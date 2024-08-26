package com.Audio;
public class Main {
 public static void main(String[] args) {
     // Create an instance of the legacy audio player
     LegacyAudioPlayer legacyPlayer = new LegacyAudioPlayer();
     
     // Create an adapter for the legacy player
     ModernMediaPlayer mediaPlayer = new LegacyAdapter(legacyPlayer);
     
     // Use the adapter to play audio
     mediaPlayer.play("example_audio_file.oldformat");
 }
}
