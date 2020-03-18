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
		this.jouable = false;
		this.lettre = new Lettre(null, 0);
		this.bonus = 0;

	}
}
