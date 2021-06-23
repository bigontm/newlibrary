import javax.swing.JPanel;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import models.RentingBook;
import models.Student;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import controllers.StudentController;
import controllers.UserController;
import controllers.manageBook;

public class QLDG extends JPanel {

	private Image img_search = new ImageIcon(QLDG.class.getResource("icon/search.png")).getImage().getScaledInstance(24,
			24, Image.SCALE_SMOOTH);
	private Image img_plus = new ImageIcon(QLDG.class.getResource("icon/plus.png")).getImage().getScaledInstance(24, 24,
			Image.SCALE_SMOOTH);
	private Image img_search_client = new ImageIcon(QLDG.class.getResource("icon/search-client.png")).getImage()
			.getScaledInstance(24, 24, Image.SCALE_SMOOTH);
	private Image img_edit_property = new ImageIcon(QLDG.class.getResource("icon/edit-property.png")).getImage()
			.getScaledInstance(24, 24, Image.SCALE_SMOOTH);
	private Image img_trash = new ImageIcon(QLDG.class.getResource("icon/trash.png")).getImage().getScaledInstance(24,
			24, Image.SCALE_SMOOTH);

	private JTextField txt_textSearch;
	private JTextField btn_search;
	private JTable tbl_data;

	public int totalAttributeOfClass = 10;
	public StudentController rentbook;

	final boolean VIEW_ACION_TYPE = true;
	final boolean UPDATE_ACTION_TYPE = false;

	void loadReaders() {

		DefaultTableModel model = (DefaultTableModel) tbl_data.getModel();
		
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged(); // notifies the JTable that the model has changed
		
		List<Student> listReader = rentbook.findAll();

		for (int i = 0; i < listReader.size(); i++) {
			Object rowData[] = new Object[this.totalAttributeOfClass];
			rowData[0] = i;
			rowData[1] = listReader.get(i).getId();
			rowData[2] = listReader.get(i).getUserName();
			rowData[3] = listReader.get(i).getGender() == 1 ? "Nam" : "Nữ";
			rowData[4] = listReader.get(i).getDob();
			rowData[5] = listReader.get(i).getClassName();
			rowData[6] = "abc@gmail.com";
			rowData[7] = listReader.get(i).getContactNumber();
			model.addRow(rowData);
		}

//		tbl_data.setModel(model);
	}

	void loadReadersWithData(List<Student> listReader)
	{
		DefaultTableModel model = (DefaultTableModel) tbl_data.getModel();
		
		// clear all data
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged(); // notifies the JTable that the model has changed
		
		for (int i = 0; i < listReader.size(); i++) {
			Object rowData[] = new Object[this.totalAttributeOfClass];
			rowData[0] = i;
			rowData[1] = listReader.get(i).getId();
			rowData[2] = listReader.get(i).getUserName();
			rowData[3] = listReader.get(i).getGender() == 1 ? "Nam" : "Nữ";
			rowData[4] = listReader.get(i).getDob();
			rowData[5] = listReader.get(i).getClassName();
			rowData[6] = "abc@gmail.com";
			rowData[7] = listReader.get(i).getContactNumber();
			model.addRow(rowData);
		}
	}
	
	/**
	 * Create the panel.
	 */
	public QLDG() {
		// logic loading
		rentbook = new StudentController();

		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(100, 100, 714, 521);

		txt_textSearch = new JTextField();
		txt_textSearch.setText("Từ khóa tìm kiếm");
		txt_textSearch.setHorizontalAlignment(SwingConstants.LEFT);
		txt_textSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txt_textSearch.setColumns(10);
		txt_textSearch.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		txt_textSearch.setBounds(10, 23, 120, 30);
		add(txt_textSearch);

		JComboBox cbbox_id_readers = new JComboBox(new Object[] {});
		cbbox_id_readers.setModel(new DefaultComboBoxModel(getIdReaders()));
		cbbox_id_readers.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbbox_id_readers.setBorder(new LineBorder(new Color(0, 0, 0)));
		cbbox_id_readers.setBackground(Color.WHITE);
		cbbox_id_readers.setBounds(139, 23, 86, 30);
		add(cbbox_id_readers);

		final JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBackground(new Color(61, 157, 245));
		panel1.setBounds(235, 23, 94, 30);
		add(panel1);

		btn_search = new JTextField();
		btn_search.setText("Tìm kiếm");
		btn_search.setHorizontalAlignment(SwingConstants.CENTER);
		btn_search.setForeground(Color.WHITE);
		btn_search.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_search.setColumns(10);
		btn_search.setBorder(null);
		btn_search.setBackground(new Color(61, 157, 245));
		btn_search.setBounds(26, 0, 68, 30);
		panel1.add(btn_search);

		btn_search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String textSearch = txt_textSearch.getText();
				
				if (textSearch.isEmpty())
				{
					JOptionPane.showMessageDialog(panel1,"cannot empty field");
				}
				else 
				{
					StudentController studentController = new StudentController();
					loadReadersWithData(studentController.findBySearch(textSearch));					
				}
			}
		});
		
		JLabel lblIconSearch = new JLabel("");
		lblIconSearch.setBounds(0, 1, 26, 30);
		panel1.add(lblIconSearch);
		lblIconSearch.setIcon(new ImageIcon(img_search));

		final JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(new Color(61, 157, 245));
		panel_1_1_1.setBounds(610, 23, 94, 30);
		add(panel_1_1_1);

		JLabel lblIconSearch_1_1_1 = new JLabel("");
		lblIconSearch_1_1_1.setBounds(0, 1, 26, 30);
		panel_1_1_1.add(lblIconSearch_1_1_1);
		lblIconSearch_1_1_1.setIcon(new ImageIcon(img_trash));

		JButton btn_delete = new JButton("Xóa");
		
		
		btn_delete.setForeground(Color.WHITE);
		btn_delete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_delete.setBorder(null);
		btn_delete.setBackground(new Color(61, 157, 245));
		btn_delete.setBounds(26, 1, 68, 30);
		panel_1_1_1.add(btn_delete);
		
		btn_delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StudentController studentController = new StudentController();
				
				int selectedRow = tbl_data.getSelectedRow();

				int id = (Integer) tbl_data.getModel().getValueAt(selectedRow, 1);
				
	            Object[] options = {"Yes", "No"};
	            Component form = null;
	            int n = JOptionPane.showOptionDialog(form, "Do you like to delete the record for Student ID: " +
	                    id + " ?", "Exit Confirmation", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options);
	            if(n == JOptionPane.YES_OPTION) {
	            	if (studentController.delete(id))
					{
	            		JOptionPane.showMessageDialog(panel_1_1_1, "The record has been deleted successfully.");
	            		loadReaders();
					}
	            	else 
					{
	                    JOptionPane.showMessageDialog(panel_1_1_1, "Record couldn't be deleted. Please try again.");
					} 
	            }
			}
		});
		

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(61, 157, 245));
		panel_1_1.setBounds(506, 23, 94, 30);
		add(panel_1_1);

		JLabel lblIconSearch_1_1 = new JLabel("");
		lblIconSearch_1_1.setBounds(0, 1, 26, 30);
		panel_1_1.add(lblIconSearch_1_1);
		lblIconSearch_1_1.setIcon(new ImageIcon(img_edit_property));

		JButton btn_update = new JButton("Sửa");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_update.setForeground(Color.WHITE);
		btn_update.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_update.setBorder(null);
		btn_update.setBackground(new Color(61, 157, 245));
		btn_update.setBounds(26, 1, 68, 30);
		panel_1_1.add(btn_update);

		btn_update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadStudentToNewForm(e, 1, UPDATE_ACTION_TYPE);
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(61, 157, 245));
		panel_1.setBounds(396, 23, 100, 30);
		add(panel_1);

		JLabel lblIconSearch_1 = new JLabel("");
		lblIconSearch_1.setBounds(0, 1, 26, 30);
		panel_1.add(lblIconSearch_1);
		lblIconSearch_1.setIcon(new ImageIcon(img_plus));

		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(61, 157, 245));
		btnNewButton.setBounds(26, 1, 74, 30);
		panel_1.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame themDocGia = new themDocGia();
				themDocGia.setVisible(true);
			}
		});

		JScrollPane scrpane_view = new JScrollPane();
		scrpane_view.setFont(new Font("Tahoma", Font.BOLD, 17));
		scrpane_view.setBorder(new LineBorder(Color.BLACK));
		scrpane_view.setBounds(10, 120, 694, 267);
		add(scrpane_view);

		tbl_data = new JTable() {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		// scrollPane.setColumnHeaderView(table);
		tbl_data.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tbl_data.setBorder(new LineBorder(new Color(0, 0, 0)));
		tbl_data.setBounds(10, 134, 694, 377);
		tbl_data.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "S\u1ED1 TT", "M\u00E3 th\u1EBB", "H\u1ECD T\u00EAn", "Gi\u1EDBi t\u00EDnh",
						"Ng\u00E0y sinh", "L\u1EDBp", "Email", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i" }));
		scrpane_view.setViewportView(tbl_data);

		loadReaders();

		tbl_data.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				loadStudentToNewForm(e, 2, VIEW_ACION_TYPE);
			}
		});

	}

	public void loadStudentToNewForm(MouseEvent e, int typeClick, boolean typeAction) {

		if (e.getClickCount() == typeClick) { // to detect doble click events
//			 	JTable tbl_data = (JTable) e.getSource();

			// Convert to Student on selected row Data of JTable
			int selectedRow = tbl_data.getSelectedRow();

			int id = (Integer) tbl_data.getModel().getValueAt(selectedRow, 1);
			String name = (String) tbl_data.getModel().getValueAt(selectedRow, 2);
			String gender = (String) tbl_data.getModel().getValueAt(selectedRow, 3);
			String className = (String) tbl_data.getModel().getValueAt(selectedRow, 5);
			String cellPhone = (String) tbl_data.getModel().getValueAt(selectedRow, 7);
			Date dob = (Date) tbl_data.getModel().getValueAt(selectedRow, 4);
			String email = (String) tbl_data.getModel().getValueAt(selectedRow, 6);

			themDocGia ViewStudentUI = new themDocGia();
			ViewStudentUI.isViewAction(typeAction);
			ViewStudentUI.pourDataToFields(id, name, gender, className, cellPhone, dob, email);
			ViewStudentUI.setVisible(true);
		}
	}

	private Object[] getIdReaders() {
		// TODO Auto-generated method stub
		
		List<Student> listReaders = rentbook.findAll();
		
		Object[] idArr = new Object[listReaders.size()];

		for (int i = 0; i < listReaders.size(); i++) {
			idArr[i] = listReaders.get(i).getId();

		}

		return idArr;
	}
}
