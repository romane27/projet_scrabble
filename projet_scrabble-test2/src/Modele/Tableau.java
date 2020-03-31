package Modele;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;

public class Tableau {
	public Case[][] tableau;
	HashMap<String, ArrayList<String>> dico;
	int mot_triple = 1;
	int lettre_triple = 2;
	int mot_double = 5;
	int lettre_double = 3;
	int sans_bonus = 0;
	public Color[] couleur = { Color.green, Color.red, Color.getHSBColor(0, 128, 255), Color.cyan, null, Color.pink,
			Color.pink };
	public String[] def = { "", "MT", "LT", "LD", "", "MD", "" };

	public Tableau() {

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

		// carre haut gauche
		for (int i = 0; i < 8; i++) {

			for (int j = 0; j < 8; j++) {
				// on remplie par carre de 7 par 7 car tout est symétrique
				// couleur bleu fonce
				if (j == 5 & i == 1) {
					tableau[i][j].bonus = 2;
					tableau[j][i].bonus = 2;
					tableau[5][5].bonus = 2;
				}
				if (i == 0 & j == 3) {
					tableau[i][j].bonus = 3;
					tableau[j][i].bonus = 3;
					tableau[6][6].bonus = 3;
				}
				if (i == 6 & j == 2) {
					tableau[i][j].bonus = 3;
					tableau[j][i].bonus = 3;

				}
				if (i == 7 & j == 3) {
					tableau[i][j].bonus = 3;
					tableau[j][i].bonus = 3;

				}

				// couleur rose

				if (i < 7 && j < 7) {

					if (tableau[i][j].bonus == 0) {
						if (i == j) {
							tableau[i][j].bonus = 5;
						}
					}
				}
			}
		}
		// carre haut droit
		for (int i = 0; i < 7; i++) {

			for (int j = 7; j < 15; j++) {
				int b = tableau[i][7 - (j - 7)].bonus;
				tableau[i][j].bonus = b;
				if (j == 7 & i != 7) {
					int c = tableau[i][0].bonus;
					tableau[i][j].bonus = c;
				}
			}
		}
		// carre bas gauche
		for (int i = 7; i < 15; i++) {
			for (int j = 0; j < 7; j++) {
				int b = tableau[7 - (i - 7)][j].bonus;
				tableau[i][j].bonus = b;
				if (j == 7 & i != 7) {
					int c = tableau[i][0].bonus;
					tableau[i][j].bonus = c;
				}

			}
		}
		// carre bas droit
		for (int i = 7; i < 15; i++) {

			for (int j = 7; j < 15; j++) {
				int b = tableau[i][7 - (j - 7)].bonus;
				tableau[i][j].bonus = b;
				if (j == 7 & i != 7) {
					int c = tableau[i][0].bonus;
					tableau[i][j].bonus = c;
				}

			}
		}
		tableau[7][7].bonus = 6;
		tableau[7][7].jouable = true;
	}

	public void majjouable(int o, int p, int i) {
		if (i == 1) {
			if (o != 0 && o != 14 && p != 0 && p != 14) {
				if (tableau[o - 1][p].occupe == false) {
					tableau[o - 1][p].jouable = true;
				}
				if (tableau[o + 1][p].occupe == false) {
					tableau[o + 1][p].jouable = true;
				}
				if (tableau[o][p - 1].occupe == false) {
					tableau[o][p - 1].jouable = true;
				}
				if (tableau[o][p + 1].occupe == false) {
					tableau[o][p + 1].jouable = true;
				}
			}
		}
	}

	public void posee(int o, int p, Bouton btn) {
		if (o != 0 && o != 14 && p != 0 && p != 14) {
			if (tableau[o - 1][p].occupe == false) {
				tableau[o - 1][p].jouable = true;
			}
			if (tableau[o + 1][p].occupe == false) {
				tableau[o + 1][p].jouable = true;
			}
			if (tableau[o][p - 1].occupe == false) {
				tableau[o][p - 1].jouable = true;
			}
			if (tableau[o][p + 1].occupe == false) {
				tableau[o][p + 1].jouable = true;
			}
		}
		tableau[o][p].jouee = true;
		tableau[o][p].occupe = true;
		tableau[o][p].lettre = btn.boutonass.lettre;

	}

	public void retiree(int o, int p, Bouton btn) {
		tableau[o][p].jouee = false;
		tableau[o][p].occupe = false;
		tableau[o][p].lettre = null;
	}

	public int comptescore() {
		int score = 0;
		int multiplacteurscore = 1;
		int memx = 0;
		int memy = 0;
		int i = 0;
		int j = 0;

		while (tableau[i][j].jouee == false) {
			j++;
			if (j == 14) {
				i += 1;
				j = 0;
			}

		}

		if (tableau[i][j + 1].occupe == true || tableau[i][j - 1].occupe == true) {// de droite à gauche

			while (tableau[i][j - 1].occupe == true) {// retrouve le debut du mot

				j -= 1;
			}

			while (tableau[i][j].occupe == true) {

				if (tableau[i][j].bonus == 0) {// sans bonus
					score += tableau[i][j].lettre.valeur;
				}
				if (tableau[i][j].bonus == 6) {// sans bonus
					score += tableau[i][j].lettre.valeur;
				}

				if (tableau[i][j].bonus == 5) {// mot double
					score += tableau[i][j].lettre.valeur;
					multiplacteurscore *= 2;
					tableau[i][j].bonus = 0;
				}
				if (tableau[i][j].bonus == 3) {// lettre double
					score += tableau[i][j].lettre.valeur * 2;
					tableau[i][j].bonus = 0;
				}

				if (tableau[i][j].bonus == 1) {// mot triple
					score += tableau[i][j].lettre.valeur;
					multiplacteurscore *= 3;
					tableau[i][j].bonus = 0;
				}

				if (tableau[i][j].bonus == 2) {// lettre triple
					score += tableau[i][j].lettre.valeur * 3;
					tableau[i][j].bonus = 0;
				}
				j += 1;
			}
		}
		if (tableau[i - 1][j].occupe == true || tableau[i + 1][j].occupe == true) {// de droite à gauche

			while (tableau[i - 1][j].occupe == true) {// retrouve le debut du mot

				i -= 1;
			}

			while (tableau[i][j].occupe == true) {
				tableau[i][j].jouee = false;
				if (tableau[i][j].bonus == 0) {// sans bonus
					score += tableau[i][j].lettre.valeur;
				}
				if (tableau[i][j].bonus == 6) {// sans bonus
					score += tableau[i][j].lettre.valeur;
				}

				if (tableau[i][j].bonus == 5) {// mot double
					score += tableau[i][j].lettre.valeur;
					multiplacteurscore *= 2;
					tableau[i][j].bonus = 0;
				}
				if (tableau[i][j].bonus == 3) {// lettre double
					score += tableau[i][j].lettre.valeur * 2;
					tableau[i][j].bonus = 0;
				}

				if (tableau[i][j].bonus == 1) {// mot triple
					score += tableau[i][j].lettre.valeur;
					multiplacteurscore *= 3;
					tableau[i][j].bonus = 0;
				}

				if (tableau[i][j].bonus == 2) {// lettre triple
					score += tableau[i][j].lettre.valeur * 3;
					tableau[i][j].bonus = 0;
				}
				i += 1;
			}
		}

		return score;

	}
}
