import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hi! Do you want to answer some questions?");
        Scanner sc = new Scanner(System.in);
        String answ = sc.nextLine();
        if(answ == "no")
            return;
        String arr[] = new String[4];
        System.out.println("What's your name?");
        String name = sc.nextLine();
        arr[0] = name;
        System.out.println("Where are you from?");
        String home = sc.nextLine();
        arr[1] = home;
        System.out.println("How old are you?");
        String age = sc.nextLine();
        arr[2] = age;
        System.out.println("Do you have any siblings?");
        String siblings = sc.nextLine();
        arr[3] = siblings;
        System.out.print("Name: " + arr[0] + "\n");
        System.out.print("Birth place: " + arr[1] + "\n");
        System.out.print("Age: " + arr[2] + "\n");
        System.out.print("Any siblings: " + arr[3]);
    }
}