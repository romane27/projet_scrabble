package projet_scrabble;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class Dico {

	HashMap<String, ArrayList<String>> dico;

	public Dico() throws IOException {

		this.dico = new HashMap<String, ArrayList<String>>();

		// initialisation du dico
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
		
		/* Tests
		long debut = System.currentTimeMillis();
		System.out.println(verifier_mot("abnegations"));
		System.out.println(System.currentTimeMillis()-debut);
		
		long debut2 = System.currentTimeMillis();
		System.out.println(verifier_mot("abyssins"));
		System.out.println(System.currentTimeMillis()-debut2);
		
		long debut3 = System.currentTimeMillis();
		System.out.println(verifier_mot("abykjevkbev"));
		System.out.println(System.currentTimeMillis()-debut3);
		
		long debut4 = System.currentTimeMillis();
		System.out.println(verifier_mot("zythums"));
		System.out.println(System.currentTimeMillis()-debut4);
		*/
	}

	public boolean verifier_mot(String a) {
		String cle = a.substring(0, 2);
		ArrayList<String> l = this.dico.get(cle);
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).equals(a)) {
				return true;
			}
		}
		return false;
	}
}
