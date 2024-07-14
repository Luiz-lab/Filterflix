package java.com.filterflix.system;

import java.com.filterflix.model.FilmeModel;
import java.com.filterflix.model.MidiaModel;
import java.com.filterflix.model.SerieModel;
import java.com.filterflix.service.MidiaService;
import java.com.filterflix.service.UsuarioService;
import java.util.List;
import java.util.Scanner;


public class Menu {
    private UsuarioService usuarioService;
    private MidiaService midiaService;
    private Scanner scanner;

    public Menu(UsuarioService usuarioService, MidiaService midiaService) {
        this.usuarioService = usuarioService;
        this.midiaService = midiaService;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("Bem-vindo ao catálogo de filmes!");
        while (true) {
            System.out.println("1. Registrar");
            System.out.println("2. Login");
            System.out.println("3. Sair");
            int escolha = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            switch (escolha) {
                case 1:
                    registrar();
                    break;
                case 2:
                    if (login()) {
                        menuPrincipal();
                    }
                    break;
                case 3:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Escolha inválida.");
            }
        }
    }

    private void registrar() {
        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();
        usuarioService.registrarUsuario(email, senha);
        System.out.println("Usuário registrado com sucesso.");
    }

    private boolean login() {
        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();
        if (usuarioService.autenticar(email, senha)) {
            System.out.println("Login bem-sucedido.");
            return true;
        } else {
            System.out.println("Email ou senha incorretos.");
            return false;
        }
    }

    private void menuPrincipal() {
        while (true) {
            System.out.println("1. Adicionar Filme");
            System.out.println("2. Adicionar Série");
            System.out.println("3. Listar Mídias");
            System.out.println("4. Logout");
            int escolha = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            switch (escolha) {
                case 1:
                    adicionarFilme();
                    break;
                case 2:
                    adicionarSerie();
                    break;
                case 3:
                    listarMidias();
                    break;
                case 4:
                    System.out.println("Logout bem-sucedido.");
                    return;
                default:
                    System.out.println("Escolha inválida.");
            }
        }
    }

    private void adicionarFilme() {
        FilmeModel filme = new FilmeModel();
        System.out.print("Título: ");
        filme.setTitulo(scanner.nextLine());
        System.out.print("Duração: ");
        filme.setDuracao(scanner.nextInt());
        scanner.nextLine();  // Consumir nova linha
        System.out.print("Classificação: ");
        filme.setClassificacao(scanner.nextLine());
        System.out.print("Avaliação: ");
        filme.setAvaliacao(scanner.nextDouble());
        scanner.nextLine();  // Consumir nova linha
        System.out.print("Sinopse: ");
        filme.setSinopse(scanner.nextLine());
        System.out.print("Gênero: ");
        filme.setGenero(scanner.nextLine());

        midiaService.adicionarMidia(filme);
        System.out.println("Filme adicionado com sucesso.");
    }

    private void adicionarSerie() {
        SerieModel serie = new SerieModel();
        System.out.print("Título: ");
        serie.setTitulo(scanner.nextLine());
        System.out.print("Duração: ");
        serie.setDuracao(scanner.nextInt());
        scanner.nextLine();  // Consumir nova linha
        System.out.print("Classificação: ");
        serie.setClassificacao(scanner.nextLine());
        System.out.print("Avaliação: ");
        serie.setAvaliacao(scanner.nextDouble());
        scanner.nextLine();  // Consumir nova linha
        System.out.print("Sinopse: ");
        serie.setSinopse(scanner.nextLine());
        System.out.print("Gênero: ");
        serie.setGenero(scanner.nextLine());
        System.out.print("Número de Episódios: ");
        serie.setNumeroDeEpisodios(scanner.nextInt());
        scanner.nextLine();  // Consumir nova linha

        midiaService.adicionarMidia(serie);
        System.out.println("Série adicionada com sucesso.");
    }

    private void listarMidias() {
        List<MidiaModel> midias = midiaService.listarMidias();
        for (MidiaModel midia : midias) {
            System.out.println("Título: " + midia.getTitulo());
            System.out.println("Duração: " + midia.getDuracao());
            System.out.println("Classificação: " + midia.getClassificacao());
            System.out.println("Avaliação: " + midia.getAvaliacao());
            System.out.println("Sinopse: " + midia.getSinopse());
            System.out.println("Gênero: " + midia.getGenero());
        }
    }
}
