package Lab6_RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface KalkulatorInterface extends Remote {

    public double dodaj(double a, double b) throws RemoteException;
    public double odejmij(double a, double b) throws RemoteException;
    public double mnoz(double a, double b) throws RemoteException;
    public double dziel(double a, double b) throws RemoteException;

}
