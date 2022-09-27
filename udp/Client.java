package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public void CreateClient(int port, String address){
        Scanner in = new Scanner(System.in);
        try{
            //! create a socket
            DatagramSocket socket=new DatagramSocket();
            String input="";
            // send data till over
            while(!input.equals("over")){
                input=in.nextLine();
                byte[] buffer=input.getBytes();
                DatagramPacket packet=new DatagramPacket(buffer, buffer.length,InetAddress.getByName(address),port);
                socket.send(packet);
            }
            socket.send(new DatagramPacket("over".getBytes(), "over".getBytes().length,InetAddress.getByName(address),port));
            in.close();
            socket.close();

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new Client().CreateClient(5001, "192.168.29.170");
    }
}
