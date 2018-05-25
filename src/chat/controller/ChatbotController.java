package chat.controller;

import chat.model.Chatbot;
import chat.view.PopupDisplay;
import chat.view.ChatFrame;
import chat.model.CTECTwitter;

/**
 * Controller for chatbot that calls all needed files
 * @author Dustin Schimel
 *
 */
public class ChatbotController
{
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	private CTECTwitter myTwitter;
	
	/**
	 * Initializes data member values
	 */
	public ChatbotController()
	{
		chatbot = new Chatbot("Dustin Schimel");
		myTwitter = new CTECTwitter(this);
		//View initialized after model
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
	}
	
	/**
	 * Prompts the user for a response
	 */
	public void start()
	{
		String results = IOController.loadFromFile(this, "commonWords.txt");
		IOController.saveToFile(this, results, "Save results.txt");
		
	}
	
	/**
	 * Gets called by a listener and then processes the user's input and then displays text to them
	 * @param input
	 * @return
	 */
	public String interactWithChatbot(String input)
	{
		String chatbotSays = "";
		
		if(chatbot.quitChecker(input))
		{
			close();
		}
		
		chatbotSays += chatbot.processConversation(input);
		
		return chatbotSays;
	}
	
	/**
	 * Displays a message to the user and then closes the chatbot
	 */
	private void close()
	{
		display.displayText("Goodbye");
		System.exit(0);
	}
	
	/**
	 * Creates a new String, processes the text and then returns it
	 * @param chat
	 * @return chatbotSays
	 */
	private String popupChat(String chat)
	{
		String chatbotSays = "";														//Creates a new variable with the value ""
		
		chatbotSays += chatbot.processConversation(chat);								//Calls processConversation and gives it chat, the returned value is then given to chatbotSays
		
		return chatbotSays;															//returns the value to response in start
	}
	
	public Chatbot getChatbot()
	{
		return chatbot;
	}
	
	public PopupDisplay getDisplay()
	{
		return display;
	}
	
	public ChatFrame getChatFrame()
	{
		return appFrame;
	}
	
	public void handleErrors(Exception error)
	{
		display.displayText(error.getMessage());
	}
	
	public void tweet(String text)
	{
		myTwitter.sendTweet(text);
	}
	
	public String search(String text)
	{
		return myTwitter.getMostCommonWord(text);
	}
	
	public String checkTopic(String topic)
	{
		return myTwitter.analyzeTwitterForTopic(topic);
	}
}
