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


@WebServlet("/Etudiantfst")
public class Etudiantfst extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Etudiantfst() {        super();   }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	    	Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.2:1521:orcl", "userfst", "userfst");
	    	String user=request.getParameter("nom");
	    	String nom=request.getParameter("filiere"); //nom filiere barre de recherche 
	    	String sql="copy from admin_ensa/admin_ensa@ensa to userfst/userfst@fst "
	    			+ "replace f4_fst using (select c1.cne,c1.nom,prenom,adresse from etudiant c1,filiere c2 where"
	    			+ "c1.cne=c2.cne and c2.nom='"+nom+"' )"; //copy Etudiant
	    	java.sql.Statement stm=conn.createStatement();
	    	stm.executeUpdate(sql);
	    	String sql1="select * from f4_fst";
	    	ResultSet resultat;
			resultat=conn.createStatement().executeQuery(sql1);
			ArrayList<Etudiant> list=new ArrayList<Etudiant>();
			while(resultat.next())
		     	{
				Etudiant e=new Etudiant();
			  	    e.setCne(resultat.getString("cne"));
			        e.setNom(resultat.getString("nom"));
			        e.setPrenom(resultat.getString("prenom"));
			        e.setAdresse(resultat.getString("adresse"));
			        list.add(e);
		     	}
	 
			request.setAttribute("nom", user);  //Bienvenue user
			request.setAttribute("list1", list);
			conn.close();
			}catch(Exception e) {
			e.printStackTrace();
		    }
		RequestDispatcher dispatchar=request.getRequestDispatcher("Etudfst.jsp");
		dispatchar.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
