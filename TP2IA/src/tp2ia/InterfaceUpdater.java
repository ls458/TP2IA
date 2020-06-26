package tp2ia;

import javafx.application.Platform;

public class InterfaceUpdater {
	private static ChatWindowController chatWindow;
	
	

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
	
	
	public static ChatWindowController getChatWindow() {
		return chatWindow;
	}
	
	public static void setChatWindow(ChatWindowController chatWindow) {
		InterfaceUpdater.chatWindow = chatWindow;
	}
}
