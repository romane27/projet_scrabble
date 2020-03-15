package projet_scrabble;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class plateau extends Parent {
	int[][] plateau;
	//Color [] couleur  = {Color.RED,Color.BLUE,Color.CYAN,Color.GREEN,Color.pink}; 
	int taille=42; //50/20
	//int espace = 30; //40/10
	String [] name;

	//ArrayList<Integer> placement_bouton = new ArrayList<>();
	public plateau() {

		//this.name=nom;
		plateau = new int [15][15];
		for (int i=0 ; i<14 ; i++) {

			for (int j=0; j<14; j++) {
				plateau[i][j]=0;
			}
		}
		//couleur rouge = 1
		// couleur bleu ==2
		// couleur cyan =3
		//couleur vert = 0
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
		/*for (int i=0 ; i<15 ; i++) {

			for (int j=0; j<15; j++) {
				System.out.print(plateau[i][j] + " ");
			}
			System.out.println();
		}*/
		
		Rectangle r = new Rectangle();
		r.setStroke(Color.BLACK);
		r.setWidth(15*taille+6);
		r.setHeight(15*taille+6);
		r.setX(taille-3);
		r.setY(0);
		this.getChildren().add(r);
		
		for (int i = 0; i < 15; i++) {
			for( int j = 1 ; j < 16; j++) {
				// couleur bleu


				if (plateau[i][j-1]==2) {
					Rectangle rect_bleu = new Rectangle();
					rect_bleu.setStroke(Color.WHITE);
					rect_bleu.setWidth(taille);
					rect_bleu.setHeight(taille);
					rect_bleu.setX(j*taille);
					rect_bleu.setY(i*taille+3);

					rect_bleu.setFill(Color.rgb(13, 52, 225));
					this.getChildren().add(rect_bleu);
				}

				// couleur rouge
				if (plateau[i][j-1]==1) {
					Rectangle rect_rouge = new Rectangle();
					rect_rouge.setStroke(Color.WHITE);
					rect_rouge.setWidth(taille);
					rect_rouge.setHeight(taille);
					rect_rouge.setX(j*taille);
					rect_rouge.setY(i*taille+3);
					rect_rouge.setFill(Color.rgb(225,13,13));
					this.getChildren().add(rect_rouge);
				}
				// couleur cyan
				if (plateau[i][j-1]==3) {
					Rectangle rect_cyan = new Rectangle();
					rect_cyan.setStroke(Color.WHITE);
					rect_cyan.setWidth(taille);
					rect_cyan.setHeight(taille);
					rect_cyan.setX(j*taille);
					rect_cyan.setY(i*taille+3);
					rect_cyan.setFill(Color.rgb(31,174,238));
					this.getChildren().add(rect_cyan);
				}
				// couleur beige
				if (plateau[i][j-1]==5) {
					Rectangle rect_beige = new Rectangle();
					rect_beige.setStroke(Color.WHITE);
					rect_beige.setWidth(taille);
					rect_beige.setHeight(taille);
					rect_beige.setX(j*taille);
					rect_beige.setY(i*taille+3);
					rect_beige.setFill(Color.rgb(230,216,171));
					this.getChildren().add(rect_beige);
					// couleur vert  
				}
				if (plateau[i][j-1]==0) {
					Rectangle rect_vert = new Rectangle();
					rect_vert.setStroke(Color.WHITE);
					rect_vert.setWidth(taille);
					rect_vert.setHeight(taille);
					rect_vert.setX(j*taille);
					rect_vert.setY(i*taille+3);
					rect_vert.setFill(Color.rgb(10,173,153));
					this.getChildren().add(rect_vert);

				}

			}
		}
	}
}


