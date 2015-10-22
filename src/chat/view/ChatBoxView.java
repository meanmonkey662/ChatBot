package chat.view;

import javax.swing.JOptionPane;

/**
 * 
 * @author kkoc6943
 *
 */
public class ChatBoxView 
{
	
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

