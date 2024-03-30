package DTO;

import java.util.Date;

public class PhieuXuat {
	private String maPX,maNV;
	private Date thoiDiemLap;
	private java.sql.Date date;
	public PhieuXuat() {
		
	}
	public PhieuXuat(String maPX, String maNV, Date thoiDiemLap) {
		this.maPX = maPX;
		this.maNV = maNV;
		this.thoiDiemLap = thoiDiemLap;
		setDate(thoiDiemLap);
	}
	public String getMaPX() {
		return maPX;
	}
	public void setMaPX(String maPX) {
		this.maPX = maPX;
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
		return "PhieuXuat [maPX=" + maPX + ", maNV=" + maNV + ", date=" + date + "]";
	}
	
}
