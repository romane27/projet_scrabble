package Modele;

import javax.swing.JButton;

public class Bouton extends JButton {
	public Boolean clique;
	public Lettre lettre;
	public Case caseass;// case associée
	public Bouton boutonass;
	public Boolean verrouille;

	public Bouton() {
		clique = false;
		lettre = new Lettre(null, 0);
		caseass = new Case();
		boutonass = null;
		verrouille=false;
	}

	public boolean isclicked() {
		return clique;
	}

	public void setclique(boolean bool) {
		clique = bool;
	}

	public void associe(Bouton bouton) {
		boutonass = bouton;
		bouton.boutonass = this;
		lettre=bouton.boutonass.lettre;  

	}

}
