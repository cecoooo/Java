import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try{
            serverSocket = new ServerSocket(5000);
            while (true){
                socket = serverSocket.accept();
                Thread thread = new Thread(new NewClient(socket));
                thread.start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                serverSocket.close();
                socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}