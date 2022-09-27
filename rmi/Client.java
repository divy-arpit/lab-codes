package rmi;

import java.rmi.*;

public class Client {
    public static void main(String args[]) {
        try {
            ServerInterface stub = (ServerInterface) Naming.lookup("rmi://localhost:5001/server");
            System.out.println(stub.Factorial(5));
            System.out.println(stub.Sub(34, 4));
            System.out.println(stub.Div(34, 4));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}