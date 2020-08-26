package Window;

public class Start{
	
	public static void main(String[] args) {
		Window window = Window.getWindow();
		window.init();
		
		Thread mainThread = new Thread(window);
		mainThread.start();
	}
	
}
