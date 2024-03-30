package DTO;

public class PhieuKiemKeCT {
	private String maPkk,maMh;
	private int slTon;
	public PhieuKiemKeCT() {
		
	}
	public PhieuKiemKeCT(String maPkk, String maMh, int slTon) {
		this.maPkk = maPkk;
		this.maMh = maMh;
		this.slTon = slTon;
	}
	public String getMaPkk() {
		return maPkk;
	}
	public void setMaPkk(String maPkk) {
		this.maPkk = maPkk;
	}
	public String getMaMh() {
		return maMh;
	}
	public void setMaMh(String maMh) {
		this.maMh = maMh;
	}
	public int getSlTon() {
		return slTon;
	}
	public void setSlTon(int slTon) {
		this.slTon = slTon;
	}
	@Override
	public String toString() {
		return "PhieuKiemKeCT [maPkk=" + maPkk + ", maMh=" + maMh + ", slTon=" + slTon + "]";
	}
	
	
}
