package projet_scrabble;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;

public class Modele {
	public String[][] tableau;
	//File fichier = new File("images.dat");
	HashMap<String, ArrayList<String>> dico;

	public Modele() throws IOException {
		this.tableau = new String[15][15];
		this.dico = new HashMap<String, ArrayList<String>>();

		
		//initialisation du dico
		Hashtable<String, ArrayList<String>> dico = new Hashtable<String, ArrayList<String>>();
		BufferedReader lecteurAvecBuffer = null;
		String ligne;

		try {
			lecteurAvecBuffer = new BufferedReader(new FileReader("dictionnaire.txt"));
		} catch (FileNotFoundException exc) {
			System.out.println("Erreur d'ouverture");
		}
		while ((ligne = lecteurAvecBuffer.readLine()) != null) {
			String cle = ligne.substring(0, 2);
			if (this.dico.containsKey(cle)) {
				ArrayList<String> liste = this.dico.get(cle);
				liste.add(ligne);
				this.dico.put(cle, liste);
			} else {
				ArrayList<String> l = new ArrayList<String>();
				l.add(ligne);
				this.dico.put(cle, l);

			}

		}
		lecteurAvecBuffer.close();
	}
	
	public boolean verifier_mot(String a) {
		String cle = a.substring(0,2);
		ArrayList<String> l = this.dico.get(cle);
		for (int i=0; i<l.size(); i++) {
			if (l.get(i).equals(a)) {
				return true;
			}
		}
		return false;		
	}

}
