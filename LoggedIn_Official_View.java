import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**	The LoggedIn_Official_View is the display GUI of the official role.	*/
public class LoggedIn_Official_View extends JFrame {
	
	/**	Image icon of an official	*/
	private Image img_Role = new ImageIcon(LoggedIn_Citizen_View.class.getResource("Res/Official.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	/** Unassigned cases panel	*/
	private PanelOfficial_Case panelOfficial_Case;
	/** Contact tracing updates panel	*/
	private PanelOfficial_Update panelOfficial_Update;
	/** Analytics panel	*/
	private PanelOfficial_Analytics panelOfficial_Analytics;
	/** Create official account panel	*/
	private PanelOfficial_Official panelOfficial_Official;
	/** Create tracer account panel	*/
	private PanelOfficial_Tracer panelOfficial_Tracer;
	/** Terminate account panel	*/
	private PanelOfficial_Terminate panelOfficial_Terminate;
	/** Show users panel	*/
	private PanelOfficial_Users panelOfficial_Users;
	/** Unassigned cases button panel	*/
	private JPanel pnlUnassigned;
	/** Contact tracing updates button panel	*/
	private JPanel pnlTracing;
	/**	Show analytics button panel	*/
	private JPanel pnlAnalytics;
	/**	Log out button panel	*/
	private JPanel pnlBtnLogOut;
	/**	Terminate button panel	*/
	private JPanel pnlTerminate;
	/**	Create tracer button panel	*/
	private JPanel pnlTracer;
	/**	Create official button panel	*/
	private JPanel pnlGovOfficial;
	/**	Show users button panel	*/
	private JPanel pnlUsers;
	/**	Error message	*/
	private JLabel lblUsername = new JLabel("");

	/**	The constructor creates the GUI of the official	*/
	public LoggedIn_Official_View() {
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
		
		panelOfficial_Case = new PanelOfficial_Case();
		panelOfficial_Update = new PanelOfficial_Update();
		panelOfficial_Analytics = new PanelOfficial_Analytics();
		panelOfficial_Official = new PanelOfficial_Official();
		panelOfficial_Tracer = new PanelOfficial_Tracer();
		panelOfficial_Terminate = new PanelOfficial_Terminate();
		panelOfficial_Users = new PanelOfficial_Users();
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(0, 128, 128));
		panelMenu.setBounds(0, 0, 198, 525);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		pnlUsers = new JPanel();
		pnlUsers.addMouseListener(new PanelButtonMouseAdapter(pnlUsers));
		pnlUsers.setLayout(null);
		pnlUsers.setBackground(new Color(0, 128, 128));
		pnlUsers.setBounds(0, 433, 198, 26);
		panelMenu.add(pnlUsers);
		
		JLabel lblUsers = new JLabel("SHOW ALL USERS");
		lblUsers.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsers.setForeground(Color.WHITE);
		lblUsers.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblUsers.setBounds(10, 0, 178, 25);
		pnlUsers.add(lblUsers);
		
		JLabel lblIconRole = new JLabel("");
		lblIconRole.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconRole.setBounds(10, 27, 178, 112);
		panelMenu.add(lblIconRole);
		lblIconRole.setIcon(new ImageIcon(img_Role));
		
		JPanel pnlShow = new JPanel();
		pnlShow.setBackground(new Color(0, 128, 128));
		pnlShow.setBounds(0, 178, 198, 26);
		panelMenu.add(pnlShow);
		pnlShow.setLayout(null);
		
		JLabel lblShow = new JLabel("SHOW");
		lblShow.setForeground(new Color(255, 255, 255));
		lblShow.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblShow.setHorizontalAlignment(SwingConstants.CENTER);
		lblShow.setBounds(10, 0, 178, 25);
		pnlShow.add(lblShow);
		
		pnlUnassigned = new JPanel();
		pnlUnassigned.addMouseListener(new PanelButtonMouseAdapter(pnlUnassigned));
		pnlUnassigned.setBackground(new Color(0, 128, 128));
		pnlUnassigned.setBounds(0, 206, 198, 26);
		panelMenu.add(pnlUnassigned);
		pnlUnassigned.setLayout(null);
		
		JLabel lblUnassigned = new JLabel("UNASSIGNED CASE");
		lblUnassigned.setForeground(new Color(255, 255, 255));
		lblUnassigned.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblUnassigned.setHorizontalAlignment(SwingConstants.LEFT);
		lblUnassigned.setBounds(10, 0, 178, 25);
		pnlUnassigned.add(lblUnassigned);
		
		pnlTracing = new JPanel();
		pnlTracing.addMouseListener(new PanelButtonMouseAdapter(pnlTracing));
		pnlTracing.setBackground(new Color(0, 128, 128));
		pnlTracing.setBounds(0, 234, 198, 26);
		panelMenu.add(pnlTracing);
		pnlTracing.setLayout(null);
		
		JLabel lblTracing = new JLabel("CONTACT TRACING UPDATE");
		lblTracing.setForeground(new Color(255, 255, 255));
		lblTracing.setFont(new Font("DialogInput", Font.BOLD, 13));
		lblTracing.setHorizontalAlignment(SwingConstants.LEFT);
		lblTracing.setBounds(10, 0, 178, 25);
		pnlTracing.add(lblTracing);
		
		JPanel pnlCreate = new JPanel();
		pnlCreate.setBackground(new Color(0, 128, 128));
		pnlCreate.setBounds(0, 300, 198, 26);
		panelMenu.add(pnlCreate);
		pnlCreate.setLayout(null);
		
		JLabel lblCreate = new JLabel("CREATE ACCOUNT");
		lblCreate.setForeground(new Color(255, 255, 255));
		lblCreate.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblCreate.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreate.setBounds(10, 0, 178, 25);
		pnlCreate.add(lblCreate);
		
		pnlAnalytics = new JPanel();
		pnlAnalytics.addMouseListener(new PanelButtonMouseAdapter(pnlAnalytics));
		pnlAnalytics.setBackground(new Color(0, 128, 128));
		pnlAnalytics.setBounds(0, 263, 198, 26);
		panelMenu.add(pnlAnalytics);
		pnlAnalytics.setLayout(null);
		
		JLabel lblAnalytics = new JLabel("ANALYTICS");
		lblAnalytics.setForeground(new Color(255, 255, 255));
		lblAnalytics.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblAnalytics.setHorizontalAlignment(SwingConstants.LEFT);
		lblAnalytics.setBounds(10, 0, 178, 25);
		pnlAnalytics.add(lblAnalytics);
		
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
		
		pnlTerminate = new JPanel();
		pnlTerminate.addMouseListener(new PanelButtonMouseAdapter(pnlTerminate));
		pnlTerminate.setLayout(null);
		pnlTerminate.setBackground(new Color(0, 128, 128));
		pnlTerminate.setBounds(0, 396, 198, 26);
		panelMenu.add(pnlTerminate);
		
		JLabel lblTerminateAccount = new JLabel("TERMINATE ACCOUNT");
		lblTerminateAccount.setHorizontalAlignment(SwingConstants.LEFT);
		lblTerminateAccount.setForeground(Color.WHITE);
		lblTerminateAccount.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblTerminateAccount.setBounds(10, 0, 178, 25);
		pnlTerminate.add(lblTerminateAccount);
		
		pnlTracer = new JPanel();
		pnlTracer.addMouseListener(new PanelButtonMouseAdapter(pnlTracer));
		pnlTracer.setLayout(null);
		pnlTracer.setBackground(new Color(0, 128, 128));
		pnlTracer.setBounds(0, 355, 198, 26);
		panelMenu.add(pnlTracer);
		
		JLabel lblTracer = new JLabel("TRACER");
		lblTracer.setHorizontalAlignment(SwingConstants.LEFT);
		lblTracer.setForeground(Color.WHITE);
		lblTracer.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblTracer.setBounds(10, 0, 178, 25);
		pnlTracer.add(lblTracer);
		
		pnlGovOfficial = new JPanel();
		pnlGovOfficial.addMouseListener(new PanelButtonMouseAdapter(pnlGovOfficial));
		pnlGovOfficial.setLayout(null);
		pnlGovOfficial.setBackground(new Color(0, 128, 128));
		pnlGovOfficial.setBounds(0, 327, 198, 26);
		panelMenu.add(pnlGovOfficial);
		
		JLabel lblGovernmentOfficial = new JLabel("GOVERNMENT OFFICIAL");
		lblGovernmentOfficial.setHorizontalAlignment(SwingConstants.LEFT);
		lblGovernmentOfficial.setForeground(Color.WHITE);
		lblGovernmentOfficial.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblGovernmentOfficial.setBounds(10, 0, 178, 25);
		pnlGovOfficial.add(lblGovernmentOfficial);
		
		lblUsername = new JLabel("");
		lblUsername.setFont(new Font("DialogInput", Font.PLAIN, 15));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(new Color(0, 255, 255));
		lblUsername.setBounds(30, 141, 147, 26);
		panelMenu.add(lblUsername);
		
		JPanel pnlMainContent = new JPanel();
		pnlMainContent.setBackground(new Color(95, 158, 160));
		pnlMainContent.setBounds(208, 11, 575, 503);
		contentPane.add(pnlMainContent);
		pnlMainContent.setLayout(null);
		
		pnlMainContent.add(panelOfficial_Case);
		pnlMainContent.add(panelOfficial_Update);
		pnlMainContent.add(panelOfficial_Analytics);
		pnlMainContent.add(panelOfficial_Official);
		pnlMainContent.add(panelOfficial_Tracer);
		pnlMainContent.add(panelOfficial_Terminate);
		pnlMainContent.add(panelOfficial_Users);
	}
	
	/** This method shows the username of the current user.	
	 * 
	 * @param username the username of the user logged in */
	public void showUsername(String username) {
		lblUsername.setText(username);
	}
	/** This method returns the unassigned cases panel
	 * 
	 * @return panelOfficial_Case The GUI for the unassigned cases */
	public PanelOfficial_Case getPanelOfficial_Case() {
		return panelOfficial_Case;
	}
	/** This method returns the contact tracing update panel
	 * 
	 * @return panelOfficial_Case The GUI for the contact tracing update */
	public PanelOfficial_Update getPanelOfficial_Update() {
		return panelOfficial_Update;
	}
	/** This method returns the analytics panel
	 * 
	 * @return panelOfficial_Case The GUI for the analytics */
	public PanelOfficial_Analytics getPanelOfficial_Analytics() {
		return panelOfficial_Analytics;
	}
	/** This method returns the create official panel
	 * 
	 * @return panelOfficial_Case The GUI for the create official */
	public PanelOfficial_Official getPanelOfficial_Official() {
		return panelOfficial_Official;
	}
	/** This method returns the create tracer panel
	 * 
	 * @return panelOfficial_Case The GUI for the create tracer */
	public PanelOfficial_Tracer getPanelOfficial_Tracer() {
		return panelOfficial_Tracer;
	}
	/** This method returns the terminate account panel
	 * 
	 * @return panelOfficial_Case The GUI for the terminate account */
	public PanelOfficial_Terminate getPanelOfficial_Terminate() {
		return panelOfficial_Terminate;
	}
	/** This method returns the users panel
	 * 
	 * @return panelOfficial_Case The GUI for the users */
	public PanelOfficial_Users getPanelOfficial_Users() {
		return panelOfficial_Users;
	}
	/** This method adds a mouse listener for the analytics panel button
	 * 
	 * @param listenForAnalyticsButton the mouse event that interacts with the analytics button */
	public void addAnalyticsListener(MouseListener listenForAnalyticsButton) {
		pnlAnalytics.addMouseListener(listenForAnalyticsButton);
	}
	/** This method adds a mouse listener for the unassigned cases panel button
	 * 
	 * @param listenForCaseButton the mouse event that interacts with the unassigned cases button */
	public void addCaseListener(MouseListener listenForCaseButton) {
		pnlUnassigned.addMouseListener(listenForCaseButton);
	}
	/** This method adds a mouse listener for the create official panel button
	 * 
	 * @param listenForOfficialButton the mouse event that interacts with the create official button */
	public void addOfficialListener(MouseListener listenForOfficialButton) {
		pnlGovOfficial.addMouseListener(listenForOfficialButton);
	}
	/** This method adds a mouse listener for the terminate account panel button
	 * 
	 * @param listenForTerminateButton the mouse event that interacts with the terminate account button */
	public void addTerminateListener(MouseListener listenForTerminateButton) {
		pnlTerminate.addMouseListener(listenForTerminateButton);
	}
	/** This method adds a mouse listener for the create tracer panel button
	 * 
	 * @param listenForTracerButton the mouse event that interacts with the create tracer button */
	public void addTracerListener(MouseListener listenForTracerButton) {
		pnlTracer.addMouseListener(listenForTracerButton);
	}
	/** This method adds a mouse listener for the contact tracing update panel button
	 * 
	 * @param listenForUpdateButton the mouse event that interacts with the contact tracing update button */
	public void addUpdateListener(MouseListener listenForUpdateButton) {
		pnlTracing.addMouseListener(listenForUpdateButton);
	}
	/** This method adds a mouse listener for the show all users panel button
	 * 
	 * @param listenForUsersButton the mouse event that interacts with the show all users button */
	public void addUsersListener(MouseListener listenForUsersButton) {
		pnlUsers.addMouseListener(listenForUsersButton);
	}
	/** This method adds a mouse listener for the logout button
	 * 
	 * @param listenForLogOutButton the mouse event that interacts with the logout button */
	public void addLogOutListener(MouseListener listenForLogOutButton) {
		pnlBtnLogOut.addMouseListener(listenForLogOutButton);
	}
}