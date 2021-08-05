package ui.gui;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

// develops sound
public class PlaySound {

    // EFFECTS: constructs a new PlaySound
    public PlaySound() { }

    // EFFECTS: plays soundName from library
    public void playSound(String soundName) {
        InputStream music;
        try {
            music = new FileInputStream(new File(soundName));
            AudioStream audio = new AudioStream(music);
            AudioPlayer.player.start(audio);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
