package tp2ia;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javafx.application.Platform;

public class InterfaceUpdater {
	private static ChatWindowController chatWindow;
	private static Logger logger;
	

	public static void agregarRespuestaBot(String text) {
		Thread thre = new Thread() {
			public void run(){
				Platform.runLater(new Runnable(){
					@Override
					public void run() {
						chatWindow.agregarRespuestaBot(text);
					}
				});
			}
		};
		thre.start();
	}
	
	public static void close() {
		Thread thre = new Thread() {
			public void run(){
				Platform.runLater(new Runnable(){
					@Override
					public void run() {
						chatWindow.close();
					}
				});
			}
		};
		thre.start();
	}
	
	
	public static ChatWindowController getChatWindow() {
		return chatWindow;
	}
	
	public static void setChatWindow(ChatWindowController chatWindow) {
		InterfaceUpdater.chatWindow = chatWindow;
		startLogger();
	}
	
	private static void startLogger() {
		System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$td/%1$tm/%1$tY %1$tH:%1$tM:%1$tS]: %5$s%n");
		
		logger = Logger.getLogger("LoggerMan");
		File file = new File("TP2IA/src/tp2ia/resources/LoggerMan.log");
		
		try {
			FileHandler fh = new FileHandler(file.getAbsolutePath());
			logger.addHandler(fh);
			SimpleFormatter sf = new SimpleFormatter();
			fh.setFormatter(sf);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void addToLog(String text) {
		logger.info(text);
	}
}
