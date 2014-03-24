package com.images;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

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
		
		DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();
		Entity utilisateur = new Entity("utilisateurs");
		utilisateur.setProperty("nom", nom);
		utilisateur.setProperty("age", age);
		dataStore.put(utilisateur);
		
		resp.sendRedirect("/rechercheProfil");
		
	}
	
	
	
}
