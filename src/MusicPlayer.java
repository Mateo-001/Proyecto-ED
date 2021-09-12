import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
public class MusicPlayer {

	Player player;
	
	public MusicPlayer(BufferedInputStream bis) {
		try {
			player = new Player(bis);
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//hola
	public void play() {
				Interfaz.pausa = false;
		new Thread() {
	         public void run() {
	            try {
	               while (true) {
	                  if (!Interfaz.pausa) {
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
	      }catch (Exception e) {
	    	  e.printStackTrace();
	      }
	}
	
	public void pause() {
		Interfaz.pausa = true;
	}
	
}