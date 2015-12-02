package chat.view;

import javax.swing.JPanel;

import java.awt.event.*;


import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import javax.swing.JLabel;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import chat.controller.ChatController;


import java.awt.Color;


	public class ChatPanel extends JPanel
	{
		private ChatController baseController;
		private SpringLayout baseLayout;
		private JButton submitButton;
		private JButton submitButton_1;
		private JTextArea chatArea;
		private JTextField typingField;
		private JLabel promptLabel;


	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		chatArea = new JTextArea(10,30);
		baseLayout = new SpringLayout();
		submitButton = new JButton("Next");
		typingField= new JTextField(30);
		promptLabel = new JLabel("typing to the chatbot oooooff doooommm");
		submitButton_1 = new JButton("Submit");

	
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.blue);
		this.add(chatArea);
		this.add(typingField);
		this.add(submitButton_1);
		this.add(promptLabel);
		typingField.setToolTipText("Type here");
		chatArea.setEnabled(false);
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, submitButton_1, 6, SpringLayout.SOUTH, chatArea);
		baseLayout.putConstraint(SpringLayout.WEST, submitButton_1, 77, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, submitButton_1, 333, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, typingField, 0, SpringLayout.WEST, chatArea);
		baseLayout.putConstraint(SpringLayout.SOUTH, typingField, -6, SpringLayout.NORTH, chatArea);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 72, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 10, SpringLayout.WEST, this);
		
	}

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
	
	public JTextField getTextField()
	{
		return typingField;
	}
}