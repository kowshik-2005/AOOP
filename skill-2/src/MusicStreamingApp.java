// Adapter Pattern
interface MusicPlayer {
    void play(String filename);
}

class LocalFilePlayer implements MusicPlayer {
    @Override
    public void play(String filename) {
        System.out.println("Playing local file: " + filename);
    }
}

class OnlineStreamPlayer implements MusicPlayer {
    @Override
    public void play(String filename) {
        System.out.println("Streaming online music: " + filename);
    }
}

// Adapter to unify access
class RadioPlayerAdapter implements MusicPlayer {
    RadioPlayer radio;

    public RadioPlayerAdapter(RadioPlayer radio) {
        this.radio = radio;
    }

    @Override
    public void play(String station) {
        radio.playRadio(station);
    }
}

// RadioPlayer class (Adaptee)
class RadioPlayer {
    public void playRadio(String station) {
        System.out.println("Playing radio station: " + station);
    }
}

public class MusicStreamingApp {
    public static void main(String[] args) {
        MusicPlayer local = new LocalFilePlayer();
        local.play("song.mp3");

        MusicPlayer online = new OnlineStreamPlayer();
        online.play("https://onlinemusic.com/song");

        RadioPlayer radio = new RadioPlayer();
        MusicPlayer radioAdapter = new RadioPlayerAdapter(radio);
        radioAdapter.play("FM 101.2");
    }
}
