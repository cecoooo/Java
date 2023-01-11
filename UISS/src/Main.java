import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try{
            serverSocket = new ServerSocket(130);
            while(true) {
                socket = serverSocket.accept();
                Thread client = new Thread(new User(socket));
                client.start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        finally{
            try{
                if(serverSocket != null) serverSocket.close();
                if(socket != null) socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}