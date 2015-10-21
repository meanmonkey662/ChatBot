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
	 * 
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
		 * 
		 * @param input
		 */
	public void displayResponse(String input)
	{
		JOptionPane.showMessageDialog(null, input);
	}
}

