import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;

public class SupportStaff implements Runnable{
    private Socket socket;
    public SupportStaff(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        Socket socket = this.socket;
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(socket.getInputStream());
            Main.tickets.add(dataInputStream.readUTF());
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            Response();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(socket != null) socket.close();
                if(dataInputStream != null) dataInputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    private synchronized void Response(){
        Random rand = new Random();
        int random = rand.nextInt(Main.tickets.size());
        String mess = Main.tickets.get(random);
        Main.tickets.remove(random);
        AddToResolved(mess);
    }

    private void AddToResolved(String mess){
        Main.resolvedTickets.add(mess);
    }
}
