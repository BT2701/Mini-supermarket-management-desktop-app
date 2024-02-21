
package BUS;

import DAO.NhanVienDAO;
import DTO.DTO_NhanVien;
import DTO.HoaDon;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class NhanVienBUS {
	private NhanVienDAO dataListNV = new NhanVienDAO();
	private ArrayList<DTO_NhanVien> listNV = null;

	public ArrayList<DTO_NhanVien> getList() {
//        listNV = dataListNV.selectAll();
//        return listNV;
		return NhanVienDAO.getIntance().selectAll();

	}
	public void insert(DTO_NhanVien t) {
		NhanVienDAO.getIntance().them(t);
	}
	public void delete(DTO_NhanVien t) {
		NhanVienDAO.getIntance().xoa(t);
	}
	public int getMaNVmoiNhat() {
		int maHDmoiNhat=0; 
		for (DTO_NhanVien nv : getList()) {
			String txtmaNV=nv.getMaNV();
			txtmaNV=txtmaNV.replace("NV", "");
			int maHD=Integer.parseInt(txtmaNV);
			if(maHD>maHDmoiNhat) {
				maHDmoiNhat=maHD;
			}
		}
		return maHDmoiNhat;
	}

	public static NhanVienBUS getIntance() {
		return new NhanVienBUS();
	}

	public void capNhat(DTO_NhanVien nv) { // -----------------sửa
		dataListNV.capNhap(nv);
	}

//	public boolean delete(DTO_NhanVien nv) { // ------------xóa
//		if (nv.getMaNV().equals("")) {
//			JOptionPane.showMessageDialog(null, "Chưa chọn khách hàng để xóa", "ERROR_MESSAGE", 1);
//			return false;
//		}
//		if (dataListNV.xoa(nv) == 1) {
//			JOptionPane.showMessageDialog(null, "Xóa thành công", "INFORMATION_MESSAGE", 2);
//			return true;
//		}
//
//		JOptionPane.showMessageDialog(null, "Xóa thất bại", "ERROR_MESSAGE", 1);
//		return false;
//	}

	public ArrayList<String> getDsMaNV() { // lấy manv cho vào 1 danh sách
		ArrayList<String> listMaNV = new ArrayList<>();
		for (DTO_NhanVien nv : getList()) {
			listMaNV.add(nv.getMaNV());
		}
		return listMaNV;
	}

//    public ArrayList<String> getDsGioiTinh() { // lấy giới tính cho vào 1 danh sách
//        ArrayList<String> GioiTinh = new ArrayList<>();        
//        for(DTO_NhanVien nv : getList()) {
//            GioiTinh.add(nv.getGioiTinh());
//        }        
//        return GioiTinh;
//    }

	public ArrayList<String> getDsDiaChi() { // Lấy địa chỉ nv ra cho vào 1 ds
		ArrayList<String> listDiaChi = new ArrayList<>();
		for (DTO_NhanVien nv : getList()) {
			listDiaChi.add(nv.getDiaChi());
		}
		return listDiaChi;
	}

	public DTO_NhanVien getMaNV(String maNV) { // tìm kiếm theo mã nhân viên
		DTO_NhanVien nhanVien = null;
		for (DTO_NhanVien nv : getList()) {
			if (nv.getMaNV().equalsIgnoreCase(maNV)) {
				nhanVien = nv;
			}
		}
		return nhanVien;
	}

	public ArrayList<DTO_NhanVien> getDiaChiNV(String diaChi) {
		ArrayList<DTO_NhanVien> listNhanVien = new ArrayList<>();
		for (DTO_NhanVien nv : getList()) {
			if (nv.getDiaChi().equalsIgnoreCase(diaChi)) {
				listNhanVien.add(nv);
			}
		}
		return listNhanVien;
	}

	public ArrayList<DTO_NhanVien> getGioiTinhNV(String gioiTinh) {
		ArrayList<DTO_NhanVien> listNhanVien = new ArrayList<>();
		for (DTO_NhanVien nv : getList()) {
			if (nv.getGioiTinh().equalsIgnoreCase(gioiTinh)) {
				listNhanVien.add(nv);
			}
		}
		return listNhanVien;
	}

	public ArrayList<DTO_NhanVien> getDsNV_ngayVaoLam(java.util.Date tuNgay, java.util.Date denNgay) {
		return NhanVienDAO.getIntance().getDsNV_ngayVaoLam(tuNgay, denNgay);
	}

	public String layTenNVtheoMA(String maNV) {
		String tenNV = "";
		for (DTO_NhanVien tnv : getList()) {
			if (tnv.getMaNV().equalsIgnoreCase(maNV)) {
				tenNV = tnv.getHoTen();
			}
		}
		return tenNV;
	}

	public ArrayList<String> getListMaVaTen() {
		ArrayList<String> listMaVaTen = new ArrayList<>();
		for (DTO_NhanVien nhanVien : getList()) {
			String maVaTen = nhanVien.getMaNV() + " - " + nhanVien.getHoTen();
			listMaVaTen.add(maVaTen);
		}
		return listMaVaTen;
	}
}
