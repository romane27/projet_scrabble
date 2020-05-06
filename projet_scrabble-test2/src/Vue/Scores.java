package Vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Modele.Joueur;
import Modele.Multijoueur;
import Modele.Pioche;

public class Scores extends JPanel {
	int i;
	Pioche p;

	public Scores(int i, Joueur jou, Multijoueur multi, Pioche p) {
		this.p = p;
		this.i = i;

		this.setBackground(new Color(220, 233, 230));
		ImageIcon image = new ImageIcon("src/images/bonhomme1.png");
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		for (int j = 0; j < i; j++) {
			JLabel label = new JLabel();
			label.setText(multi.nomjoueur.get(j) + " : " + multi.tab_joueurs[j].score);
			label.setHorizontalTextPosition(SwingConstants.CENTER);
			label.setAlignmentX(Component.CENTER_ALIGNMENT);
			label.setVisible(true);
			this.add(label);
		}
		JLabel label = new JLabel();
		label.setText("Lettres restantes : " + p.pioche.size());
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(label);
	}

	public void majscore(Joueur joueur, Pioche pioche, Multijoueur multi) { // met à jour le score de chaque joueur et
																			// le nombre de lettres
		// de la pioche
		this.p = p;
		JLabel label = (JLabel) this.getComponent(joueur.pos);
		label.setText(multi.nomjoueur.get(joueur.pos) + " : " + joueur.score);
		label = (JLabel) this.getComponent(i);
		label.setText("Lettres restantes : " + pioche.pioche.size());
	}
}
