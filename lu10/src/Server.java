import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args){
        ServerSocket serverSocket;
        ArrayList<String> listOfTickets = new ArrayList<>();

        try {
            serverSocket = new ServerSocket(1234);
            serverSocket.setReuseAddress(true);

            while(true){
                Socket socket = serverSocket.accept();
                ServerResponse serverResponse = new ServerResponse(socket);
                listOfTickets.addAll(serverResponse.returnList());
                Thread.sleep(1000);
                ObjectOutputStream objectOutputStream =  new ObjectOutputStream(socket.getOutputStream());
                int ticketNumber = serverResponse.returnIdxOfMessage();
                objectOutputStream.writeObject("Ticket number " + ticketNumber+ "has been handled");
                objectOutputStream.close();
                socket.close();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}