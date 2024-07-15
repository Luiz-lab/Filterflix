package java.com.filterflix.repository;

import java.com.filterflix.model.MidiaModel;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class MidiaRepositoryImpl implements MidiaRepository {
    private List<MidiaModel> midias = new ArrayList<>();

    @Override
    public void salvarMidia(MidiaModel midia) {
        midias.add(midia);
    }

    @Override
    public List<MidiaModel> listarMidias() {
        return midias;
    }
}