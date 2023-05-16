package metier;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entités.Professeur;


@WebServlet("/Professeursensa")
public class Professeursensa extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Professeursensa() {       super();       }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	    	Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "admin_ensa", "admin_ensa");
	    	String user=request.getParameter("nom");
	    	String sql="select * from professeur"; //professeurs
			ResultSet resultat;
			resultat=conn.createStatement().executeQuery(sql);
			ArrayList<Professeur> list=new ArrayList<Professeur>();
			while(resultat.next())
		     	{
			  	    Professeur p=new Professeur();
			  	    p.setCode(resultat.getInt("code"));
			        p.setNom(resultat.getString("nom"));
			        p.setPrenom(resultat.getString("prenom"));
			        p.setSpecialite(resultat.getString("specialite"));
			        list.add(p);
		     	}
	 
			request.setAttribute("nom", user);  //Bienvenue user
			request.setAttribute("list1", list);
			conn.close();
			}catch(Exception e) {
			e.printStackTrace();
		    }
		RequestDispatcher dispatchar=request.getRequestDispatcher("Professeursensa.jsp");
		dispatchar.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
