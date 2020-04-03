package Modele;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import Controleur.Controleur;

public class Dico extends HashMap<String, ArrayList<String>> {

	public Dico() throws IOException {

		// initialisation du dico
		BufferedReader lecteurAvecBuffer = null;
		String ligne;

		try {
			lecteurAvecBuffer = new BufferedReader(new FileReader("dictionnaire.txt"));
		} catch (FileNotFoundException exc) {
			System.out.println("Erreur d'ouverture");
		}
		String lignemaj;
		while ((ligne = lecteurAvecBuffer.readLine()) != null) {
			lignemaj = ligne.toUpperCase();
			String cle = lignemaj.substring(0, 2);
			if (this.containsKey(cle)) {
				ArrayList<String> liste = this.get(cle);
				liste.add(lignemaj);
				this.put(cle, liste);
			} else {
				ArrayList<String> l = new ArrayList<String>();
				l.add(lignemaj);
				this.put(cle, l);

			}

		}
		lecteurAvecBuffer.close();
	}

	public boolean verifier_mot(String a) {
		if (a == "") {
			return true;
		}
		try {

			String cle = a.substring(0, 2);
			ArrayList<String> l = this.get(cle);
			if (l.contains(a)) {
				return true;
			}
			return false;
		} catch (NullPointerException exp) {
			return false;
		}
	}

	/*
	 * public static void main(String[] args) throws IOException { Dico d = new
	 * Dico(); System.out.println(d.verifier_mot("LAG")); }
	 */
}
