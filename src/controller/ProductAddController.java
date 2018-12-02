package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AuthorRepository;
import model.CategoryRepository;
import model.Product;
import model.ProductRepository;
import model.Publisher;
import model.PublisherRepository;
@MultipartConfig
@WebServlet("/product/add.html")
public class ProductAddController extends Controller {
	CategoryRepository catRepository = new CategoryRepository();
	PublisherRepository pubRepository = new PublisherRepository();
	AuthorRepository auRepository = new AuthorRepository();
	ProductRepository repository = new ProductRepository();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		req.setAttribute("categories", catRepository.getCategories());
		try {
			req.setAttribute("publishers", pubRepository.getPublishers());
			req.setAttribute("authors", auRepository.getAuthors());
			render("product/add", req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		int categoryId = Integer.parseInt(req.getParameter("categoryId"));
		int publisherId = Integer.parseInt(req.getParameter("publisherId"));
		int authorId = Integer.parseInt(req.getParameter("authorId"));
		
		String isbn = req.getParameter("isbn");
		String title = req.getParameter("title");
		
		short pages = Short.parseShort(req.getParameter("pages"));
		short year = Short.parseShort(req.getParameter("year"));
		
		String weight = req.getParameter("weight");
		String size = req.getParameter("size");
		String content = req.getParameter("content");
		String description = req.getParameter("description");
		String imageUrl = upload(req.getPart("f"), getDirectory(req, "/upload/"));
		int price = Integer.parseInt(req.getParameter("price"));
		
		Product obj = new Product(0, categoryId, publisherId, authorId, title, isbn, pages, year, weight, size, description, content, imageUrl, price);
		try {
			if(repository.add(obj)>0){
				//Quay ve trang chu
				redirect("product.html", req, resp);
			}else {
				req.setAttribute("msg", "Insert Failed.");
				doGet(req, resp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
