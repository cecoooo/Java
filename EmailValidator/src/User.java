import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class User implements validator{
    private String nickName;
    private String password = "whJh!YM@HQDSCe*2";

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
        checking(nickName);
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void checking(String nick){
        if(this.nickName.contains("@gmail.com")){
            this.nickName = nick;
            try{
                FileWriter file = new FileWriter("Desktop\\database.txt");
                file.write(this.nickName + "/" +this.password);
            }catch (IOException e){
                System.out.println("Error occurred.");
            }

        }
        else{
            try {
                throw new InvalidEmailException("Email was invalid.");
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
