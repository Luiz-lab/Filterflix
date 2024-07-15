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
        inicializarExemplos(); // Método opcional para inicializar com alguns exemplos
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
        // Exemplos de filmes e séries para inicializar o repositório (opcional)
        filmes.add(new FilmeModel("O Senhor dos Anéis", "Fantasia", 9.0, "Livre", null, "Sinopse...", 180, "Diretor", "ASCII art..."));
        series.add(new SerieModel("Stranger Things", "Ficção Científica", 8.5, "16", null, "Sinopse...", 60, "Irmãos Duffer", "ASCII art...", 3));
    }

    public abstract void salvarMidia(MidiaModel midia);

    public abstract List<MidiaModel> listarMidias();
}