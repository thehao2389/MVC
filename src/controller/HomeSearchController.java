package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductRepository;

/**
 * Servlet implementation class HomeSearchController
 */
@WebServlet("/home/search.html")
public class HomeSearchController extends Controller {
	ProductRepository repository = new ProductRepository();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String q = req.getParameter("q");
		try {
			req.setAttribute("list", repository.search(q));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		render("home/search", req, resp);
	}
}
