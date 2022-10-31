package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Sach;
import utils.JDBCUtil;

public class SachDao {
	private List<Sach> books;
	private JDBCUtil db; 
	
	public SachDao() {
		db = new JDBCUtil("QuanLySach", "sa", "123456");
		books = readBooks();
	}
	
	public void loadData() {
		books = readBooks();
	}
	
	public List<Sach> getBooks() {
		return books;
	}


	public void setBooks(List<Sach> books) {
		this.books = books;
	}



	public List<Sach> readBooks() {
		List<Sach> listBook = new ArrayList<Sach>();
		try {
			db.connectDB();
			ResultSet rs = db.getQuery("select * from Sach");
			while(rs.next()) {
				listBook.add(new Sach(
						rs.getString(1),
						rs.getString(2),
						rs.getFloat(3),
						rs.getInt(4)
					));
			}
			db.closeConnection();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listBook;
	}
	
	public boolean insertBook(Sach s) {
		boolean isSuccess = false;
		try {
			db.connectDB();
			Connection con = db.getConnect();
			String query = "insert into Sach values (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, s.getMaSach());
			ps.setNString(2, s.getTenSach());
			ps.setFloat(3, s.getGiaSach());
			ps.setInt(4, s.getNamXB());
			int i = ps.executeUpdate();
			isSuccess = i > 0;
			db.closeConnection();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess; 
	}
	
	public List<Sach> readBooksWithYear(int year) {
		List<Sach> listBook = new ArrayList<Sach>();
		try {
			db.connectDB();
			ResultSet rs = db.getQuery("select * from Sach where NamXB = '"+year+"'");
			while(rs.next()) {
				listBook.add(new Sach(
						rs.getString(1),
						rs.getString(2),
						rs.getFloat(3),
						rs.getInt(4)
					));
			}
			db.closeConnection();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listBook;
	}
	
	public boolean updateBook(Sach s) {
		boolean isSuccess = false;
		try {
			db.connectDB();
			Connection con = db.getConnect();
			String query = "update Sach set TenSach = ?, Gia = ?, NamXB = ? where MaSach = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(4, s.getMaSach());
			ps.setNString(1, s.getTenSach());
			ps.setFloat(2, s.getGiaSach());
			ps.setInt(3, s.getNamXB());
			int i = ps.executeUpdate();
			isSuccess = i > 0;
			db.closeConnection();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess; 
	}
}
