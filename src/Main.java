import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		String textFile;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("�crivez le nom du fichier � lire (n'oubliez pas de l'importer)");
		textFile = scanner.nextLine();
		
		scanner.close();
		
		ReadFromFile reader = new ReadFromFile();
		reader.readFile(textFile);
	}
}
