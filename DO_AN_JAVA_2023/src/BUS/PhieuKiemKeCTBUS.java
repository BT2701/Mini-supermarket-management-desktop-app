package BUS;

import java.util.ArrayList;

import DAO.PhieuKiemKeCTDAO;
import DTO.PhieuKiemKeCT;

public class PhieuKiemKeCTBUS implements BusInterface<PhieuKiemKeCT>{

	public static PhieuKiemKeCTBUS getInstance() {
		return new PhieuKiemKeCTBUS();
	}
	@Override
	public ArrayList<PhieuKiemKeCT> getList() {
		// TODO Auto-generated method stub
		return PhieuKiemKeCTDAO.getIntance().selectAll();
	}

	@Override
	public void saveData(PhieuKiemKeCT t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PhieuKiemKeCT getByID(PhieuKiemKeCT t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inSert(PhieuKiemKeCT t) {
		// TODO Auto-generated method stub
		PhieuKiemKeCTDAO.getIntance().them(t);
	}

	@Override
	public void upDate(PhieuKiemKeCT t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(PhieuKiemKeCT t) {
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<PhieuKiemKeCT> layDanhSachCTPKKtheoMa(String maPKK){
		ArrayList<PhieuKiemKeCT> listCtpkk=new ArrayList<>();
		for (PhieuKiemKeCT phieuKiemKeCT : getList()) {
			if(phieuKiemKeCT.getMaPkk().equalsIgnoreCase(maPKK)) {
				listCtpkk.add(phieuKiemKeCT);
			}
		}
		return listCtpkk;
	}

}
