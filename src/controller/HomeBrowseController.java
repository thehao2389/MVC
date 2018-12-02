package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CategoryRepository;
import model.ProductRepository;

@WebServlet("/home/browse.html")
public class HomeBrowseController extends Controller {
	ProductRepository repository = new ProductRepository();
	CategoryRepository catRepository = new CategoryRepository();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		try {
			req.setAttribute("list", repository.getProducts(id));
			req.setAttribute("o", catRepository.getCategory(id));
			render("home/browse", req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
