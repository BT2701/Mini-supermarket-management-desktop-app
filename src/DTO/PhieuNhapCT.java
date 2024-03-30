package DTO;

public class PhieuNhapCT {
	private String maPN,maMH,maNCC;
	private int sl;
	public PhieuNhapCT() {
		
	}
	public PhieuNhapCT(String maPN, String maMH, String maNCC,int sl) {
		this.maPN = maPN;
		this.maMH = maMH;
		this.maNCC = maNCC;
		this.sl=sl;
	}

	public String getMaPN() {
		return maPN;
	}

	public void setMaPN(String maPN) {
		this.maPN = maPN;
	}

	public String getMaMH() {
		return maMH;
	}

	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}

	public String getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}
	
	public int getSl() {
		return sl;
	}
	public void setSl(int sl) {
		this.sl = sl;
	}
	@Override
	public String toString() {
		return "PhieuNhapCT [maPN=" + maPN + ", maMH=" + maMH + ", maNCC=" + maNCC + "]";
	}
	
	
}
