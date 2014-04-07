package com.images;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;
import com.google.appengine.api.taskqueue.TaskOptions.Method;

@SuppressWarnings("serial")
public class GestionProfilServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nom = req.getParameter("nom");
		String a = req.getParameter("age");
		int age = Integer.parseInt(a);
		
		Queue queue = QueueFactory.getDefaultQueue();
		queue.add(TaskOptions.Builder.withUrl("/tacheDeFond").param("nom", nom).method(Method.GET));
		
		DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();
		
		Transaction tx = dataStore.beginTransaction();
		Entity utilisateur = new Entity("utilisateurs");
		utilisateur.setProperty("nom", nom);
		utilisateur.setProperty("age", age);
		dataStore.put(utilisateur);
		tx.commit();
		
		resp.sendRedirect("/rechercheProfil?nom=" + nom);
		
	}
	
	
	
}
