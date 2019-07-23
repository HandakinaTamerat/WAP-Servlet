package Controllers;

import Models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        User user= (User) session.getAttribute("wapUser");
        String name=request.getParameter("name");
        String address1=request.getParameter("address1");
        String email=request.getParameter("email");
        String phone=request.getParameter("phone");
        String zipCode=request.getParameter("zipCode");
        String cardName=request.getParameter("cardName");
        String cardNumber=request.getParameter("cardNumber");
        String expDate=request.getParameter("expDate");
        String cvc=request.getParameter("cvc");
        double total=0;
        for(OrderItem orderItem:user.getCart().getOrderItems()){
            total+=orderItem.getQuantity()*orderItem.getItem().getPrice();
        }
        Payment payment=new Payment(PaymentStatus.PENDING,total, LocalDate.now(),address1,name,cardNumber,email,phone,Integer.parseInt(zipCode),expDate);
        Order order=new Order();
        order.setPayment(payment);
        for(OrderItem item:user.getCart().getOrderItems()){
            order.addItem(item.getItem(),item.getQuantity());
        }
        user.addOrder(order);
        if(user.getCart().getOrderItems().isEmpty()){
            request.setAttribute(
                    "error","error while trying to checkout. please try again");
            request.getRequestDispatcher("error.jsp").forward(request,response);
            return;
        }
        if(DAO.saveOrder(user,order)){
            user.setCart(new Cart());
            session.setAttribute("wapUser",user);
            request.setAttribute("confirm",order);
            request.getRequestDispatcher("/confirmation.jsp").forward(request,response);
        }else {request.setAttribute(
                "error","error while trying to checkout. please try again");
            request.getRequestDispatcher("error.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
