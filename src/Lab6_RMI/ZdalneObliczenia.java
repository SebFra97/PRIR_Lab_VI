package Lab6_RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ZdalneObliczenia extends Remote {
    void policz(Zadanie t) throws RemoteException;
    Object wynikObliczen() throws RemoteException;
}
