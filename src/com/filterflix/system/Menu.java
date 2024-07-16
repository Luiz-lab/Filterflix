package com.filterflix.system;

import com.filterflix.model.*;

import com.filterflix.service.MidiaService;
import com.filterflix.service.UsuarioService;

import java.util.Map;
import java.util.Scanner;
import java.util.List;

public class Menu {
    private UsuarioService usuarioService;
    private MidiaService midiaService;
    private Scanner scanner;
    private PerfilModel perfilAtivo;
    public Menu(UsuarioService usuarioService, MidiaService midiaService) {
        this.usuarioService = usuarioService;
        this.midiaService = midiaService;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenuInicial() {
        while (true) {
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║           Acesse a Filterflix!         ║");
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║   \033[1m1. Entrar\033[0m                            ║");
            System.out.println("║   \033[1m2. Criar Conta\033[0m                       ║");
            System.out.println("╚════════════════════════════════════════╝");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    if (entrar()) {
                        mostrarMenuCatalogo();
                    }
                    break;
                case 2:
                    criarConta();
                    break;
                default:
                    System.out.println("Escolha inválida.");
            }
        }
    }

    private void criarConta() {
        System.out.print("\nDigite seu e-mail: ");
        String email = scanner.nextLine();

        if (!usuarioService.isValidEmail(email)) {
            System.out.println("Ops.. Isso não parece um e-mail! Informe um e-mail válido.");
            criarConta();
            return;
        }

        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();
        usuarioService.registrarUsuario(email, senha);
        System.out.println();
        System.out.println("Conta criada com sucesso.");
    }

    private boolean entrar() {
        System.out.print("Digite seu e-mail: ");
        String email = scanner.nextLine();

        if (!usuarioService.isValidEmail(email)) {
            System.out.println("Ops.. Isso não parece um e-mail! Informe um e-mail válido.");
            return false;
        }

        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();
        if (usuarioService.autenticar(email, senha)) {
            System.out.println();
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║    \033[1mLogin bem-sucedido.\033[0m                 ║");
            System.out.println("╚════════════════════════════════════════╝");

            UsuarioModel usuario = usuarioService.getUsuario(email);
            if (usuario != null && usuario.getPerfis().isEmpty()) {
                criarPerfil(usuario);
            }

            perfilAtivo = usuario.getPerfis().isEmpty() ? null : usuario.getPerfis().get(0);

            return true;
        } else {
            System.out.println("Conta não encontrada ou e-mail e senha incorretos.");
            return false;
        }
    }

    private void criarPerfil(UsuarioModel usuario) {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║    Para começarmos, crie um Perfil:    ║");
        System.out.println("╚════════════════════════════════════════╝");

        System.out.print("\nDigite o nome do perfil: ");
        String nome = scanner.nextLine();

        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║            Tipo de Perfil:             ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║   1. \033[1mPerfil Adulto\033[0m                     ║");
        System.out.println("║   2. \033[1mPerfil Infantil\033[0m                   ║");
        System.out.println("╚════════════════════════════════════════╝");

        System.out.print("Escolha uma opção: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        boolean infantil = escolha == 2;

        usuarioService.criarPerfil(usuario.getEmail(), nome, infantil);
        System.out.println();
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║        \033[1mPerfil criado com sucesso.\033[0m      ║");
        System.out.println("╚════════════════════════════════════════╝");

        perfilAtivo = usuarioService.getUsuario(usuario.getEmail()).getPerfis().get(0);
    }

    private void mostrarMenuCatalogo() {
        System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                     \033[1mBem-vindo à Filterflix!\033[0m                                             ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════╝");

        System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                Filmes                                                   ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════╝");

        List<FilmeModel> filmes = midiaService.listarFilmes();
        List<SerieModel> series = midiaService.listarSeries();

        exibirMidias(filmes);

        System.out.println();
        System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                   Séries                                                ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════╝");

        exibirMidias(series);

        System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                      Digite o número da mídia, * para o menu perfil, ou 0 para sair:                    ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════╝");

        while (true) {
            try{
                String escolha = scanner.nextLine();

                if (escolha.equals("0")) {
                    System.out.println("Saindo do catálogo...");
                    break;
                } else if (escolha.equals("*")) {
                    mostrarMenuPerfil();
                } else {
                    int escolhaInt = Integer.parseInt(escolha);
                    if (escolhaInt > 0 && escolhaInt <= filmes.size() + series.size()) {
                        if (escolhaInt <= filmes.size()) {
                            detalharMidia(filmes.get(escolhaInt - 1));
                        } else {
                            detalharMidia(series.get(escolhaInt - filmes.size() - 1));
                        }
                    } else {
                        System.out.println("Opção inválida. Tente novamente.");
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Entrada inválida. Por favor, digite um número válido.");
            }catch (IndexOutOfBoundsException e) {
                System.out.println("Número fora do intervalo. Por favor, escolha um número dentro do intervalo válido.");
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            }
        }
    }

    private <T extends MidiaModel> void exibirMidias(List<T> midias) {
        for (int i = 0; i < midias.size(); i += 2) {
            T midia1 = midias.get(i);
            T midia2 = (i + 1 < midias.size()) ? midias.get(i + 1) : null;

            String capa1 = centralizarTexto(midia1.getCapa(), 50);
            String titulo1 = centralizarTexto(midia1.getTitulo(), 50);

            String capa2 = (midia2 != null) ? centralizarTexto(midia2.getCapa(), 50) : centralizarTexto("", 50);
            String titulo2 = (midia2 != null) ? centralizarTexto(midia2.getTitulo(), 50) : centralizarTexto("", 50);

            System.out.println("╔════════════════════════════════════════════════════╦════════════════════════════════════════════════════╗");
            System.out.printf(" %-52s  %-53s \n", capa1, capa2);
            System.out.println("╠════════════════════════════════════════════════════╬════════════════════════════════════════════════════╣");
            System.out.printf(" %-49s  %-50s \n", titulo1, titulo2);
            System.out.println("╚════════════════════════════════════════════════════╩════════════════════════════════════════════════════╝");
        }
    }

    private String centralizarTexto(String texto, int largura) {
        int tamanhoTexto = texto.length();
        int espacosPadding = (largura - tamanhoTexto) / 2;
        StringBuilder padding = new StringBuilder();

        for (int i = 0; i < espacosPadding; i++) {
            padding.append(" ");
        }

        if (tamanhoTexto % 2 != 0) {
            padding.append(" ");
        }

        return padding.toString() + texto + padding.toString();
    }

    private void detalharMidia(MidiaModel midia) {
        System.out.println("____________________________________________________________________________________________");
        System.out.println(midia.getCapa());
        System.out.println(midia.getTitulo());
        System.out.println(midia.getDiretor() + "     Avaliação: " + midia.getAvaliacao() + "     Duração: " + midia.getDuracao());
        System.out.println(midia.getSinopse());
        System.out.println("1. Salvar na Lista");
        System.out.println("2. Avaliar");
        System.out.println("3. Reproduzir");
        System.out.println("0. Voltar ao Catálogo Inicial");

        int escolha = scanner.nextInt();
        scanner.nextLine();

        switch (escolha) {
            case 1:
                salvarNaLista(midia);
                break;
            case 2:
                avaliarMidia(midia, scanner);
                break;
            case 3:
                reproduzirMidia(midia);
                break;
            case 0:
                System.out.println("Voltando ao catálogo inicial...");
                mostrarMenuCatalogo();
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    private void salvarNaLista(MidiaModel midia) {
        if (perfilAtivo != null) {
            perfilAtivo.adicionarFavorito(midia);
            System.out.println("Mídia salva na lista de favoritos.");
        } else {
            System.out.println("Nenhum perfil ativo encontrado.");
        }
    }

    private void avaliarMidia(MidiaModel midia, Scanner scanner) {
        if (perfilAtivo != null) {
            System.out.print("Digite a nova avaliação (de 1 a 10): ");
            int nota = this.scanner.nextInt();
            this.scanner.nextLine();
            perfilAtivo.avaliarMidia(midia, nota);
            System.out.println("Avaliação salva.");
        } else {
            System.out.println("Nenhum perfil ativo encontrado.");
        }
    }

    private void reproduzirMidia(MidiaModel midia) {
        System.out.println("Reproduzindo " + midia.getTitulo() + "...");
        String texto = midia.reproduzirInicio();
        String amarelo = "\033[33m";
        String reset = "\033[0m";

        for (char c : texto.toCharArray()) {
            System.out.print(amarelo + c + reset);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println("The End");
        perfilAtivo.adicionarFilmesAssistidos(midia);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Avaliar");
            System.out.println("2. Retornar ao Catálogo");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                avaliarMidia(midia, scanner);
                mostrarMenuCatalogo();
                break;
            } else if (opcao == 2) {
                System.out.println("Retornando ao catálogo...");
                mostrarMenuCatalogo();
                break;
            } else {
                System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    public void mostrarMenuPerfil() {
        UsuarioModel usuario = usuarioService.getUsuarioLogado();
        if (usuario != null) {
            System.out.println("Bem-vindo ao seu perfil, " + usuario.getEmail() + "!");
            System.out.println("1. Minha Lista");
            System.out.println("2. Filmes Assistidos");
            System.out.println("3. Filmes Avaliados");
            System.out.println("4. Sair do Perfil");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    mostrarMinhaLista(usuario);
                    break;
                case 2:
                    mostrarFilmesAssistidos(usuario);
                    break;
                case 3:
                    mostrarFilmesAvaliados(usuario);
                    break;
                case 4:
                    System.out.println("Saindo do perfil...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } else {
            System.out.println("Nenhum usuário logado.");
        }
    }

    private void mostrarMinhaLista(UsuarioModel usuario) {
        if (perfilAtivo != null) {
            List<MidiaModel> favoritos = perfilAtivo.getFavoritos();
            if (!favoritos.isEmpty()) {
                System.out.println("Minha Lista de Favoritos:");
                for (int i = 0; i < favoritos.size(); i++) {
                    System.out.println((i + 1) + ". " + favoritos.get(i).getTitulo());
                }
            } else {
                System.out.println("Nenhum favorito salvo.");
            }
        } else {
            System.out.println("Nenhum perfil ativo encontrado.");
        }
    }

    private void mostrarFilmesAssistidos(UsuarioModel usuario) {
        if (perfilAtivo != null) {
            List<MidiaModel> filmesAssistidos = perfilAtivo.getFilmesAssistidos();
            if (!filmesAssistidos.isEmpty()){
                System.out.println("Filmes Assistidos: ");
                filmesAssistidos.stream()
                        .map(MidiaModel::getTitulo)
                        .forEach(titulo-> System.out.println((filmesAssistidos.indexOf(titulo) + 1) + ". " + titulo));

            }else {

                System.out.println("Nenhum filme assistido.");
            }
            System.out.println("Pressione Enter para voltar ao menu.");
            scanner.nextLine();
            mostrarMenuPerfil();
        } else {
            System.out.println("Nenhum perfil ativo encontrado.");
        }
    }

    private void mostrarFilmesAvaliados(UsuarioModel usuario) {
        if (perfilAtivo != null) {
            Map<MidiaModel, Integer> avaliacoes = perfilAtivo.getAvaliacoes();
            if (!avaliacoes.isEmpty()) {
                System.out.println("Filmes Avaliados:");
                for (Map.Entry<MidiaModel, Integer> entry : avaliacoes.entrySet()) {
                    System.out.println(entry.getKey().getTitulo() + " - Nota: " + entry.getValue());
                }
            } else {
                System.out.println("Nenhum filme avaliado.");
            }
        } else {
            System.out.println("Nenhum perfil ativo encontrado.");
        }
    }
}