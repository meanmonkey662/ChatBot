package chat.view;

import javax.swing.JFrame;
import chat.controller.ChatController;

public class ChatFrame extends JFrame
{
	private ChatController baseController;
	private ChatPanel basePanel;
/**
 * sets the baseFrame up
 * @param baseController
 */
	public ChatFrame(ChatController baseController)
	{
		this.baseController = baseController;
		basePanel = new ChatPanel(baseController);
		setupFrame();
	}
/**
 * sets frame size, visibility, title, and initializes the base panel.
 */
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setResizable(false);
		this.setTitle("ChatBot");
		this.setSize(500,500);
		this.setVisible(true);
	}
/**
 * returns baseController
 * @return returns base controller.
 */
	public ChatController getBaseController()
	{
		return baseController;
		}
	
		}