package form;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Pagination extends SimpleTagSupport {
	private int n;
	private String url;

	public void setN(int n) {
		this.n = n;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public void doTag() throws JspException, IOException {
		PageContext context = (PageContext) getJspContext();
		JspWriter jw = context.getOut();
		int p = 1;
		if (context.getRequest().getParameter("p") != null) {
			p = Integer.parseInt(context.getRequest().getParameter("p"));
		}
		jw.write("<ul class=\"pagination\">");

		for (int i = 1; i <= n; i++) {
			if(p==i) {
				jw.write("<li class=\"page-item active\">");
			}else {
				jw.write("<li class=\"page-item\">");
			}
			jw.write(String.format("<a class=\"page-link\" href=\"%s?p=%d\">%d</a>", url, i, i));
			jw.write("</li>");
		}
		jw.write("</ul>");
	}
}
