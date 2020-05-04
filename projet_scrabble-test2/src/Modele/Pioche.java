package Modele;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import javafx.application.Application;

public class Pioche {
	File fichier = new File("Temp/pioche.dat");
	public ArrayList<Lettre> pioche;

	public Pioche() {

		try {
			FileInputStream fis = new FileInputStream(fichier);
			ObjectInputStream ois = new ObjectInputStream(fis);
			this.pioche = (ArrayList<Lettre>) ois.readObject();
			ois.close();
			fis.close();

		} catch (IOException | ClassNotFoundException e) {
			this.pioche = new ArrayList<Lettre>();
			for (int i = 0; i < 15; i++) {
				this.pioche.add(
						(new Lettre("E", 1, new ImageIcon("src/images/E.jpg"), new ImageIcon("src/images/Egris.jpg"))));
			}

			for (int i = 0; i < 8; i++) {
				this.pioche.add(
						(new Lettre("I", 1, new ImageIcon("src/images/I.jpg"), new ImageIcon("src/images/Igris.jpg"))));

			}

			for (int i = 0; i < 9; i++) {
				this.pioche.add((new Lettre("A", 1, new ImageIcon("src/images/A.jpg"),
						new ImageIcon("src/images/A_gris.jpg"))));

			}

			for (int i = 0; i < 6; i++) {
				this.pioche.add(
						(new Lettre("O", 1, new ImageIcon("src/images/O.jpg"), new ImageIcon("src/images/Ogris.jpg"))));

				this.pioche.add(
						(new Lettre("N", 1, new ImageIcon("src/images/N.jpg"), new ImageIcon("src/images/Ngris.jpg"))));

				this.pioche.add(
						new Lettre("R", 1, new ImageIcon("src/images/R.jpg"), new ImageIcon("src/images/Rgris.jpg")));
				this.pioche.add(
						new Lettre("S", 1, new ImageIcon("src/images/S.jpg"), new ImageIcon("src/images/Sgris.jpg")));
				this.pioche.add(
						new Lettre("U", 1, new ImageIcon("src/images/U.jpg"), new ImageIcon("src/images/Ugris.jpg")));
				this.pioche.add(
						new Lettre("T", 1, new ImageIcon("src/images/T.jpg"), new ImageIcon("src/images/Tgris.jpg")));
			}

			for (int i = 0; i < 5; i++) {
				this.pioche.add(
						new Lettre("L", 1, new ImageIcon("src/images/L.jpg"), new ImageIcon("src/images/Lgris.jpg")));
			}

			for (int i = 0; i < 3; i++) {
				this.pioche.add(
						new Lettre("D", 2, new ImageIcon("src/images/D.jpg"), new ImageIcon("src/images/Dgris.jpg")));
				this.pioche.add(
						new Lettre("M", 2, new ImageIcon("src/images/M.jpg"), new ImageIcon("src/images/Mgris.jpg")));

			}

			for (int i = 0; i < 2; i++) {
				this.pioche.add(
						new Lettre("G", 2, new ImageIcon("src/images/G.jpg"), new ImageIcon("src/images/Ggris.jpg")));
				this.pioche.add(
						new Lettre("B", 3, new ImageIcon("src/images/B.jpg"), new ImageIcon("src/images/Bgris.jpg")));
				this.pioche.add(
						new Lettre("C", 3, new ImageIcon("src/images/C.jpg"), new ImageIcon("src/images/Cgris.jpg")));
				this.pioche.add(
						new Lettre("P", 3, new ImageIcon("src/images/P.jpg"), new ImageIcon("src/images/Pgris.jpg")));
				this.pioche.add(
						new Lettre("F", 4, new ImageIcon("src/images/F.jpg"), new ImageIcon("src/images/Fgris.jpg")));
				this.pioche.add(
						new Lettre("H", 4, new ImageIcon("src/images/H.jpg"), new ImageIcon("src/images/Hgris.jpg")));
				this.pioche.add(
						new Lettre("V", 4, new ImageIcon("src/images/V.jpg"), new ImageIcon("src/images/Vgris.jpg")));
				this.pioche.add(new Lettre(" ", 0, new ImageIcon("src/images/JOKER.jpg"),
						new ImageIcon("src/images/JOKERgris.jpg")));
			}
			this.pioche
					.add(new Lettre("W", 10, new ImageIcon("src/images/W.jpg"), new ImageIcon("src/images/Wgris.jpg")));
			this.pioche
					.add(new Lettre("Y", 10, new ImageIcon("src/images/Y.jpg"), new ImageIcon("src/images/Ygris.jpg")));
			this.pioche
					.add(new Lettre("K", 10, new ImageIcon("src/images/K.jpg"), new ImageIcon("src/images/Kgris.jpg")));
			this.pioche
					.add(new Lettre("J", 8, new ImageIcon("src/images/J.jpg"), new ImageIcon("src/images/Jgris.jpg")));
			this.pioche
					.add(new Lettre("X", 10, new ImageIcon("src/images/X.jpg"), new ImageIcon("src/images/Xgris.jpg")));
			this.pioche
					.add(new Lettre("Q", 8, new ImageIcon("src/images/Q.jpg"), new ImageIcon("src/images/Qgris.jpg")));
			this.pioche
					.add(new Lettre("Z", 10, new ImageIcon("src/images/Z.jpg"), new ImageIcon("src/images/Zgris.jpg")));

		}
	}

	public Lettre piocherLettre() { // pioche une lettre et la supprime de la pioche
		Random r = new Random();
		Lettre l = this.pioche.get(r.nextInt(this.pioche.size()));
		this.pioche.remove(l);
		return l;
	}

	public void remettrepioche(Lettre l) { // remet une lettre dans la pioche
		this.pioche.add(l);
	}

	public void enregistrer() {
		try {
			FileOutputStream fos = new FileOutputStream(fichier);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this.pioche);
			oos.close();
			fos.close();
		} catch (IOException e1) {
			throw new RuntimeException("Impossible d'ecrire les donnees");
		}
	}
}
