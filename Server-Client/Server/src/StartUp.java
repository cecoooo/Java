import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class StartUp {
    public static void main(String[] args) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Socket socket = null;
        PrintWriter printWriter = null;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(80);
            socket = serverSocket.accept();
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("Connection done!");
            Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(socket.getInputStream())));
            System.out.println(scanner.nextLine());
            String fileName = scanner.nextLine();
            fis = new FileInputStream(fileName);
            ois = new ObjectInputStream(fis);
            FootballClub club = new FootballClub();
            while((club = (FootballClub) ois.readObject()) != null){
                System.out.println(club.toString());
            }
        }catch (IOException e){
            try{
                fis.close();
                socket.close();
                serverSocket.close();
                printWriter.close();
                ois.close();
            }catch (IOException i){
                i.printStackTrace();
            }
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}