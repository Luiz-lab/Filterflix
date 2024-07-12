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
        switch (this) {
            case COMECAR:
                return "Comecar";
            case PAUSAR:
                return "Pausar";
            case PARAR:
                return "Parar";
            case AVANCO_RAPIDO:
                return "Avanço Rapido";
            case RETROCEDER:
                return "Retroceder";
            case PROXIMO:
                return "Próximo";
            case ANTERIOR:
                return "Anterior";
            case ALTERAR_LEGENDA:
                return "Alterar Legenda";
            case ALTERAR_AUDIO:
                return "Alterar Audio";
            case PROXIMO_EPISODIO:
                return "Próximo Episódio";
            case EPISODIO_ANTERIOR:
                return "Episódio Anterior";
            default:
                throw new IllegalArgumentException();
        }
    }
}
