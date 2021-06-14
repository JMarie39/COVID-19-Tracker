import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

/**	The PanelOfficial_Case is the display GUI of the unassigned cases	*/
public class PanelOfficial_Case extends JPanel {
	
	/**	Image icon of an assigned tracer	*/
	private Image img_Assign = new ImageIcon(PanelOfficial_Analytics.class.getResource("Res/AssignTracer.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	/**	Confirm panel button	*/
	private JPanel pnlBtnConfirm;
	/**	Case number	*/
	private JTextField txtCaseNum;
	/**	Assign Tracer	*/
	private JTextField txtTracer;
	/**	Display in table format	*/
	private JTable table;
	/**	Error message	*/
	private JLabel lblError;

	/**	The constructor calls the initComponents	*/
	public PanelOfficial_Case() {
		initComponents();
	}
	/**	The method creates the GUI unassigned cases panel	*/
	private void initComponents() {
		setBackground(new Color(95, 158, 160));
		setBounds(0, 0, 575, 503);
		setLayout(null);
		setVisible(true);
		
		JLabel lblCases = new JLabel("SHOW UNASSIGNED CASES");
		lblCases.setForeground(new Color(224, 255, 255));
		lblCases.setFont(new Font("DialogInput", Font.BOLD, 22));
		lblCases.setHorizontalAlignment(SwingConstants.LEFT);
		lblCases.setBounds(21, 11, 410, 46);
		add(lblCases);
		
		JPanel pnlAssign = new JPanel();
		pnlAssign.setLayout(null);
		pnlAssign.setBorder(new MatteBorder(4, 0, 4, 0, (Color) new Color(173, 216, 230)));
		pnlAssign.setBackground(new Color(95, 158, 160));
		pnlAssign.setBounds(41, 326, 496, 40);
		add(pnlAssign);
		
		
		JLabel lblAssignTracer = new JLabel("ASSIGN TRACER");
		lblAssignTracer.setHorizontalAlignment(SwingConstants.CENTER);
		lblAssignTracer.setForeground(new Color(230, 230, 250));
		lblAssignTracer.setFont(new Font("Dubai", Font.PLAIN, 17));
		lblAssignTracer.setBackground(new Color(230, 230, 250));
		lblAssignTracer.setBounds(10, 0, 476, 40);
		pnlAssign.add(lblAssignTracer);
		
		JLabel lblIconAssign = new JLabel("");
		lblIconAssign.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconAssign.setBounds(363, 0, 46, 40);
		pnlAssign.add(lblIconAssign);
		lblIconAssign.setIcon(new ImageIcon(img_Assign));
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 68, 506, 248);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"CASE NUMBER", "USERNAME", "DATE"
				}
		));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBackground(Color.WHITE);
		panel.setBounds(231, 377, 229, 26);
		add(panel);
		panel.setLayout(null);
		
		txtCaseNum = new JTextField();
		txtCaseNum.setBorder(null);
		txtCaseNum.setBackground(Color.WHITE);
		txtCaseNum.setBounds(10, 0, 209, 25);
		panel.add(txtCaseNum);
		txtCaseNum.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(231, 420, 229, 26);
		add(panel_1);
		panel_1.setLayout(null);
		
		txtTracer = new JTextField();
		txtTracer.setBorder(null);
		txtTracer.setBounds(10, 0, 209, 26);
		panel_1.add(txtTracer);
		txtTracer.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CASE NUMBER:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("DialogInput", Font.PLAIN, 13));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(103, 377, 109, 26);
		add(lblNewLabel);
		
		JLabel lblTracer = new JLabel("TRACER:");
		lblTracer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTracer.setFont(new Font("DialogInput", Font.PLAIN, 13));
		lblTracer.setForeground(Color.WHITE);
		lblTracer.setBounds(103, 420, 109, 26);
		add(lblTracer);
		
		lblError = new JLabel("");
		lblError.setHorizontalAlignment(SwingConstants.RIGHT);
		lblError.setFont(new Font("DialogInput", Font.PLAIN, 13));
		lblError.setForeground(Color.ORANGE);
		lblError.setBounds(41, 466, 305, 26);
		add(lblError);
	}
	
	/**	This method removes the texts and sets it to blank.	*/
	public void Clear() {
		lblError.setText("");
		txtCaseNum.setText("");
		txtTracer.setText("");
	}
	
	/**	This method returns the textfield of the case number.
	 * 
	 * 	@return case number	*/
	public JTextField getTxtCaseNum() {
		return txtCaseNum;
	}
	
	/**	This method returns the textfield of the case number.
	 * 
	 * 	@return case number	*/
	public JTextField getTxtTracer() {
		return txtTracer;
	}
	
	/**	This method sets an error message in the label (if invalid case number).	*/
	public void Error1() {
		lblError.setText("Invalid Case");
	}
	
	/**	This method sets an error message in the label (if invalid tracer).	*/
	public void Error2() {
		lblError.setText("Invalid Tracer");
	}
	
	/**	This method sets an error message in the label.	*/
	public void Error3() {
		lblError.setText("Please fill all fields");
	}

	/** This method displays the cases in a table format
	 * 
	 * @param cases the array of cases to be displayed */
	public void displayTable(ArrayList<Case> cases) {

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		Object rowData[] = new Object[3];
		for(Case c : cases) {
			if(c.getTracer().equals("000")) {
				rowData[0] = c.getCaseNum();
				rowData[1] = c.getUser();
				rowData[2] = c.getDate();
				model.addRow(rowData);
			}
		}
	}
	
	/** This method listens for mouse events on the confirm button
	 * 
	 * @param listenForConfirmButton the mouse event that triggers the method */
	public void addConfirmListener(MouseListener listenForConfirmButton) {
		pnlBtnConfirm.addMouseListener(listenForConfirmButton);
	}
}