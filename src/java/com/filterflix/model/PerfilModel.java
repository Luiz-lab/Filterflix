package java.com.filterflix.model;

import java.util.HashMap;
import java.util.Map;

public class PerfilModel {
    private String nome;
    private boolean infantil;
    private Map<MidiaModel, Integer> avaliacoes; // avaliações de cada perfil

    public PerfilModel(String nome, boolean infantil) {
        this.nome = nome;
        this.infantil = infantil;
        this.avaliacoes = new HashMap<>();
    }

    // Getters e setters

    public String getNome() {
        return nome;
    }

    public boolean isInfantil() {
        return infantil;
    }

    public Map<MidiaModel, Integer> getAvaliacoes() {
        return avaliacoes;
    }

    public void avaliarMidia(MidiaModel midia, int nota) {
        midia.avaliar(nota);
        avaliacoes.put(midia, nota);
    }
}