package View;

import javax.swing.JOptionPane;

/**
 * Simple GUI class using JOptionPane.
 * @author Dustin Schimel
 * @version 1.0 03.10.2017
 */
public class PopupDisplay
{
	/**
	 * Displays a popup showing a supplied String to the user.
	 * @param textToDisplay The text to be displayed.
	 */
	public void displayText(String textToDisplay)
	{
		JOptionPane.showMessageDialog(null, textToDisplay);
	}
	
	/**
	 * Uses a popup to display a question to the user and stores their response as a String.
	 * @param questionToDisplay The question being asked.
	 * @return The users response to the question.
	 */
	public String getResponse(String questionToDisplay)
	{
		String answer = "";
		
		answer += JOptionPane.showInputDialog(null, questionToDisplay);
		
		return answer;
	}
}

