package projet_scrabble;

import javafx.scene.Parent;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

public class Clavier extends Parent {

	private lettre[] touches;

	public Clavier() {
		Rectangle grand_fond = new Rectangle();
		grand_fond.setWidth(900);
		grand_fond.setHeight(900);
		grand_fond.setFill(Color.WHITE);
		Rectangle fond_clavier = new Rectangle();
		fond_clavier.setWidth(440);
		fond_clavier.setHeight(90);
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
		Pupitre p = new Pupitre();
		lettre[] touches = new lettre[7];
		for (int i = 0; i < 7; i++) {
			touches[i] = new lettre(p.pupitre.get(i), 20 + 58* i, 20);
		}

		this.setTranslateX(230);
		this.setTranslateY(875);
		this.getChildren().add(grand_fond);
		this.getChildren().add(fond_clavier);

		for (lettre touche : touches) {
			this.getChildren().add(touche);
		}

	}
}
