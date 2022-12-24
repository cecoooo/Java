import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class StartUp {
    public static void main(String[] args) {
        FootballClub FCBarcelona = new FootballClub("FC Barcelona", "Joan Laporta", "Xavi", "Sergio Buskets", 1899);
        FootballClub PSG = new FootballClub("Paris Saint Germain", "Naser Al Khelaifi", "Christophe Galtier\n", "Marquinhos", 1970);
        FootballClub FCBayerMunich = new FootballClub("FC Bayern Munich", "Herbert Hainer", "Julian Nagelsmann", "Manuel Neuer", 1900);
        FootballClub Juventus = new FootballClub("Juventus", "Andrea Agnelli", "Massimiliano Allegri", "Leonardo Bonnucci", 1897);
        FootballClub ManchesterUnited = new FootballClub("Manchester United", "family Glazer", "Eric Ten Hag", "Hary Maguire", 1878);
        FootballClub Benfica = new FootballClub("FC Benfica", "Luís Filipe Vieira", "Roger Schmidt", "Nicolás Otamendi", 1904);
        FootballClub CSKASofia = new FootballClub("CSKA Sofia", "Grisha Ganchev", "Sasha Illich", "Jurgen Matei", 1948);
        String fileName = "C:\\Users\\User\\Desktop\\data.ser";
        ArrayList<FootballClub> list = new ArrayList<>();
        list.add(FCBarcelona);
        list.add(PSG);
        list.add(FCBayerMunich);
        list.add(Juventus);
        list.add(ManchesterUnited);
        list.add(Benfica);
        list.add(CSKASofia);
        try{
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            for(int i = 0; i < list.size(); i++){
                out.writeObject(list.get(i));
            }
            Socket socket = new Socket("localhost", 80);
            Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(socket.getInputStream())));
            System.out.println(scanner.nextLine());
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("Hello, Server!");
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println(fileName);
            fileOut.close();
            out.close();
            printWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}