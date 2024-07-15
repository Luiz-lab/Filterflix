package java.com.filterflix.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class FilmeModel extends MidiaModel{
    private VideoModel video;
    private int duracao;

    public FilmeModel(String nome, ArrayList<GeneroModel> generos, double avaliacao, String classificacao, String diretor, LocalDate lancamento, VideoModel video) {
        super(nome, generos, avaliacao, classificacao, diretor, lancamento);
        this.video = video;
    }

    public FilmeModel() {
        super();
    }

    @Override
    public void assistir() {
        video.rodar();
    }

    public VideoModel getVideo() {
        return video;
    }

    public void setVideo(VideoModel video) {
        this.video = video;
    }

    public int  getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}
