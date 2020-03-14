package projet_scrabble;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Pupitre {
	ArrayList<String> pupitre;
	
	public Pupitre() {
		this.pupitre = new ArrayList<String>();
		String [] lettres = {" "," ","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","A","A","A","A","A","A","A","A","A","I","I","I","I","I","I","I","I","N","N","N","N","N","N","O","O","O","O","O","O","R","R","R","R","R","R","S","S","S","S","S","S","T","T","T","T","T","T","U","U","U","U","U","U","L","L","L","L","L","D","D","D","M","M","M","G","G","B","B","C","C","P","P","F","F","H","H","V","V","J","Q","K","W","X","Y","Z"}; 
		ArrayList<String> pioche = new ArrayList<String>(Arrays.asList(lettres));
		Random r = new Random();
		for (int i = 0; i < 7; i++) {
			int nb_random=r.nextInt(lettres.length);
			pupitre.add(pioche.get(nb_random));
			pioche.remove(nb_random);
		}System.out.println(pupitre);
	}public static void main(String[] argv) throws IOException {
		Pupitre p = new Pupitre();
	}

}
