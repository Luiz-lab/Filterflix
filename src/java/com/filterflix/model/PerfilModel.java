package java.com.filterflix.model;

public class PerfilModel {
    private String nome;
    private boolean infantil;

    public PerfilModel(String nome, boolean infantil) {
        this.nome = nome;
        this.infantil = infantil;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isInfantil() {
        return infantil;
    }

    public void setInfantil(boolean infantil) {
        this.infantil = infantil;
    }
}
