package Lab2_JavaCollections;

import java.util.List;

public class MySumThread extends Thread {

    List<Integer> list;

    public MySumThread(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        try{
            sleep(100);
            while(true) {
                int j = 0;
                for (int i : list) {
                    j += i;
                }
                System.out.println("Suma " + j);
                if(this.isInterrupted()) break;
            }
        } catch (InterruptedException e) {}
    }
}
