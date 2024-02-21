package DTO;

public class ChungLoai {
	private String maChungLoai;
	private String ten;
	public ChungLoai() {
		
	}
	public ChungLoai(String maChungLoai, String ten) {
		this.maChungLoai = maChungLoai;
		this.ten = ten;
	}
	public String getMaChungLoai() {
		return maChungLoai;
	}
	public void setMaChungLoai(String maChungLoai) {
		this.maChungLoai = maChungLoai;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	@Override
	public String toString() {
		return maChungLoai+" - "+ten;
	}
	
	
}
