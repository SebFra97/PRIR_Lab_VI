package Lab1_CzytelnikPisarz;

import java.util.ArrayList;
import java.util.List;

public class mainv2 {
    public static void main(String[] args) throws InterruptedException {

        String fileName = "text.txt";
        ReadWriteLock lock = new ReadWriteLock();
        List<Thread> readers = new ArrayList<>();
        List<Thread> writers = new ArrayList<>();

        readers.add(new MyThreadReader(lock,fileName));
        readers.add(new MyThreadReader(lock,fileName));
        readers.add(new MyThreadReader(lock,fileName));
        readers.add(new MyThreadReader(lock,fileName));

        writers.add( new MyThreadWriter(lock, fileName));
        writers.add( new MyThreadWriter(lock, fileName));

        readers.stream().forEach((t)-> lock.registerReader(t));
        writers.stream().forEach((t)->t.start());
        readers.stream().forEach((t)->t.start());

        Thread.sleep(10000);

        writers.stream().forEach(t->t.interrupt());
        readers.stream().forEach(t->t.interrupt());
    }

}
