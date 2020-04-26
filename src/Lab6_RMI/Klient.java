package Lab6_RMI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Klient {
    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {

            BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
            String name = "Zdalny kalkulator";
            Registry registry = LocateRegistry.getRegistry();
            KalkulatorInterface zdalnyKalk = (KalkulatorInterface) registry.lookup(name);
            System.out.println("Nawiązano połączenie !");
            System.out.println("Podaj a");
            String a=buffer.readLine();
            System.out.println("Podaj b");
            String b =buffer.readLine();

            double liczA = Double.parseDouble(a);
            double liczB = Double.parseDouble(b);

            System.out.println("Działania na liczbach " + liczA +" oraz "+ liczB);
            System.out.println("Dodanie " + zdalnyKalk.dodaj(liczA,liczB));
            System.out.println("Dzielenie " + zdalnyKalk.dziel(liczA,liczB));
            System.out.println("Mnozenie " + zdalnyKalk.mnoz(liczA,liczB));
            System.out.println("Odejmowanie " + zdalnyKalk.odejmij(liczA,liczB));

        } catch (Exception e) {
            System.out.println("Wyjątek Klienta ! ");
            e.printStackTrace();
        }
    }
}
