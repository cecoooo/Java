import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static ArrayList<String> tickets = new ArrayList<>();
    public static ArrayList<String> resolvedTickets = new ArrayList<>();

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try{
            serverSocket = new ServerSocket(5000);
            while(true){
                socket = serverSocket.accept();
                Thread thread = new Thread(new SupportStaff(socket));
                thread.run();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (serverSocket != null) serverSocket.close();
                if (socket != null) socket.close();
            }catch (IOException e){
                System.out.println("Something wrong with closing Socket and ServerSocket.");
                e.printStackTrace();
            }
        }
    }
}