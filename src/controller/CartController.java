package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.Product;
import model.ProductRepository;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/cart.html")
public class CartController extends Controller {
	ProductRepository repository = new ProductRepository();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*HttpSession session = req.getSession();
		Map<Integer, Cart> map = (Map<Integer, Cart>) session.getAttribute("cart");
		*/
		Map<Integer, Cart> map = getCarts(req, resp);
		req.setAttribute("list", map.values());
		render("cart/index", req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		short qty = Short.parseShort(req.getParameter("quantity"));
		Product obj;
		try {
			obj = repository.getProduct(id);
			

			/*

			Map<Integer, Cart> map = null;
			if (session.getAttribute("cart") != null) {
				// Neu co roi
				map = (Map<Integer, Cart>) session.getAttribute("cart");
			} else {
				// Neu chua co
				map = new HashMap<>();
			}*/
			Map<Integer, Cart> map = getCarts(req, resp);

			if (map.containsKey(id)) {
				// Tang so luong
				Cart o = map.get(id);
				// o.setQuantity(o.getQuantity()+1);
				// o.setQuantity(o.getQuantity() + qty);
				o.increaseQuantity(qty);
			} else {
				// Dua vao gio hang
				Cart cart = new Cart(id, obj.getPrice(), qty, obj.getImageUrl(), obj.getTitle());
				map.put(id, cart);
			}
			HttpSession session = req.getSession();
			session.setAttribute("cart", map);
			doGet(req, resp);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
