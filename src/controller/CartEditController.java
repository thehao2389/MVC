package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;

@WebServlet("/cart/edit.html")
public class CartEditController extends Controller {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		/*
		 * pw.write(req.getParameter("id")); pw.write(req.getParameter("qty"));
		 */

		short qty = Short.parseShort(req.getParameter("qty"));
		int id = Integer.parseInt(req.getParameter("id"));
		Map<Integer, Cart> map = getCarts(req, resp);
		Cart obj = map.get(id);
		obj.setQuantity(qty);
		HttpSession session = req.getSession();
		session.setAttribute("cart", map);
		pw.write("1");
	}
}
