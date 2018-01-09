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
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.currentTime = LocalTime.now();
		this.questions = new String[4];
		this.username = username;
		this.content = "";
		this.intro = new String("Chatbot is being used to teach us how to ");
		this.topics = new String[4];
		this.verbs = new String[4];
		this.followUps = new String[5];
		
		buildMovieList();
		buildQuestions();
		buildTopics();
		buildVerbs();
		buildShoppingList();
		buildCuteAnimals();
		buildFollowups();
	}
	/**
	 *
	 * Built the verbs array. 4 chatbot
	 *
	 */
	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalent about";
		verbs[3] = "am thinking about";
	}
	/**
	 *
	 * Built the topics array. 4 chatbot
	 *
	 */
	private void buildTopics()
	{
		topics[0] = "Theory of Calvin's Perpetual Virginity";
		topics[1] = "Makai's Belief in Ghosts";
		topics[2] = "Yael Getting into Yale";
		topics[3] = "Parker's Narcissism";
	}
	/**
	 *
	 * Built the followups array. 4 chatbot
	 *
	 */
	private void buildFollowups()
	{
		followUps[0] = "";
		followUps[1] = "";
		followUps[2] = "";
		followUps[3] = "";
		followUps[4] = "";
	}
	/**
	 *
	 * Built the movie list arraylist. 4 chatbot
	 *
	 */
	private void buildMovieList()
	{
		movieList.add(new Movie("Friday the Thirteenth"));
		movieList.add(new Movie("Friday the Thirteenth II"));
		movieList.add(new Movie("Friday the Thirteenth III"));
		movieList.add(new Movie("Friday the Thirteenth IV"));
		movieList.add(new Movie("Friday the Thirteenth V"));
		movieList.add(new Movie("Friday the Thirteenth VI"));
		movieList.add(new Movie("Friday the Thirteenth VII"));
	}
	/**
	 *
	 * Built the shopping list arraylist. 4 chatbot
	 *
	 */
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("eggs");
		shoppingList.add("protein");
		shoppingList.add("hot peppers");
		shoppingList.add("onions");
		shoppingList.add("bagel");
		shoppingList.add("crunchy peanut butter");
		shoppingList.add("hot sauce");
		shoppingList.add("juice");
	}
	/**
	 *
	 * Built the cute animals arraylist. 4 chatbot
	 *
	 */
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("kitty");
		cuteAnimalMemes.add("puppy");
		cuteAnimalMemes.add("doge");
		cuteAnimalMemes.add("goat");
	}
	/**
	 *
	 * Built the questions array. 4 chatbot
	 *
	 */
	private void buildQuestions()
	{
		questions[0] = "What is the meaning of life? (hint: 42)";
		questions[1] = "What is the reason for existence? (hint: 42)";
		questions[2] = "Why is there something instead of nothing? (hint: 42)";
		questions[3] = "Why is Calvin such a terrible human being? (hint: 42)";
	}
	/**
	 * Built the chatbot response with random picking of the above lists.
	 * @return chatbot response.
	 */
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);
		response += verbs[random];
	
		random = (int) (Math.random() * topics.length);
		response += " " +topics[random] + ".\n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
		random = (int) (Math.random() * 2);
		
		if (random % 2 == 0)
		{
			random = (int) (Math.random() * movieList.size());
			response += "\n" + movieList.get(random).getTitle() + " is a great movie!";
		}
		
		int followup = (int) (Math.random() * 5);
		
		switch (followup)
		{
		case 0:
			response+= followUps[0] + "\n";
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
	 * Gets input and returns the chatbot response.
	 * @param input in string type
	 * @return the chatbot response from above.
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
	 * Checks the length of user inputs
	 * @param input from user in string type.
	 * @return true or false if the response is long enough
	 */
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;
		
		if (input != null && input.length() > 2)
		{
				validLength = true;
		}
		else
		{
			validLength = false;
		}
		
		
		return validLength;
	}
	/**
	 * This will check if the input is valid HTML
	 * @param input from user in string type.
	 * @return true or false depending on if the response is proper HTML
	 */
	public boolean htmlTagChecker(String input)
	{
		if (!input.contains("<") && !input.contains(">"))
		{
			return false;
		}
		else if (input.contains("<>"))
		{
			return false;
		}
		else if(input.contains(""))
		{
			return false;
		}
		else if (input.length() < 3)
		{
			return false;
		}
		if(input.contains("<A HREF=") && input.contains(">") && input.contains("</a>") && input.indexOf("<A HREF=") < input.indexOf('>') && input.indexOf('>') < input.indexOf("</a>"))
		{
			return true;
		}
		return false;
	}
	/**
	 * Checks if the input is a valid twitter username
	 * @param input in the form of a string.
	 * @return true if it is a valid twitter username.
	 */
	public boolean userNameChecker(String input)
	{
		if (input != null)
		{
			if (input.contains("@") && input.length() > 1)
			{
				return true;
			}
		}
		
			return false;
	}
	/**
	 * Checks if content is valid
	 * @param contentCheck input
	 * @return true if content is valid
	 */
	public boolean contentChecker(String contentCheck)
	{
		if (contentCheck != null)
		{
			String[] contentArray = contentCheck.split(" ");

			if(contentArray.length > 1)
			{
				return true;
			}
		}
		return false;
	}
	/**
	 * checks if the input has an animal
	 * @param user string input
	 * @return true if the user puts in the proper input.
	 */
	public boolean cuteAnimalMemeChecker(String input)
	{
		for(String meme: cuteAnimalMemes)
			{
				if (input.contains(meme))
				{
						return true;
				}
			}
		return false;
	}
	/**
	 * checks if the list has the shopping items
	 * @param shopping list
	 * @return true if the list has the items
	 */
	public boolean shoppingListChecker(String shoppingItem)
	{
		if (shoppingList.contains("slug bait"))
		{
			return false;
		}
		else if (shoppingList.contains("eggs") && shoppingList.contains("protein") && shoppingList.contains("hot peppers") && shoppingList.contains("onions") && shoppingList.contains("snacks") && shoppingList.contains("bagel") && shoppingList.contains("crunchy peanut butter") && shoppingList.contains("hot sauce") && shoppingList.contains("juice"))
		{
			return true;
		}
		return false;
	}
	/**
	 * checks if the movie titles are valid
	 * @param movie titles
	 * @return true if the movie titles are valid.
	 */
	public boolean movieTitleChecker(String title)
	{

		if(title.length() > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * checks if the movie genre is proper
	 * @param movie genres
	 * @return true if the movie genres are proper
	 */
	public boolean movieGenreChecker(String genre)
	{
		if (genre.equals(""))
		{
			return false;
		}
		if (genre.equals("Horror"))
		{
			return true;
		}
		if (genre.equals("Thriller"))
		{
			return true;
		}
		return false;
	}
	/**
	 * checks if the quitchecker is valid
	 * @param quitchecker
	 * @return true if quitchecker is right
	 */
	public boolean quitChecker(String exitString)
	{
		if (exitString.equalsIgnoreCase("quit"))
		{
			return true;
		}
		else
		{
		return false;
		}
	}

	public boolean keyboardMashChecker(String sample)
	{
		if (sample.equals("sdf") || sample.equals("dfg") || sample.equals("cvb") || sample.equals(",./") || sample.equals("kjh") || sample.equals("DFG") || sample.equals("CVB") || sample.equals("KJH")) 
		{
			return true;
		}
		return false;
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
		currentTime = LocalTime.now();
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
}
