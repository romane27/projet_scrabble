package Vue;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class IHMChrono extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	//JButton demarrer = new JButton("demarrer");
	//JButton suspendre = new JButton("suspendre");
	//JButton reprendre = new JButton("reprendre");
	//JButton arreter = new JButton("arreter");
	public static Chrono chrono;
	public int duree_chrono;
	public IHMChrono(int duree) {
		//setPreferredSize(new Dimension(500,300));
		//setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		duree_chrono = duree;
		chrono = new Chrono(this, duree, 680, 50, 80);
		chrono.demarrer();
		//demarrer.addActionListener(this);
		//suspendre.addActionListener(this);
		//reprendre.addActionListener(this);
		//arreter.addActionListener(this);
		//add(demarrer);
		//add(suspendre);
		//add(reprendre);
		//add(arreter);
		setVisible(true);
	}
	public void reprendre(int duree) {
		chrono = (Chrono)new Chrono(this, duree, 680, 50, 80);
		chrono.demarrer();
		
	}
	
	public void redemarrer() {
		chrono = (Chrono)new Chrono(this, duree_chrono, 680, 50, 80);
		chrono.demarrer();
	}

	public void actionPerformed(ActionEvent evt) {
		/*Object source = evt.getSource();

		if (source == demarrer) chrono.demarrer();
		//else if  (source == suspendre) chrono.suspendre();
		//else if  (source == reprendre) chrono.reprendre();
		 if  (source == arreter) chrono.arreter();*/
	}


	public void paintComponent(Graphics g)  {
		super.paintComponent(g);
		chrono.dessine(g);
	}
}