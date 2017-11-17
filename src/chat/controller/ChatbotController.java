package chat.controller;

import chat.view.PopupDisplay;
import chat.model.Chatbot;
import chat.view.ChatFrame;
import chat.view.ChatPanel;
public class ChatbotController
{
//this declares that the chatbot and popupdisplay exist
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
//this initializes the chatbot and popupdisplay for the Chatbot.java inside the chat.model
	public ChatbotController()
	{
		chatbot = new Chatbot("Papa Musk");
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
	}
	public void start()
	{
//this makes a new variable called response that collects the response from the display created in popupdisplay.
//		String response = display.collectResponse("What do you wanna talk about?");
		
//		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
//		{
//			response = popupChat(response);
//			response = display.collectResponse(response);
//		}

	}
	/**
	 * This makes a method with the type String and returns nothing
	 * @param String input
	 * @return null
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
	 * This makes a private method that returns a String of type chat and takes from the method processConversation to make chatbotSays return  a String of type chat.
	 * @param String chat
	 * @return chatbotSays
	 */
	private void close()
	{
		display.displayText("bu-bye");
		System.exit(0);
	}
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
	/**
	 * 
	 * @return chatbot
	 */
	public Chatbot getChatbot()
	{
		return chatbot;
	}
	/**
	 * 
	 * @return display
	 */
	public PopupDisplay getDisplay()
	{
		return display;
	}
	/**
	 * 
	 * @return appFrame
	 */
	public ChatFrame getChatFrame()
	{
		return appFrame;
	}
}
