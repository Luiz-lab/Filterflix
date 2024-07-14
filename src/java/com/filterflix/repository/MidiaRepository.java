package java.com.filterflix.repository;

import java.com.filterflix.model.MidiaModel;
import java.util.List;

public interface MidiaRepository {
    void salvarMidia(MidiaModel midia);

    List<MidiaModel> listarMidias();
}
