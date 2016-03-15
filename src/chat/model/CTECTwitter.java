package chat.model;

import java.util.ArrayList;

import twitter4j.*;
import chat.controller.ChatController;
public class CTECTwitter
{
	private ArrayList<Status> statusList;
	private ArrayList<String> wordsList;
	private Twitter chatBotTwitter;
	private ChatController baseController;
	
	
public CTECTwitter(ChatController baseController)
{
	this.baseController = baseController;
	statusList = new ArrayList<Status>();
	wordsList = new ArrayList<String>();
	this.chatBotTwitter = TwitterFactory.getSingleton();
}

public void sendTweet(String message)
{	
	try
	{
		chatBotTwitter.updateStatus("Dylan Rockne #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
	}
	catch(TwitterException error)
	{
		baseController.handleErrors(error.getErrorMessage());
	}
	
}

public void loadTweets(String twitterHandle) throws TwitterException
{
	Paging statusPage = new Paging(1, 200);
	int page = 1;
	while(page <= 10)
	{
		statusPage.setPage(page);
		statusList.addAll(chatBotTwitter.getUserTimeline(twitterHandle, statusPage));
		page++;
	}
	for(Status currentStatus : statusList)
	{
		String[] tweetText = currentStatus.getText().split("");
		for(String word : tweetText)
		{
			wordsList.add(removePunctuation(word).toLowerCase());
		}
				
	}
	removeCommonEnglishWords(wordsList);
	removeEmptyText();
}
	private void removeCommonEnglishWords(List<String>wordsList)
	{
		
	}
	
	private void removeEmptyText()
	{
		for (int spot = 0; spot < wordsList.size(); spot++)
		{
			if(wordsList.get(spot).equals(""))
			{
				wordsList.remove(spot);
				spot--;
			}
		}
	}
	
	private String removePunctuation(String currentString)
	{
		String punctuation = ".,'/!:;\"(){}^<>-";
		
		String scrubbedString = "";
		for (int i = 0; i < currentString.length(); i++)
		{
			if(punctuation.indexOf(currentString.charAt(i)) == -1)
			{
				 scrubbedString += currentString.charAt(i);
			}
		}
		return  scrubbedString;

		
	}
}

