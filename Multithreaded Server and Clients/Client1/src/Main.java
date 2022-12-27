import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Main<T> {
    private static void printFromServer(DataInputStream dataInputStream){
        try {
            System.out.println(dataInputStream.readUTF());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private static<T> void print(T data){
        System.out.print(data);
    }
    private static<T> void println(T data){
        System.out.println(data);
    }

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Socket socket = null;
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;
        try {
            socket = new Socket("localhost", 130);
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            printFromServer(dataInputStream);
            String firstRequest = scanner.nextLine();
            dataOutputStream.writeUTF(firstRequest);
            String answer = dataInputStream.readUTF();
            if(answer.equals("create")){
                CreateProfile(socket);
            } else if (answer.equals("login")) {
                LogIntoProfile(socket);
            }
            else System.out.println(answer);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(socket != null) socket.close();
                if(dataOutputStream != null) dataOutputStream.close();
                if(dataInputStream != null) dataInputStream.close();
            }catch (IOException e){
                System.out.println("Something wrong with connection closing...");
                e.printStackTrace();
            }
        }
    }

    private static void CreateProfile(Socket socket){
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;
        try{
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            printFromServer(dataInputStream);
            print("Username: ");
            dataOutputStream.writeUTF(scanner.nextLine());
            print("Password: ");
            dataOutputStream.writeUTF(scanner.nextLine());
            print("First name: ");
            dataOutputStream.writeUTF(scanner.nextLine());
            print("Last name: ");
            dataOutputStream.writeUTF(scanner.nextLine());
            print("Age: ");
            dataOutputStream.writeUTF(scanner.nextLine());
            print("Phone: ");
            dataOutputStream.writeUTF(scanner.nextLine());
            printFromServer(dataInputStream);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (dataInputStream != null) dataOutputStream.close();
                if(dataOutputStream != null) dataOutputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private static void LogIntoProfile(Socket socket){
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;
        try{
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            printFromServer(dataInputStream);
            print("Username: ");
            dataOutputStream.writeUTF(scanner.nextLine());
            print("Password: ");
            dataOutputStream.writeUTF(scanner.nextLine());
            printFromServer(dataInputStream);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (dataInputStream != null) dataOutputStream.close();
                if(dataOutputStream != null) dataOutputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}