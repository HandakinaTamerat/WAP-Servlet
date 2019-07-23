package TagClass;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class ProductTag extends SimpleTagSupport {
    private String src;
    private String alt;
    private String title;
    private String price;
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out=getJspContext().getOut();
        out.print("<div class=\"card\" >\n" +
                        "          <img width='200px' src=\""+src+"\" class=\"card-img-top\" alt=\""+alt+"\">\n" +
                        "          <div class=\"card-body\">\n" +
                        "              <input type='hidden' id='"+id+"' />"+
                        "              <h5 class=\"card-title\">"+title+"</h5>\n" +
                        "              <p class=\"card-text price\">$"+price+"</p>\n" +
                        "              <a class=\"btn btn-primary addCartBtn \">Add to Cart</a>\n" +
                        "          </div>\n" +
                        "      </div>");
    }
}
