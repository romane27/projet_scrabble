package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Modele.Dico;

class DicoTest {
	private static Dico d;

	@BeforeEach
	public void init() throws IOException {
		d = new Dico();
	}
	

	@Test
	void testVerifier_mot() {
		//System.out.println(d);
		//System.out.println("cdsfsf");
		assertFalse(d.verifier_mot("dsqfdfsf"));
		assertFalse(d.verifier_mot("a"));
		assertTrue(d.verifier_mot(""));
		assertTrue(d.verifier_mot("abaissa"));
	}

}
