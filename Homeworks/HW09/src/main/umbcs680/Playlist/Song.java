package umbcs680.Playlist;

public class Song implements Playable{
    private String title;
    private String artist;
    public Song(String title, String artist){
        this.title = title;
        this.artist = artist;
    }
    @Override
    public void Play() {
        System.out.println("Playing song: "+title+" By: "+artist);
    }

    @Override
    public String getName() {
        return title;
    }

}
