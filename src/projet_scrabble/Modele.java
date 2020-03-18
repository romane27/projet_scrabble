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
	HashMap<String, ArrayList<String>> dico;

	public Modele() throws IOException {
		this.tableau = new String[15][15];
		this.dico = new Dico().dico;

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
