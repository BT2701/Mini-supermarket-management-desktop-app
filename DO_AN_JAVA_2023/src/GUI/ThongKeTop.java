package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.border.Border;

import BUS.CTHoaDonBUS;
import BUS.ChungLoaiBUS;
import BUS.HoaDonBUS;
import BUS.KhachHangBUS;
import BUS.NhanVienBUS;
import BUS.PhieuKiemKeBUS;
import BUS.PhieuKiemKeCTBUS;
import BUS.MatHangBUS;
import DTO.CTHoaDon;
import DTO.HoaDon;
import DTO.PhieuKiemKe;
import DTO.PhieuKiemKeCT;

public class ThongKeTop extends JPanel {
	private JLabel title;
	private JLabel lbMatHangCount;
	private JLabel lbKhachHangCount;
	private JLabel lbNhanVienCount;
	private JLabel lbTongDoanhThu;
	private JButton btnView;
	public static JLabel lbLapPhieukk;
	public static JComboBox<String> cblistPKK;
	public static JLabel lbThongKeTheoNV;
	public static JLabel lbThongKeTheoKhoangThoiGian;
	public static JLabel btnRefresh;
	
//	public static JComboBox<String> cbListNV;
//	private SpinnerDateModel dateModel;
//	public static JSpinner spnThongKeTheoNgay;
	private String[] listPkk = { "Chọn phiếu kk" };
//	private String[] listNV= {"Chọn nhân viên"};
	private Border lineBorder = BorderFactory.createLineBorder(Color.black, 1);
	private Font font = new Font("Tahoma", Font.BOLD, 30);
	private Font fontItems = new Font("Tahoma", Font.BOLD, 15);
//	JComboBox<Integer> cmbNam;
	private int maPKK = PhieuKiemKeBUS.getInstance().getMaPKKmoiNhat();
	private Color btnoldColor = new Color(52, 152, 219);
	private PhieuKiemKeCTGUI phieuKiemKeCT;
	private SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	private DecimalFormat dcf = new DecimalFormat("###,###");

	public ThongKeTop() {
		initComponent();
		this.setVisible(true);
	}

	public void initComponent() {
		this.setBounds(0, 0, 1100, 500);
		this.setLayout(null);
		this.setBackground(Color.white);
		title = new JLabel("THỐNG KÊ TỔNG QUÁT");
		title.setBounds(375, 10, 350, 30);
		title.setFont(new Font("Tahoma", Font.BOLD, 28));

		JLabel lblBackgroundThucDon, lblBackgroundKhachHang, lblBackgroundNhanVien, lblBackgroundDoanhThu;
		lblBackgroundThucDon = new JLabel(new ImageIcon("./src/IMG/lb-mathang1.png"));
		lblBackgroundKhachHang = new JLabel(new ImageIcon("./src/IMG/lb-khachhang.png"));
		lblBackgroundNhanVien = new JLabel(new ImageIcon("./src/IMG/lb-nhanvien.png"));
		lblBackgroundDoanhThu = new JLabel(new ImageIcon("./src/IMG/lb-doanhthu.png"));

		lblBackgroundThucDon.setBounds(125, 60, 400, 170);
		lblBackgroundKhachHang.setBounds(575, 60, 400, 170);
		lblBackgroundNhanVien.setBounds(125, 260, 400, 170);
		lblBackgroundDoanhThu.setBounds(575, 260, 400, 170);

		lbMatHangCount = new JLabel("",JLabel.CENTER);
		lbMatHangCount.setBounds(125, 75, 263, 56);
		lbMatHangCount.setFont(font);
		lbMatHangCount.setForeground(Color.black);

		lbKhachHangCount = new JLabel("",JLabel.CENTER);
		lbKhachHangCount.setBounds(575, 75, 263, 56);
		lbKhachHangCount.setFont(font);
		lbKhachHangCount.setForeground(Color.black);

		lbNhanVienCount = new JLabel("",JLabel.CENTER);
		lbNhanVienCount.setBounds(125, 270, 263, 56);
		lbNhanVienCount.setFont(font);
		lbNhanVienCount.setForeground(Color.black);

		lbTongDoanhThu = new JLabel("",JLabel.CENTER);
		lbTongDoanhThu.setBounds(575, 270, 263, 56);
		lbTongDoanhThu.setFont(font);
		lbTongDoanhThu.setForeground(Color.black);
		
		layDuLieuThongKe();

		btnView = new JButton(new ImageIcon("./src/IMG/icons8_view_40px.png"));
		btnView.setBounds(10, 10, 45, 45);
		btnView.setToolTipText("Xem chi tiết");
		btnView.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lbLapPhieukk = new JLabel("Lập phiếu kiểm kê",JLabel.CENTER);
		lbLapPhieukk.setBounds(600, 445, 180, 30);
		lbLapPhieukk.setFont(fontItems);
		lbLapPhieukk.setBackground(btnoldColor);
		lbLapPhieukk.setOpaque(true);

		cblistPKK = new JComboBox<String>();
		getDSPhieuKK();
		cblistPKK.setBounds(800, 445, 180, 30);
		cblistPKK.setFont(fontItems);
		
		lbThongKeTheoNV=new JLabel("Thống kê theo NV",JLabel.CENTER);
		lbThongKeTheoNV.setFont(fontItems);
		lbThongKeTheoNV.setBounds(120, 445, 180, 30);
		lbThongKeTheoNV.setOpaque(true);
		lbThongKeTheoNV.setBackground(btnoldColor);
		
		lbThongKeTheoKhoangThoiGian=new JLabel("Thống kê theo ngày",JLabel.CENTER);
		lbThongKeTheoKhoangThoiGian.setFont(fontItems);
		lbThongKeTheoKhoangThoiGian.setBounds(320, 445, 180, 30);
		lbThongKeTheoKhoangThoiGian.setOpaque(true);
		lbThongKeTheoKhoangThoiGian.setBackground(btnoldColor);
		
		btnRefresh=new JLabel(new ImageIcon("./src/IMG/Refresh-icon.png"));
		btnRefresh.setBounds(730, 10, 30, 30);
		btnRefresh.setOpaque(true);
		btnRefresh.setBackground(Color.white);
		
		
		
		
		phieuKiemKeCT=new PhieuKiemKeCTGUI();

		this.add(btnRefresh);
		this.add(lbThongKeTheoKhoangThoiGian);
		this.add(lbThongKeTheoNV);
		this.add(cblistPKK);
		this.add(lbLapPhieukk);
		this.add(btnView);
		this.add(title);
		this.add(lbMatHangCount);
		this.add(lbKhachHangCount);
		this.add(lbNhanVienCount);
		this.add(lbTongDoanhThu);
		this.add(lblBackgroundThucDon);
		this.add(lblBackgroundKhachHang);
		this.add(lblBackgroundNhanVien);
		this.add(lblBackgroundDoanhThu);

	}

	public String layMa(String maVaTen) {
		String a[]=maVaTen.split(" - ");
		return a[0];
	}
	public void lapPhieuKiemKe() {
		maPKK++;
		String txtmaPKK = "KK" + maPKK;
	
		String maNV = layMa(ChiTietSanPhamGUI.tfNv.getText()); 
		// truyền dữ liệu xuống database
		PhieuKiemKe pkk = new PhieuKiemKe(txtmaPKK, maNV, new Date());
		PhieuKiemKeBUS.getInstance().inSert(pkk);

		for (int i = 0; i < DanhSachSPGUI.dsSP.getRowCount(); i++) {

			String maMH = DanhSachSPGUI.dsSP.getValueAt(i, 0) + "";

			String txtsoLuong = DanhSachSPGUI.dsSP.getValueAt(i, 3) + "";
			int soLuong = Integer.parseInt(txtsoLuong);

			PhieuKiemKeCT pkkct = new PhieuKiemKeCT(txtmaPKK, maMH, soLuong);
			PhieuKiemKeCTBUS.getInstance().inSert(pkkct);
		}
		new ThongBaoDialog("Đã lập phiếu kiểm kê", ThongBaoDialog.SUCCESS_DIALOG);
		getDSPhieuKK();

	}

	public void themPhanTuVaoMangPKK(String s) {
		int l=listPkk.length;
		listPkk=Arrays.copyOf(listPkk, l+1);
		listPkk[l]=s;
	}
	public void getDSPhieuKK() {

		for (String maPKK : PhieuKiemKeBUS.getInstance().layDanhSachMaPKK()) {
			themPhanTuVaoMangPKK(maPKK);
		}
		DefaultComboBoxModel<String> cbmodel = new DefaultComboBoxModel<>(listPkk);
		cblistPKK.setModel(cbmodel);
		listPkk = new String[0];
		themPhanTuVaoMangPKK("Chọn phiếu KK");
	}
	
	public void xuLySuKienXuatPhieuKKtheoMa() {
		if(cblistPKK.getSelectedIndex()==0) {
			phieuKiemKeCT.setVisible(false);
		}
		else {
			
			String maPKK=cblistPKK.getSelectedItem().toString();
			PhieuKiemKe pkk=PhieuKiemKeBUS.getInstance().layPhieuKKtheoMa(maPKK);
			String maNV=pkk.getMaNV();
			String tenNV=NhanVienBUS.getIntance().layTenNVtheoMA(maNV);
			String thoiDiemLap=sdf.format(pkk.getDate());
			phieuKiemKeCT.getTfmaNV().setText(maNV);
			phieuKiemKeCT.getTfMaPKK().setText(maPKK);
			phieuKiemKeCT.getTfTenNV().setText(tenNV);
			phieuKiemKeCT.getTfThoiDiemLap().setText(thoiDiemLap);
			phieuKiemKeCT.layDanhSachCTHDtheoMapkk(maPKK);
			
			phieuKiemKeCT.setVisible(true);
		}
	}
	public void layDuLieuThongKe() {
		lbMatHangCount.setText(MatHangBUS.getInstance().getListSanPham().size()+"");
		lbKhachHangCount.setText(KhachHangBUS.getIntance().getList().size()+"");
		lbNhanVienCount.setText(NhanVienBUS.getIntance().getList().size()+"");
		lbTongDoanhThu.setText(dcf.format(HoaDonBUS.getIntance().getTongDoanhThu())+" VND");
		
	}
	public void xuLySuKienThongKeTheoNV() {
		ThongKeDown.tittle.setVisible(false);
		ThongKeDown.cbListNV.setVisible(true);
		ThongKeDown.spnDenNgay.setVisible(false);
		ThongKeDown.spnTuNgay.setVisible(false);
	}
	public void xuLySuKienThongKeTheoKhoangTG() {
		ThongKeDown.tittle.setVisible(false);
		ThongKeDown.cbListNV.setVisible(false);
		ThongKeDown.spnDenNgay.setVisible(true);
		ThongKeDown.spnTuNgay.setVisible(true);
	}
	
	public JLabel getTitle() {
		return title;
	}

	public void setTitle(JLabel title) {
		this.title = title;
	}

	public JLabel getSlMon() {
		return lbMatHangCount;
	}

	public void setSlMon(JLabel slMon) {
		this.lbMatHangCount = slMon;
	}

	public JLabel getSlKh() {
		return lbKhachHangCount;
	}

	public void setSlKh(JLabel slKh) {
		this.lbKhachHangCount = slKh;
	}

	public JLabel getSlNv() {
		return lbNhanVienCount;
	}

	public void setSlNv(JLabel slNv) {
		this.lbNhanVienCount = slNv;
	}

	public JLabel getTongDoanhThu() {
		return lbTongDoanhThu;
	}

	public void setTongDoanhThu(JLabel tongDoanhThu) {
		this.lbTongDoanhThu = tongDoanhThu;
	}


	public JButton getBtnView() {
		return btnView;
	}

	public void setBtnView(JButton btnView) {
		this.btnView = btnView;
	}

	public Border getLineBorder() {
		return lineBorder;
	}

	public void setLineBorder(Border lineBorder) {
		this.lineBorder = lineBorder;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}
	
}
