package multiclient_tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try{
            server = new ServerSocket(8080);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while(true){
            try {
                socket = server.accept();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            new Echothread(socket).start();
        }
    }
}

class Echothread extends Thread{
    protected  Socket socket;

    public Echothread(Socket socket){
        this.socket = socket;
    }

    public void run(){
        System.out.println("hello");
        try {
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            DataInputStream din = new DataInputStream(socket.getInputStream());
            String str = "yo";
            System.out.println();
            while(!str.equals("over")){
                str = din.readUTF();
                System.out.println(str);
            }
            socket.close();
            System.out.println("Client disconnected from server.");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
