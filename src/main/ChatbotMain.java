package main;

import chatbot.ChatbotAgent;
import chatbot.ChatbotEnvironment;
import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;
import simulador.KnowledgeBasedAgentSimulator;

public class ChatbotMain {
	
	 public static void main(String[] args) throws PrologConnectorException {
		 	ChatbotAgent agent = new ChatbotAgent();

		 	ChatbotEnvironment environment = new ChatbotEnvironment();

		 	KnowledgeBasedAgentSimulator simulator =
	                new KnowledgeBasedAgentSimulator(environment, agent);
	        
	        simulator.start();
	    }
	
}
