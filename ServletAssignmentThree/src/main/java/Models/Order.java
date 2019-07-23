package Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private double totalPrice;
    private Payment payment;
    private List<OrderItem> orderItemList;

    public Order() {
        orderItemList=new ArrayList<>();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void addItem(Item item,double quantity){
        OrderItem orderItem=new OrderItem(item,quantity);
        orderItemList.add(orderItem);
    }
}
