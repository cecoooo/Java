import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.CancellationException;

public class NewClient implements Runnable{
    public Socket socket;

    public NewClient(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;
        try{
            Socket socket = this.socket;
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream.writeUTF("Enter username:");
            String username = dataInputStream.readUTF();
            dataOutputStream.writeUTF("Enter password:");
            String password = dataInputStream.readUTF();
            logIn(dataInputStream, dataOutputStream, username, password);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private synchronized void logIn(DataInputStream dataInputStream, DataOutputStream dataOutputStream, String username, String password){
        Object obj = new Object();
        boolean bool = true;
        try {
            while ((obj = Main.ois.readObject()) != null) {
                Main.oosHelp.writeObject(obj);
                if (obj instanceof Admin && ((Admin) obj).getUsername().equals(username) && ((Admin) obj).getPassword().equals(password)) {
                    createAccount(dataOutputStream, dataInputStream);
                    bool = false;
                } else if (obj instanceof Teacher && ((Teacher) obj).getPassword().equals(password) && ((Teacher) obj).getUsername().equals(username)) {
                    setGrade(dataInputStream, dataOutputStream);
                    bool = false;
                } else if (obj instanceof Student && ((Student) obj).getFnum().equals(username) && ((Student) obj).getEgn().equals(password)) {
                    dataOutputStream.writeUTF(getGrades(dataOutputStream, dataInputStream, username, password));
                    bool = false;
                }
            }
        }catch (IOException | ClassNotFoundException e){
            try{
                if(bool) dataOutputStream.writeUTF("Not found.\n" +
                        "Wrong username or password.");
                while((obj = Main.oisHelp.readObject()) != null)
                    Main.oos.writeObject(obj);
            }catch (IOException | ClassNotFoundException x){}
        }
    }


    private void createAccount(DataOutputStream dataOutputStream, DataInputStream dataInputStream){
        try {
            dataOutputStream.writeUTF("1");
            dataOutputStream.writeUTF("What kind of account you want to create:\n" +
                    "Admin, Teacher or Student?");
            switch (dataInputStream.readUTF()) {
                case "Admin" -> {
                    Admin admin = new Admin();
                    dataOutputStream.writeUTF("Username:");
                    String username = dataInputStream.readUTF();
                    dataOutputStream.writeUTF("Password:");
                    String password = dataInputStream.readUTF();
                    try {
                        admin.setUserName(username);
                        admin.setPassword(password);
                        Main.oos.writeObject(admin);
                        dataOutputStream.writeUTF("Created.");
                    }catch (InvalidUsernameException | InvalidPasswordException x) {
                        x.printStackTrace();
                        dataOutputStream.writeUTF(x.getMessage());
                    }
                }
                case "Teacher" -> {
                    Teacher teacher = new Teacher();
                    dataOutputStream.writeUTF("Username:");
                    String username = dataInputStream.readUTF();
                    dataOutputStream.writeUTF("Password:");
                    String password = dataInputStream.readUTF();
                    try {
                        teacher.setUserName(username);
                        teacher.setPassword(password);
                        Main.oos.writeObject(teacher);
                        dataOutputStream.writeUTF("Created.");
                    }catch (InvalidUsernameException | InvalidPasswordException x) {
                        x.printStackTrace();
                        dataOutputStream.writeUTF(x.getMessage());
                    }
                }
                case "Student" -> {
                    Student student = new Student();
                    dataOutputStream.writeUTF("Set faculty number of the Student:");
                    String fnum = dataInputStream.readUTF();
                    dataOutputStream.writeUTF("Set EGN of the Student:");
                    String egn = dataInputStream.readUTF();
                    try {
                        student.setFnum(fnum);
                        student.setEgn(egn);
                        Main.oos.writeObject(student);
                        dataOutputStream.writeUTF("Created.");
                    }catch (InvalidFacultyNumberException | InvalidEGNException x){
                        x.printStackTrace();
                        dataOutputStream.writeUTF(x.getMessage());
                    }
                }
                default -> dataOutputStream.writeUTF("Unrecognized input.");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private synchronized void setGrade(DataInputStream dataInputStream, DataOutputStream dataOutputStream){
        try {
            dataOutputStream.writeUTF("2");
            dataOutputStream.writeUTF("Enter Student's faculty number:");
            String fnum = dataInputStream.readUTF();
            Object obj = new Object();
            try{
                while((obj = Main.ois.readObject()) != null){
                    if(obj instanceof Student){
                        if(((Student) obj).getFnum().equals(fnum)){
                            Grade grade = new Grade();
                            dataOutputStream.writeUTF("Input subject:");
                            grade.setSubject(dataInputStream.readUTF());
                            dataOutputStream.writeUTF("Set number of semester:");
                            grade.setSemester(Integer.parseInt(dataInputStream.readUTF()));
                            dataOutputStream.writeUTF("Input grade:");
                            grade.setGrade(Integer.parseInt(dataInputStream.readUTF()));
                            ((Student) obj).addGrade(grade);
                        }
                    }
                    Main.oosHelp.writeObject(obj);
                }
            }catch (IOException | ClassNotFoundException e){
                try{
                    while ((obj = Main.oisHelp.readObject()) != null){
                        Main.oos.writeObject(obj);
                    }
                }catch (IOException | ClassNotFoundException x) {}
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private String getGrades(DataOutputStream dataOutputStream, DataInputStream dataInputStream, String fnum, String egn){
        StringBuilder res = new StringBuilder();
        Object obj = new Object();
        try {
            while ((obj = Main.ois.readObject()) != null) {
                if(obj instanceof Student && ((Student) obj).getFnum().equals(fnum) && ((Student) obj).getEgn().equals(egn)){
                    Student student = (Student) obj;
                    for (int i = 0; i < student.getGrades().size(); i++){
                        res.append(student.getGrades().get(i).toString()).append("\n");
                    }
                }
                Main.oosHelp.writeObject(obj);
            }
        }catch (IOException | ClassNotFoundException e){
            try{
                while((obj = Main.oisHelp.readObject()) != null){
                    Main.oos.writeObject(obj);
                }
            }catch (IOException | ClassNotFoundException x){}
        }
        return res.toString();
    }
}
