package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Filme extends Midia{
    private Video video;

    public Filme(String nome, ArrayList<Genero> generos, double avaliacao, String classificacao, String diretor, LocalDate lancamento, Video video) {
        super(nome, generos, avaliacao, classificacao, diretor, lancamento);
        this.video = video;
    }

    @Override
    public void assistir() {
        video.rodar();
    }
}
