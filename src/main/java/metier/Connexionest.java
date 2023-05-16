package metier;


import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;

import entités.Professeur;


@WebServlet("/Connexionest")
public class Connexionest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Connexionest() {      super(); }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     
		String user=request.getParameter("nom");
		String pwd=request.getParameter("password");
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
		    	Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.2:1521:orcl", user, pwd);
		    	String sql1="select count(*) from f1_est";  //professuers
				String sql2="select count(*) from f3_est";  //etudiants
		    
				ResultSet resultat;
				resultat=conn.createStatement().executeQuery(sql1);
				resultat.next();
				int count=resultat.getInt(1);
				resultat=conn.createStatement().executeQuery(sql2);
				resultat.next();
				int count1=resultat.getInt(1);
			
				request.setAttribute("count", count); //nbr professeurs
				request.setAttribute("count1", count1);//nbr etudiant
				request.setAttribute("nom", user);  //Bienvenue user
				conn.close();
				}catch(Exception e) {
				e.printStackTrace();
			    }
			RequestDispatcher dispatchar=request.getRequestDispatcher("Est.jsp");
			dispatchar.forward(request, response);
		
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
