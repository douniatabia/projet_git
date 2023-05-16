package entités;

public class Professeur {
	    private int code;
	    private String nom;
	    private String prenom;
	    private String specialite;
	    public Professeur() {
			super();
		}
		public Professeur(int code, String nom, String prenom, String specialite) {
			super();
			this.code = code;
			this.nom = nom;
			this.prenom = prenom;
			this.specialite = specialite;
		}

		public int getCode() {	return code;		}

		public void setCode(int code) {		this.code = code;}
		
		public String getNom() {	return nom;}

		public void setNom(String nom) {	this.nom = nom;}

		public String getPrenom() {		return prenom;		}
		
		public void setPrenom(String prenom) {			this.prenom = prenom;		}
       
		public String getSpecialite() {	return specialite;   }

		public void setSpecialite(String specialite) {	this.specialite = specialite;		}
	   
}
