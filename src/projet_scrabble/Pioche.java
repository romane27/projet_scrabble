package projet_scrabble;

import java.util.ArrayList;

public class Pioche {
	ArrayList<Lettre> lettrepossible;

	public Pioche() {
		lettrepossible = new ArrayList<Lettre>();
		for (int i = 0; i < 12; i++) {
			lettrepossible.add(new Lettre("E", 1));
		}

		for (int i = 0; i < 9; i++) {
			lettrepossible.add(new Lettre("A", 1));
			lettrepossible.add(new Lettre("I", 1));
		}

		for (int i = 0; i < 8; i++) {
			lettrepossible.add(new Lettre("O", 1));
		}

		for (int i = 0; i < 6; i++) {
			lettrepossible.add(new Lettre("N", 1));
			lettrepossible.add(new Lettre("R", 1));
			lettrepossible.add(new Lettre("T", 1));
		}

		for (int i = 0; i < 4; i++) {
			lettrepossible.add(new Lettre("L", 1));
			lettrepossible.add(new Lettre("S", 1));
			lettrepossible.add(new Lettre("U", 1));
			lettrepossible.add(new Lettre("D", 2));
		}

		for (int i = 0; i < 3; i++) {
			lettrepossible.add(new Lettre("G", 2));
		} // end for

		// add 2 b,c,m,p,f,h,v,w,y and blank tiles
		for (int i = 0; i < 2; i++) {
			lettrepossible.add(new Lettre("B", 3));
			lettrepossible.add(new Lettre("C", 3));
			lettrepossible.add(new Lettre("M", 3));
			lettrepossible.add(new Lettre("P", 3));
			lettrepossible.add(new Lettre("F", 4));
			lettrepossible.add(new Lettre("H", 4));
			lettrepossible.add(new Lettre("V", 4));
			lettrepossible.add(new Lettre("W", 4));
			lettrepossible.add(new Lettre("Y", 4));
			lettrepossible.add(new Lettre(" ", 0));
		} // end for

		// add 1 k,j,x,q and z tiles
		lettrepossible.add(new Lettre("K", 5));
		lettrepossible.add(new Lettre("J", 8));
		lettrepossible.add(new Lettre("X", 8));
		lettrepossible.add(new Lettre("Q", 10));
		lettrepossible.add(new Lettre("Z", 10));
	}
}
