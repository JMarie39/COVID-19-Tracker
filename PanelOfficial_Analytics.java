import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

/**	The PanelOfficial_Analytics is the display GUI of the list of analytics	*/
public class PanelOfficial_Analytics extends JPanel {
	
	/**	Image icon of a place	*/
	private Image img_Place = new ImageIcon(PanelOfficial_Analytics.class.getResource("Res/Place.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	/**	Image icon of a calendar	*/
	private Image img_Calendar = new ImageIcon(PanelOfficial_Analytics.class.getResource("Res/Calendar.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	/**	Establishment code	*/
	private JTextField txtEstCode;
	/**	Assigned tracer	*/
	private JTextField txtAssignTrace;
	/**	Starting month	*/
	private JTextField txtStartMonth;
	/**	Starting day */
	private JTextField txtStartDay;
	/**	Starting year*/
	private JTextField txtStartYear;
	/**	Ending month	*/
	private JTextField txtEndMonth;
	/**	Ending day	*/
	private JTextField txtEndDay;
	/**	Ending year	*/
	private JTextField txtEndYear;
	/**	Display the cases	*/
	private JTextArea txtCases;
	/**	Confirm panel button	*/
	private JPanel pnlBtnConfirm;
	/**	Error message	*/
	private JLabel lblError;

	/**	The constructor calls the initComponents	*/
	public PanelOfficial_Analytics() {
		initComponents();
	}
	
	/**	The method creates the GUI analytics panel	*/
	private void initComponents() {
		setBackground(new Color(95, 158, 160));
		setBounds(0, 0, 575, 503);
		setLayout(null);
		
		JLabel lblAnalytics = new JLabel("ANALYTICS");
		lblAnalytics.setBounds(21, 11, 250, 46);
		lblAnalytics.setForeground(new Color(224, 255, 255));
		lblAnalytics.setFont(new Font("DialogInput", Font.BOLD, 22));
		lblAnalytics.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblAnalytics);
		
		JPanel pnlEstCode = new JPanel();
		pnlEstCode.setBorder(new EmptyBorder(3, 0, 0, 3));
		pnlEstCode.setBackground(new Color(255, 255, 255));
		pnlEstCode.setBounds(21, 119, 264, 26);
		add(pnlEstCode);
		pnlEstCode.setLayout(null);
		
		txtEstCode = new JTextField();
		txtEstCode.setBorder(null);
		txtEstCode.setBounds(10, 0, 244, 26);
		pnlEstCode.add(txtEstCode);
		txtEstCode.setColumns(10);
		
		txtStartMonth = new JTextField();
		txtStartMonth.setColumns(10);
		txtStartMonth.setBorder(null);
		txtStartMonth.setBounds(113, 242, 129, 26);
		add(txtStartMonth);
		
		JPanel pnlMonth = new JPanel();
		pnlMonth.setBorder(new EmptyBorder(3, 0, 0, 3));
		pnlMonth.setBackground(Color.WHITE);
		pnlMonth.setBounds(103, 242, 149, 26);
		add(pnlMonth);
		pnlMonth.setLayout(null);
		
		JPanel pnlDay = new JPanel();
		pnlDay.setBorder(new EmptyBorder(3, 0, 0, 3));
		pnlDay.setBackground(Color.WHITE);
		pnlDay.setBounds(103, 279, 149, 26);
		add(pnlDay);
		pnlDay.setLayout(null);
		
		txtStartDay = new JTextField();
		txtStartDay.setColumns(10);
		txtStartDay.setBorder(null);
		txtStartDay.setBounds(10, 0, 129, 26);
		pnlDay.add(txtStartDay);
		
		JPanel pnlYear = new JPanel();
		pnlYear.setLayout(null);
		pnlYear.setBorder(new EmptyBorder(3, 0, 0, 3));
		pnlYear.setBackground(Color.WHITE);
		pnlYear.setBounds(103, 316, 149, 26);
		add(pnlYear);
		
		txtStartYear = new JTextField();
		txtStartYear.setColumns(10);
		txtStartYear.setBorder(null);
		txtStartYear.setBounds(10, 0, 129, 26);
		pnlYear.add(txtStartYear);
		
		JLabel lblMonth = new JLabel("MONTH : ");
		lblMonth.setForeground(new Color(255, 255, 255));
		lblMonth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMonth.setFont(new Font("DialogInput", Font.PLAIN, 14));
		lblMonth.setBounds(7, 237, 96, 34);
		add(lblMonth);
		
		JLabel lblDay = new JLabel("DAY : ");
		lblDay.setForeground(new Color(255, 255, 255));
		lblDay.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDay.setFont(new Font("DialogInput", Font.PLAIN, 14));
		lblDay.setBounds(21, 271, 80, 34);
		add(lblDay);
		
		JLabel lblYear = new JLabel("YEAR : ");
		lblYear.setForeground(new Color(255, 255, 255));
		lblYear.setHorizontalAlignment(SwingConstants.RIGHT);
		lblYear.setFont(new Font("DialogInput", Font.PLAIN, 14));
		lblYear.setBounds(21, 308, 80, 34);
		add(lblYear);
		
		JPanel pnlEst = new JPanel();
		pnlEst.setBorder(new MatteBorder(4, 0, 4, 0, (Color) new Color(173, 216, 230)));
		pnlEst.setLayout(null);
		pnlEst.setBackground(new Color(95, 158, 160));
		pnlEst.setBounds(21, 68, 264, 40);
		add(pnlEst);
		
		JLabel lblEst = new JLabel("ESTABLISHMENT CODE");
		lblEst.setHorizontalAlignment(SwingConstants.CENTER);
		lblEst.setForeground(new Color(230, 230, 250));
		lblEst.setFont(new Font("Dubai", Font.PLAIN, 17));
		lblEst.setBackground(new Color(230, 230, 250));
		lblEst.setBounds(10, 0, 187, 40);
		pnlEst.add(lblEst);
		
		JLabel lblIconPlace = new JLabel("");
		lblIconPlace.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconPlace.setBounds(207, 0, 47, 40);
		pnlEst.add(lblIconPlace);
		lblIconPlace.setIcon(new ImageIcon(img_Place));
		
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
		
		JPanel pnlDate = new JPanel();
		pnlDate.setLayout(null);
		pnlDate.setBorder(new MatteBorder(4, 0, 4, 0, (Color) new Color(173, 216, 230)));
		pnlDate.setBackground(new Color(95, 158, 160));
		pnlDate.setBounds(21, 156, 538, 40);
		add(pnlDate);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setForeground(new Color(230, 230, 250));
		lblDate.setFont(new Font("Dubai", Font.PLAIN, 17));
		lblDate.setBackground(new Color(230, 230, 250));
		lblDate.setBounds(10, 0, 511, 40);
		pnlDate.add(lblDate);
		
		JLabel lblIconDate = new JLabel("");
		lblIconDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconDate.setBounds(368, 0, 62, 40);
		pnlDate.add(lblIconDate);
		lblIconDate.setIcon(new ImageIcon(img_Calendar));
		
		JPanel pnlAnalytics = new JPanel();
		pnlAnalytics.setBackground(new Color(255, 255, 255));
		pnlAnalytics.setBounds(27, 365, 532, 64);
		add(pnlAnalytics);
		pnlAnalytics.setLayout(null);
		
		txtCases = new JTextArea();
		txtCases.setBounds(0, 0, 532, 64);
		txtCases.setFont(new Font("DialogInput", Font.PLAIN, 14));
		txtCases.setRows(2);
		pnlAnalytics.add(txtCases);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBackground(Color.WHITE);
		panel.setBounds(377, 242, 149, 26);
		add(panel);
		panel.setLayout(null);
		
		txtEndMonth = new JTextField();
		txtEndMonth.setBorder(null);
		txtEndMonth.setBounds(10, 0, 129, 26);
		panel.add(txtEndMonth);
		txtEndMonth.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(377, 279, 149, 26);
		add(panel_1);
		panel_1.setLayout(null);
		
		txtEndDay = new JTextField();
		txtEndDay.setBorder(null);
		txtEndDay.setBounds(10, 0, 129, 26);
		panel_1.add(txtEndDay);
		txtEndDay.setColumns(10);
		
		JLabel label = new JLabel("MONTH : ");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("DialogInput", Font.PLAIN, 14));
		label.setBounds(-39, -39, 96, 34);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("DAY : ");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("DialogInput", Font.PLAIN, 14));
		label_1.setBounds(-25, -5, 80, 34);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("YEAR : ");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("DialogInput", Font.PLAIN, 14));
		label_2.setBounds(-25, 32, 80, 34);
		panel_1.add(label_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(377, 317, 149, 25);
		add(panel_2);
		panel_2.setLayout(null);
		
		txtEndYear = new JTextField();
		txtEndYear.setBorder(null);
		txtEndYear.setText("");
		txtEndYear.setBounds(10, 0, 129, 25);
		panel_2.add(txtEndYear);
		txtEndYear.setColumns(10);
		
		JLabel lblStart = new JLabel("START DATE");
		lblStart.setHorizontalAlignment(SwingConstants.CENTER);
		lblStart.setForeground(new Color(240, 248, 255));
		lblStart.setFont(new Font("DialogInput", Font.BOLD, 17));
		lblStart.setBounds(31, 207, 221, 21);
		add(lblStart);
		
		JLabel label_3 = new JLabel("MONTH : ");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("DialogInput", Font.PLAIN, 14));
		label_3.setBounds(284, 237, 96, 34);
		add(label_3);
		
		JLabel label_4 = new JLabel("DAY : ");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("DialogInput", Font.PLAIN, 14));
		label_4.setBounds(298, 271, 80, 34);
		add(label_4);
		
		JLabel label_5 = new JLabel("YEAR : ");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("DialogInput", Font.PLAIN, 14));
		label_5.setBounds(298, 308, 80, 34);
		add(label_5);
		
		JLabel lblEndDate = new JLabel("END DATE");
		lblEndDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndDate.setForeground(new Color(240, 248, 255));
		lblEndDate.setFont(new Font("DialogInput", Font.BOLD, 17));
		lblEndDate.setBounds(296, 210, 230, 21);
		add(lblEndDate);
		
		lblError = new JLabel("");
		lblError.setHorizontalAlignment(SwingConstants.RIGHT);
		lblError.setFont(new Font("DialogInput", Font.PLAIN, 13));
		lblError.setForeground(Color.ORANGE);
		lblError.setBounds(41, 466, 305, 26);
		add(lblError);
	}
	
	/**	This method removes the texts and sets it to blank.	*/
	public void remove() {
		lblError.setText("");
		txtEstCode.setText("");
		txtStartMonth.setText("");
		txtStartDay.setText("");
		txtStartYear.setText("");
		txtEndMonth.setText("");
		txtEndDay.setText("");
		txtEndYear.setText("");
		txtCases.setText("");
	}
	
	/**	This method returns the textfield establishment code.
	 * 
	 * 	@return establishment code	*/
	public JTextField getTxtEstCode() {
		return txtEstCode;
	}
	
	/**	This method returns the textfield of the assigned traces.
	 * 
	 * 	@return assigned tracer	*/
	public JTextField getTxtAssignTrace() {
		return txtAssignTrace;
	}
	
	/**	This method returns the textfield of the start month.
	 * 
	 * 	@return start month	*/
	public JTextField getTxtMonth() {
		return txtStartMonth;
	}
	
	/**	This method returns the textfield of the start day.
	 * 
	 * 	@return start day	*/
	public JTextField getTxtDay() {
		return txtStartDay;
	}
	
	/**	This method returns the textfield of the start year.
	 * 
	 * 	@return start year	*/
	public JTextField getTxtYear() {
		return txtStartYear;
	}
	
	/**	This method returns the textfield of the end month.
	 * 
	 * 	@return end month	*/
	public JTextField getTxtEndMonth() {
		return txtEndMonth;
	}
	
	/**	This method returns the textfield of the end day.
	 * 
	 * 	@return end day	*/
	public JTextField getTxtEndDay() {
		return txtEndDay;
	}
	
	/**	This method returns the textfield of the end year.
	 * 
	 * 	@return end year	*/
	public JTextField getTxtEndYear() {
		return txtEndYear;
	}
	
	/**	This method sets an error message in the label.	*/
	public void Error() {
		lblError.setText("Please fill the necessary fields");
	}
	
	/** This method sets the analytics results in the text area
	 * 
	 * @param analytics the results of the analytics*/
	public void setLblCases(String analytics) {
		txtCases.setText(analytics);
	}
	
	/** This method listens for mouse events on the confirm button
	 * 
	 * @param listenForConfirmButton the mouse event that triggers the method */
	public void addConfirmListener(MouseListener listenForConfirmButton) {
		pnlBtnConfirm.addMouseListener(listenForConfirmButton);
	}
}