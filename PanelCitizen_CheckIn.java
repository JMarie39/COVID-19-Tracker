import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

/**	The PanelCitizen_CheckIn is the display panel for the check- in citizen option.	*/
public class PanelCitizen_CheckIn extends JPanel {
	
	/**	Image icon of a place	*/
	private Image img_Place = new ImageIcon(PanelCitizen_CheckIn.class.getResource("Res/Place.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	/**	Image icon of a calendar	*/
	private Image img_Calendar = new ImageIcon(PanelCitizen_CheckIn.class.getResource("Res/Calendar.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	/**	Month	*/
	private JTextField txtMonth;
	/**	Day */
	private JTextField txtDay;
	/**	Year	*/
	private JTextField txtYear;
	/**	Establishment code */
	private JTextField txtEstCode;
	/**	Confirm panel button	*/
	private JPanel pnlBtnConfirm;
	/**	Error message	*/
	private JLabel lblErrorMessage = new JLabel("");
	
	/**	The constructor creates the GUI check- in panel	*/
	public PanelCitizen_CheckIn() {
		setBorder(new EmptyBorder(4, 0, 4, 0));
		setBackground(new Color(95, 158, 160));
		setBounds(0, 0, 575, 503);
		setLayout(null);
		
		JLabel lblCheckIn = new JLabel("CHECKED IN");
		lblCheckIn.setBounds(21, 11, 250, 46);
		lblCheckIn.setForeground(new Color(224, 255, 255));
		lblCheckIn.setFont(new Font("DialogInput", Font.BOLD, 22));
		lblCheckIn.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblCheckIn);
		
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
		
		JPanel pnlMonth = new JPanel();
		pnlMonth.setBackground(new Color(255, 255, 255));
		pnlMonth.setBounds(269, 276, 264, 26);
		add(pnlMonth);
		pnlMonth.setLayout(null);
		
		txtMonth = new JTextField();
		txtMonth.setBorder(null);
		txtMonth.setBounds(10, 0, 244, 26);
		pnlMonth.add(txtMonth);
		txtMonth.setColumns(10);
		
		JPanel pnlDay = new JPanel();
		pnlDay.setBackground(new Color(255, 255, 255));
		pnlDay.setBounds(269, 313, 264, 26);
		add(pnlDay);
		pnlDay.setLayout(null);
		
		txtDay = new JTextField();
		txtDay.setBorder(null);
		txtDay.setBounds(10, 0, 244, 26);
		pnlDay.add(txtDay);
		txtDay.setColumns(10);
		
		JPanel pnlYear = new JPanel();
		pnlYear.setBackground(new Color(255, 255, 255));
		pnlYear.setBounds(269, 350, 264, 26);
		add(pnlYear);
		pnlYear.setLayout(null);
		
		txtYear = new JTextField();
		txtYear.setBorder(null);
		txtYear.setBounds(10, 0, 244, 26);
		pnlYear.add(txtYear);
		txtYear.setColumns(10);
		
		JLabel lblMonth = new JLabel("MONTH : ");
		lblMonth.setForeground(new Color(255, 255, 255));
		lblMonth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMonth.setFont(new Font("DialogInput", Font.PLAIN, 15));
		lblMonth.setBounds(52, 276, 192, 26);
		add(lblMonth);
		
		JLabel lblDay = new JLabel("DAY : ");
		lblDay.setForeground(new Color(255, 255, 255));
		lblDay.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDay.setFont(new Font("DialogInput", Font.PLAIN, 15));
		lblDay.setBounds(62, 313, 182, 26);
		add(lblDay);
		
		JLabel lblYear = new JLabel("YEAR : ");
		lblYear.setForeground(new Color(255, 255, 255));
		lblYear.setHorizontalAlignment(SwingConstants.RIGHT);
		lblYear.setFont(new Font("DialogInput", Font.PLAIN, 15));
		lblYear.setBounds(72, 350, 172, 26);
		add(lblYear);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(4, 0, 4, 0, (Color) new Color(173, 216, 230)));
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(21, 208, 538, 40);
		add(panel);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setForeground(new Color(230, 230, 250));
		lblDate.setFont(new Font("DialogInput", Font.PLAIN, 20));
		lblDate.setBackground(new Color(230, 230, 250));
		lblDate.setBounds(10, 0, 518, 40);
		panel.add(lblDate);
		
		JLabel lblIconDate = new JLabel("");
		lblIconDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconDate.setBounds(424, 0, 62, 40);
		panel.add(lblIconDate);
		lblIconDate.setIcon(new ImageIcon(img_Calendar));
		
		JPanel pnlEst = new JPanel();
		pnlEst.setLayout(null);
		pnlEst.setBorder(new MatteBorder(4, 0, 4, 0, (Color) new Color(173, 216, 230)));
		pnlEst.setBackground(new Color(95, 158, 160));
		pnlEst.setBounds(21, 84, 538, 40);
		add(pnlEst);
		
		JLabel lblEst = new JLabel("ESTABLISHMENT CODE");
		lblEst.setHorizontalAlignment(SwingConstants.CENTER);
		lblEst.setForeground(new Color(230, 230, 250));
		lblEst.setFont(new Font("DialogInput", Font.PLAIN, 20));
		lblEst.setBackground(new Color(230, 230, 250));
		lblEst.setBounds(0, 0, 538, 40);
		pnlEst.add(lblEst);
		
		JLabel lblIconPlace = new JLabel("");
		lblIconPlace.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconPlace.setBounds(430, 0, 47, 40);
		pnlEst.add(lblIconPlace);
		lblIconPlace.setIcon(new ImageIcon(img_Place));
		
		JPanel pnlEstCode = new JPanel();
		pnlEstCode.setLayout(null);
		pnlEstCode.setBorder(new EmptyBorder(3, 0, 0, 3));
		pnlEstCode.setBackground(Color.WHITE);
		pnlEstCode.setBounds(269, 147, 264, 26);
		add(pnlEstCode);
		
		txtEstCode = new JTextField();
		txtEstCode.setBounds(10, 0, 244, 26);
		pnlEstCode.add(txtEstCode);
		txtEstCode.setColumns(10);
		txtEstCode.setBorder(null);
		
		JLabel lblEstablishmentCode = new JLabel("ESTABLISHMENT CODE : ");
		lblEstablishmentCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstablishmentCode.setForeground(Color.WHITE);
		lblEstablishmentCode.setFont(new Font("DialogInput", Font.PLAIN, 15));
		lblEstablishmentCode.setBounds(41, 147, 203, 26);
		add(lblEstablishmentCode);
		
		lblErrorMessage.setForeground(Color.ORANGE);
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMessage.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblErrorMessage.setBounds(264, 427, 301, 28);
		add(lblErrorMessage);
	}
	
	/**	This method removes the texts and sets it to blank.	*/
	public void remove() {
		txtMonth.setText("");
		txtDay.setText("");
		txtYear.setText("");
		txtEstCode.setText("");
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

	/**	This method returns the textfield of the establishment code.
	 * 
	 * 	@return establishment code	*/
	public JTextField getTxtEstCode() {
		return txtEstCode;
	}
	
	/**	This method sets a success message in the label.	*/
	public void Success() {
		lblErrorMessage.setText("Successfully checked- in.");
	}
	
	/**	This method sets an error message in the label.	*/
	public void Error1() {
		lblErrorMessage.setText("Please input all requirements.");
	}
	
	/**	This method sets an error message for the date in the label.	*/
	public void Error2() {
		lblErrorMessage.setText("Invalid date.");
	}
	
	/** This method shows the time check- in of the user.
	 * 
	 * @param time the time to be displayed in the pop-up */
	public void timePopup(int time) {
		JOptionPane.showMessageDialog(null, "Check-in Time(Military time): " + time);
	}

	/** This method listens for mouse events on the confirm button
	 * 
	 * @param listenForConfirmButton the mouse event that triggers the method */
	public void addConfirmListener(MouseListener listenForConfirmButton) {
		pnlBtnConfirm.addMouseListener(listenForConfirmButton);
	}
}