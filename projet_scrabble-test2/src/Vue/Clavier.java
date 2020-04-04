package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Modele.Bouton;
import Modele.Joueur;

public class Clavier extends JPanel {
	public Clavier(Joueur joueur) {
		this.setLayout(new GridLayout(0, 7));
		for (int i = 0; i < 7; i++) {
			Bouton boutton = new Bouton();
			boutton.setText(joueur.get(i).nom);
			boutton.lettre = joueur.get(i);
			boutton.setBackground(Color.white);
			boutton.place = i;
			this.add(boutton);
		}
	}

	public void ajoutactionlistner(int i, ActionListener l) {
		Bouton btn = (Bouton) this.getComponent(i);
		btn.addActionListener(l);
	}
}