package Lab2_JavaCollections;

import java.util.List;

public class MyConsumentThread extends Thread{

    List<Integer> lista;

    public MyConsumentThread ( List<Integer> list) {
        this.lista = list;
    }

    @Override
    public void run() {
        int i = 0;
        try {
            Thread.sleep(1000);
            while(true) {
                int j;
                //synchronized(lista) {
                    j = lista.remove(0);
               // }
                System.out.println("Konsument pobral " + j + " jest " + i);
                assert i == j;
                i++;
               if(this.isInterrupted()) break;
            }

        } catch (InterruptedException e) {}
    }
}
