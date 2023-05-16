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

@WebServlet("/Profstautres")
public class Profstautres extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Profstautres() {      super();  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	    	Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.2:1521:orcl", "userfst", "userfst");
	    	String user=request.getParameter("nom");
	    	String sql="select * from f10_fst"; //professeurs d'autres filieres 
			ResultSet resultat;
			resultat=conn.createStatement().executeQuery(sql);
			ArrayList<Professeur> list=new ArrayList<Professeur>();
			while(resultat.next())
		     	{
			  	    Professeur p=new Professeur();
			        p.setNom(resultat.getString("nom"));
			        p.setPrenom(resultat.getString("prenom"));
			        list.add(p);
		     	}
	 
			request.setAttribute("nom", user);  //Bienvenue user
			request.setAttribute("list1", list);
			conn.close();
			}catch(Exception e) {
			e.printStackTrace();
		    }
		RequestDispatcher dispatchar=request.getRequestDispatcher("Profstautres.jsp");
		dispatchar.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
