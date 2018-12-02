package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CategoryRepository;
import model.Member;
import model.ProductRepository;


@WebServlet("/home.html")
public class HomeController extends Controller {
	int pageSize = 6;

	ProductRepository repository = new ProductRepository();
	//CategoryRepository catRepository = new CategoryRepository();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int total = repository.count();
			int n = (int) Math.ceil(total / (double) pageSize);
			req.setAttribute("total", repository.count());
			req.setAttribute("n", n);
			int p = 1;
			if(req.getParameter("p")!=null) {
				p = Integer.parseInt(req.getParameter("p"));
			}
			int pageIndex = (p-1)*pageSize;
			
			HttpSession session = req.getSession();
			if(session.getAttribute("userLogOn")!=null) {
				Member member = (Member) session.getAttribute("userLogOn");
				req.setAttribute("usr", member.getUsername());
			}
			
			//req.setAttribute("categories", catRepository.getCategories2());
			req.setAttribute("list", repository.getProducts(pageIndex,pageSize));
			render("home/index", req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
