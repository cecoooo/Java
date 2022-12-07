public abstract class Product {
    private String inventoryNumber;
    private double price;
    private int quantity;
    private Provider provider;

    public String getInventoryNumber() {
        return inventoryNumber;
    }
    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Provider getProvider() {
        return provider;
    }
    public void setProvider(Provider provider) {
        this.provider = provider;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product() {
    }
    public Product(String in, double price, int quantity, Provider provider) {
        this.inventoryNumber = in;
        this.price = price;
        this.quantity = quantity;
        this.provider = provider;
    }

    abstract double getPromotionalPrice();
    abstract boolean  sellProduct(int piece);
}
