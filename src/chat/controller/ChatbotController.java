package chat.controller;

import chat.view.PopupDisplay;
import chat.model.Chatbot;
import chat.view.ChatFrame;
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
		appFrame = new ChatFrame();
	}
	public void start()
	{
//this makes a new variable called response that collects the response from the display created in popupdisplay.
		String response = display.collectResponse("What do you wanna talk about?");
		
//		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
//		{
//			response = popupChat(response);
//			response = display.collectResponse(response);
//		}

	}
	
	public String interactWithChatbot(String input)
	{
		return null;
	}
	
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
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
}
