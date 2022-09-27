package rpc;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Socket socket = new Socket("127.0.0.1", 3000);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        System.out.println("Client ready, type and press Enter key");

        String receiveMessage, sendMessage, temp;
        while (true) {
            System.out.println("\nEnter operation to perform(add,sub,mul,div).... enter (exit) to exit");
            temp = in.nextLine();
            if (temp == "exit") {
                dataOutputStream.writeUTF("exit");
                break;
            }
            sendMessage = temp.toLowerCase();
            dataOutputStream.writeUTF(sendMessage);
            System.out.println("Enter first parameter :");
            temp = in.nextLine();
            dataOutputStream.writeUTF(temp);
            System.out.println("Enter second parameter : ");
            temp = in.nextLine();
            dataOutputStream.writeUTF(temp);
            System.out.flush();
            receiveMessage = dataInputStream.readUTF();
            System.out.println(receiveMessage);
        }
        socket.close();
        in.close();

    }
}
