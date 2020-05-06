package Vue;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.Observable;

import javax.swing.JComponent;

public class Chrono extends Observable implements Runnable {
	private int x, y, diametre;
	private JComponent proprietaire;
	private Thread deroulement;
	private long tempsEcoule = 0; // exprime en millisecondes
	private long duree; // nombre de millisecondes pour un tour complet
	private long momentDebut = 0;

	private boolean continuer;
	private boolean finir;

	public Chrono(JComponent proprietaire, int duree, int x, int y, int diametre) {
		this.duree = duree * 1000;
		this.x = x;
		this.y = y;
		this.diametre = diametre;
		this.proprietaire = proprietaire;

	}

	/* Demarre le chronometre */
	public void demarrer()  {   
		tempsEcoule = 0; 
		deroulement = new Thread(this);
		deroulement.start();
	}

	/* Arrete le chronometre. Une fois arrete, le chronometre ne peut
	    repartir qu'avec la methode demarrer, au debut du décompte du temps*/
	public synchronized void arreter() {
		if (enFonctionnement()) {
			finir = true;
			notifyAll();
		}
	}

	/* Fait tourner le chronometre */
	public void run() {
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		continuer = true;
		finir = false;
		momentDebut = System.currentTimeMillis();
		while((tempsEcoule < duree) && (!finir))

		{
			tempsEcoule = System.currentTimeMillis() - 
					momentDebut;
			proprietaire.repaint(new Rectangle(x, y, diametre, diametre));
			try {
				Thread.sleep(200);
				synchronized(this) {
					while (!continuer && !finir) wait();
				}

			}
			catch(InterruptedException e){
				e.printStackTrace();

			}

		}

		finir=true;
		// quand le chrono est fini on utilise modele observeur observable pour le dire a l utilisateur 
		if (tempsEcoule >= duree) {
			this.setChanged();
			this.notifyObservers(finir);
		}
	}

	/* Retourne true si le chronometre est en fonctionnement,  eventuellement suspendu 
	 * et false si le chronometre n'est pas demarre, ou bien a ete arrete, ou bien a fini de tourner*/
	public boolean enFonctionnement() {
		return (deroulement!=null) && (deroulement.isAlive());
	}

	/* Dessine le chronometre selon le temps pendant lequel il a tourne  depuis qu'il a ete mis en fonctionnement */
	public void dessine(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.black);
		g2.setStroke(new BasicStroke(5,
				BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
		g2.drawOval(x, y, diametre+10, diametre+10);
		g.fillRect(x+diametre/2-3, y-10, 20, 10);
		g.setColor(Color.blue);
		g.fillOval(x+42, y+5, 5, 5);
		g.fillOval(x+40+diametre/2, y+5+diametre/2, 5, 5);
		g.fillOval(x+44-diametre/2, y+5+diametre/2, 5, 5);
		g.fillOval(x+42, y+2+diametre, 5, 5);
		g.setColor(Color.green);
		g.fillArc(x+10, y+10, diametre-10, diametre-10, 90,
				(int)(360 - tempsEcoule * 360 / duree));
	}
}

