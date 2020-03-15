package projet_scrabble;

import java.util.ArrayList;

import javafx.scene.Parent;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

public class Clavier extends Parent {
	
	    
	    private lettre[] touches;
	   tirage_lettre tirage;
	    public Clavier(){
	    	Rectangle grand_fond = new Rectangle();
	        grand_fond.setWidth(250); //900
	        grand_fond.setHeight(300); //900
	        grand_fond.setFill(Color.WHITE);
	        Rectangle fond_clavier = new Rectangle();
	        fond_clavier.setWidth(420);
	        fond_clavier.setHeight(80);
	        fond_clavier.setArcWidth(30);
	        fond_clavier.setArcHeight(30);
	        fond_clavier.setFill( //on remplie notre rectangle avec un dégradé
	            new LinearGradient(0f, 0f, 0f, 1f, true, CycleMethod.NO_CYCLE,
	                new Stop[] {
	                    new Stop(0, Color.web("#333333")),
	                    new Stop(1, Color.web("#000000"))
	                }
	            )
	        );
	        Reflection r = new Reflection();//on applique un effet de réflection
	        r.setFraction(0.25);
	        r.setBottomOpacity(0);
	        r.setTopOpacity(0.5);
	        fond_clavier.setEffect(r);
	        tirage = new tirage_lettre(7);
	        ArrayList<String>  t = tirage.newlettre;
	         
	        touches = new lettre[] {
	        	new lettre(t.get(0),10,20),
	        	new lettre(t.get(1),68,20),
	        	new lettre(t.get(2),126,20),
	        	new lettre(t.get(3),184,20),
	        	new lettre(t.get(4),242,20),
	        	new lettre(t.get(5),300,20),
	        	new lettre(t.get(6),358,20)
	        	
	        	
	        };
	        
	        
	        this.setTranslateX(117);
	        this.setTranslateY(640); //875
	        this.getChildren().add(grand_fond);
	        this.getChildren().add(fond_clavier);
	        
	        for (lettre touche: touches){
	            this.getChildren().add(touche);
	        }
	        
	        //System.out.println(tirage.newlettres);
	        
	    }
	   /* public static void main(String[] args) {
			// TODO Auto-generated method stub
			Clavier ti = new Clavier();
	    }*/
	}
