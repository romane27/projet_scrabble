package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Modele.Joueur;
import Modele.Pioche;
import Modele.Lettre;

class JoueurTest {
	public Pioche p = new Pioche();
	public Joueur j1;
	ArrayList<Lettre> l = new ArrayList<Lettre>();
	ArrayList<Integer> li = new ArrayList<Integer>();
	
	@BeforeEach
	public void init() {
		j1 = new Joueur(p);
		li.add(0);
		li.add(2);
	}
	
	@Test
	void testTirage() {
		j1.remove(j1.get(3));
		j1.remove(j1.get(0));
		j1.tirage(p);
		assertEquals(j1.size(), 7);
	}

	@Test
	void testInitTirage() {
		j1.initTirage(p);
		assertEquals(j1.size(), 7);
	}

	@Test
	void testReset() {
		Joueur temp = j1;
		Lettre l1 = j1.get(6);
		Lettre l2 = j1.get(0);
		l.add(l1);
		l.add(l2);
		j1.remove(l1);
		j1.remove(l2);
		j1.reset(l);
		assertEquals(temp, j1);
	}

	@Test
	void testEchange() {
		j1.echange(li);
		assertEquals(5, j1.size());
	}

}
