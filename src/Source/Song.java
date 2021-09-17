package Source;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


/**
 *
 * @author Bryan
 */
public class Song {
    File archivo;
    Mp3File song;
    
    String nombre;
    String autor;
    String album;
    String genero;
    String anio;
    long duracion;
    
    Image img;

    public Song(String ubicacion) {
        this.archivo = new File(ubicacion);
        setInformacion(archivo);
    }
    
    public void setInformacion(File archivo){
        try {
            this.song = new Mp3File(archivo);
        } catch (IOException | UnsupportedTagException | InvalidDataException ex ) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.nombre = song.getId3v2Tag().getTitle();
        this.autor = song.getId3v2Tag().getArtist();
        this.album = song.getId3v2Tag().getAlbum();
        this.genero = song.getId3v2Tag().getGenreDescription();
        this.anio = song.getId3v2Tag().getYear();
        this.duracion = song.getLengthInMilliseconds();
        byte[] imageData = song.getId3v2Tag().getAlbumImage();
        try {
            img = ImageIO.read(new ByteArrayInputStream(imageData));
        } catch (IOException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public File getArchivo() {
        return archivo;
    }

    public Mp3File getSong() {
        return song;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public String getAlbum() {
        return album;
    }

    public String getGenero() {
        return genero;
    }

    public String getAnio() {
        return anio;
    }

    public Image getImg() {
        return img;
    }

    public long getDuracion() {
        return duracion;
    }
    
}
