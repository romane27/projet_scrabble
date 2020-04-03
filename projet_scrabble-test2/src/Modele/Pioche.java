package Modele;

import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;

public class Pioche extends ArrayList<Lettre> {

	public Pioche() {
		for (int i = 0; i < 15; i++) {
			this.add(new Lettre("E", 1));
		}

		for (int i = 0; i < 8; i++) {
			this.add(new Lettre("I", 1));
		}

		for (int i = 0; i < 9; i++) {
			this.add(new Lettre("A", 1));

		}

		for (int i = 0; i < 6; i++) {
			this.add(new Lettre("O", 1));
			this.add(new Lettre("N", 1));
			this.add(new Lettre("R", 1));
			this.add(new Lettre("S", 1));
			this.add(new Lettre("U", 1));
			this.add(new Lettre("T", 1));
		}

		for (int i = 0; i < 5; i++) {
			this.add(new Lettre("L", 1));
		}

		for (int i = 0; i < 3; i++) {
			this.add(new Lettre("D", 2));
			this.add(new Lettre("M", 3));

		}

		for (int i = 0; i < 2; i++) {
			this.add(new Lettre("G", 2));
			this.add(new Lettre("B", 3));
			this.add(new Lettre("C", 3));
			this.add(new Lettre("P", 3));
			this.add(new Lettre("F", 4));
			this.add(new Lettre("H", 4));
			this.add(new Lettre("V", 4));
			this.add(new Lettre(" ", 0));
		}
		this.add(new Lettre("W", 4));
		this.add(new Lettre("Y", 4));
		this.add(new Lettre("K", 5));
		this.add(new Lettre("J", 8));
		this.add(new Lettre("X", 8));
		this.add(new Lettre("Q", 10));
		this.add(new Lettre("Z", 10));

		/*
		 * System.out.println(this.piocherLettre().nom); for (int i=0; i<this.size();
		 * i++) { System.out.print(this.get(i).nom); }
		 */
	}

	public Lettre piocherLettre() { // pioche une lettre et la supprime de la pioche
		Random r = new Random();
		Lettre l = this.get(r.nextInt(this.size()));
		this.remove(l);
		return l;
	}

	/*
	 * public static void main(String[] args) { Pioche p = new Pioche(); }
	 */
}
