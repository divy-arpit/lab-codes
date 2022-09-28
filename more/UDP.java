package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class client {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DatagramSocket socket;
        DatagramPacket dp;

        {
            try {
                socket = new DatagramSocket(8080);
                byte[] buffer = new byte[2048];
                dp = new DatagramPacket(buffer, 2048);
                String input = " ";
                while(!input.equals("over")){
                    input=in.nextLine();
                    byte[] bfr=input.getBytes();
                    DatagramPacket packet=new DatagramPacket(bfr, bfr.length, InetAddress.getByName("127.0.0.1"),7908);
                    socket.send(packet);
                }
                socket.send(new DatagramPacket("over".getBytes(), "over".getBytes().length,InetAddress.getByName("127.0.0.1"),7908));


                String date = "";
                dp = new DatagramPacket(buffer, 2048 );
                socket.receive(dp);
                date = new String(dp.getData(),0,dp.getLength());
                System.out.println(date);
                in.close();
                socket.close();

            } catch (SocketException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

package udp;
import java.net.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class server {
    public static void main(String[] args) {
        DatagramSocket socket;
        DatagramPacket dp;

        {
            try {
                socket = new DatagramSocket(7908);
                byte[] buffer = new byte[2048];
                String str = "";
                while(!str.equals("over")) {
                    dp = new DatagramPacket(buffer, 2048);
                    socket.receive(dp);
                    str = new String(dp.getData(), 0, dp.getLength());
                    System.out.println(str);
                }


                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime date_time = LocalDateTime.now();
                String date = dtf.format(date_time);
                System.out.println(date);
                socket.send(new DatagramPacket(date.getBytes(),date.length(),InetAddress.getByName("127.0.0.1"),7908));

            socket.close();
            } catch (SocketException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
