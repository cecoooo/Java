public class Product3 implements DeliveryAPI, GetProductsTo {
    public String type;
    public double price;
    public int idOfProvider;
    public int number;

    public Product3(){

    }
    public Product3(String type, double price, int id, int num){
        this.type = type;
        this.price = price;
        this.idOfProvider = id;
        this.number = num;
    }

    @Override
    public int getNumber(int idOfProvider) {
        return 0;
    }

    @Override
    public String getType(int idOfProvider) {
        return null;
    }

    @Override
    public int getIdOfProvider() {
        return 0;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getType() {
        return null;
    }
}
