package com.filterflix.model;

import java.time.LocalDate;


public class FilmeModel extends MidiaModel {

    public FilmeModel(String titulo, String genero, double avaliacao, String classificacao, LocalDate dataLancamento,
                      String sinopse, int duracao, String diretor, String capa) {
        super(titulo, genero, avaliacao, classificacao, dataLancamento, sinopse, duracao, diretor, capa);
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
        System.out.println("Capa: \n" + getCapa());
    }
    @Override
    public String reproduzirInicio() {
        if (getTitulo().equals("O Senhor dos Anéis: A Sociedade do Anel")) {
            return "I amar prestar sen: han mathon ne nen, han mathon ne chae...a han noston ned wilith. O mundo está mudado: sinto-o na água, sinto-o na terra, cheiro-o no ar... Muito do que era antes está perdido, pois não há ninguém que se lembre disso.";
        } else if (getTitulo().equals("O Senhor dos Anéis: As Duas Torres")) {
            return "Gandalf: Não podes passar!\nFrodo: Gandalf!\nGandalf: Sou um servo do Fogo Secreto, portador da Chama de Anor!\nArgh! Volta para a sombra. O fogo não te vai servir de nada, Chama de Udon! NÃO PODERÁS... PASSAR!!!";
        } else if (getTitulo().equals("O Senhor dos Anéis: O Retorno do Rei")) {
            return "Deagol: Smeagol, apanhei um! Apanhei um peixe, Smeagol!\nSmeagol: Vá lá, puxa-o para dentro. Dá-nos isso, Deagol, meu amor!\nDeagol: Porquê?\nSmeagol: Porque é o meu aniversário e eu quero-o... Meu precioso!";
        } else if (getTitulo().equals("O Hobbit")) {
            return "Bilbo: Bom dia.\nGandalf: O que é que quer dizer com isso? Estás a querer desejas-me um bom dia, ou queres dizer que é um bom dia quer eu queira, quer não? Ou, talvez queiras dizer que te sentes bem esta manhã, ou está simplesmente a afirmar que esta é uma manhã para estar bem?\nBilbo: Todas ao mesmo tempo, suponho?";
        } else {
            return "";
        }
    }
}
