import javax.swing.JPanel;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class MuonSach extends JPanel {
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public MuonSach() {
		setBorder(null);
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(100, 100, 714, 521);
		
		JLabel lblNewLabel = new JLabel("L\u00E2\u0323p phi\u00EA\u0301u m\u01B0\u01A1\u0323n sa\u0301ch");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(242, 10, 230, 42);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn \u0111o\u0323c gia\u0309:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 94, 153, 34);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u0110i\u0323a chi\u0309:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 139, 153, 34);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("S\u00F4\u0301 \u0111i\u00EA\u0323n thoa\u0323i:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(10, 184, 153, 34);
		add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Ha\u0323n tra\u0309:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2.setBounds(10, 229, 153, 34);
		add(lblNewLabel_1_1_2);
		
		textField = new JTextField();
		textField.setBounds(137, 103, 127, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(137, 148, 127, 20);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(137, 193, 127, 20);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(137, 238, 127, 20);
		add(textField_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("Danh sa\u0301ch m\u01B0\u01A1\u0323n");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(310, 94, 153, 34);
		add(lblNewLabel_1_2);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"STT", "T\u00EAn sa\u0301ch", "Th\u00EA\u0309 loa\u0323i"},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(310, 139, 376, 124);
		add(table);
		
		JButton btnNewButton = new JButton("Xo\u0301a");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(484, 282, 96, 34);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Th\u00EAm");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.setBounds(376, 282, 96, 34);
		add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("S\u01B0\u0309a");
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setBackground(Color.CYAN);
		btnNewButton_1_1.setBounds(590, 282, 96, 34);
		add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Xo\u0301a sa\u0301ch");
		btnNewButton_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1_1.setBackground(Color.CYAN);
		btnNewButton_1_1_1.setBounds(579, 94, 107, 34);
		add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_2 = new JButton("Th\u00EAm sa\u0301ch");
		btnNewButton_1_1_2.setForeground(Color.WHITE);
		btnNewButton_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1_2.setBackground(Color.CYAN);
		btnNewButton_1_1_2.setBounds(579, 49, 107, 34);
		add(btnNewButton_1_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("Danh sa\u0301ch phi\u00EA\u0301u m\u01B0\u01A1\u0323n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(10, 334, 186, 42);
		add(lblNewLabel_2);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_1.setBounds(10, 377, 694, 134);
		add(table_1);
	}

}
