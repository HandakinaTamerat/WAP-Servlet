package Models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<OrderItem> orderItems=new ArrayList<>();
    public void add(Item item,double quantity){
        OrderItem orderItem=new OrderItem(item,quantity);
        orderItems.add(orderItem);
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
}
