package com.filterflix.system;

import com.filterflix.model.*;

import com.filterflix.service.MidiaService;
import com.filterflix.service.UsuarioService;
import java.util.Scanner;
import java.util.List;

public class Menu {
    private UsuarioService usuarioService;
    private MidiaService midiaService;
    private Scanner scanner;

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
    }

    private void mostrarMenuCatalogo() {
        System.out.println("____________________________________________________________________________________________");
        System.out.println("\nBem-vindo à Filterflix!\n");

        List<FilmeModel> filmes = midiaService.listarFilmes();
        List<SerieModel> series = midiaService.listarSeries();

        System.out.println("Filmes:");
        for (int i = 0; i < filmes.size(); i++) {
            System.out.println(filmes.get(i).getCapa());
            System.out.println(filmes.get(i).getTitulo());
        }

        System.out.println("\nSéries:");
        for (int i = 0; i < series.size(); i++) {
            System.out.println(series.get(i).getCapa());
            System.out.println(series.get(i).getTitulo());
        }

        System.out.println("____________________________________________________________________________________________");

        while (true) {
            System.out.println("\nEscolha uma mídia para detalhes (ou 0 para sair): ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha == 0) {
                System.out.println("\nSaindo do catálogo...");
                return;
            }

            if (escolha > 0 && escolha <= filmes.size()) {
                detalharMidia(filmes.get(escolha - 1));
            } else if (escolha > filmes.size() && escolha <= filmes.size() + series.size()) {
                detalharMidia(series.get(escolha - filmes.size() - 1));
            } else {
                System.out.println("Opção inválida.");
            }
        }
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
                avaliarMidia(midia);
                break;
            case 3:
                reproduzirMidia(midia);
                break;
            case 0:
                System.out.println("Voltando ao catálogo inicial...");
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    private void salvarNaLista(MidiaModel midia) {
        UsuarioModel usuario = usuarioService.getUsuarioLogado();
        if (usuario != null) {
            PerfilModel perfilAtivo = usuario.getPerfilAtivo();
            if (perfilAtivo != null) {
                perfilAtivo.adicionarFavorito(midia);  // Alterado para adicionarFavorito em vez de salvarNaLista
                usuarioService.atualizarUsuario(usuario);
                System.out.println("Mídia salva na lista de favoritos.");
            } else {
                System.out.println("Nenhum perfil ativo encontrado.");
            }
        } else {
            System.out.println("Nenhum usuário logado.");
        }
    }

    private void avaliarMidia(MidiaModel midia) {
        System.out.print("Digite a nova avaliação (de 1 a 10): ");
        int nota = scanner.nextInt();
        scanner.nextLine();

        UsuarioModel usuario = usuarioService.getUsuarioLogado();
        if (usuario != null) {
            PerfilModel perfilAtivo = usuario.getPerfilAtivo();
            if (perfilAtivo != null) {
                perfilAtivo.avaliarMidia(midia, nota);
                usuarioService.atualizarUsuario(usuario);
            } else {
                System.out.println("Nenhum perfil ativo encontrado.");
            }
        } else {
            System.out.println("Nenhum usuário logado.");
        }
    }

    private void reproduzirMidia(MidiaModel midia) {
        System.out.println("Reproduzindo " + midia.getTitulo() + "...");
        // Lógica de reprodução
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
        PerfilModel perfilAtivo = usuario.getPerfilAtivo();
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
        // Lógica para mostrar filmes assistidos
        System.out.println("Filmes Assistidos:");
        // Implemente conforme necessário
    }

    private void mostrarFilmesAvaliados(UsuarioModel usuario) {
        // Lógica para mostrar filmes avaliados
        System.out.println("Filmes Avaliados:");
        // Implemente conforme necessário
    }
}