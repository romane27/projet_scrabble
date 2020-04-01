package Modele;

public class Case {
	public boolean occupe; // si la case a une lettre
	public boolean jouable;
	public boolean jouee;// si on peut poser une lettre dessus pdnt le tour
	public Lettre lettre;
	public boolean verouillee;
	public int bonus;
	public int x;
	public int y;

	public Case() {
		x = 0;
		y = 0;
		occupe = false;
		jouable = false;
		jouee = false;
		lettre = null;
		bonus = 0;
		verouillee = false;

	}

	public void reset() {
		occupe = false;
		jouable = false;
		jouee = false;
		lettre = null;
		bonus = 0;
		verouillee = false;

	}
}
