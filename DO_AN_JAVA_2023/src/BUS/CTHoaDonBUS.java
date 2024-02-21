package BUS;

import java.util.ArrayList;
import java.util.Date;

import DAO.CTHoaDonDAO;
import DTO.CTHoaDon;

public class CTHoaDonBUS implements BusInterface<CTHoaDon>{
	private ArrayList<CTHoaDon> DShoaDon=CTHoaDonDAO.getIntance().selectAll();
	public static CTHoaDonBUS getIntance() {
		return new CTHoaDonBUS();
	}

	@Override
	public ArrayList<CTHoaDon> getList() {
		// TODO Auto-generated method stub
		return DShoaDon;
	}

	@Override
	public void saveData(CTHoaDon t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CTHoaDon getByID(CTHoaDon t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inSert(CTHoaDon t) {
		CTHoaDonDAO.getIntance().them(t);
	}

	@Override
	public void upDate(CTHoaDon t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(CTHoaDon t) {
		// TODO Auto-generated method stub
		
	}
	public ArrayList<CTHoaDon> layDanhSachTheoMaHD(String maHD){
		ArrayList<CTHoaDon>listCTHD=new ArrayList<>();
		for (CTHoaDon ctHoaDon : getList()) {
			if(ctHoaDon.getMaHd().equalsIgnoreCase(maHD)) {
				listCTHD.add(ctHoaDon);
			}
		}
		return listCTHD;
	}
	public int getTongSoLuongBanHang() {
		int soLuong=0;
		for (CTHoaDon ctHoaDon : getList()) {
			soLuong+=ctHoaDon.getSlMH();
		}
		return soLuong;
	}
	public int getTongSoLuongBanHangTheoNV(String maNV) {
		int soLuong=0;
		ArrayList<String> listMaHD=HoaDonBUS.getIntance().getDsMaHoaDonTheoNV(maNV);
		for (CTHoaDon ctHoaDon : getList()) {
			for (String maHD : listMaHD) {
				if(ctHoaDon.getMaHd().equalsIgnoreCase(maHD)) {
					soLuong+=ctHoaDon.getSlMH();
				}
			}
		}
		return soLuong;
	}
	
	public int getTongSoLuongBanHangTheoNgay(Date tuNgay, Date denNgay) {
		int soLuong=0;
		ArrayList<String> listHD=HoaDonBUS.getIntance().layMaHoaDonTheoKhoangThoiGian(tuNgay, denNgay);
		for (CTHoaDon ctHoaDon : getList()) {
			for (String maHD : listHD) {
				if(ctHoaDon.getMaHd().equalsIgnoreCase(maHD)) {
					soLuong+=ctHoaDon.getSlMH();
				}
			}
		}
		return soLuong;
	}
	public ArrayList<String> layDanhSachSanPhamBanChay(){
		ArrayList<String > listSP=CTHoaDonDAO.getIntance().layDanhSachSanPhamBanChay();
		
		return listSP;
	}
	public double layTongTienTheoMaHD(String maHD) {
		return CTHoaDonDAO.getIntance().layTongTienTheoMaHD(maHD);
	}
	
}
