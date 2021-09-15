package Source;

import Interface.JFPlay;
import com.mpatric.mp3agic.Mp3File;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.tritonus.share.sampled.file.TAudioFileFormat;

public class MusicPlayer {

    Player player;

    public MusicPlayer(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fileInputStream);
            player = new Player(bis);
        } catch (JavaLayerException | FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }

    public void play() {
        JFPlay.pausa = false;
        new Thread() {
            public void run() {
                try {
                    while (true) {
                        if (!JFPlay.pausa) {
                            if (!player.play(1)) {
                                break;
                            }
                        }
                    }
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            //Thread.sleep(1);
            //Interfaz.pausa = true;
            //System.out.println("pausado");
            //Thread.sleep(2000);
            //Interfaz.pausa = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pause() {
        JFPlay.pausa = true;
    }

    public int getDurationWithMp3Spi(File file) throws UnsupportedAudioFileException, IOException {

        AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(file);
        if (fileFormat instanceof TAudioFileFormat) {
            Map<?, ?> properties = ((TAudioFileFormat) fileFormat).properties();
            String key = "duration";
            Long microseconds = (Long) properties.get(key);
            int mili = (int) (microseconds / 1000);
            //int sec = (mili / 1000) % 60;
            //int min = (mili / 1000) / 60;
            //System.out.println("time = " + min + ":" + sec);
            //System.out.println("time = " + mili);
            return mili;
        } else {
            throw new UnsupportedAudioFileException();
        }
    }

    public String getTotalTime(File file) throws UnsupportedAudioFileException, IOException {

        AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(file);
        if (fileFormat instanceof TAudioFileFormat) {
            Map<?, ?> properties = ((TAudioFileFormat) fileFormat).properties();
            String key = "duration";
            Long microseconds = (Long) properties.get(key);
            int mili = (int) (microseconds / 1000);
            int sec = (mili / 1000) % 60;
            int min = (mili / 1000) / 60;
            String tiempo = min + ":" + sec;
            //System.out.println("time = " + mili);
            return tiempo;
        } else {
            throw new UnsupportedAudioFileException();
        }
    }

    public void close() {
        player.close();
    }

    public boolean complete() {
        return player.isComplete();
    }

    public int getPosition() {
        return player.getPosition();
    }

    public String getActualTime() {
        String tiempo;
        long mili = player.getPosition();  // obtained from StopWatch
        long min = (mili / 1000) / 60;
        int sec = (int) ((mili / 1000) % 60);
        tiempo = min + ":" + sec;
        return tiempo;
    }
}
