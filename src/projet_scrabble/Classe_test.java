package projet_scrabble;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Classe_test {
	
	public Classe_test() throws IOException {
	HashMap<String, ArrayList<String>> h = new HashMap<String, ArrayList<String>>();
	ArrayList<String> list = new ArrayList<String>();
	
	    BufferedReader lecteurAvecBuffer = null;
	    String ligne;

	    try
	      {
		lecteurAvecBuffer = new BufferedReader(new FileReader("dictionnaire.txt"));
	      }
	    catch(FileNotFoundException exc)
	      {
		System.out.println("Erreur d'ouverture");
	      }
	    while ((ligne = lecteurAvecBuffer.readLine()) != null)
	    {
	      list.add(ligne);
	    }
	    lecteurAvecBuffer.close();
	    //System.out.println(list.get(50000));
	  
	  for (int i=0; i< list.size(); i++) {
		  String cle = list.get(i).substring(0,1);
		  if (h.containsKey(cle)) {
			  ArrayList<String> liste = h.get(cle);
			  liste.add(list.get(i));
			  h.put(cle, liste);
		  }
		  else {
			  h.put(cle, new ArrayList<String>());
		  }
	  }
	    
	  }
	
	
public static void main(String[] argv) throws IOException
{
	Classe_test c = new Classe_test();
}
}
