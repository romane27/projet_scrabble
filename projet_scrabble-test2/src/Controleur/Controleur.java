package Controleur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Modele.Bouton;
import Modele.Case;
import Modele.Joueur;
import Modele.Lettre;
import Modele.Pioche;
import Modele.Suggestion;
import Modele.Tableau;
import Vue.Clavier;
import Vue.IHMChrono;
import Vue.Plateau;
import Vue.Vue;
import javafx.util.Pair;

public class Controleur {
	IHMChrono c;
	Plateau plateau;
	Tableau tableau;
	Joueur joueur;
	Joueur joueur2;
	Pioche pioche;
	Vue vue;
	Case[] mot;
	int sens = 0;
	ArrayList<Pair> listecasejouee;
	ArrayList<Lettre> listelettrejouee;
	public static String lettrejokerchoisi; 
	public Controleur() throws IOException {
		listelettrejouee = new ArrayList<Lettre>();
		pioche = new Pioche();
		System.out.println(pioche.size());
		joueur = new Joueur(pioche);
		joueur2 = new Joueur(pioche);
		tableau = new Tableau();
		vue = new Vue(tableau, joueur, joueur2);
		mot = new Case[15];
		ajoutactlist();
		appuisfdt();
		melange_lettre();
	}

	/*
	 * public static void main(String[] args) throws IOException { Controleur c =
	 * new Controleur(); }
	 */

	public void ajoutactlist() {
		ArrayList<Lettre> liste = new ArrayList();
		ArrayList<Bouton> list = new ArrayList();
		listecasejouee = new ArrayList<Pair>();
		// Ce qu'il se passe quand tu cliques sur une des lettres du clavier
		for (int i = 0; i < 7; i++) {

			Bouton btn = (Bouton) vue.clavier.getComponent(i);
			vue.clavier.ajoutactionlistner(i, (ActionEvent evt) -> {
				vue.melanger.setVisible(false);
				if (!btn.isclicked() && btn.verrouille == false) {
					btn.setIcon(btn.lettre.image_gris);
					// btn.setBackground(Color.lightGray);
					if (!liste.isEmpty()) {

						list.get(0).setIcon(list.get(0).lettre.image);
						// list.get(0).setBackground(Color.white);
					}
					liste.clear();
					liste.add(btn.lettre);
					list.clear();
					list.add(btn);

				}
				if (btn.isclicked() && btn.verrouille == false) {
					// btn.setBackground(Color.white);
					btn.setIcon(btn.lettre.image);
					liste.remove(btn.lettre);
					list.remove(btn);
				}
			});
		}
		// Ce qu'il se passe quand tu cliques sur une case du jeu
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				int o = i;
				int p = j;
				int k = 15 * i + j;
				Pair<Integer, Integer> xy = new Pair<Integer, Integer>(o, p);
				Bouton btn = (Bouton) vue.plateau.getComponent(k);
				vue.plateau.ajoutactionlistner(k, (ActionEvent evt) -> {
					try {
						if (tableau.tableau[o][p].occupe == false && !liste.isEmpty()
								&& tableau.tableau[o][p].jouable == true) {
							// btn.setBackground(Color.white);
							// btn.setText(liste.get(0).nom);
							btn.setIcon(btn.image);
							// vue.majplateau(k, liste.get(0).nom);
							vue.majplateau(k, liste.get(0).image);
							if (liste.get(0).nom==" ") {
								
								
								 JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
								    
								    String joker = (String)jop.showInputDialog(null, 
								    	      "Par quelle lettre voulait vous remplacer le joker?",
								    	      "Joker",
								    	      JOptionPane.DEFAULT_OPTION,
								    	      null,
								    	      Suggestion.alphabet,
								    	      Suggestion.alphabet[0]);
								    lettrejokerchoisi=joker;
								    System.out.println(lettrejokerchoisi);
								    for (Lettre l : Suggestion.lettreetvaleurs) {
								    	if (l.nom==lettrejokerchoisi) {
								    		btn.setIcon(l.image);
								    		list.get(0).lettre.nom=l.nom;
								    		list.get(0).lettre.valeur=0;
								    	}
								    	
								    }
								    
							}
							liste.clear();
							btn.associe(list.get(0));
							tableau.posee(o, p, btn);
							joueur.remove(btn.boutonass.lettre);
							listecasejouee.add(xy);
							listelettrejouee.add(btn.boutonass.lettre);
							System.out.println(listelettrejouee);
							btn.boutonass.verrouille = true;

						} else {
							if (!tableau.tableau[o][p].verouillee) {
								// btn.setBackground(tableau.couleur[tableau.tableau[o][p].bonus]);
								// btn.setText(tableau.def[tableau.tableau[o][p].bonus]);
								// btn.boutonass.setBackground(Color.white);
								// btn.setIcon(tableau.imageplateau[tableau.tableau[o][p].bonus]);
								btn.setIcon(btn.image);
								btn.boutonass.clique = false;
								btn.boutonass.setIcon(btn.boutonass.lettre.image);
								tableau.retiree(o, p, btn);
								joueur.add(btn.boutonass.lettre);
								listecasejouee.remove(xy);
								listelettrejouee.remove(btn.boutonass.lettre);
								btn.boutonass.verrouille = false;
							}
						}
					} catch (NullPointerException exp) {
					}
				});
			}
		}
	}

	// ce qu'il se passe quand on clic sur bouton melanger
	public void melange_lettre() {
		vue.emplacement_lettre((ActionEvent evt) -> {
			System.out.println("salut");
			vue.melangeclavier(Clavier.melangerlettre(), joueur);
		});
	}


	public void appuisfdt() {
		vue.ajoutactlist((ActionEvent evt) -> {
			vue.melanger.setVisible(true);
			// quand on clique sur fin de tour on redemarre le chrono
			System.out.println(joueur.size());
			if (joueur.size() == 7) {
				joueur.initTirage(pioche);
				vue.score.majscore(joueur, pioche);
				vue.majclavier(joueur);
				try {
					Suggestion s = new Suggestion (joueur);
					System.out.println("eee");
					vue.vuesuggestion(s);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				Pair<Boolean, Integer[]> pair = tableau.comptescore();
				if (pair.getKey() == false) {// si le mot est faux
					System.out.println(joueur);
					System.out.println(listelettrejouee);
					vue.resetclavier();
					vue.plateau.resetplateau(listecasejouee);
					tableau.majmauvaismot(listecasejouee);
					joueur.reset(listelettrejouee);
					System.out.println(joueur);

				} else {
					joueur.score += pair.getValue()[0];
					joueur.score += pair.getValue()[1];
					joueur.tirage(pioche);
					vue.score.majscore(joueur, pioche);
					vue.majclavier(joueur);
					tableau.majbonmot(listecasejouee);
					c.chrono.demarrer();
					try {
						Suggestion s = new Suggestion (joueur);
						System.out.println("eee");
						vue.vuesuggestion(s);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// tableau.majbonmot(listecasejouee);
				}
				tableau.majjouabletour();
				listecasejouee.clear();
				listelettrejouee.clear();
			}
		});

	}
}