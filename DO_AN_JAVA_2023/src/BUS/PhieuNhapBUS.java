package BUS;

import java.util.ArrayList;
import java.util.Date;

import DAO.PhieuNhapDAO;
import DTO.HoaDon;
import DTO.PhieuNhap;

public class PhieuNhapBUS implements BusInterface<PhieuNhap>{
	public static PhieuNhapBUS getInstance() {
		return new PhieuNhapBUS();
	}

	@Override
	public ArrayList<PhieuNhap> getList() {
		// TODO Auto-generated method stub
		return PhieuNhapDAO.getIntance().selectAll();
	}

	@Override
	public void saveData(PhieuNhap t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PhieuNhap getByID(PhieuNhap t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inSert(PhieuNhap t) {
		// TODO Auto-generated method stub
		PhieuNhapDAO.getIntance().them(t);
	}

	@Override
	public void upDate(PhieuNhap t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(PhieuNhap t) {
		// TODO Auto-generated method stub
		
	}
	public int getMaPNmoiNhat() {
		int maHDmoiNhat=0; 
		for (PhieuNhap hoaDon : getList()) {
			String txtmaHD=hoaDon.getMaPN();
			txtmaHD=txtmaHD.replace("PN", "");
			int maHD=Integer.parseInt(txtmaHD);
			if(maHD>maHDmoiNhat) {
				maHDmoiNhat=maHD;
			}
		}
		return maHDmoiNhat;
	}
	public ArrayList<PhieuNhap> layPhieuNhapTheoKhoangThoiGian(Date tuNgay,Date denNgay){
		return PhieuNhapDAO.getIntance().layPhieuNhapTheoKhoangThoiGian(tuNgay, denNgay);
	}
	

}
