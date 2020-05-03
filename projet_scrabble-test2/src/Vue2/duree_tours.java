package Vue2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class duree_tours extends JComboBox<Integer> implements ActionListener {
	public static int duree;

	public duree_tours() {
		// la durée par défaut
		duree = 60;
		this.addItem(60);
		this.addItem(120);
		this.addItem(180);
		this.addItem(210);
		this.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("ActionListener : action sur " + this.getSelectedItem());
		Object str = this.getSelectedItem();
		duree = (int) str;

		// affiche nombre de joueurs qui jouent
		System.out.println("le tour durera " + str + " secondes");
		// on transforme la chaine de caracteres en int pour récuperer le nbr de joueurs

	}

}
