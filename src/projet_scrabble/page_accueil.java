package projet_scrabble;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class page_accueil extends JFrame{
	public page_accueil() {
		this.setSize(1000,1000);

		//this.pack();
		String [] lettre_joueurs = {"A","B","C","D","E","F","G"};
		plateau p = new plateau (lettre_joueurs);
		//JPanel panel = new JPanel();
		//bouton bouton_lettres = new bouton(panel,lettre_joueurs);
		//bouton bouton_lettre = new bouton(lettre_joueurs);
		//this.add(bouton_lettres,BorderLayout.SOUTH);
		//panel.setBounds(100, 50, 80, 80);
		//panel.setPreferredSize(new Dimension(100,100));
		//this.getContentPane().add(panel, BorderLayout.SOUTH);
		//this.add(panel,BorderLayout.SOUTH);
		
		//this.add(le,BorderLayout.SOUTH);
		this.add(p);
		
	//	this.pack();
		this.setLocationRelativeTo(null); 
		//this.addWindowListener(this);
		this.setVisible(true);
	}



public static void main(String[] args) {
	// TODO Auto-generated method stub
	new page_accueil();
}}