import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Voter voter1 = new Voter("Gosho", "Sofia", "blabla", "blabla1");
        Voter voter2 = new Voter("Tosho", "Similtli", "1blabla", "2blabla1");
        Voter voter3 = new Voter("Iosho", "Mikre", "4blabla", "3blabla1");
        Voter voter4 = new Voter("Pesho", "Golqm Izvor", "5blabla", "6blabla1");
        Voter voter5 = new Voter("Tisho", "Sofia", "7blabla", "8blabla1");
        Voter voter6 = new Voter("Misho", "Chomakovci", "9blabla", "0blabla1");
        Voter voter7 = new Voter("Evlogi", "Sofia", "-5blabla", "-3blabla1");
        List<Voter> list = new ArrayList<>();
        list.add(voter1);
        list.add(voter2);
        list.add(voter3);
        list.add(voter4);
        list.add(voter5);
        list.add(voter6);
        list.add(voter7);
        list = list.stream().
                filter(v ->v.getCity().equals("Sofia")).
                sorted(Comparator.comparing(Voter::getStreet).thenComparing(Voter::getAddress)).
                collect(Collectors.toList());

        for(int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i).ToString());
        }
    }
}