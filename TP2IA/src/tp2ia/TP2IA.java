/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2ia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author usuario
 */
public class TP2IA extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ChatWindow.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("COVID-19 Chatbot: Atrapalos a todos!");
        stage.getIcons().add(new Image (TP2IA.class.getResourceAsStream("resources/icon.png")));
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
  //Indica que cuando se cierre la ventana se termine el hilo de b�squeda 
    @Override
    public void stop(){
        System.out.println("Stage is closing");
        ChatWindowController.closeSearchThread();
    }
    
}
