package Main.Algorithms;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
public class CollisionSound {
    static Long currentFrame;
    static Clip clip;
    AudioInputStream audioInputStream;
    public CollisionSound(int t) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if (t == 12) {
            audioInputStream = AudioSystem.getAudioInputStream(new File("resource/Sound/sound4.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            currentFrame = clip.getMicrosecondPosition();
        }else {
            audioInputStream = AudioSystem.getAudioInputStream(new File("resource/Sound/brickHitSound.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            currentFrame = clip.getMicrosecondPosition();
        }
    }
    public CollisionSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioInputStream = AudioSystem.getAudioInputStream(new File("resource/Sound/powerUpSound.wav").getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        currentFrame = clip.getMicrosecondPosition();
    }
    public CollisionSound(String s) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioInputStream = AudioSystem.getAudioInputStream(new File("resource/Sound/ballHitSound.wav").getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        currentFrame = clip.getMicrosecondPosition();
    }

    public void start() throws InterruptedException {
        clip.setFramePosition(0);
        clip.start();
        while (clip.isRunning()) {
            long counter = clip.getMicrosecondPosition();
            if (counter > 1100000) {
                clip.stop();
                clip.close();
            }
        }
    }
}
