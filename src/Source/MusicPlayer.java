package Source;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

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

}
