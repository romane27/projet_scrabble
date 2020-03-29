package projet_scrabble;

import java.util.ArrayList;

import javafx.scene.Parent;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

public class Clavier extends Parent {

	private Lettre_g[] touches;
	Tirage_lettre tirage;
	ArrayList<Lettre> t; // la liste des lettres dans le clavier
	Controleur c;
	Tableau m;
	int taille =50;
	public Clavier(Controleur c, Tableau m) {
		this.c = c ;
		this.m = m;
		Rectangle grand_fond = new Rectangle();
		grand_fond.setWidth(250); // 900
		grand_fond.setHeight(300); // 900
		grand_fond.setFill(Color.WHITE);
		Rectangle fond_clavier = new Rectangle();
		fond_clavier.setWidth(420);
		fond_clavier.setHeight(80);
		fond_clavier.setArcWidth(30);
		fond_clavier.setArcHeight(30);
		fond_clavier.setFill( // on remplie notre rectangle avec un dégradé
				new LinearGradient(0f, 0f, 0f, 1f, true, CycleMethod.NO_CYCLE,
						new Stop[] { new Stop(0, Color.web("#333333")), new Stop(1, Color.web("#000000")) }));
		Reflection r = new Reflection();// on applique un effet de réflection
		r.setFraction(0.25);
		r.setBottomOpacity(0);
		r.setTopOpacity(0.5);
		fond_clavier.setEffect(r);
		Tirage_lettre tirage = new Tirage_lettre(7);
		this.t = tirage.newlettre;

		touches = new Lettre_g[] { new Lettre_g(t.get(0).nom, t.get(0).valeur, 10, 20, taille),
				new Lettre_g(t.get(1).nom, t.get(1).valeur, 68, 20,  taille),
				new Lettre_g(t.get(2).nom, t.get(2).valeur, 126, 20,taille),
				new Lettre_g(t.get(3).nom, t.get(3).valeur, 184, 20,taille),
				new Lettre_g(t.get(4).nom, t.get(4).valeur, 242, 20,taille), 
				new Lettre_g(t.get(5).nom,t.get(5).valeur, 300, 20,taille),
				new Lettre_g(t.get(6).nom,t.get(6).valeur, 358, 20,taille)

		};

		this.setTranslateX(117);
		this.setTranslateY(640); // 875
		this.getChildren().add(grand_fond);
		this.getChildren().add(fond_clavier);

		for (Lettre_g touche : touches) {
			this.getChildren().add(touche);
		}

		// System.out.println(tirage.newLettres);

	}
	/*
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * Clavier ti = new Clavier(); }
	 */
}