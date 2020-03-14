package projet_scrabble;



import java.awt.event.MouseEvent;
import java.beans.EventHandler;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class lettre extends Parent {
	public String lettre;//lettre de la touche, c'est une variable public pour qu'elle puisse être lue depuis les autres classes
    private int positionX = 0;//abscisse
    private int positionY = 0;//ordonnée de la touche
   
    Rectangle fond_touche;
    Text lettre_touche;
    
    public lettre(String l, int posX, int posY){
        lettre =  new String(l);
        positionX = posX;
        positionY = posY;
       
        
        fond_touche = new Rectangle(50,50,Color.WHITE);
        fond_touche.setArcHeight(10);
        fond_touche.setArcWidth(10);
        this.getChildren().add(fond_touche);//ajout du rectangle de fond de la touche
        
        lettre_touche = new Text(lettre);
        lettre_touche.setFont(new Font(25));
        lettre_touche.setFill(Color.BLACK);
        lettre_touche.setX(20);
        lettre_touche.setY(35);
        this.getChildren().add(lettre_touche);//ajout de la lettre de la touche
        
        // changement de couleur au clic de la lettre
        
        
        
        this.setTranslateX(positionX);//positionnement de la touche sur le clavier
        this.setTranslateY(positionY);
     
        this.setOnMousePressed(mouseEvent -> chgmcouleurclic(lettre_touche));
       
       
    }
    public void chgmcouleurclic(Text l){
        fond_touche.setFill(Color.GRAY);
        
        l.setFont(new Font(25));
        l.setFill(Color.BLACK);
        l.setX(20);
        l.setY(35);
        if (fond_touche.isPressed()) {
        	fond_touche.setFill(Color.WHITE);
        }
      //  this.setTranslateY(positionY+2);
    }
        
   

}
	