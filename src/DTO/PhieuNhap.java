package DTO;

import java.util.Date;

public class PhieuNhap {
	private String maPN,maNV;
	private Date thoiDiemLap;
	private java.sql.Date date;
	public PhieuNhap() {
		
	}
	public PhieuNhap(String maPN, String maNV, Date thoiDiemLap) {
		this.maPN = maPN;
		this.maNV = maNV;
		this.thoiDiemLap = thoiDiemLap;
		setDate(thoiDiemLap);
	}
	public String getMaPN() {
		return maPN;
	}
	public void setMaPN(String maPN) {
		this.maPN = maPN;
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
	public java.sql.Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date= new java.sql.Date(date.getTime());
	}
	@Override
	public String toString() {
		return "PhieuNhap [maPN=" + maPN + ", maNV=" + maNV + ", date=" + date + "]";
	}
	
	
}
