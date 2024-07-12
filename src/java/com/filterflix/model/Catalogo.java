package model;

import java.util.ArrayList;

public class Catalogo {
    private ArrayList<Midia> midias;

    public Catalogo(ArrayList<Midia> midias) {
        this.midias = midias;
    }

    public ArrayList<Serie> getSeries() {
        ArrayList<Serie> series = new ArrayList<>();
        for (Midia m : midias) {
            if (m instanceof Serie) {
                series.add((Serie)m);
            }
        }
        return series;
    }

    public ArrayList<Filme> getFilmes() {
        ArrayList<Filme> filmes = new ArrayList<>();
        for (Midia m: midias) {
            if (m instanceof Filme) {
                filmes.add((Filme)m);
            }
        }
        return filmes;
    }

    public ArrayList<Filme> getFilmesGenero(Genero genero) {
        ArrayList<Midia> midiasTemp = getMidiaGenero(genero);
        ArrayList<Filme> filmes = new ArrayList<>();
        for (Midia m: midiasTemp) {
            if (m instanceof Filme) {
                filmes.add((Filme)m);
            }
        }
        return filmes;
    }

    public ArrayList<Serie> getSerieGenero(Genero genero) {
        ArrayList<Midia> midiasTemp = getMidiaGenero(genero);
        ArrayList<Serie> series = new ArrayList<>();
        for (Midia m: midiasTemp) {
            if (m instanceof Serie) {
                series.add((Serie) m);
            }
        }
        return series;
    }

    public ArrayList<Midia> getMidiaGenero(Genero genero) {
        ArrayList<Midia> midias = new ArrayList<>();
        for (Midia m: midias) {
            if (m.getGeneros().contains(genero)) {
                midias.add(m);
            }
        }
        return midias;
    }
}
