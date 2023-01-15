import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Socket socket = null;
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = null;
        try{
            socket = new Socket("localhost", 5000);
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            System.out.println(dataInputStream.readUTF());
            dataOutputStream.writeUTF(sc.next());
            System.out.println(dataInputStream.readUTF());
            dataOutputStream.writeUTF(sc.next());
            String code = dataInputStream.readUTF();
            if(code.equals("1")) {
                System.out.println(dataInputStream.readUTF());
                dataOutputStream.writeUTF(sc.next());
                System.out.println(dataInputStream.readUTF());
                dataOutputStream.writeUTF(sc.next());
                System.out.println(dataInputStream.readUTF());
                dataOutputStream.writeUTF(sc.next());
                System.out.println(dataInputStream.readUTF());
            } else if (code.equals("2")) {
                System.out.println(dataInputStream.readUTF());
                dataOutputStream.writeUTF(sc.next());
                System.out.println(dataInputStream.readUTF());
                dataOutputStream.writeUTF(sc.next());
                System.out.println(dataInputStream.readUTF());
                dataOutputStream.writeUTF(sc.next());
                System.out.println(dataInputStream.readUTF());
                dataOutputStream.writeUTF(sc.next());
            }
            else if(code.equals("3")){
                System.out.println(dataInputStream.readUTF());
            }
            else{
                System.out.println(code);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try {
                if(dataOutputStream != null) dataOutputStream.close();
                if(dataInputStream != null) dataInputStream.close();
                if(socket != null) socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}