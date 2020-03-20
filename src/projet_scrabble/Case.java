package projet_scrabble;

public class Case {
	int x; // position de la case dans la matrice 0<=x<15
	int y; // position de la case dans la matrice 0<=y<15
	boolean occupe; // si la case a une lettre
	boolean jouable; // si on peut poser une lettre dessus pdnt le tour
	Lettre lettre;
	int bonus;

	public Case() {
		this.x = 0;
		this.y = 0;
		this.occupe = false;
		this.jouable = true;
		this.lettre = new Lettre(null, 0);
		this.bonus = 0;

	}
	
	public void ajoutLettreCase(Lettre l) { // ajoute une lettre dans le tableau
		if (this.jouable && !this.occupe) {
			this.lettre = l;
			this.jouable = false;
			this.occupe = true;
		}
	}
	
	public Integer valeurCase() { // calcule la valeur d'une case
		return this.lettre.valeur *this.bonus;
	}
	
	public void supprimerLettreCase() { //supprimer une lettre d'une case si le joueur veut déplacer une lettre AVANT d'avoir validé le mot ou s'il n'est pas valide
		this.lettre = new Lettre(null, 0);
		this.jouable = true;
		this.occupe = false;
	}
}
