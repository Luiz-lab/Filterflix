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
        filmes.add(new FilmeModel("O Senhor dos Anéis: A Sociedade do Anel", "Fantasia", 9.0, "12", null, "Um hobbit e seus amigos partem em uma jornada para destruir um anel mágico.", 178, "Peter Jackson", "🔮🧙‍♂️"));
        filmes.add(new FilmeModel("O Senhor dos Anéis: As Duas Torres", "Fantasia", 8.7, "12", null, "A Irmandade é separada enquanto enfrenta novos desafios e inimigos.", 179, "Peter Jackson", "🔮🧙‍♂️"));
        filmes.add(new FilmeModel("O Senhor dos Anéis: O Retorno do Rei", "Fantasia", 8.9, "12", null, "A batalha final pela Terra-média começa, enquanto Frodo e Sam se aproximam do Monte da Perdição.", 201, "Peter Jackson", "🔮🧙‍♂️"));
        filmes.add(new FilmeModel("O Hobbit", "Fantasia", 7.8, "12", null, "Um hobbit é recrutado por um mago para ajudar um grupo de anões a recuperar sua montanha e tesouro do dragão Smaug.", 169, "Peter Jackson", "🧙‍♂️🐤"));
        series.add(new SerieModel("Stranger Things", "Ficção Científica", 8.8, "16", null, "Crianças enfrentam eventos sobrenaturais em uma pequena cidade.", 25, "Irmãos Duffer", "🤓🌌",4));
        series.add(new SerieModel("Breaking Bad", "Drama", 9.5, "18", null, "Um professor de química com câncer começa a fabricar metanfetamina para sustentar sua família.", 62, "Vince Gilligan", "👩‍🎓💨",5));
        series.add(new SerieModel("The Witcher", "Fantasia", 8.2, "18", null, "Um caçador de monstros luta para encontrar seu lugar em um mundo onde as pessoas são frequentemente mais perversas que as bestas.", 24, "Lauren Schmidt Hissrich", " 🧝‍♂️🗡️ ",3));
        series.add(new SerieModel("Rick and Morty", "Ficção Científica", 9.2, "16", null, "Um cientista louco e seu neto vivem aventuras interdimensionais.", 41, "Dan Harmon", " 🎓👽 ",100));
    }

    public abstract void salvarMidia(MidiaModel midia);

    public abstract List<MidiaModel> listarMidias();
}