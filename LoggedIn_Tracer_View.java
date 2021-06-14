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

/**	The LoggedIn_Tracer_View is the display GUI of the tracer role.	*/
public class LoggedIn_Tracer_View extends JFrame {
	
	/**	Image icon of a tracer	*/
	private Image img_Role = new ImageIcon(LoggedIn_Citizen_View.class.getResource("Res/Tracer.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	/**	Show case panel */
	private PanelTracer_ShowCase panelTracer_ShowCase;
	/**	Trace specific case panel	*/
	private PanelTracer_TraceCase panelTracer_TraceCase;
	/**	Inform citizen panel	*/
	private PanelTracer_Inform panelTracer_Inform;
	/**	Show case button panel	*/
	private JPanel pnlShowCase;
	/**	Trace specific case panel button	*/
	private JPanel pnlTraceCase;
	/**	Inform citizens panel button	*/
	private JPanel pnlInform;
	/**	Log out panel button	*/
	private JPanel pnlBtnLogOut;
	/**	Username	*/
	private JLabel lblUsername = new JLabel("");

	/**	The constructor creates the GUI of the tracer	*/
	public LoggedIn_Tracer_View() {
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
		
		panelTracer_ShowCase = new PanelTracer_ShowCase();
		panelTracer_TraceCase = new PanelTracer_TraceCase();
		panelTracer_Inform = new PanelTracer_Inform();
		
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
		
		lblUsername = new JLabel("");
		lblUsername.setFont(new Font("DialogInput", Font.PLAIN, 15));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(new Color(0, 255, 255));
		lblUsername.setBounds(30, 141, 147, 26);
		panelMenu.add(lblUsername);
		
		pnlShowCase = new JPanel();
		pnlShowCase.addMouseListener(new PanelButtonMouseAdapter(pnlShowCase));
		pnlShowCase.setBackground(new Color(0, 128, 128));
		pnlShowCase.setBounds(0, 178, 198, 26);
		panelMenu.add(pnlShowCase);
		pnlShowCase.setLayout(null);
		
		JLabel lblShowCase = new JLabel("SHOW ASSIGNED CASE");
		lblShowCase.setForeground(new Color(255, 255, 255));
		lblShowCase.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblShowCase.setHorizontalAlignment(SwingConstants.LEFT);
		lblShowCase.setBounds(10, 0, 178, 25);
		pnlShowCase.add(lblShowCase);
		
		pnlTraceCase = new JPanel();
		pnlTraceCase.addMouseListener(new PanelButtonMouseAdapter(pnlTraceCase));
		pnlTraceCase.setBackground(new Color(0, 128, 128));
		pnlTraceCase.setBounds(0, 206, 198, 26);
		panelMenu.add(pnlTraceCase);
		pnlTraceCase.setLayout(null);
		
		JLabel lblTraceCase = new JLabel("TRACE SPECIFIC CASE");
		lblTraceCase.setForeground(new Color(255, 255, 255));
		lblTraceCase.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblTraceCase.setHorizontalAlignment(SwingConstants.LEFT);
		lblTraceCase.setBounds(10, 0, 178, 25);
		pnlTraceCase.add(lblTraceCase);
		
		pnlInform = new JPanel();
		pnlInform.addMouseListener(new PanelButtonMouseAdapter(pnlInform));
		pnlInform.setBackground(new Color(0, 128, 128));
		pnlInform.setBounds(0, 234, 198, 26);
		panelMenu.add(pnlInform);
		pnlInform.setLayout(null);
		
		JLabel lblInform = new JLabel("INFORM CITIZENS");
		lblInform.setForeground(new Color(255, 255, 255));
		lblInform.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblInform.setHorizontalAlignment(SwingConstants.LEFT);
		lblInform.setBounds(10, 0, 178, 25);
		pnlInform.add(lblInform);
		
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
		
		JPanel pnlMainContent = new JPanel();
		pnlMainContent.setBackground(new Color(95, 158, 160));
		pnlMainContent.setBounds(208, 11, 575, 503);
		contentPane.add(pnlMainContent);
		pnlMainContent.setLayout(null);
		
		pnlMainContent.add(panelTracer_ShowCase);
		pnlMainContent.add(panelTracer_TraceCase);
		pnlMainContent.add(panelTracer_Inform);
	}
	
	/** This method shows the username of the current user.
	 * 
	 * @param username the username of the user logged in */
	public void showUsername(String username) {
		lblUsername.setText(username);
	}

	/** This method returns the inform citizens panel
	 * 
	 * @return panelTracer_Inform the GUI for the inform citizens */
	public PanelTracer_Inform getPanelTracer_Inform() {
		return panelTracer_Inform;
	}

	/** This method returns the assigned cases panel
	 * 
	 * @return panelTracer_Inform the GUI for the assigned cases */
	public PanelTracer_ShowCase getPanelTracer_ShowCase() {
		return panelTracer_ShowCase;
	}

	/** This method returns the trace specific case panel
	 * 
	 * @return panelTracer_Inform the GUI for the trace specific case */
	public PanelTracer_TraceCase getPanelTracer_TraceCase() {
		return panelTracer_TraceCase;
	}

	/** This method adds a mouse listener for the assigned cases panel button
	 * 
	 * @param listenForShowCaseButton the mouse event that interacts with the assigned cases button */
	public void addShowCaseListener(MouseListener listenForShowCaseButton) {
		pnlShowCase.addMouseListener(listenForShowCaseButton);
	}

	/** This method adds a mouse listener for the trace specific case panel button
	 * 
	 * @param listenForTraceCaseButton the mouse event that interacts with the trace specific case button */
	public void addTraceCaseListener(MouseListener listenForTraceCaseButton) {
		pnlTraceCase.addMouseListener(listenForTraceCaseButton);
	}

	/** This method adds a mouse listener for the inform citizens panel button
	 * 
	 * @param listenForInformButton the mouse event that interacts with the inform citizens button */
	public void addInformListener(MouseListener listenForInformButton) {
		pnlInform.addMouseListener(listenForInformButton);
	}
	
	/** This method adds a mouse listener for the logout button
	 * 
	 * @param listenForLogOutButton the mouse event that interacts with the logout button */
	public void addLogOutListener(MouseListener listenForLogOutButton) {
		pnlBtnLogOut.addMouseListener(listenForLogOutButton);
	}
}
