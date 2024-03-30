//package BUS;
//
//import java.util.ArrayList;
//
//import DAO.HoaDonDAO;
//import DAO.KhachHangDAO;
//import DTO.DTO_KhachHang;
//import DTO.HoaDon;
//
//public class KhachHangBUS implements BusInterface<DTO_KhachHang>{
//	private ArrayList<DTO_KhachHang> listkh;
//	private KhachHangDAO dataListkh=new KhachHangDAO() ;
//	public static KhachHangBUS getIntance() {
//		return new KhachHangBUS();
//	}
//	
//	public ArrayList<String>getListMaHoTenkh(){
//		return dataListkh.getMaVaTenKH();
//	}
//	public int getDiemThuong(String makh) {
//		return dataListkh.getDiemThuong(makh);
//	}
//	public void capNhatDiemThuong(String makh,int diemThuong) {
//		KhachHangDAO.getIntance().capNhatDiemThuong(makh, diemThuong);
//	}
//
//	@Override
//	public ArrayList<DTO_KhachHang> getList() {
//		// TODO Auto-generated method stub
//		return KhachHangDAO.getIntance().selectAll();
//	}
//
//	@Override
//	public void saveData(DTO_KhachHang t) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public DTO_KhachHang getByID(DTO_KhachHang t) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void inSert(DTO_KhachHang t) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void upDate(DTO_KhachHang t) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void delete(DTO_KhachHang t) {
//		// TODO Auto-generated method stub
//		
//	}
//}
package BUS;

import java.util.ArrayList;

import DAO.HoaDonDAO;
import DAO.KhachHangDAO;
import DTO.DTO_KhachHang;
import DTO.HoaDon;
import java.sql.Date;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class KhachHangBUS {

    private ArrayList<DTO_KhachHang> listkh = KhachHangDAO.getIntance().selectAll();

    public static KhachHangBUS getIntance() {
        return new KhachHangBUS();
    }

    public int getMaKHmoiNhat() {
		int maKHmoiNhat=0; 
		for (DTO_KhachHang khachHang : KhachHangDAO.getIntance().selectAll()) {
			String txtmaKH=khachHang.getMaKH();
			int maKH=Integer.parseInt(txtmaKH);
			if(maKH>maKHmoiNhat) {
				maKHmoiNhat=maKH;
			}
		}
		return maKHmoiNhat;
	}
    public void inSert(DTO_KhachHang t) {
    	KhachHangDAO.getIntance().them(t);
    }
    public ArrayList<DTO_KhachHang> getList() { 
        return listkh;
//        return KhachHangDAO.getIntance().selectAll();
    }
    
    public void capNhat (DTO_KhachHang kh) { //-----------------sửa
    	KhachHangDAO.getIntance().capNhap(kh);
    }
    
    public boolean delete(DTO_KhachHang kh) { //------------xóa
        if (kh.getMaKH().equals("")) {
            JOptionPane.showMessageDialog(null, "Chưa chọn khách hàng để xóa", "ERROR_MESSAGE", 1);
            return false;
        }
        if (KhachHangDAO.getIntance().xoa(kh) == 1) {
            JOptionPane.showMessageDialog(null, "Xóa thành công", "INFORMATION_MESSAGE", 2);
            return true;
        }

        JOptionPane.showMessageDialog(null, "Xóa thất bại", "ERROR_MESSAGE", 1);
        return false;
    }
    
    

    public ArrayList<String> getDsMaKh() { // lấy makh cho vào 1 danh sách
        ArrayList<String> listMaKH = new ArrayList<>();        
        for(DTO_KhachHang kh : getList()) {
            listMaKH.add(kh.getMaKH());
        }        
        return listMaKH;
    }
    
    public ArrayList<String> getDsDiaChi() { //Lấy địa chỉ kh ra cho vào 1 ds
        ArrayList<String> listDiaChi = new ArrayList<>();
        for(DTO_KhachHang kh : getList()) {
            listDiaChi.add(kh.getDiaChi());
        }
        return listDiaChi;
    }
    
    public DTO_KhachHang getMaKH(String maKH) { // tìm kiếm theo mã khách hàng
       DTO_KhachHang khachHang = null;       
       for(DTO_KhachHang kh : getList()) {
           if(kh.getMaKH().equalsIgnoreCase(maKH)) {
               khachHang = kh;              
           }           
       }       
       return khachHang;
    }
    
    public ArrayList<DTO_KhachHang> getDiaChiKH(String diaChi) {
        ArrayList<DTO_KhachHang> listKhachHang = new ArrayList<>();
        for(DTO_KhachHang kh : getList()) {
            if(kh.getDiaChi().equalsIgnoreCase(diaChi)) {
                listKhachHang.add(kh);
            }
        }
        return listKhachHang;
    }
    
   public ArrayList<DTO_KhachHang> getDsKH_ngayMuaGanNhat(java.util.Date tuNgay, java.util.Date denNgay) {
       return KhachHangDAO.getIntance().getDsKH_ngayMuaGanNhat(tuNgay, denNgay);
   }
   public ArrayList<String>getListMaHoTenkh(){
		return KhachHangDAO.getIntance().getMaVaTenKH();
	}
	public int getDiemThuong(String makh) {
		return KhachHangDAO.getIntance().getDiemThuong(makh);
	}
	public void capNhatDiemThuong(String makh,int diemThuong) {
		KhachHangDAO.getIntance().capNhatDiemThuong(makh, diemThuong);
	}
	public void capNhatNgayMuaGanNhat(DTO_KhachHang t) {
		KhachHangDAO.getIntance().capNhatNgayMuaGanNhat(t);
	}
	public String layTenBangMa(String makh) {
		String ten=null;
		for (DTO_KhachHang dto_KhachHang : getList()) {
			if(makh.equalsIgnoreCase(dto_KhachHang.getMaKH())) {
				ten=dto_KhachHang.getHoTen();
			}
		}
		return ten;
	}
}

