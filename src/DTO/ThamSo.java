package DTO;

public class ThamSo {
	private String ten;
	private int giaTri;
	public ThamSo() {
		
	}
	public ThamSo(String ten, int giaTri) {
		this.ten = ten;
		this.giaTri = giaTri;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getGiaTri() {
		return giaTri;
	}
	public void setGiaTri(int giaTri) {
		this.giaTri = giaTri;
	}
	
	
}
