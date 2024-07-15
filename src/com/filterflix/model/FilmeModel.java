package com.filterflix.model;

import java.time.LocalDate;


public class FilmeModel extends MidiaModel {

    public FilmeModel(String titulo, String genero, double avaliacao, String classificacao, LocalDate dataLancamento,
                      String sinopse, int duracao, String diretor, String capa) {
        super(titulo, genero, avaliacao, classificacao, dataLancamento, sinopse, duracao, diretor, capa);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Título: " + getTitulo());
        System.out.println("Gênero: " + getGenero());
        System.out.println("Avaliação: " + getAvaliacao());
        System.out.println("Classificação: " + getClassificacao());
        System.out.println("Data de Lançamento: " + getDataLancamento());
        System.out.println("Sinopse: " + getSinopse());
        System.out.println("Duração: " + getDuracao() + " minutos");
        System.out.println("Diretor: " + getDiretor());
        System.out.println("Capa: \n" + getCapa());
    }
}