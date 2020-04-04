package Modele;

import javax.swing.ImageIcon;

public class Lettre {
	public String nom;
	int valeur;
	public ImageIcon image;
	public ImageIcon image_gris;
	public Lettre(String s, int v, ImageIcon imagelettre, ImageIcon imagelettregris) {
		nom = s;
		valeur = v;
		image = imagelettre;
		image_gris=imagelettregris;
	}

}
