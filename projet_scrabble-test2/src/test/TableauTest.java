package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.swing.ImageIcon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Modele.Lettre;
import Modele.Tableau;
import javafx.util.Pair;

class TableauTest {

	public Tableau tab;
	
	@BeforeEach
	public void init() throws IOException{
		tab = new Tableau();
		tab.tableau[7][7].lettre = new Lettre("T", 1, new ImageIcon("src/images/T.jpg"), new ImageIcon("src/images/Tgris.jpg"));
		tab.tableau[7][7].jouee = true;
		tab.tableau[7][7].occupe = true;
		tab.tableau[7][8].lettre = new Lettre("E", 1, new ImageIcon("src/images/E.jpg"), new ImageIcon("src/images/Egris.jpg"));
		tab.tableau[7][8].jouee = true;
		tab.tableau[7][8].occupe = true;
		tab.tableau[7][9].lettre = new Lettre("S", 1, new ImageIcon("src/images/S.jpg"), new ImageIcon("src/images/Sgris.jpg"));
		tab.tableau[7][9].jouee = true;
		tab.tableau[7][9].occupe = true;
		tab.tableau[7][10].lettre = new Lettre("T", 1, new ImageIcon("src/images/T.jpg"), new ImageIcon("src/images/Tgris.jpg"));
		tab.tableau[7][10].jouee = true;
		tab.tableau[7][10].occupe = true;
	}
	
	@Test
	void testVerifPlacLettres() {
		assertTrue(tab.verifPlacLettres(4, 7, 7)); //nombre de lettres posées = 4
		assertFalse(tab.verifPlacLettres(5, 7, 7)); // nombre de lettres posées = 5
	}

	@Test
	void testComptescore() { //quand le mot est correct et les lettres bien placées
		Pair<Boolean, Integer[]> pair = tab.comptescore(4);
		int score = 0;
		Integer[] vp = pair.getValue();
		for (int i=0; i<vp.length; i++) {
			score += vp[i];
		}
		assertTrue(pair.getKey());
		assertEquals(4, score);
	}
	
	void test2Comptescore() { // quand les lettres ne sont pas correctement placées
		Pair<Boolean, Integer[]> pair = tab.comptescore(5);
		int score = 0;
		Integer[] vp = pair.getValue();
		assertFalse(pair.getKey());
		assertEquals(0, vp.length);
	}
	
	void test3Comptescore() { // quand les lettres sont bien placées mais que le mot n'existe pas
		tab.tableau[7][11].lettre = new Lettre("T", 1, new ImageIcon("src/images/T.jpg"), new ImageIcon("src/images/Tgris.jpg"));
		tab.tableau[7][11].jouee = true;
		tab.tableau[7][11].occupe = true;
		Pair<Boolean, Integer[]> pair = tab.comptescore(5);
		int score = 0;
		Integer[] vp = pair.getValue();
		assertFalse(pair.getKey());
	}

}
