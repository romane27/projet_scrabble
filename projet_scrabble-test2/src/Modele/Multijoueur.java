package Modele;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import Vue2.duree_tours;
import Vue2.nombre_joueur;

public class Multijoueur {
	public int ind_jr;
	public Joueur[] tab_joueurs;
	public int nbrjoueur = 0;
	public ArrayList<String> nomjoueur = new ArrayList<>();
	public int duree;
	File fichier = new File("Temp/tab_joueurs.dat");
	File fichierj = new File("Temp/ind_jr.dat");
	File fichiernbrj = new File("Temp/nbrjoueur.dat");
	File fichiernom = new File("Temp/nomjoueur.dat");
	File dureetour = new File("Temp/dureetour.dat");

	public Multijoueur(Pioche pioche) {
		try {

			FileInputStream fis = new FileInputStream(fichier);
			ObjectInputStream ois = new ObjectInputStream(fis);
			this.tab_joueurs = (Joueur[]) ois.readObject();
			ois.close();
			fis.close();
			FileInputStream fis1 = new FileInputStream(fichierj);
			ObjectInputStream ois1 = new ObjectInputStream(fis1);
			this.ind_jr = (int) ois1.readObject();
			ois1.close();
			fis1.close();
			FileInputStream fis3 = new FileInputStream(fichiernbrj);
			ObjectInputStream ois3 = new ObjectInputStream(fis3);
			this.nbrjoueur = (int) ois3.readObject();
			ois3.close();
			fis3.close();
			FileInputStream fis4 = new FileInputStream(fichiernom);
			ObjectInputStream ois4 = new ObjectInputStream(fis4);
			this.nomjoueur = (ArrayList<String>) ois4.readObject();
			ois4.close();
			fis4.close();
			FileInputStream fis5 = new FileInputStream(dureetour);
			ObjectInputStream ois5 = new ObjectInputStream(fis5);
			this.duree = (int) ois5.readObject();
			ois5.close();
			fis5.close();
		} catch (IOException | ClassNotFoundException e) {
			this.tab_joueurs = new Joueur[nombre_joueur.nbrjoueur];
			this.ind_jr = 0;
			nbrjoueur = nombre_joueur.nbrjoueur;
			nomjoueur = nombre_joueur.nomjoueur;
			duree = duree_tours.duree;
			for (int i = 0; i < nombre_joueur.nbrjoueur; i++) {
				tab_joueurs[i] = new Joueur(pioche);
				tab_joueurs[i].pos = i;

			}
		}
	}

	public Joueur joueur_act() { // récupère le joueur en train de jouer
		return this.tab_joueurs[this.ind_jr];
	}

	public void changer_joueur() { // passe au joueur suivant
		this.ind_jr = (this.ind_jr + 1) % nbrjoueur;

	}

	public int recupNbJ() { // renvoie le nombre total de joueur
		return nbrjoueur;
	}

	public void enregistrer() {
		try {
			FileOutputStream fos = new FileOutputStream(fichier);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this.tab_joueurs);
			oos.close();
			fos.close();
			FileOutputStream fos1 = new FileOutputStream(fichierj);
			ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
			oos1.writeObject(this.ind_jr);
			oos1.close();
			fos1.close();
			FileOutputStream fos3 = new FileOutputStream(fichiernom);
			ObjectOutputStream oos3 = new ObjectOutputStream(fos3);
			oos3.writeObject(this.nomjoueur);
			oos3.close();
			fos3.close();
			FileOutputStream fos4 = new FileOutputStream(fichiernbrj);
			ObjectOutputStream oos4 = new ObjectOutputStream(fos4);
			oos4.writeObject(this.nbrjoueur);
			oos4.close();
			fos4.close();
			FileOutputStream fos5 = new FileOutputStream(dureetour);
			ObjectOutputStream oos5 = new ObjectOutputStream(fos5);
			oos5.writeObject(this.duree);
			oos5.close();
			fos5.close();
		} catch (IOException e1) {
			throw new RuntimeException("Impossible d'ecrire les donnees");
		}
	}

}
