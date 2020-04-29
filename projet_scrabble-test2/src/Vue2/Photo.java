package Vue2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
// ajoute une photo 
public class Photo extends Canvas{
	Image img = null;
	public int posx,posy, hauteur, largeur;
	public Photo (String fichierimage,int x , int y,int haut,int larg) {
		this.posx=x;
		this.posy=y;
		this.hauteur=haut;
		this.largeur =larg;
		img=getToolkit().getImage(fichierimage);
	}
	public void paint (Graphics g) {
		if (img == null) {
			super.paint(g);
			g.setColor(Color.BLACK);
		}
		else {
			g.drawImage(img,posx,posy,this.hauteur, this.largeur,this);

		}
	}

}