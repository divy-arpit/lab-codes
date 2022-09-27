package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void CreateServer(int port) {
        try {
            // ! to start the server
            ServerSocket server = new ServerSocket(port);
            System.out.println("ready");
            // ! accept a client here
            Socket socket = server.accept();
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
           ;

            // process the inputs till "over" is reached
            String inputString = "";
            
            while (!inputString.equals("over")) {
                inputString = inputStream.readUTF();
                System.out.println(inputString);
                outputStream.writeUTF("got the message");
              

            }
           

           

            // !close all connections
            socket.close();
            server.close();

        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        new Server().CreateServer(5000);

    }
}
