package Lab4_Executors_2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ResultsReceiver implements Runnable {

    String[] files = {"plikA4.txt", "plikB4.txt", "plikC4.txt", "plikD4.txt", "plikE4.txt", "plikF4.txt", "plikG4.txt", "plikH4.txt"};

    @Override
    public void run() {

        int filesCount = files.length;

        while(true)
        {
            HashMap<Integer,Integer> instanceList = null;
            try {
                instanceList = SingletonService.getInstance().getService().take().get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            for (Map.Entry<Integer,Integer> entry : instanceList.entrySet()) {
                    System.out.println("Liczba " + entry.getKey() + " wystepuje " + entry.getValue() + " razy");
                }

        }
    }
}