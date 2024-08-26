package com.Audio;
public class LegacyAdapter implements ModernMediaPlayer {
 private LegacyAudioPlayer legacyAudioPlayer;

 public LegacyAdapter(LegacyAudioPlayer legacyAudioPlayer) {
     this.legacyAudioPlayer = legacyAudioPlayer;
 }

 @Override
 public void play(String filename) {
     // Assuming the legacy player supports old formats, but we'll adapt it here
     legacyAudioPlayer.playOldFormatAudio(filename);
 }
}
