package DTO;

public class PhanQuyen {
	private String quyen;
	private int nhapHang,qlSP,qlNV,	qlKh,qlNCC,qlThongKe,them,xoa,sua,qlPhanQuyen;
	public PhanQuyen() {
		
	}
	
	public PhanQuyen(String quyen, int nhapHang, int qlSP, int qlNV, int qlKh, int qlNCC, int qlThongKe, int them,
			int xoa, int sua, int qlPhanQuyen) {
		this.quyen = quyen;
		this.nhapHang = nhapHang;
		this.qlSP = qlSP;
		this.qlNV = qlNV;
		this.qlKh = qlKh;
		this.qlNCC = qlNCC;
		this.qlThongKe = qlThongKe;
		this.them = them;
		this.xoa = xoa;
		this.sua = sua;
		this.qlPhanQuyen = qlPhanQuyen;
	}

	public String getQuyen() {
		return quyen;
	}
	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}
	public int getNhapHang() {
		return nhapHang;
	}
	public void setNhapHang(int nhapHang) {
		this.nhapHang = nhapHang;
	}
	public int getQlSP() {
		return qlSP;
	}
	public void setQlSP(int qlSP) {
		this.qlSP = qlSP;
	}
	public int getQlNV() {
		return qlNV;
	}
	public void setQlNV(int qlNV) {
		this.qlNV = qlNV;
	}
	public int getQlKh() {
		return qlKh;
	}
	public void setQlKh(int qlKh) {
		this.qlKh = qlKh;
	}
	public int getQlNCC() {
		return qlNCC;
	}
	public void setQlNCC(int qlNCC) {
		this.qlNCC = qlNCC;
	}
	public int getQlThongKe() {
		return qlThongKe;
	}
	public void setQlThongKe(int qlThongKe) {
		this.qlThongKe = qlThongKe;
	}
	
	public int getThem() {
		return them;
	}

	public void setThem(int them) {
		this.them = them;
	}

	public int getXoa() {
		return xoa;
	}

	public void setXoa(int xoa) {
		this.xoa = xoa;
	}

	public int getSua() {
		return sua;
	}

	public void setSua(int sua) {
		this.sua = sua;
	}

	public int getQlPhanQuyen() {
		return qlPhanQuyen;
	}

	public void setQlPhanQuyen(int qlPhanQuyen) {
		this.qlPhanQuyen = qlPhanQuyen;
	}

	@Override
	public String toString() {
		return "PhanQuyen [quyen=" + quyen + ", nhapHang=" + nhapHang + ", qlSP=" + qlSP + ", qlNV=" + qlNV + ", qlKh="
				+ qlKh + ", qlNCC=" + qlNCC + ", qlThongKe=" + qlThongKe + ", them=" + them + ", xoa=" + xoa + ", sua="
				+ sua + ", qlPhanQuyen=" + qlPhanQuyen + "]";
	}

	
	
}
