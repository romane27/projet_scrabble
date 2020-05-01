package Modele;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.ImageIcon;

import java.util.Set;

public class Suggestion {
	Dico dico;
	Pioche p;
	public static String suggestionlist[];
	public static ArrayList<String> motpossible;
	public static String[] alphabet = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
			"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
	public static ArrayList<Lettre> lettreetvaleurs;

	public Suggestion(Joueur j) throws IOException {

		dico = new Dico();
		p = new Pioche();
		motpossible = new ArrayList<>();
		lettreetvaleurs = new ArrayList<>();
		// on rempli la liste de lettre pour pouvoir tester le joker

		lettreetvaleurs.add(
				(new Lettre("E", 1, new ImageIcon("src/images/E_joker.jpg"), new ImageIcon("src/images/Egris.jpg"))));

		lettreetvaleurs.add(
				(new Lettre("I", 1, new ImageIcon("src/images/I_joker.jpg"), new ImageIcon("src/images/Igris.jpg"))));
		lettreetvaleurs.add(
				(new Lettre("A", 1, new ImageIcon("src/images/A_joker.jpg"), new ImageIcon("src/images/A_gris.jpg"))));
		lettreetvaleurs.add(
				(new Lettre("O", 1, new ImageIcon("src/images/O_joker.jpg"), new ImageIcon("src/images/Ogris.jpg"))));

		lettreetvaleurs.add(
				(new Lettre("N", 1, new ImageIcon("src/images/N_joker.jpg"), new ImageIcon("src/images/Ngris.jpg"))));

		lettreetvaleurs.add(
				new Lettre("R", 1, new ImageIcon("src/images/R_joker.jpg"), new ImageIcon("src/images/Rgris.jpg")));
		lettreetvaleurs.add(
				new Lettre("S", 1, new ImageIcon("src/images/S_joker.jpg"), new ImageIcon("src/images/Sgris.jpg")));
		lettreetvaleurs.add(
				new Lettre("U", 1, new ImageIcon("src/images/U_joker.jpg"), new ImageIcon("src/images/Ugris.jpg")));
		lettreetvaleurs.add(
				new Lettre("T", 1, new ImageIcon("src/images/T_joker.jpg"), new ImageIcon("src/images/Tgris.jpg")));
		lettreetvaleurs.add(
				new Lettre("L", 1, new ImageIcon("src/images/L_joker.jpg"), new ImageIcon("src/images/Lgris.jpg")));
		lettreetvaleurs.add(
				new Lettre("D", 2, new ImageIcon("src/images/D_joker.jpg"), new ImageIcon("src/images/Dgris.jpg")));
		lettreetvaleurs.add(
				new Lettre("M", 3, new ImageIcon("src/images/M_joker.jpg"), new ImageIcon("src/images/Mgris.jpg")));
		lettreetvaleurs.add(
				new Lettre("G", 2, new ImageIcon("src/images/G_joker.jpg"), new ImageIcon("src/images/Ggris.jpg")));
		lettreetvaleurs.add(
				new Lettre("B", 3, new ImageIcon("src/images/B_joker.jpg"), new ImageIcon("src/images/Bgris.jpg")));
		lettreetvaleurs.add(
				new Lettre("C", 3, new ImageIcon("src/images/C_joker.jpg"), new ImageIcon("src/images/Cgris.jpg")));
		lettreetvaleurs.add(
				new Lettre("P", 3, new ImageIcon("src/images/P_joker.jpg"), new ImageIcon("src/images/Pgris.jpg")));
		lettreetvaleurs.add(
				new Lettre("F", 4, new ImageIcon("src/images/F_joker.jpg"), new ImageIcon("src/images/Fgris.jpg")));
		lettreetvaleurs.add(
				new Lettre("H", 4, new ImageIcon("src/images/H_joker.jpg"), new ImageIcon("src/images/Hgris.jpg")));
		lettreetvaleurs.add(
				new Lettre("V", 4, new ImageIcon("src/images/V_joker.jpg"), new ImageIcon("src/images/Vgris.jpg")));

		lettreetvaleurs.add(
				new Lettre("W", 4, new ImageIcon("src/images/W_joker.jpg"), new ImageIcon("src/images/Wgris.jpg")));
		lettreetvaleurs.add(
				new Lettre("Y", 4, new ImageIcon("src/images/Y_joker.jpg"), new ImageIcon("src/images/Ygris.jpg")));
		lettreetvaleurs.add(
				new Lettre("K", 5, new ImageIcon("src/images/K_joker.jpg"), new ImageIcon("src/images/Kgris.jpg")));
		lettreetvaleurs.add(
				new Lettre("J", 8, new ImageIcon("src/images/J_joker.jpg"), new ImageIcon("src/images/Jgris.jpg")));
		lettreetvaleurs.add(
				new Lettre("X", 8, new ImageIcon("src/images/X_joker.jpg"), new ImageIcon("src/images/Xgris.jpg")));
		lettreetvaleurs.add(
				new Lettre("Q", 10, new ImageIcon("src/images/Q_joker.jpg"), new ImageIcon("src/images/Qgris.jpg")));
		lettreetvaleurs.add(
				new Lettre("Z", 10, new ImageIcon("src/images/Z_joker.jpg"), new ImageIcon("src/images/Zgris.jpg")));

		ArrayList<String> possibilitecles = new ArrayList<>();
		ArrayList<String> lettreClavier = new ArrayList<>();
		for (Lettre lettre : j) {
			lettreClavier.add(lettre.nom);
		}
		// on cherche les clés possibles avec les lettres du plateau
		// cas avec joker dans les lettres joueurs
		if (lettreClavier.contains(" ")) {
			for (int i = 0; i < lettreetvaleurs.size(); i++) {
				for (int l = 0; l < j.size(); l++) {
					possibilitecles.add(lettreetvaleurs.get(i).nom + j.get(l).nom);
				}
			}
			for (int i = 0; i < j.size(); i++) {
				for (int k = 0; k < j.size(); k++) {
					if (i != k && !possibilitecles.contains(j.get(i).nom + j.get(k).nom)) {
						possibilitecles.add(j.get(i).nom + j.get(k).nom);
					}
				}
			}
		}
		// cas sans joker dans lettre joueurs
		else {
			for (int i = 0; i < j.size(); i++) {

				for (int k = 0; k < j.size(); k++) {
					if (i != k) {
						possibilitecles.add(j.get(i).nom + j.get(k).nom);
					}
				}
			}
		}

		for (int k = 0; k < possibilitecles.size(); k++) {

			String p = possibilitecles.get(k);
			if (dico.containsKey(p)) {
				ArrayList<String> l = dico.get(p);

				for (String mot : l) {
					ArrayList<String> lettrecla = (ArrayList<String>) lettreClavier.clone();

					Boolean motpos = true;

					for (int i = 0; i < mot.length(); i++) {
						// il faut supprimer la lettre du clavier;
						if (lettrecla.contains(Character.toString(mot.charAt(i))) == false
								&& !lettrecla.contains(" ")) {
							motpos = false;
						}
						if (lettrecla.contains(Character.toString(mot.charAt(i))) == false && lettrecla.contains(" ")) {
							lettrecla.remove(" ");
						} else {
							lettrecla.remove(Character.toString(mot.charAt(i)));
						}
					}
					if (motpos == true && !motpossible.contains(mot)) {

						motpossible.add(mot);

					}
				}

			}
		}
		// on transforme l'arraylist de Suggestion en List pour l'utiliser dans un Jlist
		motpossible.sort(null);
		suggestionlist = new String[motpossible.size()];
		suggestionlist = motpossible.toArray(suggestionlist);
	}
}