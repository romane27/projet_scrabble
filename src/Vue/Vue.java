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
		score.setBounds(820, 150, 100, 100);
		score.setVisible(true);
		plateau = new Plateau(tableau);
		clavier = new Clavier(joueur);
		this.setLayout(null);
		plateau.setBounds(0, 0, 800, 800);
		clavier.setBounds((800 - (800 / 15) * 7) / 2, 800 + 10, 800 / 15 * 7, 800 / 15);
		this.add(clavier);
		this.add(plateau);
		this.setSize(1000, 1000);
		this.setVisible(true);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.white);
		fdt = new JButton("Fin de Tour");
		fdt.setBounds(805, 760, 170, 30);
		this.add(fdt);
		this.add(score);
		this.setLocationRelativeTo(null);
	}

	public void ajoutactlist(ActionListener e) {
		fdt.addActionListener(e);
	}

}
