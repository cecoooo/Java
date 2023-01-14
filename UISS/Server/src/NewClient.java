import java.net.Socket;

public class NewClient implements Runnable{
    public Socket socket;

    public NewClient(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {

    }
}
