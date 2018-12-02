package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.InvoiceRepository;

/**
 * Servlet implementation class OrderDetailController
 */
@WebServlet("/order/detail.html")
public class OrderDetailController extends Controller {
	InvoiceRepository repository = new InvoiceRepository();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Long.parseLong(req.getParameter("id"));
		req.setAttribute("o", repository.getInvoice(id));
		render("order/detail", req, resp);
	}

}
