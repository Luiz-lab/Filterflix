package java.com.filterflix.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<FilmeModel> getFilmesGenero(GeneroModel genero) {
/*        ArrayList<MidiaModel> midiasTemp = getMidiaGenero(genero);
        ArrayList<FilmeModel> filmes = new ArrayList<>();
        for (MidiaModel m: midiasTemp) {
            if (m instanceof FilmeModel) {
                filmes.add((FilmeModel)m);
            }
        }*/
        return getMidiaGenero(genero).stream()
                .filter(f-> f instanceof FilmeModel)
                .map(f-> (FilmeModel) f)
                .collect(Collectors.toList());
    }

    public List<SerieModel> getSerieGenero(GeneroModel genero) {
/*        ArrayList<MidiaModel> midiasTemp = getMidiaGenero(genero);
        ArrayList<SerieModel> series = new ArrayList<>();
        for (MidiaModel m: midiasTemp) {
            if (m instanceof SerieModel) {
                series.add((SerieModel) m);
            }
        }*/
        return getMidiaGenero(genero).stream()
                .filter(s-> s instanceof SerieModel)
                .map(s->(SerieModel) s)
                .collect(Collectors.toList());
    }

    public List <MidiaModel> getMidiaGenero(GeneroModel genero) {
        /*        ArrayList<MidiaModel> midias = new ArrayList<>();
        for (MidiaModel m: midias) {
            if (m.getGeneros().contains(genero)) {
                midias.add(m);
            }
        }*/
        return midias.stream()
                .filter(m-> m.getGeneros().contains(genero))
                .collect(Collectors.toList());
    }

    public void inserirMidia(MidiaModel m) {
        midias.add(m);
    }

    public void removerMidia(MidiaModel m) {
        midias.remove(m);
    }

    public void listarMidias() {
        midias.forEach(System.out::println);
         /*
            for (MidiaModel m : midias) {
            m.imprimirMidia();
        }*/
    }

    public MidiaModel selecionarMidia(int id) {
        return midias.get(id);
    }
}
