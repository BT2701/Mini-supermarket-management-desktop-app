package DTO;

import java.util.Date;

public class MatHangDTO {
	private String maMh;
	private String tenMh;
	private double giaMua;
	private double giaBan;
	private Date ngaySX;
	private Date hsd;
	private int slNhap;
	private int slBan;
	private Date ngayNhap;
	private int vat;
	private String maLH;
	private String maDVT;
	private java.sql.Date datengsx;
	private java.sql.Date datehsd;
	private java.sql.Date datengaynhap;
	private String img;
	public MatHangDTO() {
		
	}
	public MatHangDTO(String maMh, String tenMh, double giaMua, double giaBan, Date ngaySX, Date hsd, int slNhap,
			int slBan, Date ngayNhap, int vat, String maLH, String maDVT,String img) {
		this.maMh = maMh;
		this.tenMh = tenMh;
		this.giaMua = giaMua;
		this.giaBan = giaBan;
		this.ngaySX = ngaySX;
		this.hsd = hsd;
		this.slNhap = slNhap;
		this.slBan = slBan;
		this.ngayNhap = ngayNhap;
		this.vat = vat;
		this.maLH = maLH;
		this.maDVT = maDVT;
		this.img=img;
		setDatengsx(ngaySX);
		setDatehsd(hsd);
		setDatengaynhap(ngayNhap);
	}
	public String getMaMh() {
		return maMh;
	}
	public void setMaMh(String maMh) {
		this.maMh = maMh;
	}
	public String getTenMh() {
		return tenMh;
	}
	public void setTenMh(String tenMh) {
		this.tenMh = tenMh;
	}
	public double getGiaMua() {
		return giaMua;
	}
	public void setGiaMua(double giaMua) {
		this.giaMua = giaMua;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	public Date getNgaySX() {
		return ngaySX;
	}
	public void setNgaySX(Date ngaySX) {
		this.ngaySX = ngaySX;
	}
	public Date getHsd() {
		return hsd;
	}
	public void setHsd(Date hsd) {
		this.hsd = hsd;
	}
	public int getSlNhap() {
		return slNhap;
	}
	public void setSlNhap(int slNhap) {
		this.slNhap = slNhap;
	}
	public int getSlBan() {
		return slBan;
	}
	public void setSlBan(int slBan) {
		this.slBan = slBan;
	}
	public Date getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	public int getVat() {
		return vat;
	}
	public void setVat(int vat) {
		this.vat = vat;
	}
	public String getMaLH() {
		return maLH;
	}
	public void setMaLH(String maLH) {
		this.maLH = maLH;
	}
	public String getMaDVT() {
		return maDVT;
	}
	public void setMaDVT(String maDVT) {
		this.maDVT = maDVT;
	}
	public java.sql.Date getDatengsx() {
		return datengsx;
	}
	public void setDatengsx(Date date) {
		this.datengsx= new java.sql.Date(date.getTime());
	}
	public java.sql.Date getDatehsd() {
		return datehsd;
	}
	public void setDatehsd(Date date) {
		this.datehsd= new java.sql.Date(date.getTime());
	}
	public java.sql.Date getDatengaynhap() {
		return datengaynhap;
	}
	public void setDatengaynhap(Date date) {
		this.datengaynhap= new java.sql.Date(date.getTime());
	}
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "DTO_MatHang [maMh=" + maMh + ", tenMh=" + tenMh + ", giaMua=" + giaMua + ", giaBan=" + giaBan
				+ ", slNhap=" + slNhap + ", slBan=" + slBan + ", vat=" + vat + ", maLH=" + maLH + ", maDVT=" + maDVT
				+ ", datengsx=" + datengsx + ", datehsd=" + datehsd + ", datengaynhap=" + datengaynhap + "]";
	}
	
	
}
