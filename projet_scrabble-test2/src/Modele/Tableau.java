package Modele;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import javafx.util.Pair;

public class Tableau {
	public Case[][] tableau;
	File fichiertableau = new File("Temp/tableau.dat");
	File fichiermot = new File("Temp/mot_valide.dat");
	File fichiercasj = new File("Temp/casejouables.dat");
	public ArrayList<String> mot_valide;
	public ArrayList<Case> casejouables;
	public ImageIcon[] imageplateau = { new ImageIcon("src/images/VERT.jpg"), new ImageIcon("src/images/MT.jpg"),
			new ImageIcon("src/images/LT.jpg"), new ImageIcon("src/images/LD.jpg"), null,
			new ImageIcon("src/images/MD.jpg"), new ImageIcon("src/images/MILIEU.jpg") };
	public String[] def = { "", "MT", "LT", "LD", "", "MD", "" };
	public Dico dic;

	public Tableau() throws IOException {
		dic = new Dico();
		try {
			FileInputStream fis = new FileInputStream(fichiertableau);
			ObjectInputStream ois = new ObjectInputStream(fis);
			this.tableau = (Case[][]) ois.readObject();
			ois.close();
			fis.close();

			FileInputStream fis1 = new FileInputStream(fichiermot);
			ObjectInputStream ois1 = new ObjectInputStream(fis1);
			this.mot_valide = (ArrayList<String>) ois1.readObject();
			ois1.close();
			fis1.close();
			FileInputStream fis2 = new FileInputStream(fichiercasj);
			ObjectInputStream ois2 = new ObjectInputStream(fis2);
			this.casejouables = (ArrayList<Case>) ois2.readObject();
			ois2.close();
			fis2.close();

		} catch (IOException | ClassNotFoundException e) {
			System.out.println("yolo");
			casejouables = new ArrayList<Case>();
			this.tableau = new Case[15][15];
			// this.dico = new Dico().dico;
			for (int i = 0; i < 15; i++) { // initialisation du tableau
				for (int j = 0; j < 15; j++) {
					tableau[i][j] = new Case();
				}
			}

			tableau[0][0].bonus = 1;
			tableau[7][0].bonus = 1;
			tableau[0][7].bonus = 1;
			tableau[0][0].image = new ImageIcon("src/images/MT.jpg");
			tableau[7][0].image = new ImageIcon("src/images/MT.jpg");
			tableau[0][7].image = new ImageIcon("src/images/MT.jpg");
			// carre haut gauche
			for (int i = 0; i < 8; i++) {

				for (int j = 0; j < 8; j++) {
					// on remplie par carre de 7 par 7 car tout est symétrique
					// couleur bleu fonce
					if (j == 5 & i == 1) {
						tableau[i][j].bonus = 2;
						tableau[j][i].bonus = 2;
						tableau[5][5].bonus = 2;
						tableau[i][j].image = new ImageIcon("src/images/LT.jpg");
						tableau[j][i].image = new ImageIcon("src/images/LT.jpg");
						tableau[5][5].image = new ImageIcon("src/images/LT.jpg");
					}
					if (i == 0 & j == 3) {
						tableau[i][j].bonus = 3;
						tableau[j][i].bonus = 3;
						tableau[6][6].bonus = 3;
						tableau[i][j].image = new ImageIcon("src/images/LD.jpg");
						tableau[j][i].image = new ImageIcon("src/images/LD.jpg");
						tableau[6][6].image = new ImageIcon("src/images/LD.jpg");
					}
					if (i == 6 & j == 2) {
						tableau[i][j].bonus = 3;
						tableau[j][i].bonus = 3;
						tableau[i][j].image = new ImageIcon("src/images/LD.jpg");
						tableau[j][i].image = new ImageIcon("src/images/LD.jpg");

					}
					if (i == 7 & j == 3) {
						tableau[i][j].bonus = 3;
						tableau[j][i].bonus = 3;
						tableau[i][j].image = new ImageIcon("src/images/LD.jpg");
						tableau[j][i].image = new ImageIcon("src/images/LD.jpg");

					}

					// couleur rose

					if (i < 7 && j < 7) {

						if (tableau[i][j].bonus == 0) {
							if (i == j) {
								tableau[i][j].bonus = 5;
								tableau[i][j].image = new ImageIcon("src/images/MD.jpg");
							}
						}
					}
				}
			}
			// carre haut droit
			for (int i = 0; i < 7; i++) {

				for (int j = 7; j < 15; j++) {
					ImageIcon img = tableau[i][7 - (j - 7)].image;
					int b = tableau[i][7 - (j - 7)].bonus;
					tableau[i][j].image = img;
					tableau[i][j].bonus = b;
					if (j == 7 & i != 7) {
						ImageIcon img1 = tableau[i][0].image;
						int c = tableau[i][0].bonus;
						tableau[i][j].bonus = c;
						tableau[i][j].image = img1;
					}
				}
			}
			// carre bas gauche
			for (int i = 7; i < 15; i++) {
				for (int j = 0; j < 7; j++) {
					ImageIcon img = tableau[7 - (i - 7)][j].image;
					int b = tableau[7 - (i - 7)][j].bonus;
					tableau[i][j].bonus = b;
					tableau[i][j].image = img;
					if (j == 7 & i != 7) {
						ImageIcon img1 = tableau[i][0].image;
						int c = tableau[i][0].bonus;
						tableau[i][j].bonus = c;
						tableau[i][j].image = img1;
					}

				}
			}
			// carre bas droit
			for (int i = 7; i < 15; i++) {

				for (int j = 7; j < 15; j++) {

					ImageIcon img = tableau[i][7 - (j - 7)].image;
					int b = tableau[i][7 - (j - 7)].bonus;
					tableau[i][j].image = img;
					tableau[i][j].bonus = b;
					if (j == 7 & i != 7) {
						ImageIcon img1 = tableau[i][0].image;
						int c = tableau[i][0].bonus;
						tableau[i][j].bonus = c;
						tableau[i][j].image = img1;
					}

				}
			}
			tableau[7][7].bonus = 6;
			tableau[7][7].image = new ImageIcon("src/images/MILIEU.jpg");
			tableau[7][7].jouable = true;
			// afficher_matrice();
			// System.out.println("test 1 : " + tableau[0][14].bonus);
			// System.out.println("test 2 : " + tableau[14][0].bonus);
		}
	}

	public void resetjouable() { // réinitialise le plateau
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				tableau[i][j].jouable = false;
			}
		}
	}

	public void posee(int o, int p, Bouton btn) { // définit sur quelles cases on peut poser
		if (o == 7 && p == 7) {
			tableau[o + 1][p].jouable = true;
			tableau[o - 1][p].jouable = true;
			tableau[o][p - 1].jouable = true;
			tableau[o][p + 1].jouable = true;
		}
		/*
		 * if (o == 7 && p == 7) {
		 * 
		 * tableau[o + 1][p].jouable = true; tableau[o - 1][p].jouable = true;
		 * tableau[o][p - 1].jouable = true; tableau[o][p + 1].jouable = true; }
		 */
		// on différencie les cas
		// si on pose dans un angle
		if ((o == 0 && p == 0) || (o == 0 && p == 14) || (o == 14 && p == 14) || (o == 14 && p == 0) || p == 0
				|| p == 14 || o == 0 || o == 14) {

			if (o == 0 && p == 0) {

				if (tableau[o + 1][p].occupe == true) {
					if (tableau[o][p + 1].occupe == false) {
						tableau[o][p + 1].jouable = true;
					}
				}
				if (tableau[o][p + 1].occupe = true) {
					if (tableau[o + 1][p].occupe == false) {
						tableau[o + 1][p].jouable = true;
					}
				}
			}
			if (o == 0 && p == 14) {

				if (tableau[o][p - 1].occupe == true) {
					if (tableau[o + 1][p].occupe == false) {
						tableau[o + 1][p].jouable = true;
					}
				}
				if (tableau[o + 1][p].occupe = true) {
					if (tableau[o][p - 1].occupe == false) {
						tableau[o][p - 1].jouable = true;
					}
				}
			}
			if (o == 14 && p == 14) {

				if (tableau[o][p - 1].occupe == true) {
					if (tableau[o - 1][p].occupe == false) {
						tableau[o - 1][p].jouable = true;
					}
				}
				if (tableau[o - 1][p].occupe = true) {
					if (tableau[o][p - 1].occupe == false) {
						tableau[o][p - 1].jouable = true;
					}
				}
			}
			if (o == 14 && p == 0) {

				if (tableau[o][p + 1].occupe == true) {
					if (tableau[o - 1][p].occupe == false) {
						tableau[o - 1][p].jouable = true;
					}
				}
				if (tableau[o - 1][p].occupe = true) {
					if (tableau[o][p + 1].occupe == false) {
						tableau[o][p + 1].jouable = true;
					}
				}
			}

			// si on pose sur un coté

			if (p == 0 && o != 0 && o != 14) {

				if (tableau[o + 1][p].occupe == true) {
					if (tableau[o - 1][p].occupe == false) {
						tableau[o - 1][p].jouable = true;
					}
					if (tableau[o][p + 1].occupe == false) {
						tableau[o][p + 1].jouable = true;
					}
				}
				if (tableau[o - 1][p].occupe == true) {
					if (tableau[o + 1][p].occupe == false) {
						tableau[o + 1][p].jouable = true;
					}
					if (tableau[o][p + 1].occupe == false) {
						tableau[o][p + 1].jouable = true;
					}
				}
				if (tableau[o][p + 1].occupe == true) {
					if (tableau[o + 1][p].occupe == false) {
						tableau[o + 1][p].jouable = true;
					}
					if (tableau[o - 1][p].occupe == false) {
						tableau[o - 1][p].jouable = true;
					}
				}
			}
			if (o == 0 && p != 0 && p != 14) {

				if (tableau[o][p + 1].occupe == true) {
					if (tableau[o][p - 1].occupe == false) {
						tableau[o][p - 1].jouable = true;
					}
					if (tableau[o + 1][p].occupe == false) {
						tableau[o + 1][p].jouable = true;
					}
				}
				if (tableau[o][p - 1].occupe == true) {
					if (tableau[o][p + 1].occupe == false) {
						tableau[o][p + 1].jouable = true;
					}
					if (tableau[o + 1][p].occupe == false) {
						tableau[o + 1][p].jouable = true;
					}
				}
				if (tableau[o + 1][p].occupe == true) {
					if (tableau[o][p + 1].occupe == false) {
						tableau[o][p + 1].jouable = true;
					}
					if (tableau[o][p - 1].occupe == false) {
						tableau[o][p - 1].jouable = true;
					}
				}
			}
			if (p == 14 && o != 0 && o != 14) {

				if (tableau[o + 1][p].occupe == true) {
					if (tableau[o - 1][p].occupe == false) {
						tableau[o - 1][p].jouable = true;
					}
					if (tableau[o][p - 1].occupe == false) {
						tableau[o][p - 1].jouable = true;
					}
				}
				if (tableau[o - 1][p].occupe == true) {
					if (tableau[o + 1][p].occupe == false) {
						tableau[o + 1][p].jouable = true;
					}
					if (tableau[o][p - 1].occupe == false) {
						tableau[o][p - 1].jouable = true;
					}
				}
				if (tableau[o][p - 1].occupe == true) {
					if (tableau[o + 1][p].occupe == false) {
						tableau[o + 1][p].jouable = true;
					}
					if (tableau[o - 1][p].occupe == false) {
						tableau[o - 1][p].jouable = true;
					}
				}
			}
			if (o == 14 && p != 0 && p != 14) {

				if (tableau[o][p - 1].occupe == true) {
					if (tableau[o][p + 1].occupe == false) {
						tableau[o][p + 1].jouable = true;
					}
					if (tableau[o - 1][p].occupe == false) {
						tableau[o - 1][p].jouable = true;
					}
				}
				if (tableau[o][p + 1].occupe == true) {
					if (tableau[o][p - 1].occupe == false) {
						tableau[o][p - 1].jouable = true;
					}
					if (tableau[o - 1][p].occupe == false) {
						tableau[o - 1][p].jouable = true;
					}
				}
				if (tableau[o - 1][p].occupe == true) {
					if (tableau[o][p - 1].occupe == false) {
						tableau[o][p - 1].jouable = true;
					}
					if (tableau[o][p + 1].occupe == false) {
						tableau[o][p + 1].jouable = true;
					}
				}
			}
		}
		// si on pose ailleurs
		else {
			if (tableau[o][p - 1].occupe == true && p != 0) {

				if (tableau[o][p + 1].occupe == false && p != 14) {
					tableau[o][p + 1].jouable = true;
				}
				if (tableau[o + 1][p].occupe == false && o != 14) {
					tableau[o + 1][p].jouable = true;
				}
				if (tableau[o - 1][p].occupe == false && o != 0) {
					tableau[o - 1][p].jouable = true;
				}

			}
			if (tableau[o][p + 1].occupe == true && p != 14) {

				if (tableau[o][p - 1].occupe == false && p != 0) {
					tableau[o][p - 1].jouable = true;
				}
				if (tableau[o + 1][p].occupe == false && o != 14) {
					tableau[o + 1][p].jouable = true;
				}
				if (tableau[o - 1][p].occupe == false && o != 0) {
					tableau[o - 1][p].jouable = true;
				}
			}
			if (tableau[o - 1][p].occupe == true && o != 0) {

				if (tableau[o][p - 1].occupe == false && p != 0) {
					tableau[o][p - 1].jouable = true;
				}
				if (tableau[o][p + 1].occupe == false && p != 14) {
					tableau[o][p + 1].jouable = true;

				}
				if (tableau[o + 1][p].occupe == false && o != 14) {
					tableau[o + 1][p].jouable = true;
				}
			}
			if (tableau[o + 1][p].occupe == true && o != 14) {

				if (tableau[o][p - 1].occupe == false && p != 0) {
					tableau[o][p - 1].jouable = true;
				}
				if (tableau[o][p + 1].occupe == false && p != 14) {
					tableau[o][p + 1].jouable = true;
				}
				if (tableau[o - 1][p].occupe == false && o != 0) {
					tableau[o - 1][p].jouable = true;
				}
			}
		}
		/*
		 * if (tableau[o - 1][p].occupe == true && tableau[o + 1][p].occupe == false &&
		 * o != 14) { tableau[o + 1][p].jouable = true; } if (o != 0 && tableau[o +
		 * 1][p].occupe == true && tableau[o - 1][p].occupe == false) { tableau[o -
		 * 1][p].jouable = true; } if (tableau[o][p - 1].occupe == false && tableau[o][p
		 * + 1].occupe == true && p != 0) { tableau[o][p - 1].jouable = true; } if
		 * (tableau[o][p + 1].occupe == false && tableau[o][p - 1].occupe == true && p
		 * != 14) { tableau[o][p + 1].jouable = true;
		 * 
		 * }
		 */
		tableau[o][p].jouee = true;
		tableau[o][p].occupe = true;
		tableau[o][p].lettre = btn.boutonass.lettre;
		tableau[o][p].image = tableau[o][p].lettre.image;
		// afficher_matrice();

	}

	public void retiree(int o, int p, Bouton btn) { // lorsqu'on enlève une lettre du plateau

		tableau[o][p].jouee = false;
		tableau[o][p].occupe = false;
		tableau[o][p].lettre = null;
		tableau[o][p].image = imageplateau[tableau[o][p].bonus];

	}

	public boolean verifPlacLettres(int taille, int i, int j) { // vérfie que toutes les lettres sont sur la même ligne
																// ou colonne
		int a = i;
		int cpt1 = 0;
		int cpt2 = 0;
		while (a < 15 && tableau[a][j].lettre != null) {
			if (tableau[a][j].jouee) {
				cpt1 += 1;
			}
			a++;
		}
		a = j;
		while (a < 15 && tableau[i][a].lettre != null) {
			if (tableau[i][a].jouee) {
				cpt2 += 1;
			}
			a++;
		}
		return (cpt1 == taille || cpt2 == taille);
	}

	public Pair<Boolean, Integer[]> comptescore(int taille) { // lit tous les mots et vérifie qu'ils existent
		int i = 0;
		int j = 0;
		while (tableau[i][j].jouee == false) {
			j++;
			if (j == 15) {
				i += 1;
				j = 0;
			}
		}
		System.out.println("coordonnées : " + i + ", " + j);
		boolean essai = verifPlacLettres(taille, i, j);
		System.out.println("meme ligne ? : " + essai);
		if (verifPlacLettres(taille, i, j)) {
			ArrayList<String[]> liste_mots = new ArrayList<String[]>();
			mot_valide = new ArrayList<String>();
			// if (i!=14) {
			// liste_mots.addAll(mot_vertical(i, j));
			// }
			System.out.println("c2 " + i + j);
			// if (j!=14) {
			liste_mots.addAll(mot_horizontal(i, j));
			// }
			boolean valable = true;
			Integer[] scores = new Integer[liste_mots.size() + 1];
			for (int ind = 0; ind < liste_mots.size(); ind++) {
				String[] el = liste_mots.get(ind);
				System.out.println(el[0]);
				valable = valable && dic.verifier_mot(el[0]);
				if (dic.verifier_mot(el[0]) == true && el[0] != "") {
					// System.out.println(el[0]);
					mot_valide.add(el[0]);
				}
				scores[ind] = Integer.parseInt(el[1]);
			}
			if (taille == 7) {
				scores[scores.length - 1] = 50; // correspond au bonus si on place toutes ses lettres
			} else {
				scores[scores.length - 1] = 0;
			}
			System.out.print(valable);
			/*
			 * String mot1 = r1[0]; String mot2 = r2[0]; int score_m1 =
			 * Integer.parseInt(r1[1]); int score_m2 = Integer.parseInt(r2[1]); Integer[]
			 * scores = {score_m1, score_m2}; System.out.println(mot1 + " " + score_m1 + " "
			 * + dic.verifier_mot(mot1)); System.out.println(mot2 + " " + score_m2 + " " +
			 * dic.verifier_mot(mot2)); Boolean b = dic.verifier_mot(mot1) &&
			 * dic.verifier_mot(mot2);
			 */
			Pair<Boolean, Integer[]> pair = new Pair<Boolean, Integer[]>(valable, scores);
			return pair;
		} else {
			Integer[] t = {};
			Pair<Boolean, Integer[]> pair = new Pair<Boolean, Integer[]>(false, t);
			return pair;
		}

	}

	public ArrayList<String[]> mot_horizontal(int i, int j) { // lit un mot horizontal à partir des coordonnées (i, j)
		int score_m1 = 0;
		int mults1 = 1;
		String mot1 = "";
		ArrayList<String[]> liste_mots = new ArrayList<String[]>();
		System.out.println("je passe par ici");
		// if (tableau[i][j + 1].occupe == true || tableau[i][j - 1].occupe == true) {//
		// de droite à gauche
		if (j != 0) {
			while (tableau[i][j - 1].occupe == true && j != 0) {// retrouve le debut du mot
				j -= 1;
			}
		}

		if ((j < 14 && !tableau[i][j + 1].occupe) || j == 14) {
			if (tableau[i][j].jouee) {
				tableau[i][j].jouee = false;
				ArrayList<String[]> test = mot_vertical(i, j);
				for (String[] el : test) {
					liste_mots.add(el);
					System.out.println(el[0]);
				}
			}
		}
		if (j < 14 && tableau[i][j + 1].occupe) {
			while (j <= 14 && tableau[i][j].occupe == true) {

				if (tableau[i][j].bonus == 0) {// sans bonus
					score_m1 += tableau[i][j].lettre.valeur;
				}
				if (tableau[i][j].bonus == 6) {// sans bonus
					score_m1 += tableau[i][j].lettre.valeur;
				}

				if (tableau[i][j].bonus == 5) {// mot double
					score_m1 += tableau[i][j].lettre.valeur;
					mults1 *= 2;
				}
				if (tableau[i][j].bonus == 3) {// lettre double
					score_m1 += tableau[i][j].lettre.valeur * 2;
				}

				if (tableau[i][j].bonus == 1) {// mot triple
					score_m1 += tableau[i][j].lettre.valeur;
					mults1 *= 3;
				}

				if (tableau[i][j].bonus == 2) {// lettre triple
					score_m1 += tableau[i][j].lettre.valeur * 3;
				}
				// tableau[i][j].bonus = 0;
				// tableau[i][j].jouee = false;
				// tableau[i][j].verouillee = true;
				mot1 += tableau[i][j].lettre.nom;
				System.out.println("lettre lue : " + tableau[i][j].lettre.nom);
				if (tableau[i][j].jouee) {
					tableau[i][j].jouee = false;
					ArrayList<String[]> test = mot_vertical(i, j);
					for (String[] el : test) {
						liste_mots.add(el);
						System.out.println(el[0]);
					}
				}
				j += 1;

				// }
			}
		}
		System.out.println("Le mot 1 est : " + mot1);
		System.out.println("Le score pour le mot 1 est : " + score_m1 * mults1);
		String[] resultat = { mot1, String.valueOf(score_m1 * mults1) };
		liste_mots.add(resultat);
		// System.out.println(resultat);
		return liste_mots;
	}

	public ArrayList<String[]> mot_vertical(int i, int j) { // lit un mot vertical à partir des coordonnées (i, j)
		int score_m2 = 0;
		int mults2 = 1;
		ArrayList<String[]> liste_mots = new ArrayList<String[]>();
		String mot2 = "";
		System.out.println("je passe par ici");
		// if (tableau[i - 1][j].occupe == true || tableau[i + 1][j].occupe == true) {//
		// de haut en bas
		if (i != 0) {
			while (tableau[i - 1][j].occupe == true && i != 0) {// retrouve le debut du mot

				i -= 1;
			}
		}
		if (i < 14 && tableau[i + 1][j].occupe) {
			while (i <= 14 && tableau[i][j].occupe == true) {
				// tableau[i][j].jouee = false;
				if (tableau[i][j].bonus == 0) {// sans bonus
					score_m2 += tableau[i][j].lettre.valeur;
				}
				if (tableau[i][j].bonus == 6) {// sans bonus
					score_m2 += tableau[i][j].lettre.valeur;
				}

				if (tableau[i][j].bonus == 5) {// mot double
					score_m2 += tableau[i][j].lettre.valeur;
					mults2 *= 2;
				}
				if (tableau[i][j].bonus == 3) {// lettre double
					score_m2 += tableau[i][j].lettre.valeur * 2;
				}

				if (tableau[i][j].bonus == 1) {// mot triple
					score_m2 += tableau[i][j].lettre.valeur;
					mults2 *= 3;
				}

				if (tableau[i][j].bonus == 2) {// lettre triple
					score_m2 += tableau[i][j].lettre.valeur * 3;

				}
				// tableau[i][j].bonus = 0;
				// tableau[i][j].jouee = false;
				mot2 += tableau[i][j].lettre.nom;
				System.out.println("lettre lue : " + tableau[i][j].lettre.nom);
				if (tableau[i][j].jouee) {
					tableau[i][j].jouee = false;
					ArrayList<String[]> test = mot_horizontal(i, j);
					for (String[] el : test) {
						liste_mots.add(el);
						System.out.println(el[0]);
					}
				}
				i += 1;
			}
		}
		System.out.println("Le mot 2 est : " + mot2);
		System.out.println("Le score pour le mot 2 est : " + score_m2 * mults2);
		String[] resultat = { mot2, String.valueOf(score_m2 * mults2) };
		liste_mots.add(resultat);
		// System.out.println(resultat);
		return liste_mots;
	}

	public void revalid(ArrayList<Pair> listecasejouee) { // repasse toutes les cases à jouee après vérification
		for (int k = 0; k < listecasejouee.size(); k++) {
			int i = (int) listecasejouee.get(k).getKey();
			int j = (int) listecasejouee.get(k).getValue();
			tableau[i][j].jouee = true;
		}
	}

	public void majmauvaismot(ArrayList<Pair> listecasejouee) { // ce qui se passe lorsque le mot est incorrect
		for (int k = 0; k < listecasejouee.size(); k++) {
			int i = (int) listecasejouee.get(k).getKey();
			int j = (int) listecasejouee.get(k).getValue();
			tableau[i][j].occupe = false;
			tableau[i][j].image = imageplateau[tableau[i][j].bonus];
			// tableau[i][j].jouee = false;
		}
	}

	public void majbonmot(ArrayList<Pair> listecasejouee) { // ce qui se passe lorsque le mot est correct
		System.out.print(listecasejouee);
		for (int k = 0; k < listecasejouee.size(); k++) {
			int i = (int) listecasejouee.get(k).getKey();
			int j = (int) listecasejouee.get(k).getValue();
			tableau[i][j].bonus = 0;
			// tableau[i][j].jouee = false;
			tableau[i][j].verouillee = true;
			tableau[i][j].occupe = true;
		}

	}

	public void afficher_matrice() { // permet d'afficher les éléments du tableau
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				System.out.print(tableau[i][j].lettre + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}

	public void enregistrer() {
		try {
			FileOutputStream fos = new FileOutputStream(fichiertableau);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this.tableau);
			oos.close();
			fos.close();
			FileOutputStream fos1 = new FileOutputStream(fichiercasj);
			ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
			oos1.writeObject(this.casejouables);
			oos1.close();
			fos1.close();
			FileOutputStream fos2 = new FileOutputStream(fichiermot);
			ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
			oos2.writeObject(this.mot_valide);
			oos2.close();
			fos2.close();
		} catch (IOException e1) {
			throw new RuntimeException("Impossible d'ecrire les donnees");
		}
	}

}
