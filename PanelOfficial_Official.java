import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**	The PanelOfficial_Official is the display panel for the create official account option of the official.	*/
public class PanelOfficial_Official extends JPanel {
	
	/**	Image icon of adding an account	*/
	private Image img_Add = new ImageIcon(SignIn_View.class.getResource("Res/Add.png")).getImage().getScaledInstance(145, 145, Image.SCALE_SMOOTH);
	/**	Username */
	private JTextField txtUsername;
	/**	Error message label	*/
	private JLabel lblErrorMessage = new JLabel("");
	/**	Confirm button panel	*/
	private JPanel pnlBtnConfirm;

	/**	The constructor creates the GUI create official panel	*/
	public PanelOfficial_Official() {
		
		setBackground(new Color(95, 158, 160));
		setBounds(0, 0, 575, 503);
		setLayout(null);
		
		JLabel lblTerminate = new JLabel("CREATE OFFICIAL ACCOUNT");
		lblTerminate.setBounds(21, 11, 367, 46);
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
		
		JLabel lblIconAdd = new JLabel("");
		lblIconAdd.setBounds(47, 100, 467, 186);
		lblIconAdd.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblIconAdd);
		lblIconAdd.setIcon(new ImageIcon(img_Add));
		
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
		
		lblErrorMessage.setBounds(47, 405, 487, 28);
		lblErrorMessage.setForeground(Color.ORANGE);
		lblErrorMessage.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblErrorMessage);

	}
	
	/**	This method removes the texts in the username and error message field.	*/
	public void remove() {
		lblErrorMessage.setText("");
		txtUsername.setText("");
	}
	
	/**	This method returns the textfield username.
	 * 
	 * 	@return username	*/
	public JTextField getTxtUsername() {
		return txtUsername;
	}
	
	/**	This method sets a success message in the label.	*/
	public void Success() {
		lblErrorMessage.setText("Account successfully created.");
	}
	
	/**	This method sets an error message in the label (if no user input).	*/
	public void Error() {
		lblErrorMessage.setText("Please input username.");
	}
	
	/**	This method checks whether the official wishes to create a new account or not.
	 * 
	 * 	@return true if offical wishes to create a new account, otherwise false	*/
	public boolean CreateNew() {
		if(JOptionPane.showConfirmDialog(null, "Do you wish to create a new account for this user?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0)
			return true;
		return false;
	}
	
	/** This method display the generated password if official user create a new account.
	 * 
	 * @param password the password generated to be displayed */
	public void passwordPopup(String password) {
		JOptionPane.showMessageDialog(null, "Password generated: " + password);
	}
	
	/**	This method sets an error message in the label (cannot create own account).	*/
	public void ErrorCannotCreateOwn() {
		lblErrorMessage.setText("Cannot create your current account.");
	}
	
	/**	This method sets an error message in the label (if already a government official account).	*/
	public void ErrorOfficial() {
		lblErrorMessage.setText("This account is already a government official account.");
	}
	
	/**	This method sets an error message in the label (if account is a tracer account).	*/
	public void ErrorTracer() {
		lblErrorMessage.setText("This account is a contact tracer account.");
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