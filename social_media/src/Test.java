import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Test {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Socket s = null;
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(130);
            while (true) {
                s = ss.accept();
                Thread client = new Thread(new newClient(s));
                client.start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(ss!=null) ss.close();
                if(s!=null) s.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}