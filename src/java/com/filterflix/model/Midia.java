package model;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Midia {
    private String nome;
    private ArrayList<Genero> generos;
    private double avaliacao;
    private String classificacao;
    private String diretor;
    private LocalDate lancamento;

    public Midia(String nome, ArrayList<Genero> generos, double avaliacao, String classificacao, String diretor, LocalDate lancamento) {
        this.nome = nome;
        this.generos = generos;
        this.avaliacao = avaliacao;
        this.classificacao = classificacao;
        this.diretor = diretor;
        this.lancamento = lancamento;
    }

    public abstract void assistir();

    public ArrayList<Genero> getGeneros() {
        return generos;
    }
}
