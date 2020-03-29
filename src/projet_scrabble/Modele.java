package projet_scrabble;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Modele {
	
	static String [][] matrice;
	ArrayList <String> listlettre;
	Dico dico;
	Lettre l = new Lettre("A", 2);

	public Modele() {
		this.matrice = new String[15][15];
		try {
			this.dico = new Dico();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			

		
	}
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/
	
	public static void ajouter_lettre(String lettre, int posX, int posY) {
		matrice[posY][posX-1]=lettre;
		for (int i = 0; i < 14; i++) { // initialisation du tableau
			for (int j = 0; j < 14; j++) {
				System.out.print(matrice[i][j] + " ");
			}
			System.out.println();
			}

	}

}
