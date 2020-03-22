package projet_scrabble;

import java.util.ArrayList;

public class matrice_mots {
	private int posX;
	private int posY;
	static String [][] matrice = new String[15][15];
	ArrayList <String> listlettre;
	Lettre l = new Lettre("A", 2);
	public matrice_mots() {
		
	}
	public static void mat_lettre(String lettre, int posX, int posY) {
		matrice[posY][posX-1]=lettre;
			for (int i = 0; i < 14; i++) { // initialisation du tableau
				for (int j = 0; j < 14; j++) {
					System.out.print(matrice[i][j] + " ");
				}
				System.out.println();
				}

	}

}