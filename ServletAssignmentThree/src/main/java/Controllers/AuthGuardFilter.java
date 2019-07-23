package Controllers;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthGuardFilter")
public class AuthGuardFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpSession session=((HttpServletRequest)req).getSession(false);
        if(session!=null && session.getAttribute("wapUser")!=null){
            chain.doFilter(req, resp);
        }else{
            ((HttpServletResponse)resp).sendRedirect("index.jsp");
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
