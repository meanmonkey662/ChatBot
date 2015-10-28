package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatView;
/**
 * Controller for the Chatbot project. Keeps popping up.
 * @author kkoc6943
 * @version 1.3 
 */
public class ChatController
{
	private Chatbot simpleBot;
	private ChatView display;
	
	public ChatController()
	{
		display = new ChatView();
		String user = display.getAnswer("What is your name?");
		simpleBot = new Chatbot(user);
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
			if(simpleBot.contentChecker(textFromUser))
			{
				display.displayResponse("Wow, i had no idea you loved " + simpleBot.getContent());
			}
			
			
			textFromUser = display.getAnswer("wow" + textFromUser);
		}
				
	}
}
