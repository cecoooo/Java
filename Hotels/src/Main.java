import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main implements Runnable{


    public static ArrayList<User> users = new ArrayList<>();
    public static FileOutputStream fos = null;
    public static ObjectOutputStream oos = null;
    public static FileInputStream fis = null;
    public static ObjectInputStream ois = null;

    static {
        try{
            fos = new FileOutputStream("C:\\Users\\User\\Desktop\\database.bin");
            oos = new ObjectOutputStream(fos);
            fis = new FileInputStream("C:\\Users\\User\\Desktop\\database.bin");
            ois = new ObjectInputStream(fis);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

//    public static FileInputStream fis = new FileInputStream("database.bin");
//    public static ObjectInputStream ois = new ObjectInputStream(fis);
//    public static FileOutputStream fos = new FileOutputStream("database.bin");
//    public static ObjectOutputStream oos = new ObjectOutputStream(fos);

    private Socket socket=null;
    public Main(Socket socket){
        this.socket = socket;
    }

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try{
            serverSocket = new ServerSocket(1234);
            while(true){
                socket = serverSocket.accept();
                Thread thread = new Thread(new Main(socket));
                thread.start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(serverSocket != null) serverSocket.close();
                if(socket != null) socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;
        try{
            Socket socket = this.socket;
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream.writeUTF("Reservation or rating?");
            String answ = dataInputStream.readUTF();
            if(answ.equals("reservation")){
                reservation(dataOutputStream, dataInputStream);
            }
            else {
                rating(dataOutputStream, dataInputStream);
            }
        }catch (IOException e){}
    }

    private synchronized void reservation(DataOutputStream dataOutputStream, DataInputStream dataInputStream){
        try {
            dataOutputStream.writeUTF("Enter your destination:");
            String dest = dataInputStream.readUTF();
            StringBuilder stringBuilder = new StringBuilder();
            Offert offert = new Offert();
            try{
                while((offert = (Offert) ois.readObject()) != null){
                    if(offert.getDestination().equals(dest)){
                        stringBuilder.append(offert.toString()).append("\n");
                    }
                }
            }catch (IOException | ClassNotFoundException x){
                dataOutputStream.writeUTF(stringBuilder.toString());
                int id = Integer.parseInt(dataInputStream.readUTF());
                User user = new User();
                dataOutputStream.writeUTF("Enter you email:");
                String email = dataInputStream.readUTF();
                dataOutputStream.writeUTF("Enter your password:");
                String pass = dataInputStream.readUTF();
                Grade grade = new Grade();
                grade.setOfferetId(id);
                user.setEmail(email);
                user.setPass(pass);
                user.setGrades(grade);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private synchronized void rating(DataOutputStream dataOutputStream, DataInputStream dataInputStream){
        try {
            dataOutputStream.writeUTF("Send offerId:");
            int id = Integer.parseInt(dataInputStream.readUTF());
            dataOutputStream.writeUTF("Enter you email:");
            String email = dataInputStream.readUTF();
            dataOutputStream.writeUTF("Enter your password:");
            String pass = dataInputStream.readUTF();
            double grade = 0;
            for (int i = 0; i < users.size(); i++){
                if(users.get(i).getEmail().equals(email) && users.get(i).getPass().equals(pass)){
                    User user = users.get(i);
                    for (int j = 0; j < user.getGrades().size(); j++){
                        if(user.getGrades().get(j).getOfferetId() == id && !user.getGrades().get(j).isEvaluation()){
                            user.getGrades().get(j).setEvaluation(true);
                            dataOutputStream.writeUTF("Enter your grade:");
                            grade = Double.parseDouble(dataInputStream.readUTF());
                        }
                    }
                }
            }
            Offert offert = new Offert();
            try {
                while ((offert = (Offert) ois.readObject()) != null) {
                    if(offert.getOffertId() == id)
                        offert.setEvaluation(grade);
                }
            }catch (IOException | ClassNotFoundException e){}
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}