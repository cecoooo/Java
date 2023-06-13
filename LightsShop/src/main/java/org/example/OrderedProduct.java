package org.example;

public class OrderedProduct {
    private int quantity;
    private int modelId;
    private int orderId;

    public OrderedProduct() {
    }

    public OrderedProduct(int quantity, int modelId, int orderId) {
        this.quantity = quantity;
        this.modelId = modelId;
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getModelId() {
        return modelId;
    }

    public int getOrderId() {
        return orderId;
    }
}
