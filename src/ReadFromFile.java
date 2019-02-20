import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadFromFile {

	public void readFile(String textFile) throws Exception {
		File file = new File(textFile);
		List<Client> listClient = new ArrayList<Client>();
		List<Plat> listPlat = new ArrayList<Plat>();
		List<Commande> listCommande = new ArrayList<Commande>();
		DecimalFormat df =  new DecimalFormat("###,##0.00$"); 
		
		String line;
		String[] splitter;

		Client client;
		Plat plat;
		Commande commande;
		
		String nom = "";
		String nbFois = "";
		String nourriture = "";
		String prix = "";
		
		double prixTotal;

		boolean estClient = false;
		boolean estCommande = false;
		boolean estPlat = false;

		BufferedReader br = new BufferedReader(new FileReader(file));

		while ((line = br.readLine()) != null) {
			
			if (line.equalsIgnoreCase("Fin")) {
				break;
			}
			
			if (estClient == true) {
				splitter = line.split(" ");
				
				if (splitter.length > 1 || splitter.length < 1) {
					System.out.println("Le fichier ne respecte pas le format demandé!");
					System.exit(0);
				} else if( !line.contains(":") ){
					client = new Client(line);
					listClient.add(client);
				}
			}
			
			if (estPlat == true) {
				splitter = line.split(" ");

				if (splitter.length > 2 || splitter.length < 2 && !line.contains(":")) {
					System.out.println("Le fichier ne respecte pas le format demandé !");
					System.exit(0);
					
				} else if(!line.contains(":")){

					for (int i = 0; i < splitter.length; i++) {
						if (i == 0) {
							nourriture = splitter[i];
						} else if (i == 1) {
							prix = splitter[i];
						}
					}
					plat = new Plat(nourriture, prix);
					listPlat.add(plat);
				}
			}

			if (estCommande == true) {
				splitter = line.split(" ");
				
				if (splitter.length > 3 || splitter.length < 3) {
					System.out.println("Le fichier ne respecte pas le format demandé !");
					System.exit(0);
					
				} else if(!line.contains(":")){
					for (int i = 0; i < splitter.length; i++) {
						
						if (i == 0) {
							List<Boolean> listTab = new ArrayList<Boolean>();
							for (Client clientHolder : listClient) {
								if (clientHolder.nom.equalsIgnoreCase(splitter[0])) {
									listTab.add(true);
								}else {
									listTab.add(false);
								};
							}
							if (!listTab.contains(true)) {
								System.out.println("Le fichier ne respecte pas le format demandé !");
								System.exit(0);
							} else {
								nom = splitter[0];
							}
						}
						
						if (i == 1) {
							
							List<Boolean> listTab2 = new ArrayList<Boolean>();
							for (Plat platHolder : listPlat) {
								if (platHolder.nourriture.equalsIgnoreCase(splitter[1])) {
									listTab2.add(true);
								}else {
									listTab2.add(false);
								};
							}
							if (!listTab2.contains(true)) {
								System.out.println("Le fichier ne respecte pas le format demandé !");
								System.exit(0);
							} else {
								nourriture = splitter[1];
								
							}
						}
						
						if (i == 2) {
							nbFois = splitter[2];
						}
					}
					for (Plat platHolder: listPlat) {
						if (platHolder.nourriture.equalsIgnoreCase(nourriture)) {
							prix = platHolder.prix; 
						}
					}
					
					commande = new Commande(nom, nourriture, nbFois, prix);
					listCommande.add(commande);
				}
			}
			
			if (line.equalsIgnoreCase("Clients:")) {
				estClient = true;
				estCommande = false;
				estPlat = false;

			} else if (line.equalsIgnoreCase("Plats:")) {
				estClient = false;
				estCommande = false;
				estPlat = true;
				
			} else if (line.equalsIgnoreCase("Commandes:")) {
				estClient = false;
				estCommande = true;
				estPlat = false;
				
			}
		}
		
		System.out.println("Bienvenue chez Barette!");
		System.out.println("Factures:");
		
		for (Client clientHolder : listClient) {
			prixTotal = 0.00;
			for (Commande commandeHolder: listCommande) {
				if (commandeHolder.nomClient.equalsIgnoreCase(clientHolder.nom) ) {
					prixTotal += Double.parseDouble(commandeHolder.getPrix()) * Double.parseDouble(commandeHolder.getNbFois()) ;
				}
			}
			System.out.println(clientHolder.nom + " " + df.format(prixTotal));
		}
		

	}
}
