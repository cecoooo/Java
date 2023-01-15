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
            fos = new FileOutputStream("C:\\Users\\User\\Desktop\\разни\\UISS.ser");
            oos = new ObjectOutputStream(fos);
            fis = new FileInputStream("C:\\Users\\User\\Desktop\\разни\\UISS.ser");
            ois = new ObjectInputStream(fis);
            fosHelp = new FileOutputStream("C:\\Users\\User\\Desktop\\разни\\UISSHelp.ser");
            oosHelp = new ObjectOutputStream(fosHelp);
            fisHelp = new FileInputStream("C:\\Users\\User\\Desktop\\разни\\UISSHelp.ser");
            oisHelp = new ObjectInputStream(fisHelp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try{
            Admin admin = new Admin();
            try {
                admin.setUserName("admin@tu-sofia.bg");
                admin.setPassword("11111");
            }catch (InvalidPasswordException | InvalidUsernameException e){
                e.printStackTrace();
            }
            oos.writeObject(admin);
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
                if(serverSocket != null) serverSocket.close();
                if(socket != null) socket.close();
                if(fis != null) fis.close();
                if(ois != null) ois.close();
                if(fos != null) fos.close();
                if(oos != null) oos.close();
                if(fisHelp != null) fisHelp.close();
                if(oisHelp != null) oisHelp.close();
                if(fosHelp != null) fosHelp.close();
                if(oosHelp != null) oosHelp.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}