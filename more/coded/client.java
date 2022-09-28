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
