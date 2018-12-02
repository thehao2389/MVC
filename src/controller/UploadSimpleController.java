package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/upload/simple.html")
public class UploadSimpleController extends Controller {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		render("/upload/simple", req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part part = req.getPart("f");
		System.out.println("****************************");
		System.out.println(part.getSubmittedFileName());
		System.out.println(part.getSize());
		System.out.println(part.getName());
		System.out.println(part.getContentType());
		
		//String root = req.getServletContext().getRealPath("/upload/");
/*		InputStream is = part.getInputStream();
		FileOutputStream fos = new FileOutputStream(new File(root+part.getSubmittedFileName()));
		byte[] bytes = new byte[1024];
		int len;
		while((len=is.read(bytes,0,1024))>0) {
			fos.write(bytes,0,len);
		}
		fos.close();
		is.close();*/
		//String fileName = upload(path, part);
		String root = getDirectory(req, "/upload");
		
		req.setAttribute("url", part.getSubmittedFileName());
		doGet(req, resp);
	}
}
