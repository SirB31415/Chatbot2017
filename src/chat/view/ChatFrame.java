package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JFrame;

public class ChatFrame extends JFrame
{
	private ChatbotController appController;
	
	public ChatFrame(ChatbotController appController)
	{
		super();
		this.appController = appController;
		appPane = new ChatPanel(appController);
		this.appController = appController;
		setupFrame();
	}
	private void setupFrame()
	{
		this.setResizable(false);
		this.setSize(600,600);
		this.setContentPane(appPane);
		this.setTitle("Chatting with Chatbot");
		this.setVisible(true);
	}
}
