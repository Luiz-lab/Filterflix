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

    public void imprimirMidia() {
        System.out.println(this.nome);
        System.out.print("\nGêneros: ");
        for (GeneroModel g : generos) {
            System.out.print(g.getNome()+" ");
        }
        System.out.println("Nota: "+this.avaliacao);
        System.out.println("Classificação indicativa: "+this.classificacao);
        System.out.println("Diretor: "+this.diretor);
        System.out.println("Data de lançamento: "+this.lancamento);
    }
}
