package projet_scrabble;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;



public class Tirage_lettre {
	static int nombrelettre =0;
	Pioche pioche = new Pioche();
	//String [] newlettres = new String [this.nombrelettre];
	ArrayList <Lettre> newlettre = new ArrayList<>();
	
	public Tirage_lettre(int nbrlettre) {
		this.nombrelettre=nbrlettre;
		nouveauTirage();
				
	}
	
	public ArrayList<Lettre> nouveauTirage() { //effectue un nouveau tirage sur le reste de la liste
		this.newlettre.clear(); // on initialise notre tirage
		if (this.nombrelettre < this.pioche.lettrepossible.size()) { //pioche le nombre voulu de lettres
			for (int i = 0; i < this.nombrelettre; i++) {
				Lettre l = pioche.piocherLettre();
				this.newlettre.add(l);
				//System.out.println(l.nom);
			}
			/*for (int j = 0; j < this.pioche.lettrepossible.size(); j++) {
				System.out.print(this.pioche.lettrepossible.get(j).nom);
			}*/	
		}
		else {
			if (this.pioche.lettrepossible.size() != 0) { // si on a pas assez de lettres restantes dans la pioche
					
				while (!this.pioche.lettrepossible.isEmpty()) {
					Lettre l = pioche.piocherLettre();
					this.newlettre.add(l);
				}
			}
		}
		/*System.out.println(this.newlettre.size());
		for (int i=0; i<this.newlettre.size(); i++) {
		System.out.print(this.newlettre.get(i).nom);
		}
		System.out.println("\n");*/
		return (this.newlettre); // renvoie le nouveau tirage
	}
	
	/*public static void main(String[] args) {
        Tirage_lettre p = new Tirage_lettre(7);
    }*/

}
