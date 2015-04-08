package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class ClientApplicationView {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientApplicationView window = new ClientApplicationView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClientApplicationView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 238, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JRadioButton rdbtnLastDays = new JRadioButton("Last 7 days");
		buttonGroup_1.add(rdbtnLastDays);
		rdbtnLastDays.setBounds(18, 30, 141, 23);
		frame.getContentPane().add(rdbtnLastDays);
		
		JRadioButton rdbtnLastDays_1 = new JRadioButton("Last 30 days");
		buttonGroup_1.add(rdbtnLastDays_1);
		rdbtnLastDays_1.setBounds(18, 66, 141, 23);
		frame.getContentPane().add(rdbtnLastDays_1);
		
		JRadioButton rdbtnLastDays_2 = new JRadioButton("Last 365 days");
		buttonGroup_1.add(rdbtnLastDays_2);
		rdbtnLastDays_2.setBounds(18, 101, 141, 23);
		frame.getContentPane().add(rdbtnLastDays_2);
		
		JRadioButton rdbtnAllData = new JRadioButton("All data");
		buttonGroup_1.add(rdbtnAllData);
		rdbtnAllData.setBounds(18, 136, 141, 23);
		frame.getContentPane().add(rdbtnAllData);
		
		JButton btnObtainData = new JButton("Obtain data");
		btnObtainData.setBounds(17, 186, 117, 29);
		frame.getContentPane().add(btnObtainData);
	}
}
