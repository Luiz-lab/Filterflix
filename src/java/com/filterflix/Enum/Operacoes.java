package java.com.filterflix.Enum;

public enum Operacoes {
    COMECAR,
    PAUSAR,
    PARAR,
    AVANCO_RAPIDO,
    RETROCEDER,
    PROXIMO,
    ANTERIOR,
    ALTERAR_LEGENDA,
    ALTERAR_AUDIO,
    PROXIMO_EPISODIO,
    EPISODIO_ANTERIOR;

    @Override
    public String toString() {
        switch(this) {
            case COMECAR: return "Play";
            case PAUSAR: return "Pause";
            case PARAR: return "Stop";
            case AVANCO_RAPIDO: return "Avanço Rapido";
            case RETROCEDER: return "Retroceder";
            case PROXIMO: return "Próximo";
            case ANTERIOR: return "Previous";
            case ALTERAR_LEGENDA: return "Change Subtitle";
            case ALTERAR_AUDIO: return "Change Audio";
            case PROXIMO_EPISODIO: return "Next Episode";
            case EPISODIO_ANTERIOR: return "Previous Episode";
            default: throw new IllegalArgumentException();
        }
    }
}

