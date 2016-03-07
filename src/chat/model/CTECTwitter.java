package chat.model;

import java.util.ArrayList;
import twitter4j.*;
import chat.controller.ChatController;

public class CTECTwitter 
{
	private ArrayList<Status>statusList;
	private ArrayList<String>wordsList;
	private Twitter chatbotTwitter;
	private ChatController baseController;
	
	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
		statusList = new ArrayList<Status>();
		wordsList = new ArrayList<String>();
		this.chatbotTwitter = TwitterFactory.getSingleton();
	}
	
	public void sendTweet(String message)
	{
		try
		{
			chatbotTwitter.updateStatus("Kyle Koch #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
			//if boolean method set variable to true here.
			
		}
		catch(TwitterException error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}
		
		
	}
}
