package rmi;

import java.rmi.*;

public class Client {
    public static void main(String args[]) {
        try {
            ServerInterface stub = (ServerInterface) Naming.lookup("rmi://localhost:5001/server");
            System.out.println(stub.Add(34, 4));
            System.out.println("Sent");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}