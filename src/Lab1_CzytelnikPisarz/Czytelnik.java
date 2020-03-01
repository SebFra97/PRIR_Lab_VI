package Lab1_CzytelnikPisarz;

public class Czytelnik extends Thread {
    Czytelnia czytelnia;
    Czytelnik(Czytelnia czytelnia) {
        this.czytelnia = czytelnia;
    }

    public void run(){
        try {
            while(true){
                System.out.println("Czytelnik " + getId() + " pozdrawia");
                sleep((int) (Math.random() *100));
                System.out.println("Czytelnik " + getId() + " chce czytac");
                czytelnia.chceCzytac();
                sleep((int) (Math.random() *100));
                System.out.println("Czytelnik " + getId() + " skonczyl czytac");
                czytelnia.koniecCzytania();
            }
        } catch (InterruptedException ex) {}
    }

}
