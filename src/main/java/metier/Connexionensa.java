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

import entit�s.Professeur;
//code source

@WebServlet("/Connexionensa")
public class Connexionensa extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Connexionensa() {   super();  }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user=request.getParameter("nom");
		String pwd=request.getParameter("password");
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
		    	Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", user, pwd);
		    	String sql1="select count(*) from professeur";  //professuers
				String sql2="select count(*) from etudiant";  //etudiants
				String sql3="select count(*) from filiere";   //filieres
				
				ResultSet resultat;
				resultat=conn.createStatement().executeQuery(sql1);
				resultat.next();
				int count=resultat.getInt(1);
				resultat=conn.createStatement().executeQuery(sql2);
				resultat.next();
				int count1=resultat.getInt(1);
				resultat=conn.createStatement().executeQuery(sql3);
				resultat.next();
				int count2=resultat.getInt(1);
			
				request.setAttribute("count", count); //nbr professeurs
				request.setAttribute("count1", count1);//nbr etudiant
				request.setAttribute("count2", count2);  //nbr filieres
 				request.setAttribute("nom", user);  //Bienvenue user
				conn.close();
				}catch(Exception e) {
				e.printStackTrace();
			    }
			RequestDispatcher dispatchar=request.getRequestDispatcher("Ensa.jsp");
			dispatchar.forward(request, response);
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}
