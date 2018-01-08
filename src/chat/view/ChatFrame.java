package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JFrame;

/**
 * Creates a frame for the panel to sit in
 * @author Dustin Schimel
 *
 */
public class ChatFrame extends JFrame
{
	private ChatbotController appController;
	private ChatPanel appPanel;
	
	/**
	 * Creates a new chat panel and calls setupFrame
	 * @param appController
	 */
	public ChatFrame(ChatbotController appController)
	{
		super();
		this.appController = appController;
		appPanel = new ChatPanel(appController);
		
		setupFrame();
	}
	
	/**
	 * Sets up GUI frame settings 
	 */
	private void setupFrame()
	{
		this.setContentPane(appPanel); //this line SHOULD be first
		this.setTitle("Chatting with John");
		this.setResizable(false);
		this.setSize(500, 500);
		this.setVisible(true); //this line must be last
	}
	
	public ChatbotController getAppController()
	{
		return appController;
	}
}
