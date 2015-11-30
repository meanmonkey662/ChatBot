package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatView;
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
	
	public ChatController()
	{
		String user = display.getAnswer("What is your name?");
		simpleBot = new Chatbot(user);
		display = new ChatView();
	}
	
	public void start()
	{
		display.displayResponse("Hello " + simpleBot.getUserName());
		chat();
	}
	
	private void chat()
	{
		String textFromUser = display.getAnswer("Talk to the chatbot");
		while(simpleBot.lengthChecker(textFromUser))
		{
			textFromUser = simpleBot.processConversation(textFromUser);
			
			textFromUser = display.getAnswer(textFromUser);
		}
				
	}
	
	public ChatView getChatView()
	{
		return display;
	}
	
	public ChatFrame getBaseFrame()
	{
		return baseFrame;
	}
	
	public Chatbot getChatbot()
	{
		return simpleBot;
	}
	

}
