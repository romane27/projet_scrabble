package projet_scrabble;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Plateau extends Parent {
	Tableau plateau; // Color [] couleur = {Color.RED,Color.BLUE,Color.CYAN,Color.GREEN,Color.pink};
	int taille = 42; // 50/20
	// int espace = 30; //40/10
	String[] name;

	// ArrayList<Integer> Placement_bouton = new ArrayList<>();
	public Plateau() {

		// this.name=nom;
		plateau = new Tableau();
		Rectangle r = new Rectangle();
		r.setStroke(Color.BLACK);
		r.setWidth(15 * taille + 6);
		r.setHeight(15 * taille + 6);
		r.setX(taille - 3);
		r.setY(0);
		this.getChildren().add(r);

		for (int i = 0; i < 15; i++) {
			for (int j = 1; j < 16; j++) {
				// couleur bleu

				if (plateau.tableau[i][j - 1].bonus == 2) {
					Rectangle rect_bleu = new Rectangle();
					rect_bleu.setStroke(Color.WHITE);
					rect_bleu.setWidth(taille);
					rect_bleu.setHeight(taille);
					rect_bleu.setX(j * taille);
					rect_bleu.setY(i * taille + 3);

					rect_bleu.setFill(Color.rgb(13, 52, 225));
					this.getChildren().add(rect_bleu);
				}
				// milieu
				if (plateau.tableau[i][j - 1].bonus == 6) {
					Rectangle rect_rose = new Rectangle();
					rect_rose.setStroke(Color.WHITE);
					rect_rose.setWidth(taille);
					rect_rose.setHeight(taille);
					rect_rose.setX(j * taille);
					rect_rose.setY(i * taille + 3);

					rect_rose.setFill(Color.PINK);
					this.getChildren().add(rect_rose);
				}

				// couleur rouge
				if (plateau.tableau[i][j - 1].bonus == 1) {
					Rectangle rect_rouge = new Rectangle();
					rect_rouge.setStroke(Color.WHITE);
					rect_rouge.setWidth(taille);
					rect_rouge.setHeight(taille);
					rect_rouge.setX(j * taille);
					rect_rouge.setY(i * taille + 3);
					rect_rouge.setFill(Color.rgb(225, 13, 13));
					this.getChildren().add(rect_rouge);
				}
				// couleur cyan
				if (plateau.tableau[i][j - 1].bonus == 3) {
					Rectangle rect_cyan = new Rectangle();
					rect_cyan.setStroke(Color.WHITE);
					rect_cyan.setWidth(taille);
					rect_cyan.setHeight(taille);
					rect_cyan.setX(j * taille);
					rect_cyan.setY(i * taille + 3);
					rect_cyan.setFill(Color.rgb(31, 174, 238));
					this.getChildren().add(rect_cyan);
				}
				// couleur beige
				if (plateau.tableau[i][j - 1].bonus == 5) {
					Rectangle rect_beige = new Rectangle();
					rect_beige.setStroke(Color.WHITE);
					rect_beige.setWidth(taille);
					rect_beige.setHeight(taille);
					rect_beige.setX(j * taille);
					rect_beige.setY(i * taille + 3);
					rect_beige.setFill(Color.rgb(230, 216, 171));
					this.getChildren().add(rect_beige);
					// couleur vert
				}
				if (plateau.tableau[i][j - 1].bonus == 0) {
					Rectangle rect_vert = new Rectangle();
					rect_vert.setStroke(Color.WHITE);
					rect_vert.setWidth(taille);
					rect_vert.setHeight(taille);
					rect_vert.setX(j * taille);
					rect_vert.setY(i * taille + 3);
					rect_vert.setFill(Color.rgb(10, 173, 153));
					this.getChildren().add(rect_vert);

				}

			}
		}
	}
}
