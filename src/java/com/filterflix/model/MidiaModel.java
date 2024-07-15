package java.com.filterflix.model;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
@Getter
@Setter
@NoArgsConstructor
public abstract class MidiaModel {
    private String titulo;
    private ArrayList<GeneroModel> generos;
    private String genero;
    private double avaliacao;
    private String classificacao;
    private String diretor;
    private LocalDate lancamento;
    private String sinopse;
    private int duracao;

    public MidiaModel(String titulo, ArrayList<GeneroModel> generos, double avaliacao, String classificacao, String diretor, LocalDate lancamento) {
        this.titulo = titulo;
        this.generos = generos;
        this.avaliacao = avaliacao;
        this.classificacao = classificacao;
        this.diretor = diretor;
        this.lancamento = lancamento;
    }


    public abstract void assistir();

    public ArrayList<GeneroModel> getGeneros() {
        return generos;
    }

    public void imprimirMidia() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<GeneroModel> getGenero() {
        return generos;
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

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao){
        this.duracao = duracao;
    }

    public double getAvaliacao() {
    return  avaliacao;
    }

}
