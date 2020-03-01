package Lab1_CzytelnikPisarz;

public class CzytelniaC implements Czytelnia {

    private boolean pisarzPisze;
    private boolean pisarzCzeka;
    private boolean pisarzWlasnieCosWpisal;
    private int liczbaCzytelnikow;

    public synchronized void chceCzytac() {
        try{
            while(pisarzPisze || (pisarzCzeka && !pisarzWlasnieCosWpisal)) { wait(); }
            liczbaCzytelnikow++;
            pisarzWlasnieCosWpisal = false;
        } catch (InterruptedException ex) {}

    }

    public synchronized void koniecCzytania() {
        liczbaCzytelnikow--;
        notifyAll();
    }

    public synchronized void chcePisac() {
        try {
            pisarzCzeka = true;
            while(liczbaCzytelnikow > 0 || pisarzPisze) { wait(); }
            pisarzCzeka = false;
            pisarzPisze = true;
        } catch (InterruptedException e) {}
    }

    public synchronized void koniecPisania() {
        pisarzPisze = false;
        pisarzWlasnieCosWpisal = true;
        notifyAll();
    }
}
