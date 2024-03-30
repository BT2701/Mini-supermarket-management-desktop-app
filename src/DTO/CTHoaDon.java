package DTO;

public class CTHoaDon {
	private String maHd;
	private String maMH;
	private int slMH;
	private double donGia,thanhTien;
	public CTHoaDon() {
		
	}
	public CTHoaDon(String maHd, String maMH, int slMH, double donGia,double thanhTien) {
		this.maHd = maHd;
		this.maMH = maMH;
		this.slMH = slMH;
		this.donGia=donGia;
		this.thanhTien=thanhTien;
	}
	public String getMaHd() {
		return maHd;
	}
	public void setMaHd(String maHd) {
		this.maHd = maHd;
	}
	public String getMaMH() {
		return maMH;
	}
	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}
	public int getSlMH() {
		return slMH;
	}
	public void setSlMH(int slMH) {
		this.slMH = slMH;
	}
	
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public double getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
	@Override
	public String toString() {
		return "CTHoaDon [maHd=" + maHd + ", maMH=" + maMH + ", slMH=" + slMH + ", donGia=" + donGia + ", thanhTien="
				+ thanhTien + "]";
	}
	
	
	
}
