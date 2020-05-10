package Lab7_RMI_2;

import rmi.komunikatorSimple.CommunicatorService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    CommunicatorService service;
    String user;
    String pass;

    public Client(String user, String pass) {
        this.user = user;
        this.pass = pass;
        String nazwa = "komunikator";
        Registry registry = null;

        try {
            registry = LocateRegistry.getRegistry(4444);
            service = (CommunicatorService)registry.lookup(nazwa);
            System.out.println("Klient połączony !");
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try{
            service.registerUser(user,pass);

            Thread reader = new Thread(() -> {
                try{
                    while(!Thread.interrupted()) {
                        String msg = service.getMessage(user, pass);
                        if (msg != null) {
                            String[] lines = msg.split(";");
                            if(lines.length == 2) {
                                String fromUser = lines[0];
                                msg = lines[1];
                                System.out.println("Uzytkownik : " + fromUser + " wysyła wiadomosc : " + msg);
                            }
                        }
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            });

            reader.start();

            Thread writer = new Thread(() -> {
                try{
                    Scanner sc = new Scanner(System.in);
                    int toUser = -1;
                    boolean nextIter = true;
                    while(nextIter) {
                        String linia = sc.nextLine();
                        String[] linie = linia.split(";");
                                String dstUser = linie[0];
                                String msg = linie[1];
                                service.addMessage(user,pass,dstUser,msg);
                        }
                    } catch (RemoteException ex) {
                    ex.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            writer.start();

    } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
