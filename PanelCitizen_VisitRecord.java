import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import java.util.ArrayList;

/**	The PanelCitizen_VisitRecord is the display GUI of the list of visited place of the user.	*/
public class PanelCitizen_VisitRecord extends JPanel {
	
	/**	Display information in table format */
	private JTable table;

	/**	The constructor calls the initComponents	*/
	public PanelCitizen_VisitRecord() {
		initComponents();
	}
	
	/**	The method create the GUI view establishment record panel	*/
	private void initComponents() {
		setBackground(new Color(95, 158, 160));
		setBounds(0, 0, 575, 503);
		setLayout(null);
		setVisible(true);
		
		JLabel lblVisitRecord = new JLabel("VIEW VISIT ESTABLISHMENT RECORD");
		lblVisitRecord.setForeground(new Color(224, 255, 255));
		lblVisitRecord.setFont(new Font("DialogInput", Font.BOLD, 22));
		lblVisitRecord.setHorizontalAlignment(SwingConstants.LEFT);
		lblVisitRecord.setBounds(21, 11, 410, 46);
		add(lblVisitRecord);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 83, 492, 386);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"ESTABLISHMENT CODE", "CHECK-IN DATE", "CHECK-IN TIME"
				}
			));
	}

	/** This method displays the visit record array in the table
	 * 
	 * @param visits the array of visit records to be displayed */
	public void displayTable(ArrayList<VisitRecord> visits) {
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		Object rowData[] = new Object[3];
		for(VisitRecord v : visits) {
				rowData[0] = v.getCode();
				rowData[1] = v.getDate();
				rowData[2] = v.getTime();
				model.addRow(rowData);
		}
	}
}
