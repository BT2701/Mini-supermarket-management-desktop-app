package DTO;

import java.util.Date;

public class HoaDon {
	private String maHD;
	private String maNV;
	private Date thoiDiemLap;
	private java.sql.Date date;
	private double tongTienPhaiTra;
	private String maKH;
	private int diemThuong;
	private int trangThai;
	public HoaDon() {
		
	}
	public HoaDon(String maHD, String maNV, Date thoiDiemLap, double tongTienPhaiTra, String maKH, int diemThuong,int trangThai) {
		this.maHD = maHD;
		this.maNV = maNV;
		this.thoiDiemLap = thoiDiemLap;
		this.tongTienPhaiTra = tongTienPhaiTra;
		this.maKH = maKH;
		this.diemThuong = diemThuong;
		this.trangThai=trangThai;
		setDate(thoiDiemLap);
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public Date getThoiDiemLap() {
		return thoiDiemLap;
	}
	public void setThoiDiemLap(Date thoiDiemLap) {
		this.thoiDiemLap = thoiDiemLap;
	}
	public double getTongTienPhaiTra() {
		return tongTienPhaiTra;
	}
	public void setTongTienPhaiTra(double tongTienPhaiTra) {
		this.tongTienPhaiTra = tongTienPhaiTra;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public int getDiemThuong() {
		return diemThuong;
	}
	public void setDiemThuong(int diemThuong) {
		this.diemThuong = diemThuong;
	}
	public java.sql.Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date= new java.sql.Date(date.getTime());
	}
	
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", maNV=" + maNV + ", thoiDiemLap=" + date
				+ ", tongTienPhaiTra=" + tongTienPhaiTra + ", maKH=" + maKH + ", diemThuong=" + diemThuong + ", mucGia="
				+ "]";
	}
	
	
	
}
