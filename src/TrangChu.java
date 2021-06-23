import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.DropMode;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Panel;

public class TrangChu extends JFrame {
	
	private Image img_logo = new ImageIcon(TrangChu.class.getResource("icon/books.png")).getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
	private Image img_book = new ImageIcon(TrangChu.class.getResource("icon/book.png")).getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
	private Image img_course = new ImageIcon(TrangChu.class.getResource("icon/course.png")).getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
	private Image img_user_account = new ImageIcon(TrangChu.class.getResource("icon/account.png")).getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
	private Image img_borrow_book = new ImageIcon(TrangChu.class.getResource("icon/borrow-book.png")).getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
	private Image img_change_user = new ImageIcon(TrangChu.class.getResource("icon/change-user.png")).getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
	private Image img_add_user = new ImageIcon(TrangChu.class.getResource("icon/add-user.png")).getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
	
	private JPanel contentPane;
	private JTextField textField;
	private JPanel children1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChu frame = new TrangChu();
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
	public TrangChu() {
		setUndecorated(true);
		setTitle("Trang ch\u1EE7");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Trang ch\u1EE7");
		lblNewLabel.setBounds(40, 10, 67, 22);
		contentPane.add(lblNewLabel);
		
		final JPanel panelMain = new JPanel();
		panelMain.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMain.setBounds(200, 38, 718, 521);
		contentPane.add(panelMain);
		panelMain.setLayout(new BorderLayout(0, 0));
		
		JLabel lblIonLogo = new JLabel("");
		lblIonLogo.setBounds(10, 5, 32, 32);
		contentPane.add(lblIonLogo);
		lblIonLogo.setIcon(new ImageIcon(img_logo));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(new Color(61, 157, 245));
		panel_1.setBounds(0, 38, 200, 521);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(61, 157, 245));
		panel_2.setBounds(10, 10, 180, 49);
		panel_1.add(panel_2);
		
		textField = new JTextField();
		textField.setText("Admin");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(new Color(61, 157, 245));
		textField.setBounds(52, 10, 96, 29);
		panel_2.add(textField);
		
		JPanel panel_3_1_1_1_1_1 = new JPanel();
		panel_3_1_1_1_1_1.setLayout(null);
		panel_3_1_1_1_1_1.setBackground(new Color(61, 157, 245));
		panel_3_1_1_1_1_1.setBounds(10, 353, 180, 49);
		panel_1.add(panel_3_1_1_1_1_1);
		
		JButton btnNewButton = new JButton("\u0110\u0103ng k\u00ED");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				children1 = new DangKy();
				panelMain.removeAll();
				panelMain.add(children1);
				panelMain.validate();
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(61, 157, 245));
		btnNewButton.setBounds(51, 0, 129, 49);
		panel_3_1_1_1_1_1.add(btnNewButton);
		
		JLabel lblDK = new JLabel("");
		lblDK.setBounds(10, 10, 32, 32);
		panel_3_1_1_1_1_1.add(lblDK);
		lblDK.setIcon(new ImageIcon(img_add_user));
		
		JPanel panel_3_1_1_1_1_1_1 = new JPanel();
		panel_3_1_1_1_1_1_1.setLayout(null);
		panel_3_1_1_1_1_1_1.setBackground(new Color(61, 157, 245));
		panel_3_1_1_1_1_1_1.setBounds(10, 294, 180, 49);
		panel_1.add(panel_3_1_1_1_1_1_1);
		
		JButton btnQunLTi = new JButton("Qu\u1EA3n l\u00FD t\u00E0i kho\u1EA3n");
		btnQunLTi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				children1 = new QLTK();
				panelMain.removeAll();
				panelMain.add(children1);
				panelMain.validate();
			}
		});
		btnQunLTi.setHorizontalAlignment(SwingConstants.LEFT);
		btnQunLTi.setForeground(Color.WHITE);
		btnQunLTi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnQunLTi.setBorder(null);
		btnQunLTi.setBackground(new Color(61, 157, 245));
		btnQunLTi.setBounds(51, 0, 129, 49);
		panel_3_1_1_1_1_1_1.add(btnQunLTi);
		
		JLabel lblQLTK = new JLabel("");
		lblQLTK.setBounds(9, 10, 32, 32);
		panel_3_1_1_1_1_1_1.add(lblQLTK);
		lblQLTK.setIcon(new ImageIcon(img_change_user));
		
		JPanel panel_3_1_1_1_1_1_1_1 = new JPanel();
		panel_3_1_1_1_1_1_1_1.setLayout(null);
		panel_3_1_1_1_1_1_1_1.setBackground(new Color(61, 157, 245));
		panel_3_1_1_1_1_1_1_1.setBounds(10, 235, 180, 49);
		panel_1.add(panel_3_1_1_1_1_1_1_1);
		
		JButton btnNewButton_1_1 = new JButton("Qu\u1EA3n l\u00FD m\u01B0\u1EE3n tr\u1EA3");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				children1 = new QLMT();
				panelMain.removeAll();
				panelMain.add(children1);
				panelMain.validate();
			}
		});
		btnNewButton_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1.setBorder(null);
		btnNewButton_1_1.setBackground(new Color(61, 157, 245));
		btnNewButton_1_1.setBounds(51, 0, 129, 49);
		panel_3_1_1_1_1_1_1_1.add(btnNewButton_1_1);
		
		JLabel lblQLMuonTra = new JLabel("");
		lblQLMuonTra.setBounds(9, 10, 32, 32);
		panel_3_1_1_1_1_1_1_1.add(lblQLMuonTra);
		lblQLMuonTra.setIcon(new ImageIcon(img_borrow_book));
		
		JPanel panel_3_1_1_1_1_1_1_1_1 = new JPanel();
		panel_3_1_1_1_1_1_1_1_1.setLayout(null);
		panel_3_1_1_1_1_1_1_1_1.setBackground(new Color(61, 157, 245));
		panel_3_1_1_1_1_1_1_1_1.setBounds(10, 176, 180, 49);
		panel_1.add(panel_3_1_1_1_1_1_1_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Qu\u1EA3n l\u00FD \u0111\u1ED9c gi\u1EA3");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				children1 = new QLDG();
				panelMain.removeAll();
				panelMain.add(children1);
				panelMain.validate();
			}
		});
		btnNewButton_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1_1.setBorder(null);
		btnNewButton_1_1_1.setBackground(new Color(61, 157, 245));
		btnNewButton_1_1_1.setBounds(51, 0, 129, 49);
		panel_3_1_1_1_1_1_1_1_1.add(btnNewButton_1_1_1);
		
		JLabel lblUserAccount = new JLabel("");
		lblUserAccount.setBounds(10, 10, 32, 32);
		panel_3_1_1_1_1_1_1_1_1.add(lblUserAccount);
		lblUserAccount.setIcon(new ImageIcon(img_user_account));
		
		JPanel panel_3_1_1_1_1_1_1_1_1_1 = new JPanel();
		panel_3_1_1_1_1_1_1_1_1_1.setLayout(null);
		panel_3_1_1_1_1_1_1_1_1_1.setBackground(new Color(61, 157, 245));
		panel_3_1_1_1_1_1_1_1_1_1.setBounds(10, 117, 180, 49);
		panel_1.add(panel_3_1_1_1_1_1_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Qu\u1EA3n l\u00FD s\u00E1ch");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				children1 = new QuanLiSach();
				panelMain.removeAll();
				panelMain.add(children1);
				panelMain.validate();
			}
		});
		btnNewButton_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1_1_1.setBorder(null);
		btnNewButton_1_1_1_1.setBackground(new Color(61, 157, 245));
		btnNewButton_1_1_1_1.setBounds(51, 0, 129, 49);
		panel_3_1_1_1_1_1_1_1_1_1.add(btnNewButton_1_1_1_1);
		
		JLabel lblQLSach = new JLabel("");
		lblQLSach.setBounds(10, 10, 32, 32);
		panel_3_1_1_1_1_1_1_1_1_1.add(lblQLSach);
		lblQLSach.setIcon(new ImageIcon(img_course));
		
		JPanel panel_3_1_1_1_1_1_1_1_1_1_1 = new JPanel();
		panel_3_1_1_1_1_1_1_1_1_1_1.setLayout(null);
		panel_3_1_1_1_1_1_1_1_1_1_1.setForeground(Color.WHITE);
		panel_3_1_1_1_1_1_1_1_1_1_1.setBackground(new Color(61, 157, 245));
		panel_3_1_1_1_1_1_1_1_1_1_1.setBounds(10, 58, 180, 49);
		panel_1.add(panel_3_1_1_1_1_1_1_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("M\u01B0\u1EE3n s\u00E1ch");
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				children1 = new MuonSach();
				panelMain.removeAll();
				panelMain.add(children1);
				panelMain.validate();
			}
		});
		btnNewButton_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1_1_1_1.setBorder(null);
		btnNewButton_1_1_1_1_1.setBackground(new Color(61, 157, 245));
		btnNewButton_1_1_1_1_1.setBounds(51, 0, 129, 49);
		panel_3_1_1_1_1_1_1_1_1_1_1.add(btnNewButton_1_1_1_1_1);
		
		JLabel lblBook = new JLabel("");
		lblBook.setBounds(10, 10, 32, 32);
		panel_3_1_1_1_1_1_1_1_1_1_1.add(lblBook);
		setLocationRelativeTo(null);
		lblBook.setIcon(new ImageIcon(img_book));
	}
}
