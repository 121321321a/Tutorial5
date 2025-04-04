import java.util.ArrayList;

class Playlist {
    private final String name;
    private final ArrayList<String> tracks;

    public Playlist(String name) {
        this.name = name;
        this.tracks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addTrack(String track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        }
    }

    public void removeTrack(String track) {
        tracks.remove(track);
    }

    public boolean hasTrack(String track) {
        return tracks.contains(track);
    }

    public void display() {
        System.out.println("Playlist: " + name);
        for (String track : tracks) {
            System.out.println("- " + track);
        }
    }
}

class MusicLibrary {
    private final String owner;
    private final ArrayList<String> tracks;
    private final ArrayList<Playlist> playlists;

    public MusicLibrary(String name, String owner) {
        this.owner = owner;
        this.tracks = new ArrayList<>();
        this.playlists = new ArrayList<>();
    }

    public void addTrack(String track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        }
    }

    public void removeTrack(String track) {
        if (tracks.remove(track)) {
            for (Playlist playlist : playlists) {
                playlist.removeTrack(track);
            }
        }
    }

    public void displayTracks() {
        System.out.println("Tracks in library:");
        for (String track : tracks) {
            System.out.println("- " + track);
        }
    }

    public void searchTracks(String keyword) {
        System.out.println("Search results for '" + keyword + "':");
        for (String track : tracks) {
            if (track.contains(keyword)) {
                System.out.println("- " + track);
            }
        }
    }

    public void createPlaylist(String playlistName) {
        for (Playlist p : playlists) {
            if (p.getName().equals(playlistName)) {
                return;
            }
        }
        playlists.add(new Playlist(playlistName));
    }

    public void addTrackToPlaylist(String track, String playlistName) {
        for (Playlist playlist : playlists) {
            if (playlist.getName().equals(playlistName)) {
                if (!playlist.hasTrack(track)) {
                    playlist.addTrack(track);
                }
                return;
            }
        }
    }

    public void displayPlaylist(String playlistName) {
        for (Playlist playlist : playlists) {
            if (playlist.getName().equals(playlistName)) {
                playlist.display();
                return;
            }
        }
        System.out.println("Playlist not found.");
    }

    public void displayAllPlaylists() {
        System.out.println("All playlists:");
        for (Playlist playlist : playlists) {
            System.out.println("- " + playlist.getName());
        }
    }

    public int getTrackCount() {
        return tracks.size();
    }

    public int getPlaylistCount() {
        return playlists.size();
    }

    public String getOwner() {
        return owner;
    }
}

class Program {
    public static void main(String[] args) {
        MusicLibrary myLibrary = new MusicLibrary("Rock Collection", "John Smith");

        myLibrary.addTrack("Led Zeppelin - Stairway to Heaven");
        myLibrary.addTrack("Queen - Bohemian Rhapsody");
        myLibrary.addTrack("Pink Floyd - Comfortably Numb");
        myLibrary.addTrack("AC/DC - Back in Black");
        myLibrary.addTrack("Metallica - Nothing Else Matters");

        myLibrary.displayTracks();

        myLibrary.createPlaylist("Favorites");
        myLibrary.createPlaylist("Party");

        myLibrary.addTrackToPlaylist("Queen - Bohemian Rhapsody", "Favorites");
        myLibrary.addTrackToPlaylist("Pink Floyd - Comfortably Numb", "Favorites");
        myLibrary.addTrackToPlaylist("AC/DC - Back in Black", "Party");
        myLibrary.addTrackToPlaylist("Metallica - Nothing Else Matters", "Party");

        myLibrary.displayAllPlaylists();
        myLibrary.displayPlaylist("Favorites");

        myLibrary.searchTracks("Queen");

        myLibrary.removeTrack("AC/DC - Back in Black");
        myLibrary.displayPlaylist("Party");

        System.out.println("Total number of tracks in the library: " + myLibrary.getTrackCount());
        System.out.println("Total number of playlists: " + myLibrary.getPlaylistCount());
    }
}
