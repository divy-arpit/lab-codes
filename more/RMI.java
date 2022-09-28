package rmi;

import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.sql.SQLOutput;

public class server {

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        ServerInterface stub = new Model();
        LocateRegistry.createRegistry(5001);
        System.out.println("Started");
    }
}




package rmi;
import tcp.Server;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;


interface ServerInterface extends Remote{
    public int Add(int a,int b) throws RemoteException;
    public int Sub(int a,int b) throws RemoteException;
    public int Mul(int a,int b) throws RemoteException;
    public int Div(int a,int b) throws RemoteException;
    public int Fact(int a) throws RemoteException;
}

public class Model extends UnicastRemoteObject implements ServerInterface {

    protected Model() throws RemoteException {
        super();
    }

    @Override
    public int Add(int a, int b) throws RemoteException {
        return a+b;
    }

    @Override
    public int Sub(int a, int b) throws RemoteException {
        return a-b;
    }

    @Override
    public int Mul(int a, int b) throws RemoteException {
        return a*b;
    }

    @Override
    public int Div(int a, int b) throws RemoteException {
        return a/b;
    }

    @Override
    public int Fact(int a) throws RemoteException {
        int fact = 1;
        for(int i = 1; i<=a; i++){
            fact *= a;
        }
        return fact;
    }
}



package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
    public static void main(String[] args) {
        ServerInterface stub;

        {
            try {
                stub = (ServerInterface) Naming.lookup("rmi://localhost:5001/server");

                System.out.println("Addition: " + stub.Add(4,23));
                System.out.println("Addition: " + stub.Mul(2,0));
                System.out.println("Factorial: " + stub.Fact(7));

            } catch (NotBoundException e) {
                throw new RuntimeException(e);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
