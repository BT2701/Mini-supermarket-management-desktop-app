package BUS;

import java.util.ArrayList;

import DAO.PhanQuyenDAO;
import DTO.PhanQuyen;

public class PhanQuyenBUS implements BusInterface<PhanQuyen>{

	public static PhanQuyenBUS getInstance() {
		return new PhanQuyenBUS();
	}
	@Override
	public ArrayList<PhanQuyen> getList() {
		// TODO Auto-generated method stub
		return PhanQuyenDAO.getIntance().selectAll();
	}

	@Override
	public void saveData(PhanQuyen t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PhanQuyen getByID(PhanQuyen t) {
		// TODO Auto-generated method stub
		
		return PhanQuyenDAO.getIntance().selectById(t);
	}

	@Override
	public void inSert(PhanQuyen t) {
		// TODO Auto-generated method stub
		PhanQuyenDAO.getIntance().them(t);
		
	}

	@Override
	public void upDate(PhanQuyen t) {
		// TODO Auto-generated method stub
		PhanQuyenDAO.getIntance().capNhap(t);
	}

	@Override
	public void delete(PhanQuyen t) {
		// TODO Auto-generated method stub
		PhanQuyenDAO.getIntance().xoa(t);
	}
	
	public ArrayList<String> layDanhSachQuyen(){
		ArrayList<String> listq=new ArrayList<>();
		for (PhanQuyen quyen : getList()) {
			listq.add(quyen.getQuyen());
		}
		return listq;
	}
	

}
