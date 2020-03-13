package projet_scrabble;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class plateau extends Canvas implements MouseListener{
	int[][] plateau;
	Color [] couleur  = {Color.red,Color.blue,Color.CYAN,Color.green,Color.pink}; 
	int taille=50;
	int espace = 40;
	String [] name;
	ArrayList<Integer> placement_bouton = new ArrayList<>();
	public plateau (String [] nom) {
		this.name=nom;
		plateau = new int [15][15];
		for (int i=0 ; i<14 ; i++) {

			for (int j=0; j<14; j++) {
				plateau[i][j]=0;
			}
		}
		//couleur rouge = 1
		// couleur bleu ==2
		// couleur cyan =3
		//couleur vert = 0
		// couleur rose =5
		plateau[0][0]=1;


		// carre haut gauche	
		for (int i=0 ; i<14 ; i++) {

			for (int j=0; j<14; j++) {
				// on remplie par carre de 7 par 7 car tout est symétrique
				// couleur bleu fonce 
				if (j==5 & i==1) {
					plateau [i][j]=2;
					plateau [j][i]=2;
					plateau [5][5]=2;
				}
				if (i==0 & j ==3) {
					plateau [i][j]=3;
					plateau [j][i]=3;
					plateau [6][6]=3;	
				}
				if (i==6 & j ==2) {
					plateau [i][j]=3;
					plateau [j][i]=3;

				}

				// couleur rose

				if (i<7 && j <7) {
					if (i==j & plateau[i][j]==0) {
						plateau[i][j]=5;
					}
				}
			}
		}
		// carre haut droit
		for (int i=0 ; i<7 ; i++) {

			for (int j=7; j<15; j++) {
				plateau[i][j]=plateau[i][7-(j-7)];
				if (j==7) {
					plateau[i][j]=plateau[i][0];
				}
			}

		}
		// carre bas gauche
		for (int i=7 ; i<15 ; i++) {

			for (int j=0; j<8; j++) {
				plateau[i][j]=plateau[7-(i-7)][j];
				if (i==7) {
					plateau[i][j]=plateau[0][j];
				}
			}

		}
		// carre bas droit
		for (int i=7 ; i<15 ; i++) {

			for (int j=7; j<15; j++) {
				plateau[i][j]=plateau[i][7-(j-7)];
				if (j==7) {
					plateau[i][j]=plateau[i][0];
				}
			}

		}
		plateau [7][7]=5;}
		// on affiche la matrice 		
		/*for (int i=0 ; i<15 ; i++) {

			for (int j=0; j<15; j++) {
				System.out.print(plateau[i][j] + " ");
			}
			System.out.println();
		}*/

	
	//couleur rouge = 1
	// couleur bleu ==2
	// couleur cyan =3
	//couleur vert = 4 
	// couleur rose =5
	public void paint(Graphics g) {
		this.addMouseListener(this);
		for (int i = 0; i < 15; i++) {
			for( int j = 0; j < 15; j++) {
				// couleur bleu
				if (plateau[i][j]==2) {
					g.setColor(new Color (13,52,225));
					g.fillRect(j*taille,i*taille,taille,taille);
				}
				// couleur rouge
				if (plateau[i][j]==1) {
					g.setColor(new Color (225,13,13));
					g.fillRect(j*taille,i*taille,taille,taille);

				}
				// couleur cyan
				if (plateau[i][j]==3) {
					g.setColor(new Color (31,174,238));
					g.fillRect(j*taille,i*taille,taille,taille);

				}
				// couleur beige
				if (plateau[i][j]==5) {
					g.setColor(new Color (230,216,171));
					g.fillRect(j*taille,i*taille,taille,taille);
					// couleur vert  
				}
				if (plateau[i][j]==0) {
					g.setColor(new Color(10,173,153));
					g.fillRect(j*taille,i*taille,taille,taille);

				}
				g.setColor(Color.white);
				g.drawRect(j*taille,i*taille,taille,taille);
			}
		}
		g.setColor(Color.BLACK);
		for (int i =1; i<8;i++) {
			Font fontEntered = new Font(Font.DIALOG, Font.PLAIN, 20);
			g.drawRect(i*taille, 800, taille,taille);
			g.setFont(fontEntered);
			g.drawString(name[i-1], i*taille+15, 830);
			
		}
		
	
		//System.out.println(g);
	}
	/*public void remplir_plateau(JButton bout, String name, int x , int y) {
		Graphics g1 = null;
		g1.setColor(Color.white);
		g1.fillRect(x*taille,y*taille,taille,taille);
		g1.setColor(Color.black);
		g1.drawString(name, x, y);
		
		
	}*/
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			Graphics g = getGraphics();
			g.setColor(Color.black);
			if (e.getY()<750 && e.getX()<=750) {
			
			double x = e.getX()/taille;
			
			double y = e.getY()/taille;
			
			
			
			g.fillRect((int)x*taille,(int)y*taille,taille,taille);
			}
			if (e.getY()<=850 && e.getY()>=800 && e.getX()<=400 && e.getX()>=50) {
				double x = e.getX()/taille;
				
				double y = e.getY()/taille;
				
				g.setColor(Color.cyan);
				g.fillRect((int)x*taille,(int)y*taille,taille,taille);
				for(int i=0;i<8;i++) {
					g.setColor(Color.BLACK);
					g.drawString(name[i-1], (i-1)*taille+15, 830);
					
				}
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

