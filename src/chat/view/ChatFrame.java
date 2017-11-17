package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JFrame;

public class ChatFrame extends JFrame
{
	private ChatbotController appController;
	private ChatPanel appPanel;
	
	/**
	 * 
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
}
