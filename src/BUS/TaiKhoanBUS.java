package BUS;

import java.util.ArrayList;

import DAO.TaiKhoanDAO;
import DTO.DTO_TaiKhoan;

public class TaiKhoanBUS implements BusInterface<DTO_TaiKhoan> {

	private ArrayList<DTO_TaiKhoan> listtk=TaiKhoanDAO.getInstance().selectAll();
	public static TaiKhoanBUS getInstance() {
		return new TaiKhoanBUS();
	}

	@Override
	public ArrayList<DTO_TaiKhoan> getList() {
		// TODO Auto-generated method stub
		return listtk;
	}

	@Override
	public void saveData(DTO_TaiKhoan t) {
		// TODO Auto-generated method stub

	}

	@Override
	public DTO_TaiKhoan getByID(DTO_TaiKhoan t) {
		// TODO Auto-generated method stub
		return TaiKhoanDAO.getInstance().selectById(t);
	}

	@Override
	public void inSert(DTO_TaiKhoan t) {
		// TODO Auto-generated method stub
		TaiKhoanDAO.getInstance().them(t);
	}

	@Override
	public void upDate(DTO_TaiKhoan t) {
		// TODO Auto-generated method stub
		TaiKhoanDAO.getInstance().capNhap(t);
	}

	@Override
	public void delete(DTO_TaiKhoan t) {
		// TODO Auto-generated method stub
		TaiKhoanDAO.getInstance().xoa(t);
	}

	public DTO_TaiKhoan layTaiKhoan(String tenDN, String matKhau) {
		DTO_TaiKhoan taiKhoan = null;
		for (DTO_TaiKhoan tk : getList()) {
			String tdn = tk.getTenDN();
			String mk = tk.getMatKhau();
			if (tdn.equals(tenDN) && mk.equals(matKhau)) {
				taiKhoan=tk;
			}
		}
		return taiKhoan;

	}
	public void voHieuHoaTaiKhoan(String maNV) {
		TaiKhoanDAO.getInstance().voHieuHoaTaiKhoan(maNV);
	}

}
