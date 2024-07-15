package java.com.filterflix.model;

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
    private String capa; // String ASCII pra capa

    public MidiaModel(String titulo, String genero, double avaliacao, String classificacao, LocalDate dataLancamento,
                      String sinopse, int duracao, String diretor, String capa) {
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }

    public abstract void exibirDetalhes();
}