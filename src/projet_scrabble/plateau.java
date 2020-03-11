package projet_scrabble;

import java.awt.Color;

public class plateau {
	int[][] plateau;
	Color [] couleur  = {Color.red,Color.blue,Color.CYAN,Color.green,Color.pink}; 
	
	public plateau () {
		plateau = new int [15][15];
		//couleur rouge = 1
		// couleur bleu ==2
		// couleur cyan =3
		//couleur vert = 4 
		// couleur rose =5
		plateau[0][0]=1;
		plateau [14][14]=1;
		plateau [0][14]=1;
		plateau [14][0]=1;
				
		for (int i=0 ; i<15 ; i++) {
			
		for (int j=0; j<15; j++) {
			
			// couleur rose
			if (i==j) {
				if (i>=1 && i<=4 && i>=1 && i<=4)
				plateau [i][j]=5;
				if (j==5 && i==1) {
					// bleu
					plateau [i][j]=2;
				}
				
			}
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

