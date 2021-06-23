import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controllers.StaffController;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import models.Staff;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QLTK extends JPanel {
	private JTable tbl_data;
	JFrame children;
	private List<String> staff;
	private JTextField txtMk;
	private JTextField txtEmail;
	private JTextField txtGhiChu;
	private JTextField txtName;
	String name;
	int id;
	String email;
	String password;
	int is_admin;
	String description;
	String isadmin;
	
	public int totalAttributeOfClass = 10;
	public StaffController staffController;

	final boolean VIEW_ACION_TYPE = true;
	final boolean UPDATE_ACTION_TYPE = false;

	void loadReaders() {

		DefaultTableModel model = (DefaultTableModel) tbl_data.getModel();
		
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged(); // notifies the JTable that the model has changed
		
		List<Staff> listReader = staffController.findAll();

		for (int i = 0; i < listReader.size(); i++) {
			Object rowData[] = new Object[this.totalAttributeOfClass];
			rowData[0] = listReader.get(i).getId();
			rowData[1] = listReader.get(i).getUserName();
			rowData[2] = listReader.get(i).getEmail();
			rowData[3] = listReader.get(i).getPassword();
			rowData[4] = listReader.get(i).isAdmin() == 1 ? "true" : "false";
			rowData[5] = listReader.get(i).getDescription();
			model.addRow(rowData);
		}

//		tbl_data.setModel(model);
	}

//	void loadReadersWithData(List<Staff> listReader)
//	{
//		DefaultTableModel model = (DefaultTableModel) tbl_data.getModel();
//		
//		// clear all data
//		model.getDataVector().removeAllElements();
//		model.fireTableDataChanged(); // notifies the JTable that the model has changed
//		
//		for (int i = 0; i < listReader.size(); i++) {
//			Object rowData[] = new Object[this.totalAttributeOfClass];
//			rowData[0] = i;
//			rowData[1] = listReader.get(i).getId();
//			rowData[2] = listReader.get(i).getUserName();
//			rowData[3] = listReader.get(i).getEmail();
//			rowData[4] = listReader.get(i).getPassword();
//			rowData[5] = listReader.get(i).isAdmin();
//			rowData[6] = listReader.get(i).getDescription();
//			model.addRow(rowData);
//		}
//	}

	/**
	 * Create the panel.
	 */
	public QLTK() {
		setLayout(null);
		setBounds(100, 100, 714, 521);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(10, 25, 694, 434);
		add(panel_4);
		
		JButton btnNewButton = new JButton("S\u1EEDa");
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(205, 37, 100, 30);
		panel_4.add(btnNewButton);
		
		JButton btnXoa = new JButton("X\u00F3a");
		
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnXoa.setBounds(341, 37, 100, 30);
		panel_4.add(btnXoa);
		
		JScrollPane scrpane_view = new JScrollPane();
		scrpane_view.setFont(new Font("Tahoma", Font.BOLD, 17));
		scrpane_view.setBorder(new LineBorder(Color.BLACK));
		scrpane_view.setBounds(10, 157, 674, 267);
		panel_4.add(scrpane_view);
		
		tbl_data = new JTable() {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		tbl_data.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selectedRow = tbl_data.getSelectedRow();

				id = (Integer) tbl_data.getModel().getValueAt(selectedRow, 0);
				name = (String) tbl_data.getModel().getValueAt(selectedRow, 1);
				email = (String) tbl_data.getModel().getValueAt(selectedRow, 2);
				password = (String) tbl_data.getModel().getValueAt(selectedRow, 3);
				isadmin = (String) tbl_data.getModel().getValueAt(selectedRow, 4);
				description = (String) tbl_data.getModel().getValueAt(selectedRow, 5);
				if(isadmin == "true") {
					is_admin = 0;
				}else {
					is_admin = 1;
				}
				
				
				
				
			}
		});
		// scrollPane.setColumnHeaderView(table);
		tbl_data.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tbl_data.setBorder(new LineBorder(new Color(0, 0, 0)));
		tbl_data.setBounds(10, 134, 694, 377);
		tbl_data.setRowHeight(50);
		tbl_data.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"S\u1ED1 TT", "T\u00EAn t\u00E0i kho\u1EA3n", "Email", "Password", "IsAdmin", "M\u00F4 t\u1EA3"
			}
		));
		scrpane_view.setViewportView(tbl_data);
		
		loadReaders();
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuaTK children = new SuaTK(id,name,email,password,is_admin,description);
				children.setVisible(true);
			}
		});
		
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				staffController = new StaffController();
				staffController.delete(id);
				loadReaders();
			}
		});

	}
	
	
}
