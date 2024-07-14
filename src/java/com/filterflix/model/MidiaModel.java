package java.com.filterflix.model;


import java.time.LocalDate;
import java.util.ArrayList;
@SuppressWarnings("ALL")

public abstract class MidiaModel {
    private String titulo;
    private String genero;
    private double avaliacao;
    private String classificacao;
    private String diretor;
    private LocalDate lancamento;
    private String sinopse;
    private int duracao;

    public MidiaModel(String titulo, ArrayList<GeneroModel> generos, double avaliacao, String classificacao, String diretor, LocalDate lancamento) {
        this.titulo = titulo;
        this.genero = String.valueOf(generos);
        this.avaliacao = avaliacao;
        this.classificacao = classificacao;
        this.diretor = diretor;
        this.lancamento = lancamento;
    }

    public MidiaModel() {

    }

    public abstract void assistir();

    public String getGeneros() {
        return genero;
    }

    public void imprimirMidia() {
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

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public LocalDate getLancamento() {
        return lancamento;
    }

    public void setLancamento(LocalDate lancamento) {
        this.lancamento = lancamento;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public double getDuracao() {
        return duracao;
    }

}
