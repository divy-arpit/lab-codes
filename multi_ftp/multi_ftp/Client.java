import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket ss=new Socket("127.0.0.1", 6001);
        System.out.println("Connected to Server...");

        byte[] data=new byte[1024];
        ss.getInputStream().read(data);

        String list=new String(data);
        System.out.println(list);

        BufferedReader br=new BufferedReader(new InputStreamReader((System.in)));
        String fileNeeded=br.readLine();

        ss.getOutputStream().write(fileNeeded.getBytes());

        byte[] data2=new byte[1024];
        ss.getInputStream().read(data2);

        String content=new String(data2);
        System.out.println(content);
    }
}
