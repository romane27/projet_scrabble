package Vue;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import Modele.Bouton;
import Modele.Tableau;
import javafx.scene.shape.Rectangle;

import java.awt.Color;

public class Plateau extends JPanel {
	Tableau tableau;

	public Plateau(Tableau plateau) {
		tableau = plateau;
		this.setLayout(new GridLayout(15, 15));
		for (int i = 0; i < 15; i++) {
			for (int j = 1; j < 16; j++) {
				// couleur bleu
				if (plateau.tableau[i][j - 1].bonus == 2) {
					Bouton bouton = new Bouton();
					bouton.setText("LD");
					// test mais lettre ecrit trop petit ...
					Font f=bouton.getFont().deriveFont(5.0f);
					bouton.setFont(f);
					bouton.setBackground(new Color (42, 125, 210 ));
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
					bouton.setBackground(new Color (240,175,234));
					bouton.caseass = plateau.tableau[i][j - 1];
					this.add(bouton);
					// couleur vert
				}
				if (plateau.tableau[i][j - 1].bonus == 0) {
					Bouton bouton = new Bouton();
					bouton.setBackground(new Color(13,173,31));
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

	public void resetplateau(ArrayList<Integer> listecasejouee) {
		for (int k = 0; k < listecasejouee.size(); k++) {
			int i = listecasejouee.get(k) / 15;
			int j = listecasejouee.get(k) % 15;

			Bouton bouton = (Bouton) this.getComponent(listecasejouee.get(k));
			// bouton.setBackground(Color.orange);
			System.out.println(bouton.getBackground());
			if (tableau.tableau[i][j].bonus == 2) {
				bouton.setText("");
				bouton.setBackground(Color.getHSBColor(0, 128, 255));
				bouton.caseass = tableau.tableau[i][j];
			}
			// milieu
			if (tableau.tableau[i][j].bonus == 6) {
				bouton.setText("");
				bouton.setBackground(Color.pink);
				bouton.caseass = tableau.tableau[i][j];
			}

			// couleur rouge
			if (tableau.tableau[i][j].bonus == 1) {
				bouton.setText("");
				bouton.setBackground(Color.red);
				bouton.caseass = tableau.tableau[i][j];
			}
			// couleur cyan
			if (tableau.tableau[i][j].bonus == 3) {
				bouton.setText("");
				bouton.setBackground(Color.cyan);
				bouton.caseass = tableau.tableau[i][j];
			}
			// couleur beige
			if (tableau.tableau[i][j].bonus == 5) {
				bouton.setText("");
				bouton.setBackground(Color.pink);
				bouton.caseass = tableau.tableau[i][j];
				// couleur vert
			}
			if (tableau.tableau[i][j].bonus == 0) {
				bouton.setText("");
				bouton.setBackground(Color.green);
				bouton.caseass = tableau.tableau[i][j];

			}
		}
	}
}