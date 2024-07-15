package com.filterflix.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class MidiaModel {
    private String titulo;
    private String genero;
    private double avaliacao;
    private String classificacao;
    private LocalDate dataLancamento;
    private String sinopse;
    private int duracao;
    private String diretor;
    private String capa; // String contendo a arte ASCII
    private List<Integer> avaliacoes; // Lista para armazenar notas de avaliação

    public MidiaModel(String titulo, String genero, double avaliacao, String classificacao, LocalDate dataLancamento, String sinopse, int duracao, String diretor, String capa) {
        this.titulo = titulo;
        this.genero = genero;
        this.avaliacao = avaliacao;
        this.classificacao = classificacao;
        this.dataLancamento = dataLancamento;
        this.sinopse = sinopse;
        this.duracao = duracao;
        this.diretor = diretor;
        this.capa = capa;
        this.avaliacoes = new ArrayList<>();
    }

    // Getters

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

    public List<Integer> getAvaliacoes() {
        return avaliacoes;
    }

    public void avaliar(int nota) {
        if (nota < 1 || nota > 10) {
            throw new IllegalArgumentException("A nota deve ser entre 1 e 10.");
        }
        avaliacoes.add(nota);
        recalcularAvaliacao();
    }

    private void recalcularAvaliacao() {
        if (avaliacoes.isEmpty()) {
            this.avaliacao = 0;
        } else {
            double soma = 0;
            for (int nota : avaliacoes) {
                soma += nota;
            }
            this.avaliacao = soma / avaliacoes.size();
        }
    }

    public void exibirDetalhes() {

    }
}