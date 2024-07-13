package java.com.filterflix.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class OperacoesModel {
    private String operacoes;
    private boolean comecar;
    private boolean parar;
    private boolean pausar;
    private boolean avancoRpaido;
    private boolean retroceder;
    private int velocidade;
    private boolean proximoEpisodio;
    private boolean episodioAnterior;

    public OperacoesModel() {
    }

}
