package Main.Algorithms;

import java.io.File;
import java.io.IOException;
//import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
    static Long currentFrame;
    static Clip clip;
    AudioInputStream audioInputStream;
    public Sound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioInputStream = AudioSystem.getAudioInputStream(new File("resource/Sound/sound1.wav").getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        currentFrame = clip.getMicrosecondPosition();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public Sound(String s) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioInputStream = AudioSystem.getAudioInputStream(new File("resource/Sound/lose.wav").getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        currentFrame = clip.getMicrosecondPosition();

    }

    public void gotoChoice(int c) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        switch (c) {
            case 1:
                resumeAudio();
                break;
            case 2:
                pause();
                break;
        }
    }
    public void play() {
        clip.setMicrosecondPosition(0L);
        clip.start();
    }
    public void pause() {
        clip.stop();
    }
    public void resumeAudio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        clip.close();
        resetAudioStream();
        clip.setMicrosecondPosition(currentFrame);
        this.play();
    }
    public void resetAudioStream() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioInputStream = AudioSystem.getAudioInputStream(
                new File("resource/Sound/sound1.wav").getAbsoluteFile());
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }


}