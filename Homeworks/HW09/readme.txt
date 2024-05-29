Playlist Management Application

This application demonstrates the use of the Composite design pattern to manage playlists in a music player.
The application consists of three main classes:
1. Song: Represents an individual song with a title and an artist.
2. Playlist: Represents a playlist that can contain either songs or other playlists.
3. PlaylistManager: Provides a simple test scenario for creating playlists, adding songs to them, shuffling the playlists, and playing them.
Functionality:
- Song Class: Represents an individual song with a title and an artist. It provides a getName() method to retrieve the song's title.
- Playlist Class: Represents a playlist that can contain songs or other playlists. It provides methods to add, remove, and shuffle playlist items, as well as a play() method to play the playlist.
- PlaylistManager Class: Provides a test scenario to demonstrate the functionality of the Song and Playlist classes. It creates songs, playlists, adds songs to playlists, shuffles playlists, and plays them.
