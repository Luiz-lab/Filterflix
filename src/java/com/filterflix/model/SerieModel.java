package java.com.filterflix.model;

import java.time.LocalDate;

public class SerieModel extends MidiaModel {
        private int numeroDeEpisodios;

    public SerieModel(String titulo, String genero, double avaliacao, String classificacao, LocalDate dataLancamento,
                      String sinopse, int duracao, String diretor, String capa, int numeroDeEpisodios) {
        super(titulo, genero, avaliacao, classificacao, dataLancamento, sinopse, duracao, diretor, capa);
        this.numeroDeEpisodios = numeroDeEpisodios;
    }

    public int getNumeroDeEpisodios() {
        return numeroDeEpisodios;
    }

    public void setNumeroDeEpisodios(int numeroDeEpisodios) {
        this.numeroDeEpisodios = numeroDeEpisodios;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Título: " + getTitulo());
        System.out.println("Gênero: " + getGenero());
        System.out.println("Avaliação: " + getAvaliacao());
        System.out.println("Classificação: " + getClassificacao());
        System.out.println("Data de Lançamento: " + getDataLancamento());
        System.out.println("Sinopse: " + getSinopse());
        System.out.println("Duração: " + getDuracao() + " minutos");
        System.out.println("Diretor: " + getDiretor());
        System.out.println("Número de Episódios: " + getNumeroDeEpisodios());
        System.out.println("Capa: \n" + getCapa());
    }
}