package projet_scrabble;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;





import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Page_accueil extends Application {

    public static void main(String[] args) {
        Application.launch(Page_accueil.class, args);
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException {
    	Modele m = new Modele();
    	Controleur c = new Controleur(m);
        primaryStage.setTitle("Jeu du Scrabble");
        Group root = new Group();
        Scene scene = new Scene(root,1000, 800, Color.WHITE);
        //Modele m = new Modele();
        //Controleur c = new Controleur(m);
        
        Clavier mon_clavier = new Clavier(c,m);
        Suggestions suggestion = new Suggestions();
        Plateau plateau = new Plateau(m);
        bouton_ok bouton = new bouton_ok("remettre");
       
        root.getChildren().add(bouton);
        root.getChildren().add(suggestion);
        root.getChildren().add(plateau);
        root.getChildren().add(mon_clavier);
        primaryStage.setScene(scene);
        
       primaryStage.show();
    }
}