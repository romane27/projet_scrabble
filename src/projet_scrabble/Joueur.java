package projet_scrabble;

import java.util.ArrayList;

public class Joueur {
	ArrayList<Lettre> jeu;
	// private int score;
	// private String nom;

	public Joueur(Pioche pioche) {
		this.jeu = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			this.jeu.add(pioche.piocherLettre());
		}
	}
	public void tirage(Pioche pioche) {
		for (int i = 0; i < 7-this.jeu.size(); i++) {
			this.jeu.add(pioche.piocherLettre());
		}
	}
}
