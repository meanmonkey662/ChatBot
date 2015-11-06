package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided. Students will complete methods as part
 * of the project.
 * @author Kyle Koch
 * @version 1.1 10/23/15 Repaired the getUserName method and initialized the userName in the constructor.
 * Repaired the getContent method. Completed the contentChecker method.
 */
public class Chatbot
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;
	
	/**
	 * Creates an instance of the Chatbot with the supplied username.
	 * @param userName The username for the chatbot.
	 */
	public Chatbot(String userName)
	{
		this.userName = userName;
		this.memesList = new ArrayList <String>();
		this.politicalTopicList = new ArrayList<String>();
		this.content = "Snowboarding";
		
		buildMemesList();
		buildPoliticalTopicsList();
	}
	
	private void buildMemesList()
	{
		this.memesList.add("Doge");
		this.memesList.add("Done with life Kermit");
		this.memesList.add("Ladies get in line");
		this.memesList.add("Cute animals");
		this.memesList.add("Most interesting man in the world");
		this.memesList.add("Funny girl");
		this.memesList.add("Best cry ever");
		this.memesList.add("Funny squirrel");
		this.memesList.add("Dexter");
		this.memesList.add("Funny animal");
		
		
	}
	
	private void buildPoliticalTopicsList()
	{
		
	}
	
	/**
	 * Checks the length of the supplied string. Returns false if the supplied String is empty or null,
	 * otherwise returns true. 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;
		if(currentInput != null)
		{
			if(currentInput.length() >= 1)
			{
				return true;
			}
		}
		
		if(currentInput != null && currentInput.length() > 0)
		{
			hasLength = true;
		}
		
		return hasLength;
	}
	
	/**
	 * Checks if the supplied String matches the content area for this Chatbot instance.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether it matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;
		
		if(currentInput.contains(content))
		{
			hasContent = true;
		}
		
		return hasContent;
		
	}
	
	/**
	 * Checks if supplied String matches ANY of the topics in the politicalTopicsList. Returns
	 * true if it does find a match and false if it does not match.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{	
		String nextConversation = "Lets talk politics";
		int randomTopic = (int) (Math.random() *5);
		switch(randomTopic)
		{
		case 0 :
			if(politicalTopicChecker(currentInput))
			{
				nextConversation = ""
			}
		}
		
		
		return false;
	}
	
	
	/**
	 * Checks to see that the supplied String value is in the current memesList variable.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
	
	
	public boolean memeChecker(String currentInput)
	{
		boolean hasMemeList = false;
		if(memesList.contains(currentInput))
		{
			hasMemeList = true;
		}
		return false;
	}
	
	public boolean quitChecker(String currentInput)
	{
		boolean quitCheck = false;
		
		return quitCheck;
		
	}
	
	public String processConversation(String currentInput)
	{
		String nextConversation = "what else would you like to talk about?";
		int randomTopic = (int) (Math.random() *5); //Generates a random number between 0 and 4
		
		switch (randomTopic)
		{
			case 0:
				if(contentChecker(currentInput))
				{
					nextConversation = "hey you talked Snowboarding, that is neat! What else do you like?";
				}
				break;
			case 1:
				if(memeChecker(currentInput))
				{
					nextConversation = "Thats an awesome meme! Wow! What is your favorite food?";
				}
				break;
			case 2:
				if(politicalTopicChecker(currentInput))
				{
					nextConversation = "my favorite is souls, what is your favorite color?";
				}
				break;
			case 3:
				//Choose your own text here 
				if(currentInput.length() > 23)
				{
					nextConversation = "Thats neat! Where do you live?";
				}
				break;
			case 4:
				//Random topic for chat here
				nextConversation = "Hmm, saved.. Where do you sleep?";
				break;
			default:
				//Never will happen!
				nextConversation = "Okay ;), do you live alone?";
				break;
		}
		return nextConversation;
	}
	
	/**
	 * Returns the username of this Chatbot instance.
	 * @return The username of the Chatbot.
	 */
	public String getUserName()
	{
		return userName;
	}
	
	/**
	 * Returns the content area for this Chatbot instance.
	 * @return The content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}
	
	/**
	 * Getter method for the memesList object.
	 * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return null;
	}
	
	/**
	 * Getter method for the politicalTopicList object.
	 * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		
		return null;
	}
	
	/**
	 * Updates the content area for this Chatbot instance.
	 * @param content The updated value for the content area.
	 */
	public void setContent(String content)
	{
		
	}
}