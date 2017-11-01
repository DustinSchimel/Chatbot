package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

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
	
	public Chatbot(String username)
	{
		this.movieList = null;
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = null;
		this.currentTime = null;
		this.questions = new String[5];
		this.username = username;
		this.content = "games are fun";
		this.intro = null;
		this.topics = new String[7];
		this.verbs = new String [4];
		this.followUps = new String[5];
		
		buildVerbs();
		buildShoppingList();
		buildTopics();
		buildQuestions();
	}
	
	private void buildQuestions()
	{
		questions[0] = "What is your name?";
		questions[1] = "Do you have any cats?";
		questions[2] = "What's your favorite food?";
		questions[3] = "what color is your house?";
		questions[4] = "Do you have any dogs?";
	}
	
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
	
	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalent about";
		verbs[3] = "am thinking about";
	}

	private void buildMovieList()
	{
	
	}
	
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
	
	private void buildCuteAnimals()
	{
		
	}
	
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;
		
		if (input != null && input.length() > 2)
		{
			validLength = true;
		}
		
		return validLength;
	}
	
	public boolean htmlTagChecker(String input)
	{
		return false;
	}
	
	public boolean userNameChecker(String input)
	{
		return false;
	}
	
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		chatbotResponse += "You said:" + "\n" + input + "\n";
		
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);
		
		response += verbs[random];
		
		random = (int) (Math.random() * topics.length);
		response += " " + topics[random] + ".\n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
		return response;
	}
	
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
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		return false;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		if (shoppingList.contains(shoppingItem))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean movieTitleChecker(String title)
	{
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		return false;
	}

	public boolean quitChecker(String exitString)
	{
		return false;
	}

	public boolean keyboardMashChecker(String input)
	{
		if (input.contains("S.D.F."))
		{
			return false;
		}
		else if (input.contains("derf"))
		{
			return false;
		}
		else if (input.contains("sdf"))
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
		return null;
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
		return null;
	}
	
	public LocalTime getCurrentTime()
	{
		return null;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
}
