import java.util.Date;

public class Order {
    private java.sql.Timestamp orderDate;
    private String firmName;
    private boolean isFilled;
    private int CustomerId;

    public Order(){}

    public Order(java.sql.Timestamp date, String firmName, boolean isFilled, int CustomerId){
        this.orderDate = date;
        this.firmName = firmName;
        this.isFilled = isFilled;
        this.CustomerId = CustomerId;
    }

    public java.sql.Timestamp getOrderDate() {
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
