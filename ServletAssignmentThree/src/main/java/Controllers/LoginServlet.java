package Controllers;

import Models.DAO;
import Models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName=request.getParameter("name");
        String uPassword=request.getParameter("password");
        User user=DAO.getUser(userName,uPassword);
        if(user!=null){
            HttpSession session=request.getSession(true);
            session.setAttribute("wapUser",user);
            response.getWriter().print(1);
        }else {
            response.getWriter().print(0);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
