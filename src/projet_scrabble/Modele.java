package projet_scrabble;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;

public class Modele {
	public String[] pupitre;
	public String[][] tableau;
	File fichier = new File("images.dat");

	public Modele() {
		this.tableau = new String[15][15];
		this.pupitre = new String[7];
		Hashtable<String, String> dico = new Hashtable<String, String>();
	}

	public void affiche() throws IOException {
		String ligne = "";
		String fichier = "dictionnaire.txt";

		BufferedReader ficTexte;
		try {
			ficTexte = new BufferedReader(new FileReader(new File(fichier)));
			if (ficTexte == null) {
				throw new FileNotFoundException("Fichier non trouvé: " + fichier);
			}
			do {
				ligne = ficTexte.readLine();
				if (ligne != null) {
					System.out.println(ligne);
				}
			} while (ficTexte != null);
			ficTexte.close();
			System.out.println("\n");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	

}
