package chat.view;

import javax.swing.JPanel;

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import chat.controller.ChatController;

import java.awt.Color;

/**
 * calls buttons, Jlabel, text area, and controller.
 * @author kkoc6943
 *
 */
	public class ChatPanel extends JPanel
	{
		private ChatController baseController;
		private JScrollPane textPane;
		private SpringLayout baseLayout;
		private SpringLayout baseLayout_1;
		private JButton submitButton;
		private JButton submitButton_1;
		private JTextArea chatArea;
		private JTextField typingField;
		private JLabel promptLabel;

/**
 * sets layout data set
 * @param baseController
 */
	public ChatPanel(ChatController baseController)
	{
		baseLayout = new SpringLayout();
		this.baseController = baseController;
		chatArea = new JTextArea(10,30);
		baseLayout_1 = new SpringLayout();
		submitButton = new JButton("Next");
		typingField= new JTextField(30);
		promptLabel = new JLabel("typing to the chatbot oooooff doooommm");
		submitButton_1 = new JButton("Submit");

		setupChatPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupChatPane()
	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
		textPane = new JScrollPane(chatArea);
		baseLayout_1.putConstraint(SpringLayout.SOUTH, textPane, -20, SpringLayout.SOUTH, this);
		textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		textPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	

/**
 * adds the components to the JPanel
 */
	private void setupPanel()
	{
		this.setLayout(baseLayout_1);
		this.setBackground(Color.blue);
		this.add(textPane);
		this.add(typingField);
		this.add(submitButton_1);
		this.add(promptLabel);
		typingField.setToolTipText("Type here");
		chatArea.setEnabled(false);
	}
/**
 * This is where you dump the layout garbage when you arrange components in the builder window.
 */
	private void setupLayout()
	{
		baseLayout_1.putConstraint(SpringLayout.NORTH, submitButton_1, 6, SpringLayout.SOUTH, chatArea);
		baseLayout_1.putConstraint(SpringLayout.WEST, submitButton_1, 77, SpringLayout.WEST, this);
		baseLayout_1.putConstraint(SpringLayout.EAST, submitButton_1, 333, SpringLayout.WEST, this);
		baseLayout_1.putConstraint(SpringLayout.WEST, typingField, 0, SpringLayout.WEST, chatArea);
		baseLayout_1.putConstraint(SpringLayout.SOUTH, typingField, -6, SpringLayout.NORTH, chatArea);
		baseLayout_1.putConstraint(SpringLayout.NORTH, chatArea, 72, SpringLayout.NORTH, this);
		baseLayout_1.putConstraint(SpringLayout.WEST, chatArea, 10, SpringLayout.WEST, this);
		
	}
/**
 * sets listeners
 */
	private void setupListeners()
	{
		submitButton_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				//Grab user text
				//send the text to the controller
				//display user text
				//give text to chatbot to process
				//get chatbots answer
				//display answer
				//clear user field
				String userText = typingField.getText();
				String response = baseController.fromUserToChatbot(userText);
				chatArea.append("\nUser: " + userText);
				chatArea.append("\nChatbot: " + response);
				typingField.setText("");
			}
		});
	}
	/**
	 * puts the text field on the Jframe
	 * @return
	 */
	public JTextField getTextField()
	{
		return typingField;
	}
}