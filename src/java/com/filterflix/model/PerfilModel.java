package java.com.filterflix.model;

import java.util.ArrayList;

public class PerfilModel {
    private ArrayList<MidiaModel> assistidos;
    private CatalogoModel catalogo;
    private boolean isInfantil;

    public PerfilModel(CatalogoModel catalogo, boolean isInfantil) {
        this.assistidos = new ArrayList<>();
        this.catalogo = catalogo;
        this.isInfantil = isInfantil;
    }

    public ArrayList<MidiaModel> getAssistidos() {
        return assistidos;
    }

    public void adicionarMidiaAssistida(MidiaModel midia) {
        this.assistidos.add(midia);
    }

    public CatalogoModel getCatalogo() {
        return catalogo;
    }

    public boolean isInfantil() {
        return isInfantil;
    }

    public void setInfantil(boolean isInfantil) {
        this.isInfantil = isInfantil;
    }
}
