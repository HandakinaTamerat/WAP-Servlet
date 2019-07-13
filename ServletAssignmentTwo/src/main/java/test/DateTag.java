package test;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTag extends SimpleTagSupport {
    private String color;
    private String size;
    public void setColor(String col) {
        this.color = col;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void doTag()
            throws JspException, IOException
    {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        if (color != null && size!=null) {
            JspWriter out = getJspContext().getOut();
            out.println( "<span style=\"color: "+color+"; font-size: "+size+";\">"+ft.format(dNow)+"</span>" );
        }
    }
}
