package projet_scrabble;

import com.sun.prism.paint.Color;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class bouton_ok extends Parent {
	static Button bouton;

	
	public bouton_ok(String nom) {
	// TODO Auto-generated constructor stub
		bouton = new Button(nom);
		bouton.setStyle("-fx-background-color: #00ff00");
		bouton.setTranslateX(700);
		bouton.setTranslateY(670);
		bouton.setOnAction(ActionEvent-> {
			for (Button b : Lettre_g.bouttonsupprimer) {
				b.setVisible(true);
			}
			for (Lettre_g lettre: Lettre_g.lettre_plateau) {
				lettre.setVisible(false);
				Lettre_g.ajout_lettre_sele(lettre.lettre);
			};});
		this.getChildren().add(bouton);
}	
	

}


