package Controleur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;
import java.util.OptionalInt;

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
import javafx.util.Pair;

public class Controleur implements Observer {

	Plateau plateau;
	Tableau tableau;
	Pioche pioche;
	Vue vue;
	Case[] mot;
	Multijoueur multi;
	int sens = 0;
	ArrayList<Pair> listecasejouee;
	ArrayList<Lettre> listelettrejouee;
	ArrayList<Bouton> listechange;
	public static String lettrejokerchoisi;

	public Controleur() throws IOException {
		this.lettrejokerchoisi = " ";
		listelettrejouee = new ArrayList<Lettre>();
		pioche = new Pioche();
		multi = new Multijoueur(pioche);
		tableau = new Tableau();
		vue = new Vue(tableau, multi);
		mot = new Case[15];
		vue.chrono.chrono.addObserver(this);
		ajoutactlist();
		appuisfdt();
		melange_lettre();
		echanger();
		verif();
		fin();
		echanger2();
		annuler();
		meilleur();
		historique1();
		sauvegarder();
	}

	public void ajoutactlist() { // quand on pose une lettre
		ArrayList<Lettre> liste = new ArrayList();
		ArrayList<Bouton> list = new ArrayList();
		listecasejouee = new ArrayList<Pair>();
		listechange = new ArrayList();
		// Ce qu'il se passe quand tu cliques sur une des lettres du clavier
		for (int i = 0; i < 7; i++) {

			Bouton btn = (Bouton) vue.clavier.getComponent(i);
			vue.clavier.ajoutactionlistner(i, (ActionEvent evt) -> {
				vue.melanger.setVisible(false);
				if (!btn.isclicked() && btn.verrouille == false) {
					btn.setIcon(btn.lettre.image_gris);

					if (!liste.isEmpty()) {

						list.get(0).setIcon(list.get(0).lettre.image);

					}
					liste.clear();
					liste.add(btn.lettre);
					list.clear();
					list.add(btn);

				}
				if (btn.isclicked() && btn.verrouille == false) {

					btn.setIcon(btn.lettre.image);
					liste.remove(btn.lettre);
					list.remove(btn);
				}

			});
		}
		// pour les echanges
		for (int i = 0; i < 7; i++) {

			Bouton btn = (Bouton) vue.clavierech.getComponent(i);
			vue.clavierech.ajoutactionlistner(i, (ActionEvent evt) -> {
				// vue.melanger.setVisible(false);
				if (!btn.isclicked() && listechange.size() <= pioche.pioche.size()) {
					btn.setIcon(btn.lettre.image_gris);
					listechange.add(btn);

				}
				if (btn.isclicked()) {
					btn.setIcon(btn.lettre.image);
					listechange.remove(btn);
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
							btn.setIcon(btn.image);
							vue.majplateau(k, liste.get(0).image);
							vue.melanger.setVisible(false);
							// si la lettre posée est un joker on fait choisir à l'utilisateur la lettre
							if (liste.get(0).nom == " ") {

								JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();

								String joker = (String) jop.showInputDialog(null,
										"Par quelle lettre voulez-vous remplacer le joker ?", "Joker",
										JOptionPane.DEFAULT_OPTION, null, Suggestion.alphabet, Suggestion.alphabet[0]);
								lettrejokerchoisi = joker;
								if (joker == null) {
									lettrejokerchoisi = "A";
								}

								for (Lettre l : Suggestion.lettreetvaleurs) {
									if (l.nom == lettrejokerchoisi) {
										btn.setIcon(l.image);
										list.get(0).lettre.nom = l.nom;
										list.get(0).lettre.valeur = 0;
									}

								}

							}
							liste.clear();
							btn.associe(list.get(0));
							tableau.posee(o, p, btn);
							multi.joueur_act().remove(btn.boutonass.lettre);
							listecasejouee.add(xy);
							listelettrejouee.add(btn.boutonass.lettre);
							btn.boutonass.verrouille = true;

						} else {
							if (!tableau.tableau[o][p].verouillee) {
								btn.setIcon(btn.image);
								btn.boutonass.clique = false;
								btn.boutonass.setIcon(btn.boutonass.lettre.image);
								tableau.retiree(o, p, btn);
								if (btn.boutonass.lettre.nom == lettrejokerchoisi) {
									btn.boutonass.lettre.nom = " ";
								}
								multi.joueur_act().add(btn.boutonass.lettre);
								listecasejouee.remove(xy);
								listelettrejouee.remove(btn.boutonass.lettre);
								btn.boutonass.verrouille = false;
							}
						}
						// si toute les lettres sont sur le pupitre on rajoute le bouton pour mélanger
						// les lettres
						if (listecasejouee.size() == 0) {
							vue.melanger.setVisible(true);
						}
					} catch (NullPointerException exp) {
					}
				});
			}
		}
	}

	public void historique1() {

		vue.hist1((ActionEvent evt) -> {

			ImageIcon image = new ImageIcon("src/images/bonhomme1.png");
			String[] nom = new String[multi.nbrjoueur];

			;
			if (multi.nbrjoueur == 1) {
				nom[0] = multi.nomjoueur.get(0);

			}
			if (multi.nbrjoueur == 2) {
				nom[0] = multi.nomjoueur.get(0);

				nom[1] = multi.nomjoueur.get(1);

			}
			if (multi.nbrjoueur == 3) {
				nom[0] = multi.nomjoueur.get(0);

				nom[1] = multi.nomjoueur.get(1);

				nom[2] = multi.nomjoueur.get(2);

			}
			if (multi.nbrjoueur == 4) {
				nom[0] = multi.nomjoueur.get(0);

				nom[1] = multi.nomjoueur.get(1);

				nom[2] = multi.nomjoueur.get(2);

				nom[3] = multi.nomjoueur.get(3);

			}

			JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
			int rang = jop.showOptionDialog(null, "Veuillez choisir l'historique que vous souhaitez voir !",
					"Historique !", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, nom,
					nom[multi.nbrjoueur - 1]);
			if (multi.tab_joueurs[rang].mot.isEmpty() == false) {
				jop2.showMessageDialog(null, "les mots jouer par " + multi.nomjoueur.get(rang) + " sont "
						+ multi.tab_joueurs[rang].mot.toString(), "Historique", JOptionPane.NO_OPTION);
			} else {
				jop2.showMessageDialog(null, multi.nomjoueur.get(rang) + " a joué aucun mot", "Historique",
						JOptionPane.INFORMATION_MESSAGE);
			}

			/*if (JOptionPane.VALUE_PROPERTY.equals(jop2.CLOSED_OPTION)) {

				System.exit(0);
			}
			if (JOptionPane.VALUE_PROPERTY.equals(jop.CLOSED_OPTION)) {

				System.exit(0);
			}*/

			/*
			 * int input = JOptionPane.showConfirmDialog(null, "l'historique de
			 * " + multi.nomjoueur.get(0) + multi.tab_joueurs[0].mot.toString(), " ",
			 * JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, image);
			 */

		});
	}

	public void meilleur() { // récupère le meilleur mot (vaut le plus de points)
		vue.meilleur1((ActionEvent evt) -> {
			vue.sugges.bestmot(vue.sugges.motpossible);
			int input = JOptionPane.showConfirmDialog(null,
					"Le meilleur mot possible avec vos lettres est " + vue.sugges.meilleur_mot + " avec "
							+ vue.sugges.meilleur + " points",
					" ", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null);

		});
	}

	// ce qu il se passe quand on appuie sur verification
	public void verif() { // vérifie si un mot est correct
		vue.verification_mots((ActionEvent evt) -> {
			ImageIcon image = new ImageIcon("src/images/bonhomme1.png");
			if (multi.joueur_act().size() == 7) {
				int input = JOptionPane.showConfirmDialog(null, "Veuillez placer des lettres sur le plateau", " ",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, image);
				if (input == JOptionPane.OK_OPTION) {
				}
			} else {
				Pair<Boolean, Integer[]> pair = tableau.comptescore(listelettrejouee.size());
				if (pair.getKey() == false) {// si le mot est faux
					if (pair.getValue().length == 0) {
						int input = JOptionPane.showConfirmDialog(null,
								"Vous devez placer toutes les lettres sur la même ligne ou colonne !", " ",
								JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
						if (input == JOptionPane.OK_OPTION) {
						}
					} else {
						int input = JOptionPane.showConfirmDialog(null, "Le mot est incorrect !", " ",
								JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, image);
						if (input == JOptionPane.OK_OPTION) {
						}
					}
					vue.resetclavier(multi.joueur_act());
					vue.plateau.resetplateau(listecasejouee);
					tableau.majmauvaismot(listecasejouee);
					multi.joueur_act().reset(listelettrejouee);

					// multi.changer_joueur();
					vue.majclavier(multi.joueur_act(), pioche);
					vue.melanger.setVisible(true);
					listelettrejouee.clear();
					listecasejouee.clear();

				} else {
					tableau.revalid(listecasejouee);
					int input = JOptionPane.showConfirmDialog(null,
							"Le mot est correct ! Appuyez sur fin de tour pour valider.", " ",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, image);

				}
			}
		});

	}

	public void sauvegarder() {
		vue.sauvegarder((ActionEvent evt) -> {
			File f = new File("");
			String nom = JOptionPane.showInputDialog(null, "Donnez un nom à votre sauvegarde");
			if (nom != null) {
				f = new File("Sauvegardes/" + nom);
				while (f.exists()) {
					nom = JOptionPane.showInputDialog(null, "Ce nom est déjà pris, veuillez en choisir un autre");
				}
				multi.enregistrer();
				pioche.enregistrer();
				tableau.enregistrer();
				f.mkdir();
				File rep = new File("Temp");
				File[] l = rep.listFiles();
				for (File fichier : l) {
					fichier.renameTo(new File("Sauvegardes/" + nom + "/" + fichier.getName()));
				}
				JOptionPane.showMessageDialog(null, "Votre partie à été sauvegardé", "Sauvegarde",
						JOptionPane.WARNING_MESSAGE);
			}

		});

	}

	public void fin() { // quand on appuie sur Arreter la partie
		vue.fin_du_jeu((ActionEvent evt) -> {
			ArrayList<Integer> daccord = new ArrayList<>();
			for (Joueur j : multi.tab_joueurs) {
				int n = JOptionPane.showConfirmDialog(null,
						multi.nomjoueur.get(j.pos) + ", voulez-vous arrêter la partie ?", "Et maintenant …",
						JOptionPane.YES_NO_OPTION);
				// réponse oui du joueur
				if (n == 0) {
					daccord.add(0);
				} else {
					daccord.add(1);
				}
			}
			/*
			 * int k=0;
			 * 
			 * for (int i=0;i<daccord.size();i++) {
			 */
			if (daccord.contains(1)) {
				JOptionPane.showMessageDialog(null, "On continue la partie car au moins un joueur souhaite continuer !",
						"Attention", JOptionPane.WARNING_MESSAGE);

			}
			/*
			 * else { k+=1; }
			 * 
			 * }
			 */
			else {
				vue.chrono.chrono.arreter();
				int score_max = 0;
				int[] score = new int[multi.nbrjoueur];
				ArrayList<Integer> egal = new ArrayList<>();
				String nom = "";
				// if (k==daccord.size()) {
				for (int j = 0; j < multi.nbrjoueur; j++) {
					// score[j] = (multi.tab_joueurs[j].score);
					if (multi.tab_joueurs[j].score > score_max) { // multi.tab_joueurs[j - 1].score) {
						egal.clear();
						egal.add(j);
						// nom = multi.nomjoueur.get(j) + " a ";
					}
					if (multi.tab_joueurs[j].score == score_max) {
						egal.add(j);
						// nom = multi.nomjoueur.get(j - 1) + " et " +
						// multi.nomjoueur.get(j) + " ont ";
					}

				}

				if (egal.size() == 1) {
					nom = multi.nomjoueur.get(egal.get(0)) + " a ";
				} else {
					for (int ind = 0; ind < egal.size() - 1; ind++) {
						nom += multi.nomjoueur.get(egal.get(ind)) + " et ";
					}
					nom += multi.nomjoueur.get(egal.size() - 1) + " ont ";
				}
				// quand on dit le gagnant on ferme la fenetre
				ImageIcon image = new ImageIcon("src/images/bonhomme1.png");
				int input = JOptionPane.showConfirmDialog(null, nom + "gagné la partie. Bien joué !", " Gagnant",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, image);
				if (input == JOptionPane.OK_OPTION) {
					vue.dispose();
				}
			}
		});
	}

	// ce qu'il se passe quand on clic sur bouton melanger
	public void melange_lettre() { // réorganise les lettres du clavier
		vue.emplacement_lettre((ActionEvent evt) -> {

			vue.melangeclavier(Clavier.melangerlettre(), multi.joueur_act());
		});
	}

	public void appuisfdt() { // quand on appuie sur fin_de_tour -> lance la vérif du mot puis change de
								// joueur
		vue.ajoutactlist((ActionEvent evt) -> {
			vue.chrono.chrono.arreter();
			vue.melanger.setVisible(true);
			// quand on clique sur fin de tour on redemarre le chrono

			if (listelettrejouee.size() == 0) {

				vue.score.majscore(multi.joueur_act(), pioche, multi);
				multi.changer_joueur();

				vue.majclavier(multi.joueur_act(), pioche);
				if (multi.nbrjoueur != 1) {
					try {
						Suggestion s = new Suggestion(multi.joueur_act());
						if (s.motpossible.isEmpty()) {
							vue.meilleur_mot.setVisible(false);
						}
						vue.vuesuggestion(s);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					ImageIcon image = new ImageIcon("src/images/bonhomme1.png");

					int input2 = JOptionPane.showConfirmDialog(null,
							"C'est à " + multi.nomjoueur.get(multi.ind_jr) + " de jouer.", " ",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, image);

				}
				vue.tour.majtour(multi.ind_jr, multi);
				vue.chrono.chrono.demarrer();

			} else {
				Pair<Boolean, Integer[]> pair = tableau.comptescore(listelettrejouee.size());
				if (pair.getKey() == false) {// si le mot est faux
					if (pair.getValue().length == 0) {
						int input = JOptionPane.showConfirmDialog(null,
								"Vous devez placer toutes les lettres sur la même ligne ou colonne !", " ",
								JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
						if (input == JOptionPane.OK_OPTION) {
							/*
							 * vue.resetclavier(); vue.plateau.resetplateau(listecasejouee);
							 * tableau.majmauvaismot(listecasejouee);
							 * multi.joueur_act().reset(listelettrejouee);
							 * 
							 * multi.changer_joueur(); vue.majclavier(multi.joueur_act(), pioche);
							 */
						}

					}
					vue.resetclavier(multi.joueur_act());
					vue.plateau.resetplateau(listecasejouee);
					tableau.majmauvaismot(listecasejouee);
					multi.joueur_act().reset(listelettrejouee);

					multi.changer_joueur();
					vue.majclavier(multi.joueur_act(), pioche);
				} else {
					for (Integer sc : pair.getValue()) {
						multi.joueur_act().score += sc;
					}
					/*
					 * multi.joueur_act().score += pair.getValue()[0]; multi.joueur_act().score +=
					 * pair.getValue()[1];
					 */
					multi.joueur_act().tirage(pioche);
					for (String n : tableau.mot_valide) {
						multi.joueur_act().mot.add(n);

					}
					vue.score.majscore(multi.joueur_act(), pioche, multi);
					tableau.majbonmot(listecasejouee);
					multi.changer_joueur();
					vue.majclavier(multi.joueur_act(), pioche);

				}
				try {
					Suggestion s = new Suggestion(multi.joueur_act());
					if (s.motpossible.isEmpty()) {
						vue.meilleur_mot.setVisible(false);
					}
					vue.vuesuggestion(s);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ImageIcon image = new ImageIcon("src/images/bonhomme1.png");
				int input = JOptionPane.showConfirmDialog(null,
						"C'est à " + multi.nomjoueur.get(multi.ind_jr) + " de jouer.", " ", JOptionPane.DEFAULT_OPTION,
						JOptionPane.INFORMATION_MESSAGE, image);
				if (input == JOptionPane.OK_OPTION) {
					vue.tour.majtour(multi.ind_jr, multi);
					vue.chrono.chrono.demarrer();

				}
				// 0=ok, 2=cancel

				listecasejouee.clear();
				listelettrejouee.clear();

			}
			if (pioche.pioche.size() > 0) {
				vue.echanger.setVisible(true);
			}

		});

	}

	public void echanger() { // permet d'échanger les lettres de son clavier

		vue.echanger((ActionEvent evt) -> {
			vue.majechclav(multi.joueur_act());
			vue.meilleur_mot.setVisible(false);
			ImageIcon image = new ImageIcon("src/images/bonhomme1.png");
			int input = JOptionPane.showConfirmDialog(null, "Veuillez sélectionner les lettres à échanger.", " ",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, image);

			if (input == 0) {
				vue.resetclavier(multi.joueur_act());

				vue.melanger.setVisible(false);
				vue.clavechange(false);
				vue.echanger.setVisible(false);
				vue.echanger2.setVisible(true);
				vue.annuler.setVisible(true);
				vue.fdt.setVisible(false);

			}
		});
	}

	public void annuler() {
		vue.annuler((ActionEvent evt) -> {
			vue.clavechange(true);
			vue.melanger.setVisible(true);
			vue.echanger.setVisible(true);
			vue.echanger2.setVisible(false);
			vue.annuler.setVisible(false);
			vue.fdt.setVisible(true);
		});
	}

	public void echanger2() {
		vue.echanger2((ActionEvent evt) -> {
			ArrayList<Integer> l = new ArrayList();

			for (int i = 0; i < listechange.size(); i++) {

				l.add(listechange.get(i).place);
				pioche.pioche.add(listechange.get(i).lettre);
			}
			Collections.sort(l, Collections.reverseOrder());
			multi.joueur_act().echange(l);
			multi.joueur_act().tirage(pioche);
			vue.echanger.setVisible(false);
			vue.echanger2.setVisible(false);
			vue.annuler.setVisible(false);
			vue.clavechange(true);
			vue.majclavier(multi.joueur_act(), pioche);
			vue.fdt.setVisible(false);

			try {
				Suggestion s = new Suggestion(multi.joueur_act());
				if (s.motpossible.isEmpty()) {
					vue.meilleur_mot.setVisible(false);
				}
				vue.vuesuggestion(s);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			vue.meilleur_mot.setVisible(true);
			vue.majverrouille(true);
			vue.fdt.setVisible(true);
			listechange.clear();
			vue.echanger.setVisible(true);
			fin_de_tour();
		});
	}

	public void fin_de_tour() { // relié au chrono
		vue.melanger.setVisible(true);
		// quand on clique sur fin de tour on redemarre le chrono

		if (listelettrejouee.size() == 0) {

			vue.score.majscore(multi.joueur_act(), pioche, multi);
			multi.changer_joueur();
			vue.majclavier(multi.joueur_act(), pioche);
			if (multi.nbrjoueur != 1) {
				try {
					Suggestion s = new Suggestion(multi.joueur_act());
					if (s.motpossible.isEmpty()) {
						vue.meilleur_mot.setVisible(false);
					}
					vue.vuesuggestion(s);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				ImageIcon image = new ImageIcon("src/images/bonhomme1.png");

				int input2 = JOptionPane.showConfirmDialog(null,
						"C'est à " + multi.nomjoueur.get(multi.ind_jr) + " de jouer", " ", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.INFORMATION_MESSAGE, image);

			}
			vue.tour.majtour(multi.ind_jr, multi);
			vue.chrono.chrono.demarrer();
		} else {
			Pair<Boolean, Integer[]> pair = tableau.comptescore(listelettrejouee.size());
			if (pair.getKey() == false) {// si le mot est faux
				if (pair.getValue().length == 0) {
					int input = JOptionPane.showConfirmDialog(null,
							"Vous devez placer toutes les lettres sur la même ligne ou colonne !", " ",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
					if (input == JOptionPane.OK_OPTION) {
						vue.resetclavier(multi.joueur_act());
						vue.plateau.resetplateau(listecasejouee);
						tableau.majmauvaismot(listecasejouee);
						multi.joueur_act().reset(listelettrejouee);

						multi.changer_joueur();
						vue.majclavier(multi.joueur_act(), pioche);
					}

				} else {
					vue.plateau.resetplateau(listecasejouee);
					tableau.majmauvaismot(listecasejouee);
					multi.joueur_act().reset(listelettrejouee);
					multi.changer_joueur();
					vue.majclavier(multi.joueur_act(), pioche);
				}
			} else {
				for (Integer sc : pair.getValue()) {
					multi.joueur_act().score += sc;
				}
				/*
				 * multi.joueur_act().score += pair.getValue()[0]; multi.joueur_act().score +=
				 * pair.getValue()[1];
				 */
				multi.joueur_act().tirage(pioche);
				vue.score.majscore(multi.joueur_act(), pioche, multi);
				tableau.majbonmot(listecasejouee);
				multi.changer_joueur();
				vue.majclavier(multi.joueur_act(), pioche);

			}
			try {
				Suggestion s = new Suggestion(multi.joueur_act());
				if (s.motpossible.isEmpty()) {
					vue.meilleur_mot.setVisible(false);
				}
				vue.vuesuggestion(s);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ImageIcon image = new ImageIcon("src/images/bonhomme1.png");
			int input = JOptionPane.showConfirmDialog(null,
					"C'est à " + multi.nomjoueur.get(multi.ind_jr) + " de jouer", " ", JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE, image);
			if (input == JOptionPane.OK_OPTION) {
				vue.tour.majtour(multi.ind_jr, multi);
				vue.chrono.chrono.demarrer();

			}
			// 0=ok, 2=cancel

			listecasejouee.clear();
			listelettrejouee.clear();
		}

	}

	// quand le temps est fini on utilise observeur/ observable
	@Override
	public void update(Observable o, Object arg) { // quand le chrono est terminé

		Boolean etat = (Boolean) arg;
		int input2 = JOptionPane.showConfirmDialog(null, "Temps écoulé !", " ", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null);
		if (input2 == JOptionPane.OK_OPTION) {

			fin_de_tour();

		}

	}
}