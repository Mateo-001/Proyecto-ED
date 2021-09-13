package Source;

import Interface.JFPlay;

public class Main {

    static ListaCanciones lista = new ListaCanciones();
    
    public static void main(String[] args) {
        JFPlay jFPlay = new JFPlay();
        jFPlay.setVisible(true);
    }
    
}
