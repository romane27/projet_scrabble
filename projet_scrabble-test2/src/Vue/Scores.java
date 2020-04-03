package Vue;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Modele.Joueur;
import Modele.Pioche;

public class Scores extends JPanel {
	int i;

	public Scores(int i) {
		this.i = i;
		this.setBackground(Color.white);
		for (int j = 0; j < i; j++) {
			JLabel label = new JLabel();
			label.setText("Joueur " + (j + 1) + " : 0");
			label.setVisible(true);
			this.add(label);
		}
		JLabel label = new JLabel();
		label.setText("Lettres restantes : " + (102 - 7 * this.i));
		this.add(label);
	}

	public void majscore(Joueur joueur, Pioche pioche) {
		JLabel label = (JLabel) this.getComponent(joueur.pos);
		label.setText("Joueur " + (joueur.pos + 1) + " : " + joueur.score);
		label = (JLabel) this.getComponent(4);
		label.setText("Lettres restantes : " + pioche.size());
	}
}
