
public class Commande {
	Client client;
	Plat plat;
	int nbFois;
	
	public Commande(Client client, Plat plat, int nbFois) {
		this.client = client;
		this.plat = plat;
		this.nbFois = nbFois;
	}
	
}
