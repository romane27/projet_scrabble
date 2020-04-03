package Vue2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;

public class photo extends Canvas{
	Image img = null;
	int ok;
	public photo (String fichierimage) {
		img=getToolkit().getImage(fichierimage);
	}
	public void paint (Graphics g) {
		if (img == null) {
			super.paint(g);
			g.setColor(Color.BLACK);
		}
		else {
			g.drawImage(img,0,0,800,800,this);
			
			}
	}

}
