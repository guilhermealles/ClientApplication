package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

import model.DatabaseRequest;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class ClientApplicationView {

	private JFrame frame;
	private static ButtonGroup buttonGroup;
	private JTextField outletSelectionTextField;

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
		
		buttonGroup = new ButtonGroup();
		
		JRadioButton rdbtnLastSevenDays = new JRadioButton("Last 7 Days", false);
		rdbtnLastSevenDays.setBounds(17, 6, 141, 23);
		buttonGroup.add(rdbtnLastSevenDays);
		frame.getContentPane().add(rdbtnLastSevenDays);
		
		JRadioButton rdbtnLastThirtyDays = new JRadioButton("Last 30 Days", false);
		rdbtnLastThirtyDays.setBounds(17, 41, 141, 23);
		buttonGroup.add(rdbtnLastThirtyDays);
		frame.getContentPane().add(rdbtnLastThirtyDays);
		
		JRadioButton rdbtnLastThreeSixFiveDays = new JRadioButton("Last 365 Days", false);
		rdbtnLastThreeSixFiveDays.setBounds(17, 76, 141, 23);
		buttonGroup.add(rdbtnLastThreeSixFiveDays);
		frame.getContentPane().add(rdbtnLastThreeSixFiveDays);
		
		JRadioButton rdbtnAllData = new JRadioButton("All Data", true);
		rdbtnAllData.setBounds(17, 111, 141, 23);
		buttonGroup.add(rdbtnAllData);
		frame.getContentPane().add(rdbtnAllData);
		
		outletSelectionTextField = new JTextField();
		outletSelectionTextField.setText("0");
		outletSelectionTextField.setBounds(17, 153, 44, 23);
		frame.getContentPane().add(outletSelectionTextField);
		outletSelectionTextField.setColumns(2);
		
		JLabel lblOutletSelector = new JLabel("Outlet selector");
		lblOutletSelector.setBounds(62, 157, 141, 16);
		frame.getContentPane().add(lblOutletSelector);
		
		JLabel lblLeaveAt = new JLabel("Leave at 0 to get all outlets");
		lblLeaveAt.setFont(new Font("Lucida Grande", Font.ITALIC, 9));
		lblLeaveAt.setBounds(17, 174, 186, 16);
		frame.getContentPane().add(lblLeaveAt);
		
		JButton btnRetrieveData = new JButton("Retrieve data");
		btnRetrieveData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int mode = 0;
				if (rdbtnLastSevenDays.isSelected()) {
					mode = DatabaseRequest.LAST_7_DAYS;
				}
				else if (rdbtnLastThirtyDays.isSelected()) {
					mode = DatabaseRequest.LAST_30_DAYS;
				}
				else if (rdbtnLastThreeSixFiveDays.isSelected()) {
					mode = DatabaseRequest.LAST_365_DAYS;
				}
				else if (rdbtnAllData.isSelected()) {
					mode = DatabaseRequest.ALL_DATA;
				}
				
				int outlet = 0;
				outlet = Integer.parseInt(outletSelectionTextField.getText());
				
				retrieveData(mode, outlet);
			}
		});
		btnRetrieveData.setBounds(17, 222, 117, 29);
		frame.getContentPane().add(btnRetrieveData);
	}
	
	void retrieveData(int mode, int outlet) {
		
	}
}
