package BUS;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import DAO.HoaDonDAO;
import DTO.HoaDon;

public class HoaDonBUS implements BusInterface<HoaDon>{
	private SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	public static HoaDonBUS getIntance() {
		return new HoaDonBUS();
	}
	private ArrayList<HoaDon> listHD= HoaDonDAO.getIntance().selectAll();
	
	@Override
	public ArrayList<HoaDon> getList() {
        return HoaDonDAO.getIntance().selectAll();
	}
	public ArrayList<HoaDon> getlistdata(){
		return listHD;
	}
	
	public ArrayList<HoaDon> getListByDate(Date date){
		HoaDon hd=new HoaDon();
		hd.setDate(date);
		String txtDate=sdf.format(hd.getDate());
		ArrayList<HoaDon> listHD=new ArrayList<>();
		for(int i=0;i<getList().size();i++) {
			if((sdf.format(getList().get(i).getDate())).equalsIgnoreCase(txtDate)) {
				listHD.add(getList().get(i));
			}
		}
		return listHD;
	}

	@Override
	public void saveData(HoaDon t) {
		// TODO Auto-generated method stub
		HoaDonDAO.getIntance().them(t);
		
	}

	@Override
	public HoaDon getByID(HoaDon t) {
		// TODO Auto-generated method stub
		return HoaDonDAO.getIntance().selectById(t);
	}

	@Override
	public void inSert(HoaDon t) {
		HoaDonDAO.getIntance().them(t);
		
	}

	@Override
	public void upDate(HoaDon t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(HoaDon t) {
		// TODO Auto-generated method stub
		
	}
	public int getMaHDmoiNhat() {
		int maHDmoiNhat=0; 
		for (HoaDon hoaDon : getList()) {
			String txtmaHD=hoaDon.getMaHD();
			txtmaHD=txtmaHD.replace("HD", "");
			int maHD=Integer.parseInt(txtmaHD);
			if(maHD>maHDmoiNhat) {
				maHDmoiNhat=maHD;
			}
		}
		return maHDmoiNhat;
	}
	public double getTongDoanhThu() {
		double tongDoanhThu=0;
		for (HoaDon hoaDon : getList()) {
			tongDoanhThu+=hoaDon.getTongTienPhaiTra();
		}
		return tongDoanhThu;
	}
	
	public double getTongDoanhThuTheoNgay(Date date) {
		double tongDoanhThuTheoNgay=0;
		for (HoaDon hoaDon : getList()) {
			if(sdf.format(hoaDon.getDate()).equalsIgnoreCase(sdf.format(date))) {
				tongDoanhThuTheoNgay+=hoaDon.getTongTienPhaiTra();
			}
		}
		return tongDoanhThuTheoNgay;
	}
	
	public double getTongDoanhThuTheoNV(String maNV) {
		double tongDoanhThuTheoNV=0;
		for (HoaDon hoaDon : getList()) {
			if(hoaDon.getMaNV().equalsIgnoreCase(maNV)) {
				tongDoanhThuTheoNV+=hoaDon.getTongTienPhaiTra();
			}
		}
		return tongDoanhThuTheoNV;
	}
	
	public ArrayList<String> getDsMaHoaDonTheoNV(String maNV){
		ArrayList<String> listMahd=new ArrayList<>();
		for (HoaDon hoaDon : getList()) {
			if(hoaDon.getMaNV().equalsIgnoreCase(maNV)) {
				String maHD=hoaDon.getMaHD();
				listMahd.add(maHD);
			}
		}
		return listMahd;
	}
	
	public ArrayList<String> layMaHoaDonTheoKhoangThoiGian(Date tuNgay, Date denNgay){
		
		return HoaDonDAO.getIntance().layMaHoaDonTheoKhoangThoiGian(tuNgay, denNgay);
	}
	public double layDoanhThuTheoNgayChart(int year,int month,int day){
		double doanhThu=0;
		String ngay=day+"";
		String thang=month+"";
		if(day<10) {
			ngay="0"+day;
		}
		else {
			ngay=day+"";
		}
		if(month<10) {
			thang="0"+month;
		}
		else {
			thang=month+"";
		}
		String ngayThangNam=ngay+"/"+thang+"/"+year;
		for (HoaDon hoaDon : getList()) {
			if(sdf.format(hoaDon.getDate()).equalsIgnoreCase(ngayThangNam)) {
				doanhThu+=hoaDon.getTongTienPhaiTra();
			}
		}
		
		
		return doanhThu;
	}
	
	public double thongKeTheoKhoangThoiGian(Date tuNgay,Date denNgay) {
		return HoaDonDAO.getIntance().thongKeTheoKhoangThoiGian(tuNgay, denNgay);
	}
	
	public ArrayList<HoaDon> layDsHoaDonTheoKhoangThoiGian(Date tuNgay, Date denNgay){
		ArrayList<HoaDon> listhd=new ArrayList<>();
		for (String maHD : HoaDonDAO.getIntance().layMaHoaDonTheoKhoangThoiGian(tuNgay, denNgay)) {
			for (HoaDon hoaDon : getList()) {
				if(hoaDon.getMaHD().equalsIgnoreCase(maHD)) {
					listhd.add(hoaDon);
				}
			}
		}
		return listhd;
	}
	public ArrayList<HoaDon> layDsHoaDonTheoGia(double giaTu,double denGia){
		return HoaDonDAO.getIntance().layDanhSachHoaDonTheoGia(giaTu, denGia);
	}
	public void thayDoiTrangThai(String maHD,int trangThai) {
		HoaDonDAO.getIntance().thayDoiTrangThai(maHD, trangThai);
	}
	
}
