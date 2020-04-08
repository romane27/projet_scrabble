package Modele;

import java.util.ArrayList;

import javafx.util.Pair;

public class Joueur extends ArrayList<Lettre> {
	public int score;
	public int pos;
	// public String nom;

	public Joueur(Pioche pioche) {
		score = 0;
		initTirage(pioche);
	}

	public void tirage(Pioche pioche) {
		int k = 7 - this.size();
		if (pioche.size()<k) {
			while (pioche.size()>0) {
				this.add(pioche.piocherLettre());
			}
		}
		else {
		for (int i = 0; i < k; i++) {
			this.add(pioche.piocherLettre());
		}
		}
		for (int i = 0; i < this.size(); i++) {
			System.out.print(this.get(i).nom);
		}
		System.out.println(this.size());
		System.out.println("\n");
	}

	public void initTirage(Pioche pioche) {
		this.clear();
		for (int i = 0; i < 7; i++) {
			this.add(pioche.piocherLettre());
		}
		for (int i = 0; i < this.size(); i++) {
			System.out.print(this.get(i).nom);
		}
		System.out.println(this.size());
		System.out.println("\n");
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < this.size(); i++) {
			s += this.get(i).nom + ", ";
		}
		return s;

	}

	public void reset(ArrayList<Lettre> listelettrejouee) {
		for (int i = 0; i < listelettrejouee.size(); i++) {
			this.add(listelettrejouee.get(i));
		}
	}
}
