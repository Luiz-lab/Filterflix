package com.filterflix.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class SerieModel extends MidiaModel {
    private ArrayList<VideoModel> episodios;
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

    public void escolherEpisodio(int numEpisodio) {
        this.numeroDeEpisodios = numEpisodio;
        assistir();
    }

    public void assistir() {
        episodios.get(numeroDeEpisodios).rodar();
        numeroDeEpisodios++;
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

    @Override
    public String reproduzirInicio() {
        if (getTitulo().equals("Stranger Things")) {
            return "Mike: Estão ouvindo isto? Ouçam... Algo está a chegar... Algo com sede de sangue...";
        } else if (getTitulo().equals("Breaking Bad")) {
            return "O meu nome é Walter Hartwell White. Vivo em 308 Negra Arroyo Lane, Albuquerque, Novo México, 87104. Esta é a minha confissão. Se estão a ver esta cassete, provavelmente estou morto, assassinado pelo meu cunhado Hank Schrader.";
        } else if (getTitulo().equals("The Witcher")) {
            return "Geralt: O que é que vai ser? Indica-me a casa do vereador.\nPlebeu: É ao fundo do beco, à esquerda. Não queremos os da tua laia aqui, Witcher.\nGeralt: Diz-me onde ele está e eu vou-me embora.\nPlebeu: Não és tu que dás as ordens por aqui...";
        } else if (getTitulo().equals("Rick and Morty")) {
            return "Rick: Morty, morty, você tem que vir comigo...\nMorty: O quê, Rick? O que é que se passa?\nRick: Tenho uma surpresa para ti, Morty.\nMorty: Estamos a meio da noite. Do que é que estão a falar?\nRick: Vamos, tenho uma surpresa para ti. Vamos.\nRick: Temos de ir, temos de sair daqui, vamos. Tenho uma surpresa para ti Morty.\nRick: O que achas deste... veículo voador, Morty? Construí com coisas que encontrei na garagem.\nMorty: Sim, Rick... É ótimo. É esta a surpresa?\nRick: Morty. Eu tinha que... Eu tinha que o fazer. Tive de fazer uma bomba, Morty. Eu tinha que criar uma bomba.";
        } else {
            return "";
        }
    }
}
