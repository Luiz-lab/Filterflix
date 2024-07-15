package com.filterflix.service;

import com.filterflix.Enum.OperacoesEnum;

public interface OperacoesService {
    boolean executarOperacao(OperacoesEnum operacao);
    boolean retroceder( int velocidade);
    boolean avancar_rapido(int velocidade);
    boolean proximoEpisodio(int episodioAtual);
    boolean episodioAnterior(int episodioAtual);
}
