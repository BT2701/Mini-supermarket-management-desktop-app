package TEST;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JOptionPane;

import BUS.CTHoaDonBUS;
import BUS.HoaDonBUS;
import BUS.MatHangBUS;
import BUS.TaiKhoanBUS;
import DAO.CTHoaDonDAO;
import DAO.HoaDonDAO;
import DAO.KhachHangDAO;
import DAO.LoaiHangDAO;
import DAO.PhanQuyenDAO;
import DAO.PhieuKiemKeCTDAO;
import DAO.PhieuKiemKeDAO;
import DAO.PhieuNhapCTDAO;
import DAO.PhieuNhapDAO;
import DAO.PhieuXuatCTDAO;
import DAO.PhieuXuatDAO;
import DAO.MatHangDAO;
import DTO.CTHoaDon;
import DTO.DTO_KhachHang;
import DTO.MatHangDTO;
import DTO.DTO_TaiKhoan;
import DTO.HoaDon;
import DTO.PhanQuyen;
import DTO.PhieuKiemKe;
import DTO.PhieuKiemKeCT;
import DTO.PhieuNhap;
import DTO.PhieuNhapCT;
import DTO.PhieuXuat;
import DTO.PhieuXuatChiTiet;
import GUI.CheckLoi;
import GUI.DiaLogThemKhachHangGUI;
import GUI.DialogTaoTaiKhoanGUI;
import GUI.ThongBaoDialog;

public class testDao {
	public static void themPhanTuVaoMang(String []arr,String s) {
		arr=Arrays.copyOf(arr, arr.length+1);
		arr[arr.length-1]=s;
	}
	public static void main(String[] args) {
		//TEST HOADONDAO
//		Date date=new Date();
//		HoaDon hd=new HoaDon();
//		hd.setMaHD("HD01");
//		hd.setTongTienPhaiTra(2000000);
//		hd.setDiemThuong(25);
//		hd.setMucGia(35000);
//		HoaDonDAO.getIntance().capNhap(hd);
//		System.out.println(HoaDonDAO.getIntance().selectById(hd));
//		for(int i =0;i<HoaDonDAO.getIntance().selectAll().size();i++)
//		for (HoaDon string : HoaDonDAO.getIntance().selectAll()) {
//			System.out.println(string);
//		}
		
		
		//TEST CTHOADONDAO
//		CTHoaDon cthd=new CTHoaDon("HD01", "0086", 20);
//		CTHoaDonDAO.getIntance().them(cthd);
//		for (CTHoaDon string : CTHoaDonDAO.getIntance().selectAll()) {
//			System.out.println(string.toString());
//		}
//		System.out.println(CTHoaDonDAO.getIntance().selectById(cthd).toString());
//		CTHoaDonDAO.getIntance().capNhap(cthd);
//		CTHoaDonDAO.getIntance().xoa(cthd);
		
		
		//TEST PHANQUYENDAO
//		PhanQuyen pq=new PhanQuyen("chèn",1,1,9,1,1,2);
//		PhanQuyenDAO.getIntance().them(pq);
//		for (PhanQuyen a : PhanQuyenDAO.getIntance().selectAll()) {
//			System.out.println(a);
//		}
//		System.out.println(PhanQuyenDAO.getIntance().selectById(pq));
//		PhanQuyenDAO.getIntance().capNhap(pq);
//		PhanQuyenDAO.getIntance().xoa(pq);
		
		//TEST PHIEUKKDAO
//		PhieuKiemKe pkk=new PhieuKiemKe("KK1", "NV001", new Date());
//		PhieuKiemKeDAO.getIntance().them(pkk);
//		for (PhieuKiemKe string : PhieuKiemKeDAO.getIntance().selectAll()) {
//			System.out.println(string);
//		}
//		System.out.println(PhieuKiemKeDAO.getIntance().selectById(pkk));
//		PhieuKiemKeDAO.getIntance().capNhap(pkk);
//		PhieuKiemKeDAO.getIntance().xoa(pkk);
		
		
		//TEST PKKCTDAO
//		PhieuKiemKeCT pkkct=new PhieuKiemKeCT("KK1", "0011", 10);
//		PhieuKiemKeCTDAO.getIntance().them(pkkct);
//		for (PhieuKiemKeCT string : PhieuKiemKeCTDAO.getIntance().selectAll()) {
//			System.out.println(string);
//		}
//		System.out.println(PhieuKiemKeCTDAO.getIntance().selectById(pkkct));
//		PhieuKiemKeCTDAO.getIntance().capNhap(pkkct);
//		PhieuKiemKeCTDAO.getIntance().xoa(pkkct);
		
		
		//TEST PHIEUNHAPDAO
//		PhieuNhap pn=new PhieuNhap("PN2", "NV001", new Date());
//		PhieuNhapDAO.getIntance().them(pn);
//		for (PhieuNhap string : PhieuNhapDAO.getIntance().selectAll()) {
//			System.out.println(string);
//		}
//		System.out.println(PhieuNhapDAO.getIntance().selectById(pn));
//		PhieuNhapDAO.getIntance().capNhap(pn);
//		PhieuNhapDAO.getIntance().xoa(pn);
		
		//TEST PHIEUNHAPCTDAO
//		PhieuNhapCT pnct=new PhieuNhapCT("PN1", "0011", "NCC11123");
//		PhieuNhapCTDAO.getIntance().them(pnct);
//		for (PhieuNhapCT string : PhieuNhapCTDAO.getIntance().selectAll()) {
//			System.out.println(string);
//		}
//		System.out.println(PhieuNhapCTDAO.getIntance().selectById(pnct));
//		PhieuNhapCTDAO.getIntance().capNhap(pnct);
//		PhieuNhapCTDAO.getIntance().xoa(pnct);
		
		//TEST PHIEUXUATDAO
//		PhieuXuat px=new PhieuXuat("PX2", "NV002", new Date());
//		PhieuXuatDAO.getIntance().them(px);
//		for (PhieuXuat string : PhieuXuatDAO.getIntance().selectAll()) {
//			System.out.println(string);
//		}
//		System.out.println(PhieuXuatDAO.getIntance().selectById(px));
//		PhieuXuatDAO.getIntance().capNhap(px);
//		PhieuXuatDAO.getIntance().xoa(px);
		

		//TEST PHIEUXUATCTDAO
//		PhieuXuatChiTiet pxct=new PhieuXuatChiTiet("PX1", "0011", 30);
//		PhieuXuatCTDAO.getIntance().them(pxct);
//		for (PhieuXuatChiTiet string : PhieuXuatCTDAO.getIntance().selectAll()) {
//			System.out.println(string);
//		}
//		System.out.println(PhieuXuatCTDAO.getIntance().selectById(pxct));
//		PhieuXuatCTDAO.getIntance().capNhap(pxct);
//		PhieuXuatCTDAO.getIntance().xoa(pxct);
		
//		String []a= {};
//		System.out.println(a.length);
//		String []b= {"w"};
//		System.out.println(b.length);
//		for (String string : b) {
//			System.out.println(string);
//		}
//		b=new String[0];
//		System.out.println(b.length);
//		for (String string : b) {
//			System.out.println(string);
//		}
//		String []array= {};
//		for (String string : KhachHangDAO.getIntance().getMaVaTenKH()) {
//			themPhanTuVaoMang(array, string);
//		}
//		for (String string : array) {
//			System.out.println(string);
//		}
		
//		System.out.println(KhachHangDAO.getIntance().getDiemThuong("111101"));
//		for (String string : LoaiHangDAO.getIntance().selectByChungLoai("001")) {
//			System.out.println(string);
//		}
		
//		for (DTO_MatHang string : SanPhamDAO.getIntance().selectAll()) {
//			System.out.println(string);
//		}
//		for (DTO_MatHang string : SanPhamDAO.getIntance().selectByLoaiHang("LH0011")) {
//			System.out.println(string);
//		}
//		System.out.println(345/1000);
//		double x=2345;
//		double y=1000;
//		System.out.println();
//		CTHoaDon cthd=new CTHoaDon("HD3", "0012", 10, 250000, 2500000);
//		CTHoaDonBUS.getIntance().inSert(cthd);
//		CTHoaDonDAO.getIntance().them(cthd);
//		String kh="chọn khách hàng";
//		String []a=kh.split(" k");
//		System.out.println(a[0]);
//		Date date=new Date();
//		System.out.println(date.getTime());
//		System.out.println(date);
//		for (HoaDon string : HoaDonBUS.getIntance().getListByDate(date)) {
//			System.out.println(string);
//		}
//		for (CTHoaDon string : CTHoaDonBUS.getIntance().layDanhSachTheoMaHD("HD10")) {
//			System.out.println(string);
//		}
//		for (String string : CTHoaDonDAO.getIntance().layDanhSachSanPhamBanChay()) {
//			System.out.println(string);
//		}
		
//		for (String string : CTHoaDonBUS.getIntance().layDanhSachSanPhamBanChay()) {
//			System.out.println(string);
//		}
//		for (PhanQuyen string : PhanQuyenDAO.getIntance().selectAll()) {
//			System.out.println(string);
//		}
//		for (DTO_TaiKhoan string : TaiKhoanBUS.getInstance().getList()) {
//			System.out.println(string);
//		}
//		PhanQuyen p=new PhanQuyen();
//		p.setQuyen("Admin");
//		p=PhanQuyenDAO.getIntance().selectById(p);
//		System.out.println(p);
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		Date d1=new Date();
//		Date d2=new Date();
//		System.out.println(sdf.format(d1.getTime()));
//		System.out.println(sdf.format(d2.getTime()));
//		System.out.println(HoaDonDAO.getIntance().thongKeTheoKhoangThoiGian(d1, d2));
//		Date d1=new Date();
//		Date d2=new Date();
//		for (HoaDon string : HoaDonBUS.getIntance().layDsHoaDonTheoKhoangThoiGian(d1, d2)) {
//			System.out.println(string);
//		}
//		for (HoaDon string : HoaDonBUS.getIntance().layDsHoaDonTheoGia(1000000, 3000000)) {
//			System.out.println(string);
//		}
//		String tenQuyen = JOptionPane.showInputDialog("Nhập tên quyền");
//		System.out.println(tenQuyen);
//		String stringDate = "2023-05-03";
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        Date date=null;
//        try {
//        	date = format.parse(stringDate);
//            System.out.println(date);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		new DiaLogThemKhachHangGUI();
//		Date date=new Date();
//		String maKH="111101";
//		DTO_KhachHang a=new DTO_KhachHang();
//		a.setDateNgayMuaGanNhat(date);
//		a.setMaKH(maKH);
//		KhachHangDAO.getIntance().capNhatNgayMuaGanNhat(a);
//		new DialogTaoTaiKhoanGUI();
//		String soLuong="123456";
//		String sl="sdf2243";
//		if(CheckLoi.isInteger(sl)) {
//			new ThongBaoDialog("là số nguyên", ThongBaoDialog.SUCCESS_DIALOG);
//			return;
//		}
//		else
//			new ThongBaoDialog("không số nguyên", ThongBaoDialog.ERROR_DIALOG);
//		String s1="thịt bò";
//		String s2="thịt bò loại 2";
//		System.out.println(CheckLoi.similarity(s1, s2));
		MatHangDTO mh=new MatHangDTO("00413", "123", 1, 1, new Date(), new Date(), 0, 0, new Date(), 0, null, null, null);
		MatHangBUS.getInstance().add(mh);
		for (MatHangDTO m : MatHangBUS.getInstance().getList()) {
			System.out.println(m);
		}
		
		
	}
}
