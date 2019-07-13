package test;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class MyTag3 extends SimpleTagSupport {
    private String message;
    public void setMessage(String msg) {
        this.message = msg;
    }
    public void doTag()
            throws JspException, IOException
    {
        if (message != null) {
            JspWriter out = getJspContext().getOut();
            out.println( message );
        }
    }

}
