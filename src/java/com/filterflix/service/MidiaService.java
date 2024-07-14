package java.com.filterflix.service;

import java.com.filterflix.model.MidiaModel;
import java.com.filterflix.repository.MidiaRepository;
import java.util.List;

public class MidiaService {
    private MidiaRepository midiaRepository;

    public MidiaService(MidiaRepository midiaRepository) {
        this.midiaRepository = midiaRepository;
    }

    public void adicionarMidia(MidiaModel midia) {
        midiaRepository.salvarMidia(midia);
    }

    public List<MidiaModel> listarMidias() {
        return midiaRepository.listarMidias();
    }
}