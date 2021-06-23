import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controllers.StaffController;
import models.Staff;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SuaTK extends JFrame {

	private JPanel contentPane;
	public JTextField textMk;
	public JTextField textEmail;
	public JTextField textGhiChu;
	JTextField textName;
	JComboBox cbChucVu;
	String matKhau;
	static String name;
	static int id;
	static String email;
	static String password;
	static int is_admin;
	static String description;

//	public Staff staffs = new Staff();
	public StaffController staffsController = new StaffController();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuaTK frame = new SuaTK(id, name, email, password, is_admin, description);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	
	public SuaTK(final int id, String name, String email, String password, int is_admin, String description) {

		setBounds(100, 100, 592, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btnLuTiKhon = new JButton("L\u01B0u t\u00E0i kho\u1EA3n");
		
		btnLuTiKhon.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		btnLuTiKhon.setBounds(189, 302, 200, 30);
		panel.add(btnLuTiKhon);
		
		JButton btnTroVe= new JButton("Tr\u1EDF v\u1EC1 qu\u1EA3n l\u00FD t\u00E0i kho\u1EA3n");
		btnTroVe.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		btnTroVe.setBounds(164, 361, 250, 30);
		panel.add(btnTroVe);
		
		textMk = new JTextField();
		textMk.setText(password);
		textMk.setColumns(10);
		textMk.setBounds(189, 147, 200, 30);
		panel.add(textMk);
		
		textEmail = new JTextField();
		textEmail.setText(email);
		textEmail.setColumns(10);
		textEmail.setBounds(189, 104, 200, 30);
		panel.add(textEmail);
		
		textGhiChu = new JTextField();
		textGhiChu.setText(description);
		textGhiChu.setColumns(10);
		textGhiChu.setBounds(189, 187, 200, 30);
		panel.add(textGhiChu);
		
		textName = new JTextField();
		textName.setText(name);
		textName.setColumns(10);
		textName.setBounds(189, 62, 200, 30);
		panel.add(textName);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn t\u00E0i kho\u1EA3n");
		lblNewLabel_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(46, 62, 121, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(46, 104, 121, 30);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("M\u1EADt kh\u1EA9u");
		lblNewLabel_1_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(46, 147, 121, 30);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Ghi ch\u00FA");
		lblNewLabel_1_3.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(46, 187, 121, 30);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Ch\u1EE9c v\u1EE5");
		lblNewLabel_1_4.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(46, 227, 121, 30);
		panel.add(lblNewLabel_1_4);
		
		cbChucVu = new JComboBox();
		cbChucVu.setModel(new DefaultComboBoxModel(new String[] {"Qu\u1EA3n l\u00FD", "Nh\u00E2n vi\u00EAn"}));
		cbChucVu.setSelectedIndex(is_admin);
		cbChucVu.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		cbChucVu.setBounds(189, 227, 200, 30);
		panel.add(cbChucVu);
		
		btnLuTiKhon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int isadmin;
				if(cbChucVu.getSelectedIndex()==0)
				{
					isadmin = 1;
				}else {
					isadmin = 0;
				}
				Staff staffs = new Staff(id,textName.getText(),textEmail.getText(),textMk.getText(),isadmin,textGhiChu.getText());
				System.out.println(staffsController.update(staffs));
				if (staffsController.update(staffs))
				{
					showMessageDialog(null, "Sá»­a tÃ i khoáº£n thÃ nh cÃ´ng");
				}
				else 
				{
					showMessageDialog(null, "Ä�Ã£ xáº£y ra lá»—i");
				}
			}
		});
		
	}

	public SuaTK() {
		// TODO Auto-generated constructor stub
	}

}
