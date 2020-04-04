package Modele;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Bouton extends JButton implements MouseListener {
	public Boolean clique;
	public Lettre lettre;
	public Case caseass;// case associée
	public Bouton boutonass;
	public Boolean verrouille;
	public int place;
	public ImageIcon image;
	public ImageIcon imagegris;
	public Bouton() {
		clique = false;
		image=null;
		imagegris=null;
		lettre = new Lettre(null, 0,image,imagegris);
		caseass = new Case();
		boutonass = null;
		verrouille = false;
		addMouseListener(this);
		place=0;
	}

	public boolean isclicked() {
		return clique;
	}

	public void associe(Bouton bouton) {
		boutonass = bouton;
		bouton.boutonass = this;
		lettre = bouton.boutonass.lettre;

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		clique = !clique;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
