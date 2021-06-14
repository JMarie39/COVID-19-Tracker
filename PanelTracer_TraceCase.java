import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

/**	The PanelTracer_TraceCase is the display GUI of the trace specific case	*/
public class PanelTracer_TraceCase extends JPanel {
	/**	Displays information in table format	*/
	private JTable table;
	/**	Case number	*/
	private JTextField txtCaseNum;
	/**	Confirm panel button	*/
	private JPanel pnlConfirm;
	/**	Error message */
	private JLabel lblErrorMessage = new JLabel("");

	/**	The constructor calls the initComponents	*/
	public PanelTracer_TraceCase() {
		initComponents();
	}
	
	/**	The method creates the GUI trace specific case panel	*/
	private void initComponents() {
		setBackground(new Color(95, 158, 160));
		setBounds(0, 0, 575, 503);
		setLayout(null);
		
		JLabel lblTerminate = new JLabel("TRACE SPECIFIC CASE");
		lblTerminate.setBounds(21, 11, 250, 46);
		lblTerminate.setForeground(new Color(224, 255, 255));
		lblTerminate.setFont(new Font("DialogInput", Font.BOLD, 22));
		lblTerminate.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblTerminate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 82, 515, 239);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"USERNAME", "ESTABLISHMENT CODE", "DATE"
				}
			));
		
		JLabel lblNewLabel = new JLabel("CASE NUMBER:");
		lblNewLabel.setFont(new Font("DialogInput", Font.PLAIN, 13));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(73, 382, 99, 14);
		add(lblNewLabel);
		
		pnlConfirm = new JPanel();
		pnlConfirm.addMouseListener(new PanelButtonMouseAdapter(pnlConfirm));
		pnlConfirm.setLayout(null);
		pnlConfirm.setBackground(new Color(0, 128, 128));
		pnlConfirm.setBounds(367, 466, 198, 26);
		add(pnlConfirm);
		
		JLabel lblConfirm = new JLabel("CONFIRM");
		lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirm.setForeground(Color.WHITE);
		lblConfirm.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblConfirm.setBounds(10, 0, 178, 25);
		pnlConfirm.add(lblConfirm);
		
		JPanel pnlCaseNum = new JPanel();
		pnlCaseNum.setLayout(null);
		pnlCaseNum.setBackground(Color.WHITE);
		pnlCaseNum.setBounds(181, 370, 264, 26);
		add(pnlCaseNum);
		
		txtCaseNum = new JTextField();
		txtCaseNum.setBounds(10, 0, 244, 26);
		pnlCaseNum.add(txtCaseNum);
		txtCaseNum.setFont(new Font("DialogInput", Font.PLAIN, 12));
		txtCaseNum.setBorder(null);
		txtCaseNum.setColumns(10);
		
		lblErrorMessage.setBounds(94, 405, 440, 28);
		lblErrorMessage.setForeground(Color.ORANGE);
		lblErrorMessage.setFont(new Font("DialogInput", Font.BOLD, 15));
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblErrorMessage);
	}
	
	/** This method listens for mouse events on the confirm button
	 * 
	 * @param listenForConfirmButton the mouse event that triggers the method */
	public void addConfirmListener(MouseListener listenForConfirmButton) {
		pnlConfirm.addMouseListener(listenForConfirmButton);
	}
	
	/** This method returns the case number text field
	 * 
	 * @return txtCaseNum the case number text field */
	public JTextField getTxtCaseNum() {
		return txtCaseNum;
	}
	/** This method displays the visits in a table format
	 * 
	 * @param visits the array of visit records to be displayed */
	public void displayTable(ArrayList<VisitRecord> visits) {

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		Object rowData[] = new Object[3];
		for(VisitRecord v : visits) {
			rowData[0] = v.getUsername();
			rowData[1] = v.getCode();
			rowData[2] = v.getDate();
			model.addRow(rowData);
		}
	}
	
	/**	This method removes the texts and sets it to blank.	*/
	public void remove() {
		txtCaseNum.setText("");
		lblErrorMessage.setText("");
	}
	
	/**	This method sets an error message in the label.	*/
	public void Error() {
		lblErrorMessage.setText("Please fill the necessary fields");
	}
	
	/**	This method sets an error message in the label.	*/
	public void Error2() {
		lblErrorMessage.setText("Invalid case number");
	}
}