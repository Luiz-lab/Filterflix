package java.com.filterflix.model;

import java.util.ArrayList;

public class Perfil {
    private ArrayList<Midia> assistidos;
    private Catalogo catalogo;
    private boolean isInfantil;

    public Perfil(Catalogo catalogo, boolean isInfantil) {
        this.assistidos = new ArrayList<>();
        this.catalogo = catalogo;
        this.isInfantil = isInfantil;
    }

    public ArrayList<Midia> getAssistidos() {
        return assistidos;
    }

    public void adicionarMidiaAssistida(Midia midia) {
        this.assistidos.add(midia);
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public boolean isInfantil() {
        return isInfantil;
    }

    public void setInfantil(boolean isInfantil) {
        this.isInfantil = isInfantil;
    }
}
