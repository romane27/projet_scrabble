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
import Modele.Suggestion;
import Modele.Tableau;
import Vue2.Photo;
import Vue2.duree_tours;
import Vue2.nombre_joueur;


public class Vue extends JFrame {
	public Clavier clavier;
	public Plateau plateau;
	public JButton fdt;
	public JButton melanger;
	public JButton verifmot;
	public JButton fin_jeu;
	public Scores score;
	public IHMChrono chrono;
	public Suggestion sugges;
	public JList liste;
	public JPanel panel ;
	public Tour tour;
	
	public Vue(Tableau tableau, Multijoueur joueurs) throws IOException {
		score = new Scores(joueurs.recupNbJ(),joueurs.joueur_act());
		score.setBounds(670, 150, 150, 120);
		score.setVisible(true);
		plateau = new Plateau(tableau);
		clavier = new Clavier(joueurs.joueur_act());
		tour = new Tour(joueurs.ind_jr);
		sugges = new Suggestion(joueurs.joueur_act());
		// this.setLayout(null);
		plateau.setBounds(0, 0, 640, 640);
		clavier.setBounds((640 - (640 / 15) * 7) / 2, 640 + 10, 640 / 15 * 7, 640 / 15);
		fdt = new JButton("Fin de Tour");
		fdt.setBounds(670, 600, 170, 30);
		tour.setBounds(640,10,250,40);
		verifmot = new JButton("Vérification mot");
		verifmot.setBounds(670, 650, 170, 30);
		fin_jeu= new JButton("Arreter la partie");
		fin_jeu.setBounds(670, 300, 170, 30);
		initPanel();
		this.add(clavier);
		this.add(plateau);
		this.setSize(900, 850);
		//Photo font = new Photo("src/images/font.jpg",0,0, this.getWidth(),this.getHeight());
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
		this.panel.setBackground(new Color (220,233,230));
		this.panel.setBounds(670, 400, 120,150);
		this.add(this.panel);
		JLabel motpossible = new JLabel("Suggestions");
		motpossible.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.add(motpossible,BorderLayout.NORTH);
		vuesuggestion(sugges);

	}
	public void vuesuggestion(Suggestion s) {
		this.panel.removeAll();
		this.sugges = s;
		if (this.sugges.suggestionlist.length != 0) {
			JLabel motpossible = new JLabel("Suggestions");
			motpossible.setFont(new Font("Arial", Font.PLAIN, 20));
			panel.add(motpossible,BorderLayout.NORTH);
			//liste = new JList<>();
			//liste.setSize(200, 200);
			//liste.setFixedCellHeight(200)
			liste = new JList (sugges.suggestionlist);
			// creer un assenceur quand bcp de suggestion
			JScrollPane ascenseur = new JScrollPane(liste);
			ascenseur.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			ascenseur.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			liste.setFont(new Font("Arial", Font.PLAIN, 20) );
			liste.setBackground(new Color(236, 237, 191));
			panel.add(ascenseur,BorderLayout.SOUTH);
			//panel.add(liste, BorderLayout.CENTER);
			liste.setVisibleRowCount(4);
		}
		//this.add(panel);
		else {
			JLabel motpossible = new JLabel("Pas\n de\n suggestions");
			motpossible.setFont(new Font("Arial", Font.PLAIN, 20));
			panel.add(motpossible,BorderLayout.NORTH);
		}

		panel.repaint();
		//this.validate();



	}
	public void majclavier(Joueur joueur) {
		Clavier claviertemp = new Clavier(joueur);

		for (int i = 0; i < 7; i++) {
			Bouton btn = (Bouton) claviertemp.getComponent(i);
			Bouton btn2 = (Bouton) clavier.getComponent(i);
			btn2.setIcon(btn.lettre.image);
			// btn2.setText(btn.lettre.nom);
			// btn2.setBackground(Color.white);
			btn2.lettre = btn.lettre;
			btn2.verrouille = false;
			btn2.clique = false;
		}

	}

	public void melangeclavier(int[] emplacement, Joueur joueur) {
		Clavier claviertemp = new Clavier(joueur);
		for (int i = 0; i < 7; i++) {
			Bouton btn = (Bouton) claviertemp.getComponent(i);
			Bouton btn2 = (Bouton) clavier.getComponent(emplacement[i]);
			// btn2.place=emplacement[i];
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

			// btn.setBackground(Color.white);
		}
	}

	public void majplateau(int k, ImageIcon nom) {
		//		public void majplateau(int k, String nom) {
		Bouton bouton = (Bouton) plateau.getComponent(k);
		// bouton.setBackground(Color.white);
		bouton.setIcon(nom);
		// bouton.setText(nom);
	}

}
