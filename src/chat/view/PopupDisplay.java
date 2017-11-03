package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class PopupDisplay
{
	private ImageIcon icon;
	private String windowTitle;
	
	public PopupDisplay()
	{
		icon = new ImageIcon(getClass().getResource("images/hal.png"));
		windowTitle = "Chatbot says";
	}
	
	public void displayText(String message)
	{
		JOptionPane.showMessageDialog(null, message, windowTitle, JOptionPane.INFORMATION_MESSAGE, icon);
	}
	
//this creates the collectResponse method for the controller
	public String collectResponse(String question)
	{
		String answer = "";
		answer += JOptionPane.showInputDialog(null, question, windowTitle, JOptionPane.PLAIN_MESSAGE, icon, null, "");
		return answer;
	}
}
