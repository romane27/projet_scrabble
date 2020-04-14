package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Modele.Joueur;
import Modele.Pioche;

public class Scores extends JPanel {
	int i;

	public Scores(int i) {
		this.i = i;
		this.setBackground(new Color (220,233,230));
		ImageIcon image = new ImageIcon("src/images/bonhomme1.png");
		ImageIcon image2 = new ImageIcon("src/images/bonhomme2.png");
		ImageIcon image3 = new ImageIcon("src/images/bonhomme3.png");
		ImageIcon image4 = new ImageIcon("src/images/bonhomme4.png");
		ImageIcon[] im = {image,image2,image3,image4};
		for (int j = 0; j < i; j++) {
			JButton b = new JButton();
			b.setIcon(im[j]);
			b.setPreferredSize(new Dimension(im[j].getIconHeight(),im[j].getIconWidth()));
			b.setToolTipText("nom du joueur");
			b.setLayout(new FlowLayout(FlowLayout.LEFT));
			JLabel label = new JLabel();
			label.setText("Joueur " + (j + 1) + " : 0                   "                               );
			label.setVisible(true);
			this.add(b);
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
