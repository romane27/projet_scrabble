package Vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Modele.Joueur;
import Vue2.nombre_joueur;

public class Tour extends JPanel{
	// permet d'afficher qui est en train de jouer
	public Tour (int j ) {
		JLabel label1 = new JLabel();		
		label1.setText( "Actuellement, "+nombre_joueur.nomjoueur.get(j)+ " joue.");		
		label1.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 13));		
		this.add(label1);		
		this.setVisible(true);
	}



	public void majtour(int joueur) {
		Tour t = new Tour(joueur);
		JLabel label1;
		if (nombre_joueur.nbrjoueur==2) {
			if (joueur ==1) {

				label1 = (JLabel) this.getComponent(joueur-1);
			}
			else {

				label1 = (JLabel) this.getComponent(joueur);
			}
			label1.setText( "Actuellement, "+nombre_joueur.nomjoueur.get(joueur)+ " joue.");

		}
		if (nombre_joueur.nbrjoueur==3) {

			if (joueur ==1 ) {

				label1 = (JLabel) this.getComponent(joueur-1);
				label1.setText( "Actuellement, "+nombre_joueur.nomjoueur.get(joueur)+ " joue.");
			}
			else {

				label1 = (JLabel) this.getComponent(0);
				label1.setText( "Actuellement, "+nombre_joueur.nomjoueur.get(joueur)+ " joue.");
			}


		}
		if (nombre_joueur.nbrjoueur==4) {

			if (joueur ==1 ) {

				label1 = (JLabel) this.getComponent(joueur-1);
				label1.setText( "Actuellement, "+nombre_joueur.nomjoueur.get(joueur)+ " joue.");
			}
			if (joueur ==2 ) {

				label1 = (JLabel) this.getComponent(joueur-2);
				label1.setText( "Actuellement, "+nombre_joueur.nomjoueur.get(joueur)+ " joue.");
			}
			else {

				label1 = (JLabel) this.getComponent(0);
				label1.setText( "Actuellement, "+nombre_joueur.nomjoueur.get(joueur)+ " joue.");

			}


		}




	}


}
