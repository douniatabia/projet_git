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

import entités.Etudiant;

@WebServlet("/Etudiantsest")
public class Etudiantsest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Etudiantsest() {     super();    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	    	Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.2:1521:orcl", "userest", "userest");
	    	String user=request.getParameter("nom");
	    	String sql="select * from f3_est"; //Etudiant
			ResultSet resultat;
			resultat=conn.createStatement().executeQuery(sql);
			ArrayList<Etudiant> list=new ArrayList<Etudiant>();
			while(resultat.next())
		     	{
				Etudiant e=new Etudiant();
			  	    e.setCne(resultat.getString("cne"));
			        e.setNom(resultat.getString("nom"));
			        e.setAdresse(resultat.getString("adresse"));
			        e.setPrenom(resultat.getString("prenom"));
			        list.add(e);
		     	}
	 
			request.setAttribute("nom", user);  //Bienvenue user
			request.setAttribute("list1", list);
			conn.close();
			}catch(Exception e) {
			e.printStackTrace();
		    }
		RequestDispatcher dispatchar=request.getRequestDispatcher("Etudiantsest.jsp");
		dispatchar.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
