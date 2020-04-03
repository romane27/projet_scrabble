package Vue2;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;

import Controleur.Controleur;
import Modele.Joueur;
import Modele.Tableau;
import Vue.Vue;

public class Boutonexec extends JButton implements MouseListener {
	String name;
	Controleur c;
	
	public Boutonexec (String str) {
		super (str);
		this.name=str;
		this.addMouseListener(this);
		
	}
	public void paintComponent(Graphics g){
	    Graphics2D g2d = (Graphics2D)g;
	    GradientPaint gp = new GradientPaint(0, 0, Color.blue, 0, 40, Color.cyan, true);
	    g2d.setPaint(gp);
	    g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
	    g2d.setColor(Color.white);
	    g2d.drawString(this.name, this.getWidth() / 2 - (this.getWidth()/ 2 /4), (this.getHeight() / 2) + 5);
	  }
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("bbb");
		try {
			c= new Controleur();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}