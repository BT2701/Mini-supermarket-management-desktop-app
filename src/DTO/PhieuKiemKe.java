package DTO;

import java.util.Date;

public class PhieuKiemKe {
	private String maPkk,maNV;
	private Date thoiDiemLap;
	private java.sql.Date date;
	public PhieuKiemKe() {
		
	}
	public PhieuKiemKe(String maPkk, String maNV, Date thoiDiemLap) {
		this.maPkk = maPkk;
		this.maNV = maNV;
		this.thoiDiemLap = thoiDiemLap;
		setDate(thoiDiemLap);
	}
	public String getMaPkk() {
		return maPkk;
	}
	public void setMaPkk(String maPkk) {
		this.maPkk = maPkk;
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
		return "PhieuKiemKe [maPkk=" + maPkk + ", maNV=" + maNV + ", date=" + date
				+ "]";
	}
	
	
}
