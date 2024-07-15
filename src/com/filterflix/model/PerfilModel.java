package com.filterflix.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PerfilModel {
    private String nome;
    private boolean infantil;
    private List<MidiaModel> favoritos;
    private Map<MidiaModel, Integer> avaliacoes;

    public PerfilModel(String nome, boolean infantil) {
        this.nome = nome;
        this.infantil = infantil;
        this.favoritos = new ArrayList<>();
        this.avaliacoes = new HashMap<>();
    }

    public void adicionarFavorito(MidiaModel midia) {
        if (!favoritos.contains(midia)) {
            favoritos.add(midia);
        }
    }

    public String getNome() {
        return nome;
    }

    public boolean isInfantil() {
        return infantil;
    }

    public List<MidiaModel> getFavoritos() {
        return favoritos;
    }

    public Map<MidiaModel, Integer> getAvaliacoes() {
        return avaliacoes;
    }

    public void avaliarMidia(MidiaModel midia, int nota) {
        if (nota < 1 || nota > 10) {
            throw new IllegalArgumentException("Nota entre 1 e 10.");
        }
        avaliacoes.put(midia, nota);
    }

    public boolean podeAcessarMidia(MidiaModel midia) {
        String classificacao = midia.getClassificacao();

        if (infantil) {
            return classificacao.equals("L") || classificacao.equals("10") || classificacao.equals("12") || classificacao.equals("14");
        }

        return true;
    }
}