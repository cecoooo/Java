import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerResponse implements Runnable{

    private Socket socket;
    private ArrayList<String> list;
    String message;

    public ServerResponse(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            message = (String) objectInputStream.readObject();
            list.add(message);
        } catch (IOException | ClassNotFoundException  e) {
            e.printStackTrace();
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public ArrayList<String> returnList(){
        return list;
    }

    public int returnIdxOfMessage(){
        return list.indexOf(message);
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
