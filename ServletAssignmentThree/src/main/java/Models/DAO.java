package Models;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DAO {

    public static boolean saveOrder(User user, Order order){
        boolean found=false;
        PaymentStatus pStatus=order.getPayment().getStatus();
        try {
            Connection con = DataBaseConnection.initializeDatabase();
            Statement stmt = con.createStatement();
            int status=0;
            if(pStatus==PaymentStatus.PENDING){
                status=1;
            }else {
                status=2;
            }
            ResultSet payIdRes=stmt.executeQuery("select * from payments;");
            payIdRes.last();
            int payId=payIdRes.getInt("id");
            payId++;


            Payment payment=order.getPayment();
            String q1 = "insert into payments (id,status, name, address1, zip_code, phone, email, card_name, card_number, exp_date) " +
                    "values ("+payId+","+status+",'"+payment.getCardName()+"','address1',"+payment.getZipCode()+",'"+payment.getPhone()+"','"+
                    payment.getEmail()+"','"+payment.getCardName()+"','"+payment.getCardNumber()+"',"+payment.getExpDate()+");";
            found = stmt.execute(q1);
            ResultSet rs=stmt.executeQuery("select id from orders;");
            rs.last();
            int orderId=rs.getInt("id")+1;
            found=stmt.execute("insert into orders (id,date, use_id, payment_id) values ("+orderId+","+ LocalDate.now().toEpochDay() +","+user.getUserId()+","+payId+");");
            String q3="select id from orders where use_id="+user.getUserId()+" AND payment_id="+payId+";";
            for(OrderItem oItem:order.getOrderItemList()){
                found=stmt.execute("insert into order_items (order_id, item_id, quantity) values ("+orderId+","+oItem.getItem().getId()+","+oItem.getQuantity()+");");
            }
            found=true;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return found;
    }

    public static List<Item> getItemes(){
        List<Item> items=new ArrayList<>();
        try {
            Connection con = DataBaseConnection.initializeDatabase();
            Statement stmt = con.createStatement();
            String q1 = "select * from items";
            ResultSet rs = stmt.executeQuery(q1);
            while (rs.next()){
                Item item=new Item(rs.getInt("id"),rs.getString("name"),rs.getDouble("price"),rs.getString("image"));
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return items;
    }

    public static Item getItem(int id){
        Item item=null;
        try {
            Connection con = DataBaseConnection.initializeDatabase();
            Statement stmt = con.createStatement();
            String q1 = "select * from items where id='"+id+"'";
            ResultSet rs = stmt.executeQuery(q1);
            rs.first();
            item=new Item(rs.getInt("id"),rs.getString("name"),rs.getDouble("price"),rs.getString("image"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return item;
    }

    public static User getUser(String userName,String password){
        User user=null;
        try {
            Connection con = DataBaseConnection.initializeDatabase();
            Statement stmt = con.createStatement();
            String q1 = "select * from users where users.name='"+userName+"' AND users.password='"+password+"'";
            ResultSet rs = stmt.executeQuery(q1);
            if(rs.first()){
                user=new User(rs.getInt("id"),rs.getString("name"),rs.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }
}
