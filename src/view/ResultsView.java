package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import rmi.base.RequestResponse;

public class ResultsView extends JFrame {

	private static final long serialVersionUID = 1L;

	private RequestResponse data;
	
	private JPanel contentPane;
	private JTable table;
	
	public static void CreateResultsView(RequestResponse data) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultsView frame = new ResultsView(data);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ResultsView(RequestResponse data) {
		this.data = data;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 180, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 20, 140, 180);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		ArrayList<Integer> id_list = this.data.getIdList();
		ArrayList<Double> consumption_list = this.data.getConsumptionList();
		
		DefaultTableModel dft = new DefaultTableModel();
		dft.addColumn("Outlet ID", id_list.toArray());
		dft.addColumn("Consumption", consumption_list.toArray());
		
		table.setModel(dft);
	}
}
