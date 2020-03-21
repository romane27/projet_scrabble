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

public class Tableau {
	public Case[][] tableau;
	HashMap<String, ArrayList<String>> dico;
	int mot_triple = 1;
	int lettre_triple = 2;
	int mot_double = 5;
	int lettre_double = 3;
	int sans_bonus = 0;

	public Tableau() {

		this.tableau = new Case[15][15];
		// this.dico = new Dico().dico;
		for (int i = 0; i < 14; i++) { // initialisation du tableau
			for (int j = 0; j < 14; j++) {
				tableau[i][j] = new Case();
			}
		}
		
		tableau[0][0].bonus=1;
		tableau[7][0].bonus=1;
		tableau[0][7].bonus=1;
		
		// carre haut gauche
		for (int i = 0; i < 14; i++) {

			for (int j = 0; j <14; j++) {
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
				
				if (i < 7 && j < 7 ) {
					
				if (tableau[i][j].bonus == 0) {
					if (i == j  ) {
						tableau[i][j].bonus = 5;
					}}
				}
			}
		}
		// carre haut droit
		for (int i = 0; i < 7; i++) {

			for (int j = 7; j < 15; j++) {
				tableau[i][j] = tableau[i][7 - (j - 7)];
				if (j == 7  & i!=7) {
					tableau[i][j] = tableau[i][0];
				}
			}

		}
		// carre bas gauche
		for (int i = 7; i < 15; i++) {

			for (int j = 0; j < 7; j++) {
				tableau[i][j] = tableau[7 - (i - 7)][j];
				if (j == 7 & i!=7) {
					tableau[i][j] = tableau[i][0];
				}
				if(j==7 & i==7) {
					tableau[i][j].bonus = 6;
				}
			}

		}
		// carre bas droit
		for (int i = 7; i < 15; i++) {

			for (int j = 7; j < 15; j++) {
				tableau[i][j] = tableau[i][7 - (j - 7)];
				if (j == 7  & i!=7) {
					tableau[i][j] = tableau[i][0];
				}
				if(j==7 & i==7) {
					tableau[i][j].bonus = 6;
				}
			}

		}
		
		for (int i=0 ; i<15 ; i++) {

			for (int j=0; j<15; j++) {
				System.out.print(tableau[i][j].bonus + " ");
			}
			System.out.println();
		}
		
	}
	
	public void ajoutLettre(int posX, int posY, Lettre l) {
		for (int i=0 ; i<this.tableau.length; i++) {
			for (int j=0 ; j<this.tableau[i].length; j++) {
				System.out.print(this.tableau[i][j].lettre.nom);
				System.out.print(" ");

			}
			System.out.print("\n");

		}
		System.out.println(tableau[posX][posY].bonus);
		Case a = tableau[posX][posY];
		a.ajoutLettreCase(l);
		System.out.print(posX);
		System.out.print(" ");
		System.out.print(posY);
		System.out.print("\n");
		for (int i=0 ; i<this.tableau.length; i++) {
			for (int j=0 ; j<this.tableau[i].length; j++) {
				System.out.print(this.tableau[i][j].lettre.nom);
				System.out.print(" ");

			}
			System.out.print("\n");

		}
		
	}


}
