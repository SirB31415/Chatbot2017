package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JFrame;

public class ChatFrame extends JFrame
{
	private ChatbotController appController;
	private ChatPanel appPanel;
/**
 * This initializes chatPanel and setupFrame and connects appController to JFrame
 * @param appController
 */
	public ChatFrame(ChatbotController appController)
	{
		super();
		this.appController = appController;
		appPanel = new ChatPanel(appController);
		
		setupFrame();
	}
/**
 * This makes a method called setupFrame that sets up the frame of the window.
 */
	private void setupFrame()
	{

		this.setSize(500,500);
		this.setContentPane(appPanel);
		this.setTitle("Chatting with Chatbot");
		this.setResizable(false);
		this.setVisible(true);
	}
	public ChatbotController getAppController()
	{
		return appController;
	}
}
