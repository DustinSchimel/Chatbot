package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 * Simple GUI class using JOptionPane.
 * @author Dustin Schimel
 * @version 1.0 03.10.2017
 */

public class PopupDisplay
{
	private ImageIcon icon;
	private String windowTitle;
	
	public PopupDisplay()
	{
		icon = new ImageIcon(getClass().getResource("images/chatbot.png"));
		windowTitle = "Chatbot says";
	}
	
	/**
	 * Displays a popup showing a supplied String to the user.
	 * @param textToDisplay The text to be displayed.
	 */
	
	public void displayText(String message)
	{
		JOptionPane.showMessageDialog(null, message, windowTitle, JOptionPane.INFORMATION_MESSAGE, icon);
	}
	
	/**
	 * Uses a popup to display a question to the user and stores their response as a String.
	 * @param questionToDisplay The question being asked.
	 * @return The users response to the question.
	 */
	
	public String collectResponse(String question)
	{
		String answer = "";
		
		answer += JOptionPane.showInputDialog(null, question, windowTitle, JOptionPane.PLAIN_MESSAGE, icon, null, "");
		
		return answer;
	}
}

