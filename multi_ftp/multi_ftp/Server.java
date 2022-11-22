import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

class ServerThread extends Thread {
    private Socket cs;
    public  ServerThread(Socket cs){
        this.cs=cs;
    }

    @Override
    public void run(){
        try {
            String path="D:/7th Sem/DS Labs/lab-codes/multi_ftp/SampleDir";
            File file=new File(path);
            File[] files=file.listFiles();

            String list="";
            for(File f:files){
                list+=f.getName()+", ";
            }

            cs.getOutputStream().write(list.getBytes());

            byte[] data=new byte[1024];
            cs.getInputStream().read(data);
            String dataNeeded=new String(data);
            dataNeeded=dataNeeded.trim();

            String filePath=path+"/"+dataNeeded;
            BufferedReader content=new BufferedReader(new FileReader(filePath));
            
            String sendData="";
            String temp;
            while(( temp=content.readLine())!=null){
                sendData+=temp;
            }

            cs.getOutputStream().write(sendData.getBytes());
            cs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss=new ServerSocket(6001);
        ArrayList<ServerThread> threads=new ArrayList<>();

        while(true){
            Socket cs=ss.accept();
            System.out.println("New client connected");

            ServerThread st=new ServerThread(cs);
            threads.add(st);
            st.start();
        }
    }    
}
