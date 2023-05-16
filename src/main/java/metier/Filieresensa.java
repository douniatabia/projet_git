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

import entités.Filiere;

@WebServlet("/Filieresensa")
public class Filieresensa extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Filieresensa() {       super();   }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	    	Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "admin_ensa", "admin_ensa");
	    	String user=request.getParameter("nom");
	    	String sql="select * from filiere"; //Filieres
			ResultSet resultat;
			resultat=conn.createStatement().executeQuery(sql);
			ArrayList<Filiere> list=new ArrayList<Filiere>();
			while(resultat.next())
		     	{
			  	    Filiere f=new Filiere();
			  	    f.setId(resultat.getString("id"));
			        f.setNom(resultat.getString("nom"));
			        list.add(f);
		     	}
	 
			request.setAttribute("nom", user);  //Bienvenue user
			request.setAttribute("list1", list);
			conn.close();
			}catch(Exception e) {
			e.printStackTrace();
		    }
		RequestDispatcher dispatchar=request.getRequestDispatcher("Filieresensa.jsp");
		dispatchar.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}
