package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Member;
import model.MemberRepository;

/**
 * Servlet implementation class AuthLogOnController
 */
@WebServlet("/auth/logon.html")
public class AuthLogOnController extends Controller {
	MemberRepository repository = new MemberRepository();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		render("auth/logon", req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String usr = req.getParameter("usr");
		String pwd = req.getParameter("pwd");
		
		Member obj = new Member(usr, pwd);
		try {
			if(repository.logOn(obj)>0) {
				//Luu vao Session
				HttpSession session = req.getSession();
				session.setAttribute("userLogOn", obj);
				
				redirect("home.html", req, resp);
				
			}else {
				req.setAttribute("msg", "Loi Dang Nhap");
				doGet(req, resp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
