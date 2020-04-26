package Lab6_RMI;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Serwer {
    public static void main(String[] args) {
        if(System.getSecurityManager() == null ) {
            System.setSecurityManager(new RMISecurityManager());
        }

        try {
                String name = "Zdalny kalkulator";
                KalkulatorInterface impl = new Kalkulator();
                KalkulatorInterface stub = (KalkulatorInterface) UnicastRemoteObject.exportObject(impl,0);
                Registry registry = LocateRegistry.createRegistry(1099);
                registry.rebind(name,stub);

                System.out.println("Uruchomiono i podpięto zdalny Kalkulator");
                
        } catch (Exception e) {
            System.err.println("Wyjątek");
            e.printStackTrace();
        }
    }
}
