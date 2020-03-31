package Vue;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Modele.Bouton;
import Modele.Tableau;
import javafx.scene.shape.Rectangle;

import java.awt.Color;

public class Plateau extends JPanel {

	public Plateau(Tableau plateau) {
		this.setLayout(new GridLayout(15, 15));
		for (int i = 0; i < 15; i++) {
			for (int j = 1; j < 16; j++) {
				// couleur bleu
				if (plateau.tableau[i][j - 1].bonus == 2) {
					Bouton bouton = new Bouton();
					bouton.setText("LT");
					bouton.setBackground(Color.getHSBColor(0, 128, 255));
					bouton.caseass = plateau.tableau[i][j - 1];
					this.add(bouton);
				}
				// milieu
				if (plateau.tableau[i][j - 1].bonus == 6) {
					Bouton bouton = new Bouton();
					bouton.setBackground(Color.pink);
					bouton.caseass = plateau.tableau[i][j - 1];
					this.add(bouton);
				}

				// couleur rouge
				if (plateau.tableau[i][j - 1].bonus == 1) {
					Bouton bouton = new Bouton();
					bouton.setText("MT");
					bouton.setBackground(Color.red);
					bouton.caseass = plateau.tableau[i][j - 1];
					this.add(bouton);
				}
				// couleur cyan
				if (plateau.tableau[i][j - 1].bonus == 3) {
					Bouton bouton = new Bouton();
					bouton.setText("LD");
					bouton.setBackground(Color.cyan);
					bouton.caseass = plateau.tableau[i][j - 1];
					this.add(bouton);
				}
				// couleur beige
				if (plateau.tableau[i][j - 1].bonus == 5) {
					Bouton bouton = new Bouton();
					bouton.setText("MD");
					bouton.setBackground(Color.pink);
					bouton.caseass = plateau.tableau[i][j - 1];
					this.add(bouton);
					// couleur vert
				}
				if (plateau.tableau[i][j - 1].bonus == 0) {
					Bouton bouton = new Bouton();
					bouton.setBackground(Color.green);
					bouton.caseass = plateau.tableau[i][j - 1];
					this.add(bouton);

				}
			}

		}
		this.setVisible(true);
	}

	public void ajoutactionlistner(int k, ActionListener l) {
		JButton btn = (Bouton) this.getComponent(k);
		btn.addActionListener(l);
	}
}