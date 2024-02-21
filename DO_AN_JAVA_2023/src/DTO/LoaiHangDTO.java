package DTO;

public class LoaiHangDTO {
	private String maLH;
	private String tenLH;
	private String maCL;
	public LoaiHangDTO() {
		
	}
	public LoaiHangDTO(String maLH, String tenLH, String maCL) {
		this.maLH = maLH;
		this.tenLH = tenLH;
		this.maCL = maCL;
	}
	public String getMaLH() {
		return maLH;
	}
	public void setMaLH(String maLH) {
		this.maLH = maLH;
	}
	public String getTenLH() {
		return tenLH;
	}
	public void setTenLH(String tenLH) {
		this.tenLH = tenLH;
	}
	public String getMaCL() {
		return maCL;
	}
	public void setMaCL(String maCL) {
		this.maCL = maCL;
	}
	
}
