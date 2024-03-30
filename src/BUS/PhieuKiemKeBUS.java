package BUS;

import java.util.ArrayList;

import DAO.PhieuKiemKeDAO;
import DTO.PhieuKiemKe;

public class PhieuKiemKeBUS implements BusInterface<PhieuKiemKe>{
	public static PhieuKiemKeBUS getInstance() {
		return new PhieuKiemKeBUS();
	}
	public int getMaPKKmoiNhat() {
		int index=getList().size()-1;
		String txtmaHDmoiNhat=getList().get(index).getMaPkk();
		txtmaHDmoiNhat=txtmaHDmoiNhat.replace("KK", "");
		int maHDmoiNhat=Integer.parseInt(txtmaHDmoiNhat);
		return maHDmoiNhat;
	}
	@Override
	public ArrayList<PhieuKiemKe> getList() {
		// TODO Auto-generated method stub
		return PhieuKiemKeDAO.getIntance().selectAll();
	}
	@Override
	public void saveData(PhieuKiemKe t) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public PhieuKiemKe getByID(PhieuKiemKe t) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void inSert(PhieuKiemKe t) {
		// TODO Auto-generated method stub
		PhieuKiemKeDAO.getIntance().them(t);
		
	}
	@Override
	public void upDate(PhieuKiemKe t) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(PhieuKiemKe t) {
		// TODO Auto-generated method stub
		
	}
	public ArrayList<String>layDanhSachMaPKK(){
		ArrayList<String> listMaPkk=new ArrayList<>();
		for (PhieuKiemKe pkk : getList()) {
			listMaPkk.add(pkk.getMaPkk());
		}
		return listMaPkk;
	}
	public PhieuKiemKe layPhieuKKtheoMa(String maPKK) {
		PhieuKiemKe pkk=null;
		for (PhieuKiemKe phieuKK : getList()) {
			if(phieuKK.getMaPkk().equalsIgnoreCase(maPKK)) {
				pkk=phieuKK;
			}
		}
		return pkk;
	}
	
}
