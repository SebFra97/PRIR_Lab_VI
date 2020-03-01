package Lab1_CzytelnikPisarz;

public class MyThreadWriter extends Thread{

    ReadWriteLock lock;
    String filename;

    public MyThreadWriter(ReadWriteLock lock, String fileName) {
        this.lock = lock;
        this.filename = fileName;
    }

    @Override
    public void run() {
        while (true){
            lock.writeLock();
            System.out.println("Pisarz " + getid()+" pisze");
            lock.unlockWrite();
        }
    }
    private long getid(){
        return Thread.currentThread().getId();
    }
}
