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
		initTirage(pioche);
	}

	public void tirage(Pioche pioche) {
		int k = 7 - this.jeu.size();
		for (int i = 0; i < k; i++) {
			this.jeu.add(pioche.piocherLettre());
		}
		for (int i = 0; i < this.jeu.size(); i++) {
			System.out.print(this.jeu.get(i).nom);
		}
		System.out.println(this.jeu.size());
		System.out.println("\n");
	}
	
	public void initTirage(Pioche pioche) {
		this.jeu.clear();
		for (int i = 0; i < 7; i++) {
			this.jeu.add(pioche.piocherLettre());
		}
		for (int i = 0; i < this.jeu.size(); i++) {
			System.out.print(this.jeu.get(i).nom);
		}
		System.out.println(this.jeu.size());
		System.out.println("\n");
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < jeu.size(); i++) {
			s += jeu.get(i).nom + ", ";
		}
		return s;

	}
}
