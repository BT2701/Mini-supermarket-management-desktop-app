package DTO;

public class KhuyenMaiDTO {
	private String ten;
	private int giatri;
	public KhuyenMaiDTO() {
		
	}
	public KhuyenMaiDTO(String ten, int giatri) {
		this.ten = ten;
		this.giatri = giatri;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getGiatri() {
		return giatri;
	}
	public void setGiatri(int giatri) {
		this.giatri = giatri;
	}
	
	
}
