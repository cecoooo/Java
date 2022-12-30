import java.io.*;
import java.net.Socket;

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
            else if(firstResponse.equalsIgnoreCase("private-info")){
                User user = null;
                StringBuilder stringBuilder = new StringBuilder("Private data from database\n" +
                        "All usernames:\n");
                try {
                    while ((user = (User) Main.ois.readObject()) != null) {
                        Main.oosHelp.writeObject(user);
                        stringBuilder.append(user.getUsername()).append("\n");
                    }
                }catch (IOException | ClassNotFoundException e){
                    dataOutputStream.writeUTF(stringBuilder.toString());
                    try {
                        while ((user = (User) Main.oisHelp.readObject()) != null) {
                            Main.oos.writeObject(user);
                        }
                    }catch (ClassNotFoundException i){}
                }
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
        User user = null;
        boolean isNotLoged = true;
        try{
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF("Enter password and username.");
            String username = dataInputStream.readUTF();
            String password = dataInputStream.readUTF();
            while((user = (User) Main.ois.readObject()) != null){
                Main.oosHelp.writeObject(user);
                if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    dataOutputStream.writeUTF("You are sign-in!");
                    isNotLoged = false;
                }
            }
        }catch (IOException | ClassNotFoundException e){
            try{
                while((user = (User) Main.oisHelp.readObject()) != null){
                    Main.oos.writeObject(user);
                }
            }catch (IOException | ClassNotFoundException i){}
        } finally {
            try {
                if(isNotLoged) dataOutputStream.writeUTF("Wrong password or username!\n" +
                        "Your access is still blocked.");
                if(dataInputStream != null) dataInputStream.close();
                if(dataOutputStream != null) dataOutputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private void CreateProfile(Socket socket){
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = null;
        User user = new User();
        boolean isTrue = true;
        try{
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF("Fulfill all data below.");
            String username = dataInputStream.readUTF();
            String password = dataInputStream.readUTF();
            String fname = dataInputStream.readUTF();
            String lname = dataInputStream.readUTF();
            int age = Integer.parseInt(dataInputStream.readUTF());
            String phone = dataInputStream.readUTF();
            try {
                user.setUsername(username);
                if(user.getUsername().equals("")) throw new InvalidUsernameException();
                user.setPassword(password);
                if(user.getPassword().equals("")) throw new InvalidPasswordException();
                user.setFirstName(fname);
                if(user.getFirstName().equals("")) throw new InvalidFirstOrLastNameException();
                user.setLastName(lname);
                if(user.getLastName().equals("")) throw new InvalidFirstOrLastNameException();
                user.setAge(age);
                if(user.getAge() == 0) throw new InvalidAgeException();
                user.setPhone(phone);
                if(user.getPhone().equals("")) throw new InvalidPhoneException();
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
            isTrue = VerificationForRepetition(username);
        }catch (IOException e){}
        finally {
            try {
                if (isTrue) {
                    Main.oos.writeObject(user);
                    Main.oos.flush();
                    dataOutputStream.writeUTF("Your account has been just created!");
                }
                else dataOutputStream.writeUTF("This username is not already free.");
            }catch (IOException i){
                i.printStackTrace();
            }
            try {
                if(dataInputStream != null) dataInputStream.close();
                if(dataOutputStream != null) dataOutputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private boolean VerificationForRepetition(String username){
        boolean isTrue = true;
        try{
            User testUser = null;
            while((testUser = (User) Main.ois.readObject()) != null){
                Main.oosHelp.writeObject(testUser);
                if(testUser.getUsername().equals(username)) isTrue = false;
            }
        }catch (IOException | ClassNotFoundException e){
            try {
                User testUser = null;
                while ((testUser = (User) Main.oisHelp.readObject()) != null) {
                    Main.oos.writeObject(testUser);
                }
            }catch (IOException | ClassNotFoundException i){
                return isTrue;
            }
            return isTrue;
        }
        return isTrue;
    }
}
