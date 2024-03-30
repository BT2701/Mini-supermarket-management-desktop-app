package DTO;

public class DTO_TaiKhoan {
	private String maNV,tenDN,matKhau,quyen,hinhAnh;
	private int trangThai;
	public DTO_TaiKhoan() {
		
	}
	public DTO_TaiKhoan(String maNV, String tenDN, String matKhau, String quyen, int trangThai,String hinhAnh) {
		this.maNV = maNV;
		this.tenDN = tenDN;
		this.matKhau = matKhau;
		this.quyen = quyen;
		this.trangThai = trangThai;
		this.hinhAnh=hinhAnh;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenDN() {
		return tenDN;
	}
	public void setTenDN(String tenDN) {
		this.tenDN = tenDN;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getQuyen() {
		return quyen;
	}
	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	@Override
	public String toString() {
		return "DTO_TaiKhoan [maNV=" + maNV + ", tenDN=" + tenDN + ", matKhau=" + matKhau + ", quyen=" + quyen
				+ ", trangThai=" + trangThai + "]";
	}
	
	
}
