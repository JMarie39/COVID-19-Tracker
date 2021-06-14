import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**	The PanelTracer_Inform is the display GUI to inform the citizens	*/
public class PanelTracer_Inform extends JPanel {
	/**	Image icon	*/
	private Image img_Inform = new ImageIcon(SignIn_View.class.getResource("Res/Inform.png")).getImage().getScaledInstance(165, 165, Image.SCALE_SMOOTH);
	/**	Confirm button panel	*/
	private JPanel pnlBtnConfirm;
	
	/**	The method creates the GUI inform citizens panel	*/
	public PanelTracer_Inform() {
		setBackground(new Color(95, 158, 160));
		setBounds(0, 0, 575, 503);
		setLayout(null);
		
		JLabel lblTerminate = new JLabel("INFORM CITIZENS");
		lblTerminate.setBounds(21, 11, 250, 46);
		lblTerminate.setForeground(new Color(224, 255, 255));
		lblTerminate.setFont(new Font("DialogInput", Font.BOLD, 22));
		lblTerminate.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblTerminate);
		
		JLabel lblIconInform = new JLabel("");
		lblIconInform.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconInform.setBounds(99, 78, 376, 232);
		add(lblIconInform);
		lblIconInform.setIcon(new ImageIcon(img_Inform));
		
		pnlBtnConfirm = new JPanel();
		pnlBtnConfirm.addMouseListener(new PanelButtonMouseAdapter(pnlBtnConfirm));
		pnlBtnConfirm.setLayout(null);
		pnlBtnConfirm.setBackground(new Color(0, 128, 128));
		pnlBtnConfirm.setBounds(367, 466, 198, 26);
		add(pnlBtnConfirm);
		
		JLabel label = new JLabel("CONFIRM");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("DialogInput", Font.BOLD, 15));
		label.setBounds(10, 0, 178, 25);
		pnlBtnConfirm.add(label);
	}

	/** This method listens for mouse events on the confirm button
	 * 
	 * @param listenForConfirmButton the mouse event that triggers the method */
	public void addConfirmListener(MouseListener listenForConfirmButton) {
		pnlBtnConfirm.addMouseListener(listenForConfirmButton);
	}
	
	/**	This method display a message when users are informed	*/
	public void inform() {
		JOptionPane.showMessageDialog(null, "Exposed users informed!");
	}
	
	/**	This method display a message when no tracing has been done	*/
	public void notTraced() {
		JOptionPane.showMessageDialog(null, "Please trace a specific case first.");
	}
}