package projet_scrabble;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;



public class Tirage_lettre {
	 static int nombrelettre =0;
	Pioche pioche = new Pioche();
	//String [] newlettres = new String [this.nombrelettre];
	ArrayList <Lettre > newlettre = new ArrayList<>();
	
	public Tirage_lettre(int nbrlettre) {
		this.nombrelettre=nbrlettre;
		Random r = new Random();
		
		for (int i = 0; i < this.nombrelettre; i++) {
			newlettre.add(pioche.lettrepossible.get(r.nextInt(pioche.lettrepossible.size())));
		}
		
		
	}

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		tirage_lettre ti = new tirage_lettre(7);
	}*/

}
