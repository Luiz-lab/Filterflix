package java.com.filterflix.system;

import java.com.filterflix.model.*;
import java.com.filterflix.service.MidiaService;
import java.com.filterflix.service.UsuarioService;
import java.time.LocalDate;
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
            System.out.println("1. Entrar");
            System.out.println("2. Criar Conta");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    if (entrar()) {
                        mostrarMenuPerfil();
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
        System.out.print("Digite seu e-mail: ");
        String email = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();
        usuarioService.registrarUsuario(email, senha);
        System.out.println("Conta criada com sucesso.");
    }

    private boolean entrar() {
        System.out.print("Digite seu e-mail: ");
        String email = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();
        if (usuarioService.autenticar(email, senha)) {
            System.out.println("Login bem-sucedido.");
            return true;
        } else {
            System.out.println("E-mail ou senha incorretos.");
            return false;
        }
    }

    private void mostrarMenuPerfil() {
        System.out.println("1. Criar Perfil");
        System.out.println("2. Selecionar Perfil");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        switch (escolha) {
            case 1:
                criarPerfil();
                break;
            case 2:
                selecionarPerfil();
                break;
            default:
                System.out.println("Escolha inválida.");
        }
    }

    private void criarPerfil() {
        System.out.print("Digite o nome do perfil: ");
        String nome = scanner.nextLine();
        System.out.print("É um perfil infantil? (s/n): ");
        boolean infantil = scanner.nextLine().equalsIgnoreCase("s");
        UsuarioModel usuario = usuarioService.obterUsuarioLogado();
        PerfilModel perfil = new PerfilModel(nome, infantil);
        usuario.adicionarPerfil(perfil);
        System.out.println("Perfil criado com sucesso.");
        mostrarMenuCatalogo(perfil);
    }

    private void selecionarPerfil() {
        UsuarioModel usuario = usuarioService.obterUsuarioLogado();
        List<PerfilModel> perfis = usuario.getPerfis();
        if (perfis.isEmpty()) {
            System.out.println("Nenhum perfil encontrado. Crie um perfil primeiro.");
            return;
        }

        System.out.println("Selecione um perfil:");
        for (int i = 0; i < perfis.size(); i++) {
            System.out.println((i + 1) + ". " + perfis.get(i).getNome());
        }
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha > 0 && escolha <= perfis.size()) {
            PerfilModel perfilSelecionado = perfis.get(escolha - 1);
            mostrarMenuCatalogo(perfilSelecionado);
        } else {
            System.out.println("Escolha inválida.");
        }
    }

    private void mostrarMenuCatalogo(PerfilModel perfil) {
        System.out.println("Bem-vindo ao catálogo, " + perfil.getNome() + "!");
        while (true) {
            System.out.println("1. Listar Mídias");
            System.out.println("2. Adicionar Mídia");
            System.out.println("3. Sair");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    listarMidias();
                    break;
                case 2:
                    adicionarMidia();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Escolha inválida.");
            }
        }
    }

    private void listarMidias() {
        List<MidiaModel> midias = midiaService.listarMidias();
        if (midias.isEmpty()) {
            System.out.println("Nenhuma mídia encontrada.");
            return;
        }

        for (MidiaModel midia : midias) {
            midia.exibirDetalhes();
            System.out.println("-----------------------------");
        }
    }

    private void adicionarMidia() {
        System.out.print("Digite o título: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite o gênero: ");
        String genero = scanner.nextLine();
        System.out.print("Digite a avaliação: ");
        double avaliacao = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Digite a classificação: ");
        String classificacao = scanner.nextLine();
        System.out.print("Digite a data de lançamento (YYYY-MM-DD): ");
        LocalDate dataLancamento = LocalDate.parse(scanner.nextLine());
        System.out.print("Digite a sinopse: ");
        String sinopse = scanner.nextLine();
        System.out.print("Digite a duração em minutos: ");
        int duracao = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o diretor: ");
        String diretor = scanner.nextLine();
        System.out.print("Digite a capa (ASCII art): ");
        String capa = scanner.nextLine();
        System.out.print("Digite o tipo de mídia (1 para Filme, 2 para Série): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        if (tipo == 1) {
            FilmeModel filme = new FilmeModel(titulo, genero, avaliacao, classificacao, dataLancamento, sinopse, duracao, diretor, capa);
            midiaService.adicionarMidia(filme);
            System.out.println("Filme adicionado com sucesso.");
        } else if (tipo == 2) {
            System.out.print("Digite o número de episódios: ");
            int numeroDeEpisodios = scanner.nextInt();
            scanner.nextLine();
            SerieModel serie = new SerieModel(titulo, genero, avaliacao, classificacao, dataLancamento, sinopse, duracao, diretor, capa, numeroDeEpisodios);
            midiaService.adicionarMidia(serie);
            System.out.println("Série adicionada com sucesso.");
        } else {
            System.out.println("Tipo de mídia inválido.");
        }
    }
}