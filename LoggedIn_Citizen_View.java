import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**	The LoggedIn_Citizen_View is the display GUI of the citizen role.	*/
public class LoggedIn_Citizen_View extends JFrame {
	
	/**	Image icon of a citizen */
	private Image img_Role = new ImageIcon(LoggedIn_Citizen_View.class.getResource("Res/Citizen.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	/**	Check- in panel	*/
	private PanelCitizen_CheckIn panelCitizen_CheckIn;
	/**	Report positive panel	*/
	private PanelCitizen_Report panelCitizen_Report;
	/**	Visit record panel	*/
	private PanelCitizen_VisitRecord panelCitizen_VisitRecord;
	/**	Update and see profile panel	*/
	private PanelCitizen_Profile panelCitizen_Profile;
	/**	Check- in button panel */
	private JPanel pnlCheckIn;
	/**	Profile button panel 	*/
	private JPanel pnlProfile;
	/**	Report button panel 	*/
	private JPanel pnlReport;
	/**	Visit button panel 	*/
	private JPanel pnlVisit;
	/**	Log out button panel 	*/
	private JPanel pnlBtnLogOut;
	/**	Username	*/
	private JLabel lblUsername;

	/**	The constructor creates the GUI of the citizen	*/
	public LoggedIn_Citizen_View() {
		
		setUndecorated(true);
		setResizable(false);
		setAlwaysOnTop(true);
		setBackground(new Color(0, 128, 128));
		setBounds(100, 100, 793, 525);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new LineBorder(new Color(0, 128, 128), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelCitizen_CheckIn = new PanelCitizen_CheckIn();
		panelCitizen_Report = new PanelCitizen_Report();
		panelCitizen_VisitRecord = new PanelCitizen_VisitRecord();
		panelCitizen_Profile = new PanelCitizen_Profile();
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(0, 128, 128));
		panelMenu.setBounds(0, 0, 198, 525);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel lblIconRole = new JLabel("");
		lblIconRole.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconRole.setBounds(10, 27, 178, 112);
		panelMenu.add(lblIconRole);
		lblIconRole.setIcon(new ImageIcon(img_Role));
		
		pnlCheckIn = new JPanel();
		pnlCheckIn.addMouseListener(new PanelButtonMouseAdapter(pnlCheckIn));
		pnlCheckIn.setBackground(new Color(0, 128, 128));
		pnlCheckIn.setBounds(0, 178, 198, 26);
		panelMenu.add(pnlCheckIn);
		pnlCheckIn.setLayout(null);
		
		JLabel lblCheckIn = new JLabel("CHECK IN");
		lblCheckIn.setForeground(new Color(255, 255, 255));
		lblCheckIn.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblCheckIn.setHorizontalAlignment(SwingConstants.LEFT);
		lblCheckIn.setBounds(10, 0, 178, 25);
		pnlCheckIn.add(lblCheckIn);
		
		pnlReport = new JPanel();
		pnlReport.addMouseListener(new PanelButtonMouseAdapter(pnlReport));
		pnlReport.setBackground(new Color(0, 128, 128));
		pnlReport.setBounds(0, 206, 198, 26);
		panelMenu.add(pnlReport);
		pnlReport.setLayout(null);
		
		JLabel lblReportPositive = new JLabel("REPORT POSITIVE");
		lblReportPositive.setForeground(new Color(255, 255, 255));
		lblReportPositive.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblReportPositive.setHorizontalAlignment(SwingConstants.LEFT);
		lblReportPositive.setBounds(10, 0, 178, 25);
		pnlReport.add(lblReportPositive);
		
		pnlVisit = new JPanel();
		pnlVisit.addMouseListener(new PanelButtonMouseAdapter(pnlVisit));
		pnlVisit.setBackground(new Color(0, 128, 128));
		pnlVisit.setBounds(0, 234, 198, 26);
		panelMenu.add(pnlVisit);
		pnlVisit.setLayout(null);
		
		JLabel lblViewVisitRecord = new JLabel("VIEW VISIT RECORD");
		lblViewVisitRecord.setForeground(new Color(255, 255, 255));
		lblViewVisitRecord.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblViewVisitRecord.setHorizontalAlignment(SwingConstants.LEFT);
		lblViewVisitRecord.setBounds(10, 0, 178, 25);
		pnlVisit.add(lblViewVisitRecord);
		
		pnlProfile = new JPanel();
		pnlProfile.addMouseListener(new PanelButtonMouseAdapter(pnlProfile));
		pnlProfile.setBackground(new Color(0, 128, 128));
		pnlProfile.setBounds(0, 263, 198, 26);
		panelMenu.add(pnlProfile);
		pnlProfile.setLayout(null);
		
		JLabel lblProfile = new JLabel("UPDATE PROFILE");
		lblProfile.setForeground(new Color(255, 255, 255));
		lblProfile.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblProfile.setHorizontalAlignment(SwingConstants.LEFT);
		lblProfile.setBounds(10, 0, 178, 25);
		pnlProfile.add(lblProfile);
		
		pnlBtnLogOut = new JPanel();
		pnlBtnLogOut.addMouseListener(new PanelButtonMouseAdapter(pnlBtnLogOut));
		pnlBtnLogOut.setBackground(new Color(0, 128, 128));
		pnlBtnLogOut.setBounds(0, 474, 198, 26);
		panelMenu.add(pnlBtnLogOut);
		pnlBtnLogOut.setLayout(null);
		
		JLabel lblLogOut = new JLabel("LOG OUT");
		lblLogOut.setBounds(10, 0, 178, 25);
		pnlBtnLogOut.add(lblLogOut);
		lblLogOut.setForeground(new Color(255, 255, 255));
		lblLogOut.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblLogOut.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblUsername = new JLabel("");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(Color.CYAN);
		lblUsername.setFont(new Font("DialogInput", Font.PLAIN, 15));
		lblUsername.setBounds(20, 141, 157, 26);
		panelMenu.add(lblUsername);
		
		JPanel pnlMainContent = new JPanel();
		pnlMainContent.setBackground(new Color(95, 158, 160));
		pnlMainContent.setBounds(208, 11, 575, 503);
		contentPane.add(pnlMainContent);
		pnlMainContent.setLayout(null);
		
		pnlMainContent.add(panelCitizen_CheckIn);
		pnlMainContent.add(panelCitizen_Report);
		pnlMainContent.add(panelCitizen_VisitRecord);
		pnlMainContent.add(panelCitizen_Profile);
	}
	
	/** This method shows the username of the current user.
	 * 
	 * @param username the username of the user logged in */
	public void showUsername(String username) {
		lblUsername.setText(username);
	}

	/** This method returns the GUI of the Check-in panel
	 * 
	 * @return panelCitizen_CheckIn the visuals of the check-in panel.	*/
	public PanelCitizen_CheckIn getPanelCitizen_CheckIn() {
		return panelCitizen_CheckIn;
	}

	/** This method returns the GUI of the report positive panel
	 * 
	 * @return panelCitizen_Report the visuals of the report positive panel.	*/
	public PanelCitizen_Report getPanelCitizen_Report() {
		return panelCitizen_Report;
	}
	
	/** This method returns the GUI of the visit record panel
	 * 
	 * @return panelCitizen_VisitRecord the visuals of the visit record panel.	*/
	public PanelCitizen_VisitRecord getPanelCitizen_VisitRecord() {
		return panelCitizen_VisitRecord;
	}

	/** This method returns the GUI of the profile panel
	 * 
	 * @return panelCitizen_Profile the visuals of the profile panel.	*/
	public PanelCitizen_Profile getPanelCitizen_Profile() {
		return panelCitizen_Profile;
	}

	/** This method adds a mouse listener for the check-in panel button
	 * 
	 * @param listenForCheckInButton the mouse event that interacts with the check-in panel button	*/
	public void addCheckInListener(MouseListener listenForCheckInButton) {
		pnlCheckIn.addMouseListener(listenForCheckInButton);
	}
	
	/** This method adds a mouse listener for the profile panel button
	 * 
	 * @param listenForProfileButton the mouse event that interacts with the profile panel button	*/
	public void addProfileListener(MouseListener listenForProfileButton) {
		pnlProfile.addMouseListener(listenForProfileButton);
	}
	
	/** This method adds a mouse listener for the check-in panel button
	 * 
	 * @param listenForReportButton the mouse event that interacts with the report positive panel button	*/
	public void addReportListener(MouseListener listenForReportButton) {
		pnlReport.addMouseListener(listenForReportButton);
	}
	
	/** This method adds a mouse listener for the visit record panel button
	 * 
	 * @param listenForVisitRecordButton the mouse event that interacts with the visit record panel button	*/
	public void addVisitRecordListener(MouseListener listenForVisitRecordButton) {
		pnlVisit.addMouseListener(listenForVisitRecordButton);
	}
	
	/** This method adds a mouse listener for the log out button
	 * 
	 * @param listenForLogOutButton the mouse event that interacts with the log out button	*/
	public void addLogOutListener(MouseListener listenForLogOutButton) {
		pnlBtnLogOut.addMouseListener(listenForLogOutButton);
	}
	
	/** This method displays a notice that the user may have come in contact with a positive patient
	 * 
	 * @param estCode The establishment where the user may have come in contact with a positive patient
	 * @param date The date when the user may have come in contact with a positive patient */
	public void notice(String estCode, String date) {
		JOptionPane.showMessageDialog(null, "!!! USER MAY HAVE COME IN CONTACT WITH A POSITIVE PATIENT ON " + date + " in " + estCode + " !!!");
	}
}