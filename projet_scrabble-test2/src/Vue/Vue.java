package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import Modele.Bouton;
import Modele.Joueur;
import Modele.Multijoueur;
import Modele.Pioche;
import Modele.Suggestion;
import Modele.Tableau;
import Vue2.Photo;
import Vue2.duree_tours;
import Vue2.nombre_joueur;

public class Vue extends JFrame {
	public Clavier clavier;
	public Clavier clavierech;
	public Plateau plateau;
	public JButton fdt;
	public JButton melanger;
	public JButton verifmot;
	public JButton fin_jeu;
	public JButton echanger;
	public JButton echanger2;
	public JButton annuler;
	public Scores score;
	public IHMChrono chrono;
	public Suggestion sugges;
	public JList liste;
	public JPanel panel;
	public Tour tour;

	public Vue(Tableau tableau, Multijoueur joueurs) throws IOException {
		score = new Scores(joueurs.recupNbJ(), joueurs.joueur_act());
		score.setBounds(670, 160, 150, 120);
		score.setVisible(true);
		plateau = new Plateau(tableau);
		clavier = new Clavier(joueurs.joueur_act());
		clavierech = new Clavier(joueurs.joueur_act());
		tour = new Tour(joueurs.ind_jr);
		sugges = new Suggestion(joueurs.joueur_act());
		plateau.setBounds(0, 0, 640, 640);
		clavier.setBounds((640 - (640 / 15) * 7) / 2, 640 + 10, 640 / 15 * 7, 640 / 15);
		clavierech.setBounds((640 - (640 / 15) * 7) / 2, 640 + 10, 640 / 15 * 7, 640 / 15);
		fdt = new JButton("Fin de Tour");
		fdt.setBounds(670, 600, 170, 30);
		tour.setBounds(640, 10, 250, 40);
		verifmot = new JButton("Vérification mot");
		verifmot.setBounds(670, 650, 170, 30);
		fin_jeu = new JButton("Arreter la partie");
		fin_jeu.setBounds(670, 300, 170, 30);
		echanger = new JButton("Echanger");
		echanger.setBounds(30, 650, 100, 30);
		echanger2 = new JButton("Echanger");
		echanger2.setBounds(30, 650, 100, 30);
		echanger2.setVisible(false);
		annuler = new JButton("Annuler");
		annuler.setBounds(30, 685, 100, 30);
		annuler.setVisible(false);
		initPanel();
		this.add(echanger);
		this.add(echanger2);
		this.add(annuler);
		this.add(clavier);
		this.add(clavierech);
		this.add(plateau);
		this.setSize(900, 850);
		ImageIcon melange = new ImageIcon("src/images/melanger.png");
		melanger = new JButton(melange);
		melanger.setBounds(550, 650, melange.getIconHeight(), melange.getIconWidth());
		this.add(melanger);
		this.getContentPane().setBackground(Color.white);
		this.add(fdt);
		this.add(fin_jeu);
		this.add(verifmot);
		this.add(score);
		this.add(tour);
		chrono = new IHMChrono(duree_tours.duree);
		this.add(chrono);
		this.setTitle("Jeu du Scrabble");
		Image icone = Toolkit.getDefaultToolkit().getImage("src/images/S.jpg");
		this.setIconImage(icone);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void fin_du_jeu(ActionListener e) {
		fin_jeu.addActionListener(e);
	}

	public void echanger(ActionListener e) {
		echanger.addActionListener(e);
	}

	public void clavechange(Boolean b) {
		clavier.setVisible(b);
		clavierech.setVisible(!b);

	}

	public void ajoutactlist(ActionListener e) {
		fdt.addActionListener(e);
	}

	public void verification_mots(ActionListener e) {
		verifmot.addActionListener(e);
	}

	public void emplacement_lettre(ActionListener e) {
		melanger.addActionListener(e);
	}

	public void initPanel() {

		this.panel = new JPanel();
		this.panel.setBackground(new Color(220, 233, 230));
		this.panel.setBounds(670, 400, 120, 150);
		this.add(this.panel);
		JLabel motpossible = new JLabel("Suggestions");
		motpossible.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.add(motpossible, BorderLayout.NORTH);
		vuesuggestion(sugges);

	}

	public void vuesuggestion(Suggestion s) {
		this.panel.removeAll();
		this.sugges = s;
		if (this.sugges.suggestionlist.length != 0) {
			JLabel motpossible = new JLabel("Suggestions");
			motpossible.setFont(new Font("Arial", Font.PLAIN, 20));
			panel.add(motpossible, BorderLayout.NORTH);
			liste = new JList(sugges.suggestionlist);
			// creer un ascenseur quand bcp de suggestions
			JScrollPane ascenseur = new JScrollPane(liste);
			ascenseur.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			ascenseur.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			liste.setFont(new Font("Arial", Font.PLAIN, 20));
			liste.setBackground(new Color(236, 237, 191));
			panel.add(ascenseur, BorderLayout.SOUTH);
			liste.setVisibleRowCount(4);
		}

		else {
			JLabel motpossible = new JLabel("Pas\n de\n suggestions");
			motpossible.setFont(new Font("Arial", Font.PLAIN, 20));
			panel.add(motpossible, BorderLayout.NORTH);
		}

		panel.repaint();

	}

	public void majclavier(Joueur joueur, Pioche p) {

		for (int i = 0; i < joueur.size(); i++) {

			Bouton btn2 = (Bouton) clavier.getComponent(i);
			Clavier claviertemp = new Clavier(joueur);
			Bouton btn = (Bouton) claviertemp.getComponent(i);
			btn2.setIcon(btn.lettre.image);
			btn2.lettre = btn.lettre;
			btn2.verrouille = false;
			btn2.clique = false;
		}
		int j = joueur.size();
		while (j < 7) {
			Bouton btn2 = (Bouton) clavier.getComponent(joueur.size());
			btn2.setIcon(null);
			btn2.setBackground(Color.gray);
			btn2.lettre = null;
			btn2.verrouille = true;
			btn2.clique = false;
			j += 1;
		}

	}

	public void melangeclavier(int[] emplacement, Joueur joueur) {
		Clavier claviertemp = new Clavier(joueur);
		for (int i = 0; i < joueur.size(); i++) {
			Bouton btn = (Bouton) claviertemp.getComponent(i);
			Bouton btn2 = (Bouton) clavier.getComponent(emplacement[i]);
			btn2.setIcon(btn.lettre.image);
			btn2.lettre = btn.lettre;
		}
	}

	public void resetclavier() {
		for (int i = 0; i < 7; i++) {
			Bouton btn = (Bouton) clavier.getComponent(i);
			btn.setIcon(btn.lettre.image);
			btn.verrouille = false;
			btn.clique = false;
		}
	}

	public void majplateau(int k, ImageIcon nom) {
		Bouton bouton = (Bouton) plateau.getComponent(k);
		bouton.setIcon(nom);
	}

	public void echanger2(ActionListener e) {
		echanger2.addActionListener(e);

	}

	public void annuler(ActionListener e) {
		annuler.addActionListener(e);

	}

	public void majechclav(Joueur joueur_act) {
		for (int i = 0; i < 7; i++) {
			Bouton btn2 = (Bouton) clavierech.getComponent(i);
			Clavier claviertemp = clavier;
			Bouton btn = (Bouton) claviertemp.getComponent(i);
			btn2.setIcon(btn.lettre.image);
			btn2.lettre = btn.lettre;
			btn2.clique = false;
			btn2.setIcon(btn.lettre.image);
		}

	}

	public void majverrouille(boolean b) {
		for (int i = 0; i < 7; i++) {
			Bouton btn = (Bouton) clavier.getComponent(i);
			btn.verrouille = b;
		}

	}

}
