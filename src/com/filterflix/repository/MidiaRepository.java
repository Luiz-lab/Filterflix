package com.filterflix.repository;

import com.filterflix.model.FilmeModel;
import com.filterflix.model.MidiaModel;
import com.filterflix.model.SerieModel;

import java.util.ArrayList;
import java.util.List;

public abstract class MidiaRepository {
    private List<FilmeModel> filmes;
    private List<SerieModel> series;

    public MidiaRepository() {
        this.filmes = new ArrayList<>();
        this.series = new ArrayList<>();
        inicializarExemplos();
    }

    public List<FilmeModel> listarFilmes() {
        return new ArrayList<>(filmes);
    }

    public List<SerieModel> listarSeries() {
        return new ArrayList<>(series);
    }

    public void adicionarMidia(FilmeModel filme) {
        filmes.add(filme);
    }

    public void adicionarMidia(SerieModel serie) {
        series.add(serie);
    }

    private void inicializarExemplos() {

        filmes.add(new FilmeModel("O Senhor dos Anéis: A Sociedade do Anel", "Fantasia", 9.0, "12", null, "Um hobbit e seus amigos partem em uma jornada para destruir um anel mágico.", 178, "Peter Jackson", "ASCII art..."));
        filmes.add(new FilmeModel("O Senhor dos Anéis: As Duas Torres", "Fantasia", 9.0, "12", null, "Os membros da Irmandade são dispersos, mas seguem lutando contra o mal.", 179, "Peter Jackson", "ASCII art..."));
        filmes.add(new FilmeModel("O Senhor dos Anéis: O Retorno do Rei", "Fantasia", 9.0, "12", null, "A batalha final pelo destino da Terra Média começa.", 201, "Peter Jackson", "ASCII art..."));
        filmes.add(new FilmeModel("O Hobbit", "Fantasia", 9.0, "12", null, "Lá e de volta outra vez", 201, "Peter Jackson", "ASCII art..."));

        series.add(new SerieModel("Stranger Things", "Ficção Científica", 8.5, "16", null, "Crianças investigam o desaparecimento de um amigo e encontram um mundo sombrio.", 60, "Irmãos Duffer", "ASCII art...", 4));
        series.add(new SerieModel("Breaking Bad", "Drama", 9.5, "18", null, "Um professor de química começa a fabricar metanfetamina.", 47, "Vince Gilligan", "ASCII art...", 5));
        series.add(new SerieModel("The Witcher", "Fantasia", 8.2, "16", null, "Um caçador de monstros luta para encontrar seu lugar em um mundo onde as pessoas são mais perversas que as bestas.", 60, "Lauren Schmidt Hissrich", "ASCII art...", 2));
        series.add(new SerieModel("Rick and Morty", "Comédia/Sci-Fi", 9.0, "16", null, "Um cientista maluco e seu neto em aventuras pelo multiverso", 22, "John Rice", "ASCII Art...", 100));
    }

    public abstract void salvarMidia(MidiaModel midia);

    public abstract List<MidiaModel> listarMidias();
}