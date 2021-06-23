import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controllers.StudentController;
import controllers.manageBook;
import models.Student;
import models.Book;
import models.Shelves;
import models.BookCategory;
import models.Author;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JButton;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class themSach extends JFrame {
	private JTextField textField;
	private JPanel contentPane;
	private JTextField txttensach;
	private JTextField txt_tensach;
	private JTextField txtidsach;
	private JTextField txttheloai;
	private JTextField txttacgia;
	private JTextField txtnamxb;
	private JTextField txtvitrike;
	private JTextField txt_idsach;
	private JTextField txt_theloai;
	private JTextField txt_tacgia;
	private JTextField txt_namxb;
	private JTextField txt_vitrike;
	private JButton btn_update;
	
	public manageBook bookk;
	public void setDisableAll()
	{
		txt_tensach.disable();
		txt_idsach.disable();
		txt_theloai.disable();
		txt_tacgia.disable();
		txt_vitrike.disable();
		txt_namxb.disable();
		
	}
	
	public void setEnalble()
	{
		txt_idsach.enable();
		txt_theloai.enable();
		txt_tacgia.enable();
		txt_vitrike.enable();
		txt_namxb.enable();
		
	}
	
	public void pourData(int id, String bookname, String theloai, String tacgia, String vitrike, String namxb)
	{
		txt_idsach.setText(id + "");
		txt_tensach.setText(bookname);
		txt_theloai.setText(theloai);
		txt_tacgia.setText(tacgia);
		txt_vitrike.setText(vitrike);
		txt_namxb.setText(namxb);
		
		
		btn_update.setText(actionType?"Ok":"Chỉnh sửa");
		bookk = new manageBook();
		
		if (actionType)
		{
			setDisableAll();
		}
		else {
			txt_tensach.disable();
		}
	}
	
	public boolean actionType;
	
	public void isViewAction(boolean isView) 
	{
		this.actionType = isView;
	}
	// 1 is view
	// 0 is update
	
	public void setUpBtn_update() 
	{
		if (actionType)
		{
			this.dispose();
		}
		else 
		{
			
			
			Book book = new Book(
					
					
					
					
					);
			
			if (
					bookk.update(book)
				)
			{
				JOptionPane.showMessageDialog(this, "Update success");
				this.dispose();
			}
			else 
			{
				JOptionPane.showMessageDialog(this, "something error");
			}
		}
	}
	
	
	
	
	/**
	 * Launch the application.
	 */
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					themSach frame = new themSach();
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
	public themSach() {
		
		setTitle("Th\u00EAm \u0111\u1ED9c gi\u1EA3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 516, 419);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txttensach = new JTextField();
		txttensach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txttensach.setText("T\u00EAn S\u00E1ch");
		txttensach.setHorizontalAlignment(SwingConstants.LEFT);
		txttensach.setBounds(83, 21, 150, 32);
		panel.add(txttensach);
		txttensach.setColumns(10);
		
		txt_tensach = new JTextField();
		txt_tensach.setBounds(283, 21, 150, 32);
		panel.add(txt_tensach);
		txt_tensach.setColumns(10);
		
		txtidsach = new JTextField();
		txtidsach.setText("IBSN");
		txtidsach.setHorizontalAlignment(SwingConstants.LEFT);
		txtidsach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtidsach.setColumns(10);
		txtidsach.setBounds(83, 71, 150, 32);
		panel.add(txtidsach);
		
		txttheloai = new JTextField();
		txttheloai.setText("Th\u1EC3 lo\u1EA1i");
		txttheloai.setHorizontalAlignment(SwingConstants.LEFT);
		txttheloai.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txttheloai.setColumns(10);
		txttheloai.setBounds(83, 121, 150, 32);
		panel.add(txttheloai);
		
		txttacgia = new JTextField();
		txttacgia.setText("T\u00E1c gi\u1EA3");
		txttacgia.setHorizontalAlignment(SwingConstants.LEFT);
		txttacgia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txttacgia.setColumns(10);
		txttacgia.setBounds(83, 171, 150, 32);
		panel.add(txttacgia);
		
		txtnamxb = new JTextField();
		txtnamxb.setText("N\u0103m xu\u1EA5t b\u1EA3n");
		txtnamxb.setHorizontalAlignment(SwingConstants.LEFT);
		txtnamxb.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtnamxb.setColumns(10);
		txtnamxb.setBounds(83, 221, 150, 32);
		panel.add(txtnamxb);
		
		txtvitrike = new JTextField();
		txtvitrike.setText("V\u1ECB tr\u00ED k\u1EC7");
		txtvitrike.setHorizontalAlignment(SwingConstants.LEFT);
		txtvitrike.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtvitrike.setColumns(10);
		txtvitrike.setBounds(83, 271, 150, 32);
		panel.add(txtvitrike);
		
		txt_idsach = new JTextField();
		txt_idsach.setColumns(10);
		txt_idsach.setBounds(283, 71, 150, 32);
		panel.add(txt_idsach);
		
		txt_theloai = new JTextField();
		txt_theloai.setColumns(10);
		txt_theloai.setBounds(283, 121, 150, 32);
		panel.add(txt_theloai);
		
		txt_tacgia = new JTextField();
		txt_tacgia.setColumns(10);
		txt_tacgia.setBounds(283, 171, 150, 32);
		panel.add(txt_tacgia);
		
		txt_namxb = new JTextField();
		txt_namxb.setColumns(10);
		txt_namxb.setBounds(283, 221, 150, 32);
		panel.add(txt_namxb);
		
		txt_vitrike = new JTextField();
		txt_vitrike.setColumns(10);
		txt_vitrike.setBounds(283, 274, 150, 32);
		panel.add(txt_vitrike);
	
	btn_update = new JButton("Chỉnh sửa");
	btn_update.setForeground(Color.WHITE);
	btn_update.setFont(new Font("Tahoma", Font.PLAIN, 18));
	btn_update.setBounds(309, 374, 124, 32);
	panel.add(btn_update);
	btn_update.setBackground(new Color(61, 157, 245));
	
	btn_update.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e)
		{
			setUpBtn_update();
		}
	});

}
}
