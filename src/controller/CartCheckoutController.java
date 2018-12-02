package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.Invoice;
import model.InvoiceDetail;
import model.InvoiceRepository;

@WebServlet("/cart/checkout.html")
public class CartCheckoutController extends Controller {
	InvoiceRepository repository = new InvoiceRepository();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*HttpSession session = request.getSession();
		Object obj = session.getAttribute("cart");
		Map<Integer, Cart> map = (Map<Integer, Cart>) session.getAttribute("cart");*/
		Map<Integer, Cart> map = getCarts(request, response);
		request.setAttribute("list", map.values());
		render("cart/checkout", request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Ngau nhien
		Random rand = new Random();
		//Absolute
		Long id = Math.abs(rand.nextLong());
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String tel = req.getParameter("tel");

		Invoice obj = new Invoice(id, null, tel, address, email, (short) 1);
		
		List<InvoiceDetail> list = new LinkedList<>();
		/*HttpSession session = req.getSession();
		Map<Integer, Cart> map = (Map<Integer, Cart>) session.getAttribute("cart");*/
		Map<Integer, Cart> map = getCarts(req, resp);
		
		for(Cart o:map.values()) {
			InvoiceDetail detail = new InvoiceDetail(id,o.getProductId(), o.getQuantity(), o.getPrice());
			list.add(detail);
		}
		obj.setDetails(list);

		try {
			if (repository.add(obj) > 0) {
				redirect("order/detail.html?id="+id, req, resp);
			} else {
				req.setAttribute("msg", "Ordered Failed");
				doGet(req, resp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
