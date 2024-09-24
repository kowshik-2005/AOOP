import java.util.LinkedList;

public class MusicPlaylist {
    private LinkedList<String> playlist;

    public MusicPlaylist() {
        playlist = new LinkedList<>();
    }

    public void addSong(String song) {
        playlist.add(song);
    }

    public void removeSong(String song) {
        playlist.remove(song);
    }

    public void moveSong(int oldIndex, int newIndex) {
        if (oldIndex >= 0 && oldIndex < playlist.size() && newIndex >= 0 && newIndex < playlist.size()) {
            String song = playlist.remove(oldIndex);
            playlist.add(newIndex, song);
        }
    }

    public void displayPlaylist() {
        System.out.println("Playlist: " + playlist);
    }

    public static void main(String[] args) {
        MusicPlaylist musicPlaylist = new MusicPlaylist();
        musicPlaylist.addSong("Song 1");
        musicPlaylist.addSong("Song 2");
        musicPlaylist.displayPlaylist();
        musicPlaylist.moveSong(0, 1);
        musicPlaylist.displayPlaylist();
        musicPlaylist.removeSong("Song 2");
        musicPlaylist.displayPlaylist();
    }
}




