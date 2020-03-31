package Vue;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Modele.Joueur;
import Modele.Tableau;

public class Vue extends JFrame {
	public Clavier clavier;
	public Plateau plateau;
	public JButton fdt;
	public Scores score;

	public Vue(Tableau tableau, Joueur joueur, Joueur joueur2) {
		score = new Scores(4);
		score.setBounds(670, 150, 100, 100);
		score.setVisible(true);
		plateau = new Plateau(tableau);
		clavier = new Clavier(joueur);
		this.setLayout(null);
		plateau.setBounds(0, 0, 640, 640);
		clavier.setBounds((640 - (640 / 15) * 7) / 2, 640 + 10, 640 / 15 * 7,640 / 15);
		this.add(clavier);
		this.add(plateau);
		this.setSize(900, 900);
		this.setVisible(true);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.white);
		fdt = new JButton("Fin de Tour");
		fdt.setBounds(670, 600, 170, 30);
		this.add(fdt);
		this.add(score);
		this.setLocationRelativeTo(null);
	}

	public void ajoutactlist(ActionListener e) {
		fdt.addActionListener(e);
	}

}
