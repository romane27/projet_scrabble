package projet_scrabble;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;



public class tirage_lettre {
	 static int nombrelettre =0;
	String [] lettrepossible = {"A","A","A","A","A","A","A","A","A","B","B","C","C","D","D","D","E","E","E","E","E","E","E","E","E","E","E","E","E","E","E","F","F","G","G","H","H",
			"I","I","I","I","I","I","I","I","J","K","L","L","L","L","L","M","M","M",
			"N","N","N","N","N","N","O","O","O","O","O","O","P","P","Q","R","R","R","R","R","R","S","S","S","S","S","S",
			"T","T","T","T","T","T","U","U","U","U","U","U","V","V","W","X","Y","Z"," "," "};
	//String [] newlettres = new String [this.nombrelettre];
	ArrayList <String > newlettre = new ArrayList<>();
	
	public tirage_lettre(int nbrlettre) {
		this.nombrelettre=nbrlettre;
		Random r = new Random();
		
		for (int i = 0; i < this.nombrelettre; i++) {
			newlettre.add(lettrepossible[r.nextInt(lettrepossible.length)]);
		}
		
		
	}

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		tirage_lettre ti = new tirage_lettre(7);
	}*/

}
