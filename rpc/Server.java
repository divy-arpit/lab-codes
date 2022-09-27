package rpc;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.net.*;

public class Server {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(3000);

        System.out.println("Server ready");

        Socket socket = serverSocket.accept();
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        String fun;
        int a, b, c;

        while (true) {
            fun = dataInputStream.readUTF();
            if (fun == "exit") {
                break;
            }
            a = Integer.parseInt(dataInputStream.readUTF());
            b = Integer.parseInt(dataInputStream.readUTF());

            if (fun != null) {
                System.out.println("Operation : " + fun);
            }

            System.out.println("Parameter 1 : " + a);
            System.out.println("Parameter 2 : " + b);
            if (fun.compareTo("add") == 0) {
                c = a + b;
                System.out.println("Addition = " + c);
                dataOutputStream.writeUTF("Addition = " + c);

            }
            if (fun.compareTo("sub") == 0) {
                c = a - b;
                System.out.println("Substraction = " + c);
                dataOutputStream.writeUTF("Subtraction = " + c);

            }
            if (fun.compareTo("mul") == 0) {
                c = a * b;
                System.out.println("Multiplication = " + c);
                dataOutputStream.writeUTF("Multiplication = " + c);
            }
            if (fun.compareTo("div") == 0) {
                c = a / b;
                System.out.println("Division = " + c);
                dataOutputStream.writeUTF("Division = " + c);
            }
            System.out.flush();
        }
        socket.close();
        serverSocket.close();
    }

}
