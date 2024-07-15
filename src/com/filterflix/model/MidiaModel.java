package com.filterflix.model;

import java.time.LocalDate;

public abstract class MidiaModel {
    private String titulo;
    private String genero;
    private double avaliacao;
    private String classificacao;
    private LocalDate dataLancamento;
    private String sinopse;
    private int duracao;
    private String diretor;
    private String capa;

    public MidiaModel(String titulo, String genero, double avaliacao, String classificacao,
                      LocalDate dataLancamento, String sinopse, int duracao, String diretor, String capa) {
        this.titulo = titulo;
        this.genero = genero;
        this.avaliacao = avaliacao;
        this.classificacao = classificacao;
        this.dataLancamento = dataLancamento;
        this.sinopse = sinopse;
        this.duracao = duracao;
        this.diretor = diretor;
        this.capa = capa;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }


    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public String getSinopse() {
        return sinopse;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getDiretor() {
        return diretor;
    }

    public String getCapa() {
        return capa;
    }

    public abstract void exibirDetalhes();
}