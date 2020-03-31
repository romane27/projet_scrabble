package Vue;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Modele.Joueur;

public class Scores extends JPanel {

	public Scores(int i) {
		this.setBackground(Color.white);
		for (int j = 0; j < i; j++) {
			JLabel label = new JLabel();
			label.setText("Joueur " + (j + 1) + " : 0");
			label.setVisible(true);
			this.add(label);
		}
	}

	public void majscore(Joueur joueur) {
		JLabel label = (JLabel) this.getComponent(joueur.pos);
		label.setText("joueur " + joueur.pos + " : " + joueur.score);
	}
}
