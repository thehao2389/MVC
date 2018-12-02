package form;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import model.Category;
import model.Entity;

public class Select extends SimpleTagSupport{
	private String name;
	private String css;
	private List<Entity> list;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCss(String css) {
		this.css = css;
	}
	
	public void setList(List<Entity> list) {
		this.list = list;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter jw = getJspContext().getOut();
		jw.write(String.format("<select name=\"%s\" class=\"%s\">", name,css));
		for(Entity o:list) {
			jw.write(String.format("<option value=\"%d\">%s</option>", o.getId(),o.getName()));
		}
		jw.write("</select>");
	}
}
