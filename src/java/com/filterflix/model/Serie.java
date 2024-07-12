package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Serie extends Midia{

    private ArrayList<Video> episodios;
    private int contEpisodio = 0;

    public Serie(String nome, ArrayList<Genero> generos, double avaliacao, String classificacao, String diretor, LocalDate lancamento, ArrayList<Video> episodios) {
        super(nome, generos, avaliacao, classificacao, diretor, lancamento);

        this.episodios = episodios;
    }

    public void escolherEpisodio(int numEpisodio) {
        this.contEpisodio = numEpisodio;
        assistir();
    }

    @Override
    public void assistir() {
        episodios.get(contEpisodio).rodar();
        contEpisodio++;
    }
}
