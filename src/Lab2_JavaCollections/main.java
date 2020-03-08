package Lab2_JavaCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.lang.Thread.sleep;

public class main {
    public static void main(String[] args) throws InterruptedException {

        // List<Integer> lista = new ArrayList<Integer>(); // ZAD 1
         List<Integer> lista;
         List<Integer> lista2;
         List<Integer> lista3;

        lista = new ArrayList<Integer>();
        lista2 = Collections.synchronizedList(lista);
        lista3 = new CopyOnWriteArrayList<>();

        speedTest test = new speedTest();


         System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Test zwyklej listy ! ");
         speedTest.testing(lista);
         System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Test listy synchronized ! ");
         speedTest.testing(lista2);
         System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Test CopyOnWriteArray ! ");
         speedTest.testing(lista3);

       // MyProducentThread producent = new MyProducentThread(lista);
       // MyConsumentThread konsument = new MyConsumentThread(lista);
       // MySumThread sumThread = new MySumThread(lista);

        //producent.start();
        //konsument.start();
        //sumThread.start();

        //Thread.sleep(30_000);

        //producent.interrupt();
        //konsument.interrupt();
        //sumThread.interrupt();

    }
}
