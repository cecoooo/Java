import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        User user = new User();
        user.setPassword("fergeraret");
        user.setNickName("vfdbvsvre@gmial.com");
        File file = new File("Desktop\\database.txt");
        Boolean bool1 = CheckInDatabase(file, "vfdbvsvre@gmial.com", "fergeraret");
        Boolean bool2 = CheckInDatabase(file, "vfdbvre@gmial.com", "fergeet");
        System.out.println(bool1);
        System.out.println(bool2);
    }

    static Boolean CheckInDatabase(File file, String nickName, String password){
        Boolean res = false;
        try{
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNextLine()){
                String[] line = fileReader.nextLine().split("/");
                if(line[0] == nickName && line[1] == password)
                    res = true;
            }
        }catch (IOException e){
            System.out.println("An Error occurred.");
        }
        return res;
    }
}