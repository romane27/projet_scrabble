package Vue2;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class nombre_joueur implements ActionListener {
	public static int nbrjoueur;
	JComboBox combo ;
	public nombre_joueur(JComboBox<String> combobo) {
		this.combo=combobo;
		  //combo.setPreferredSize(new Dimension(100, 20));
		    combo.addItem("1 joueur");
		    combo.addItem("2 joueurs");
		    combo.addItem("3 joueurs");
		    combo.addItem("4 joueurs");
		    combo.addActionListener(this);
	          
	  }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("ActionListener : action sur " + combo.getSelectedItem());
		Object str = combo.getSelectedItem();
		String o = ""+str;
		// affiche nombre de joueurs qui jouent
		System.out.println("Il y a "+o.charAt(0)+"joueur(s)");
		// on transforme la chaine de caracteres en int pour récuperer le nbr de joueurs
		char nbrj= o.charAt(0);
		String nb = Character.toString(nbrj);
		nbrjoueur= Integer.parseInt(nb);
		//System.out.println(nbrjoueur);
		
	}
	     
	  }

