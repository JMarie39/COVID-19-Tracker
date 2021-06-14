import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/** The SignIn_View is the display GUI for the sign in menu */
public class SignIn_View extends JFrame {
	
	/**	Image icon of the log-in logo	*/
	private Image img_Logo = new ImageIcon(SignIn_View.class.getResource("Res/Virus.png")).getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
	/**	Image icon of an user	*/
	private Image img_User = new ImageIcon(SignIn_View.class.getResource("Res/User.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
	/**	Image icon of a password	*/
	private Image img_Password = new ImageIcon(SignIn_View.class.getResource("Res/Lock.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
	/**	Image icon of a key	*/
	private Image img_SignIn = new ImageIcon(SignIn_View.class.getResource("Res/Key.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
	/**	Username 	*/
	private JTextField txtUsername;
	/**	Password	*/
	private JPasswordField txtPassword;
	/**	Error message	*/
	private JLabel lblErrorMessage = new JLabel("");
	/**	Sign in button panel	*/
	private JPanel pnlSignIn;
	/**	Sign up button panel	*/
	private JPanel pnlBtnSignUp;
	/**	Exit button panel	*/
	private JPanel pnlBtnExit;
	
	/**	The constructor creates the GUI sign in panel	*/
	public SignIn_View() {
		
		setUndecorated(true);
		setResizable(false);
		setBackground(new Color(224, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 525);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new LineBorder(new Color(0, 128, 128), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlUsername = new JPanel();
		pnlUsername.setBackground(Color.WHITE);
		pnlUsername.setBounds(240, 256, 301, 40);
		contentPane.add(pnlUsername);
		pnlUsername.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("DialogInput", Font.PLAIN, 15));
		txtUsername.setText("Username");
		txtUsername.setBounds(10, 11, 201, 20);
		pnlUsername.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblIconUser = new JLabel("");
		lblIconUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconUser.setBounds(221, 0, 70, 40);
		lblIconUser.setIcon(new ImageIcon(img_User));
		pnlUsername.add(lblIconUser);
		
		JPanel pnlPassword = new JPanel();
		pnlPassword.setBackground(Color.WHITE);
		pnlPassword.setBounds(240, 309, 301, 40);
		contentPane.add(pnlPassword);
		pnlPassword.setLayout(null);
		
		txtPassword = new JPasswordField();
		txtPassword.setBorder(null);
		txtPassword.setEchoChar((char)0);
		txtPassword.setFont(new Font("DialogInput", Font.PLAIN, 15));
		txtPassword.setText("Password");
		txtPassword.setBounds(10, 11, 201, 20);
		pnlPassword.add(txtPassword);
		
		JLabel lblIconPass = new JLabel("");
		lblIconPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconPass.setBounds(221, 0, 70, 40);
		lblIconPass.setIcon(new ImageIcon(img_Password));
		pnlPassword.add(lblIconPass);
		
		pnlBtnExit = new JPanel();
		pnlBtnExit.addMouseListener(new PanelButtonMouseAdapter(pnlBtnExit));
		pnlBtnExit.setForeground(Color.WHITE);
		pnlBtnExit.setBackground(new Color(0, 128, 128));
		pnlBtnExit.setBounds(240, 455, 144, 32);
		contentPane.add(pnlBtnExit);
		pnlBtnExit.setLayout(null);
		
		JLabel lblExit = new JLabel("EXIT");
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setBounds(10, 0, 130, 32);
		lblExit.setForeground(Color.WHITE);
		lblExit.setFont(new Font("DialogInput", Font.PLAIN, 15));
		pnlBtnExit.add(lblExit);
		
		pnlSignIn = new JPanel();
		pnlSignIn.addMouseListener(new PanelButtonMouseAdapter(pnlSignIn));
		pnlSignIn.setForeground(Color.WHITE);
		pnlSignIn.setBackground(new Color(0, 128, 128));
		pnlSignIn.setBounds(240, 412, 301, 32);
		contentPane.add(pnlSignIn);
		pnlSignIn.setLayout(null);

		JLabel lblBtnSignIn = new JLabel("SIGN IN");
		lblBtnSignIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtnSignIn.setBounds(10, 0, 287, 32);
		lblBtnSignIn.setForeground(Color.WHITE);
		lblBtnSignIn.setFont(new Font("DialogInput", Font.PLAIN, 15));
		pnlSignIn.add(lblBtnSignIn);
		
		JLabel lblIconSignIn = new JLabel("");
		lblIconSignIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconSignIn.setBounds(38, 0, 63, 32);
		lblIconSignIn.setIcon(new ImageIcon(img_SignIn));
		pnlSignIn.add(lblIconSignIn);
		
		pnlBtnSignUp = new JPanel();
		pnlBtnSignUp.addMouseListener(new PanelButtonMouseAdapter(pnlBtnSignUp));
		pnlBtnSignUp.setForeground(Color.WHITE);
		pnlBtnSignUp.setBackground(new Color(0, 128, 128));
		pnlBtnSignUp.setBounds(397, 455, 144, 32);
		contentPane.add(pnlBtnSignUp);
		pnlBtnSignUp.setLayout(null);
		
		JLabel lblSignUp = new JLabel("SIGN UP");
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setBounds(10, 0, 130, 32);
		lblSignUp.setForeground(Color.WHITE);
		lblSignUp.setFont(new Font("DialogInput", Font.PLAIN, 15));
		pnlBtnSignUp.add(lblSignUp);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setBounds(240, 25, 301, 208);
		contentPane.add(lblIconLogo);
		lblIconLogo.setIcon(new ImageIcon(img_Logo));
		
		lblErrorMessage.setForeground(Color.ORANGE);
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMessage.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblErrorMessage.setBounds(240, 373, 301, 28);
		contentPane.add(lblErrorMessage);
		
		JLabel lblCreated = new JLabel("BY : AGULTO & DURIMAN");
		lblCreated.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCreated.setForeground(new Color(153, 255, 255));
		lblCreated.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		lblCreated.setBounds(586, 497, 197, 28);
		contentPane.add(lblCreated);
		
		setLocationRelativeTo(null);
	}
	
	/**	This method returns the textfield username.
	 * 
	 * 	@return username	*/
	public JTextField getTxtUsername() {
		return txtUsername;
	}

	/**	This method returns the passwordfield password.
	 * 
	 * 	@return password	*/
	public JPasswordField getTxtPassword() {
		return txtPassword;
	}
	
	/**	This method returns the username text.
	 * 
	 * 	@return username	*/
	public String getUsername() {
		return txtUsername.getText();
	}
	
	/**	This method returns the password text.
	 * 
	 * 	@return password	*/
	@SuppressWarnings("deprecation")
	public String getPassword() {
		return txtPassword.getText();
	}

	/**	This method sets a success message in the label.	*/
	public void Success() {
		lblErrorMessage.setText("Successfully logged in.");
	}
	
	/**	This method sets an error message in the label.	*/
	public void Error1() {
		lblErrorMessage.setText("Please input all requirements.");
	}
	
	/**	This method sets an error message in the label.	*/
	public void Error2() {
		lblErrorMessage.setText("Invalid username or password.");
	}
	
	/**	This method checks the confirmation.
	 * 
	 * 	@return true if confirmed, otherwise false	*/
	public boolean Confirmation() {
		if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0)
			return true;
		return false;
	}
	
	/** This method listens for focus events on the username text field
	 * 
	 * @param e the focus event that triggers the method */
	public void addUsernameListener(FocusListener e) {
		txtUsername.addFocusListener(e);
	}
	
	/** This method listens for focus events on the password text field
	 * 
	 * @param e the focus event that triggers the method */
	public void addPasswordListener(FocusListener e) {
		txtPassword.addFocusListener(e);
	}
	
	/** This method listens for mouse events on the sign in button
	 * 
	 * @param listenForSignInButton the mouse event that triggers the method */
	public void addSignInListener(MouseListener listenForSignInButton) {
		pnlSignIn.addMouseListener(listenForSignInButton);
	}
	
	/** This method listens for mouse events on the sign up button
	 * 
	 * @param listenForSignUpButton the mouse event that triggers the method */
	public void addSignUpListener(MouseListener listenForSignUpButton) {
		pnlBtnSignUp.addMouseListener(listenForSignUpButton);
	}
	
	/** This method listens for mouse events on the exit button
	 * 
	 * @param listenForExitButton the mouse event that triggers the method */
	public void addExitListener(MouseListener listenForExitButton) {
		pnlBtnExit.addMouseListener(listenForExitButton);
	}
}