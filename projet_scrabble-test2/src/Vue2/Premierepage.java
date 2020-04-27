package Vue2;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controleur.Controleur;
import Vue.IHMChrono;
import Vue2.Photo;

public class Premierepage extends Frame implements WindowListener, ActionListener {

	Boutonexec bouton_executer;
	nombre_joueur nbrjoueur;
	duree_tours combo_duree;
	duree_tours dureetour;

	public Premierepage() {
		// titre avec taille, police, positionnement
		Font fonte, font;
		this.setSize(670, 670);
		Photo image = new Photo("src/images/image.jpg",0,0,this.getWidth(),this.getHeight());
		

		fonte = new Font("Brush Script MT", Font.BOLD, 45);
		font = new Font("Helvetica", Font.CENTER_BASELINE, 15);
		JLabel titre = new JLabel("Bienvenue dans le jeu du Scrabble \n");

		titre.setHorizontalAlignment(JLabel.CENTER);
		titre.setFont(fonte);
		titre.setForeground(new Color(210, 42, 42));

		this.add(titre, BorderLayout.NORTH);
		JLabel titre2 = new JLabel(" Nombre de joueurs :");
		JLabel titre3 = new JLabel(" Dur�e de jeu par tours :");

		bouton_executer = new Boutonexec("Nouvelle partie");
		bouton_executer.addActionListener(this);
		nbrjoueur = new nombre_joueur();
		dureetour = new duree_tours();
		JLabel b = new JLabel("                                                  R�gle du jeu              ");
		JLabel l = new JLabel("<html>  D�roulement d'une partie :  <br><br> - Le joueur 1 commence la partie 7 lettres au hasard lui sont attribu� <br>  - Chaque joueur � un certain temps pour jouer temps choisit maintenant <br> - Pour d�placer les lettres : on clic sur la lettre puis sur l'endroit du plateau <br> - Vous avez la possibilit� de v�rifier votre mot avec le bouton 'verifier mot' avant de changer de joueur <br> - attention une fois appuyer sur 'fin de tour' on passe directement au joueur suivant <br> - Si aucun joueur ne peux continuer appuyer sur Arr�ter la partie <br> Bonne partie </html>");
		//p.add(b,l);
		b.setFont(font);
		b.setBackground(new Color(173, 239, 200));
		l.setBackground(new Color(173, 239, 200));
		l.setOpaque(true);
		b.setOpaque(true);
		
		b.setBounds(100, 300, 500,30);
		
		l.setBounds(100, 330, 500,200);
		
		//p.add(ascenseur);
		//l.setText();
		//l.setSize(200, 300);;
		this.add(b);
		
		this.add(l);
		this.add(bouton_executer, BorderLayout.SOUTH);
		this.add(titre2);
		this.add(titre3);
		titre2.setFont(font);
		titre3.setFont(font);
		// titre2.setBackground(Color.yellow);
		titre2.setBounds(100, 155, 150, 40);
		titre3.setBounds(100, 200, 200, 40);
		// this.setBackground(new Color (119, 210, 132));
		// ajout menu deroulant
		nbrjoueur.setBounds(360, 160, 100, 30);
		dureetour.setBounds(360, 200, 100, 30);
		this.add(dureetour);
		this.add(nbrjoueur);
		this.add(image);

		// ajout d'un bouton

		// this.setBackground(new Color(0,153,0));
		this.setTitle("Jeu du Scrabble");
		Image icone = Toolkit.getDefaultToolkit().getImage("src/images/S.jpg"); 
		// this.pack();
		this.setIconImage(icone);

		this.setLocationRelativeTo(null);
		this.addWindowListener(this);
		this.setVisible(true);
	}
	/*
	 * public void paint(Graphics g) {
	 * 
	 * g.setColor(Color.BLUE); //g.drawRect(10,20,this.getHeight(),120);
	 * g.fillRect(0, 0, this.getWidth(), 80);
	 * 
	 * }
	 */

	/*
	 * class rectangle extends Canvas{ private void rpaint(Graphics g) { // TODO
	 * Auto-generated method stub g.drawRect(0, 10, this.getWidth(),
	 * this.getHeight()); g.setColor(new Color(0,153,0)); } }
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Premierepage();
	}

	/*
	 * @Override public void itemStateChanged(ItemEvent e) { // TODO Auto-generated
	 * method stub System.out.println("j'�coute"); //this.setVisible(false); }
	 */
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("j'�coute");
		//this.setVisible(false);
	}

}
