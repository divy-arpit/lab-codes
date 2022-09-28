package tcp;
import java.net.*;
import java.io.*;
import java.util.Scanner;


public class client {
    public static void main(String[] args) throws Exception {
        try{
            Socket s = new Socket("localhost",8080);
            System.out.println("Client connected to client");
            DataOutputStream op = new DataOutputStream(s.getOutputStream());


            while(true) {
                Scanner sc = new Scanner(System.in);
                String str = sc.nextLine();
                op.writeUTF(str);
                if(str.equals("over"))
                    break;
            }

//            read server time
            DataInputStream in = new DataInputStream(s.getInputStream());
            String date_time = in.readUTF();
            System.out.println(date_time);

        }
        catch (Exception e){
            System.out.println(e);
        }


    }
}


package tcp;
import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Server {
    public static void main(String[] args) throws Exception {
        try{
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server Started...");
            Socket socket = server.accept();
            System.out.println("Listening to client...");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            String str = "";
            while(!str.equals("over")) {
                str = in.readUTF();
                str = str.trim();
                System.out.println(str);
            }

//            send server time
            DataOutputStream op = new DataOutputStream(socket.getOutputStream());
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime date_time = LocalDateTime.now();
            op.writeUTF(dtf.format(date_time));

            server.close();
            socket.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
