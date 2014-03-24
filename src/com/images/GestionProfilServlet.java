package com.images;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class GestionProfilServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
		String nom = req.getParameter("nom");
		String a = req.getParameter("age");
		int age = Integer.parseInt(a);
		System.out.println(nom + " " + age);
	}
	
	
	
}
