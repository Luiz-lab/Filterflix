package java.com.filterflix.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class SerieModel extends MidiaModel{

    private ArrayList<VideoModel> episodios;
    private int contEpisodio = 0;

    public SerieModel(String nome, ArrayList<GeneroModel> generos, double avaliacao, String classificacao, String diretor, LocalDate lancamento, ArrayList<VideoModel> episodios) {
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
