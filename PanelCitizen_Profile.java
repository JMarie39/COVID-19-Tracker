import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.awt.Color;
import javax.swing.JTextField;

/**	The PanelCitizen_Profile is the display GUI of the to be updated information of the citizen user. */
public class PanelCitizen_Profile extends JPanel {
	
	/**	Image icon of a user	*/
	private Image img_User = new ImageIcon(SignIn_View.class.getResource("Res/User.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	/**	Image icon of a lock	*/
	private Image img_Lock = new ImageIcon(PanelCitizen_Profile.class.getResource("Res/Lock.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	/**	Username	*/
	private JLabel lblUsername = new JLabel("");
	/**	Password	*/
	private JTextField txtPassword;
	/**	First name	*/
	private JTextField txtFirst;
	/**	Middle name	*/
	private JTextField txtMiddle;
	/**	Surname	*/
	private JTextField txtSurname;
	/**	Birth month	*/
	private JTextField txtMonth;
	/**	Birth day	*/
	private JTextField txtDay;
	/**	Birth year	*/
	private JTextField txtYear;
	/**	Home address	*/
	private JTextField txtHome;
	/**	Office address	*/
	private JTextField txtOffice;
	/**	Phone number	*/
	private JTextField txtPhone;
	/**	Email address	*/
	private JTextField txtEmail;
	/**	Confirm panel	*/
	private JPanel pnlBtnConfirm;
	
	/**	The constructor creates the GUI profile information panel	*/
	public PanelCitizen_Profile() {
		setBackground(new Color(95, 158, 160));
		setBounds(0, 0, 575, 503);
		setLayout(null);
		
		JLabel lblProfInfo = new JLabel("UPDATE PROFILE INFORMATION");
		lblProfInfo.setForeground(new Color(224, 255, 255));
		lblProfInfo.setFont(new Font("DialogInput", Font.BOLD, 22));
		lblProfInfo.setHorizontalAlignment(SwingConstants.LEFT);
		lblProfInfo.setBounds(21, 11, 358, 46);
		add(lblProfInfo);
		
		JLabel lblFirst = new JLabel("FIRST NAME : ");
		lblFirst.setForeground(new Color(255, 255, 255));
		lblFirst.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirst.setBounds(21, 201, 103, 14);
		add(lblFirst);
		
		JLabel lblMiddle = new JLabel("MIDDLE NAME : ");
		lblMiddle.setForeground(new Color(255, 255, 255));
		lblMiddle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMiddle.setBounds(21, 232, 103, 14);
		add(lblMiddle);
		
		JLabel lblSurname = new JLabel("SURNAME : ");
		lblSurname.setForeground(new Color(255, 255, 255));
		lblSurname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSurname.setBounds(21, 263, 103, 14);
		add(lblSurname);
		
		JLabel lblMonth = new JLabel("BIRTH MONTH : ");
		lblMonth.setForeground(new Color(255, 255, 255));
		lblMonth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMonth.setBounds(300, 201, 112, 14);
		add(lblMonth);
		
		JLabel lblDay = new JLabel("BIRTH DAY : ");
		lblDay.setForeground(new Color(255, 255, 255));
		lblDay.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDay.setBounds(300, 232, 112, 14);
		add(lblDay);
		
		JLabel lblYear = new JLabel("BIRTH YEAR : ");
		lblYear.setForeground(new Color(255, 255, 255));
		lblYear.setHorizontalAlignment(SwingConstants.RIGHT);
		lblYear.setBounds(300, 263, 112, 14);
		add(lblYear);
		
		JPanel pnlPersonal = new JPanel();
		pnlPersonal.setLayout(null);
		pnlPersonal.setBackground(new Color(95, 158, 160));
		pnlPersonal.setBounds(21, 147, 342, 40);
		add(pnlPersonal);
		
		JLabel lblPersonalInformation = new JLabel("PERSONAL INFORMATION");
		lblPersonalInformation.setForeground(new Color(230, 230, 250));
		lblPersonalInformation.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblPersonalInformation.setBackground(new Color(230, 230, 250));
		lblPersonalInformation.setBounds(10, 11, 252, 23);
		pnlPersonal.add(lblPersonalInformation);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(203, 0, 46, 46);
		pnlPersonal.add(label_1);
		
		JPanel pnlContact = new JPanel();
		pnlContact.setLayout(null);
		pnlContact.setBackground(new Color(95, 158, 160));
		pnlContact.setBounds(21, 291, 342, 40);
		add(pnlContact);
		
		JLabel lblContactInformation = new JLabel("CONTACT INFORMATION");
		lblContactInformation.setForeground(new Color(230, 230, 250));
		lblContactInformation.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblContactInformation.setBackground(new Color(230, 230, 250));
		lblContactInformation.setBounds(10, 11, 252, 23);
		pnlContact.add(lblContactInformation);
		
		JLabel label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(237, 0, 46, 46);
		pnlContact.add(label_2);
		
		JLabel lblHomeAddress = new JLabel("HOME ADDRESS : ");
		lblHomeAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHomeAddress.setForeground(Color.WHITE);
		lblHomeAddress.setBounds(21, 345, 111, 14);
		add(lblHomeAddress);
		
		JLabel lblOfficeAddress = new JLabel("OFFICE ADDRESS : ");
		lblOfficeAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOfficeAddress.setForeground(Color.WHITE);
		lblOfficeAddress.setBounds(21, 376, 111, 14);
		add(lblOfficeAddress);
		
		JLabel lblPhoneNumber = new JLabel("PHONE NUMBER : ");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhoneNumber.setForeground(Color.WHITE);
		lblPhoneNumber.setBounds(21, 407, 111, 14);
		add(lblPhoneNumber);
		
		JLabel lblEmailAddress = new JLabel("EMAIL ADDRESS : ");
		lblEmailAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailAddress.setForeground(Color.WHITE);
		lblEmailAddress.setBounds(21, 438, 111, 14);
		add(lblEmailAddress);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(21, 96, 422, 40);
		add(panel);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(new Color(230, 230, 250));
		lblPassword.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblPassword.setBackground(new Color(230, 230, 250));
		lblPassword.setBounds(10, 11, 166, 23);
		panel.add(lblPassword);
		
		JLabel lblIconPass = new JLabel("");
		lblIconPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconPass.setBounds(110, 0, 46, 46);
		panel.add(lblIconPass);
		lblIconPass.setIcon(new ImageIcon(img_Lock));
		
		JPanel pnlPassword = new JPanel();
		pnlPassword.setBackground(Color.WHITE);
		pnlPassword.setBounds(186, 11, 209, 23);
		panel.add(pnlPassword);
		pnlPassword.setLayout(null);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("DialogInput", Font.PLAIN, 11));
		txtPassword.setBounds(10, 0, 189, 23);
		pnlPassword.add(txtPassword);
		txtPassword.setBorder(null);
		txtPassword.setColumns(10);
		
		pnlBtnConfirm = new JPanel();
		pnlBtnConfirm.addMouseListener(new PanelButtonMouseAdapter(pnlBtnConfirm));
		pnlBtnConfirm.setLayout(null);
		pnlBtnConfirm.setBackground(new Color(0, 128, 128));
		pnlBtnConfirm.setBounds(367, 466, 198, 26);
		add(pnlBtnConfirm);
		
		JLabel lblConfirm = new JLabel("CONFIRM");
		lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirm.setForeground(Color.WHITE);
		lblConfirm.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblConfirm.setBounds(10, 0, 178, 25);
		pnlBtnConfirm.add(lblConfirm);
		
		JPanel pnlFirst = new JPanel();
		pnlFirst.setBackground(Color.WHITE);
		pnlFirst.setBounds(126, 198, 178, 23);
		add(pnlFirst);
		pnlFirst.setLayout(null);
		
		txtFirst = new JTextField();
		txtFirst.setFont(new Font("DialogInput", Font.PLAIN, 11));
		txtFirst.setBounds(10, 0, 158, 23);
		pnlFirst.add(txtFirst);
		txtFirst.setBorder(null);
		txtFirst.setColumns(10);
		
		JPanel pnlMiddle = new JPanel();
		pnlMiddle.setBackground(Color.WHITE);
		pnlMiddle.setBounds(126, 229, 178, 23);
		add(pnlMiddle);
		pnlMiddle.setLayout(null);
		
		txtMiddle = new JTextField();
		txtMiddle.setFont(new Font("DialogInput", Font.PLAIN, 11));
		txtMiddle.setBounds(10, 0, 154, 23);
		pnlMiddle.add(txtMiddle);
		txtMiddle.setBorder(null);
		txtMiddle.setColumns(10);
		
		JPanel pnlSurname = new JPanel();
		pnlSurname.setBackground(Color.WHITE);
		pnlSurname.setBounds(126, 260, 178, 20);
		add(pnlSurname);
		pnlSurname.setLayout(null);
		
		txtSurname = new JTextField();
		txtSurname.setFont(new Font("DialogInput", Font.PLAIN, 11));
		txtSurname.setBounds(10, 0, 154, 20);
		pnlSurname.add(txtSurname);
		txtSurname.setBorder(null);
		txtSurname.setColumns(10);
		
		JPanel pnlMonth = new JPanel();
		pnlMonth.setBackground(Color.WHITE);
		pnlMonth.setBounds(415, 198, 118, 20);
		add(pnlMonth);
		pnlMonth.setLayout(null);
		
		txtMonth = new JTextField();
		txtMonth.setFont(new Font("DialogInput", Font.PLAIN, 11));
		txtMonth.setBounds(10, 0, 102, 20);
		pnlMonth.add(txtMonth);
		txtMonth.setBorder(null);
		txtMonth.setColumns(10);
		
		JPanel pnlDay = new JPanel();
		pnlDay.setBackground(Color.WHITE);
		pnlDay.setBounds(415, 229, 118, 20);
		add(pnlDay);
		pnlDay.setLayout(null);
		
		txtDay = new JTextField();
		txtDay.setFont(new Font("DialogInput", Font.PLAIN, 11));
		txtDay.setBounds(10, 0, 102, 20);
		pnlDay.add(txtDay);
		txtDay.setBorder(null);
		txtDay.setColumns(10);
		
		JPanel pnlYear = new JPanel();
		pnlYear.setBackground(Color.WHITE);
		pnlYear.setBounds(415, 260, 118, 20);
		add(pnlYear);
		pnlYear.setLayout(null);
		
		txtYear = new JTextField();
		txtYear.setFont(new Font("DialogInput", Font.PLAIN, 11));
		txtYear.setBounds(10, 0, 102, 20);
		pnlYear.add(txtYear);
		txtYear.setBorder(null);
		txtYear.setColumns(10);
		
		JPanel pnlHome = new JPanel();
		pnlHome.setBackground(Color.WHITE);
		pnlHome.setBounds(142, 342, 391, 20);
		add(pnlHome);
		pnlHome.setLayout(null);
		
		txtHome = new JTextField();
		txtHome.setFont(new Font("DialogInput", Font.PLAIN, 11));
		txtHome.setBounds(10, 0, 371, 20);
		pnlHome.add(txtHome);
		txtHome.setBorder(null);
		txtHome.setColumns(10);
		
		JPanel pnlOffice = new JPanel();
		pnlOffice.setBackground(Color.WHITE);
		pnlOffice.setBounds(142, 373, 391, 20);
		add(pnlOffice);
		pnlOffice.setLayout(null);
		
		txtOffice = new JTextField();
		txtOffice.setFont(new Font("DialogInput", Font.PLAIN, 11));
		txtOffice.setBounds(10, 0, 371, 20);
		pnlOffice.add(txtOffice);
		txtOffice.setBorder(null);
		txtOffice.setColumns(10);
		
		JPanel pnlPhone = new JPanel();
		pnlPhone.setBackground(Color.WHITE);
		pnlPhone.setBounds(142, 404, 391, 20);
		add(pnlPhone);
		pnlPhone.setLayout(null);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("DialogInput", Font.PLAIN, 11));
		txtPhone.setBounds(10, 0, 371, 20);
		pnlPhone.add(txtPhone);
		txtPhone.setBorder(null);
		txtPhone.setColumns(10);
		
		JPanel pnlEmail = new JPanel();
		pnlEmail.setBackground(Color.WHITE);
		pnlEmail.setBounds(142, 435, 391, 20);
		add(pnlEmail);
		pnlEmail.setLayout(null);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("DialogInput", Font.PLAIN, 11));
		txtEmail.setBounds(10, 0, 371, 20);
		pnlEmail.add(txtEmail);
		txtEmail.setBorder(null);
		txtEmail.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setBounds(21, 55, 422, 40);
		add(panel_1);
		
		JLabel lblUser = new JLabel("USERNAME");
		lblUser.setForeground(new Color(230, 230, 250));
		lblUser.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblUser.setBackground(new Color(230, 230, 250));
		lblUser.setBounds(10, 11, 166, 23);
		panel_1.add(lblUser);
		
		JLabel lblIconUser = new JLabel("");
		lblIconUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconUser.setBounds(111, 0, 46, 40);
		panel_1.add(lblIconUser);
		lblIconUser.setIcon(new ImageIcon(img_User));
		
		JPanel pnlUsername = new JPanel();
		pnlUsername.setLayout(null);
		pnlUsername.setBackground(Color.WHITE);
		pnlUsername.setBounds(186, 11, 209, 23);
		panel_1.add(pnlUsername);
		
		lblUsername = new JLabel("");
		lblUsername.setBounds(10, 0, 189, 23);
		pnlUsername.add(lblUsername);
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setBackground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("DialogInput", Font.PLAIN, 11));
	}
	
	/** This method shows the username of the current user.
	 * 
	 * @param username the username of the user logged in */
	public void showUsername(String username) {
		lblUsername.setText(username);
	}
	
	/**	This method returns the password of the current user.
	 * 
	 * 	@return password	*/
	public JTextField getTxtPassword() {
		return txtPassword;
	}
	
	/**	This method returns the textfield first name of the current user.
	 * 
	 * 	@return first name	*/
	public JTextField getTxtFirst() {
		return txtFirst;
	}
	
	/**	This method returns the textfield middle name of the current user.
	 * 
	 * 	@return middle name	*/
	public JTextField getTxtMiddle() {
		return txtMiddle;
	}
	
	/**	This method returns the textfield surname of the current user.
	 * 
	 * 	@return surname	*/
	public JTextField getTxtSurname() {
		return txtSurname;
	}
	
	/**	This method returns the textfield birth month of the current user.
	 * 
	 * 	@return month	*/
	public JTextField getTxtMonth() {
		return txtMonth;
	}
	
	/**	This method returns the textfield birth day of the current user.
	 * 
	 * 	@return day	*/
	public JTextField getTxtDay() {
		return txtDay;
	}
	
	/**	This method returns the textfield birth year of the current user.
	 * 
	 * 	@return year	*/
	public JTextField getTxtYear() {
		return txtYear;
	}
	
	/**	This method returns the textfield home address of the current user.
	 * 
	 * 	@return home address	*/
	public JTextField getTxtHome() {
		return txtHome;
	}
	
	/**	This method returns the textfield office address of the current user.
	 * 
	 * 	@return office address	*/
	public JTextField getTxtOffice() {
		return txtOffice;
	}
	
	/**	This method returns the textfield phone number
	 * 
	 * 	@return phone number	*/
	public JTextField getTxtPhone() {
		return txtPhone;
	}
	
	/**	This method returns the textfield email address of the current user.
	 * 
	 * 	@return email address	*/
	public JTextField getTxtEmail() {
		return txtEmail;
	}

	/**	This method sets a success message in the label.	*/
	public void success() {
		JOptionPane.showMessageDialog(null, "Profile successfully updated.");
	}
	
	/**	This method sets an error message in the label.	*/
	public void error() {
		JOptionPane.showMessageDialog(null, "Profile not updated. (Information entered is invalid or no entered info)");
	}
	
	/** This method listens for focus events on the password text field
	 * 
	 * @param e the focus event that triggers the method */
	public void passwordListener(FocusListener e) {
		txtPassword.addFocusListener(e);
	}
	
	/** This method listens for focus events on the first name text field
	 * 
	 * @param e the focus event that triggers the method */
	public void fNameListener(FocusListener e) {
		txtFirst.addFocusListener(e);
	}
	
	/** This method listens for focus events on the middle name text field
	 * 
	 * @param e the focus event that triggers the method */
	public void mNameListener(FocusListener e) {
		txtMiddle.addFocusListener(e);
	}
	
	/** This method listens for focus events on the surname text field
	 * 
	 * @param e the focus event that triggers the method */
	public void sNameListener(FocusListener e) {
		txtSurname.addFocusListener(e);
	}
	
	/** This method listens for focus events on the birth month text field
	 * 
	 * @param e the focus event that triggers the method */
	public void dMonthListener(FocusListener e) {
		txtMonth.addFocusListener(e);
	}

	/** This method listens for focus events on the birth day text field
	 * 
	 * @param e the focus event that triggers the method */
	public void dDayListener(FocusListener e) {
		txtDay.addFocusListener(e);
	}

	/** This method listens for focus events on the birth year text field
	 * 
	 * @param e the focus event that triggers the method */
	public void dYearListener(FocusListener e) {
		txtYear.addFocusListener(e);
	}
	
	/** This method listens for focus events on the home address text field
	 * 
	 * @param e the focus event that triggers the method */
	public void homeListener(FocusListener e) {
		txtHome.addFocusListener(e);
	}
	
	/** This method listens for focus events on the office address text field
	 * 
	 * @param e the focus event that triggers the method */
	public void officeListener(FocusListener e) {
		txtOffice.addFocusListener(e);
	}
	
	/** This method listens for focus events on the phone number text field
	 * 
	 * @param e the focus event that triggers the method */
	public void phoneListener(FocusListener e) {
		txtPhone.addFocusListener(e);
	}
	
	/** This method listens for focus events on the email address text field
	 * 
	 * @param e the focus event that triggers the method */
	public void emailListener(FocusListener e) {
		txtEmail.addFocusListener(e);
	}
	
	/** This method listens for mouse events on the confirm button
	 * 
	 * @param listenForConfirmButton the mouse event that triggers the method */
	public void addConfirmListener(MouseListener listenForConfirmButton) {
		pnlBtnConfirm.addMouseListener(listenForConfirmButton);
	}
}
