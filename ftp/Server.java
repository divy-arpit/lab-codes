package ftp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
   public static void main(String[] args) {
    new Server().StartServer(6001);
   }
   public void StartServer(int port){
    try{
        ServerSocket serverSocket=new ServerSocket(port);
        Socket socket=serverSocket.accept();
        DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
        DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
        
        //! read the files present in the directory
        String path="C:\\Users\\Arpit\\Desktop\\Syllabus stuff\\7th sem\\lab\\codes\\ftp\\sampleDirectory";
        File file=new File(path);
		
        File[]files=file.listFiles();
		ArrayList<String>arrayList=new ArrayList<>();
        for(File f:files){
            arrayList.add(f.getName());
        }
        String list="";
        for(String s:arrayList){
            list+=s+",";
        }
		
        //! send the list of files to the client
        dataOutputStream.writeUTF(list);
        String dataNeeded=dataInputStream.readUTF();

        //! read the file to send to the client
        BufferedReader content=new BufferedReader(new FileReader(path+"/"+dataNeeded));
        String sendData="";
        String temp;
        while(( temp=content.readLine())!=null){
            sendData+=temp;
        }
        dataOutputStream.writeUTF(sendData);
    
        }catch(Exception e){
			System.out.println(e);
		}
	}
}


