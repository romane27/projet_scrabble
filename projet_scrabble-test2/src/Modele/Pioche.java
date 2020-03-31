package Modele;

import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;

public class Pioche {
	ArrayList<Lettre> lettrepossible;

	public Pioche() {
		this.lettrepossible = new ArrayList<Lettre>();
		for (int i = 0; i < 12; i++) {
			this.lettrepossible.add(new Lettre("E", 1));
		}

		for (int i = 0; i < 9; i++) {
			this.lettrepossible.add(new Lettre("A", 1));
			this.lettrepossible.add(new Lettre("I", 1));
		}

		for (int i = 0; i < 8; i++) {
			this.lettrepossible.add(new Lettre("O", 1));
		}

		for (int i = 0; i < 6; i++) {
			this.lettrepossible.add(new Lettre("N", 1));
			this.lettrepossible.add(new Lettre("R", 1));
			this.lettrepossible.add(new Lettre("T", 1));
		}

		for (int i = 0; i < 4; i++) {
			this.lettrepossible.add(new Lettre("L", 1));
			this.lettrepossible.add(new Lettre("S", 1));
			this.lettrepossible.add(new Lettre("U", 1));
			this.lettrepossible.add(new Lettre("D", 2));
		}

		for (int i = 0; i < 3; i++) {
			this.lettrepossible.add(new Lettre("G", 2));
		}

		for (int i = 0; i < 2; i++) {
			this.lettrepossible.add(new Lettre("B", 3));
			this.lettrepossible.add(new Lettre("C", 3));
			this.lettrepossible.add(new Lettre("M", 3));
			this.lettrepossible.add(new Lettre("P", 3));
			this.lettrepossible.add(new Lettre("F", 4));
			this.lettrepossible.add(new Lettre("H", 4));
			this.lettrepossible.add(new Lettre("V", 4));
			this.lettrepossible.add(new Lettre("W", 4));
			this.lettrepossible.add(new Lettre("Y", 4));
			this.lettrepossible.add(new Lettre(" ", 0));
		}

		this.lettrepossible.add(new Lettre("K", 5));
		this.lettrepossible.add(new Lettre("J", 8));
		this.lettrepossible.add(new Lettre("X", 8));
		this.lettrepossible.add(new Lettre("Q", 10));
		this.lettrepossible.add(new Lettre("Z", 10));

		/*
		 * System.out.println(this.piocherLettre().nom); for (int i=0;
		 * i<this.lettrepossible.size(); i++) {
		 * System.out.print(this.lettrepossible.get(i).nom); }
		 */
	}

	public Lettre piocherLettre() { // pioche une lettre et la supprime de la pioche
		Random r = new Random();
		Lettre l = this.lettrepossible.get(r.nextInt(this.lettrepossible.size()));
		this.lettrepossible.remove(l);
		return l;
	}

	/*
	 * public static void main(String[] args) { Pioche p = new Pioche(); }
	 */
}
