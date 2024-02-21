package BUS;

import java.util.ArrayList;

import DAO.KhuyenMaiDAO;
import DTO.KhuyenMaiDTO;

public class KhuyenMaiBUS implements BusInterface<KhuyenMaiDTO>{

	public static KhuyenMaiBUS getInstance() {
		return new KhuyenMaiBUS();
	}
	@Override
	public ArrayList<KhuyenMaiDTO> getList() {
		// TODO Auto-generated method stub
		return KhuyenMaiDAO.getIstance().selectAll();
	}

	@Override
	public void saveData(KhuyenMaiDTO t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public KhuyenMaiDTO getByID(KhuyenMaiDTO t) {
		// TODO Auto-generated method stub
		return KhuyenMaiDAO.getIstance().selectById(t);
	}

	@Override
	public void inSert(KhuyenMaiDTO t) {
		// TODO Auto-generated method stub
		KhuyenMaiDAO.getIstance().them(t);
	}

	@Override
	public void upDate(KhuyenMaiDTO t) {
		// TODO Auto-generated method stub
		KhuyenMaiDAO.getIstance().capNhap(t);
	}

	@Override
	public void delete(KhuyenMaiDTO t) {
		// TODO Auto-generated method stub
		KhuyenMaiDAO.getIstance().xoa(t);
	}

}
