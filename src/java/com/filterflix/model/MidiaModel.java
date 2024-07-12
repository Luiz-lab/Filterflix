package java.com.filterflix.model;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class MidiaModel {
    private String nome;
    private ArrayList<GeneroModel> generos;
    private double avaliacao;
    private String classificacao;
    private String diretor;
    private LocalDate lancamento;

    public MidiaModel(String nome, ArrayList<GeneroModel> generos, double avaliacao, String classificacao, String diretor, LocalDate lancamento) {
        this.nome = nome;
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

    public double getAvaliacao() {
        return avaliacao;
    }
}
