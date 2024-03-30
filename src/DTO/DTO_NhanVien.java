package DTO;

import java.util.Date;

public class DTO_NhanVien {
	private String maNV;
	private String hoTen;
	private Date ngaySinh;
	private java.sql.Date dateNgaySinh;
	private String  gioiTinh;
	private String cmnd;
	private String diaChi;
	private String sdt;
	private Date ngayVaoLam;
	private java.sql.Date dateNgayVL;
	private String maCV;
	public DTO_NhanVien() {
		
	}
	public DTO_NhanVien(String maNV, String hoTen, Date ngaySinh, String gioiTinh, String cmnd, String diaChi,
			String sdt, Date ngayVaoLam, String maCV) {
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.cmnd = cmnd;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.ngayVaoLam = ngayVaoLam;
		this.maCV = maCV;
		setDateNgaySinh(ngaySinh);
		setDateNgayVL(ngayVaoLam);
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public Date getNgayVaoLam() {
		return ngayVaoLam;
	}
	public void setNgayVaoLam(Date ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}
	public String getMaCV() {
		return maCV;
	}
	public void setMaCV(String maCV) {
		this.maCV = maCV;
	}
	public java.sql.Date getDateNgaySinh() {
		return dateNgaySinh;
	}
	public void setDateNgaySinh(Date dateNgaySinh) {
		this.dateNgaySinh = new java.sql.Date(dateNgaySinh.getTime());
	}
	public java.sql.Date getDateNgayVL() {
		return dateNgayVL;
	}
	public void setDateNgayVL(Date dateNgayVL) {
		this.dateNgayVL = new java.sql.Date(dateNgayVL.getTime());
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	
}
