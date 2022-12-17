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
        return this.number;
    }

    @Override
    public String getType(int idOfProvider) {
        return this.type;
    }

    @Override
    public int getIdOfProvider() {
        return this.idOfProvider;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getType() {
        return this.type;
    }

    public String toString(){
        return this.type + "\n"+
                this.price + "\n"+
                this.idOfProvider+ "\n"+
                this.number;
    }
}
