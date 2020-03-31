package Modele;

import java.util.ArrayList;

public class Joueur {
	public ArrayList<Lettre> jeu;
	public int score;
	public int pos;
	// public String nom;

	public Joueur(Pioche pioche) {
		score=0;
		this.jeu = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			this.jeu.add(pioche.piocherLettre());
		}
	}

	public void tirage(Pioche pioche) {
		for (int i = 0; i < 7 - this.jeu.size(); i++) {
			this.jeu.add(pioche.piocherLettre());
		}
	}
}
