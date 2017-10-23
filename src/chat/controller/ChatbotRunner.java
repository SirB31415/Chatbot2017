package chat.controller;

import chat.view.PopupDisplay;

public class ChatbotRunner
{
	public static void main(String []args)
	{
		PopupDisplay test = new PopupDisplay();
		test.displayText("You're talking to your new supreme leader, SuperGodLord AI I");
		test.collectResponse("I'm omniscient, ask me a question.");
	}
}
