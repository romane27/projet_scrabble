package Vue2;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
// initialise le choix du nombre de joueur par l'utilisateur avec une Jcombobox
public class nombre_joueur extends JComboBox implements ActionListener {
	public static int nbrjoueur = 0;
	public static ArrayList <String> nomjoueur = new ArrayList<>();
	public nombre_joueur() {

		this.addItem("Choix");
		this.addItem("1 joueur");
		this.addItem("2 joueurs");
		this.addItem("3 joueurs");
		this.addItem("4 joueurs");
		this.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object str = this.getSelectedItem();
		String o = "" + str;
		// on transforme la chaine de caracteres en int pour récuperer le nbr de joueurs
		char nbrj = o.charAt(0);
		String nb = Character.toString(nbrj);
		nbrjoueur = Integer.parseInt(nb);
		int j=1;
		for (int i=0 ; i<nbrjoueur;i++) {
			ImageIcon image = new ImageIcon("src/images/bonhomme1.png");
			String nom = JOptionPane.showInputDialog(null, "Entrez nom du joueur "+j+":", "Nom", JOptionPane.QUESTION_MESSAGE);

			if (nom.isEmpty()) {
				System.out.println("le nom llll" +nom);
				nomjoueur.add("Joueur "+j);
			}
			else {
				nomjoueur.add(nom);
			}

			j+=1;

		}
	}
}
