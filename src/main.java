import java.io.*;

public class main {

	public static void main(String[] args) throws Exception {
		readFile();
	}

	public static void readFile() throws Exception {
		File file = new File("..//..//test.txt");
		String line;
		boolean estClient = false;
		boolean estCommande = false;
		boolean estPlat = false;

		BufferedReader br = new BufferedReader(new FileReader(file));

		while ((line = br.readLine()) != null) {
			
			if (line == "Client:") {
				estClient = true;
				estCommande = false;
				estPlat = false;

			} else if (line == "Commande:") {
				estClient = false;
				estCommande = true;
				estPlat = false;

			} else if (line == "Plat:") {
				estClient = false;
				estCommande = false;
				estPlat = true;
			}

		}
		System.out.println(line);

	}
}
