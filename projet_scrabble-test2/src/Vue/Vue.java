package Vue;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Modele.Bouton;
import Modele.Joueur;
import Modele.Tableau;

import Vue2.duree_tours;
public class Vue extends JFrame {
	public Clavier clavier;
	public Plateau plateau;
	public JButton fdt;
	public JButton melanger;
	public Scores score;
	public IHMChrono chrono;
	
	public Vue(Tableau tableau, Joueur joueur, Joueur joueur2) {
		score = new Scores(4);
		score.setBounds(670, 150, 150, 120);
		score.setVisible(true);
		plateau = new Plateau(tableau);
		clavier = new Clavier(joueur);
		//this.setLayout(null);
		plateau.setBounds(0, 0, 640, 640);
		clavier.setBounds((640 - (640 / 15) * 7) / 2, 640 + 10, 640 / 15 * 7, 640 / 15);
		fdt = new JButton("Fin de Tour");
		fdt.setBounds(670, 600, 170, 30);
		this.add(clavier);
		this.add(plateau);
		this.setSize(900, 850);
		ImageIcon melange = new ImageIcon("src/images/melanger.png");
		melanger = new JButton(melange);
	
		melanger.setBounds(550, 650, melange.getIconHeight(), melange.getIconWidth());
		
		this.add(melanger);
		//this.setResizable(false);
		this.getContentPane().setBackground(Color.white);
		this.add(fdt);
		this.add(score);
		chrono = new IHMChrono(duree_tours.duree);
		this.add(chrono);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void ajoutactlist(ActionListener e) {
		fdt.addActionListener(e);
	}
	public void emplacement_lettre(ActionListener e) {
		melanger.addActionListener(e);
	}


	public void majclavier(Joueur joueur) {
		Clavier claviertemp = new Clavier(joueur);

		for (int i = 0; i < 7; i++) {
			Bouton btn = (Bouton) claviertemp.getComponent(i);
			Bouton btn2 = (Bouton) clavier.getComponent(i);
			btn2.setIcon(btn.lettre.image);
			//btn2.setText(btn.lettre.nom);
			//btn2.setBackground(Color.white);
			btn2.lettre = btn.lettre;
		}

	}
	public void melangeclavier (int [] emplacement,Joueur joueur) {
		Clavier claviertemp = new Clavier(joueur);
		for (int i = 0; i < 7; i++) {
			Bouton btn = (Bouton) claviertemp.getComponent(i);
			Bouton btn2 = (Bouton) clavier.getComponent(emplacement[i]);
			//btn2.place=emplacement[i];
			btn2.setIcon(btn.lettre.image);
			btn2.lettre = btn.lettre;
		}
	}

	public void resetclavier() {
		for (int i = 0; i < 7; i++) {
			Bouton btn = (Bouton) clavier.getComponent(i);
			btn.setIcon(btn.lettre.image);
			//btn.setBackground(Color.white);
		}
	}
	public void majplateau(int k, ImageIcon nom) {
//		public void majplateau(int k, String nom) {
			Bouton bouton = (Bouton) plateau.getComponent(k);
			//bouton.setBackground(Color.white);
			bouton.setIcon(nom);
			//bouton.setText(nom);
		}

}
