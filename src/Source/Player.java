
package Source;

import Interface.JFPlay;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;
import org.tritonus.share.sampled.file.TAudioFileFormat;

/**
 *
 * @author Bryan
 */
public class Player implements BasicPlayerListener{
    BasicPlayer player = new BasicPlayer();
    BasicController control = (BasicController) player;
    
    boolean change = false;

    public Player() {
        player.addBasicPlayerListener(this);
    }
    
    public void addFile(Song song){
        try {
            control.open(song.getArchivo());
        } catch (BasicPlayerException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void play(){
        try {
            control.play();
        } catch (BasicPlayerException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void resume(){
        try {
            control.resume();
        } catch (BasicPlayerException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void pause(){
        try {
            control.pause();
        } catch (BasicPlayerException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void nextSong(){
        try {
            control.stop();
            control.open(Main.lista.nextSong().getArchivo());
            control.play();
        } catch (BasicPlayerException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void previousSong(){
        try {
            control.stop();
            control.open(Main.lista.previousSong().getArchivo());
            control.play();
        } catch (BasicPlayerException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getActualTime(long l) {
        String tiempo;
        long mili = l;  // obtained from StopWatch
        long min = (mili / 1000) / 60;
        int sec = (int) ((mili / 1000) % 60);
        tiempo = min + ":" + sec;
        return tiempo;
    }
    
    @Override
    public void opened(Object o, Map map) {
        JFPlay.actualizar();
    }

    @Override
    public void progress(int i, long l, byte[] bytes, Map map) {
        JFPlay.updateProgressBar(l/1000, Main.lista.actualsong().getDuracion());
        if(l/1000 == Main.lista.actualsong().getDuracion()){
            change =  true;
        }
    }

    @Override
    public void stateUpdated(BasicPlayerEvent bpe) {
        if (player.getStatus() == BasicPlayer.STOPPED && change == true) {
            nextSong();
            change = false;
        }
    }

    @Override
    public void setController(BasicController bc) {
        
    }
}
