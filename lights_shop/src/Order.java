import java.util.Date;

public class Order {
    private java.sql.Date orderDate;
    private String firmName;
    private boolean isFilled;
    private int CustomerId;

    public Order(){}

    public Order(java.sql.Date date, String firmName, boolean isFilled, int CustomerId){
        this.orderDate = date;
        this.firmName = firmName;
        this.isFilled = isFilled;
        this.CustomerId = CustomerId;
    }

    public java.sql.Date getOrderDate() {
        return orderDate;
    }

    public String getFirmName() {
        return firmName;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public int getCustomerId() {
        return CustomerId;
    }
}
