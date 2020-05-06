package Modele;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.util.Pair;

public class Joueur extends ArrayList<Lettre> implements Serializable {
	public int score;
	public int pos;
	public ArrayList<String> mot;

	public Joueur(Pioche pioche) {
		score = 0;
		initTirage(pioche);
		mot = new ArrayList<>();
	}
	public void tirage(Pioche pioche) { // tire le nombre de lettres qu'il manque au joueur
		int k = 7 - this.size();
		if (pioche.pioche.size() < k) {
			while (pioche.pioche.size() > 0) {
				this.add(pioche.piocherLettre());
			}
		} else {
			for (int i = 0; i < k; i++) {
				this.add(pioche.piocherLettre());
			}
		}
	}

	public void initTirage(Pioche pioche) { // initialise le tirage
		this.clear();
		for (int i = 0; i < 7; i++) {
			this.add(pioche.piocherLettre());
		}
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < this.size(); i++) {
			s += this.get(i).nom + ", ";
		}
		return s;

	}

	public void reset(ArrayList<Lettre> listelettrejouee) { // remet les lettres dans le clavier du joueur
		for (int i = 0; i < listelettrejouee.size(); i++) {
			this.add(listelettrejouee.get(i));
		}
	}

	public void echange(ArrayList<Integer> l) { // permet l'échange des lettres
		for (int i = 0; i < l.size(); i++) {
			this.remove((int) l.get(i));
		}

	}
}
