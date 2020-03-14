package projet_scrabble;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Classe_test {
	HashMap<String, ArrayList<String>> h = new HashMap<String, ArrayList<String>>();

	public Classe_test() throws IOException  {
		this.h = new HashMap<String, ArrayList<String>>();

		BufferedReader lecteurAvecBuffer = null;
		String ligne;

		try {
			lecteurAvecBuffer = new BufferedReader(new FileReader("dictionnaire.txt"));
		} catch (FileNotFoundException exc) {
			System.out.println("Erreur d'ouverture");
		}
		
		while ((ligne = lecteurAvecBuffer.readLine()) != null) {
			String cle = ligne.substring(0, 2);
			if (h.containsKey(cle)) {
				ArrayList<String> liste = h.get(cle);
				liste.add(ligne);
				h.put(cle, liste);
			} else {
				ArrayList<String> l = new ArrayList<String>();
				l.add(ligne);
				h.put(cle,l);
			}
		}
		
		lecteurAvecBuffer.close();
		
		long debut = System.currentTimeMillis();
		System.out.println(verifier_mot("abnegations"));
		System.out.println(System.currentTimeMillis()-debut);
		
		long debut2 = System.currentTimeMillis();
		System.out.println(verifier_mot("abyssins"));
		System.out.println(System.currentTimeMillis()-debut2);
		
		long debut3 = System.currentTimeMillis();
		System.out.println(verifier_mot("abykjevkbev"));
		System.out.println(System.currentTimeMillis()-debut3);
		

	}

	public static void main(String[] argv) throws IOException {
		Classe_test c = new Classe_test();
	}
	
	public boolean verifier_mot(String a) {
		String cle = a.substring(0,2);
		ArrayList<String> l = h.get(cle);
		for (int i=0; i<l.size(); i++) {
			if (l.get(i).equals(a)) {
				return true;
			}
		}
		return false;		
		
	}
}
