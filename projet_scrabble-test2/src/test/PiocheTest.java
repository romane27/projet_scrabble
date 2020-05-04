package test;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.ImageIcon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Modele.Lettre;
import Modele.Pioche;

class PiocheTest {

	public Pioche p;
	public int nb_tirage;
	public Lettre lt = new Lettre("Z", 10, new ImageIcon("src/images/Z.jpg"), new ImageIcon("src/images/Zgris.jpg"));
	
	@BeforeEach
	public void init() {
		p = new Pioche();
		nb_tirage = 3;
	}
	
	@Test
	void testPiocherLettre() {
		int taille = p.pioche.size();
		for (int i=0; i<nb_tirage; i++) {
			p.piocherLettre();
		}
		assertEquals(taille-nb_tirage, p.pioche.size());
	}

	@Test
	void testRemettrepioche() {
		int taille = p.pioche.size();
		for (int i=0; i<nb_tirage; i++) {
			p.remettrepioche(lt);
		}
		assertEquals(taille+nb_tirage, p.pioche.size());
	}

}
