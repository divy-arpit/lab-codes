package rmi;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;


class MyServer {
    public static void main(String[] args) {
        try{
            ServerInterface stub=new Model();
            LocateRegistry.createRegistry(5001);
            Naming.rebind("rmi://localhost:5001/server", stub);
            System.out.println("Started");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
