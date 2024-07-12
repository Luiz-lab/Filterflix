package java.com.filterflix.service;

import java.com.filterflix.Enum.Operacoes;
import java.com.filterflix.model.MidiaModel;

public class OperacoesServiceImpl implements OperacoesService{

    @Override
    public boolean executarOperacao(Operacoes operacao) {
        return true;
    }

    @Override
    public boolean retroceder(int velocidade) {
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
