package Controleur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import Modele.Bouton;
import Modele.Case;
import Modele.Joueur;
import Modele.Lettre;
import Modele.Multijoueur;
import Modele.Pioche;
import Modele.Suggestion;
import Modele.Tableau;
import Vue.Clavier;
import Vue.IHMChrono;
import Vue.Plateau;
import Vue.Vue;
import Vue2.duree_tours;
import Vue2.nombre_joueur;
import javafx.util.Pair;

public class Controleur implements Observer{
	
	Plateau plateau;
	Tableau tableau;
	/*Joueur joueur;
	Joueur joueur2;*/
	Pioche pioche;
	Vue vue;
	Case[] mot;
	Multijoueur multi;
	int sens = 0;
	ArrayList<Pair> listecasejouee;
	ArrayList<Lettre> listelettrejouee;
	public static String lettrejokerchoisi; 
	public Controleur() throws IOException {
		this.lettrejokerchoisi =" ";
		listelettrejouee = new ArrayList<Lettre>();
		pioche = new Pioche();
		System.out.println(pioche.size());
		multi = new Multijoueur(pioche);
		/*joueur = new Joueur(pioche);
		joueur2 = new Joueur(pioche);*/
		tableau = new Tableau();
		vue = new Vue(tableau, multi);
		mot = new Case[15];
		vue.chrono.chrono.addObserver(this);
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
								    if (joker == null) {
								    	lettrejokerchoisi = "A";
								    }
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
							//list.get(0).setVisible(false);
							tableau.posee(o, p, btn);
							multi.joueur_act().remove(btn.boutonass.lettre);
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
								//list.get(0).setVisible(true);
								tableau.retiree(o, p, btn);
								if (btn.boutonass.lettre.nom == lettrejokerchoisi) {
									btn.boutonass.lettre.nom=" ";
								}
								multi.joueur_act().add(btn.boutonass.lettre);
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
			
			vue.melangeclavier(Clavier.melangerlettre(), multi.joueur_act());
		});
	}


	public void appuisfdt() {
		vue.ajoutactlist((ActionEvent evt) -> {
			vue.melanger.setVisible(true);
			// quand on clique sur fin de tour on redemarre le chrono
			System.out.println(multi.joueur_act().size());
			if (multi.joueur_act().size() == 7) {
				System.out.println(multi.joueur_act().size());
				multi.joueur_act().initTirage(pioche);
				vue.score.majscore(multi.joueur_act(), pioche);
				multi.changer_joueur();
				vue.majclavier(multi.joueur_act());
				
				try {
					Suggestion s = new Suggestion (multi.joueur_act());
					System.out.println("eee");
					vue.vuesuggestion(s);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (nombre_joueur.nbrjoueur!=1) {
					ImageIcon image = new ImageIcon("src/images/bonhomme1.png");
					
					int input2 = JOptionPane.showConfirmDialog(null, 
							"c'est à "+nombre_joueur.nomjoueur.get(multi.ind_jr)+ " de jouer", " ", 
				                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, image);
					 if (input2==JOptionPane.OK_OPTION) {
						
						 vue.chrono.chrono.demarrer();

							
					 }
				}
				vue.tour.majtour(multi.ind_jr);
				vue.chrono.chrono.demarrer();
				
				
				
			} else {
				Pair<Boolean, Integer[]> pair = tableau.comptescore();
				if (pair.getKey() == false) {// si le mot est faux
					System.out.println(multi.joueur_act());
					System.out.println(listelettrejouee);
					vue.resetclavier();
					vue.plateau.resetplateau(listecasejouee);
					tableau.majmauvaismot(listecasejouee);
					multi.joueur_act().reset(listelettrejouee);
					System.out.println(multi.joueur_act());
					multi.changer_joueur();
					vue.majclavier(multi.joueur_act());

				} else {
					multi.joueur_act().score += pair.getValue()[0];
					multi.joueur_act().score += pair.getValue()[1];
					System.out.println(multi.ind_jr+ " : "+ multi.joueur_act().score );
					multi.joueur_act().tirage(pioche);
					vue.score.majscore(multi.joueur_act(), pioche);
					tableau.majbonmot(listecasejouee);
					multi.changer_joueur();
					vue.majclavier(multi.joueur_act());
					
				}
					try {
						Suggestion s = new Suggestion (multi.joueur_act());
						System.out.println("eee");
						vue.vuesuggestion(s);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// tableau.majbonmot(listecasejouee);
				ImageIcon image = new ImageIcon("src/images/bonhomme1.png");
				
				    
				int input = JOptionPane.showConfirmDialog(null, 
						"c'est à "+nombre_joueur.nomjoueur.get(multi.ind_jr)+ " de jouer", " ", 
			                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, image);
				 if (input==JOptionPane.OK_OPTION) {
					 vue.tour.majtour(multi.ind_jr);
					 vue.chrono.chrono.demarrer();

						
				 }
			        // 0=ok, 2=cancel
			       // System.out.println(input);
			//	tableau.majjouabletour();
				listecasejouee.clear();
				listelettrejouee.clear();
			}
		});

	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("on passe la");
		Boolean etat = (Boolean)arg;
		int input2 = JOptionPane.showConfirmDialog(null, 
				"temps écoulé c'est à " +nombre_joueur.nomjoueur.get(multi.ind_jr) +" de jouer", " ", 
	                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
		
		
		 if (input2==JOptionPane.OK_OPTION) {
			 vue.majclavier(multi.joueur_act());
			 vue.tour.majtour(multi.ind_jr);
			// vue.chrono.chrono.demarrer();
			 vue.chrono.reprendre(duree_tours.duree);
		 }
}
}