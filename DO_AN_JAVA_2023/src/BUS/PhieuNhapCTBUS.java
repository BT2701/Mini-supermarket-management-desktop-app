package BUS;

import java.util.ArrayList;

import DAO.PhieuNhapCTDAO;
import DTO.PhieuNhapCT;

public class PhieuNhapCTBUS implements BusInterface<PhieuNhapCT>{

	public static PhieuNhapCTBUS getInstance() {
		return new PhieuNhapCTBUS();
	}
	@Override
	public ArrayList<PhieuNhapCT> getList() {
		// TODO Auto-generated method stub
		return PhieuNhapCTDAO.getIntance().selectAll();
	}

	@Override
	public void saveData(PhieuNhapCT t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PhieuNhapCT getByID(PhieuNhapCT t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inSert(PhieuNhapCT t) {
		// TODO Auto-generated method stub
		PhieuNhapCTDAO.getIntance().them(t);
	}

	@Override
	public void upDate(PhieuNhapCT t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(PhieuNhapCT t) {
		// TODO Auto-generated method stub
		
	}
	public ArrayList<PhieuNhapCT> layDStheoMaPN(String maPN){
		ArrayList<PhieuNhapCT> list=new ArrayList<>();
		for (PhieuNhapCT phieuNhapCT : getList()) {
			if(phieuNhapCT.getMaPN().equalsIgnoreCase(maPN)) {
				list.add(phieuNhapCT);
			}
		}
		return list;
	}

}
