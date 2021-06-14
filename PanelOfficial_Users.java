import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**	The PanelOfficial_Users is the display GUI of the list of users	*/
public class PanelOfficial_Users extends JPanel {
	/** Displays the information in table format */
	private JTable table;

	/**	The constructor calls the initComponents	*/
	public PanelOfficial_Users() {
		initComponents();
	}
	/**	The method creates the GUI list of users panel	*/
	private void initComponents() {
		setBackground(new Color(95, 158, 160));
		setBounds(0, 0, 575, 503);
		setLayout(null);
		setVisible(true);
		
		JLabel lblCases = new JLabel("LIST OF ALL USERS");
		lblCases.setForeground(new Color(224, 255, 255));
		lblCases.setFont(new Font("DialogInput", Font.BOLD, 22));
		lblCases.setHorizontalAlignment(SwingConstants.LEFT);
		lblCases.setBounds(21, 11, 410, 46);
		add(lblCases);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 68, 506, 387);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"USERNAME", "PASSWORD", "ROLE"
				}
		));
	}

	/** This method displays the citizens in a table format
	 * 
	 * @param citizens the array of citizens to be displayed */
	public void displayTable(ArrayList<Citizen> citizens) {

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		Object rowData[] = new Object[3];
		for(Citizen c : citizens) {
				rowData[0] = c.getUser().getUsername();
				rowData[1] = c.getUser().getPassword();
				rowData[2] = c.getRole();
				model.addRow(rowData);
		}
	}
}