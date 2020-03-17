package projet_scrabble;

import java.awt.List;
import java.awt.Panel;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class Suggestions extends Parent {
	ArrayList<String> lettres_selectionnees;
	ListView suggestion;

	public Suggestions() throws IOException {
		this.suggestion = new ListView();
		this.lettres_selectionnees = new ArrayList<String>();
		List listeImages = new List(20);
		listeImages.setName("sélectionImages");
		Dico dico = new Dico();
		for (String nebular : lettres_selectionnees) {
			suggestion.getItems().add(nebular);
		}
		suggestion.setMaxHeight(42*3);
		Label label = new Label("mots possibles");
		this.setTranslateX(700);
		this.setTranslateY(42*12+3);
		this.getChildren().add(suggestion);
		
	}
}