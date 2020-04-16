package Modele;

import Vue2.nombre_joueur;

public class Multijoueur {
	public int ind_jr;
	public Joueur[] tab_joueurs;
	
	public Multijoueur(Pioche pioche) {
		this.tab_joueurs = new Joueur[nombre_joueur.nbrjoueur];
		this.ind_jr = 0;
		for (int i=0; i<nombre_joueur.nbrjoueur; i++) {
			tab_joueurs[i] = new Joueur(pioche);
			System.out.println(tab_joueurs[i]);
		}
		
	}
	
	public Joueur joueur_act() {
		return this.tab_joueurs[this.ind_jr];
	}
	
	public void changer_joueur() {
		this.ind_jr = (this.ind_jr +1) % nombre_joueur.nbrjoueur;
		System.out.println("num joueur : "+ this.ind_jr);
	}
	
}
