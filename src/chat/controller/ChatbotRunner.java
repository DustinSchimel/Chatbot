package chat.controller;

/**
 * Runs the project by calling the ChatbotController
 * @author dsch3401
 *
 */
public class ChatbotRunner
{
	public static void main (String [] args)
	{
		ChatbotController app = new ChatbotController();
		app.start();				
	}
}
