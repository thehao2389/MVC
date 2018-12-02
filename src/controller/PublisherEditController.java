package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Publisher;
import model.PublisherRepository;

@WebServlet("/publisher/edit.html")
public class PublisherEditController extends HttpServlet {
	PublisherRepository repository = new PublisherRepository();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Publisher obj;
		try {
			obj = repository.getPublisher(id);
			request.setAttribute("o", obj);
			request.getRequestDispatcher("/views/publisher/edit.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		Publisher obj = new Publisher(id,name);
		try {
			if(repository.edit(obj)>0) {
				response.sendRedirect("/MVC/publisher.html");
			}else {
				request.setAttribute("msg", "Loi khong the cap nhat");
				doGet(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
