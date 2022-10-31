package entity;

public class Sach {
	private String maSach,tenSach;
	private float giaSach;
	private int namXB;
	public Sach(String maSach, String tenSach, float giaSach, int namXB) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.giaSach = giaSach;
		this.namXB = namXB;
	}
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public float getGiaSach() {
		return giaSach;
	}
	public void setGiaSach(float giaSach) {
		this.giaSach = giaSach;
	}
	public int getNamXB() {
		return namXB;
	}
	public void setNamXB(int namXB) {
		this.namXB = namXB;
	}
	
	
}
