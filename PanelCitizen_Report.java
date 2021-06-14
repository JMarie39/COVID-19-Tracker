import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;

/**	The PanelCitizen_Report is the display GUI panel of the report positive case	*/
public class PanelCitizen_Report extends JPanel {

	/**	Image icon of a report	*/
	private Image img_Report = new ImageIcon(PanelCitizen_Report.class.getResource("Res/ReportPositive.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
	/**	Image icon of a calendar	*/
	private Image img_Calendar = new ImageIcon(PanelCitizen_CheckIn.class.getResource("Res/Calendar.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	/**	Confirm panel button	*/
	private JPanel pnlBtnConfirm;
	/**	Month	*/
	private JTextField txtMonth;
	/**	Day	*/
	private JTextField txtDay;
	/**	Year	*/
	private JTextField txtYear;
	/**	Error message	*/
	private JLabel lblErrorMessage = new JLabel("");
	
	/**	The constructor creates the GUI report positive panel	*/
	public PanelCitizen_Report() {
		setBackground(new Color(95, 158, 160));
		setBounds(0, 0, 575, 503);
		setLayout(null);
		
		JLabel lblReport = new JLabel("REPORT POSITIVE");
		lblReport.setForeground(new Color(224, 255, 255));
		lblReport.setFont(new Font("DialogInput", Font.BOLD, 22));
		lblReport.setHorizontalAlignment(SwingConstants.LEFT);
		lblReport.setBounds(21, 11, 365, 46);
		add(lblReport);
		
		JLabel lblIconReport = new JLabel("");
		lblIconReport.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconReport.setBounds(21, 278, 240, 214);
		add(lblIconReport);
		lblIconReport.setIcon(new ImageIcon(img_Report));
		
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
		pnlDate.setBounds(21, 79, 538, 40);
		add(pnlDate);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setForeground(new Color(230, 230, 250));
		lblDate.setFont(new Font("DialogInput", Font.PLAIN, 20));
		lblDate.setBackground(new Color(230, 230, 250));
		lblDate.setBounds(10, 0, 518, 40);
		pnlDate.add(lblDate);
		
		JLabel lblIconDate = new JLabel("");
		lblIconDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconDate.setBounds(424, 0, 62, 40);
		pnlDate.add(lblIconDate);
		lblIconDate.setIcon(new ImageIcon(img_Calendar));
		
		JLabel lblMonth = new JLabel("MONTH : ");
		lblMonth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMonth.setForeground(Color.WHITE);
		lblMonth.setFont(new Font("DialogInput", Font.PLAIN, 15));
		lblMonth.setBounds(52, 147, 192, 26);
		add(lblMonth);
		
		JLabel lblDay = new JLabel("DAY : ");
		lblDay.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDay.setForeground(Color.WHITE);
		lblDay.setFont(new Font("DialogInput", Font.PLAIN, 15));
		lblDay.setBounds(62, 184, 182, 26);
		add(lblDay);
		
		JLabel lblYear = new JLabel("YEAR : ");
		lblYear.setHorizontalAlignment(SwingConstants.RIGHT);
		lblYear.setForeground(Color.WHITE);
		lblYear.setFont(new Font("DialogInput", Font.PLAIN, 15));
		lblYear.setBounds(72, 221, 172, 26);
		add(lblYear);
		
		JPanel pnlYear = new JPanel();
		pnlYear.setLayout(null);
		pnlYear.setBackground(Color.WHITE);
		pnlYear.setBounds(269, 221, 264, 26);
		add(pnlYear);
		
		txtYear = new JTextField();
		txtYear.setColumns(10);
		txtYear.setBorder(null);
		txtYear.setBounds(10, 0, 244, 26);
		pnlYear.add(txtYear);
		
		JPanel pnlDay = new JPanel();
		pnlDay.setLayout(null);
		pnlDay.setBackground(Color.WHITE);
		pnlDay.setBounds(269, 184, 264, 26);
		add(pnlDay);
		
		txtDay = new JTextField();
		txtDay.setColumns(10);
		txtDay.setBorder(null);
		txtDay.setBounds(10, 0, 244, 26);
		pnlDay.add(txtDay);
		
		JPanel pnlMonth = new JPanel();
		pnlMonth.setLayout(null);
		pnlMonth.setBackground(Color.WHITE);
		pnlMonth.setBounds(269, 147, 264, 26);
		add(pnlMonth);
		
		txtMonth = new JTextField();
		txtMonth.setColumns(10);
		txtMonth.setBorder(null);
		txtMonth.setBounds(10, 0, 244, 26);
		pnlMonth.add(txtMonth);
		
		lblErrorMessage = new JLabel("");
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMessage.setForeground(Color.ORANGE);
		lblErrorMessage.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblErrorMessage.setBounds(264, 427, 301, 28);
		add(lblErrorMessage);
	}
	
	/**	This method removes the texts and sets it to blank.	*/
	public void remove() {
		txtMonth.setText("");
		txtDay.setText("");
		txtYear.setText("");
		lblErrorMessage.setText("");
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

	/**	This method sets a success message in the label.	*/
	public void Success() {
		lblErrorMessage.setText("Report successful.");
	}
	
	/**	This method sets an error message in the label.	*/
	public void Error1() {
		lblErrorMessage.setText("Please input all requirements.");
	}
	
	/**	This method sets an error message in the label (if invalid date).	*/
	public void Error2() {
		lblErrorMessage.setText("Invalid date.");
	}

	/** This method listens for mouse events on the confirm button
	 * 
	 * @param listenForConfirmButton the mouse event that triggers the method */
	public void addConfirmListener(MouseListener listenForConfirmButton) {
		pnlBtnConfirm.addMouseListener(listenForConfirmButton);
	}
}
