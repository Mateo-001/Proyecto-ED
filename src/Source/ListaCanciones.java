package Source;

import java.util.ArrayList;

public class ListaCanciones {

    public Nodo head;
    public Nodo pointer;

    public ListaCanciones() {
        head = new Nodo();
        head.next = head;
        head.previous = head;
        pointer = head;
    }

    public void insertSong(Song song) {
        if (head.isEmpty()) {
            head.song = song;
        } else {
            Nodo nuevo = new Nodo(song);
            Nodo ultimo = head;
            while (ultimo.next != head) {
                ultimo = ultimo.next;
            }
            nuevo.next = head;
            ultimo.next = nuevo;
            head.previous = nuevo;
            nuevo.previous = ultimo;
        }
        //pointer = head;
    }

    public void deleteSong(int index) {
        Nodo recorre = head;
        if (head != head.next) {
            if (index == 1) {
                head.next.previous = head.previous;
                head.previous.next = head.next;
                head = head.next;
            } else if (index == listSize()) {
                head.previous.previous.next = head;
                head.previous = head.previous.previous;
            } else {
                for (int i = 1; i < index; i++) {
                    recorre = recorre.next;
                }
                recorre.previous.next = recorre.next;
                recorre.next.previous = recorre.previous;
            }
        }else{
            head = new Nodo();
            head.next = head;
            head.previous = head;
            pointer = head;
        }
        //pointer = head;
    }

    public Song nextSong() {
        //Nodo recorre = head.next;
        if (head == head.next) {
            pointer.next = pointer;
        }
        pointer = pointer.next;
        return pointer.song;
    }

    public Song previousSong() {
        //Nodo recorre = head.previous;
        if (head == head.previous) {
            pointer.previous = pointer;
        }
        pointer = pointer.previous;
        return pointer.song;
    }

    public Song actualsong() {
        return pointer.song;
    }

    public int listSize() {
        Nodo recorre = head;
        int i = 0;
        while (recorre.next != head) {
            i++;
            recorre = recorre.next;
        }
        i++;
        return i;
    }

    public ArrayList getList() {
        Nodo recorre = head;
        ArrayList<Song> songList = new ArrayList<>();
        while (recorre.next != head) {
            songList.add(recorre.song);
            recorre = recorre.next;
        }
        songList.add(recorre.song);
        return songList;
    }

}
