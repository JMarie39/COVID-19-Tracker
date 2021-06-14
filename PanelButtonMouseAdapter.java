import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

/**	The PanelButtonMouseAdapter is for the effects of the panels	*/
public class PanelButtonMouseAdapter extends MouseAdapter {
		
		/**	The constructor initializes the panel, based on the given parameters.	
		 * 
		 * 	@param panel of a certain panel button	*/
		PanelButtonMouseAdapter (JPanel panel) {
			this.panel = panel;
		}
		/** This method checks if a mouse entered the area of a specific asset
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(0, 113, 128));
		}
		/** This method checks if a mouse exited the area of a specific asset
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(0, 128, 128));
		}
		/** This method checks if a mouse is pressed on a specific asset
		 * 
		 * @param e the mouse event that triggers the method */  
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(60, 179, 113));
		}
		/** This method checks if a mouse is released on a specific asset
		 * 
		 * @param e the mouse event that triggers the method */ 
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(0, 128, 128));
		}
		
		/**	Panel */
		JPanel panel;
	}