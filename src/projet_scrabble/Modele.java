package projet_scrabble;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

import javafx.scene.control.Button;

public class Modele extends Observable {
	
	String [][] matrice;
	ArrayList <String> listlettre;
	
	Dico dico;
	//Lettre l = new Lettre("A", 2);
	Lettre_g en_cours;
	//int val_EC;
	ArrayList<Lettre_g> manche;
	
	public Modele() {
		this.matrice = new String[15][15];
		try {
			this.dico = new Dico();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.en_cours = null;
		//this.val_EC = 0;
		this.manche = new ArrayList<Lettre_g>();			

		
	}
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/
	
	public void modifL_EC(Lettre_g l) {
		this.en_cours = l;

		System.out.println(this.en_cours.lettre);
	}
	
	public Lettre_g ajouterLettre(int posX, int posY) {
		if (this.en_cours != null) {
			this.matrice[posY][posX-1]=this.en_cours.lettre;
			afficherMat();
			this.en_cours.setPosition(posX, posY);
			if (this.manche.contains(this.en_cours)){
				System.out.println("redéplacement");
				verif_maj(this.en_cours);
			}
			else {
			this.manche.add(this.en_cours);
			}
			System.out.println("lll"+this.manche.get(this.manche.size()-1).lettre);
			System.out.println("lll"+this.manche.get(this.manche.size()-1).positionX/42);
		}
		return this.en_cours;
	}
	
	public void verif_maj(Lettre_g l) {
		for (Lettre_g ll : this.manche) {
			if (l.equals(ll)) {
				ll.positionX = l.positionX;
				ll.positionY = l.positionY;
			}
		}
	}
	
	
	public void rmL_EC() {
		this.en_cours = null;
	}
	
	public boolean CaseLibre(int posX, int posY) {
		System.out.println("La case cliquée a pour valeur :" + this.matrice[posY][posX-1]);
		return (this.matrice[posY][posX-1] == null);
	}
	
	public void supprimerElem(int posX, int posY) {
		this.matrice[posY][posX-1] = null;
		afficherMat();
	}
	
	public void afficherMat() {
		for (int i = 0; i < 15; i++) { // initialisation du tableau
			for (int j = 0; j < 15; j++) {
				System.out.print(matrice[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/*public Lettre_g ajoutBouton(double x, double y) {
		String l= this.en_cours;
	
		System.out.println(l);
		System.out.println(y);
		int taille=42;
		System.out.println((int)(x/50)*50);
		System.out.println((int)(y/50)*50);
		
		Lettre_g lll =new Lettre_g(this.c, this.m, l, 2, (int)(x/taille)*taille, (int)(y/taille)*taille,taille);
		//lll.getChildren().add();
		//this.getChildren().add(le);
		this.m.ajouterLettre((int)(x/taille),(int)(y/taille));
		System.out.println("la lelele"+lll.lettre);
		return lll;
		
	}*/

}
