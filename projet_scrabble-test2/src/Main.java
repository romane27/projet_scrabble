import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;

import Controleur.Controleur;
import Vue2.Premierepage;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ImageIcon image1 = new ImageIcon("src/images/bonhomme1.png");
		int input = JOptionPane.showConfirmDialog(null, "Voulez-vous charger une partie ?", " ",
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, image1);

		if (input == 0) {
			File rep = new File("Sauvegardes");
			File[] l = rep.listFiles();
			if (l.length == 0) {
				JOptionPane.showMessageDialog(null, "Il n'y a pas de sauvegarde, une nouvelle partie se lance !", "",
						JOptionPane.WARNING_MESSAGE);
				new Premierepage();
			} else {
				ArrayList<String> list = new ArrayList<String>();
				for (File f : l) {
					list.add(f.getName());
					System.out.println(list.get(0));
				}
				Object[] fichier = list.toArray();
				JOptionPane jop = new JOptionPane();
				String nom = (String) jop.showInputDialog(null, "Veulliez choisir la sauvegarde", "Lancement",
						JOptionPane.QUESTION_MESSAGE, null, fichier, fichier[fichier.length - 1]);
				File rep1 = new File("Sauvegardes/" + nom);
				File[] l1 = rep1.listFiles();
				for (File fichier1 : l1) {
					FileChannel in = new FileInputStream("Sauvegardes/" + nom + "/" + fichier1.getName()).getChannel();
					FileChannel out = new FileOutputStream("Temp/" + fichier1.getName()).getChannel();
					{

						in.transferTo(0, in.size(), out);
						;
					}
					{

					}

				}
				new Controleur();
			}
		}
		if (input == 1) {
			File rep1 = new File("Temp");
			File[] l1 = rep1.listFiles();
			if (l1.length != 0) {

				for (File fichier1 : l1) {
					fichier1.delete();
				}
			}
			new Premierepage();
		}

	}
}
