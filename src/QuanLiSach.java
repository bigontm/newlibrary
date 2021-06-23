import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controllers.StudentController;
import controllers.manageBook;
import models.Author;
import models.Book;
import models.BookCategory;
import models.Shelves;
import models.Student;
import java.sql.Connection;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class QuanLiSach extends JPanel {
	private JTable table;
	private JTable table_1;
    private manageBook bookk;
    public int totalAttributeOfClass = 10;
    private JTable tbl_data;
    private JTextField btn_search;
	private JTextField txt_textSearch;
	final boolean VIEW_ACION_TYPE = true;
	final boolean UPDATE_ACTION_TYPE = false;
    void loadReaders() {
//    	this.bookk = new manageBook();
		DefaultTableModel model = (DefaultTableModel) tbl_data.getModel();
		
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged(); // notifies the JTable that the model has changed
		
		List<Book> listBook = bookk.findAll();

	
		for (int i = 0; i < listBook.size(); i++) {
		Object rowData[] = new Object[this.totalAttributeOfClass];
			rowData[0] = listBook.get(i).getBookName();
		    rowData[1] = listBook.get(i).getId();
		    rowData[2] = listBook.get(i).getBookcate().getBookCateName();
		    rowData[3]=  listBook.get(i).getAuthor().getAuthorName();
			rowData[4] = listBook.get(i).getPublicationYear();
		    rowData[5] = listBook.get(i).getShelves().getShelf();
		
		model.addRow(rowData);
		}
		

//	tbl_data.setModel(model);
	}
    void loadBookWithData(List<Book> listBook)
	{
		DefaultTableModel model = (DefaultTableModel) tbl_data.getModel();
		
		// clear all data
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged(); // notifies the JTable that the model has changed
		
		for (int i = 0; i < listBook.size(); i++) {
			Object rowData[] = new Object[this.totalAttributeOfClass];
			rowData[0] = listBook.get(i).getBookName();
		    rowData[1] = listBook.get(i).getId();
		    rowData[2] = listBook.get(i).getBookcate().getBookCateName();
		    rowData[3]=  listBook.get(i).getAuthor().getAuthorName();
			rowData[4] = listBook.get(i).getPublicationYear();
		    rowData[5] = listBook.get(i).getShelves().getShelf();
		
		model.addRow(rowData);
		}
	}
	public QuanLiSach() {
		bookk=new manageBook();
		setBorder(null);
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(100, 100, 714, 521);
		
		txt_textSearch = new JTextField();
		txt_textSearch.setText("Tu khoa tim kiem");
		txt_textSearch.setHorizontalAlignment(SwingConstants.LEFT);
		txt_textSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txt_textSearch.setColumns(10);
		txt_textSearch.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		txt_textSearch.setBounds(189, 358, 120, 30);
		add(txt_textSearch);

		

		final JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBackground(new Color(61, 157, 245));
		panel1.setBounds(319, 358, 94, 30);
		add(panel1);
		
				btn_search = new JTextField();
				btn_search.setBounds(10, 0, 68, 30);
				
				btn_search.setText("Tìm kiếm");
				btn_search.setHorizontalAlignment(SwingConstants.CENTER);
				btn_search.setForeground(Color.WHITE);
				btn_search.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btn_search.setColumns(10);
				btn_search.setBorder(null);
				btn_search.setBackground(new Color(61, 157, 245));
				panel1.add(btn_search);

//tìm kiếm theo tên sách
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
					manageBook bookkk = new manageBook();
					loadBookWithData(bookkk.findBySearch(textSearch));					
				}
			}
		});
		

		
		
		JLabel lblNewLabel = new JLabel("Th\u00EAm th\u00EA\u0309 loa\u0323i");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(152, 25, 124, 39);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Th\u00EAm sa\u0301ch");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(489, 25, 124, 39);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("T\u00EAn th\u00EA\u0309 loa\u0323i");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 100, 107, 29);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("ID");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(10, 139, 107, 29);
		add(lblNewLabel_2_1);
		
		JTextField textField = new JTextField();
		textField.setBounds(145, 105, 138, 20);
		add(textField);
		textField.setColumns(10);
		
		JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(145, 145, 138, 20);
		add(textField_1);
		
		JLabel txt_tensach = new JLabel("T\u00EAn sa\u0301ch");
		txt_tensach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_tensach.setBounds(394, 99, 107, 29);
		add(txt_tensach);
		
		JTextField txt_bookname = new JTextField();
		txt_bookname.setColumns(10);
		txt_bookname.setBounds(526, 105, 138, 20);
		add(txt_bookname);
		
		JLabel txt_ibsn = new JLabel("ISBN");
		txt_ibsn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_ibsn.setBounds(394, 139, 107, 29);
		add(txt_ibsn);
		
		JLabel txt_theloai = new JLabel("Th\u00EA\u0309 loa\u0323i");
		txt_theloai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_theloai.setBounds(394, 183, 107, 29);
		add(txt_theloai);
		
		JLabel txt_tacgia = new JLabel("Ta\u0301c gia\u0309");
		txt_tacgia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_tacgia.setBounds(394, 223, 107, 29);
		add(txt_tacgia);
		
		JLabel txt_namxb = new JLabel("N\u0103m xu\u00E2\u0301t ba\u0309n");
		txt_namxb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_namxb.setBounds(394, 263, 107, 29);
		add(txt_namxb);
		
		JLabel txt_vitriks = new JLabel("Vi\u0323 tri\u0301 k\u00EA\u0323 sa\u0301ch");
		txt_vitriks.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_vitriks.setBounds(394, 304, 107, 29);
		add(txt_vitriks);
		
		JTextField txt_idsach = new JTextField();
		txt_idsach.setColumns(10);
		txt_idsach.setBounds(526, 145, 138, 20);
		add(txt_idsach);
		
		JTextField txt_tacgia1 = new JTextField();
		txt_tacgia1.setColumns(10);
		txt_tacgia1.setBounds(526, 229, 138, 20);
		add(txt_tacgia1);
		
		JTextField txt_namxuatban = new JTextField();
		txt_namxuatban.setColumns(10);
		txt_namxuatban.setBounds(526, 269, 138, 20);
		add(txt_namxuatban);
		
		JTextField txt_vtks = new JTextField();
		txt_vtks.setColumns(10);
		txt_vtks.setBounds(526, 310, 138, 20);
		add(txt_vtks);
		//EM THEM VÔ THÌ NÓ HIỆN LÊN TRÊN LOADDATA NHƯNG MÀ TRÊN DB LẠI K CÓ :(((((( 
		JButton btn_them = new JButton("Th\u00EAm");
		btn_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				if(txt_idsach.getText().equals("")) {
				sb.append("Mã sách không được để trống ");
				txt_idsach.setBackground(Color.red);
			 }else{
				txt_idsach.setBackground(Color.white);
			}
				if(sb.length()>0) {
					JOptionPane.showMessageDialog(null,sb);
					return ;
				}
					try {
						Book book= new Book();
						
						Author author = new Author();
						author.setAuthorName(txt_tacgia1.getText());
						
						BookCategory bookCate = new BookCategory();
						bookCate.setBookCateName(txt_theloai.getText());
						
						Shelves shelves = new Shelves();
						shelves.setShelf(txt_vtks.getText());
						shelves.setFloor("flor");
						
						
						book.setAuthor(author);
						book.setBookcate(bookCate);
						book.setShelves(shelves);
						
						
						book.setBookName(txt_bookname.getText());
						book.setPublicationYear(txt_namxuatban.getText());
						book.setStatus("");
						
						manageBook manage = new manageBook();
						boolean success = manage.addBook(book);
						if (success) {
							JOptionPane.showMessageDialog(null,"THem thanh cong");
						}
						else {
							JOptionPane.showMessageDialog(null,"THem KHONG thanh cong");
						}
						
						
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			
		});
		
		btn_them.setBounds(423, 363, 87, 23);
		add(btn_them);
		
		JButton btn_xoa = new JButton("Xo\u0301a");
		
		btn_xoa.setBounds(617, 363, 87, 23);
		add(btn_xoa);
		btn_xoa.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
			
				manageBook bookk = new manageBook();
				
				int selectedRow = tbl_data.getSelectedRow();

				int id = (Integer) tbl_data.getModel().getValueAt(selectedRow, 1);
				
	            Object[] options = {"Yes", "No"};
	            Component form = null;
	            int n = JOptionPane.showOptionDialog(form, "Do you like to delete the record for Book ID: " +
	                    id + " ?", "Exit Confirmation", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options);
	            if(n == JOptionPane.YES_OPTION) {
	            	if (bookk.deleteBook(id))
					{
	            		JOptionPane.showMessageDialog(btn_xoa, "The record has been deleted successfully.");
	            		loadReaders();
					}
	            	else 
					{
	                    JOptionPane.showMessageDialog(btn_xoa, "Record couldn't be deleted. Please try again.");
					} 
	            }
			}
		});
		
		JButton btn_sua = new JButton("S\u01B0\u0309a");
		btn_sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StringBuilder sb = new StringBuilder();
				if(txt_idsach.getText().equals("")) {
					sb.append("Mã sách không được để trống ");
					txt_idsach.setBackground(Color.red);
				 }else{
					txt_idsach.setBackground(Color.white);
				}
					if(sb.length()>0) {
						JOptionPane.showMessageDialog(null,sb);
						return ;
					}
			try {
			
				Book book=new Book();
				book.setBookName(txt_bookname.getText());
				book.setPublicationYear(txt_namxb.getText());
				manageBook bookk=new manageBook();
				bookk.update(book);
			
			
			
			
				JOptionPane.showMessageDialog(null, "lưu");
				
					
					
				
			
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "sai");
				e2.printStackTrace();
			}
					
			}
		});
		btn_sua.setBounds(520, 363, 87, 23);
		add(btn_sua);
		

	
		
		JComboBox comboBox = new JComboBox(new Object[] {});
		comboBox.setModel(new DefaultComboBoxModel(getIdtl()));
		comboBox.setBounds(526, 188, 138, 22);
		add(comboBox);
		
		JScrollPane scrpane_view = new JScrollPane();
		scrpane_view.setBounds(21, 397, 683, 113);
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
			new String[] {"Tên sách","IBSN","Thể Loại","Tác giả","Năm xuất bản","Vị trí kệ",}));
	scrpane_view.setViewportView(tbl_data);
	

	loadReaders();

	tbl_data.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			loadBookToNewForm(e, 2, VIEW_ACION_TYPE);
		}
	});

	}
	public void loadBookToNewForm(MouseEvent e, int typeClick, boolean typeAction) {

		if (e.getClickCount() == typeClick) { // to detect doble click events
//			 	JTable tbl_data = (JTable) e.getSource();

			// Convert to Student on selected row Data of JTable
			int selectedRow = tbl_data.getSelectedRow();

			int id = (Integer) tbl_data.getModel().getValueAt(selectedRow, 2);
			String bookname = (String) tbl_data.getModel().getValueAt(selectedRow, 1);
			String theloai = (String) tbl_data.getModel().getValueAt(selectedRow, 3);
			String tacgia = (String) tbl_data.getModel().getValueAt(selectedRow, 4);
			String namxb = (String) tbl_data.getModel().getValueAt(selectedRow, 5);
			
			String vitrike = (String) tbl_data.getModel().getValueAt(selectedRow, 6);

			themSach ViewStudentUI = new themSach();
			ViewStudentUI.isViewAction(typeAction);
			ViewStudentUI.pourData(id, bookname, theloai,  tacgia, namxb,vitrike);
			ViewStudentUI.setVisible(true);
		}
	}
	

	private Object[] getIdtl() {
		// TODO Auto-generated method stub
		this.bookk = new manageBook();
		List<Book> listBook = bookk.findAll();
		Object[] idtl = new Object[listBook.size()];

		for (int i = 0; i < listBook.size(); i++) {
			idtl[i] = listBook.get(i).getBookcate().getBookCateName();

		}

		return idtl;
	}
	 
}
