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


@WebServlet("/Connexionfst")
public class Connexionfst extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Connexionfst() {    super();       }
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("nom");
		String pwd=request.getParameter("password");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	    	Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.2:1521:orcl", user, pwd);
	    	String sql1="select count(*) from f1_fst";   //professeurs
			String sql2="select count(*) from f2_fst";  //filieres
			String sql3="select count(*) from f6_fst"; //etudiants
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
			
			request.setAttribute("count", count);//nbr professeurs
			request.setAttribute("count1", count1);//nbr filieres
			request.setAttribute("count2", count2);//nbr etudaints 
			request.setAttribute("nom", user);  //Bienvenue user
			conn.close();
			}catch(Exception e) {
			e.printStackTrace();
		    }
		RequestDispatcher dispatchar=request.getRequestDispatcher("Fst.jsp");
		dispatchar.forward(request, response);
		
		doGet(request, response);
	}
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			response.getWriter().append("Served at: ").append(request.getContextPath());
		}

}
