package Modele;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class Lettre implements Serializable {
	public String nom;
	public int valeur;
	public ImageIcon image;
	public ImageIcon image_gris;

	public Lettre(String s, int v, ImageIcon imagelettre, ImageIcon imagelettregris) {
		nom = s;
		valeur = v;
		image = imagelettre;
		image_gris = imagelettregris;
	}

}
