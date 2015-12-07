package chat.controller;

import chat.model.Chatbot;
import chat.view.*;
import chat.view.ChatFrame;
/**
 * Controller for the Chatbot project. Keeps popping up.
 * @author kkoc6943
 * @version 1.3 
 */
public class ChatController
{
	private Chatbot simpleBot;
	private ChatView display;
	private ChatFrame baseFrame;
	/**
	 * Shows the display
	 */
	public ChatController()
	{
		display = new ChatView();
		baseFrame = new ChatFrame(this);
		String user = display.getAnswer("What is your name?");
		simpleBot = new Chatbot(user);
		
	}
	/**
	 * show the username and greets them.
	 */
	public void start()
	{
		display.displayResponse("Hello " + simpleBot.getUserName());
		//chat();
	}
	/**
	 * shows the botResponse and has a shutdown.
	 */
	private void chat()
	{
		String textFromUser = display.getAnswer("Talk to the chatbot");
		while(simpleBot.lengthChecker(textFromUser))
		{
			textFromUser = simpleBot.processConversation(textFromUser);
			
			textFromUser = display.getAnswer(textFromUser);
		}
				
	}
	/**
	 * shows botResponse and has a shutdown
	 * @param conversation
	 * @return
	 */
	public String fromUserToChatbot(String conversation)
	{
		String botResponse = "";
		
		if(simpleBot.quitChecker(conversation))
		{
			shutDown();
		}
		botResponse = simpleBot.processConversation(conversation);
		
		return botResponse;
	}
	/**
	 * shuts down the program
	 */
	private void shutDown()
	{
		display.displayResponse("Goodbye, " + simpleBot.getUserName() + " it has been my pleasureto talk to you");
		System.exit(0);
	}
	/**
	 * getters and setters
	 * @return
	 */
	public ChatView getChatView()
	{
		return display;
	}
	/**
	 * getters and setters
	 * @return
	 */
	public ChatFrame getBaseFrame()
	{
		return baseFrame;
	}
	/**
	 * getters and setters
	 * @return
	 */
	public Chatbot getChatbot()
	{
		return simpleBot;
	}
	

}
