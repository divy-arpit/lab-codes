package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public void CreateClient(int port,String address){
        Scanner in=new Scanner(System.in);
        try{
            //!create a socket
            Socket socket=new Socket(address,port);

            DataOutputStream outputStream=new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
            

            String input=in.nextLine();
            while(!input.equals("over")){
                outputStream.writeUTF(input);
                String response=dataInputStream.readUTF();
                System.out.println(response);
                input=in.nextLine();
            }
            outputStream.writeUTF("over");
            in.close();
            socket.close();


        }
        catch(Exception e){

        }

    }
    public static void main(String[] args) {
        new Client().CreateClient(5000, "127.0.0.1");

    }
    
}
