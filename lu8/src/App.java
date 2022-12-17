import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Product1 p1 = new Product1("Dron", 100, 12, 10);
        Product2 p2 = new Product2("Raketa", 150, 12, 5);
        Product3 p3 = new Product3("Piron", 10, 2, 50);
        ArrayList<GetProductsTo> list1 = new ArrayList<>();
        ArrayList<DeliveryAPI> list2 = new ArrayList<>();
        list1.add(p1);
        list2.add(p1);
        list1.add(p2);
        list2.add(p2);
        list1.add(p3);
        list2.add(p3);

        PresentStore presentStore = new PresentStore(list1, list2);
        ArrayList<GetProductsTo> byPrice = presentStore.CheaperThan(120);
        ArrayList<DeliveryAPI> byID = presentStore.SelectByID(12);

        for (int i = 0; i < byPrice.size(); i++){
            System.out.println(byPrice.get(i).toString());
        }
        for (int i = 0; i < byID.size(); i++){
            System.out.println(byID.get(i).toString());
        }
    }
}