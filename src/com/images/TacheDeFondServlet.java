package com.images;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Transaction;

@SuppressWarnings("serial")
public class TacheDeFondServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String nom = req.getParameter("nom");
		System.out.println("Ceci est une tache de fond avec le parametre : " + nom);
	}

	
	
}
