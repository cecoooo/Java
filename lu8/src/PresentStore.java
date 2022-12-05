import java.security.DigestException;
import java.util.ArrayList;

public class PresentStore {
    ArrayList<GetProductsTo> products;
    ArrayList<DeliveryAPI> devApi;

    public PresentStore(){

    }
    public PresentStore(ArrayList<GetProductsTo> list1, ArrayList<DeliveryAPI> list2){
        this.products = list1;
        this.devApi = list2;
    }

    public ArrayList<GetProductsTo> getProductPrice(double maxPrice){
        ArrayList<GetProductsTo> list = new ArrayList<>();
        for(GetProductsTo product: products){
            if(product.getPrice()<maxPrice){
                list.add(product);
            }
        }
        return list;
    }

    public ArrayList<DeliveryAPI> getAllProducts(int id){
        ArrayList<DeliveryAPI> list = new ArrayList<>();
        for(DeliveryAPI deliveryAPI : devApi){
            if(deliveryAPI.getIdOfProvider()==id){
                list.add(deliveryAPI);
            }
        }
        return list;
    }
}