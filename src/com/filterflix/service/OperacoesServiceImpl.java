package com.filterflix.service;

import com.filterflix.Enum.OperacoesEnum;
import com.filterflix.model.MidiaModel;
import com.filterflix.model.OperacoesModel;

import java.util.Timer;
import java.util.TimerTask;

public class OperacoesServiceImpl implements OperacoesService{

    OperacoesModel operacoesModel;
    private Timer timer;
    private TimerTask timerTask;
    private MidiaModel midiaModel;

    public OperacoesServiceImpl(MidiaModel midiaModel) {
        this.midiaModel = midiaModel;
        this.operacoesModel = new OperacoesModel();
        operacoesModel.setDuracao(midiaModel.getDuracao());
    }

    @Override
    public boolean executarOperacao(OperacoesEnum operacao) {
        if (operacao == null) {
            return false;
        }
        switch (operacao) {
            case COMECAR -> {
                iniciar();
                return true;
            }
            case PAUSAR -> {
                pausar();
                return true;
            }
            case PARAR -> {
                parar();
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
                return true;
            }
            case ALTERAR_AUDIO -> {
                return true;
            }
            default -> throw new IllegalArgumentException("Operação não suportada: " + operacao);
        }
    }

    @Override
    public boolean retroceder(int velocidade) {
        if (velocidade <= 0){
            return false;
        }
        int novoTempo  = operacoesModel.getTempoAtual() - velocidade;
        operacoesModel.setTempoAtual(Math.max(novoTempo,0));
        System.out.println("Retrocesso: " + formatarTempo(operacoesModel.getTempoAtual()));
        operacoesModel.setVelocidade(velocidade);
        return true;
    }

    @Override
    public boolean avancar_rapido(int velocidade) {
        if (velocidade <= 0){
            return false;
        }
        int novoTempo = operacoesModel.getTempoAtual() - velocidade;
        operacoesModel.setTempoAtual(Math.min(novoTempo,operacoesModel.getDuracao()));
        System.out.println("Avanço rápido: " + formatarTempo(operacoesModel.getTempoAtual()));
        operacoesModel.setVelocidade(velocidade);
        return true;
    }

    private void iniciar(){
        if (timer != null){
            timer.cancel();
        }
        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                int novoTempo  = operacoesModel.getTempoAtual() + 1;
                operacoesModel.setTempoAtual(Math.min(novoTempo,operacoesModel.getDuracao()));
                System.out.println("Tempo Atual: " + formatarTempo(operacoesModel.getTempoAtual()));
                if (operacoesModel.getDuracao()<=operacoesModel.getTempoAtual()){
                    parar();
                }
            }
        };
        timer.scheduleAtFixedRate(timerTask,0,1000);
        operacoesModel.setComecar(true);
        operacoesModel.setParar(false);
        operacoesModel.setPausar(false);
    }

    private void pausar(){
        if (timer!= null){
            timer.cancel();
            timer = null;
        }
        operacoesModel.setComecar(false);
        operacoesModel.setParar(false);
        operacoesModel.setPausar(true);
    }

    private void parar() {
        if (timer != null){
            timer.cancel();
            timer = null;
        }
        operacoesModel.setTempoAtual(0);
        operacoesModel.setComecar(false);
        operacoesModel.setParar(true);
        operacoesModel.setPausar(false);
    }

    @Override
    public boolean proximoEpisodio(int episodioAtual) {
        return false;
    }

    @Override
    public boolean episodioAnterior(int episodioAtual) {
        return false;
    }

    private String formatarTempo(int tempoAtual) {
        int horas = tempoAtual / 3600;
        int minutos = (tempoAtual % 3600) / 60;
        int segundos = tempoAtual % 60;
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }
}
