public class Electronics extends Product{

    private String manufacturer;
    private String model;

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Electronics(){

    }
    public Electronics(String manufacturer, String model){
        this.manufacturer = manufacturer;
        this.model = model;
    }

    @Override
    double getPromotionalPrice() {
        return this.getPrice()*0.9;
    }

    @Override
    boolean sellProduct(int piece) {
        int remain = this.getQuantity() - piece;
        if(remain >= 0)
            return true;
        try{
            throw new NoMoreProductsException();
        }catch (NoMoreProductsException e){
            e.printStackTrace();
        }
        return false;
    }
}
