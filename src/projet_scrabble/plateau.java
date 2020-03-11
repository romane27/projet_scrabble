package projet_scrabble;

import java.awt.Color;

public class plateau {
	int[][] plateau;
	Color [] couleur  = {Color.red,Color.blue,Color.CYAN,Color.green,Color.pink}; 

	public plateau () {
		plateau = new int [15][15];
		for (int i=0 ; i<14 ; i++) {

			for (int j=0; j<14; j++) {
				plateau[i][j]=0;
			}
		}
		//couleur rouge = 1
		// couleur bleu ==2
		// couleur cyan =3
		//couleur vert = 4 
		// couleur rose =5
		plateau[0][0]=1;


		// carre haut gauche	
		for (int i=0 ; i<14 ; i++) {

			for (int j=0; j<14; j++) {
				// on remplie par carre de 7 par 7 car tout est symétrique
				// couleur bleu fonce 
				if (j==5 & i==1) {
					plateau [i][j]=2;
					plateau [j][i]=2;
					plateau [5][5]=2;
				}
				if (i==0 & j ==3) {
					plateau [i][j]=3;
					plateau [j][i]=3;
					plateau [6][6]=3;	
				}
				if (i==6 & j ==2) {
					plateau [i][j]=3;
					plateau [j][i]=3;

				}

				// couleur rose

				if (i<7 && j <7) {
					if (i==j & plateau[i][j]==0) {
						plateau[i][j]=5;
					}
				}
			}
		}
		// carre haut droit
		for (int i=0 ; i<7 ; i++) {

			for (int j=7; j<15; j++) {
				plateau[i][j]=plateau[i][7-(j-7)];
				if (j==7) {
					plateau[i][j]=plateau[i][0];
				}
			}

		}
		// carre bas gauche
		for (int i=7 ; i<15 ; i++) {

			for (int j=0; j<8; j++) {
				plateau[i][j]=plateau[7-(i-7)][j];
				if (i==7) {
					plateau[i][j]=plateau[0][j];
				}
			}

		}
		// carre bas droit
		for (int i=7 ; i<15 ; i++) {

			for (int j=7; j<15; j++) {
				plateau[i][j]=plateau[i][7-(j-7)];
				if (j==7) {
					plateau[i][j]=plateau[i][0];
				}
			}

		}
		plateau [7][7]=5;
		// on affiche la matrice 		
		for (int i=0 ; i<15 ; i++) {

			for (int j=0; j<15; j++) {
				System.out.print(plateau[i][j] + " ");
			}
			System.out.println();
		}

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new plateau();
	}
}

