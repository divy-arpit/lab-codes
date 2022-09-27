package rmi;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

//! this class needs to be present in both server as well as client as this acts as the object for passing all the data

interface ServerInterface extends Remote{
    public int Add(int a,int b) throws RemoteException;
    public int Sub(int a,int b) throws RemoteException;
    public int Mul(int a,int b) throws RemoteException;
    public int Div(int a,int b) throws RemoteException;
    public int Factorial(int a) throws RemoteException;
}

public class Model extends UnicastRemoteObject implements ServerInterface{
    
    protected Model() throws RemoteException {
        super();
    }

    public int Add(int a, int b) throws RemoteException{
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
    public int Factorial(int a) throws RemoteException {
        int ans=1;
        for(int i=1;i<=a;i++){
            ans*=i;
        }
        return ans;
    }

}