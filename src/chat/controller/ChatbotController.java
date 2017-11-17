package chat.controller;

import chat.model.Chatbot;
import chat.view.PopupDisplay;
import chat.view.ChatFrame;

public class ChatbotController
{
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	
	/**
	 * Initializes data member values
	 */
	public ChatbotController()
	{
		chatbot = new Chatbot("Dustin Schimel");
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
	}
	
	/**
	 * Prompts the user for a response
	 */
	public void start()
	{
		display.displayText("Hello, my name is John");
	}
	
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
	
	private void close()
	{
		display.displayText("Goodbye");
		System.exit(0);
	}
	
	/**
	 * Creates a new String and processes the text and then returns it
	 * @param chat
	 * @return chatbotSays
	 */
	private String popupChat(String chat)
	{
		String chatbotSays = "";														//Creates a new variable with the value ""
		
		chatbotSays += chatbot.processConversation(chat);								//Calls processConversation and gives it chat, the returned value is then given to chatbotSays
		
		return chatbotSays;															//returns the value to response in start
	}
}
