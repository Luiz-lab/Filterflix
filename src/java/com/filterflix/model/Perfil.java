package java.com.filterflix.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Perfil<T extends Midia> {
    private List<T> assistidos;
    private Catalogo catalogo;
    private boolean isInfantil;

    public Perfil(Catalogo catalogo, boolean isInfantil) {
        this.assistidos = new ArrayList<>();
        this.catalogo = catalogo;
        this.isInfantil = isInfantil;
    }

    public List<T> getAssistidos() {
        return assistidos;
    }

    public void adicionarMidiaAssistida(T midia) {
        this.assistidos.add(midia);
    }

    public void removerMidiaAssistida(T midia) {
        this.assistidos.remove(midia);
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

    public List<T> buscarMidiasGenero(Genero genero) {
        return assistidos.stream()
                .filter(midia -> midia.getGeneros().contains(genero))
                .collect(Collectors.toList());
    }

    public List<T> buscarMidiasAvaliacao(double avaliacaoMinima) {
        return assistidos.stream()
                .filter(midia -> midia.getAvaliacao() >= avaliacaoMinima)
                .collect(Collectors.toList());
    }
}
