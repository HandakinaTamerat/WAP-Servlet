import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(name = "SupportServlet")
public class SupportServlet extends HttpServlet {
    String[] fruit=new String[]{"Banana","orange","Apple"};
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        Random r=new Random();
        int id=r.nextInt(10000000);
        ServletContext sc = this.getServletContext();
        out.print("<HTML>");
        out.print("<head><title>Servlet</title></head>");
        out.print("<body>");
        out.print("<p style='font-size:14pt;width:800px;'>Thank you! "+request.getParameter("name")+" for contacting us. We should receive reply" +
                " from us with in 24 hrs in your email address "+request.getParameter("email")+". Let us know in" +
                " our support email "+sc.getInitParameter("support-email")+" if you don’t receive reply within 24 hrs. " +
                "Please be sure to attach your reference "+id+" your email.</p>");
        out.print("</body><html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        out.print("<HTML>");
        out.print("<head><title>Servlet</title></head>");
        out.print("<body><form method='POST'>");
        out.print("Name: <input type='text' name='name'><br>");
        out.print("Email:<input type='email' name='email'><br>");
        out.print("Problem:<input type='text' name='problem'><br>");
        out.print("Description: <textarea name'description'></textarea><br>");
        out.print("<input type='submit' value='help'>");
        out.print("</form></body></HTML>");
    }
}
