package Lab1_CzytelnikPisarz;

public class MyThreadReader extends Thread {

    ReadWriteLock lock;
    String filename;

    public MyThreadReader(ReadWriteLock lock, String fileName) {
        this.lock = lock;
        this.filename = fileName;
    }

    @Override
    public void run() {
        while (true){
            lock.readLock();
            System.out.println("Czytelnik " + getid()+" czyta");
            lock.unlockRead();
        }
    }
    private long getid(){
        return Thread.currentThread().getId();
    }
}
