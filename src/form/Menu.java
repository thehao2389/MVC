package form;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import model.Category;

public class Menu extends SimpleTagSupport {
	private List<Category> list;

	public void setList(List<Category> list) {
		this.list = list;
	}

	@Override
	public void doTag() throws JspException, IOException {
		PageContext context = (PageContext) getJspContext();
		JspWriter jw = context.getOut();
		String str = "<li><a href=\"%s/home/browse.html?id=%d\">%s</a></li>";
		jw.write("<ul>");
		for (Category p : list) {
			if (p.getParentId() == 0) {
				jw.write("<li>");
				jw.write(p.getName());
				jw.write("<ul>");
				for (Category c : list) {
					if (c.getParentId() == p.getId()) {
						jw.write(String.format(str, context.getServletContext().getContextPath(), c.getId(),
								c.getName()));
					}
				}
				// jw.write(String.format("<li>%s</li>", p.getName()));
				jw.write("</ul>");
				jw.write("</li>");
			}
		}
		jw.write("</ul>");
	}
}
