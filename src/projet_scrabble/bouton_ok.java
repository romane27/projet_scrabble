package projet_scrabble;

import com.sun.prism.paint.Color;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class bouton_ok extends Parent {
	final Button bouton;
	Modele m;
	
	public bouton_ok(String nom, Modele m) {
	// TODO Auto-generated constructor stub
		this.m = m;
		bouton = new Button(nom);
		bouton.setStyle("-fx-background-color: #00ff00");
		bouton.setTranslateX(700);
		bouton.setTranslateY(670);
		bouton.setOnAction(ActionEvent-> { for (Lettre_g lettre : this.m.manche) {
			System.out.println(lettre.lettre);
			this.m.en_cours = lettre;
			this.m.supprimerElem(((lettre.positionX)/lettre.taille), (lettre.positionY)/lettre.taille);
			lettre.setVisible(false);
			
		}
			
		//	Modele.manche[i].setVisible(false);
			//Modele.manche[i].lettres.setVisible(true);
			}
);
		this.getChildren().add(bouton);
}	
	

}


