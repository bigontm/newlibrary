import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controllers.StudentController;
import models.Student;

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

public class themDocGia extends JFrame {

	private JPanel contentPane;
	private JTextField txtMTh;
	private JTextField txt_id;
	private JTextField txtHTn;
	private JTextField txtGiiTnh;
	private JTextField txtNgySinh;
	private JTextField txtCmnd;
	private JTextField txtEmail;
	private JTextField txtSinThoi;
	private JTextField txt_name;
	private JTextField txt_gender;
	private JTextField txt_dob;
	private JTextField txt_className;
	private JTextField txt_email;
	private JTextField txt_cellPhone;
	private JButton btn_update;
	
	public StudentController studentController;
	
	public void setDisableAll()
	{
		txt_id.disable();
		txt_name.disable();
		txt_gender.disable();
		txt_dob.disable();
		txt_email.disable();
		txt_className.disable();
		txt_cellPhone.disable();
	}
	
	public void setEnalble()
	{
		txt_name.enable();
		txt_gender.enable();
		txt_dob.enable();
		txt_email.enable();
		txt_className.enable();
		txt_cellPhone.enable();
	}
	
	public void pourDataToFields(int id, String name, String gender, String className, String cellPhone, Date dob, String email)
	{
		txt_id.setText(id + "");
		txt_name.setText(name);
		txt_gender.setText(gender);
		txt_dob.setText(dob.toString());
		txt_email.setText(email);
		txt_className.setText(className);
		txt_cellPhone.setText(cellPhone);
		
		btn_update.setText(actionType?"Ok":"Chỉnh sửa");
		studentController = new StudentController();
		
		if (actionType)
		{
			setDisableAll();
		}
		else {
			txt_id.disable();
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
			Date date= Date.valueOf(txt_dob.getText());
			// exute update query
			Student student = new Student(
					Integer.parseInt(txt_id.getText()),
					txt_name.getText(),
					"",
					"",
					txt_gender.equals("Nam")?1:2,
					date,
					"",
					txt_className.getText(),
					txt_email.getText(),
					txt_cellPhone.getText()
					);
			
			if (
					studentController.update(student)
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
					themDocGia frame = new themDocGia();
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
	public themDocGia() {
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
		
		txtMTh = new JTextField();
		txtMTh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMTh.setText("M\u00E3 th\u1EBB:");
		txtMTh.setHorizontalAlignment(SwingConstants.LEFT);
		txtMTh.setBounds(83, 21, 150, 32);
		panel.add(txtMTh);
		txtMTh.setColumns(10);
		
		txt_id = new JTextField();
		txt_id.setBounds(283, 21, 150, 32);
		panel.add(txt_id);
		txt_id.setColumns(10);
		
		txtHTn = new JTextField();
		txtHTn.setText("H\u1ECD T\u00EAn:");
		txtHTn.setHorizontalAlignment(SwingConstants.LEFT);
		txtHTn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtHTn.setColumns(10);
		txtHTn.setBounds(83, 71, 150, 32);
		panel.add(txtHTn);
		
		txtGiiTnh = new JTextField();
		txtGiiTnh.setText("Gi\u1EDBi T\u00EDnh:");
		txtGiiTnh.setHorizontalAlignment(SwingConstants.LEFT);
		txtGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtGiiTnh.setColumns(10);
		txtGiiTnh.setBounds(83, 121, 150, 32);
		panel.add(txtGiiTnh);
		
		txtNgySinh = new JTextField();
		txtNgySinh.setText("Ng\u00E0y Sinh:");
		txtNgySinh.setHorizontalAlignment(SwingConstants.LEFT);
		txtNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNgySinh.setColumns(10);
		txtNgySinh.setBounds(83, 171, 150, 32);
		panel.add(txtNgySinh);
		
		txtCmnd = new JTextField();
		txtCmnd.setText("L\u1EDBp:");
		txtCmnd.setHorizontalAlignment(SwingConstants.LEFT);
		txtCmnd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCmnd.setColumns(10);
		txtCmnd.setBounds(83, 221, 150, 32);
		panel.add(txtCmnd);
		
		txtEmail = new JTextField();
		txtEmail.setText("Email:");
		txtEmail.setHorizontalAlignment(SwingConstants.LEFT);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtEmail.setColumns(10);
		txtEmail.setBounds(83, 271, 150, 32);
		panel.add(txtEmail);
		
		txtSinThoi = new JTextField();
		txtSinThoi.setText("S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i:");
		txtSinThoi.setHorizontalAlignment(SwingConstants.LEFT);
		txtSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSinThoi.setColumns(10);
		txtSinThoi.setBounds(83, 321, 150, 32);
		panel.add(txtSinThoi);
		
		txt_name = new JTextField();
		txt_name.setColumns(10);
		txt_name.setBounds(283, 71, 150, 32);
		panel.add(txt_name);
		
		txt_gender = new JTextField();
		txt_gender.setColumns(10);
		txt_gender.setBounds(283, 121, 150, 32);
		panel.add(txt_gender);
		
		txt_dob = new JTextField();
		txt_dob.setColumns(10);
		txt_dob.setBounds(283, 171, 150, 32);
		panel.add(txt_dob);
		
		txt_className = new JTextField();
		txt_className.setColumns(10);
		txt_className.setBounds(283, 238, 150, 32);
		panel.add(txt_className);
		
		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(283, 271, 150, 32);
		panel.add(txt_email);
		
		txt_cellPhone = new JTextField();
		txt_cellPhone.setColumns(10);
		txt_cellPhone.setBounds(283, 321, 150, 32);
		panel.add(txt_cellPhone);
		
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