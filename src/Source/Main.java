package Source;

import Interface.JFPlay;
import java.io.IOException;

public class Main {

    public static ListaCanciones lista = new ListaCanciones();
    
    public static void main(String[] args) throws IOException {
        JFPlay jFPlay = new JFPlay();
        jFPlay.setVisible(true);
    }
    
}
