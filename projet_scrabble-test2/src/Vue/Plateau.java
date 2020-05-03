package Vue;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Modele.Bouton;
import Modele.Tableau;
import javafx.scene.shape.Rectangle;
import javafx.util.Pair;

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
					bouton.image = new ImageIcon("src/images/LT.jpg");
					bouton.setIcon(bouton.image);
					bouton.caseass = plateau.tableau[i][j - 1];
					this.add(bouton);
				}
				// milieu
				if (plateau.tableau[i][j - 1].bonus == 6) {
					Bouton bouton = new Bouton();
					bouton.image=new ImageIcon("src/images/MILIEU.jpg");
					bouton.setIcon(bouton.image);
					bouton.caseass = plateau.tableau[i][j - 1];
					this.add(bouton);
				}

				// couleur rouge
				if (plateau.tableau[i][j - 1].bonus == 1) {
					Bouton bouton = new Bouton();
					bouton.image=new ImageIcon("src/images/MT.jpg");
					bouton.setIcon(bouton.image);
					bouton.caseass = plateau.tableau[i][j - 1];
					this.add(bouton);
				}
				// couleur cyan
				if (plateau.tableau[i][j - 1].bonus == 3) {
					Bouton bouton = new Bouton();
					bouton.image=new ImageIcon("src/images/LD.jpg");
					bouton.setIcon(bouton.image);
					bouton.caseass = plateau.tableau[i][j - 1];
					this.add(bouton);
				}
				// couleur beige
				if (plateau.tableau[i][j - 1].bonus == 5) {
					Bouton bouton = new Bouton();
					bouton.image=new ImageIcon("src/images/MD.jpg");
					bouton.setIcon(bouton.image);

					bouton.caseass = plateau.tableau[i][j - 1];
					this.add(bouton);
					// couleur vert
				}
				if (plateau.tableau[i][j - 1].bonus == 0) {
					Bouton bouton = new Bouton();
					bouton.image=new ImageIcon("src/images/VERT.jpg");
					bouton.setIcon(bouton.image);

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

	public void resetplateau(ArrayList<Pair> listecasejouee) { // redessine le plateau
		for (int k = 0; k < listecasejouee.size(); k++) {
			int i = (int) listecasejouee.get(k).getKey();
			int j = (int) listecasejouee.get(k).getValue();

			Bouton bouton = (Bouton) this
					.getComponent((int) listecasejouee.get(k).getKey() * 15 + (int) listecasejouee.get(k).getValue());

			if (tableau.tableau[i][j].bonus == 2) {
				bouton.setText("");
				bouton.image = new ImageIcon("src/images/LT.jpg");
				bouton.setIcon(bouton.image);
				bouton.caseass = tableau.tableau[i][j];
			}
			// milieu
			if (tableau.tableau[i][j].bonus == 6) {
				bouton.setText("");
				bouton.image=new ImageIcon("src/images/MILIEU.jpg");
				bouton.setIcon(bouton.image);
				bouton.caseass = tableau.tableau[i][j];
			}

			// couleur rouge
			if (tableau.tableau[i][j].bonus == 1) {
				bouton.setText("");
				bouton.image=new ImageIcon("src/images/MT.jpg");
				bouton.setIcon(bouton.image);
				bouton.caseass = tableau.tableau[i][j];
			}
			// couleur cyan
			if (tableau.tableau[i][j].bonus == 3) {
				bouton.setText("");
				bouton.image=new ImageIcon("src/images/LD.jpg");
				bouton.setIcon(bouton.image);
				bouton.caseass = tableau.tableau[i][j];
			}
			// couleur beige
			if (tableau.tableau[i][j].bonus == 5) {
				bouton.setText("");
				bouton.image=new ImageIcon("src/images/MD.jpg");
				bouton.setIcon(bouton.image);
				bouton.caseass = tableau.tableau[i][j];
				// couleur vert
			}
			if (tableau.tableau[i][j].bonus == 0) {
				bouton.setText("");
				bouton.image=new ImageIcon("src/images/VERT.jpg");
				bouton.setIcon(bouton.image);
				bouton.caseass = tableau.tableau[i][j];

			}
		}
	}
}