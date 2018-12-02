package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/upload/multiple.html")
public class UploadMultipleController extends Controller {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		render("upload/multiple", req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//String root = req.getServletContext().getRealPath("/upload/");

		/*List<String> list = new LinkedList();
		for (Part part : req.getParts()) {
			System.out.println(part.getSubmittedFileName());
			list.add(part.getSubmittedFileName());

			InputStream is = part.getInputStream();
			FileOutputStream fos = new FileOutputStream(new File(root + part.getSubmittedFileName()));
			byte[] bytes = new byte[1024];
			int len;
			while ((len = is.read(bytes, 0, 1024)) > 0) {
				fos.write(bytes, 0, len);
			}
			fos.close();
			is.close();
		}*/
		String root = getDirectory(req, "/upload");
		List<String> list = upload(req.getParts(), root);
		req.setAttribute("list", list);
		doGet(req, resp);
	}
}
