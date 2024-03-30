package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import BUS.ChungLoaiBUS;
import BUS.DonViBUS;
import BUS.LoaiHangBUS;
import BUS.MatHangBUS;
import DTO.ChungLoai;
import DTO.MatHangDTO;
import DTO.DonViDTO;
import DTO.LoaiHangDTO;

public class DanhSachSPGUI extends JPanel{
	public static JTable dsSP;
	private JLabel dsSPName;
	private JLabel btnChange;
	private JScrollPane scrDSSP;
	private DefaultTableModel modelDssp;
	private String maSP,tenSP,donViTinh,hanSuDung;
	private double donGia;
	private int slTon;
	public static JComboBox<String>cbchungloai;
	public static JComboBox<String>cbloaihang;
	private String []collum= {"Mã SP","Tên SP","Đơn giá","Còn lại","Đơn vị tính","Hạn sử dụng"};
	private Font font = new Font("Tahoma", Font.BOLD, 20);
	private Font fontItems = new Font("Tahoma",0, 15);
//	private Color backgroundcolor=new Color(255, 204, 204);
	private String []listChungLoai= {"Chủng loại"};
	private String []listLoaihang= {"Loại hàng"};
	private String []TTSP=new String[0];
	private MatHangBUS sanPhamBus;
	private DonViBUS donViBUS;
	private DecimalFormat dcf = new DecimalFormat("###,###");
	private SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	public DanhSachSPGUI() {
		initComponent();
	}
	public void initComponent() {
		this.setLayout(null);
//		this.setBackground(backgroundcolor);
		this.setBounds(0,40,700,660);
//		this.setBackground(Color.red);
		
		//khoi tao tam du lieu de xuat len bang
		String mean[][]= null;
		dsSPName=new JLabel("Danh sách sản phẩm");
		dsSPName.setFont(font);
		dsSPName.setBounds(200, 10, 300, 50);
		
		btnChange=new JLabel(new ImageIcon("./src/IMG/Refresh-icon.png"));
		btnChange.setBounds(500, 20, 30, 30);
		btnChange.setOpaque(true);
		
		modelDssp=new DefaultTableModel(mean, collum);
		
		dsSP=new JTable(modelDssp);
		dsSP.setFont(new Font("Tahoma", Font.BOLD, 15));
		dsSP.getTableHeader().setForeground(Color.white);
		dsSP.getTableHeader().setBackground(new Color(52, 152, 219));
		dsSP.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));
		dsSP.getTableHeader().setPreferredSize(new Dimension(700,30));
		dsSP.setRowHeight(25);
		dsSP.getColumnModel().getColumn(0).setPreferredWidth(20);
		dsSP.getColumnModel().getColumn(1).setPreferredWidth(200);
		dsSP.getColumnModel().getColumn(2).setPreferredWidth(20);
		dsSP.getColumnModel().getColumn(3).setPreferredWidth(20);
		dsSP.getColumnModel().getColumn(4).setPreferredWidth(30);
		dsSP.getColumnModel().getColumn(5).setPreferredWidth(50);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		dsSP.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
//		dsSP.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		dsSP.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		dsSP.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		dsSP.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		
		
		sanPhamBus=new MatHangBUS();
		donViBUS=new DonViBUS();
		getDSSPALL();
		
		scrDSSP=new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrDSSP.setBounds(0,110,700,530);
		scrDSSP.setViewportView(dsSP);
		
		
		cbchungloai=new JComboBox<String>();
		getDSchungLoai();
		cbchungloai.setFont(fontItems);
		cbchungloai.setBounds(125, 70, 200, 30);
		
//		getDSloaiHang();
		cbloaihang=new JComboBox<String>(listLoaihang);
		cbloaihang.setFont(fontItems);
		cbloaihang.setBounds(375, 70, 200, 30);
		cbloaihang.setEnabled(false);
		
		this.add(dsSPName);
		this.add(btnChange);
		this.add(cbchungloai);
		this.add(cbloaihang);
		this.add(scrDSSP);
		
	}
	public void themPhanTuVaoMangChungLoai(String s) {
		int l=listChungLoai.length;
		listChungLoai=Arrays.copyOf(listChungLoai, l+1);
		listChungLoai[l]=s;
	}
	public void themPhanTuVaoMangLoaiHang(String s) {
		int l=listLoaihang.length;
		listLoaihang=Arrays.copyOf(listLoaihang, l+1);
		listLoaihang[l]=s;
	}
	public void themPhanTuVaoMangTTSP(String s) {
		int l=TTSP.length;
		TTSP=Arrays.copyOf(TTSP, l+1);
		TTSP[l]=s;
	}
	public void getDSchungLoai() {
		
		for (String chungloai : ChungLoaiBUS.getIntance().getListChungloai()) {
			themPhanTuVaoMangChungLoai(chungloai);
		}
		DefaultComboBoxModel<String>cbmodel=new DefaultComboBoxModel<>(listChungLoai);
		cbchungloai.setModel(cbmodel);
		listChungLoai=new String[0];
		themPhanTuVaoMangChungLoai("Chủng loại");
//		listChungLoai=new String[0];
	}
	public void getDSloaiHangView(String maVaTen) {
		cbloaihang.setEnabled(true);
		for (String loaihang : LoaiHangBUS.getIntance().getListByChungLoai(layMa(maVaTen))) {
			themPhanTuVaoMangLoaiHang(loaihang);
		}
		DefaultComboBoxModel<String>cbmodel=new DefaultComboBoxModel<>(listLoaihang);
		cbloaihang.setModel(cbmodel);
		listLoaihang= new String[0];
		themPhanTuVaoMangLoaiHang("Loại hàng");
	}
	public String layMa(String maVaTen) {
		String []s=maVaTen.split(" - ");
		return s[0];
	}
	public void getDSSPALL() {
//		"Mã SP","Tên SP","Đơn giá","Còn lại","Đơn vị tính","Hạn sử dụng"
		DefaultTableModel model = (DefaultTableModel) dsSP.getModel();
		for(int i=0;i<sanPhamBus.getListSanPham().size();i++) {
			themPhanTuVaoMangTTSP(sanPhamBus.getListSanPham().get(i).getMaMh());
			themPhanTuVaoMangTTSP(sanPhamBus.getListSanPham().get(i).getTenMh());
			themPhanTuVaoMangTTSP(dcf.format(sanPhamBus.getListSanPham().get(i).getGiaBan())+"");
			themPhanTuVaoMangTTSP((sanPhamBus.getListSanPham().get(i).getSlNhap()-sanPhamBus.getListSanPham().get(i).getSlBan())+"");
			DonViDTO dv=new DonViDTO();
			dv.setMaDVT(sanPhamBus.getListSanPham().get(i).getMaDVT());
			themPhanTuVaoMangTTSP(donViBUS.getDonViByID(dv).getTenDVT());
			themPhanTuVaoMangTTSP(sdf.format(sanPhamBus.getListSanPham().get(i).getDatehsd()));
			model.addRow(TTSP);
			TTSP= new String[0];
		}
	}
	public void loadTableSP() {
		DefaultTableModel model=(DefaultTableModel)dsSP.getModel();
		for (MatHangDTO matHang : MatHangBUS.getInstance().getList()) {
			Vector<String> vec=new Vector<>();
			vec.add(matHang.getMaMh());
			vec.add(matHang.getTenMh());
			vec.add(dcf.format(matHang.getGiaBan()));
			vec.add(matHang.getSlNhap()-matHang.getSlBan()+"");
			String madv=matHang.getMaDVT();
			DonViDTO dvt=new DonViDTO();
			dvt.setMaDVT(madv);
			dvt=DonViBUS.getIntance().getDonViByID(dvt);
			String tenDVT=dvt.getTenDVT();
			vec.add(tenDVT);
			vec.add(sdf.format(matHang.getDatehsd()));
			model.addRow(vec);
			
		}
	}
	public void delTableSanPham() {
		DefaultTableModel model=(DefaultTableModel) dsSP.getModel();
		model.setRowCount(0);
	}
	public void getDSspByMaLH(String maVaTen) {
//		"Mã SP","Tên SP","Đơn giá","Còn lại","Đơn vị tính","Hạn sử dụng"
		DefaultTableModel model = (DefaultTableModel) dsSP.getModel();
//		for(int i=0;i<sanPhamBus.getListSanPhamByMaLH(layMa(maVaTen)).size();i++) {
//			themPhanTuVaoMangTTSP(sanPhamBus.getListSanPhamByMaLH(layMa(maVaTen)).get(i).getMaMh());
//			themPhanTuVaoMangTTSP(sanPhamBus.getListSanPhamByMaLH(layMa(maVaTen)).get(i).getTenMh());
//			themPhanTuVaoMangTTSP(dcf.format(sanPhamBus.getListSanPhamByMaLH(layMa(maVaTen)).get(i).getGiaBan())+"");
//			themPhanTuVaoMangTTSP((sanPhamBus.getListSanPhamByMaLH(layMa(maVaTen)).get(i).getSlNhap()-sanPhamBus.getListSanPham().get(i).getSlBan())+"");
//			DonVi dv=new DonVi();
//			dv.setMaDVT(sanPhamBus.getListSanPhamByMaLH(layMa(maVaTen)).get(i).getMaDVT());
//			themPhanTuVaoMangTTSP(donViBUS.getDonViByID(dv).getTenDVT());
//			themPhanTuVaoMangTTSP(sdf.format(sanPhamBus.getListSanPhamByMaLH(layMa(maVaTen)).get(i).getDatehsd()));
//			model.addRow(TTSP);
//			TTSP= new String[0];
//		}
		for (MatHangDTO sanPham : sanPhamBus.getListSanPhamByMaLH(layMa(maVaTen))) {
			themPhanTuVaoMangTTSP(sanPham.getMaMh());
			themPhanTuVaoMangTTSP(sanPham.getTenMh());
			themPhanTuVaoMangTTSP(dcf.format(sanPham.getGiaBan())+"");
			themPhanTuVaoMangTTSP((sanPham.getSlNhap()-sanPham.getSlBan())+"");
			DonViDTO dv=new DonViDTO();
			dv.setMaDVT(sanPham.getMaDVT());
			themPhanTuVaoMangTTSP(donViBUS.getDonViByID(dv).getTenDVT());
			themPhanTuVaoMangTTSP(sdf.format(sanPham.getDatehsd()));
			model.addRow(TTSP);
			TTSP= new String[0];
		}
	}
	
	public JTable getDsSP() {
		return dsSP;
	}
	public void setDsSP(JTable dsSP) {
		this.dsSP = dsSP;
	}
	public JLabel getDsSPName() {
		return dsSPName;
	}
	public void setDsSPName(JLabel dsSPName) {
		this.dsSPName = dsSPName;
	}
	public JLabel getBtnChange() {
		return btnChange;
	}
	public void setBtnChange(JLabel btnChange) {
		this.btnChange = btnChange;
	}
	public JScrollPane getAttribute() {
		return scrDSSP;
	}
	public void setAttribute(JScrollPane attribute) {
		this.scrDSSP = attribute;
	}
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public String getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	public String getHanSuDung() {
		return hanSuDung;
	}
	public void setHanSuDung(String hanSuDung) {
		this.hanSuDung = hanSuDung;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public int getSlTon() {
		return slTon;
	}
	public void setSlTon(int slTon) {
		this.slTon = slTon;
	}
	public String[] getCollum() {
		return collum;
	}
	public void setCollum(String[] collum) {
		this.collum = collum;
	}
	public Font getFont() {
		return font;
	}
	public void setFont(Font font) {
		this.font = font;
	}
	
}
