package com.filterflix.service;

import com.filterflix.model.FilmeModel;
import com.filterflix.model.MidiaModel;
import com.filterflix.model.SerieModel;
import com.filterflix.repository.MidiaRepository;

import java.util.ArrayList;
import java.util.List;

public class MidiaService {
    private MidiaRepository midiaRepository;

    public MidiaService(MidiaRepository midiaRepository) {
        this.midiaRepository = midiaRepository;
    }

    public List<FilmeModel> listarFilmes() {
        return midiaRepository.listarFilmes();
    }

    public List<SerieModel> listarSeries() {
        return midiaRepository.listarSeries();
    }

    public ArrayList<String> listarGeneros() { return midiaRepository.listarGeneros(); }

    public ArrayList<MidiaModel> listarMidiasPorGenero(String genero) {
        return midiaRepository.listarMidiasPorGenero(genero);
    }

    public void adicionarMidia(FilmeModel filme) {
        midiaRepository.adicionarMidia(filme);
    }

    public void adicionarMidia(SerieModel serie) {
        midiaRepository.adicionarMidia(serie);
    }
}