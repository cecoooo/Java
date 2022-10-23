import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Hello! Here you can reserve date and hour for your pet.\n" +
                "To check free hours, press 1;\n" +
                "To save reserve an hour, press 2;");
        int num = sc.nextInt();
        String[] arr = new String[]{
                "Monday 18:00",
                "Tuesday 11:00",
                "Wednesday 13:45",
                "Thursday 9:30",
                "Friday 11:20"
        };

        if(num == 1){
            for(int i = 0; i < 5; i++){
                System.out.println(arr[i]);
            }
        }
        else{
            System.out.println("Enter day you want:");
            String day = sc.next();
            System.out.println("Enter date time you want:");
            String time = sc.next();
            System.out.println("Enter what it the type of your pet:");
            String petType = sc.next();
            String res = "You are ready!\n You reserved hour for your " + petType + " at " + time + " on " + day;
            System.out.println(res);
        }
    }
}