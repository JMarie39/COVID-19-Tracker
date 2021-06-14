import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

/**	The PanelTracer_ShowCase is the display GUI of the show cases	*/
public class PanelTracer_ShowCase extends JPanel {
	/**	Display the information in table format	*/
	private JTable table;

	/**	The constructor calls the initComponents	*/
	public PanelTracer_ShowCase() {
		initComponents();
	}
	
	/**	The method creates the GUI show cases panel	*/
	private void initComponents() {
		setBackground(new Color(95, 158, 160));
		setBounds(0, 0, 575, 503);
		setLayout(null);
		
		JLabel lblTerminate = new JLabel("SHOW CASES");
		lblTerminate.setBounds(21, 11, 250, 46);
		lblTerminate.setForeground(new Color(224, 255, 255));
		lblTerminate.setFont(new Font("DialogInput", Font.BOLD, 22));
		lblTerminate.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblTerminate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 68, 482, 397);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"CASE NUMBER", "USERNAME", "DATE"
				}
			));
	}
	
	/** This method displays the cases in a table format
	 * 
	 * @param cases the array of cases to be displayed */
	public void displayTable(ArrayList<Case> cases) {

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		Object rowData[] = new Object[3];
		for(Case c : cases) {
			rowData[0] = c.getCaseNum();
			rowData[1] = c.getUser();
			rowData[2] = c.getDate();
			model.addRow(rowData);
		}
	}
}