package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import model.MemberRepository;
import util.Helper;

/**
 * Servlet implementation class AuthRegisterController
 */
@WebServlet("/auth/register.html")
public class AuthRegisterController extends Controller {
	MemberRepository repository = new MemberRepository();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		render("auth/register", req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String usr = req.getParameter("usr");
		String pwd = req.getParameter("pwd");
		String fullName = req.getParameter("fullName");
		String email = req.getParameter("email");
		byte gender = Byte.parseByte(req.getParameter("gender"));
		Member obj = new Member(Helper.randomLong(), usr, pwd, fullName, email, gender);
		if (repository.add(obj) > 0) {
			redirect("auth/logon.html", req, resp);
		} else {
			req.setAttribute("msg", "Register Failed");
			doGet(req, resp);
		}
	}

}
