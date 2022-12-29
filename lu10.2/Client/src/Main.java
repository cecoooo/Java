import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        Socket socket = null;
        DataOutputStream dataOutputStream = null;
        try{
            socket = new Socket("localhost", 5000);
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF("Message2 from Client1");
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(socket != null) socket.close();
                if(dataOutputStream != null) dataOutputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}