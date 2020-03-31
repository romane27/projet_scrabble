package Controleur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;

import Modele.Bouton;
import Modele.Case;
import Modele.Joueur;
import Modele.Lettre;
import Modele.Pioche;
import Modele.Tableau;
import Vue.Plateau;
import Vue.Vue;

public class Controleur {

	Plateau plateau;
	Tableau tableau;
	Joueur joueur;
	Joueur joueur2;
	Pioche pioche;
	Vue vue;
	Case[] mot;
	int nblettre = 0;
	int sens = 0;

	public Controleur() {

		pioche = new Pioche();
		joueur = new Joueur(pioche);
		joueur2 = new Joueur(pioche);
		tableau = new Tableau();
		vue = new Vue(tableau, joueur, joueur2);
		mot = new Case[15];
		ajoutactlist();
		appuisfdt();
	}

	public static void main(String[] args) {
		Controleur c = new Controleur();
	}

	public void ajoutactlist() {
		ArrayList<Lettre> liste = new ArrayList();
		ArrayList<Bouton> list = new ArrayList();
		// Ce qu'il se passe quand tu cliques sur une des lettres du clavier
		for (int i = 0; i < 7; i++) {

			Bouton btn = (Bouton) vue.clavier.getComponent(i);
			vue.clavier.ajoutactionlistner(i, (ActionEvent evt) -> {
				if (!btn.isclicked()) {
					btn.setBackground(Color.lightGray);
					if (!liste.isEmpty()) {
						list.get(0).setBackground(Color.white);
						btn.clique = false;
					}
					liste.clear();
					liste.add(btn.lettre);
					list.clear();
					list.add(btn);
					nblettre += 1;

				}
				if (btn.isclicked() && btn.verrouille == false) {
					btn.setBackground(Color.white);
					btn.setclique(true);
					liste.remove(btn.lettre);
					list.remove(btn);
					nblettre -= 1;

				}
				btn.setclique(!btn.clique);

			});
		}
		// Ce qu'il se passe quand tu cliques sur une case du jeu
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				int o = i;
				int p = j;
				int k = 15 * i + j;
				Bouton btn = (Bouton) vue.plateau.getComponent(k);
				vue.plateau.ajoutactionlistner(k, (ActionEvent evt) -> {
					if (tableau.tableau[o][p].occupe == false && !liste.isEmpty()
							&& tableau.tableau[o][p].jouable == true) {
						btn.setBackground(Color.white);
						btn.setText(liste.get(0).nom);
						liste.clear();
						btn.associe(list.get(0));
						tableau.posee(o, p, btn);
						btn.boutonass.verrouille = true;
					} else {
						btn.setBackground(tableau.couleur[tableau.tableau[o][p].bonus]);
						btn.setText(tableau.def[tableau.tableau[o][p].bonus]);
						btn.boutonass.setBackground(Color.white);
						btn.boutonass.clique = false;
						tableau.retiree(o, p, btn);

					}
				});
			}
		}

	}

	public void appuisfdt() {
		vue.ajoutactlist((ActionEvent evt) -> {
			joueur.score += tableau.comptescore();
			System.out.println(joueur.score);
			vue.score.majscore(joueur);
		});

	}
}