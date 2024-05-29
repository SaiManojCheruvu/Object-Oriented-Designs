package umbcs680.Playlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Playlist implements Playable{
    private List<Playable> playlist;
    private String name;

    public Playlist(String name) {
        this.name = name;
        playlist = new ArrayList<>();
    }

    public void add(Playable playable) {
        playlist.add(playable);
    }

    public void remove(Playable playable) {
        playlist.remove(playable);
    }

    @Override
    public void Play() {
        System.out.println("Playing playlist: " + name);
        for (Playable playable : playlist) {
            playable.Play();
        }
    }

    @Override
    public String getName() {
        return name;
    }

    public void shuffle() {
        Collections.shuffle(playlist);
    }

    public List<Playable> getPlaylist() {
        return playlist;
    }
}
