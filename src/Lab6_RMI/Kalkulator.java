package Lab6_RMI;

import java.rmi.RemoteException;

public class Kalkulator implements KalkulatorInterface {
    @Override
    public double dodaj(double a, double b) throws RemoteException {
        double wynik = a + b;
        return wynik;
    }

    @Override
    public double odejmij(double a, double b) throws RemoteException {
        double wynik = a - b;
        return wynik;
    }

    @Override
    public double mnoz(double a, double b) throws RemoteException {
        double wynik = a * b;
        return wynik;
    }

    @Override
    public double dziel(double a, double b) throws RemoteException {
        double wynik = a / b;
        return wynik;
    }
}
