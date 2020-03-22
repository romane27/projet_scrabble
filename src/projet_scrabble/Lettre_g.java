package projet_scrabble;

import java.awt.event.MouseEvent;
import java.beans.EventHandler;
import java.util.ArrayList;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Lettre_g extends Parent implements Observable {
	Controleur c;
	Tableau m;
	public String lettre;// lettre de la touche, c'est une variable public pour qu'elle puisse être lue
							// depuis les autres classes
	private int positionX = 0;// abscisse
	private int positionY = 0;// ordonnée de la touche
	int valeur =0; //combien de points vaut la lettre
	int Selectionne = 0;
	Rectangle fond_touche;
	Text lettre_touche;
	Text valeur_touche;
	boolean deplacable; //1 quand la lettre est déplaçable (sur le pupitre ou sur le plateau mais jouable ) / 0 quand elle ne l'est plus
	Button lettres;
	static matrice_mots mat;
	static ArrayList <String> lettresel ;
	public Lettre_g(String l,int valeur, int posX, int posY,int taille) {
		this.lettre = l;
		this.positionX = posX;
		this.positionY = posY;
		this.valeur = valeur;
		this.lettresel =new ArrayList<>();
		lettresel.add("A");
		this.lettres=new Button(this.lettre);
		//bouton.setMinHeight(50);;
		lettres.setMinSize(taille,taille);
		lettres.setStyle("-fx-background-color: White");
		//bouton.setStyle("-fx-border-color:White");
		lettres.setTranslateX(posX);
		lettres.setTranslateY(posY);
		this.getChildren().add(lettres);
		//lettres.setOnAction(ActionEvent-> lettres_selectionne(lettres) );
		//System.out.println("ccc");
			
		// on differenci clic droit ou gauche
		lettres_selectionne();
	}
		/*this.c = c;
		this.lettre = l.nom;
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
				int pX = (int)(( e.getSceneX() +21-45) / 42);
				int pY = (int)((e.getSceneY() +21 -3) / 42);
				System.out.println("la lettre " + this.lettre + " a été déposé en (" + pX + ","
						+ pY + ")");
				m.ajoutLettre(pX, pY, l); // pour envoyer sur le modèle
				
			});

		});
	}*/

	/*public void chgmcouleurclic(Text l) {

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

	}*/
	public void lettres_selectionne() {
		lettres.setOnMousePressed(e-> {if (e.getButton() == MouseButton.SECONDARY){lettres.setStyle("-fx-background-color: White"); 
		supprimer_lettre_sele(lettres.getText());
		}
		//lettresel.remove(-1);}
		else {lettres.setStyle("-fx-background-color: Gray");
		ajout_lettre_sele(lettres.getText());
		// on ajoute la lettre selectionne a la liste 
		//System.out.println("la lettre"+lettres.getText());
		lettresel.add(lettres.getText());}});}
	public void ajout_lettre_sele(String lettre_a_ajouter) {
		this.lettresel.add(lettre_a_ajouter);
		System.out.println(lettresel.get(1));
		System.out.println("la lettre ajoute est"+ lettre_a_ajouter);
		
	}
	public void supprimer_lettre_sele(String lettre_a_supprimer) {
		this.lettresel.remove(-1);
		System.out.println("la lettre supprimer est"+ lettre_a_supprimer);
	}
	
	public static Lettre_g changer_bouton(double x, double y) {
		String l= lettresel.get(1);
	
		System.out.println(l);
		System.out.println(y);
		int taille=42;
		System.out.println((int)(x/50)*50);
		System.out.println((int)(y/50)*50);
		
		Lettre_g lll =new Lettre_g(l, 2, (int)(x/taille)*taille, (int)(y/taille)*taille,taille);
		//lll.getChildren().add();
		//this.getChildren().add(le);
		mat.mat_lettre(lll.lettre,(int)(x/taille),(int)(y/taille));
		System.out.println("la lelele"+lll.lettre);
		return lll;
		
	}
	

	@Override
	public void addListener(InvalidationListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListener(InvalidationListener arg0) {
		// TODO Auto-generated method stub
		
	}

}