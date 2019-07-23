package Controllers;

import Models.DAO;
import Models.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "GuardFilter")
public class GuardFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        HttpSession session=request.getSession(false);
        User user=null;
        if(session!=null && session.getAttribute("wapUser")!=null ){
            user=(User) session.getAttribute("wapUser");
        }
        request.setAttribute("user",user);
        request.setAttribute("items",DAO.getItemes());
        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
