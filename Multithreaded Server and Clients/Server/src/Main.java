import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static FileInputStream fis;
    public static ObjectInputStream ois;
    public static FileOutputStream fos;
    public static ObjectOutputStream oos;
    public static FileInputStream fisHelp;
    public static ObjectInputStream oisHelp;
    public static FileOutputStream fosHelp;
    public static ObjectOutputStream oosHelp;

    static {
        try {
            fis = new FileInputStream("C:\\Users\\User\\Desktop\\MultithreadedServerDatabase.ser");
            ois = new ObjectInputStream(fis);
            fos = new FileOutputStream("C:\\Users\\User\\Desktop\\MultithreadedServerDatabase.ser");
            oos = new ObjectOutputStream(fos);
            fosHelp = new FileOutputStream("C:\\Users\\User\\Desktop\\MultithreadedServerDatabaseHelp.ser");
            oosHelp = new ObjectOutputStream(fosHelp);
            fisHelp = new FileInputStream("C:\\Users\\User\\Desktop\\MultithreadedServerDatabaseHelp.ser");
            oisHelp = new ObjectInputStream(fisHelp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try{
            serverSocket = new ServerSocket(130);
            while(true) {
                socket = serverSocket.accept();
                Thread client = new Thread(new NewClient(socket));
                client.start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        finally{
            try{
                if(serverSocket != null) serverSocket.close();
                if(socket != null) socket.close();
                if(fis != null) fis.close();
                if(ois != null) ois.close();
                if(fos != null) fos.close();
                if(oos != null) oos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}