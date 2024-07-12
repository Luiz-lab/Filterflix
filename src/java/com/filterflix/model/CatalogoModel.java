package java.com.filterflix.model;

import java.util.ArrayList;

public class CatalogoModel {
    private ArrayList<MidiaModel> midias;

    public CatalogoModel(ArrayList<MidiaModel> midias) {
        this.midias = midias;
    }

    public ArrayList<SerieModel> getSeries() {
        ArrayList<SerieModel> series = new ArrayList<>();
        for (MidiaModel m : midias) {
            if (m instanceof SerieModel) {
                series.add((SerieModel)m);
            }
        }
        return series;
    }

    public ArrayList<FilmeModel> getFilmes() {
        ArrayList<FilmeModel> filmes = new ArrayList<>();
        for (MidiaModel m: midias) {
            if (m instanceof FilmeModel) {
                filmes.add((FilmeModel)m);
            }
        }
        return filmes;
    }

    public ArrayList<FilmeModel> getFilmesGenero(GeneroModel genero) {
        ArrayList<MidiaModel> midiasTemp = getMidiaGenero(genero);
        ArrayList<FilmeModel> filmes = new ArrayList<>();
        for (MidiaModel m: midiasTemp) {
            if (m instanceof FilmeModel) {
                filmes.add((FilmeModel)m);
            }
        }
        return filmes;
    }

    public ArrayList<SerieModel> getSerieGenero(GeneroModel genero) {
        ArrayList<MidiaModel> midiasTemp = getMidiaGenero(genero);
        ArrayList<SerieModel> series = new ArrayList<>();
        for (MidiaModel m: midiasTemp) {
            if (m instanceof SerieModel) {
                series.add((SerieModel) m);
            }
        }
        return series;
    }

    public ArrayList<MidiaModel> getMidiaGenero(GeneroModel genero) {
        ArrayList<MidiaModel> midias = new ArrayList<>();
        for (MidiaModel m: midias) {
            if (m.getGeneros().contains(genero)) {
                midias.add(m);
            }
        }
        return midias;
    }
}
