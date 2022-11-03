import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class User implements validator{
    private String nickName;
    private String password;

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public void setPassword(String pass){
        this.password = pass;
    }
    public String getNickName(){
        return this.nickName;
    }
    public String getPassword(){
        return this.password;
    }

    public void checking() throws Exception, IOException{
        if(this.nickName.contains("@gmail.com") && !this.nickName.contains("/") && !this.password.contains("/")){
            String nick = this.nickName.split("@")[0];
            if(nick.length() > 2 && nick.length() < 21){
                try{
                    File database = new File("C:\\Users\\User\\Desktop\\PushToGithub\\java\\EmailValidator\\emailsDataBase.txt");
                    database.createNewFile();
                    FileWriter writer = new FileWriter("C:\\Users\\User\\Desktop\\PushToGithub\\java\\EmailValidator\\emailsDataBase.txt");
                    writer.write(this.nickName + "/" + this.password + "\n");
                    return;
                }
                catch (IOException e){
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
        }
        throw new Exception("Invalid nickname or password.");
    }
}
