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
import Modele.Pioche;
import Vue2.nombre_joueur;

public class Scores extends JPanel {
	int i;
	Pioche p = new Pioche();
	public Scores(int i, Joueur jou) {
		this.i = i;
		
		this.setBackground(new Color (220,233,230));
		ImageIcon image = new ImageIcon("src/images/bonhomme1.png");
		ImageIcon image2 = new ImageIcon("src/images/bonhomme2.png");
		ImageIcon image3 = new ImageIcon("src/images/bonhomme3.png");
		ImageIcon image4 = new ImageIcon("src/images/bonhomme4.png");
		ImageIcon[] im = {image,image2,image3,image4};
		/*for (int k=0;k<4;k++) {
			JButton b = new JButton();
			b.setIcon(im[k]);
			b.setPreferredSize(new Dimension(im[k].getIconHeight(),im[k].getIconWidth()));
			b.setToolTipText("nom du joueur");
			b.setLayout(new FlowLayout(FlowLayout.LEFT));
			this.add(b);
		}*/
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		for (int j = 0; j < i ;j++) {
			/*JButton b = new JButton();
			b.setIcon(im[j]);
			b.setPreferredSize(new Dimension(im[j].getIconHeight(),im[j].getIconWidth()));
			b.setToolTipText("nom du joueur");
			b.setLayout(new FlowLayout(FlowLayout.LEFT));*/
			JLabel label = new JLabel();
			label.setText(nombre_joueur.nomjoueur.get(j) + " : 0");
			label.setHorizontalTextPosition(SwingConstants.CENTER);
			label.setAlignmentX(Component.CENTER_ALIGNMENT);
			label.setVisible(true);
			this.add(label);
		}
		JLabel label = new JLabel();
		label.setText("Lettres restantes : " + ((p.size() - jou.size() * this.i)));
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(label);
	}

	public void majscore(Joueur joueur, Pioche pioche) {
		JLabel label = (JLabel) this.getComponent(joueur.pos);
		//JButton b = (JButton) this.getComponent(4);
		
		label.setText(nombre_joueur.nomjoueur.get(joueur.pos)  + " : " + joueur.score);
		label = (JLabel) this.getComponent(i);
		label.setText("Lettres restantes : " + pioche.size());
	}
}
