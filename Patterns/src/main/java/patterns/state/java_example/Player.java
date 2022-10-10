package patterns.state.java_example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Player {

    @Setter
    @Getter
    private State state;
    @Getter
    @Setter
    private boolean isPlaying = false;
    private final List<String> playlist = new ArrayList<>();
    private int currentTrack = 0;

    public Player() {
        this.state = new ReadyState(this);
        setPlaying(true);
        for (int i = 0; i < 12; i++) {
            playlist.add("Track " + i);
        }
    }

    public String startPlayback() {
        return "Playing " + playlist.get(currentTrack);
    }

    public String nextTrack() {
        currentTrack++;
        if (currentTrack > playlist.size() - 1) {
            currentTrack = 0;
        }
        return startPlayback();
    }

    public String previousTrack() {
        currentTrack--;
        if (currentTrack < 0) {
            currentTrack = playlist.size() - 1;
        }
        return startPlayback();
    }

    public void setCurrentTrackAfterStop(){
        this.currentTrack = 0;
    }

}
