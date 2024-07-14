package java.com.filterflix.service;

import java.com.filterflix.Enum.OperacoesEnum;
import java.com.filterflix.model.OperacoesModel;

public class OperacoesServiceImpl implements OperacoesService{

    OperacoesModel operacoesModel = new OperacoesModel();

    @Override
    public boolean executarOperacao(OperacoesEnum operacao) {
        if (operacao == null) {
            return false;
        }
        switch (operacao) {
            case COMECAR -> {
                operacoesModel.setComecar(true);
                return true;
            }
            case PAUSAR -> {
                operacoesModel.setPausar(true);
                return true;
            }
            case PARAR -> {
                operacoesModel.setParar(true);
                return true;
            }
            case AVANCO_RAPIDO -> {
                return avancar_rapido(operacoesModel.getVelocidade());
            }
            case RETROCEDER -> {
                return retroceder(operacoesModel.getVelocidade());
            }
            case PROXIMO_EPISODIO -> {
                operacoesModel.setProximoEpisodio(true);
                return true;
            }
            case EPISODIO_ANTERIOR -> {
                operacoesModel.setEpisodioAnterior(true);
                return true;
            }
            case ALTERAR_LEGENDA -> {
                // Falta adicionar logica pra alterar legenda
                return true;
            }
            case ALTERAR_AUDIO -> {
                // Falta adicionar logica pra alterar o audio
                return true;
            }
            default -> throw new IllegalArgumentException("Operação não suportada: " + operacao);
        }
    }

    @Override
    public boolean retroceder(int velocidade) {
        if (velocidade == 0){
            return false;
        }
        else {

            operacoesModel.setVelocidade(velocidade);
        }
        return false;
    }

    @Override
    public boolean avancar_rapido(int velocidade) {
        return false;
    }

    @Override
    public boolean proximoEpisodio(int episodioAtual) {
        return false;
    }

    @Override
    public boolean episodioAnterior(int episodioAtual) {
        return false;
    }
}
