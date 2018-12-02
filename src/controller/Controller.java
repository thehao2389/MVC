package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Cart;

public abstract class Controller extends HttpServlet {
	protected void render(String view, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/" + view + ".jsp").forward(request, response);
	}

	protected void redirect(String location, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.sendRedirect(request.getContextPath() + "/" + location);
	}

	protected Map<Integer, Cart> getCarts(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("cart");

		Map<Integer, Cart> carts = null;
		if (obj != null) {
			carts = (Map<Integer, Cart>) obj;
		} else {
			carts = new HashMap();
			session.setAttribute("cart", carts);
		}
		return carts;
	}

	protected static String upload(Part part,String root) throws IOException {
		String fileName = part.getSubmittedFileName();

		InputStream is = part.getInputStream();
		FileOutputStream fos = new FileOutputStream(new File(root + part.getSubmittedFileName()));
		byte[] bytes = new byte[1024];
		int len;
		while ((len = is.read(bytes, 0, 1024)) > 0) {
			fos.write(bytes, 0, len);
		}
		fos.close();
		is.close();

		return fileName;
	}

	protected static String getDirectory(HttpServletRequest req, String name) {
		return req.getServletContext().getRealPath(name);

	}

	protected static List<String> upload(Collection<Part> parts, String root) throws IOException {
		List<String> list = new LinkedList<>();
		for (Part part : parts) {
			list.add(upload(part, root));
		}
		return list;

	}
}
