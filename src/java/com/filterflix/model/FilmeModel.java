package java.com.filterflix.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class FilmeModel extends MidiaModel{
    private VideoModel video;

    public FilmeModel(String nome, ArrayList<GeneroModel> generos, double avaliacao, String classificacao, String diretor, LocalDate lancamento, VideoModel video) {
        super(nome, generos, avaliacao, classificacao, diretor, lancamento);
        this.video = video;
    }

    @Override
    public void assistir() {
        video.rodar();
    }
}
