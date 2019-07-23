package Controllers;

import Models.DAO;
import Models.OrderItem;
import Models.User;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "AddCartServlet")
public class AddCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user=null;
        HttpSession session = request.getSession(false);
        int requestItemId=Integer.parseInt(request.getParameter("id"));
        if (session!=null && session.getAttribute("wapUser") != null) {
            user= (User) session.getAttribute("wapUser");
            boolean found=false;
            for(OrderItem item:user.getCart().getOrderItems()){
                if(item.getItem().getId()==requestItemId){
                    item.setQuantity(item.getQuantity()+1);
                    found=true;
                    break;
                }
            }
            if(!found){
                user.getCart().add(DAO.getItem(requestItemId),1);
            }
            session.setAttribute("wapUser",user);
        }
        Map map=new HashMap();
        if(user==null){
            map.put("status","error");
        }else {
            map.put("status","ok");
            map.put("numberOfItem",String.valueOf(user.getCart().getOrderItems().size()));
        }
        String obj= new Gson().toJson(map);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(obj);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
