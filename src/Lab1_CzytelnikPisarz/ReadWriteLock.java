package Lab1_CzytelnikPisarz;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;

public class ReadWriteLock implements java.util.concurrent.locks.ReadWriteLock {
    Set<Long> readers=new HashSet<>();
    Set<Long> who_entered=new HashSet<>();
    Set<Long> who_left=new HashSet<>();
    boolean writer_wait=false;
    public synchronized void unlockRead(){
        long id=getid();
        who_left.add(id);
        if(who_left.containsAll(readers)&&who_left.equals(who_entered))
            writer_wait=false;
        notifyAll();
    }
    @Override
    public synchronized Lock readLock()     {
        long id=getid();
        while (who_entered.contains(id)||writer_wait==false) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        who_entered.add(id);
        return null;
    }
    @Override
    public synchronized Lock writeLock() {
        while (writer_wait==true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        writer_wait=true;
        return null;
    }
    public synchronized Lock unlockWrite() {
        who_left.clear();
        who_entered.clear();
        notifyAll();
        return null;
    }
    public synchronized void registerReader(Thread t) {
        readers.add(t.getId());
    }
    public synchronized void unregisterReader(Thread t) {
        readers.remove(t.getId());
    }
    private long getid(){
        return Thread.currentThread().getId();
    }
}
