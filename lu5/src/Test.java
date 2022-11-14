// IF YOU WANT THIS APP RUNNING SUCCESSFULLY, FIRST CREATE NOTEPAD (.txt file) ON YOU DESKTOP, CALLED "database"!

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.print("What you want to do?\n" +
                "press 0 for log-in\n" +
                "press 1 for registration: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        if(num == 0){
            System.out.print("Enter username: ");
            String user = sc.nextLine();
            System.out.print("Enter password: ");
            String pass = sc.nextLine();
            String passFromDatabase = "";
            String userFromDatabase = "";
            try {
                boolean bool = false;
                File database = new File("C:\\Users\\User\\Desktop\\database.txt");
                Scanner reader = new Scanner(database);
                while (reader.hasNextLine()){
                    String line = reader.nextLine();
                    StringBuilder str = new StringBuilder(line);
                    int index1 = str.indexOf("/");
                    userFromDatabase = str.substring(0, index1);
                    str.delete(index1, index1+1);
                    int index2 = str.indexOf("/");
                   passFromDatabase = str.substring(index1, index2);
                    if(userFromDatabase.equals(user) && passFromDatabase.equals(pass)) {
                        bool = true;
                        break;
                    }
                }
                if(bool){
                    System.out.println("You are logged.");
                }
                else{
                   try {
                       throw new WrongUserException();
                   }catch (WrongUserException e){
                       e.printStackTrace();
                   }
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        else{
            System.out.print("Enter username: ");
            String username = sc.nextLine();
            System.out.print("Enter password: ");
            String pass = sc.nextLine();
            System.out.print("Enter phone number: ");
            String number = sc.nextLine();
            User user = new User(username, pass ,number);
            System.out.println("You are successfully registered!");
            user.saveToDatabase();
        }


    }
}