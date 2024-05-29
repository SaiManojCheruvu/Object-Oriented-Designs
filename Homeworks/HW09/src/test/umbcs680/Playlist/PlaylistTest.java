package umbcs680.Playlist;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PlaylistTest {
    @Test
    public void testSongGetName() {
        Song song = new Song("Song 1", "Artist 1");
        assertEquals("Song 1", song.getName());
    }

    @Test
    public void testPlaylistGetName() {
        Playlist playlist = new Playlist("Test Playlist");
        assertEquals("Test Playlist", playlist.getName());
    }

    @Test
    public void testPlaylistAddAndPlay() {
        Playlist playlist = new Playlist("Test Playlist");
        Song song1 = new Song("Song 1", "Artist 1");
        Song song2 = new Song("Song 2", "Artist 2");
        playlist.add(song1);
        playlist.add(song2);
        assertEquals("Song 1", ((Song)playlist.getPlaylist().get(0)).getName());
        assertEquals("Song 2", ((Song)playlist.getPlaylist().get(1)).getName());
        // As we are not expecting any return value from play method, we will simply call it
        playlist.Play();
    }

    @Test
    public void testPlaylistAddAndRemove() {
        Playlist playlist = new Playlist("Test Playlist");
        Song song1 = new Song("Song 1", "Artist 1");
        Song song2 = new Song("Song 2", "Artist 2");
        playlist.add(song1);
        playlist.add(song2);
        assertEquals(2, playlist.getPlaylist().size());
        playlist.remove(song1);
        assertEquals(1, playlist.getPlaylist().size());
    }

    @Test
    public void testPlaylistShuffle() {
        Playlist playlist = new Playlist("Test Playlist");
        Song song1 = new Song("Song 1", "Artist 1");
        Song song2 = new Song("Song 2", "Artist 2");
        playlist.add(song1);
        playlist.add(song2);
        playlist.shuffle();
        System.out.println("shuffle did not throw any exception");
        assertTrue(true);
    }


}