import java.net.Socket;
import java.util.Scanner;

public class newClient implements Runnable {

    private Socket s;
    private Scanner sc = new Scanner(System.in);
    private void print(Object text){
        System.out.print(text);
    }
    private void println(Object text){
        System.out.println(text);
    }

    public newClient(Socket socket){
        this.s = socket;
    }

    @Override
    public void run() {
        println("Hello!\nPress 0 for login\nPress 1 for sign up.");
        String start = sc.nextLine();
        switch (start){
            case "0":
                login();
                break;
            case "1":
                setup();
                break;
            default: println("Incorrect input! System accepts only '0' and '1' as respond.");
        }
    }

    private void login(){

    }
    private void setup(){
        println("Enter Username:");
    }
}
