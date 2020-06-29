/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2ia;

import java.lang.Thread.State;
import java.net.URL;
import java.util.ResourceBundle;

import chatbot.ChatbotAgent;
import chatbot.ChatbotEnvironment;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import simulador.KnowledgeBasedAgentSimulator;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class ChatWindowController implements Initializable {
	public static Thread thre;
	
    @FXML
    private TextField tfInput;
    @FXML
    private WebView wvChat;
    
    private WebEngine engine;
    private StringBuffer htmlContent;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        htmlContent = new StringBuffer();
        engine = wvChat.getEngine();
        
    	//Configura interface
    	InterfaceUpdater.setChatWindow(this);
    	engine.setUserStyleSheetLocation(getClass().getResource("resources/style.css").toString());
    	htmlContent.append("<script> \r\n" + 
    			"function scrollBottom() {window.scrollTo(0, 99999);}\r\n" + 
    			"if (document.addEventListener) document.addEventListener(\"DOMContentLoaded\", scrollBottom, false)\r\n" + 
    			"else if (window.attachEvent) window.attachEvent(\"onload\", scrollBottom);\r\n" + 
    			"</script>");
    	comenzarSimulacion();
    }    
    
    @FXML
    private void agregarRespuestaUsuario(ActionEvent event){
        if( ! tfInput.getText().isEmpty()){
        	htmlContent.append("<div class=\"user\"><span class=\"user\"><p>" + tfInput.getText() + "</p></span></div>");
            engine.loadContent(htmlContent.toString());
            ChatbotEnvironment.respuestaUsuario = tfInput.getText();
            tfInput.clear();
        }
    }
    
    public void agregarRespuestaBot(String text){
    	htmlContent.append("<div class=\"chatbot\"><span class=\"chatbot\"><p>" + text + "</p></span></div>");
        engine.loadContent(htmlContent.toString());
    }
    
    public void close() {
    	((Stage) tfInput.getScene().getWindow()).close();
    }
    
    public void comenzarSimulacion() {
    	
    	//Comienza la ejecución en un hilo secundario para no trabar sobre el hilo de la interface
    	thre = new Thread() {
    		public void run() {
    			ChatbotAgent agent = new ChatbotAgent();

    		 	ChatbotEnvironment environment = new ChatbotEnvironment();

    		 	KnowledgeBasedAgentSimulator simulator =
    	                new KnowledgeBasedAgentSimulator(environment, agent);
    	        
    	        simulator.start();
    		}
    		
    		@Override
    		public void interrupt() {
    			super.interrupt();
    			System.out.println("Thread interrupted");
    			this.stop();
    		}
    	};
    	
        thre.start();
    }
    
    /***Termina la ejecución del hilo de búsqueda***/
    public static void closeSearchThread() {
    	if(thre!=null) {
    		if(!thre.isAlive())
    			return;
    		
    		//Evita interrumpirlo mientras el hilo está dormido para evitar una exception
    		while(thre.getState()==State.TIMED_WAITING) {
    			
    		}
    		thre.interrupt();
    	}
    }
    
    public void cambiarIcon() {
    	((Stage) tfInput.getScene().getWindow()).getIcons().clear();
    	((Stage) tfInput.getScene().getWindow()).getIcons().add(new Image (TP2IA.class.getResourceAsStream("resources/icon2.png")));
    }
}
