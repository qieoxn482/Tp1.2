
public class Commande {
	String nomClient;
	String plat;
	String nbFois;
	String prix;
	
	public Commande(String nomClient, String plat, String nbFois, String prix) {
		this.nomClient = nomClient ;
		this.plat = plat;
		this.nbFois = nbFois;
		this.prix = prix;
	}
	
	public String getPlat() {
		return this.plat;
	}
	
	public String getNbFois() {
		return this.nbFois;
	}
	
	public String getPrix() {
		return this.prix;
	}
}
