import javax.xml.crypto.Data;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class NewClient implements Runnable{
    private Socket socket = null;

    public NewClient(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        Socket socket = this.socket;
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = null;
        try{
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF("==What do you want to do?==\n" +
                   "Return as response 'sign-up' or 'sign-in'.");
            String firstResponse = dataInputStream.readUTF();
            if(firstResponse.equalsIgnoreCase("sign-up")){
                dataOutputStream.writeUTF("create");
                CreateProfile(socket);
            } else if (firstResponse.equalsIgnoreCase("sign-in")) {
                dataOutputStream.writeUTF("login");
                LogIntoProfile(socket);
            }
            else{
                try {
                    throw new InvalidResponceException();
                }catch (InvalidResponceException e){
                    dataOutputStream.writeUTF(e.getMessage());
                }
            }
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

    private void LogIntoProfile(Socket socket){
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        User user = new User();
        boolean isNotLoged = true;
        try{
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF("Enter password and username.");
            String password = dataInputStream.readUTF();
            String username = dataInputStream.readUTF();
            fis = new FileInputStream("C:\\Users\\User\\Desktop\\MultithreadedServerDatabase.ser");
            ois = new ObjectInputStream(fis);
            while((user = (User) ois.readObject()) != null){
                if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    dataOutputStream.writeUTF("You are sign-in!");
                    isNotLoged = false;
                }
            }
        }catch (IOException | ClassNotFoundException e){} finally {
            try {
                if(isNotLoged) dataOutputStream.writeUTF("Wrong password or username!\n" +
                        "Your access is still blocked.");
                if(dataInputStream != null) dataInputStream.close();
                if(dataOutputStream != null) dataOutputStream.close();
                if(fis != null) fis.close();
                if(ois != null) ois.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private void CreateProfile(Socket socket){
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        User user = new User();
        try{
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF("Fulfill all data below.");
            String username = dataInputStream.readUTF();
            String password = dataInputStream.readUTF();
            String fname = dataInputStream.readUTF();;
            String lname = dataInputStream.readUTF();;
            int age = Integer.parseInt(dataInputStream.readUTF());
            String phone = dataInputStream.readUTF();
            try {
                user.setUsername(username);
                if(user.getUsername().equals("")) throw new InvalidUsernameException();
                user.setPassword(password);
                if(user.getUsername().equals("")) throw new InvalidPasswordException();
                user.setFirstName(fname);
                if(user.getUsername().equals("")) throw new InvalidFirstOrLastNameException();
                user.setLastName(lname);
                if(user.getUsername().equals("")) throw new InvalidFirstOrLastNameException();
                user.setAge(age);
                if(user.getUsername().equals("")) throw new InvalidAgeException();
                user.setPhone(phone);
                if(user.getUsername().equals("")) throw new InvalidPhoneException();
                dataOutputStream.writeUTF("Your account has been just created!");
            }catch (InvalidUsernameException e){
                dataOutputStream.writeUTF(e.getMessage());
            }catch (InvalidPasswordException e){
                dataOutputStream.writeUTF(e.getMessage());
            }catch (InvalidFirstOrLastNameException e){
                dataOutputStream.writeUTF(e.getMessage());
            }catch (InvalidAgeException e){
                dataOutputStream.writeUTF(e.getMessage());
            }catch (InvalidPhoneException e){
                dataOutputStream.writeUTF(e.getMessage());
            }
            fos = new FileOutputStream("C:\\Users\\User\\Desktop\\MultithreadedServerDatabase.ser");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(user);
            oos.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                if(dataInputStream != null) dataInputStream.close();
                if(dataOutputStream != null) dataOutputStream.close();
                if(fos != null) fos.close();
                if(oos != null) oos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
