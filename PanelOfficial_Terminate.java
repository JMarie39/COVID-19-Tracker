import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**	The PanelOfficial_Terminate is the display panel for the terminate account option of the official.	*/
public class PanelOfficial_Terminate extends JPanel {
	
	/**	Image icon of terminating an account	*/
	private Image img_Terminate = new ImageIcon(SignIn_View.class.getResource("Res/Terminate.png")).getImage().getScaledInstance(145, 145, Image.SCALE_SMOOTH);
	/**	Username	*/
	private JTextField txtUsername;
	/**	Confirm button panel	*/
	private JPanel pnlBtnConfirm;
	/**	Error message */
	private JLabel lblErrorMessage = new JLabel("");

	/**	The constructor creates the GUI terminate account panel	*/
	public PanelOfficial_Terminate() {
		setBackground(new Color(95, 158, 160));
		setBounds(0, 0, 575, 503);
		setLayout(null);
		
		JLabel lblTerminate = new JLabel("TERMINATE ACCOUNT");
		lblTerminate.setBounds(21, 11, 375, 46);
		lblTerminate.setForeground(new Color(224, 255, 255));
		lblTerminate.setFont(new Font("DialogInput", Font.BOLD, 22));
		lblTerminate.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblTerminate);
		
		JPanel pnlUsername = new JPanel();
		pnlUsername.setBounds(148, 316, 332, 37);
		pnlUsername.setBackground(Color.WHITE);
		add(pnlUsername);
		pnlUsername.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("DialogInput", Font.PLAIN, 14));
		txtUsername.setBorder(null);
		txtUsername.setBounds(10, 0, 312, 37);
		pnlUsername.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblIconTerminate = new JLabel("");
		lblIconTerminate.setBounds(47, 100, 467, 186);
		lblIconTerminate.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblIconTerminate);
		lblIconTerminate.setIcon(new ImageIcon(img_Terminate));
		
		JLabel lblUsername = new JLabel("USERNAME : ");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setBounds(44, 325, 94, 28);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("DialogInput", Font.PLAIN, 14));
		add(lblUsername);
		
		pnlBtnConfirm = new JPanel();
		pnlBtnConfirm.addMouseListener(new PanelButtonMouseAdapter(pnlBtnConfirm));
		pnlBtnConfirm.setBounds(367, 466, 198, 26);
		pnlBtnConfirm.setLayout(null);
		pnlBtnConfirm.setBackground(new Color(0, 128, 128));
		add(pnlBtnConfirm);
		
		JLabel lblConfirm = new JLabel("CONFIRM");
		lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirm.setForeground(Color.WHITE);
		lblConfirm.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblConfirm.setBounds(10, 0, 178, 25);
		pnlBtnConfirm.add(lblConfirm);	
		
		lblErrorMessage.setBounds(94, 405, 440, 28);
		lblErrorMessage.setForeground(Color.ORANGE);
		lblErrorMessage.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblErrorMessage);
	}
	
	
	/**	This method removes the texts in the username and error message field.	*/
	public void remove() {
		txtUsername.setText("");
		lblErrorMessage.setText("");
	}
	
	/**	This method returns the textfield username.
	 * 
	 * 	@return username	*/
	public JTextField getTxtUsername() {
		return txtUsername;
	}

	/**	This method sets a success message in the label.	*/
	public void Success() {
		lblErrorMessage.setText("Account successfully terminated.");
	}
	
	/**	This method sets an error message in the label (if no user input).	*/
	public void Error() {
		lblErrorMessage.setText("Please input username.");
	}
	
	/**	This method sets an error message in the label (if username entered not found).	*/
	public void ErrorNotFound() {
		lblErrorMessage.setText("Username not found.");
	}
	
	/**	This method sets an error message in the label (cannot terminate own account).	*/
	public void ErrorCannotTerminateOwn() {
		lblErrorMessage.setText("Cannot terminate your own account.");
	}
	
	/**	This method sets an error message in the label (if already a citizen account).	*/
	public void ErrorCannotTerminateCitizen() {
		lblErrorMessage.setText("This account is already a citizen account.");
	}

	/** This method listens for focus events on the username text field
	 * 
	 * @param e the focus event that triggers the method */
	public void addUsernameListener(FocusListener e) {
		txtUsername.addFocusListener(e);
	}
	
	/** This method listens for mouse events on the confirm button
	 * 
	 * @param listenForConfirmButton the mouse event that triggers the method */
	public void addConfirmListener(MouseListener listenForConfirmButton) {
		pnlBtnConfirm.addMouseListener(listenForConfirmButton);
	}
}
