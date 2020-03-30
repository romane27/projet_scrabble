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
	Modele m;
	public String lettre;// lettre de la touche, c'est une variable public pour qu'elle puisse être lue
							// depuis les autres classes
	private int positionX = 0;// abscisse
	private int positionY = 0;// ordonnée de la touche
	int valeur =0; //combien de points vaut la lettre
	//int Selectionne = 0;
	Rectangle fond_touche;
	//Text lettre_touche;
	//Text valeur_touche;
	boolean deplacable; //1 quand la lettre est déplaçable (sur le pupitre ou sur le plateau mais jouable ) / 0 quand elle ne l'est plus
	Button lettres;
	int taille;
	//static matrice_mots mat;
	//static ArrayList <String> lettresel ;
	public Lettre_g(Controleur c, Modele m , String l,int valeur, int posX, int posY,int taille) {
		this.c=c;
		this.m=m;
		this.lettre = l;
		this.positionX = posX;
		this.positionY = posY;
		this.valeur = valeur;
		this.deplacable = true;
		//this.lettresel =new ArrayList<>();
		//lettresel.add("A");
		this.taille = taille;
		this.lettres=new Button(this.lettre);
		//bouton.setMinHeight(50);;
		lettres.setMinSize(taille,taille);
		lettres.setStyle("-fx-background-color: White");
		//bouton.setStyle("-fx-border-color:White");
		lettres.setTranslateX(posX);
		lettres.setTranslateY(posY);
		this.getChildren().add(lettres);
		this.lettres_selectionne();
		//System.out.println("ccc");
			
		// on differenci clic droit ou gauche
		//lettres_selectionne();
	}

	public void lettres_selectionne() {
		//System.out.print("On clique sur un bouton");
		lettres.setOnMousePressed(e-> {
			System.out.println("On clique sur un bouton");
			if (e.getButton() == MouseButton.SECONDARY){
				lettres.setStyle("-fx-background-color: White"); 
				System.out.println("Nope");
			}
		//lettresel.remove(-1);}
			else {
				lettres.setStyle("-fx-background-color: Gray");
				this.m.modifL_EC(this);
				// on ajoute la lettre selectionne a la liste 
				//System.out.println("la lettre"+lettres.getText());
				//lettresel.add(lettres.getText());
				}
		});
	}
	
	public void setPosition(int posX, int posY) {
		System.out.println(posX);
		System.out.println(posY);
		this.positionX = posX*this.taille;
		this.positionY = posY*this.taille;
		this.lettres.setTranslateX(this.positionX);
		this.lettres.setTranslateY(this.positionY);
		this.lettres.setStyle("-fx-background-color: White"); 
		System.out.println(this.positionX);
		System.out.println(this.positionY);
		
		//this.getChildren().add(this.lettres);
	}
	/*public void ajout_lettre_sele(String lettre_a_ajouter) {
		this.lettresel.add(lettre_a_ajouter);
		System.out.println(lettresel.get(1));
		System.out.println("la lettre ajoute est"+ lettre_a_ajouter);
		
	}
	public void supprimer_lettre_sele(String lettre_a_supprimer) {
		this.lettresel.remove(-1);
		System.out.println("la lettre supprimer est"+ lettre_a_supprimer);
	}*/
	
	
	

	@Override
	public void addListener(InvalidationListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListener(InvalidationListener arg0) {
		// TODO Auto-generated method stub
		
	}

}