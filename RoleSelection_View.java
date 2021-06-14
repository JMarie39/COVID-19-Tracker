import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**	The RoleSelection_View is the display GUI when choosing a certain role	*/
public class RoleSelection_View extends JFrame {
	
	/**	Image icon of different roles	*/
	private Image img_Roles = new ImageIcon(RoleSelection_View.class.getResource("Res/Roles.png")).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
	/**	Official button	*/
	private JPanel pnlBtnOfficial;
	/**	Tracer button	*/
	private JPanel pnlBtnTracer;
	/**	Citizen button	*/
	private JPanel pnlBtnCitizen;
	/**	Exit button	*/
	private JPanel pnlBtnExit;
	/**	Error message	*/
	private JLabel lblErrorMessage = new JLabel("");

	/**	The method creates the GUI role selection panel	*/
	public RoleSelection_View() {
		setUndecorated(true);
		setBackground(new Color(224, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 525);
		
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new LineBorder(new Color(0, 128, 128), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pnlBtnOfficial = new JPanel();
		pnlBtnOfficial.addMouseListener(new PanelButtonMouseAdapter(pnlBtnOfficial));
		pnlBtnOfficial.setBackground(new Color(0, 128, 128));
		pnlBtnOfficial.setBounds(255, 255, 280, 46);
		contentPane.add(pnlBtnOfficial);
		pnlBtnOfficial.setLayout(null);
		
		JLabel lblOfficial = new JLabel("OFFICIAL");
		lblOfficial.setForeground(SystemColor.textHighlightText);
		lblOfficial.setFont(new Font("DialogInput", Font.BOLD, 20));
		lblOfficial.setHorizontalAlignment(SwingConstants.CENTER);
		lblOfficial.setBounds(41, 0, 210, 47);
		pnlBtnOfficial.add(lblOfficial);
		
		pnlBtnTracer = new JPanel();
		pnlBtnTracer.addMouseListener(new PanelButtonMouseAdapter(pnlBtnTracer));
		pnlBtnTracer.setLayout(null);
		pnlBtnTracer.setBackground(new Color(0, 128, 128));
		pnlBtnTracer.setBounds(255, 312, 280, 46);
		contentPane.add(pnlBtnTracer);
		
		JLabel lblTracer = new JLabel("TRACER");
		lblTracer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTracer.setForeground(Color.WHITE);
		lblTracer.setFont(new Font("DialogInput", Font.BOLD, 20));
		lblTracer.setBounds(41, 0, 210, 47);
		pnlBtnTracer.add(lblTracer);
		
		pnlBtnCitizen = new JPanel();
		pnlBtnCitizen.addMouseListener(new PanelButtonMouseAdapter(pnlBtnCitizen));
		pnlBtnCitizen.setLayout(null);
		pnlBtnCitizen.setBackground(new Color(0, 128, 128));
		pnlBtnCitizen.setBounds(255, 369, 280, 46);
		contentPane.add(pnlBtnCitizen);
		
		JLabel lblCitizen = new JLabel("CITIZEN");
		lblCitizen.setHorizontalAlignment(SwingConstants.CENTER);
		lblCitizen.setForeground(Color.WHITE);
		lblCitizen.setFont(new Font("DialogInput", Font.BOLD, 20));
		lblCitizen.setBounds(41, 0, 210, 47);
		pnlBtnCitizen.add(lblCitizen);
		
		pnlBtnExit = new JPanel();
		pnlBtnExit.addMouseListener(new PanelButtonMouseAdapter(pnlBtnExit));
		pnlBtnExit.setLayout(null);
		pnlBtnExit.setForeground(Color.WHITE);
		pnlBtnExit.setBackground(new Color(0, 128, 128));
		pnlBtnExit.setBounds(10, 482, 142, 32);
		contentPane.add(pnlBtnExit);
		
		JLabel lblExit = new JLabel("EXIT");
		lblExit.setForeground(Color.WHITE);
		lblExit.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblExit.setBounds(53, 5, 36, 21);
		pnlBtnExit.add(lblExit);
		
		JLabel lblIconRoles = new JLabel("");
		lblIconRoles.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconRoles.setBounds(255, 60, 280, 161);
		contentPane.add(lblIconRoles);
		lblIconRoles.setIcon(new ImageIcon(img_Roles));
		
		lblErrorMessage = new JLabel("");
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMessage.setForeground(Color.ORANGE);
		lblErrorMessage.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblErrorMessage.setBounds(232, 444, 332, 28);
		contentPane.add(lblErrorMessage);
	}
	
	/**	This method sets an error message in the label	*/
	public void Error() {
		lblErrorMessage.setText("You have no access to this option.");
	}
	
	/** This method listens for mouse events on the official button
	 * 
	 * @param listenForOfficialButton the mouse event that triggers the method */
	public void addOfficialListener(MouseListener listenForOfficialButton) {
		pnlBtnOfficial.addMouseListener(listenForOfficialButton);
	}
	
	/** This method listens for mouse events on the tracer button
	 * 
	 * @param listenForTracerButton the mouse event that triggers the method */
	public void addTracerListener(MouseListener listenForTracerButton) {
		pnlBtnTracer.addMouseListener(listenForTracerButton);
	}
	
	/** This method listens for mouse events on the citizen button
	 * 
	 * @param listenForCitizenButton the mouse event that triggers the method */
	public void addCitizenListener(MouseListener listenForCitizenButton) {
		pnlBtnCitizen.addMouseListener(listenForCitizenButton);
	}
	
	/** This method listens for mouse events on the exit button
	 * 
	 * @param listenForExitButton the mouse event that triggers the method */
	public void addExitListener(MouseListener listenForExitButton) {
		pnlBtnExit.addMouseListener(listenForExitButton);
	}
}