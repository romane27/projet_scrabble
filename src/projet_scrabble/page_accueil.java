package projet_scrabble;

import java.awt.BorderLayout;
import java.awt.Dimension;

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

public class page_accueil extends Application {

    public static void main(String[] args) {
        Application.launch(page_accueil.class, args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Jeu du Scrabble");
        Group root = new Group();
        Scene scene = new Scene(root,1000, 1000, Color.WHITE);
        
        Clavier mon_clavier = new Clavier();
       
        plateau plateau = new plateau();
        root.getChildren().add(plateau);
        root.getChildren().add(mon_clavier);
        primaryStage.setScene(scene);
        
       primaryStage.show();
    }
}

