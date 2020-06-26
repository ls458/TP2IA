/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2ia;

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
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
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
    	comenzarSimulacion();
    }    
    
    @FXML
    private void agregarRespuestaUsuario(ActionEvent event){
        if( ! tfInput.getText().isEmpty()){
            //htmlContent.append("<p style=\"text-align: right; color:green; margin-top:0em; margin-bottom:0.5em;\"><span style=\"font-size:18px;\">"+tfInput.getText()+"</span></p>");
            htmlContent.append("<div style=\"display: flex; justify-content: flex-end; margin-left: 20%; margin-bottom: 4px;\">"
                    + "<span style=\"background-color: #f2f2f2; padding: 5px 15px 5px 10px; border-left: 6px solid #2d862d;"
                    + "border-radius: 0px 0px 0px 4px; float: right; overflow: hidden; word-wrap: break-word;\">"
                    + "<p style=\"margin:0.25em;\">" + tfInput.getText()+"</p></span></div>");
            engine.loadContent(htmlContent.toString());
            ChatbotEnvironment.respuestaUsuario = tfInput.getText();
        }
    }
    
    public void agregarRespuestaBot(String text){
        //htmlContent.append("<p style=\"text-align: left;\"><span style=\"font-size:18px;\">"+text+"</span></p>");
        htmlContent.append("<div style=\"display: flex; margin-right: 20%; margin-bottom: 5px;\">"
                    + "<span style=\"background-color: #f2f2f2; padding: 5px 10px 5px 15px; border-right: 6px solid #33ccff;"
                    + "border-radius: 0px 0px 4px 0px; overflow: hidden; word-wrap: break-word;\">"
                    + "<p style=\"margin:0.25em;\">" + text +"</p></span></div>");
        engine.loadContent(htmlContent.toString());
    }
    
    @FXML
    private void initialized(ActionEvent event) {
    	comenzarSimulacion();
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
}
