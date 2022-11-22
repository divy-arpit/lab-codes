package multiclient_tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            Socket socket = new Socket("localhost", 8080);
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            DataInputStream din = new DataInputStream(socket.getInputStream());
//            System.out.println(din.readUTF());
            System.out.println("Write something to send to server. type \"over\" to end connection");

            String input = in.nextLine();
            while(!input.equals("over")){
                dout.writeUTF(input);
                input = in.nextLine();
            }
            dout.writeUTF("over");
            socket.close();
            System.out.println("Client disconnected from server.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
