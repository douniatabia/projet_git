package entités;

public class Etudiant {
	   private String nom;
	   private String prenom;
	   private String cne;
	   private String adresse;
	public Etudiant() {
		super();
	}
	public Etudiant(String nom, String prenom, String cne, String adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cne = cne;
		this.adresse = adresse;
	}
	public String getNom() {	return nom;}
	public void setNom(String nom) {	this.nom = nom;}
	public String getPrenom() {	return prenom;}
	public void setPrenom(String prenom) {		this.prenom = prenom;}
	public String getCne() {		return cne;}
	public void setCne(String cne) {	this.cne = cne;}
	public String getAdresse() {	return adresse;     }
	public void setAdresse(String adresse) {	this.adresse = adresse; 	}  
}
