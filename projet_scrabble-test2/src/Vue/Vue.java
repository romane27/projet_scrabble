package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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

public class Vue extends JFrame implements WindowListener {
	public Clavier clavier;
	public Clavier clavierech;
	public Plateau plateau;
	public JButton fdt;
	public JButton melanger;
	public JButton verifmot;
	public JButton fin_jeu;
	public JButton echanger;
	public JButton echanger2;
	public JButton meilleur_mot;
	public JButton sauvegarder;
	public JButton annuler;
	public JButton historique1;
	public Scores score;
	public IHMChrono chrono;
	public Suggestion sugges;
	public JList liste;
	public JLabel echan;
	public JPanel panel;
	public Tour tour;
	public Tableau tableau;
	public Multijoueur joueurs;

	public Vue(Tableau tableau, Multijoueur joueurs, Pioche p) throws IOException {
		this.tableau = tableau;
		score = new Scores(joueurs.recupNbJ(), joueurs.joueur_act(), joueurs, p);
		score.setBounds(670, 160, 150, 120);
		score.setVisible(true);
		plateau = new Plateau(tableau);
		clavier = new Clavier(joueurs.joueur_act());
		clavierech = new Clavier(joueurs.joueur_act());
		tour = new Tour(joueurs.ind_jr, joueurs);
		sugges = new Suggestion(joueurs.joueur_act());
		plateau.setBounds(0, 0, 640, 640);
		clavier.setBounds((640 - (640 / 15) * 7) / 2, 640 + 10, 640 / 15 * 7, 640 / 15);
		clavierech.setBounds((640 - (640 / 15) * 7) / 2, 640 + 10, 640 / 15 * 7, 640 / 15);
		fdt = new JButton("Fin de Tour");
		fdt.setBounds(670, 585, 170, 30);
		tour.setBounds(640, 10, 250, 40);
		verifmot = new JButton("Vérification mot");
		verifmot.setBounds(670, 620, 170, 30);
		sauvegarder = new JButton("Sauver la partie");
		sauvegarder.setBounds(670, 335, 170, 30);

		fin_jeu = new JButton("Arrêter la partie");
		fin_jeu.setBounds(670, 300, 170, 30);
		ImageIcon stat = new ImageIcon("src/images/Statistique1.png");
		historique1 = new JButton(stat);

		historique1.setBounds(620, 650, stat.getIconWidth(), stat.getIconHeight());
		historique1.setToolTipText("Historique");
		historique1.setBorderPainted(false);
		historique1.setFocusPainted(false);
		this.add(sauvegarder);
		this.add(historique1);

		ImageIcon echanger3 = new ImageIcon("src/images/echanger.png");
		echanger = new JButton(echanger3);
		// echanger.setIcon(echanger3);
		// echanger.setForeground(echanger3);
		// echanger.setText("Echanger");
		echanger.setBounds(30, 650, echanger3.getIconWidth(), echanger3.getIconHeight() + 10);
		// echanger.setBounds(30, 650,100,60);
		echanger.setToolTipText("Échanger");
		echanger.setBorderPainted(false);
		echanger.setFocusPainted(false);
		echanger.setOpaque(true);
		echanger2 = new JButton(echanger3);
		echanger2.setBounds(30, 650, echanger3.getIconWidth(), echanger3.getIconHeight() + 10);
		echanger2.setToolTipText("Échanger");
		echanger2.setBorderPainted(false);
		echanger2.setFocusPainted(false);
		echanger2.setVisible(false);

		ImageIcon annule = new ImageIcon("src/images/annuler.png");
		annuler = new JButton(annule);
		annuler.setBorderPainted(false);
		annuler.setFocusPainted(false);
		annuler.setBounds(95, 650, annule.getIconWidth(), annule.getIconHeight());
		annuler.setToolTipText("Annuler");
		annuler.setVisible(false);
		ImageIcon meilleur = new ImageIcon("src/images/meilleur.png");
		meilleur_mot = new JButton(meilleur);
		meilleur_mot.setBorderPainted(false);
		meilleur_mot.setFocusPainted(false);
		meilleur_mot.setBounds(550, 650, meilleur.getIconWidth(), meilleur.getIconHeight());
		meilleur_mot.setToolTipText("Meilleur mot possible");
		initPanel();
		// this.add(echan);

		this.add(meilleur_mot);
		this.add(echanger);
		this.add(echanger2);
		this.add(annuler);
		this.add(clavier);
		this.add(clavierech);
		this.add(plateau);
		this.setSize(900, 850);
		ImageIcon melange = new ImageIcon("src/images/melanger.png");
		melanger = new JButton(melange);
		melanger.setToolTipText("Mélanger");
		melanger.setBounds(500, 650, melange.getIconHeight(), melange.getIconWidth());
		this.add(melanger);
		this.getContentPane().setBackground(Color.white);
		this.add(fdt);
		this.add(fin_jeu);
		this.add(verifmot);
		this.add(score);
		this.add(tour);
		chrono = new IHMChrono(joueurs.duree);
		this.add(chrono);
		this.setTitle("Jeu du Scrabble");
		Image icone = Toolkit.getDefaultToolkit().getImage("src/images/S.jpg");
		this.setIconImage(icone);
		this.addWindowListener(this);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	// ajoute des action listener à tous les boutons
	public void hist1(ActionListener e) {
		historique1.addActionListener(e);
	}

	public void meilleur1(ActionListener e) {
		meilleur_mot.addActionListener(e);
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

	public void initPanel() { // initialisation de la vue

		this.panel = new JPanel();
		this.panel.setBackground(new Color(220, 233, 230));
		this.panel.setBounds(670, 400, 120, 150);
		this.add(this.panel);
		JLabel motpossible = new JLabel("Suggestions");
		motpossible.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.add(motpossible, BorderLayout.NORTH);
		vuesuggestion(sugges);

	}

	public void vuesuggestion(Suggestion s) { // ajoute les suggestions
		this.panel.removeAll();
		this.sugges = s;
		if (this.sugges.suggestionlist.length != 0) {
			JLabel motpossible = new JLabel("Suggestions");
			motpossible.setFont(new Font("Arial", Font.PLAIN, 20));
			panel.add(motpossible, BorderLayout.NORTH);
			liste = new JList(sugges.suggestionlist);
			meilleur_mot.setVisible(true);
			JScrollPane ascenseur = new JScrollPane(liste);
			ascenseur.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			ascenseur.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			liste.setFont(new Font("Arial", Font.PLAIN, 20));
			liste.setBackground(new Color(236, 237, 191));
			panel.add(ascenseur, BorderLayout.SOUTH);
			liste.setVisibleRowCount(4);
		}

		else {
			JLabel motpossible = new JLabel("<html> Pas de <br> suggestions </html>");
			motpossible.setFont(new Font("Arial", Font.PLAIN, 15));
			panel.add(motpossible, BorderLayout.NORTH);
		}

		panel.repaint();

	}

	public void majclavier(Joueur joueur, Pioche p) { // met à jour le clavier avec les nouvelles lettres

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

	public void melangeclavier(int[] emplacement, Joueur joueur) { // mélange le clavier
		Clavier claviertemp = new Clavier(joueur);
		for (int i = 0; i < joueur.size(); i++) {
			Bouton btn = (Bouton) claviertemp.getComponent(i);
			Bouton btn2 = (Bouton) clavier.getComponent(emplacement[i]);
			btn2.setIcon(btn.lettre.image);
			btn2.lettre = btn.lettre;
		}
	}

	public void resetclavier(Joueur j) { // remet toutes les lettres dans le clavier
		for (int i = 0; i < j.size(); i++) {
			Bouton btn = (Bouton) clavier.getComponent(i);
			btn.setIcon(btn.lettre.image);
			btn.verrouille = false;
			btn.clique = false;
		}
	}

	public void majplateau(int k, ImageIcon nom) { // met à jour le plateau
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

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		// this.tableau.enregistrer();
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public void sauvegarder(ActionListener e) {
		sauvegarder.addActionListener(e);

	}

}
