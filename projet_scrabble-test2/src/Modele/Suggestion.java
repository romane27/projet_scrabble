package Modele;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;



public class Suggestion {
	Dico dico;
	public static String suggestionlist[];
	public static ArrayList<String> motpossible  ;
	public Suggestion(Joueur j) throws IOException {
		dico = new Dico();
		motpossible = new ArrayList<>();
		ArrayList<String> possibilitecles = new ArrayList<>();
		ArrayList <String> lettreClavier = new ArrayList<>();
		for (Lettre lettre :j) {
			lettreClavier.add(lettre.nom);
		}
		// on cherche les clés possibles avec les lettres du plateau
		// il manque le cas ou on a un joker a faire plus tard 
		for (int i =0; i<j.size();i++) {
			for (int k=0;k<j.size();k++) {
				if(i!=k) {
					possibilitecles.add(j.get(i).nom+j.get(k).nom);

				}
			}

		}

		for (int k=0;k<possibilitecles.size();k++) {

			String p=possibilitecles.get(k);			
			if (dico.containsKey(p)) {
				ArrayList<String> l=dico.get(p);

				for (String mot : l) {
					ArrayList <String> lettrecla = (ArrayList<String>)lettreClavier.clone();


					Boolean motpos = true;

					for (int i=0;i<mot.length();i++) {
						// il faut supprimer la lettre du clavier; 
						if (lettrecla.contains(Character.toString(mot.charAt(i)))==false && !lettrecla.contains(" ")) {
							motpos=false;
						}
						if (lettrecla.contains(Character.toString(mot.charAt(i)))==false && lettrecla.contains(" ")) {
							lettrecla.remove(" ");
						}
						else {
							lettrecla.remove(Character.toString(mot.charAt(i)));
						}
					}
					if (motpos==true && !motpossible.contains(mot)) {

						motpossible.add(mot);

					}
				}


			}
		}
		// on transforme l'arraylist de Suggestion en List pour l'utiliser dans un Jlist
		motpossible.sort(null);
		suggestionlist= new String[motpossible.size()];
		suggestionlist=motpossible.toArray(suggestionlist);

		System.out.println(motpossible);




	}
}










