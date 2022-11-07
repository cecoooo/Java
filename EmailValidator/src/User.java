import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class User implements validator{
    private String nickName;
    private String password;

    public void setNickName(String nickName) {
        if(nickName.contains("@gmail.com") && !nickName.contains("/")){
            String nick = nickName.split("@")[0];
            if(nick.length() > 2 && nick.length() < 21 && checkForRepetition(nickName)){
                this.nickName = nickName;
                try{
                    File database = new File("C:\\Users\\User\\Desktop\\PushToGithub\\java\\EmailValidator\\emailsDataBase.txt");
                    database.createNewFile();
                    FileWriter writer = new FileWriter("C:\\Users\\User\\Desktop\\PushToGithub\\java\\EmailValidator\\emailsDataBase.txt");
                    writer.write("\n" + this.nickName);
                    return;
                }
                catch (IOException e){
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
            try{
                this.checking();
            }
            catch (Exception e){
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }
    public void setPassword(String pass){
        if(pass.contains("@gmail.com") && !pass.contains("/")){
            String nick = nickName.split("@")[0];
            if(nick.length() > 2 && nick.length() < 21 && checkForRepetition(nickName)){
                this.nickName = nickName;
                try{
                    File database = new File("C:\\Users\\User\\Desktop\\PushToGithub\\java\\EmailValidator\\emailsDataBase.txt");
                    database.createNewFile();
                    FileWriter writer = new FileWriter("C:\\Users\\User\\Desktop\\PushToGithub\\java\\EmailValidator\\emailsDataBase.txt");
                    writer.write("\n" + this.nickName);
                    return;
                }
                catch (IOException e){
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
            try{
                this.checking();
            }
            catch (Exception e){
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        public String getNickName(){
            return this.nickName;
        }
        public String getPassword(){
            return this.password;
        }

        public void checking() throws Exception{
            throw new Exception("Invalid nickname or password.");
        }

        private Boolean checkForRepetition(String nick){
            Boolean isValid = true;
            try {
                File file = new File("C:\\Users\\User\\Desktop\\PushToGithub\\java\\EmailValidator\\emailsDataBase.txt");
                Scanner fileReader = new Scanner(file);
                while(fileReader.hasNextLine()){
                    String email = fileReader.nextLine().split("/")[0];
                    if(email == nick)
                        isValid = false;
                }
            }
            catch (IOException e){
                System.out.println("Occurred error with the stream");
                e.printStackTrace();
            }
            return isValid;
        }
    }
