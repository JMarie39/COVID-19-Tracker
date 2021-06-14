import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

/**	The CreateAccount_View is the display GUI of creating an account.	*/
public class CreateAccount_View extends JFrame {

	/**	Username	*/
	private JTextField txtUsername;
	/**	Password field	*/
	private JTextField txtPassword;
	/**	First name	*/
	private JTextField txtFirst;
	/**	Middle name	*/
	private JTextField txtMiddle;
	/**	Surname	*/
	private JTextField txtLast;
	/**	Home address	*/
	private JTextField txtHome;
	/**	Office address	*/
	private JTextField txtOffice;
	/**	Email address	*/
	private JTextField txtEmail;
	/**	Birth month	*/
	private JTextField txtMonth;
	/**	Birth day	*/
	private JTextField txtDay;
	/**	Birth year	*/
	private JTextField txtYear;
	/**	Phone number	*/
	private JTextField txtPhone;
	/**	Error message label	*/
	private JLabel lblErrorMessage = new JLabel("");
	/**	Error message label	for the username	*/
	private JLabel lblErrorUsername = new JLabel("");
	/**	Error message label	for the password	*/
	private JLabel lblErrorPassword = new JLabel("");
	/**	Back panel	*/
	private JPanel pnlBtnBack;
	/**	Confirm panel button */
	private JPanel pnlBtnConfirm;

	/**	The constructor creates the GUI of creating an account	*/
	public CreateAccount_View() {
		setUndecorated(true);
		setResizable(false);
		setAlwaysOnTop(true);
		setBackground(new Color(0, 128, 128));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 525);
		
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new LineBorder(new Color(0, 128, 128), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pnlBtnBack = new JPanel();
		pnlBtnBack.addMouseListener(new PanelButtonMouseAdapter(pnlBtnBack));
		pnlBtnBack.setLayout(null);
		pnlBtnBack.setForeground(Color.WHITE);
		pnlBtnBack.setBackground(new Color(0, 128, 128));
		pnlBtnBack.setBounds(10, 482, 142, 32);
		contentPane.add(pnlBtnBack);
		
		JLabel lblBack = new JLabel("BACK");
		lblBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblBack.setForeground(Color.WHITE);
		lblBack.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblBack.setBounds(10, 5, 122, 21);
		pnlBtnBack.add(lblBack);
		
		pnlBtnConfirm = new JPanel();
		pnlBtnConfirm.addMouseListener(new PanelButtonMouseAdapter(pnlBtnConfirm));
		pnlBtnConfirm.setLayout(null);
		pnlBtnConfirm.setForeground(Color.WHITE);
		pnlBtnConfirm.setBackground(new Color(0, 128, 128));
		pnlBtnConfirm.setBounds(641, 482, 142, 32);
		contentPane.add(pnlBtnConfirm);
		
		JLabel lblConfirm = new JLabel("CONFIRM");
		lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirm.setForeground(Color.WHITE);
		lblConfirm.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblConfirm.setBounds(10, 5, 122, 21);
		pnlBtnConfirm.add(lblConfirm);
		
		JPanel pnlAccount = new JPanel();
		pnlAccount.setBorder(new MatteBorder(5, 0, 5, 0, (Color) new Color(173, 216, 230)));
		pnlAccount.setBackground(new Color(95, 158, 160));
		pnlAccount.setForeground(Color.WHITE);
		pnlAccount.setBounds(10, 25, 773, 43);
		contentPane.add(pnlAccount);
		pnlAccount.setLayout(null);
		
		JLabel lblCreateAccount = new JLabel("CREATE ACCOUNT");
		lblCreateAccount.setForeground(new Color(255, 255, 255));
		lblCreateAccount.setFont(new Font("DialogInput", Font.BOLD | Font.ITALIC, 23));
		lblCreateAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAccount.setBounds(10, 0, 763, 41);
		pnlAccount.add(lblCreateAccount);
		
		JPanel pnlUsername = new JPanel();
		pnlUsername.setBackground(new Color(255, 255, 255));
		pnlUsername.setBounds(138, 79, 354, 25);
		contentPane.add(pnlUsername);
		pnlUsername.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("DialogInput", Font.PLAIN, 16));
		txtUsername.setBackground(new Color(255, 255, 255));
		txtUsername.setBounds(10, 0, 334, 25);
		pnlUsername.add(txtUsername);
		txtUsername.setColumns(10);
		
		JPanel pnlPassword = new JPanel();
		pnlPassword.setBackground(new Color(255, 255, 255));
		pnlPassword.setBounds(138, 117, 354, 25);
		contentPane.add(pnlPassword);
		pnlPassword.setLayout(null);
		
		txtPassword = new JTextField();
		txtPassword.setBorder(null);
		txtPassword.setFont(new Font("DialogInput", Font.PLAIN, 16));
		txtPassword.setColumns(10);
		txtPassword.setBackground(Color.WHITE);
		txtPassword.setBounds(10, 0, 334, 25);
		pnlPassword.add(txtPassword);
		
		JLabel lblUsername = new JLabel("USERNAME :");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setBackground(new Color(255, 255, 255));
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setBounds(20, 81, 96, 25);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setBackground(new Color(255, 255, 255));
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(20, 117, 96, 25);
		contentPane.add(lblPassword);
		
		JPanel pnlInfo = new JPanel();
		pnlInfo.setLayout(null);
		pnlInfo.setForeground(Color.WHITE);
		pnlInfo.setBorder(new MatteBorder(5, 0, 5, 0, (Color) new Color(173, 216, 230)));
		pnlInfo.setBackground(new Color(95, 158, 160));
		pnlInfo.setBounds(10, 151, 773, 43);
		contentPane.add(pnlInfo);
		
		JLabel lblPersonalInformation = new JLabel("PERSONAL INFORMATION");
		lblPersonalInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonalInformation.setForeground(Color.WHITE);
		lblPersonalInformation.setFont(new Font("DialogInput", Font.BOLD | Font.ITALIC, 23));
		lblPersonalInformation.setBounds(10, 0, 763, 41);
		pnlInfo.add(lblPersonalInformation);
		
		JLabel lblFirstName = new JLabel("FIRST NAME :");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setBackground(Color.WHITE);
		lblFirstName.setBounds(20, 207, 96, 25);
		contentPane.add(lblFirstName);
		
		JPanel pnlFirst = new JPanel();
		pnlFirst.setBackground(Color.WHITE);
		pnlFirst.setBounds(138, 207, 354, 25);
		contentPane.add(pnlFirst);
		pnlFirst.setLayout(null);
		
		txtFirst = new JTextField();
		txtFirst.setBorder(null);
		txtFirst.setFont(new Font("DialogInput", Font.PLAIN, 16));
		txtFirst.setColumns(10);
		txtFirst.setBackground(Color.WHITE);
		txtFirst.setBounds(10, 0, 334, 25);
		pnlFirst.add(txtFirst);
		
		JLabel lblMiddleName = new JLabel("MIDDLE NAME :");
		lblMiddleName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMiddleName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMiddleName.setForeground(Color.WHITE);
		lblMiddleName.setBackground(Color.WHITE);
		lblMiddleName.setBounds(20, 243, 96, 25);
		contentPane.add(lblMiddleName);
		
		JPanel pnlMiddle = new JPanel();
		pnlMiddle.setBackground(Color.WHITE);
		pnlMiddle.setBounds(138, 243, 354, 25);
		contentPane.add(pnlMiddle);
		pnlMiddle.setLayout(null);
		
		txtMiddle = new JTextField();
		txtMiddle.setBorder(null);
		txtMiddle.setFont(new Font("DialogInput", Font.PLAIN, 16));
		txtMiddle.setColumns(10);
		txtMiddle.setBackground(Color.WHITE);
		txtMiddle.setBounds(10, 0, 334, 25);
		pnlMiddle.add(txtMiddle);
		
		JPanel pnlLast = new JPanel();
		pnlLast.setBackground(Color.WHITE);
		pnlLast.setBounds(138, 279, 354, 25);
		contentPane.add(pnlLast);
		pnlLast.setLayout(null);
		
		txtLast = new JTextField();
		txtLast.setBorder(null);
		txtLast.setFont(new Font("DialogInput", Font.PLAIN, 16));
		txtLast.setColumns(10);
		txtLast.setBackground(Color.WHITE);
		txtLast.setBounds(10, 0, 334, 25);
		pnlLast.add(txtLast);
		
		JLabel lblSurname = new JLabel("SURNAME :");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSurname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSurname.setForeground(Color.WHITE);
		lblSurname.setBackground(Color.WHITE);
		lblSurname.setBounds(20, 279, 96, 25);
		contentPane.add(lblSurname);
		
		JLabel lblMonth = new JLabel("BIRTH MONTH : ");
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMonth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMonth.setForeground(Color.WHITE);
		lblMonth.setBackground(Color.WHITE);
		lblMonth.setBounds(504, 205, 96, 25);
		contentPane.add(lblMonth);
		
		JPanel pnlDay = new JPanel();
		pnlDay.setBackground(Color.WHITE);
		pnlDay.setBounds(610, 241, 150, 25);
		contentPane.add(pnlDay);
		pnlDay.setLayout(null);
		
		txtDay = new JTextField();
		txtDay.setBounds(10, 0, 134, 25);
		pnlDay.add(txtDay);
		txtDay.setFont(new Font("DialogInput", Font.PLAIN, 16));
		txtDay.setColumns(10);
		txtDay.setBorder(null);
		txtDay.setBackground(Color.WHITE);
		
		JLabel lblDay = new JLabel("BIRTH DAY : ");
		lblDay.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDay.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDay.setForeground(Color.WHITE);
		lblDay.setBackground(Color.WHITE);
		lblDay.setBounds(504, 243, 96, 25);
		contentPane.add(lblDay);
		
		JLabel lblYear = new JLabel("BIRTH YEAR : ");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblYear.setHorizontalAlignment(SwingConstants.RIGHT);
		lblYear.setForeground(Color.WHITE);
		lblYear.setBackground(Color.WHITE);
		lblYear.setBounds(502, 279, 96, 25);
		contentPane.add(lblYear);
		
		JPanel pnlYear = new JPanel();
		pnlYear.setBackground(Color.WHITE);
		pnlYear.setBounds(610, 277, 150, 25);
		contentPane.add(pnlYear);
		pnlYear.setLayout(null);
		
		txtYear = new JTextField();
		txtYear.setFont(new Font("DialogInput", Font.PLAIN, 16));
		txtYear.setColumns(10);
		txtYear.setBorder(null);
		txtYear.setBackground(Color.WHITE);
		txtYear.setBounds(10, 0, 134, 25);
		pnlYear.add(txtYear);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new MatteBorder(5, 0, 5, 0, (Color) new Color(173, 216, 230)));
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(10, 313, 773, 43);
		contentPane.add(panel);
		
		JLabel lblContactInformation = new JLabel("CONTACT INFORMATION");
		lblContactInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactInformation.setForeground(Color.WHITE);
		lblContactInformation.setFont(new Font("DialogInput", Font.BOLD | Font.ITALIC, 23));
		lblContactInformation.setBounds(10, 0, 763, 41);
		panel.add(lblContactInformation);
		
		JLabel lblHomeAddress = new JLabel("HOME ADDRESS : ");
		lblHomeAddress.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblHomeAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHomeAddress.setForeground(Color.WHITE);
		lblHomeAddress.setBackground(Color.WHITE);
		lblHomeAddress.setBounds(20, 369, 96, 25);
		contentPane.add(lblHomeAddress);
		
		JLabel lblOfficeAddress = new JLabel("OFFICE ADDRESS : ");
		lblOfficeAddress.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOfficeAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOfficeAddress.setForeground(Color.WHITE);
		lblOfficeAddress.setBackground(Color.WHITE);
		lblOfficeAddress.setBounds(20, 405, 96, 25);
		contentPane.add(lblOfficeAddress);
		
		JLabel lblEmailAddress = new JLabel("EMAIL ADDRESS : ");
		lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmailAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailAddress.setForeground(Color.WHITE);
		lblEmailAddress.setBackground(Color.WHITE);
		lblEmailAddress.setBounds(20, 441, 96, 25);
		contentPane.add(lblEmailAddress);
		
		JPanel pnlEmail = new JPanel();
		pnlEmail.setBackground(Color.WHITE);
		pnlEmail.setBounds(138, 441, 354, 25);
		contentPane.add(pnlEmail);
		pnlEmail.setLayout(null);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("DialogInput", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		txtEmail.setBackground(Color.WHITE);
		txtEmail.setBounds(10, 0, 334, 25);
		pnlEmail.add(txtEmail);
		
		JPanel pnlOffice = new JPanel();
		pnlOffice.setBackground(Color.WHITE);
		pnlOffice.setBounds(138, 405, 354, 25);
		contentPane.add(pnlOffice);
		pnlOffice.setLayout(null);
		
		txtOffice = new JTextField();
		txtOffice.setFont(new Font("DialogInput", Font.PLAIN, 16));
		txtOffice.setColumns(10);
		txtOffice.setBorder(null);
		txtOffice.setBackground(Color.WHITE);
		txtOffice.setBounds(10, 0, 334, 25);
		pnlOffice.add(txtOffice);
		
		JPanel pnlHome = new JPanel();
		pnlHome.setBackground(Color.WHITE);
		pnlHome.setBounds(138, 369, 354, 25);
		contentPane.add(pnlHome);
		pnlHome.setLayout(null);
		
		txtHome = new JTextField();
		txtHome.setFont(new Font("DialogInput", Font.PLAIN, 16));
		txtHome.setColumns(10);
		txtHome.setBorder(null);
		txtHome.setBackground(Color.WHITE);
		txtHome.setBounds(10, 0, 334, 25);
		pnlHome.add(txtHome);
		
		JPanel pnlPhone = new JPanel();
		pnlPhone.setBackground(Color.WHITE);
		pnlPhone.setBounds(610, 367, 150, 25);
		contentPane.add(pnlPhone);
		pnlPhone.setLayout(null);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("DialogInput", Font.PLAIN, 16));
		txtPhone.setColumns(10);
		txtPhone.setBorder(null);
		txtPhone.setBackground(Color.WHITE);
		txtPhone.setBounds(10, 0, 134, 25);
		pnlPhone.add(txtPhone);
		
		JLabel lblPhoneNumber = new JLabel("PHONE NUMBER :");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhoneNumber.setForeground(Color.WHITE);
		lblPhoneNumber.setBackground(Color.WHITE);
		lblPhoneNumber.setBounds(492, 367, 108, 25);
		contentPane.add(lblPhoneNumber);
		
		lblErrorMessage.setForeground(Color.ORANGE);
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMessage.setFont(new Font("DialogInput", Font.BOLD, 13));
		lblErrorMessage.setBounds(525, 441, 258, 28);
		contentPane.add(lblErrorMessage);
		
		lblErrorUsername = new JLabel("");
		lblErrorUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorUsername.setForeground(Color.ORANGE);
		lblErrorUsername.setFont(new Font("DialogInput", Font.BOLD, 13));
		lblErrorUsername.setBounds(525, 76, 235, 28);
		contentPane.add(lblErrorUsername);
		
		lblErrorPassword = new JLabel("");
		lblErrorPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorPassword.setForeground(Color.ORANGE);
		lblErrorPassword.setFont(new Font("DialogInput", Font.BOLD, 13));
		lblErrorPassword.setBounds(525, 117, 235, 28);
		contentPane.add(lblErrorPassword);
		
		JPanel pnlMonth = new JPanel();
		pnlMonth.setBounds(610, 205, 150, 25);
		contentPane.add(pnlMonth);
		pnlMonth.setBackground(Color.WHITE);
		pnlMonth.setLayout(null);
		
		txtMonth = new JTextField();
		txtMonth.setBounds(10, 0, 134, 25);
		pnlMonth.add(txtMonth);
		txtMonth.setFont(new Font("DialogInput", Font.PLAIN, 16));
		txtMonth.setColumns(10);
		txtMonth.setBorder(null);
		txtMonth.setBackground(Color.WHITE);
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
	public JTextField getTxtPassword() {
		return txtPassword;
	}

	/**	This method returns the textfield first name.
	 * 
	 * 	@return first name	*/
	public JTextField getTxtFirst() {
		return txtFirst;
	}

	/**	This method returns the textfield middle name.
	 * 
	 * 	@return middle name	*/
	public JTextField getTxtMiddle() {
		return txtMiddle;
	}

	/**	This method returns the textfield surname.
	 * 
	 * 	@return surname	*/
	public JTextField getTxtLast() {
		return txtLast;
	}

	/**	This method returns the textfield home address.
	 * 
	 * 	@return home address	*/
	public JTextField getTxtHome() {
		return txtHome;
	}

	/**	This method returns the textfield office address.
	 * 
	 * 	@return office address	*/
	public JTextField getTxtOffice() {
		return txtOffice;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}
	
	/**	This method returns the textfield of the month.
	 * 
	 * 	@return month	*/
	public JTextField getTxtMonth() {
		return txtMonth;
	}

	/**	This method returns the textfield of the day.
	 * 
	 * 	@return day	*/
	public JTextField getTxtDay() {
		return txtDay;
	}

	/**	This method returns the textfield of the year.
	 * 
	 * 	@return year	*/
	public JTextField getTxtYear() {
		return txtYear;
	}

	/**	This method returns the textfield of the phone number.
	 * 
	 * 	@return phone number	*/
	public JTextField getTxtPhone() {
		return txtPhone;
	}
	
	/**	This method sets a success message in the label	*/
	public void Success() {
		lblErrorMessage.setText("Account successfully created.");
	}
	
	/**	This method sets an error message in the label	*/
	public void Error1() {
		lblErrorMessage.setText("Please input all requirements.");
	}
	
	/**	This method sets an error message for the birthdate in the label	*/
	public void Error2() {
		lblErrorMessage.setText("Invalid birthdate.");
	}
	
	/**	This method sets an error message for the username in the label	*/
	public void ErrorUsername() {
		lblErrorUsername.setText("Invalid username.");
	}
	
	/**	This method sets an error message for the password in the label	*/
	public void ErrorPassword() {
		lblErrorPassword.setText("Invalid password.");
	}
	
	/** This method listens for mouse interactions with the back button
	 * 
	 * @param listenForBackButton the mouse event that triggers the method */
	public void addBackListener(MouseListener listenForBackButton) {
		pnlBtnBack.addMouseListener(listenForBackButton);
	}
	
	/** This method listens for mouse interactions with the confirm button
	 * 
	 * @param listenForConfirmButton the mouse event that triggers the method */
	public void addConfirmListener(MouseListener listenForConfirmButton) {
		pnlBtnConfirm.addMouseListener(listenForConfirmButton);
	}
}