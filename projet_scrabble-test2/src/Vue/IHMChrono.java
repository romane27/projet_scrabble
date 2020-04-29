package Vue;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class IHMChrono extends JPanel {
	private static final long serialVersionUID = 1L;
	public static Chrono chrono;
	public int duree_chrono;
	public IHMChrono(int duree) {
		duree_chrono = duree;
		chrono = new Chrono(this, duree, 680,60, 80);
		chrono.demarrer();
		setVisible(true);
	}
	public void paintComponent(Graphics g)  {
		super.paintComponent(g);
		chrono.dessine(g);
	}
}