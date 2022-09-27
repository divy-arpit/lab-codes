package ftp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		new Client().StartClient("127.0.0.1", 6001);
	}

	public void StartClient(String ip, int port){
        try{
            Scanner in=new Scanner(System.in);
            Socket socket=new Socket(ip,port);
            DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
            String list=dataInputStream.readUTF();
            System.out.println(list);
            //! process the list
            String fileNeeded=in.nextLine();
            dataOutputStream.writeUTF(fileNeeded);
            String content=dataInputStream.readUTF();
            System.out.println(content);


        }catch(Exception e){

		}
	}
}

