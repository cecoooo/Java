import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String arg[]){
        Socket connection = null;
        Scanner socketIn = null;
        PrintWriter socketOut = null;
        Scanner keyBoard = new Scanner(System.in);
        int port = 1234;
        String host = "localhost";
        try{
            System.out.println("Очаквам свързване със сървъра");
            try {
                connection = new Socket(host, port);
            } catch (ConnectException e) {
                System.err.println("Не мога да осъществя връзка със сървъра");
                return;
            }
            System.out.println("Свързването със сървъра беше успешно!");

            System.out.println("Приемам първоначално съобщение от сървъра...");
            socketIn = new Scanner(new BufferedReader(new InputStreamReader(connection.getInputStream())));
            System.out.println("Съобщението е: " + socketIn.nextLine());

            String command = null;
            socketOut = new PrintWriter(connection.getOutputStream(), true);
            do {
                socketOut.flush();
                System.out.print("Въведете команда: ");
                command = keyBoard.nextLine();
                socketOut.println(command.toLowerCase());

                System.out.println("Изчакване на отговор от сървъра...");
                String answer = socketIn.nextLine();
                System.out.println("Сървърът отговори: " + answer);
            } while (!command.equalsIgnoreCase("exit"));
            System.out.println("Затваряне на връзката...");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (socketIn != null)
                    socketIn.close();
                if (socketOut != null)
                    socketOut.close();
                if (connection != null)
                    connection.close();
                keyBoard.close();
            } catch (IOException e) {
                System.err.println("Сокета не може да се затвори");
            }
        }
//        try {
//            Socket socket = new Socket("localhost", 1234);
//            Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(socket.getInputStream())));
//            System.out.println(scanner.nextLine());
//            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//            out.println("Second Message (from Client to Server)...");
//            String line = "";
//            Scanner sc = new Scanner(System.in);
//            while(!line.equalsIgnoreCase("stop")){
//                line = sc.nextLine();
//                out.println(line);
//                out.flush();
//            }
//            System.out.println("Process finished.");
//            socket.close();
//            out.close();
//            sc.close();
//            System.out.println("Connection closed.");
//        }catch (IOException e){
//            e.printStackTrace();
//        }
    }
}