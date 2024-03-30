package DTO;

public class DonViDTO {
	private String maDVT;
	private String tenDVT;
	public DonViDTO() {
		
	}
	public DonViDTO(String maDVT, String tenDVT) {
		this.maDVT = maDVT;
		this.tenDVT = tenDVT;
	}
	public String getMaDVT() {
		return maDVT;
	}
	public void setMaDVT(String maDVT) {
		this.maDVT = maDVT;
	}
	public String getTenDVT() {
		return tenDVT;
	}
	public void setTenDVT(String tenDVT) {
		this.tenDVT = tenDVT;
	}
	
	
}
