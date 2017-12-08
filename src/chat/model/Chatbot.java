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
		this.cuteAnimalMemes = null;
		this.currentTime = LocalTime.now();
		this.questions = new String[4];
		this.username = username;
		this.content = null;
		this.intro = new String("Chatbot is being used to teach us how to ");
		this.topics = new String[4];
		this.verbs = new String[4];
		this.followUps = new String[5];
		
		buildMovieList();
		buildQuestions();
		buildTopics();
		buildVerbs();
		buildShoppingList();
	}
	
	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalent about";
		verbs[3] = "am thinking about";
	}
	private void buildTopics()
	{
		topics[0] = "Theory of Calvin's Perpetual Virginity";
		topics[1] = "Makai's Belief in Ghosts";
		topics[2] = "Yael Getting into Yale";
		topics[3] = "Parker's Narcissism";
	}
	private void buildMovieList()
	{
		Movie m1 = new Movie("Friday the Thirteenth");
		Movie m2 = new Movie("Friday the Thirteenth II");
		Movie m3 = new Movie("Friday the Thirteenth III");
		Movie m4 = new Movie("Friday the Thirteenth IV");
		Movie m5 = new Movie("Friday the Thirteenth V");
		Movie m6 = new Movie("Friday the Thirteenth VI");
		Movie m7 = new Movie("Friday the Thirteenth VII");
		
		movieList.add(m1);
		movieList.add(m2);
		movieList.add(m3);
		movieList.add(m4);
		movieList.add(m5);
		movieList.add(m6);
		movieList.add(m7);
	}
	
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
	
	private void buildCuteAnimals()
	{
		
	}
	
	private void buildQuestions()
	{
		questions[0] = "What is the meaning of life? (hint: 42)";
		questions[1] = "What is the reason for existence? (hint: 42)";
		questions[2] = "Why is there something instead of nothing? (hint: 42)";
		questions[3] = "Why is Calvin such a terrible human being? (hint: 42)";
	}
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		currentTime = LocalTime.now();
		chatbotResponse += currentTime.getHour() + ":" + currentTime.getMinute() + " ";
		chatbotResponse += "You said:" + "\n" + input + "\n";
		
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);
		response += " " + verbs[random];
	
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
	
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;
		
		if (input != null && input.length() > 1)
		{
				validLength = true;
		}
		else
		{
			validLength = false;
		}
		
		
		return validLength;
	}
	
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
	
	public boolean userNameChecker(String input)
	{
		return false;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		return false;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		return false;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		if (shoppingList.contains("eggs") && shoppingList.contains("protein") && shoppingList.contains("hot peppers") && shoppingList.contains("onions") && shoppingList.contains("snacks") && shoppingList.contains("bagel") && shoppingList.contains("crunchy peanut butter") && shoppingList.contains("hot sauce") && shoppingList.contains("juice"))
		{
			return true;
		}
		return false;
	}
	
	public boolean movieTitleChecker(String title)
	{
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		if (genre.equals(""))
		{
			return false;
		}
		if (genre.equals("Documentary"))
		{
			return true;
		}
		if (genre.equals("Thriller"))
		{
			return true;
		}
		return false;
	}

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
		return intro;
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
