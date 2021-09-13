package Source;

public class Nodo {

    public Song song;
    public Nodo next;
    public Nodo previous;
    

    public Nodo() {
    }

    public Nodo(Song song) {
        this.song = song;
        this.next = null;
        this.previous = null;
    }
    
    public boolean isEmpty(){
        return song == null;
    }

}
