package Lab1_CzytelnikPisarz;

public class main {
    public static void main(String[] args) {
        Czytelnia czytelnia = new CzytelniaC();
        Pisarz pisarz = new Pisarz(czytelnia);
        Czytelnik[] czytelnicy = new Czytelnik[5];
        for(int i=0; i< czytelnicy.length; i++) {
            czytelnicy[i] = new Czytelnik(czytelnia);
        }
        pisarz.start();
        for(Czytelnik c : czytelnicy) c.start();
    }
}
