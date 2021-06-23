import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class QLMT extends JPanel {
	private Image img_search = new ImageIcon(QLMT.class.getResource("icon/search.png")).getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
	private Image img_edit_property = new ImageIcon(QLMT.class.getResource("icon/edit-property.png")).getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
	private Image img_trash = new ImageIcon(QLMT.class.getResource("icon/trash.png")).getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
	
	private JTextField txtTKhaTm;
	private JTextField txtTNagyf;
	private JTextField txtnNgy;
	private JTextField textField;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public QLMT() {
		setBorder(null);
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(100, 100, 714, 521);
		
		txtTKhaTm = new JTextField();
		txtTKhaTm.setBorder(new LineBorder(Color.BLACK));
		txtTKhaTm.setForeground(Color.GRAY);
		txtTKhaTm.setText("T\u1EEB kh\u00F3a t\u00ECm ki\u1EBFm");
		txtTKhaTm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTKhaTm.setBounds(10, 29, 130, 32);
		add(txtTKhaTm);
		txtTKhaTm.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"M\u00E3 s\u1ED1 th\u1EBB"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setBounds(150, 29, 97, 32);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Tr\u1EA1ng th\u00E1i"}));
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox_1.setBounds(257, 29, 97, 32);
		add(comboBox_1);
		
		txtTNagyf = new JTextField();
		txtTNagyf.setBorder(new LineBorder(Color.BLACK));
		txtTNagyf.setForeground(Color.GRAY);
		txtTNagyf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTNagyf.setText("T\u1EEB ng\u00E0y");
		txtTNagyf.setHorizontalAlignment(SwingConstants.LEFT);
		txtTNagyf.setBounds(364, 29, 66, 32);
		add(txtTNagyf);
		txtTNagyf.setColumns(10);
		
		txtnNgy = new JTextField();
		txtnNgy.setBorder(new LineBorder(Color.BLACK));
		txtnNgy.setForeground(Color.GRAY);
		txtnNgy.setText("\u0110\u1EBFn ng\u00E0y");
		txtnNgy.setHorizontalAlignment(SwingConstants.LEFT);
		txtnNgy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtnNgy.setColumns(10);
		txtnNgy.setBounds(440, 29, 66, 32);
		add(txtnNgy);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBackground(new Color(61, 157, 245));
		panel1.setBounds(536, 29, 94, 32);
		add(panel1);
		
		textField = new JTextField();
		textField.setText("Tìm kiếm");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(new Color(61, 157, 245));
		textField.setBounds(26, 0, 68, 30);
		panel1.add(textField);
		
		JLabel lblIconSearch = new JLabel("");
		lblIconSearch.setBounds(0, 1, 26, 30);
		panel1.add(lblIconSearch);
		lblIconSearch.setIcon(new ImageIcon(img_search));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setBounds(10, 110, 694, 187);
		add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Tr\u1EA1ng th\u00E1i", "Th\u1EE7 th\u01B0", "H\u1EA1n tr\u1EA3", " Ng\u00E0y m\u01B0\u1EE3n", "\u0110i\u1EC7n tho\u1EA1i", "M\u00E3 th\u1EBB", "\u0110\u1ED9c gi\u1EA3", "S\u1ED1 TT"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(61, 157, 245));
		panel_1_1.setBounds(504, 461, 94, 30);
		add(panel_1_1);
		
		JLabel lblIconSearch_1_1 = new JLabel("");
		lblIconSearch_1_1.setBounds(0, 1, 26, 30);
		panel_1_1.add(lblIconSearch_1_1);
		lblIconSearch_1_1.setIcon(new ImageIcon(img_edit_property));
		
		JButton btnSa = new JButton("Sửa");
		btnSa.setForeground(Color.WHITE);
		btnSa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSa.setBorder(null);
		btnSa.setBackground(new Color(61, 157, 245));
		btnSa.setBounds(26, 1, 68, 30);
		panel_1_1.add(btnSa);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(new Color(61, 157, 245));
		panel_1_1_1.setBounds(610, 461, 94, 30);
		add(panel_1_1_1);
		
		JLabel lblIconSearch_1_1_1 = new JLabel("");
		lblIconSearch_1_1_1.setBounds(0, 1, 26, 30);
		panel_1_1_1.add(lblIconSearch_1_1_1);
		lblIconSearch_1_1_1.setIcon(new ImageIcon(img_trash));
		
		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBackground(new Color(61, 157, 245));
		btnNewButton_2.setBounds(26, 1, 68, 30);
		panel_1_1_1.add(btnNewButton_2);
	}
}
