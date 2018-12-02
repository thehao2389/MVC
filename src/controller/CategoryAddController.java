package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Category;
import model.CategoryRepository;
import model.PublisherRepository;

@WebServlet("/category/add.html")

public class CategoryAddController extends Controller {
	
	CategoryRepository repository = new CategoryRepository();
	PublisherRepository repository2 = new PublisherRepository();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("parents", repository.getParents());
		render("category/add", req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		Integer parent = Integer.parseInt(req.getParameter("parent"));
		
		Category obj = new Category(0, name,parent);
		try {
			if(repository.add(obj)>0){
				//Quay ve trang chu
				redirect("category.html", req, resp);
			}else {
				req.setAttribute("msg", "Loi khong them duoc.");
				doGet(req, resp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
