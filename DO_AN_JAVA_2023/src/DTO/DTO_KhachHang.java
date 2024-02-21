package DTO;

import java.util.Date;

public class DTO_KhachHang {
	private String maKH;
	private String hoTen;
	private String diaChi;
	private Date ngayCapThe;
	private java.sql.Date dateNgayCapThe;
	private Date ngayMuaGanNhat;
	private java.sql.Date dateNgayMuaGanNhat;
	private int diemThuong;
	public DTO_KhachHang() {
		
	}
	public DTO_KhachHang(String maKH, String hoTen, String diaChi, Date ngayCapThe, Date ngayMuaGanNhat,
			int diemThuong) {
		this.maKH = maKH;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.ngayCapThe = ngayCapThe;
		this.ngayMuaGanNhat = ngayMuaGanNhat;
		this.diemThuong = diemThuong;
		setDateNgayCapThe(ngayCapThe);
		setDateNgayMuaGanNhat(ngayMuaGanNhat);
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public Date getNgayCapThe() {
		return ngayCapThe;
	}
	public void setNgayCapThe(Date ngayCapThe) {
		this.ngayCapThe = ngayCapThe;
	}
	public Date getNgayMuaGanNhat() {
		return ngayMuaGanNhat;
	}
	public void setNgayMuaGanNhat(Date ngayMuaGanNhat) {
		this.ngayMuaGanNhat = ngayMuaGanNhat;
		setDateNgayMuaGanNhat(ngayMuaGanNhat);
	}
	public int getDiemThuong() {
		return diemThuong;
	}
	public void setDiemThuong(int diemThuong) {
		this.diemThuong = diemThuong;
	}
	public java.sql.Date getDateNgayCapThe() {
		return dateNgayCapThe;
	}
	public void setDateNgayCapThe(Date dateNgayCapThe) {
		this.dateNgayCapThe = new java.sql.Date(dateNgayCapThe.getTime());
	}
	public java.sql.Date getDateNgayMuaGanNhat() {
		return dateNgayMuaGanNhat;
	}
	public void setDateNgayMuaGanNhat(Date dateNgayMuaGanNhat) {
		this.dateNgayMuaGanNhat = new java.sql.Date(dateNgayMuaGanNhat.getTime());
	}
	
	
}
