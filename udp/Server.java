package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public void CreateServer(int port){
        byte[] buffer=new byte[2048]; 
        try{
           
            //! create a socket
            DatagramSocket socket=new DatagramSocket(port);

            //! this is the packet being received
            DatagramPacket packet;
            String inputString="";

            while(!inputString.equals("over")){
                //! receive a packet
                packet=new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                inputString="";

                // process the packet till we get characters
                for(int i=0;i<buffer.length;i++){
                    if(buffer[i]==0){
                        break;
                    }
                    else{
                        inputString+=(char)buffer[i];

                    }
                }
                buffer=new byte[2048];
                System.out.println(inputString);
            }
            socket.close();

        }
        catch(Exception e){
            System.out.println(e);

        }
        

        
    } 
    public static void main(String[] args) {
        new Server().CreateServer(5000);
    }  
}
