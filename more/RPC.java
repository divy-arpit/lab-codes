package rpc;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8080);
            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter any operation (add,sub,mul,div) followed by two operands in new line each...");

            String op;
            while(true) {
                op = sc.nextLine();
                dout.writeUTF(op);
                if (op.equals("exit")) {
                    break;
                }

                int a, b;
                a = Integer.parseInt(sc.next());
                b = Integer.parseInt(sc.next());


                dout.writeInt(a);
                dout.writeInt(b);

                int ans = Integer.parseInt(din.readUTF());

                System.out.println("Ans = " + ans);
            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


package rpc;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        ServerSocket server;
        Socket socket;
//        DataInputStream din = new DataInputStream(socket.getInputStream());


        try {
            server = new ServerSocket(8080);
            socket = server.accept();
                                                                                                                                                                                                                    DataInputStream din = new DataInputStream(socket.getInputStream());
                                                                                                                                                                                                                    DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            String operation = "";
            int a, b, c;


            while(true){
                operation = din.readUTF();

                if(operation.equals("exit")){
                    break;
                }
                a = din.readInt();
                b = din.readInt();

                if(operation != null){
                    System.out.println("Operation: " + operation);
                }

                if(operation.equals("add")){
                    c = a+b;
                    System.out.println(a + " + " + b + " = " + c);
                    dout.writeUTF(String.valueOf(c));
                }

                if(operation.equals("mul")){
                    c = a*b;
                    System.out.println(a + " * " + b + " = " + c);
                    dout.writeUTF(String.valueOf(c));
                }

                if(operation.equals("sub")){
                    c = a-b;
                    System.out.println(a + " - " + b + " = " + c);
                    dout.writeUTF(String.valueOf(c));
                }

                if(operation.equals("div")) {
                    c = a / b;
                    System.out.println(a + " / " + b + " = " + c);
                    dout.writeUTF(String.valueOf(c));
                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
