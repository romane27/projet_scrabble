package projet_scrabble;

import java.io.IOException;
import java.util.Random;

public class Pupitre {
	public Pupitre() {
		Character[] pupitre = new Character[7];
		Character[] pioche = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		Random r = new Random();
		for (int i = 0; i < 7; i++) {
			pupitre [i]=pioche[r.nextInt(25)];
		}
	}public static void main(String[] argv) throws IOException {
		Pupitre p = new Pupitre();
	}

}
