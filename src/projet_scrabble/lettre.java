package projet_scrabble;



import java.awt.event.MouseEvent;
import java.beans.EventHandler;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class lettre extends Parent {
	public String lettre;//lettre de la touche, c'est une variable public pour qu'elle puisse être lue depuis les autres classes
    private int positionX = 0;//abscisse
    private int positionY = 0;//ordonnée de la touche
    int Selectionne = 0;
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
        lettre_touche.setX(15);
        lettre_touche.setY(35);
        this.getChildren().add(lettre_touche);//ajout de la lettre de la touche
        
        // changement de couleur au clic de la lettre
        
        
        
        this.setTranslateX(positionX);//positionnement de la touche sur le clavier
        this.setTranslateY(positionY);
     
        this.setOnMousePressed(mouseEvent -> chgmcouleurclic(lettre_touche));
        this.setOnMouseDragged( e -> {
        	double x = e.getX();
        	double y = e.getY();
        	Selectionne =3;
        	fond_touche.setX(x);
        	fond_touche.setY(y);
        	fond_touche.setFill(Color.WHITE);
        	lettre_touche.setX(x+20);
        	lettre_touche.setY(y+35);

        	


        });
    }
    
   
   	
    public void chgmcouleurclic(Text l){
        
        if (fond_touche.isPressed() && Selectionne ==1) {
        	fond_touche.setFill(Color.WHITE);
        	Selectionne=0;
        	System.out.println("on deselectionne le bouton"+this.lettre);
        }
        else if (Selectionne==0){
        	fond_touche.setFill(Color.GRAY);
            System.out.println("on selectionne le bouton"+this.lettre);
            l.setFont(new Font(25));
            l.setFill(Color.BLACK);
            l.setX(20);
            l.setY(35);
            Selectionne=1;
        	
        }
     
    }
        
   

}