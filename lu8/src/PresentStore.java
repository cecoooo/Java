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

    public ArrayList<GetProductsTo> CheaperThan(double price){
        ArrayList<GetProductsTo> res = new ArrayList<>();
        for (int i = 0; i < this.products.size(); i++){
            if(this.products.get(i).getPrice() < price){
                res.add(this.products.get(i));
            }
        }
        return res;
    }

    public ArrayList<DeliveryAPI> SelectByID(int id){
        ArrayList<DeliveryAPI> res = new ArrayList<>();
        for (int i = 0; i < this.devApi.size(); i++){
            if(this.devApi.get(i).getIdOfProvider() == id){
                res.add(this.devApi.get(i));
            }
        }
        return res;
    }
}