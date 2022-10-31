package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.SachDao;
import entity.Sach;

public class QuanLySach extends JFrame {

	private JPanel contentPane;
	private JTextField tfMaSach;
	private JTextField tfTenSach;
	private JTextField tfGiaSach;
	private JTextField tfNamSanXuat;
	private JTable table;
	private DefaultTableModel tableModel;
	private SachDao sd = new SachDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLySach frame = new QuanLySach();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.addWindowListener(new WindowListener() {
						
						@Override
						public void windowOpened(WindowEvent e) {
							frame.fillTable();
						}
						
						@Override
						public void windowIconified(WindowEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void windowDeiconified(WindowEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void windowDeactivated(WindowEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void windowClosing(WindowEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void windowClosed(WindowEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void windowActivated(WindowEvent e) {
							// TODO Auto-generated method stub
							
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QuanLySach() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ SÁCH");
		lblNewLabel.setBounds(15, 16, 579, 29);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JLabel lblNewLabel_1 = new JLabel("Mã sách:");
		lblNewLabel_1.setBounds(82, 77, 80, 30);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfMaSach = new JTextField();
		tfMaSach.setBounds(256, 71, 223, 30);
		tfMaSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfMaSach.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên sách:");
		lblNewLabel_1_1.setBounds(82, 118, 80, 30);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Giá sách:");
		lblNewLabel_1_1_1.setBounds(82, 159, 80, 30);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Năm sản xuất:");
		lblNewLabel_1_1_1_1.setBounds(82, 200, 90, 30);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(tfMaSach);
		contentPane.add(lblNewLabel_1_1);
		contentPane.add(lblNewLabel_1_1_1);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		tfTenSach = new JTextField();
		tfTenSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfTenSach.setColumns(10);
		tfTenSach.setBounds(256, 118, 223, 30);
		contentPane.add(tfTenSach);
		
		tfGiaSach = new JTextField();
		tfGiaSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfGiaSach.setColumns(10);
		tfGiaSach.setBounds(256, 159, 223, 30);
		contentPane.add(tfGiaSach);
		
		tfNamSanXuat = new JTextField();
		tfNamSanXuat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNamSanXuat.setColumns(10);
		tfNamSanXuat.setBounds(256, 200, 223, 30);
		contentPane.add(tfNamSanXuat);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 251, 584, 129);
		contentPane.add(scrollPane);
		
		tableModel = new DefaultTableModel(null,new String[] {
				"Mã sách", "Tên sách", "Giá", "Năm xuất bản"
			});
		
		table = new JTable();
		table.setModel(tableModel);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				tfMaSach.setText(tableModel.getValueAt(row, 0)+"");
				tfTenSach.setText(tableModel.getValueAt(row, 1)+"");
				tfGiaSach.setText(tableModel.getValueAt(row, 2)+"");
				tfNamSanXuat.setText(tableModel.getValueAt(row, 3)+"");
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(15, 391, 579, 46);
		contentPane.add(panel);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btnClear);
		btnClear.addActionListener(e -> {
			clearForm();
		});
		
		JButton btnInsert = new JButton("Insert");
		panel.add(btnInsert);
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInsert.addActionListener(e -> {
			insertSach();
			fillTable();
		});
		
		JButton btnUpdate = new JButton("Update");
		panel.add(btnUpdate);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.addActionListener(e -> {
			updateSach();
			fillTable();
		});
		
		JButton btn2021 = new JButton("2021");
		panel.add(btn2021);
		btn2021.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn2021.addActionListener(e -> {
			fillTableWithYear(2021);
		});
	}
	
	public void clearForm() {
		tfMaSach.setText("");
		tfTenSach.setText("");
		tfGiaSach.setText("");
		tfNamSanXuat.setText("");
	}
	
	public Sach getBookForm() {
		return new Sach(
				tfMaSach.getText(),
				tfTenSach.getText(),
				Float.parseFloat(tfGiaSach.getText()),
				Integer.parseInt(tfNamSanXuat.getText())
			);
	}
	
	public void updateSach() {
		if(sd.updateBook(getBookForm())) {
			JOptionPane.showMessageDialog(contentPane, "Cập nhật sách thành công");
		}else {
			JOptionPane.showMessageDialog(contentPane, "Cập nhật sách thất bại");
		}
	}

	
	public void insertSach() {
		if(sd.insertBook(getBookForm())) {
			JOptionPane.showMessageDialog(contentPane, "Thêm sách thành công");
		}else {
			JOptionPane.showMessageDialog(contentPane, "Thêm sách thất bại");
		}
	}
	
	public void fillTable() {
		tableModel.setRowCount(0);
		sd.loadData();
		List<Sach> list = sd.getBooks();
		list.forEach(i -> {
			tableModel.addRow(new Object[] {
					i.getMaSach(),
					i.getTenSach(),
					i.getGiaSach(),
					i.getNamXB()
			});
		});
	}
	
	public void fillTableWithYear(int year) {
		tableModel.setRowCount(0);
		List<Sach> list = sd.readBooksWithYear(year);
		list.forEach(i -> {
			tableModel.addRow(new Object[] {
					i.getMaSach(),
					i.getTenSach(),
					i.getGiaSach(),
					i.getNamXB()
			});
		});
	}
	
	
}
