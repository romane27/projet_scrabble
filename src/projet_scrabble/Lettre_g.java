package projet_scrabble;

import java.awt.event.MouseEvent;
import java.beans.EventHandler;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Lettre_g extends Parent {
	public String lettre;// lettre de la touche, c'est une variable public pour qu'elle puisse être lue
							// depuis les autres classes
	private int positionX = 0;// abscisse
	private int positionY = 0;// ordonnée de la touche
	int valeur =0; //combien de points vaut la lettre
	int Selectionne = 0;
	Rectangle fond_touche;
	Text lettre_touche;
	Text valeur_touche;

	public Lettre_g(String l,int valeur, int posX, int posY) {
		this.lettre = new String(l);
		this.positionX = posX;
		this.positionY = posY;
		this.valeur = valeur;

		this.fond_touche = new Rectangle(40, 40, Color.WHITE);
		this.fond_touche.setArcHeight(10);
		this.fond_touche.setArcWidth(10);
		this.getChildren().add(this.fond_touche);// ajout du rectangle de fond de la touche

		this.lettre_touche = new Text();
		this.lettre_touche.setFont(new Font(25));
		this.lettre_touche.setFill(Color.BLACK);
		this.lettre_touche.setText(this.lettre);
		// this.lettre_touche.setTextAlignment(TextAlignment.CENTER);
		this.lettre_touche.setX(12);
		this.lettre_touche.setY(28);
		this.valeur_touche = new Text();
		this.valeur_touche.setFont(new Font(15));
		this.valeur_touche.setFill(Color.BLACK);
		this.valeur_touche.setText(Integer.toString(this.valeur));
		this.valeur_touche.setX(30);
		this.valeur_touche.setY(35);
		this.getChildren().add(this.valeur_touche);
		this.getChildren().add(this.lettre_touche);// ajout de la lettre de la touche

		// changement de couleur au clic de la lettre

		this.setTranslateX(this.positionX);// positionnement de la touche sur le clavier
		this.setTranslateY(this.positionY);

		this.setOnMousePressed(mouseEvent -> chgmcouleurclic(this.lettre_touche));

		this.setOnMouseDragged(e -> {
			double x = e.getX();
			double y = e.getY();
			this.Selectionne = 3;
			this.fond_touche.setX(x);
			this.fond_touche.setY(y);
			this.fond_touche.setFill(Color.WHITE);
			this.lettre_touche.setX(x + 12);
			this.lettre_touche.setY(y + 28);
			this.valeur_touche.setX(x + 30);
			this.valeur_touche.setY(y + 35);
			

			this.setOnMouseReleased(mouseEvent -> {
				System.out.println("la lettre " + this.lettre + " a été déposé en (" + ((int) e.getSceneX() - 45) / 42 + ","
						+ (e.getSceneY() - 3) / 42 + ")");
				
			});

		});
	}

	public void chgmcouleurclic(Text l) {

		if (this.fond_touche.isPressed() && this.Selectionne == 1) {
			this.fond_touche.setFill(Color.WHITE);
			this.Selectionne = 0;
			System.out.println("on deselectionne le bouton");
		} else if (this.Selectionne == 0) {
			this.fond_touche.setFill(Color.GRAY);
			System.out.println("on selectionne le bouton " + this.lettre);
			l.setFont(new Font(25));
			l.setFill(Color.BLACK);
			l.setX(12);
			l.setY(28);
			this.Selectionne = 1;

		}

	}

}