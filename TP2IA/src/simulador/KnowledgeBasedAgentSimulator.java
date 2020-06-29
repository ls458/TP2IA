package simulador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import chatbot.ChatbotAgent;
import chatbot.ChatbotEnvironment;
import sistemadeproduccion.GestorDeFrases;
import tp2ia.InterfaceUpdater;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.simulator.events.EventType;
import frsf.cidisi.faia.simulator.events.SimulatorEventNotifier;

/**
 * Clase que implementa el simulador de un agente basado en conocimiento.
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class KnowledgeBasedAgentSimulator extends frsf.cidisi.faia.simulator.Simulator {

	private final int SLEEP_TIME = 2500;
	
	/**
	 * Constructor.
	 * @param environment
	 * @param agents
	 */
    public KnowledgeBasedAgentSimulator(Environment environment, Vector<Agent> agents) {
        super(environment,agents);
    }
    
    /**
     * Constructor.
     * @param environment
     * @param agent
     */
    public KnowledgeBasedAgentSimulator(Environment environment, Agent agent) {
   		Vector<Agent> v = new Vector<Agent>();
   		v.add(agent);
    	this.environment = environment;
    	this.agents = v;
    }
	
	@Override
	public void start() {

        System.out.println("----------------------------------------------------");
        System.out.println("--- " + this.getSimulatorName() + " ---");
        System.out.println("----------------------------------------------------");
        System.out.println();

        
        //TODO Futuro: Esta hecho para el ChatBot pero debería incluirse el método learn en la clase agente.
        ChatbotAgent agent;

        agent = (ChatbotAgent) this.getAgents().firstElement();
        String respuesta = "";
        
        
        
        //Encuesta inicial para saber características del usuario
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String inputUsuario;
        
        ArrayList<String> respuestasFinEncuesta = new ArrayList<String>();
        respuestasFinEncuesta.add("Manténgase tranquilo, usted no es paciente de riesgo. Si la situación empeora "
        		+ "no dude en buscar asistencia médica. ¿Tiene alguna pregunta para hacer?");
        respuestasFinEncuesta.add("Le recomendamos que busque atención médica, no quisiéramos que su salud empeore.<br>"
        		+ "¿Desea saber algo más?");
        respuestasFinEncuesta.add("Excelente! Eso fue todo. ¿Tiene alguna pregunta para hacer?");
        agent.empezarConversacion(); //Se coloca el saludo inicial para poder ejecutarse en el environment

    	InterfaceUpdater.agregarRespuestaBot(agent.ejecutarRegla("Hola"));
        do {
        	//Espera hasta que el usuario introdusca una respuesta para el chatbot
        	while(ChatbotEnvironment.respuestaUsuario == null) {
        		//Espera SLEEP_TIME milisegundos para volver a revisar si el usuario ya ha contestado
        		try { Thread.sleep(SLEEP_TIME); }
        		catch (InterruptedException e) { e.printStackTrace(); }
        	}
        	
        	inputUsuario = agent.see();
            respuesta = agent.ejecutarRegla(inputUsuario);
        	
        	
            if (respuesta == null)
            	System.out.println("\nRule to execute: None");
            else
            {
            	System.out.println("\nRespuesta del robot: " + respuesta);
            	InterfaceUpdater.agregarRespuestaBot(respuesta);
            }
            System.out.println();
        	
        } while(!respuestasFinEncuesta.contains(respuesta));
        
        
        do {
            
        	//Espera hasta que el usuario introdusca una respuesta para el chatbot
        	while(ChatbotEnvironment.respuestaUsuario == null) {
        		//Espera SLEEP_TIME milisegundos para volver a revisar si el usuario ya ha contestado
        		try { Thread.sleep(SLEEP_TIME); }
        		catch (InterruptedException e) { e.printStackTrace(); }
        	}
        	
        	inputUsuario = agent.see();
            respuesta = agent.learn(inputUsuario);

            if (respuesta == null)
            	System.out.println("\nRule to execute: None");
            else
            {
            	System.out.println("\nRespuesta del robot: " + respuesta);
            	InterfaceUpdater.agregarRespuestaBot(respuesta);
            }
            System.out.println();


        } while(respuesta != "Adiós! Me alegra haber podido aclarar tus dudas!<br>"
				+ "Me voy en 5...4...3...");
        
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        InterfaceUpdater.close();

        System.out.println();

        // This call can be moved to the Simulator class
        this.environment.close();

        // Launch simulationFinished event
        SimulatorEventNotifier.runEventHandlers(EventType.SimulationFinished, null);
		
	}
	
	public String getSimulatorName() {
        return "Knowledge Based Simulator";
    }
    
}
