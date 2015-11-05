package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 * 
 * @author kkoc6943
 *
 */
public class ChatView 
{
	private String windowMessage;
	private ImageIcon chatIcon;
	
	public ChatView()
	{
		windowMessage = "This message brought to you by the wonderful chatbot! ";
		chatIcon = new ImageIcon(getClass().getResource("images/chatbot.jpg"));
	}
	
	/**
	 * Displays a gui popup for collecting user text with the supplied String.
	 * @param input
	 * @return
	 */
		public String getAnswer(String input)
		{
			String userInput = "";
					
			userInput = JOptionPane.showInputDialog(null, input);
			
			return userInput;
		}
		
		/**
		 * Displays a String to the user with a standard popup.
		 * @param input
		 */
	public void displayResponse(String input)
	{
		JOptionPane.showMessageDialog(null, input);
	}
}

