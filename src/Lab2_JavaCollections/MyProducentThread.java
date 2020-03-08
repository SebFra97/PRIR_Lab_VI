package Lab2_JavaCollections;

import java.util.List;

public class MyProducentThread extends Thread {

    List<Integer> lista;

    public MyProducentThread(List<Integer> list) {
        this.lista = list;
    }

    @Override
    public void run() {
        int i = 0;
        while(true) {
           // synchronized (lista) {
                lista.add(i);
                // }
            i++;
            if(this.isInterrupted()) break;
        }
    }
}
