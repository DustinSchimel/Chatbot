package chat.controller;

import chat.view.PopupDisplay;
import chat.model.Chatbot;

public class ChatbotController
{
	private Chatbot chatbot;
	private PopupDisplay display;
	
	public ChatbotController()
	{
		chatbot = new Chatbot("Dustin Schimel");
		display = new PopupDisplay();
	}
	
	public void start()
	{
		String response = display.collectResponse("What do you want to talk about?");	//Prompts the user for a response
		
		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))		//Checks for if the user's response is greater than or equal to three, not null,
		{																			//and that it's not the word 'quit'
			response = popupChat(response);											//Calls popupChat and gives it response
			response = display.collectResponse(response);								//Displays the users response, bot statement and question, the user can then answer and it will loop
		}
	}
	
	private String popupChat(String chat)
	{
		String chatbotSays = "";														//Creates a new variable with the value ""
		
		chatbotSays += chatbot.processConversation(chat);								//Calls processConversation and gives it chat, the returned value is then given to chatbotSays
		
		return chatbotSays;															//returns the value to response in start
	}
}
