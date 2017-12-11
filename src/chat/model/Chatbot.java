package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Model for everything that the chatbot uses
 * @author Dustin Schimel
 *
 */
public class Chatbot
{
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	
	/**
	 * Initializes data members and calls other methods
	 * @param username
	 */
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.currentTime = LocalTime.now();
		this.questions = new String[10];
		this.username = username;
		this.content = "games are fun";
		this.intro = "Hi, I'm john and I love to talk fellow humans.";
		this.topics = new String[7];
		this.verbs = new String [4];
		this.followUps = new String[5];
		
		buildVerbs();
		buildShoppingList();
		buildTopics();
		buildQuestions();
		buildCuteAnimals();
	}
	
	/**
	 * Creates questions for the bot to ask from an array
	 */
	private void buildQuestions()
	{
		questions[0] = "What is your name?";
		questions[1] = "Do you have any cats?";
		questions[2] = "What's your favorite food?";
		questions[3] = "what color is your house?";
		questions[4] = "Do you have any dogs?";
		questions[5] = "How tall are you?";
		questions[6] = "What's your favorite drink?";
		questions[7] = "Where do you live?";
		questions[8] = "Are you having a nice day?";
		questions[9] = "What's your favorite cereal?";
	}
	
	/**
	 * Creates topics for the bot to mention in a conversation from an array
	 */
	private void buildTopics()
	{
		topics[0] = "science";
		topics[1] = "games";
		topics[2] = "food";
		topics[3] = "dogs";
		topics[4] = "cats";
		topics[5] = "life";
		topics[6] = "gameshows";
	}
	
	/**
	 * Creates verbs for the bot to use when describing a topic from an array
	 */
	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalent about";
		verbs[3] = "am thinking about";
	}

	/**
	 * TODO - Puts movies into the movie list
	 * Builds movies into a list
	 */
	private void buildMovieList()
	{
	
	}
	
	/**
	 * Adds shopping items to a list for the bot's use
	 */
	private void buildShoppingList()
	{
		shoppingList.add("eggs");
		shoppingList.add("protein");
		shoppingList.add("hot peppers");
		shoppingList.add("onions");
		shoppingList.add("snacks");
		shoppingList.add("bagel");
		shoppingList.add("crunchy peanut butter");
		shoppingList.add("hot sauce");
		shoppingList.add("juice");
		shoppingList.add("veggies");
	}
	
	/**
	 * Adds cute animals to a list
	 **/
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("pupper");
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("kittie");
		cuteAnimalMemes.add("FLOOFER");
	}
	
	/**
	 * Checks for if the string provided to the bot is greater than two and not null
	 * @param input
	 * @return
	 */
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;
		
		if (input != null && input.length() > 2)
		{
			validLength = true;
		}
		
		return validLength;
	}
	
	/**
	 * Checks for if the input contains proper HTML
	 * @param input
	 * @return
	 */
	public boolean htmlTagChecker(String input)
	{
		//turns the input into lowercase
		String lowerCaseInput = input.toLowerCase();
		
		//checks that the input is not null, contains < & >
		if (lowerCaseInput == null || !lowerCaseInput.contains("<") || !lowerCaseInput.contains(">"))
		{
			return false;
		}
		
		int firstOpen = lowerCaseInput.indexOf("<");
		int firstClose = lowerCaseInput.indexOf(">", firstOpen);
		int secondOpen = -9;
		int secondClose = -9;
		String tagText = lowerCaseInput.substring(firstOpen + 1, firstClose);
		
		//checks bad/empty tags
		if(lowerCaseInput.contains("<>") || lowerCaseInput.contains("< >"))
		{
			return false;
		}
		
		//checks singleton
		else if(lowerCaseInput.contains("<p>") || lowerCaseInput.contains("<br>"))
		{
			return true;
		}
		
		//checks others
		else if(firstClose > firstOpen)
		{
			if (tagText.contains("a href="))
			{
				secondOpen = lowerCaseInput.indexOf("</", firstClose);
				secondClose = lowerCaseInput.indexOf(">", secondOpen);
			}
			else
			{
				secondOpen = lowerCaseInput.indexOf("</" + tagText, firstClose);
				secondClose = lowerCaseInput.indexOf(">", secondOpen);
			}
			
			if (secondOpen == -1 || secondClose == -1) 
			{
				return false;
			}
			else if (tagText.contains("a href") && !tagText.contains("="))
			{
				return false;
			}
			else if (secondClose > secondOpen)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else 
		{
			return false;
		}
	}
	
	/**
	 * Checks for if a provided username meets the criteria
	 * @param input
	 * @return
	 */
	public boolean userNameChecker(String input)
	{
		if (input == null)
		{
			return false;
		}
		
		if (input != "")
		{
			if (input.substring(0, 1).equals("@"))
			{
				if (input.indexOf("@", 1) == -1)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Turns the user's input into a different string that the bot displays to the user
	 * @param input
	 * @return
	 */
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		currentTime = LocalTime.now();
		chatbotResponse += currentTime.getHour() + ":" + currentTime.getMinute() + " ";
		chatbotResponse += "You said:" + "\n" + input + "\n";
		
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	
	/**
	 * Uses random numbers to grab data from different arrays to make a question and topic for the bot to talk about
	 * @return response
	 */
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);
		
		response += verbs[random];
		
		random = (int) (Math.random() * topics.length);
		response += " " + topics[random] + ".\n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
		if (random % 2 == 0)
		{
			random = (int) (Math.random() * shoppingList.size());
			response += "\n" + shoppingList.get(random) + " is a great item!";
		}
		
		int followup = (int) (Math.random() * 5);
		
		switch (followup)
		{
		case 0:
			response += followUps[0] + "\n";
			break;
		case 3:
			response += followUps[1] + "\n";
		case 1:
			response += followUps[2] + "\n";
			break;
		default:
			response += followUps[4] + "\n";
			response += followUps[3] + "\n";
			break;
		}
		
		return response;
	}
	
	/**
	 * Checks for if the user's input contains any of these words, if it does it will return true
	 * and vice versa
	 * @param contentCheck
	 * @return true || false
	 */
	public boolean contentChecker(String contentCheck)
	{ 
		if (contentCheck.contains("games"))
		{
			return true;
		}
		
		if (contentCheck.contains("dogs"))
		{
			return true;
		}
		
		if (contentCheck.contains("cars"))
		{
			return true;
		}
		
		if (contentCheck.contains("cats"))
		{
			return true;
		}
		
		if (contentCheck.contains("socks"))
		{
			return true;
		}
		
		else if (contentCheck.contains("sfd"))
		{
			return true;
		}
		
		else
		{
			return false;
		}
		
	}
	
	/**
	 * Checks for if the cuteAnimalMeme list contains certain animals
	 * @param input
	 * @return
	 */
	public boolean cuteAnimalMemeChecker(String input)
	{
		for (int index = 0; index < cuteAnimalMemes.size(); index++)
		{
			if (cuteAnimalMemes.get(index).contains(input))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Goes through the shopping list to check for certain items
	 * @param shoppingItem
	 * @return true || false
	 */
	public boolean shoppingListChecker(String shoppingItem)
	{
		
		for (int index = 0; index < shoppingList.size(); index++)
		{
			if (shoppingItem.contains(shoppingList.get(index)))
			{
				return true;
			}
		}
	
		return false;	
	}
	
	/**
	 * TODO - Checks the movie list for certain titles
	 * @param title
	 * @return
	 */
	public boolean movieTitleChecker(String title)
	{
		return false;
	}
	
	/**
	 * TODO - Checks the movie list for certain genres
	 * @param genre
	 * @return
	 */
	public boolean movieGenreChecker(String genre)
	{
		return false;
	}

	/**
	 * Checks for if the user types the quit keyword
	 * @param exitString
	 * @return
	 */
	public boolean quitChecker(String exitString)
	{
		if (exitString == null)
		{
			return false;
		}
		else if (exitString.equals(""))
		{
			return false;
		}
		else if (exitString.equals("Quit") || exitString.equals("quit") || exitString.equals("QUIT"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Checks for if the user 'mashed their keyboard' by checking to see if their input contains any of these strings
	 * @param input
	 * @return true || false
	 */
	public boolean keyboardMashChecker(String input)
	{
		if (input.contains("sdf"))
		{
			return true;
		}
		else if (input.contains("SDF"))
		{
			return true;
		}
		else if (input.contains("dfg"))
		{
			return true;
		}
		else if (input.contains("cvb"))
		{
			return true;
		}
		else if (input.contains(",./"))
		{
			return true;
		}
		else if (input.contains("kjh"))
		{
			return true;
		}
		else if (input.contains("DFG"))
		{
			return true;
		}
		else if (input.contains("CVB"))
		{
			return true;
		}
		else if (input.contains("KJH"))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public List<Movie> getMovieList()
	{
		return movieList;
	}
	
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String [] getQuestions()
	{
		return questions;
	}
	
	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return intro;
	}
	
	public LocalTime getCurrentTime()
	{
		return currentTime;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
	
	public String toString()
	{
		String description = "Hello, my name is John and I like to talk to humans!";
		
		return description;
	}
}
