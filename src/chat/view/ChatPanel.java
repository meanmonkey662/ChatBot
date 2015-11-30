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
		private JTextArea chatArea;
		private JTextField typingField;
		private JLabel promptLabel;


	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		submitButton = new JButton("Next");
		typingField= new JTextField("Enter Answer here");
		promptLabel = new JLabel("");
		submitButton = new JButton("adsa");

		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.WHITE);
		this.add(chatArea);
		this.add(typingField);
		this.add(submitButton);
		this.add(promptLabel);
		typingField.setToolTipText("Type here");
		chatArea.setEnabled(false);
	}

	private void setupLayout()
	{

	}

	private void setupListeners()
	{

	}
}