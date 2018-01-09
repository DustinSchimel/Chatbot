package chat.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import chat.controller.ChatbotController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 * Creates a panel for the bot to be able to display information to the user, and for the user to send input
 * @author Dustin Schimel
 * 
 */
public class ChatPanel extends JPanel
{
	private ChatbotController appController;
	private JButton chatButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	private SpringLayout appLayout_1;
	private JButton checkerButton;
	private JLabel infoLabel;
	private JLabel infoLabel2;
	private JScrollPane chatPane;
	
	/**
	 * Initializes GUI data members and calls other methods
	 * @param appController
	 */
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;
		
		appLayout = new SpringLayout();
		chatArea = new JTextArea(5, 25);
		chatButton = new JButton("Chat");
		checkerButton = new JButton("Check");
		inputField = new JTextField(20);
		infoLabel = new JLabel("Type to chat with John");
		infoLabel2 = new JLabel("I don't bite!");
		appLayout_1 = new SpringLayout();
		chatPane = new JScrollPane();
		
		setupChatArea();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupChatArea()
	{
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
		chatArea.setWrapStyleWord(true);
		chatArea.setLineWrap(true);
		chatPane.setViewportView(chatArea);
		chatPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	}
	
	/**
	 * Sets certain settings for the panel on start
	 */
	private void setupPanel()
	{
		this.setLayout(appLayout_1);
		this.setBackground(Color.GREEN);
		this.add(chatButton);
		this.add(inputField);
		this.add(infoLabel);
		this.add(infoLabel2);
		this.add(checkerButton);
		this.add(chatPane);
		
	}
	
	/**
	 * Sets positioning of GUI elements
	 */
	private void setupLayout()
	{
		appLayout_1.putConstraint(SpringLayout.SOUTH, chatButton, -40, SpringLayout.SOUTH, this);
		appLayout_1.putConstraint(SpringLayout.NORTH, chatArea, 10, SpringLayout.NORTH, this);
		appLayout_1.putConstraint(SpringLayout.WEST, chatArea, 25, SpringLayout.WEST, this);
		appLayout_1.putConstraint(SpringLayout.SOUTH, chatArea, -14, SpringLayout.NORTH, checkerButton);
		appLayout_1.putConstraint(SpringLayout.EAST, chatArea, -25, SpringLayout.EAST, this);
		appLayout_1.putConstraint(SpringLayout.SOUTH, checkerButton, -6, SpringLayout.NORTH, chatButton);
		appLayout_1.putConstraint(SpringLayout.EAST, checkerButton, -25, SpringLayout.EAST, this);
		appLayout_1.putConstraint(SpringLayout.WEST, chatButton, 0, SpringLayout.WEST, checkerButton);
		appLayout_1.putConstraint(SpringLayout.WEST, inputField, 25, SpringLayout.WEST, this);
		appLayout_1.putConstraint(SpringLayout.EAST, chatButton, -25, SpringLayout.EAST, this);
		appLayout_1.putConstraint(SpringLayout.NORTH, chatPane, 50, SpringLayout.NORTH, this);
		appLayout_1.putConstraint(SpringLayout.WEST, chatPane, 30, SpringLayout.WEST, this);
		appLayout_1.putConstraint(SpringLayout.EAST, chatPane, -30, SpringLayout.EAST, this);
		appLayout_1.putConstraint(SpringLayout.NORTH, infoLabel2, 6, SpringLayout.SOUTH, infoLabel);
		appLayout_1.putConstraint(SpringLayout.WEST, infoLabel2, 0, SpringLayout.WEST, inputField);
		appLayout_1.putConstraint(SpringLayout.NORTH, inputField, 237, SpringLayout.NORTH, this);
		appLayout_1.putConstraint(SpringLayout.WEST, infoLabel, 0, SpringLayout.WEST, inputField);
		appLayout_1.putConstraint(SpringLayout.SOUTH, infoLabel, -26, SpringLayout.NORTH, inputField);
	}
	
	/**
	 * Creates listeners for two buttons to send information to the chatbot
	 */
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent click)
				{
					//String userText = inputField.getText();
					//String displayText = appController.interactWithChatbot(userText);
					//chatArea.append(displayText);
					//inputField.setText("");
					scrollTextDown();
				}
		});
		
		inputField.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent enterPress)
				{
					
					scrollTextUp();
				}
		});
	}
	
	
	private void scrollTextUp()
	{
		String userText = inputField.getText();
		String chatbotResponse = appController.interactWithChatbot(userText);
		String currentText = chatArea.getText();
		
		chatArea.setText("You said: " + userText + "\n" + "Chatbot says: " + chatbotResponse + "\n" + currentText);
		chatArea.setCaretPosition(0);
		
		inputField.setText("");
	}
	
	private void scrollTextDown()
	{
		String userText = inputField.getText();
		String chatbotResponse = appController.interactWithChatbot(userText);
		String oldText = chatArea.getText();
		
		chatArea.setText(oldText + "You said: " + userText + "\n" + "Chatbot says: " + chatbotResponse);
		chatArea.setCaretPosition(chatArea.getCaretPosition());
		
		inputField.setText("");
	}
	
}
