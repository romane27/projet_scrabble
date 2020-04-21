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

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import javafx.util.Pair;

public class Tableau {
	public Case[][] tableau;
	/*
	 * int mot_triple = 1; int lettre_triple = 2; int mot_double = 5; int
	 * lettre_double = 3; int sans_bonus = 0;
	 */
	public ArrayList<Case> casejouables;
	//public Color[] couleur = { new Color(13, 173, 31), Color.red, new Color(42, 125, 210), Color.cyan, null,
	//		new Color(240, 175, 234), Color.pink };
	public ImageIcon [] imageplateau = {new ImageIcon("src/VERT.jpg"),new ImageIcon("src/MT.jpg"),new ImageIcon("src/LT.jpg"),new ImageIcon("src/LD.jpg"),null,new ImageIcon("src/MD.jpg"),new ImageIcon("src/MILIEU.jpg")};
	public String[] def = { "", "MT", "LT", "LD", "", "MD", "" };
	public Dico dic;

	public Tableau() throws IOException {
		dic = new Dico();
		
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
		//afficher_matrice();
		//System.out.println("test 1 : " + tableau[0][14].bonus);
		//System.out.println("test 2 : " + tableau[14][0].bonus);
	}

	/*public void majjouabletour() {
		for (int i = 1; i < 14; i++) {
			for (int j = 1; j < 14; j++) {
				tableau[i][j].jouable = this.jouable(i, j);
			}
		}
	}*/

	public void resetjouable() {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				tableau[i][j].jouable = false;
			}
		}
	}

	public void posee(int o, int p, Bouton btn) {
		if (o == 7 && p == 7) {
			tableau[o + 1][p].jouable = true;
			tableau[o - 1][p].jouable = true;
			tableau[o][p - 1].jouable = true;
			tableau[o][p + 1].jouable = true;
		}
		if (o == 7 && p == 7) {
			
			tableau[o + 1][p].jouable = true;
			tableau[o - 1][p].jouable = true;
			tableau[o][p - 1].jouable = true;
			tableau[o][p + 1].jouable = true;
		}
		// on différencie les cas 
		// si on pose dans un angle 
		if ((o == 0 && p==0) || (o==0 && p==14) || (o==14 && p==14)||(o==14 && p==0) ||  p==0 || p==14 || o==0 || o==14) {
		
		
			if (o == 0 && p==0) {
				
			if (tableau[o+1][p].occupe==true) {
				if (tableau[o][p+1].occupe==false) {
					tableau[o][p+1].jouable=true;
				}
			}
			if (tableau[o][p+1].occupe=true) {
				if (tableau[o+1][p].occupe==false) {
					tableau[o+1][p].jouable=true;
				}
			}
		}
		if (o==0 && p==14) {
			
			if (tableau[o][p-1].occupe==true) {
				if (tableau[o+1][p].occupe==false) {
					tableau[o+1][p].jouable=true;
				}
			}
			if (tableau[o+1][p].occupe=true) {
				if (tableau[o][p-1].occupe==false) {
					tableau[o][p-1].jouable=true;
				}
			}
		}
		if (o==14 && p==14) {
			
			if (tableau[o][p-1].occupe==true) {
				if (tableau[o-1][p].occupe==false) {
					tableau[o-1][p].jouable=true;
				}
			}
			if (tableau[o-1][p].occupe=true) {
				if (tableau[o][p-1].occupe==false) {
					tableau[o][p-1].jouable=true;
				}
			}
		}
		if (o==14 && p==0) {
			
			if (tableau[o][p+1].occupe==true) {
				if (tableau[o-1][p].occupe==false) {
					tableau[o-1][p].jouable=true;
				}
			}
			if (tableau[o-1][p].occupe=true) {
				if (tableau[o][p+1].occupe==false) {
					tableau[o][p+1].jouable=true;
				}
			}
		}
		
		// si on pose sur un coté 
		
		if (p==0 && o!=0 && o!=14) {
			
			if (tableau[o+1][p].occupe==true) {
				if (tableau[o-1][p].occupe==false) {
					tableau[o-1][p].jouable=true;
				}
				if (tableau[o][p+1].occupe==false) {
					tableau[o][p+1].jouable=true;
				}
			}
			if (tableau[o-1][p].occupe==true) {
				if (tableau[o+1][p].occupe==false) {
					tableau[o+1][p].jouable=true;
				}
				if (tableau[o][p+1].occupe==false) {
					tableau[o][p+1].jouable=true;
				}
			}
		}
		if (o==0 && p!=0 && p!=14) {
			
			if (tableau[o][p+1].occupe==true) {
				if (tableau[o][p-1].occupe==false) {
					tableau[o][p-1].jouable=true;
				}
				if (tableau[o+1][p].occupe==false) {
					tableau[o+1][p].jouable=true;
				}
			}
			if (tableau[o][p-1].occupe==true) {
				if (tableau[o][p+1].occupe==false) {
					tableau[o][p+1].jouable=true;
				}
				if (tableau[o+1][p].occupe==false) {
					tableau[o+1][p].jouable=true;
				}
			}
		}
		if (p==14 && o!=0 && o!=14) {
		
			if (tableau[o+1][p].occupe==true) {
				if (tableau[o-1][p].occupe==false) {
					tableau[o-1][p].jouable=true;
				}
				if (tableau[o][p-1].occupe==false) {
					tableau[o][p-1].jouable=true;
				}
			}
			if (tableau[o-1][p].occupe==true) {
				if (tableau[o+1][p].occupe==false) {
					tableau[o+1][p].jouable=true;
				}
				if (tableau[o][p-1].occupe==false) {
					tableau[o][p-1].jouable=true;
				}
			}
		}
		if (o==14 && p!=0 && p!=14) {
			
			if (tableau[o][p-1].occupe==true) {
				if (tableau[o][p+1].occupe==false) {
					tableau[o][p+1].jouable=true;
				}
				if (tableau[o-1][p].occupe==false) {
					tableau[o-1][p].jouable=true;
				}
			}
			if (tableau[o][p+1].occupe==true) {
				if (tableau[o][p-1].occupe==false) {
					tableau[o][p-1].jouable=true;
				}
				if (tableau[o-1][p].occupe==false) {
					tableau[o-1][p].jouable=true;
				}
			}
		}
		}
		// si on pose ailleurs 
		else {
			if (tableau[o][p-1].occupe==true && p!=0) {
			
				if (tableau[o][p+1].occupe==false && p!=14) {
					tableau[o][p+1].jouable=true;
				}
				if (tableau[o+1][p].occupe==false && o!=14) {
					tableau[o+1][p].jouable=true;
				}
				if (tableau[o-1][p].occupe==false && o!=0) {
					tableau[o-1][p].jouable=true;
				}
				
				
			}
			if (tableau[o][p+1].occupe==true && p!=14) {
				
				if (tableau[o][p-1].occupe==false && p!=0) {
					tableau[o][p-1].jouable=true;
				}
				if (tableau[o+1][p].occupe==false && o!=14) {
					tableau[o+1][p].jouable=true;
				}
				if (tableau[o-1][p].occupe==false && o!=0) {
					tableau[o-1][p].jouable=true;
				}
			}
			if (tableau[o-1][p].occupe==true && o!=0 ) {
				
				if (tableau[o][p-1].occupe==false && p !=0) {
					tableau[o][p-1].jouable=true;
				}
				if (tableau[o][p+1].occupe==false && p!=14) {
					tableau[o][p+1].jouable=true;
					
				}
				if (tableau[o+1][p].occupe==false && o!=14) {
					tableau[o+1][p].jouable=true;
				}
			}
			if (tableau[o+1][p].occupe==true && o!=14) {
				
				if (tableau[o][p-1].occupe==false && p!=0) {
					tableau[o][p-1].jouable=true;
				}
				if (tableau[o][p+1].occupe==false && p!=14) {
					tableau[o][p+1].jouable=true;
				}
				if (tableau[o-1][p].occupe==false && o!=0) {
					tableau[o-1][p].jouable=true;
				}
			}
		}
		/*if (tableau[o - 1][p].occupe == true && tableau[o + 1][p].occupe == false && o != 14) {
			tableau[o + 1][p].jouable = true;
		}
		if (o != 0 && tableau[o + 1][p].occupe == true && tableau[o - 1][p].occupe == false) {
			tableau[o - 1][p].jouable = true;
		}
		if (tableau[o][p - 1].occupe == false && tableau[o][p + 1].occupe == true && p != 0) {
			tableau[o][p - 1].jouable = true;
		}
		if (tableau[o][p + 1].occupe == false && tableau[o][p - 1].occupe == true && p != 14) {
			tableau[o][p + 1].jouable = true;

		}*/
		tableau[o][p].jouee = true;
		tableau[o][p].occupe = true;
		tableau[o][p].lettre = btn.boutonass.lettre;
		//afficher_matrice();

	}

	public void retiree(int o, int p, Bouton btn) {
		tableau[o][p].jouee = false;
		tableau[o][p].occupe = false;
		tableau[o][p].lettre = null;
	}

	public Pair<Boolean, Integer[]> comptescore() {
		int i = 0;
		int j = 0;
		while (tableau[i][j].jouee == false) {
			j++;
			if (j == 15) {
				i += 1;
				j = 0;
			}
		}
		System.out.println("coordonnées : "+i+", "+j);
		String[] r1 = { "", "0"};
		String[] r2 = { "", "0"};
		//if (i!=14) {
		r1 = mot_vertical(i, j);
		//}
		System.out.println("c2 "+i + j);
		//if (j!=14) {
		r2 = mot_horizontal(i,j);
		//}
		String mot1 = r1[0];
		String mot2 = r2[0];
		int score_m1 = Integer.parseInt(r1[1]);
		int score_m2 = Integer.parseInt(r2[1]);
		Integer[] scores = {score_m1, score_m2};
		System.out.println(mot1 + " " + score_m1 + " " + dic.verifier_mot(mot1));
		System.out.println(mot2 + " " + score_m2 + " " + dic.verifier_mot(mot2));
		Boolean b = dic.verifier_mot(mot1) && dic.verifier_mot(mot2);
		Pair<Boolean, Integer[]> pair = new Pair<Boolean, Integer[]>(b, scores);
		return pair;

	}
	
	public String[] mot_horizontal(int i, int j) {
		int score_m1=0;
		int mults1 =1;
		String mot1 = "";
		System.out.println("je passe par ici");
		//if (tableau[i][j + 1].occupe == true || tableau[i][j - 1].occupe == true) {// de droite à gauche
		if (j!=0) {
			while (tableau[i][j - 1].occupe == true && j!=0) {// retrouve le debut du mot
				j -= 1;
			}
		}
		if (tableau[i][j+1].occupe) {
			while (j<=14 && tableau[i][j].occupe == true) {

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
				//tableau[i][j].bonus = 0;
				//tableau[i][j].jouee = false;
				// tableau[i][j].verouillee = true;
				mot1 += tableau[i][j].lettre.nom;
				System.out.println("lettre lue : "+ tableau[i][j].lettre.nom);
				j += 1;

			//}
			}
		}
		System.out.println("Le mot 1 est : " + mot1);
		System.out.println("Le score pour le mot 1 est : " +score_m1*mults1);
		String[] resultat = {mot1, String.valueOf(score_m1*mults1)};
		return resultat;
	}
	
	public String[] mot_vertical(int i, int j) {
		int score_m2=0;
		int mults2 =1;
		String mot2 = "";
		System.out.println("je passe par ici");
		//if (tableau[i - 1][j].occupe == true || tableau[i + 1][j].occupe == true) {// de haut en bas
		if (i!=0) {
			while (tableau[i - 1][j].occupe == true && i!=0) {// retrouve le debut du mot

				i -= 1;
			}
		}
		if (tableau[i+1][j].occupe) {
			while (i<= 14 && tableau[i][j].occupe == true) {
				//tableau[i][j].jouee = false;
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
				//tableau[i][j].bonus = 0;
				//tableau[i][j].jouee = false;
				mot2 += tableau[i][j].lettre.nom;
				System.out.println("lettre lue : "+ tableau[i][j].lettre.nom);
				i += 1;
			}
		}
		System.out.println("Le mot 2 est : " + mot2);
		System.out.println("Le score pour le mot 2 est : " +score_m2*mults2);
		String[] resultat = {mot2, String.valueOf(score_m2*mults2)};
		//System.out.println(resultat);
		return resultat;
	}

	public void majmauvaismot(ArrayList<Pair> listecasejouee) {
		for (int k = 0; k < listecasejouee.size(); k++) {
			int i = (int) listecasejouee.get(k).getKey();
			int j = (int) listecasejouee.get(k).getValue();
			tableau[i][j].occupe = false;
			tableau[i][j].jouee = false;
		}
	}

	public void majbonmot(ArrayList<Pair> listecasejouee) {
		System.out.print(listecasejouee);
		for (int k = 0; k < listecasejouee.size(); k++) {
			int i = (int) listecasejouee.get(k).getKey();
			int j = (int) listecasejouee.get(k).getValue();
			tableau[i][j].bonus = 0;
			tableau[i][j].jouee = false;
			tableau[i][j].verouillee = true;
			tableau[i][j].occupe = true;
		}

	}
	
	public void afficher_matrice() {
		for(int i=0; i<15; i++) {
			for (int j=0; j<15; j++) {
				System.out.print(tableau[i][j].lettre + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}

	/*public boolean jouable(int o, int p) {
		if (o == 7 && p == 7) {
			return true;
		}
		if (tableau[o - 1][p].occupe == true && o != 14) {
			return true;
		}
		if (o != 0 && tableau[o + 1][p].occupe == true) {
			return true;
		}
		if (tableau[o][p - 1].occupe == true && p != 0) {
			return true;
		}
		if (tableau[o][p + 1].occupe == true && p != 14) {
			return true;

		}
		return false;
	}*/
}
