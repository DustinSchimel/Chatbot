package chat.view;

import javax.swing.*;
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
	private JButton searchButton;
	private JButton saveButton;
	private JButton loadButton;
	private JButton tweetButton;
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
		
		chatButton = new JButton("Chat", new ImageIcon(getClass().getResource("/chat/view/images/chatIcon.png")));
		searchButton = new JButton("Search", new ImageIcon(getClass().getResource("/chat/view/images/searchIcon.png")));
		saveButton = new JButton("Save", new ImageIcon(getClass().getResource("/chat/view/images/saveIcon.png")));
		loadButton = new JButton("Load", new ImageIcon(getClass().getResource("/chat/view/images/loadIcon.png")));
		tweetButton = new JButton("Tweet", new ImageIcon(getClass().getResource("/chat/view/images/tweetIcon.png")));
		
		checkerButton = new JButton("Check contents");
		appLayout = new SpringLayout();
		inputField = new JTextField(20);
		infoLabel = new JLabel("Type to chat with John");
		infoLabel2 = new JLabel("I don't bite!");
		appLayout_1 = new SpringLayout();
		appLayout_1.putConstraint(SpringLayout.SOUTH, infoLabel, -71, SpringLayout.NORTH, infoLabel2);
		appLayout_1.putConstraint(SpringLayout.WEST, infoLabel2, 0, SpringLayout.WEST, inputField);
		appLayout_1.putConstraint(SpringLayout.EAST, infoLabel2, 72, SpringLayout.WEST, inputField);
		appLayout_1.putConstraint(SpringLayout.SOUTH, infoLabel2, -17, SpringLayout.NORTH, inputField);
		appLayout_1.putConstraint(SpringLayout.WEST, infoLabel, 25, SpringLayout.WEST, this);
		appLayout_1.putConstraint(SpringLayout.WEST, tweetButton, 379, SpringLayout.WEST, this);
		appLayout_1.putConstraint(SpringLayout.EAST, tweetButton, -1, SpringLayout.WEST, saveButton);
		appLayout_1.putConstraint(SpringLayout.WEST, inputField, 10, SpringLayout.WEST, this);
		appLayout_1.putConstraint(SpringLayout.SOUTH, inputField, 0, SpringLayout.SOUTH, chatButton);
		appLayout_1.putConstraint(SpringLayout.WEST, checkerButton, 0, SpringLayout.WEST, chatButton);
		appLayout_1.putConstraint(SpringLayout.SOUTH, checkerButton, -4, SpringLayout.NORTH, saveButton);
		appLayout_1.putConstraint(SpringLayout.EAST, checkerButton, 0, SpringLayout.EAST, chatButton);
		appLayout_1.putConstraint(SpringLayout.WEST, searchButton, 379, SpringLayout.WEST, this);
		appLayout_1.putConstraint(SpringLayout.SOUTH, tweetButton, -6, SpringLayout.NORTH, searchButton);
		appLayout_1.putConstraint(SpringLayout.NORTH, searchButton, 0, SpringLayout.NORTH, chatButton);
		appLayout_1.putConstraint(SpringLayout.WEST, saveButton, 0, SpringLayout.WEST, chatButton);
		appLayout_1.putConstraint(SpringLayout.WEST, chatButton, 472, SpringLayout.WEST, this);
		appLayout_1.putConstraint(SpringLayout.EAST, chatButton, -10, SpringLayout.EAST, this);
		appLayout_1.putConstraint(SpringLayout.SOUTH, loadButton, -6, SpringLayout.NORTH, chatButton);
		appLayout_1.putConstraint(SpringLayout.EAST, loadButton, -10, SpringLayout.EAST, this);
		appLayout_1.putConstraint(SpringLayout.SOUTH, chatButton, -10, SpringLayout.SOUTH, this);
		chatPane = new JScrollPane();
		appLayout_1.putConstraint(SpringLayout.NORTH, saveButton, 154, SpringLayout.SOUTH, chatPane);
		
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
		chatPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	}
	
	/**
	 * Sets certain settings for the panel on start
	 */
	private void setupPanel()
	{
		this.setLayout(appLayout_1);
		this.setBackground(Color.CYAN);
		this.add(chatButton);
		this.add(searchButton);
		this.add(saveButton);
		this.add(loadButton);
		this.add(tweetButton);
		this.add(inputField);
		this.add(infoLabel);
		this.add(infoLabel2);
		this.add(checkerButton);
		this.add(chatPane);
		chatArea = new JTextArea(5, 25);
		add(chatArea);
		
	}
	
	/**
	 * Sets positioning of GUI elements
	 */
	private void setupLayout()
	{
		appLayout_1.putConstraint(SpringLayout.NORTH, chatArea, 10, SpringLayout.NORTH, this);
		appLayout_1.putConstraint(SpringLayout.WEST, chatArea, 25, SpringLayout.WEST, this);
		appLayout_1.putConstraint(SpringLayout.SOUTH, chatArea, -14, SpringLayout.NORTH, checkerButton);
		appLayout_1.putConstraint(SpringLayout.EAST, chatArea, -25, SpringLayout.EAST, this);
		appLayout_1.putConstraint(SpringLayout.NORTH, chatPane, 50, SpringLayout.NORTH, this);
		appLayout_1.putConstraint(SpringLayout.WEST, chatPane, 30, SpringLayout.WEST, this);
		appLayout_1.putConstraint(SpringLayout.EAST, chatPane, -30, SpringLayout.EAST, this);
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
