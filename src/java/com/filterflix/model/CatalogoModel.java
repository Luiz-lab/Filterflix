package java.com.filterflix.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CatalogoModel {
    private ArrayList<MidiaModel> midias;
    private PerfilModel perfilAtivo;

    public CatalogoModel(PerfilModel perfilAtivo) {
        this.midias = new ArrayList<>();
        this.perfilAtivo = perfilAtivo;
    }

    public ArrayList<SerieModel> getSeries() {
        return midias.stream()
                .filter(m -> m instanceof SerieModel)
                .map(m -> (SerieModel) m)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<FilmeModel> getFilmes() {
        return midias.stream()
                .filter(m -> m instanceof FilmeModel)
                .map(m -> (FilmeModel) m)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<FilmeModel> getFilmesGenero(String genero) {
        return getMidiaGenero(genero).stream()
                .filter(m -> m instanceof FilmeModel)
                .map(m -> (FilmeModel) m)
                .collect(Collectors.toList());
    }

    public List<SerieModel> getSeriesGenero(String genero) {
        return getMidiaGenero(genero).stream()
                .filter(m -> m instanceof SerieModel)
                .map(m -> (SerieModel) m)
                .collect(Collectors.toList());
    }

    public List<MidiaModel> getMidiaGenero(String genero) {
        return midias.stream()
                .filter(m -> m.getGenero().equalsIgnoreCase(genero))
                .collect(Collectors.toList());
    }

    public void inserirMidia(MidiaModel midia) {
        midias.add(midia);
    }

    public void removerMidia(MidiaModel midia) {
        midias.remove(midia);
    }

    public void listarMidiasPorGenero(String genero) {
        List<MidiaModel> midiasGenero = getMidiaGenero(genero);
        if (midiasGenero.isEmpty()) {
            System.out.println("Nenhuma mídia encontrada para o gênero " + genero + ".");
            return;
        }

        System.out.println("Listando " + genero + ":");
        for (MidiaModel midia : midiasGenero) {
            System.out.println(midia.getCapa());
            System.out.println(midia.getTitulo());
            System.out.println();
        }
    }

    public void exibirDetalhesMidia(MidiaModel midia) {
        System.out.println(midia.getCapa());
        System.out.println("Título: " + midia.getTitulo());
        System.out.println("Gênero: " + midia.getGenero());
        System.out.println("Avaliação: " + midia.getAvaliacao());
        System.out.println("Classificação: " + midia.getClassificacao());
        System.out.println("Data de Lançamento: " + midia.getDataLancamento());
        System.out.println("Sinopse: " + midia.getSinopse());
        System.out.println("Duração: " + midia.getDuracao());
        System.out.println("Diretor: " + midia.getDiretor());
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Opções:");
        System.out.println("1. Reproduzir");
        System.out.println("2. Adicionar à Lista");
        System.out.println("3. Avaliar");
        System.out.print("Escolha uma opção: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        switch (escolha) {
            case 1:
                System.out.println("Reproduzindo " + midia.getTitulo() + "...");
                break;
            case 2:
                System.out.println(midia.getTitulo() + " adicionado à lista.");
                break;
            case 3:
                System.out.print("Digite uma nota de 1 a 10: ");
                int nota = scanner.nextInt();
                perfilAtivo.avaliarMidia(midia, nota);
                System.out.println("Você avaliou " + midia.getTitulo() + " com a nota " + nota + ".");
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    public void listarCatalogo() {
        System.out.println("Catálogo de Filmes e Séries:");
        System.out.println("1. Listar Filmes por Gênero");
        System.out.println("2. Listar Séries por Gênero");
        System.out.print("Escolha uma opção: ");
        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();
        scanner.nextLine();

        switch (escolha) {
            case 1:
                System.out.print("Digite o gênero: ");
                String generoFilmes = scanner.nextLine();
                listarMidiasPorGenero(generoFilmes);
                break;
            case 2:
                System.out.print("Digite o gênero: ");
                String generoSeries = scanner.nextLine();
                listarMidiasPorGenero(generoSeries);
                break;
            default:
                System.out.println("Opção inválida.");
        }

        System.out.print("Digite o ID da mídia para ver detalhes: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (id >= 0 && id < midias.size()) {
            exibirDetalhesMidia(midias.get(id));
        } else {
            System.out.println("ID inválido.");
        }
    }
}