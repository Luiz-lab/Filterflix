package java.com.filterflix.Enum;

public enum Operations {
    PLAY,
    PAUSE,
    STOP,
    FAST_FORWARD,
    REWIND,
    NEXT,
    PREVIOUS,
    CHANGE_SUBTITLE,
    CHANGE_AUDIO,
    NEXT_EPISODE,
    PREVIOUS_EPISODE;

    @Override
    public String toString() {
        switch(this) {
            case PLAY: return "Play";
            case PAUSE: return "Pause";
            case STOP: return "Stop";
            case FAST_FORWARD: return "Fast Forward";
            case REWIND: return "Rewind";
            case NEXT: return "Next";
            case PREVIOUS: return "Previous";
            case CHANGE_SUBTITLE: return "Change Subtitle";
            case CHANGE_AUDIO: return "Change Audio";
            case NEXT_EPISODE: return "Next Episode";
            case PREVIOUS_EPISODE: return "Previous Episode";
            default: throw new IllegalArgumentException();
        }
    }
}

