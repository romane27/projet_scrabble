package Vue2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class duree_tours implements ActionListener{
	public static int duree;
	JComboBox combo ;
	public duree_tours(JComboBox<Integer> combobo) {
		this.duree=60;
		this.combo=combobo;
		  //combo.setPreferredSize(new Dimension(100, 20));
		    combo.addItem(60);
		    combo.addItem(120);
		    combo.addItem(180);
		    combo.addItem(210);
		    combo.addActionListener(this);
	          
	  }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("ActionListener : action sur " + combo.getSelectedItem());
		 Object str = combo.getSelectedItem();
		 duree=(int) str;
		
		// affiche nombre de joueurs qui jouent
		System.out.println("le tours durera "+str+" secondes");
		// on transforme la chaine de caracteres en int pour récuperer le nbr de joueurs
		
		
		
	}
	     
	  }



