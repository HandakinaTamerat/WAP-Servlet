

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginAuth implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

       HttpServletRequest request= (HttpServletRequest) req;
       HttpSession session=request.getSession(false);
       HttpServletResponse response= ((HttpServletResponse)resp);
       if(session.getAttribute("userName")==null){
           String userName=request.getParameter("name");
           String pass=request.getParameter("password");
           if(userName!=null&&pass!=null){
               if(DB.getUser(userName)!=null&& DB.getUser(userName).getPassword().equalsIgnoreCase(pass)){
                   if(request.getParameterValues("remember")!=null && request.getParameterValues("remember")[0].equalsIgnoreCase("on")){
                       Cookie userCookie = new Cookie("userName", userName);
                       userCookie.setMaxAge(2592000); //for month
                       response.addCookie(userCookie);
                   }else {
                       for (Cookie cookie : request.getCookies()) {
                           if (cookie.getName().equals("userName")) {
                               cookie.setMaxAge(0);
                           }
                       }
                   }
                   session=request.getSession(true);
                   session.setAttribute("userName",request.getParameter("name"));
                   resp.getWriter().print("<a href='logout'>Logout</a>");
                   chain.doFilter(req,resp);
                   Cookie promo = new Cookie("value", "$100");
                   promo.setMaxAge(2592000); //for month
                   response.addCookie(promo);
               }else {
                   response.getWriter().print("invalid user name or password!");
                   response.sendRedirect("index.jsp");
               }
           }else {
               response.getWriter().print("invalid user name or password!");
               response.sendRedirect("index.jsp");
           }
       }else {
           resp.getWriter().print("<a href='logou'>Logout</a>");
           chain.doFilter(req,resp);
       }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
