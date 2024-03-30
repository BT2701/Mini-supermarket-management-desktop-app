//package BUS;
//
//import java.util.ArrayList;
//
//import DAO.LoaiHangDAO;
//import DTO.LoaiHangDTO;
//
//public class LoaiHangBUS implements BusInterface<LoaiHangDTO>{
//	public static LoaiHangBUS getIntance() {
//		return new LoaiHangBUS();
//	}
//	public ArrayList<String>getListByChungLoai(String maCl){
//		return LoaiHangDAO.getIntance().selectByChungLoai(maCl);
//	}
//	public ArrayList<String> getMaLH(){
//		ArrayList<String> listMaLH=new ArrayList<>();
//		for (LoaiHangDTO loaiHang : getList()) {
//			String maLH=loaiHang.getMaLH();
//			listMaLH.add(maLH);
//		}
//		return listMaLH;
//	}
//	@Override
//	public ArrayList<LoaiHangDTO> getList() {
//		// TODO Auto-generated method stub
//		return LoaiHangDAO.getIntance().selectAll();
//	}
//	@Override
//	public void saveData(LoaiHangDTO t) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public LoaiHangDTO getByID(LoaiHangDTO t) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//	public void inSert(LoaiHangDTO t) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public void upDate(LoaiHangDTO t) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public void delete(LoaiHangDTO t) {
//		// TODO Auto-generated method stub
//		
//	}
//}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.LoaiHangDAO;
import DTO.LoaiHangDTO;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class LoaiHangBUS {
    private LoaiHangDAO loaihangDAO= new LoaiHangDAO();
    private ArrayList<LoaiHangDTO> listloaihang = null;
    public static LoaiHangBUS getIntance() {
        return new LoaiHangBUS();
	}
    public ArrayList<LoaiHangDTO> getList()
    {
        listloaihang = loaihangDAO.selectAll();
        return listloaihang;
    }
    public ArrayList<String>getListByChungLoai(String maCl){
		return LoaiHangDAO.getIntance().selectByChungLoai(maCl);
	}
    public LoaiHangDTO getLoaiHangByID(LoaiHangDTO lh) {
		return loaihangDAO.getIntance().selectById(lh);
	}
    public String laymatheotenloaihang(String tenloaihang)
    {
        String malh= null;
        for(LoaiHangDTO mh : getList())
        {
            if(mh.getTenLH().equalsIgnoreCase(tenloaihang))
            {
                malh=mh.getMaLH();
            }
        }
        return malh;
    }
    public String laytentheomaloaihang(String maloaihang)
    {
        String tenlh=null;
        for(LoaiHangDTO lh: getList())
        {
            if(lh.getMaLH().equalsIgnoreCase(maloaihang))
                tenlh=lh.getTenLH();
        }
        return tenlh;
    }
	public ArrayList<String> getMaLH(){
		ArrayList<String> listMaLH=new ArrayList<>();
		for (LoaiHangDTO loaiHang : getList()) {
			String maLH=loaiHang.getMaLH();
			listMaLH.add(maLH);
		}
		return listMaLH;
	}
}

