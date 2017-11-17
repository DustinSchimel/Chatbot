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
		String response = display.collectResponse("What do you want to talk about?");
		
		/*while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))		//Checks for if the user's response is greater than or equal to three, not null,
		{																			//and that it's not the word 'quit'
			response = popupChat(response);											//Calls popupChat and gives it response
			response = display.collectResponse(response);								//Displays the users response, bot statement and question, the user can then answer and it will loop
		}*/
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
