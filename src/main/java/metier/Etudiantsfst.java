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
import entités.Filiere;
import entités.Professeur;


@WebServlet("/Etudiantsfst")
public class Etudiantsfst extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Etudiantsfst() {      super();  }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	    	Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.2:1521:orcl", "userfst", "userfst");
	    	String user=request.getParameter("nom");
	    	String sql="select * from f6_fst"; //Etudiant
			ResultSet resultat;
			resultat=conn.createStatement().executeQuery(sql);
			ArrayList<Etudiant> list=new ArrayList<Etudiant>();
			while(resultat.next())
		     	{
				Etudiant e=new Etudiant();
			  	    e.setCne(resultat.getString("cne"));
			        e.setNom(resultat.getString("nom"));
			        list.add(e);
		     	}
	 
			request.setAttribute("nom", user);  //Bienvenue user
			request.setAttribute("list1", list);
			conn.close();
			}catch(Exception e) {
			e.printStackTrace();
		    }
		RequestDispatcher dispatchar=request.getRequestDispatcher("Etudiantsfst.jsp");
		dispatchar.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
