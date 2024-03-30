package GUI;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
//import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import BUS.MatHangBUS;

public class BanHangEvent implements ActionListener,MouseListener,MouseMotionListener,ListSelectionListener{

	private BanHang banHang;
//	private GioHangGUI gioHang=new GioHangGUI();
	private Color oldColor=new Color(236, 240, 241);
	private Color hoverColor=new Color(192, 57, 43);
	
	private Color btnoldColor=new Color(52, 152, 219);
	private Color btnhoverColor=new Color(116, 185, 255);
	private Color pressColor=new Color(87, 101, 116);
	private DecimalFormat dcf = new DecimalFormat("###,###");
	
	//dữ liệu của giỏ hàng
	private String maSP=null;
	private String tenSP=null;
	private double giaban=0;
	private double tongtien=0;
	private int soLuongSP=1;
	public BanHangEvent(BanHang banHang) {
		this.banHang = banHang;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==banHang.getBtnCart()) {
			banHang.getGioHang().setVisible(true);
		}
		if(e.getSource()==banHang.getBtnBill()) {
			banHang.getCthd().setVisible(true);
		}
		
		//xử lý nút refresh
		if(e.getSource()==banHang.getDssp().getBtnChange()) {
			banHang.xuLySuKienRefreshBanHang();
		}
		
		//xử lý table sản phẩm bán hàng
		if(e.getSource()==banHang.getDssp().getDsSP()) {
			banHang.getCtsp().getBtnThemCart().setEnabled(true);
//			banHang.getCtsp().getBtnDelCart().setEnabled(true);
//			banHang.getCtsp().getBtnXuatHD().setEnabled(true);
			ChiTietSanPhamGUI.spnSoluong.setEnabled(true);
			
			int selectedRow=banHang.getDssp().getDsSP().getSelectedRow();
			String donGiaValue=(banHang.getDssp().getDsSP().getModel().getValueAt(selectedRow, 2)+"").replace(",", "");
			
			giaban=Double.parseDouble(donGiaValue);
			maSP="SP"+banHang.getDssp().getDsSP().getModel().getValueAt(selectedRow, 0);
			tenSP=banHang.getDssp().getDsSP().getModel().getValueAt(selectedRow, 1)+"";
//			soLuongSP=1;
			ImageIcon newImage;
			Image image;
			try {
				newImage = new ImageIcon("./src/IMG_SANPHAM/" + MatHangBUS.getInstance().getAnh(banHang.getDssp().getDsSP().getModel().getValueAt(selectedRow, 0).toString()));
				image = (newImage).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);

			} catch (NullPointerException E) {
				newImage = new ImageIcon("./src/IMG_SANPHAM/boloai1.jpg");
				image = (newImage).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
			}
			newImage = new ImageIcon(image);
			ChiTietSanPhamGUI.lbImage.setIcon(newImage);
			
			ChiTietSanPhamGUI.spnSoluong.setValue(1);
			ChiTietSanPhamGUI.tfMasp.setText(maSP);
			ChiTietSanPhamGUI.tfTensp.setText(tenSP);
			ChiTietSanPhamGUI.tfDongia.setText(dcf.format(giaban)+" VND");
		}
		
		
		if(e.getSource()==banHang.getCtsp().getBtnThemCart()) {
			banHang.getGioHang().xuLyThemVaoGioHang();
		}
		
		if((e.getSource()==GioHangGUI.btnDel)) {
			banHang.getGioHang().xuLyXoaSPGioHang();
		}
//		if(e.getSource()==GioHangGUI.btndungdiem) {
//			banHang.getGioHang().dungDiemThuong();
//		}
		
		if((e.getSource()==GioHangGUI.btnThanhToan)) {
			banHang.getGioHang().xuLyThanhToan();
			banHang.getDssp().delTableSanPham();
			banHang.getDssp().loadTableSP();
		}
		if(e.getSource()==banHang.getHdgui().getTbHoaDon()) {
			banHang.getHdgui().xuLySuKienTableHoaDon();
			banHang.getCthd().layDanhSachCTHDtheoMaHD(HoaDonGUI.maHDselected);
		}
		if(e.getSource()==HoaDonGUI.btnTimkiem) {
			banHang.getHdgui().xuLySuKienTimKiemHoaDonTheoNgay();
		}
		if(e.getSource()==HoaDonGUI.btnTimkiem1) {
			banHang.getHdgui().xuLySuKienTimKiemHoaDonTheoKhoangGia();
		}
		if(e.getSource()==banHang.getCthd().getTbHoaDonCT()) {
			banHang.getCthd().xuLySuKienTableCTHoaDon();
		}
		if(e.getSource()==banHang.getHdgui().getBtnChange()) {
			banHang.xuLySuKienRefreshHoaDon();
		}
		if(e.getSource()==HoaDonGUI.lbTimTheoPrince) {
			banHang.getHdgui().xuLyBtnSearchPrice();
		}
		if(e.getSource()==HoaDonGUI.lbTimTheoTime) {
			banHang.getHdgui().xuLyBtnSearchTime();
		}
//		if(e.getSource()==DiaLogThemKhachHangGUI.lbThemKH) {
//			DiaLogThemKhachHangGUI.xuLyThemKH();
//		}
		
		
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==banHang.getBtnCart()) {
			banHang.getBtnCart().setBackground(btnhoverColor);
		}
		if(e.getSource()==banHang.getBtnBill()) {
			banHang.getBtnBill().setBackground(btnhoverColor);
		}
		if(e.getSource()==banHang.getDssp().getBtnChange()) {
			banHang.getDssp().getBtnChange().setBackground(btnhoverColor);
		}
		if(e.getSource()==banHang.getHdgui().getBtnChange()) {
			banHang.getHdgui().getBtnChange().setBackground(btnhoverColor);
		}
//		if(e.getSource()==banHang.getCtsp().getBtnDelCart()) {
//			banHang.getCtsp().getBtnDelCart().setBackground(btnhoverColor);
//		}
		if(e.getSource()==banHang.getCtsp().getBtnThemCart()) {
			banHang.getCtsp().getBtnThemCart().setBackground(btnhoverColor);
		}
//		if(e.getSource()==banHang.getCtsp().getBtnXuatHD()) {
//			banHang.getCtsp().getBtnXuatHD().setBackground(btnhoverColor);
//		}
		if((e.getSource()==GioHangGUI.btnDel)) {
			GioHangGUI.btnDel.setBackground(btnhoverColor);
		}
		if((e.getSource()==GioHangGUI.btnThanhToan)) {
			GioHangGUI.btnThanhToan.setBackground(btnhoverColor);
		}
		if(e.getSource()==HoaDonGUI.btnTimkiem) {
			HoaDonGUI.btnTimkiem.setBackground(btnhoverColor);
		}
//		if(e.getSource()==GioHangGUI.btndungdiem) {
//			GioHangGUI.btndungdiem.setBackground(btnhoverColor);
//		}
		if(e.getSource()==HoaDonGUI.lbTimTheoPrince) {
			HoaDonGUI.lbTimTheoPrince.setBackground(btnhoverColor);
		}
		if(e.getSource()==HoaDonGUI.lbTimTheoTime) {
			HoaDonGUI.lbTimTheoTime.setBackground(btnhoverColor);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==banHang.getBtnCart()) {
			banHang.getBtnCart().setBackground(oldColor);
		}
		if(e.getSource()==banHang.getBtnBill()) {
			banHang.getBtnBill().setBackground(oldColor);
		}
		if(e.getSource()==banHang.getDssp().getBtnChange()) {
			banHang.getDssp().getBtnChange().setBackground(oldColor);
		}
		if(e.getSource()==banHang.getHdgui().getBtnChange()) {
			banHang.getHdgui().getBtnChange().setBackground(oldColor);
		}
//		if(e.getSource()==banHang.getCtsp().getBtnDelCart()) {
//			banHang.getCtsp().getBtnDelCart().setBackground(btnoldColor);
//		}
		if(e.getSource()==banHang.getCtsp().getBtnThemCart()) {
			banHang.getCtsp().getBtnThemCart().setBackground(btnoldColor);
		}
//		if(e.getSource()==banHang.getCtsp().getBtnXuatHD()) {
//			banHang.getCtsp().getBtnXuatHD().setBackground(btnoldColor);
//		}
		if((e.getSource()==GioHangGUI.btnDel)) {
			GioHangGUI.btnDel.setBackground(btnoldColor);
		}
		if((e.getSource()==GioHangGUI.btnThanhToan)) {
			GioHangGUI.btnThanhToan.setBackground(btnoldColor);
			ThongKeChiTiet.getInstance().xuLyHienThiSanPhamBanChay();
		}
		if(e.getSource()==HoaDonGUI.btnTimkiem) {
			HoaDonGUI.btnTimkiem.setBackground(btnoldColor);
		}
//		if(e.getSource()==GioHangGUI.btndungdiem) {
//			GioHangGUI.btndungdiem.setBackground(btnoldColor);
//		}
		if(e.getSource()==HoaDonGUI.lbTimTheoPrince) {
			HoaDonGUI.lbTimTheoPrince.setBackground(btnoldColor);
		}
		if(e.getSource()==HoaDonGUI.lbTimTheoTime) {
			HoaDonGUI.lbTimTheoTime.setBackground(btnoldColor);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==banHang.getBtnbanHang()) {
			banHang.SelectTaskBanHang();
		}
		if(e.getSource()==banHang.getBtnhoaDon()) {
			banHang.SelectTaskHoaDon();
		}
		if (e.getSource()==GioHangGUI.cbthongtinkh) {
			if(GioHangGUI.cbthongtinkh.getSelectedIndex()== (GioHangGUI.cbthongtinkh.getItemCount()-1)) {
				new DiaLogThemKhachHangGUI();
				banHang.getGioHang().getThongTinKhachHang();
			}
//			else {
//				banHang.getGioHang().getTfdungdiem().setEnabled(true);
//				String maVaTen=GioHangGUI.cbthongtinkh.getSelectedItem().toString();
//				banHang.getGioHang().setDiemThuongView(maVaTen);
//			}
		}
		if (e.getSource()==DanhSachSPGUI.cbchungloai) {
			if(DanhSachSPGUI.cbchungloai.getSelectedIndex()==0) {
				DanhSachSPGUI.cbloaihang.setEnabled(false);
				banHang.getDssp().delTableSanPham();
				banHang.getDssp().getDSSPALL();
				
				banHang.getCtsp().getBtnThemCart().setEnabled(false);
//				banHang.getCtsp().getBtnDelCart().setEnabled(false);
//				banHang.getCtsp().getBtnXuatHD().setEnabled(false);
				
				ChiTietSanPhamGUI.tfDongia.setText(null);
				ChiTietSanPhamGUI.tfMasp.setText(null);
				ChiTietSanPhamGUI.tfTensp.setText(null);
				
//				soLuongSP=0;
				ChiTietSanPhamGUI.spnSoluong.setValue(0);
				ChiTietSanPhamGUI.spnSoluong.setEnabled(false);
			}
			else {
				String maVaTen=DanhSachSPGUI.cbchungloai.getSelectedItem().toString();
				banHang.getDssp().getDSloaiHangView(maVaTen);
			}
		}
		if (e.getSource()==DanhSachSPGUI.cbloaihang) {
			if(DanhSachSPGUI.cbloaihang.getSelectedIndex()==0) {
				banHang.getDssp().delTableSanPham();
				banHang.getDssp().getDSSPALL();
				
				banHang.getCtsp().getBtnThemCart().setEnabled(false);
//				banHang.getCtsp().getBtnDelCart().setEnabled(false);
//				banHang.getCtsp().getBtnXuatHD().setEnabled(false);
				
				ChiTietSanPhamGUI.tfDongia.setText(null);
				ChiTietSanPhamGUI.tfMasp.setText(null);
				ChiTietSanPhamGUI.tfTensp.setText(null);
				
//				soLuongSP=0;
				ChiTietSanPhamGUI.spnSoluong.setValue(0);
				ChiTietSanPhamGUI.spnSoluong.setEnabled(false);
			}
			else {
				String maVaTen=DanhSachSPGUI.cbloaihang.getSelectedItem().toString();
				banHang.getDssp().delTableSanPham();
				banHang.getDssp().getDSspByMaLH(maVaTen);
			}
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}


}
