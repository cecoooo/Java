public abstract class Product {
    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    String inventoryNumber;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    double price;

    public Product() {
    }

    public Product(String in, double price, int quantity, Provider provider) {
        this.inventoryNumber = in;
        this.price = price;
        this.quantity = quantity;
        this.provider = provider;
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

    int quantity;
    Provider provider;

    abstract double getPromotionalPrice();

    abstract boolean  sellProduct(int piece);
}
