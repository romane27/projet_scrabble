package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

import Modele.Bouton;
import Modele.Joueur;

public class Clavier extends JPanel {
	static Joueur j;

	public Clavier(Joueur joueur) {
		this.j = joueur;
		this.setBackground(new Color(176, 198, 193));
		this.setLayout(new GridLayout(0, 7));
		for (int i = 0; i < joueur.size(); i++) {
			Bouton boutton = new Bouton();

			boutton.image = joueur.get(i).image;
			boutton.setIcon(boutton.image);
			boutton.lettre = joueur.get(i);
			boutton.setBackground(Color.white);
			boutton.place = i;
			this.add(boutton);
		}
	}

	public void ajoutactionlistner(int i, ActionListener l) { // crée un bouton pour chaque lettre du clavier du joueur
		Bouton btn = (Bouton) this.getComponent(i);
		btn.addActionListener(l);
	}
	// retourne une liste de nombre sans doublons = pour changer emplacement lettre

	public static int[] melangerlettre() { // mélange toutes les lettres du clavier
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < j.size(); i++) {
			list.add(i);

		}
		int[] emplacementlettre = new int[list.size()];

		Random random = new Random();
		int position = 0;

		while (list.size() > 0) {
			position = random.nextInt(list.size());
			emplacementlettre[list.size() - 1] = list.get(position);
			list.remove(position);
		}

		return emplacementlettre;
	}
}
