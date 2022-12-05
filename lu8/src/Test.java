import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Product1 p1 = new Product1("Dron", 100, 12, 10);
        Product2 p2 = new Product2("Raketa", 150, 12, 5);
        Product3 p3 = new Product3("Piron", 10, 2, 50);
        ArrayList<GetProductsTo> list1 = new ArrayList<>();
        ArrayList<DeliveryAPI> list2 = new ArrayList<>();
        list1.add(p1);
        list2.add(p1);

        PresentStore presentStore = new PresentStore(list1, list2);
        presentStore.getProductPrice(120);
        presentStore.getAllProducts(12);

    }


}