package Modele;

import java.util.ArrayList;

public class Joueur {
	public ArrayList<Lettre> jeu;
	public int score;
	public int pos;
	// public String nom;

	public Joueur(Pioche pioche) {
		score = 0;
		this.jeu = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			this.jeu.add(pioche.piocherLettre());
		}
	}

	public void tirage(Pioche pioche) {
		int k = 7 - this.jeu.size();
		for (int i = 0; i < k; i++) {
			System.out.println(this);
			this.jeu.add(pioche.piocherLettre());
		}
		System.out.println(this.jeu.size());

	}

	public String toString() {
		String s = "";
		for (int i = 0; i < jeu.size(); i++) {
			s += jeu.get(i).nom + ", ";
		}
		return s;

	}
}
