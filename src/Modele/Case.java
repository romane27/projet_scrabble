package Modele;

public class Case {
	public boolean occupe; // si la case a une lettre
	public boolean jouable;
	public boolean jouee;// si on peut poser une lettre dessus pdnt le tour
	public Lettre lettre;
	public int bonus;

	public Case() {
		occupe = false;
		jouable = false;
		jouee = false;
		lettre = null;
		bonus = 0;

	}
}
