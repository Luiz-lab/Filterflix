package java.com.filterflix.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class SerieModel extends MidiaModel{

    private ArrayList<VideoModel> episodios;
    private int numeroDeEpisodios = 0;
    private int duracao;

    public SerieModel(String nome, ArrayList<GeneroModel> generos, double avaliacao, String classificacao, String diretor, LocalDate lancamento, ArrayList<VideoModel> episodios) {
        super(nome, generos, avaliacao, classificacao, diretor, lancamento);

        this.episodios = episodios;
    }

    public SerieModel() {

    }

    public void escolherEpisodio(int numEpisodio) {
        this.numeroDeEpisodios = numEpisodio;
        assistir();
    }

    @Override
    public void assistir() {
        episodios.get(numeroDeEpisodios).rodar();
        numeroDeEpisodios++;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void setNumeroDeEpisodios(int i) {
    }

}
