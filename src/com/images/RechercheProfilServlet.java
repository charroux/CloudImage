package com.images;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;
import com.google.appengine.api.taskqueue.TaskOptions.Method;

@SuppressWarnings("serial")
public class RechercheProfilServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String nom = req.getParameter("nom");
		System.out.println("nom" + nom);
		
		Query query = new Query("utilisateurs");
		query.addFilter("nom", Query.FilterOperator.EQUAL, nom);
		DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();
		PreparedQuery pq = dataStore.prepare(query);
		for (Entity result : pq.asIterable()){
			nom = (String) result.getProperty("nom");
			Long age = (Long) result.getProperty("age");
			System.out.println(nom + " " + age);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
	
	
	
}
