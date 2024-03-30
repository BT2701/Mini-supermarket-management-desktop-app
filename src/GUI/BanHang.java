package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionListener;

public class BanHang extends JPanel{
	private DanhSachSPGUI dssp;
	private ChiTietSanPhamGUI ctsp;
	private HoaDonGUI hdgui;
	private GioHangGUI gioHang;
	private ChiTietHoaDonGUI cthd;
	private JButton btnbanHang;
	private JButton btnhoaDon;
	private JLabel btnCart;
	private JLabel btnBill;
	
	private Color oldColor=new Color(236, 240, 241);
	private Color hoverColor=new Color(192, 57, 43);
	private Color pressColor=new Color(87, 101, 116);
//	private JFrame parentFrame;
	private Font font = new Font("Tahoma", Font.BOLD, 20);
	private Font fontItems = new Font("Tahoma",0, 15);
	ActionListener ac= new BanHangEvent(this);
	MouseListener mouse=new BanHangEvent(this);
	ListSelectionListener listSelect=new BanHangEvent(this);
//	ChangeListener changeListener=new BanHangEvent(this);
	private Color backgroundcolor=new Color(255, 204, 204);
//	private CompoundBorder cpBorder=new CompoundBorder(new LineBorder(new Color(250, 177, 160), 2), new MatteBorder(2, 4, 2, 4, new Color(0, 206, 201)));
	public BanHang() {
		initComponents();
		addEvent();
	}
	public void initComponents() {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(1100,700));
//		this.setBackground(backgroundcolor);
		dssp=new DanhSachSPGUI();
		ctsp=new ChiTietSanPhamGUI();
		hdgui=new HoaDonGUI();
		gioHang=new GioHangGUI();
		cthd=new ChiTietHoaDonGUI(); 
		btnbanHang=new JButton("Bán hàng");
		btnbanHang.setHorizontalAlignment(JButton.CENTER);
		btnbanHang.setVerticalTextPosition(JButton.CENTER);
//		btnbanHang.setIcon(new ImageIcon("./src/IMG/tabbed-btn--selected.png"));
		btnbanHang.setBackground(new Color(113, 128, 147));
		btnbanHang.setBounds(0, 0, 140, 37);
		btnbanHang.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnbanHang.setForeground(Color.white);
		btnbanHang.setFont(font);
		btnbanHang.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
		
		btnhoaDon= new JButton("Hóa đơn");
		btnhoaDon.setHorizontalAlignment(JButton.CENTER);
		btnhoaDon.setVerticalTextPosition(JButton.CENTER);
//		btnhoaDon.setIcon(new ImageIcon("./src/IMG/tabbed-btn.png"));
		btnhoaDon.setBackground(new Color(220, 221, 225));
		btnhoaDon.setBounds(140, 0, 140, 37);
		btnhoaDon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnhoaDon.setForeground(Color.white);
		btnhoaDon.setFont(font);
		btnhoaDon.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
		
		btnCart=new JLabel(new ImageIcon("./src/IMG/cart-icon.png"));
		btnCart.setBounds(1030, 0, 50, 50);
		btnCart.setOpaque(true);
		
		btnBill=new JLabel(new ImageIcon("./src/IMG/Bill-icon.png"));
		btnBill.setBounds(1030, 0, 50, 50);
		btnBill.setOpaque(true);
		
		
		this.add(btnCart);
		this.add(btnBill);
		this.add(btnhoaDon);
		this.add(btnbanHang);
		this.add(dssp);
		this.add(ctsp);
		this.add(hdgui);
		this.setVisible(false);
		
	}
	public void SelectTaskBanHang() {
		dssp.setVisible(true);
		ctsp.setVisible(true);
		hdgui.setVisible(false);
		btnCart.setVisible(true);
		btnBill.setVisible(false);
		btnbanHang.setBackground(new Color(113, 128, 147));
		btnhoaDon.setBackground(new Color(220, 221, 225));
	}
	public void SelectTaskHoaDon() {
		dssp.setVisible(false);
		ctsp.setVisible(false);
		hdgui.setVisible(true);
		btnCart.setVisible(false);
		btnBill.setVisible(true);
		btnbanHang.setBackground(new Color(220, 221, 225));
		btnhoaDon.setBackground(new Color(113, 128, 147));
	}
	public void addEvent() {
		btnbanHang.addActionListener(ac);
		btnhoaDon.addActionListener(ac);
		btnCart.addMouseListener(mouse);
		btnBill.addMouseListener(mouse);
		dssp.getBtnChange().addMouseListener(mouse);
		hdgui.getBtnChange().addMouseListener(mouse);
//		ctsp.getBtnDelCart().addMouseListener(mouse);
		ctsp.getBtnThemCart().addMouseListener(mouse);
//		ctsp.getBtnXuatHD().addMouseListener(mouse);
		GioHangGUI.btnDel.addMouseListener(mouse);
		GioHangGUI.btnThanhToan.addMouseListener(mouse);
		HoaDonGUI.btnTimkiem.addMouseListener(mouse);
//		GioHangGUI.btndungdiem.addMouseListener(mouse);
		GioHangGUI.cbthongtinkh.addActionListener(ac);
		DanhSachSPGUI.cbchungloai.addActionListener(ac);
		DanhSachSPGUI.cbloaihang.addActionListener(ac);
		this.getDssp().getDsSP().addMouseListener(mouse);
		hdgui.getTbHoaDon().addMouseListener(mouse);
		cthd.getTbHoaDonCT().addMouseListener(mouse);
		HoaDonGUI.btnTimkiem1.addMouseListener(mouse);
		HoaDonGUI.lbTimTheoTime.addMouseListener(mouse);
		HoaDonGUI.lbTimTheoPrince.addMouseListener(mouse);
//		DiaLogThemKhachHangGUI.lbThemKH.addMouseListener(mouse);
//		ChiTietSanPhamGUI.spnSoluong.addChangeListener(changeListener);
	}
	public void xuLySuKienRefreshBanHang() {
		dssp.getDSchungLoai();
		dssp.getDSloaiHangView("1 - 2");
		dssp.delTableSanPham();
		dssp.getDSSPALL();
		
		ctsp.getBtnThemCart().setEnabled(false);
//		ctsp.getBtnDelCart().setEnabled(false);
//		ctsp.getBtnXuatHD().setEnabled(false);
		DanhSachSPGUI.cbloaihang.setEnabled(false);
		
		ChiTietSanPhamGUI.tfDongia.setText(null);
		ChiTietSanPhamGUI.tfMasp.setText(null);
		ChiTietSanPhamGUI.tfTensp.setText(null);
		
		ChiTietSanPhamGUI.spnSoluong.setValue(0);
		ChiTietSanPhamGUI.spnSoluong.setEnabled(false);
		
		gioHang.getThongTinKhachHang();
	}
	public void xuLySuKienRefreshHoaDon() {
		hdgui.xuLySuKienNutRefresh();
		cthd.xuLySuKienRefresh();
	}
	public DanhSachSPGUI getDssp() {
		return dssp;
	}
	public void setDssp(DanhSachSPGUI dssp) {
		this.dssp = dssp;
	}
	public ChiTietSanPhamGUI getCtsp() {
		return ctsp;
	}
	public void setCtsp(ChiTietSanPhamGUI ctsp) {
		this.ctsp = ctsp;
	}
	public HoaDonGUI getHdgui() {
		return hdgui;
	}
	public void setHdgui(HoaDonGUI hdgui) {
		this.hdgui = hdgui;
	}
	public GioHangGUI getGioHang() {
		return gioHang;
	}
	public void setGioHang(GioHangGUI gioHang) {
		this.gioHang = gioHang;
	}
	public JButton getBtnbanHang() {
		return btnbanHang;
	}
	public void setBtnbanHang(JButton btnbanHang) {
		this.btnbanHang = btnbanHang;
	}
	public JButton getBtnhoaDon() {
		return btnhoaDon;
	}
	public void setBtnhoaDon(JButton btnhoaDon) {
		this.btnhoaDon = btnhoaDon;
	}
	public JLabel getBtnCart() {
		return btnCart;
	}
	public void setBtnCart(JLabel btnCart) {
		this.btnCart = btnCart;
	}
	public JLabel getBtnBill() {
		return btnBill;
	}
	public void setBtnBill(JLabel btnBill) {
		this.btnBill = btnBill;
	}
	public Font getFont() {
		return font;
	}
	public void setFont(Font font) {
		this.font = font;
	}
	public ChiTietHoaDonGUI getCthd() {
		return cthd;
	}
	public void setCthd(ChiTietHoaDonGUI cthd) {
		this.cthd = cthd;
	}
	
	
}
