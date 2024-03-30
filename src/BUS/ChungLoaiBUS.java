package BUS;

import java.util.ArrayList;

import DAO.ChungLoaiDAO;
import DTO.ChungLoai;

public class ChungLoaiBUS {
	public static ChungLoaiBUS getIntance() {
		return new ChungLoaiBUS();
	}
	public ArrayList<String> getListChungloai(){
		ArrayList<String>listCL=new ArrayList<>();
		for (ChungLoai cl : ChungLoaiDAO.getIntance().selectAll()) {
			listCL.add(cl.toString());
		}
		return listCL;
	}
}
