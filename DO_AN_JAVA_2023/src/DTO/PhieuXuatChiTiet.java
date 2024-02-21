package DTO;

public class PhieuXuatChiTiet {
	private String maPX,maMH;
	private int soLuong;
	public PhieuXuatChiTiet() {
		
	}
	public PhieuXuatChiTiet(String maPX, String maMH, int soLuong) {
		this.maPX = maPX;
		this.maMH = maMH;
		this.soLuong = soLuong;
	}
	public String getMaPX() {
		return maPX;
	}
	public void setMaPX(String maPX) {
		this.maPX = maPX;
	}
	public String getMaMH() {
		return maMH;
	}
	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	@Override
	public String toString() {
		return "PhieuXuatChiTiet [maPX=" + maPX + ", maMH=" + maMH + ", soLuong=" + soLuong + "]";
	}
	
}
