/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

//import controller.QuanLyListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import BUS.PhanQuyenBUS;
import DTO.PhanQuyen;

/**
 *
 * @author phamn
 */
public class QuanLyView extends JFrame {

	private JPanel jPanel_north, jPanel_west, jPanel_icon_north;
	private JLabel jLabel_north, jLabel_logo, jLabel_ima_profile, jLabel_user;
	private ImageIcon image_profile, icon_shop, icon_logout;
	public JButton jButton_hidden, jButton_close, jButton_logout;
	private ThongKe thongKe;
	private BanHang banHang;
	private NhaCungCapGUI ncc;
	private MatHangGUI matHang;
	private KhachHangGUI khachHang;
	private NhanVienGUI nhanVien;
	private TrangChuGUI trangChu;
	private PhanQuyenGUI phanQuyen;
	private NhapHangGUI nhapHang;
	private Color pressColor=new Color(72, 219, 251);
	private Color backgroundcolor = new Color(255, 204, 204);
	// sự kiện di chuột
	MouseListener mouse = new QuanLyListener(this);

	// sự kiện
	ActionListener ac = new QuanLyListener(this);

//Mảng Item Menu
	public String[] menuItem = { "Trang chủ", "Bán hàng", "Sản phẩm", "Nhân viên", "Khách hàng", "Nhập hàng",
			"Nhà cung cấp", "Phân quyền", "Thống kê" };
	public JLabel[] menu_Label;

//Mảng Icon Menu --------55X55----Padding = 15px--------Position = X:20px, Y=0px
	private String[] link_menuImageIcon = { "./src/IMG/home1-icon.png", "./src/IMG/BanHang.png", "./src/IMG/QLSP.png",
			"./src/IMG/QLNV.png", "./src/IMG/QLKH.png", "./src/IMG/NhapXuat.png", "./src/IMG/NhaCungCap.png",
			"./src/IMG/TaiKhoan.png", "./src/IMG/ThongKe.png" };
	private ImageIcon menuImageIcon;

	public QuanLyView() { // Constructor
		this.init();
		mousePress_setVisibleCenter_TrangChu();
		addEvent();
	}

	private void init() {
		this.setSize(1300, 730);
		this.setLocationRelativeTo(null);
//		this.setBackground(backgroundcolor);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setBackground(Color.white);
//        Content=new Center();
		thongKe = new ThongKe();
		banHang = new BanHang();
		ncc = new NhaCungCapGUI(1100);
		matHang = new MatHangGUI(1100);
		khachHang = new KhachHangGUI();
		nhanVien = new NhanVienGUI();
		trangChu = new TrangChuGUI();
		phanQuyen = new PhanQuyenGUI();
		nhapHang = new NhapHangGUI();

		// Image, icon
		image_profile = new ImageIcon("./src/IMG/admin.png");
		icon_shop = new ImageIcon("./src/IMG/icon_shop.png");
		icon_logout = new ImageIcon("./src/IMG/icon_logout.png");

		// Line
		Border lineBorder_exit_hidden = BorderFactory.createLineBorder(new Color(0x29B6F6), 1);

		// Font
		Font font_label_north = new Font("Times New Roman", Font.BOLD, 20);
		Font font_exit_hidden = new Font("Arials", Font.BOLD, 20);
		Font font_menu_item = new Font("Arials", Font.BOLD, 15);
		Font f_jLabel_hello = new Font("Open Sans", Font.ITALIC, 15);
		Font f_jLabel_user = new Font("Arials", Font.BOLD, 15);

		// north
		jLabel_logo = new JLabel(icon_shop); // icon bên trái
		jLabel_logo.setBounds(0, 0, 30, 30);

		JLabel jLabel_hello = new JLabel("Chào!,");
		jLabel_hello.setBounds(50, 0, 48, 30);
		jLabel_hello.setFont(f_jLabel_hello);

		jLabel_user = new JLabel("Admin"); // sẽ thay đổi xưng hô theo từng user
		jLabel_user.setBounds(100, 0, 150, 30);
		jLabel_user.setFont(f_jLabel_user);

		jLabel_north = new JLabel("PHẦN MỀM QUẢN LÝ SIÊU THỊ MINI"); // label giữa
		jLabel_north.setBounds(500, 0, 380, 30);
		jLabel_north.setFont(font_label_north);

		// Exit và Hidden
		jButton_hidden = new JButton("-"); // nút hidden
		jButton_hidden.setBounds(1242, 0, 30, 31); // 33
		jButton_hidden.setBackground(new Color(0x29B6F6));

		jButton_hidden.setBorder(lineBorder_exit_hidden);
		jButton_hidden.setFont(font_exit_hidden);
		jButton_hidden.setCursor(new Cursor(Cursor.HAND_CURSOR));


		jButton_close = new JButton("X"); // nút close
		jButton_close.setBounds(1270, 0, 30, 31);
		jButton_close.setBackground(new Color(0x29B6F6));

		jButton_close.setBorder(lineBorder_exit_hidden);
		jButton_close.setFont(font_exit_hidden);
		jButton_close.setCursor(new Cursor(Cursor.HAND_CURSOR));

		jButton_close.addActionListener(ac); // sự kiện
		jButton_close.addMouseListener(mouse); // sự kiện chuột

		jButton_logout = new JButton(icon_logout);
		jButton_logout.setBounds(1214, 0, 30, 31);
		jButton_logout.setBackground(new Color(0x29B6F6));
		jButton_logout.setCursor(new Cursor(Cursor.HAND_CURSOR));

//        jButton_close.addActionListener(ac); //sự kiện
		

		jPanel_north = new JPanel();
		jPanel_north.setLayout(null);
		jPanel_north.setPreferredSize(new Dimension(1300, 30));
		jPanel_north.setBackground(new Color(0x29B6F6));

		// north add...
		jPanel_north.add(jLabel_north);
		jPanel_north.add(jLabel_logo);
		jPanel_north.add(jButton_hidden);
		jPanel_north.add(jButton_close);
		jPanel_north.add(jLabel_hello);
		jPanel_north.add(jLabel_user);
		jPanel_north.add(jButton_logout);

		// profile_west
		jLabel_ima_profile = new JLabel(image_profile);
		jLabel_ima_profile.setBounds(0, 0, 200, 200);

		JPanel profile_west = new JPanel();
		profile_west.setLayout(null);
		profile_west.setBackground(new Color(55, 63, 81));
		profile_west.setPreferredSize(new Dimension(220, 200));
		profile_west.add(jLabel_ima_profile);

		// Thanh menu
		jPanel_west = new JPanel();
		jPanel_west.setLayout(new FlowLayout(0, 0, 0));
		jPanel_west.setPreferredSize(new Dimension(200, 700));
		jPanel_west.setBackground(new Color(0x596275));

		jPanel_west.add(profile_west);

		menu_Label = new JLabel[menuItem.length];
		for (int i = 0; i < menuItem.length; i++) {
			menu_Label[i] = new JLabel(menuItem[i], JLabel.LEFT); // khởi tạo Label

			menuImageIcon = new ImageIcon(link_menuImageIcon[i]);// khởi tạo Icon
			menu_Label[i].setIcon(menuImageIcon);// set Icon cho Label

			menu_Label[i].setPreferredSize(new Dimension(220, 50));
			menu_Label[i].addMouseListener(mouse);
			menu_Label[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
			menu_Label[i].setFont(font_menu_item);
			menu_Label[i].setForeground(Color.WHITE);

			jPanel_west.add(menu_Label[i]);
		}
//		menu_Label[5].setVisible(false);

		this.setLayout(new BorderLayout());
		// this add...
		this.add(jPanel_north, BorderLayout.NORTH);
		this.add(jPanel_west, BorderLayout.WEST);

		
		Image icon_store = Toolkit.getDefaultToolkit().createImage("./src/IMG/icon_store.png");
		this.setIconImage(icon_store);

		this.setUndecorated(true); // tắt thanh chức năng mặc định của chương trình
		this.setVisible(true);
	}
	public void addEvent() {
		nhapHang.jLabel_nh.addMouseListener(mouse);
		nhapHang.jLabel_qlpn.addMouseListener(mouse);
		jButton_logout.addMouseListener(mouse); // sự kiện chuột
		jButton_hidden.addActionListener(ac); // sự kiện
		jButton_hidden.addMouseListener(mouse); // sự kiện chuột
		KhachHangGUI.btndelete.addMouseListener(mouse);
		MatHangGUI.btndelete.addMouseListener(mouse);
		NhaCungCapGUI.btndelete.addMouseListener(mouse);
		NhanVienGUI.btndelete.addMouseListener(mouse);
		
		KhachHangGUI.btnadd.addMouseListener(mouse);
		MatHangGUI.btnadd.addMouseListener(mouse);
		NhaCungCapGUI.btnadd.addMouseListener(mouse);
		NhanVienGUI.btnadd.addMouseListener(mouse);
		
		KhachHangGUI.btnedit.addMouseListener(mouse);
		MatHangGUI.btnedit.addMouseListener(mouse);
		NhaCungCapGUI.btnedit.addMouseListener(mouse);
		NhanVienGUI.btnedit.addMouseListener(mouse);
		
		PhanQuyenGUI.cbLisPQ.addActionListener(ac);
		PhanQuyenGUI.btnadd.addMouseListener(mouse);
		PhanQuyenGUI.btndelete.addMouseListener(mouse);
		PhanQuyenGUI.btnedit.addMouseListener(mouse);
		
		
	}

//Phương thức
	// Sự kiện click chuột vào close, hidden, logout
	public void click_close() {
		System.exit(0);
	}

	public void click_hidden() {
		this.setState(ICONIFIED);
	}

	// sự kiện di chuột vào exit và hidden, logout
	public void mouseEntered_button_close() {
		jButton_close.setBackground(Color.red);
		jButton_close.setForeground(Color.white);
	}

	public void mouseExited_button_close() {
		jButton_close.setBackground(new Color(0x29B6F6));
		jButton_close.setForeground(Color.black);
	}

	// sự kiện di chuột vào nút hidden
	public void mouseEntered_button_hidden() {
		jButton_hidden.setBackground(Color.red);
		jButton_hidden.setForeground(Color.white);
	}

	public void mouseExited_button_hidden() {
		jButton_hidden.setBackground(new Color(0x29B6F6));
		jButton_hidden.setForeground(Color.black);
	}

	// sự kiện di chuột vào nút logout
	public void mouseEntered_button_logout() {
		jButton_logout.setBackground(Color.red);
		jButton_logout.setForeground(Color.white);
	}

	public void mouseExited_button_logout() {
		jButton_logout.setBackground(new Color(0x29B6F6));
		jButton_logout.setForeground(Color.black);
	}
//-------------------------------------------------------------------------------

	public void mouseEntered_button_item(int i, Color color) {
		menu_Label[i].setBackground(color);
		menu_Label[i].setForeground(Color.WHITE);
		menu_Label[i].setOpaque(true);

	}

	public void mouseExited_button_item(int i, Color color) {
		menu_Label[i].setBackground(color);
		menu_Label[i].setForeground(Color.WHITE);

	}
	
	public void mousePresses_menuItems(int i) {
		menu_Label[i].setBackground(pressColor);
	}

	public void mousePress_setVisibleCenter_banHang() {
		this.getContentPane().add(banHang, BorderLayout.CENTER);
		banHang.setVisible(true);
		thongKe.setVisible(false);
		matHang.setVisible(false);
		ncc.setVisible(false);
		nhanVien.setVisible(false);
		khachHang.setVisible(false);
		trangChu.setVisible(false);
		phanQuyen.setVisible(false);
		nhapHang.setVisible(false);
	}

	public void mousePress_setVisibleCenter_thongKe() {
		this.getContentPane().add(thongKe, BorderLayout.CENTER);
		thongKe.setVisible(true);
		banHang.setVisible(false);
		matHang.setVisible(false);
		ncc.setVisible(false);
		nhanVien.setVisible(false);
		khachHang.setVisible(false);
		trangChu.setVisible(false);
		phanQuyen.setVisible(false);
		nhapHang.setVisible(false);
	}

	public void mousePress_setVisibleCenter_MatHang() {
		this.getContentPane().add(matHang, BorderLayout.CENTER);
		matHang.setVisible(true);
		banHang.setVisible(false);
		thongKe.setVisible(false);
		ncc.setVisible(false);
		nhanVien.setVisible(false);
		khachHang.setVisible(false);
		trangChu.setVisible(false);
		phanQuyen.setVisible(false);
		nhapHang.setVisible(false);
	}

	public void mousePress_setVisibleCenter_NCC() {
		this.getContentPane().add(ncc, BorderLayout.CENTER);
		ncc.setVisible(true);
		matHang.setVisible(false);
		banHang.setVisible(false);
		thongKe.setVisible(false);
		nhanVien.setVisible(false);
		khachHang.setVisible(false);
		trangChu.setVisible(false);
		phanQuyen.setVisible(false);
		nhapHang.setVisible(false);

	}

	public void mousePress_setVisibleCenter_NhanVien() {
		this.getContentPane().add(nhanVien, BorderLayout.CENTER);
		nhanVien.setVisible(true);
		matHang.setVisible(false);
		banHang.setVisible(false);
		thongKe.setVisible(false);
		ncc.setVisible(false);
		khachHang.setVisible(false);
		trangChu.setVisible(false);
		phanQuyen.setVisible(false);
		nhapHang.setVisible(false);
	}

	public void mousePress_setVisibleCenter_KhachHang() {
		this.getContentPane().add(khachHang, BorderLayout.CENTER);
		nhanVien.setVisible(false);
		matHang.setVisible(false);
		banHang.setVisible(false);
		thongKe.setVisible(false);
		ncc.setVisible(false);
		khachHang.setVisible(true);
		trangChu.setVisible(false);
		phanQuyen.setVisible(false);
		nhapHang.setVisible(false);
	}

	public void mousePress_setVisibleCenter_TrangChu() {
		this.getContentPane().add(trangChu, BorderLayout.CENTER);
		nhanVien.setVisible(false);
		matHang.setVisible(false);
		banHang.setVisible(false);
		thongKe.setVisible(false);
		ncc.setVisible(false);
		khachHang.setVisible(false);
		trangChu.setVisible(true);
		phanQuyen.setVisible(false);
		nhapHang.setVisible(false);
	}

	public void mousePress_setVisibleCenter_PhanQuyen() {
		this.getContentPane().add(phanQuyen, BorderLayout.CENTER);
		nhanVien.setVisible(false);
		matHang.setVisible(false);
		banHang.setVisible(false);
		thongKe.setVisible(false);
		ncc.setVisible(false);
		khachHang.setVisible(false);
		trangChu.setVisible(false);
		phanQuyen.setVisible(true);
		nhapHang.setVisible(false);
	}

	public void mousePress_setVisibleCenter_NhapHang() {
		this.getContentPane().add(nhapHang, BorderLayout.CENTER);
		nhanVien.setVisible(false);
		matHang.setVisible(false);
		banHang.setVisible(false);
		thongKe.setVisible(false);
		ncc.setVisible(false);
		khachHang.setVisible(false);
		trangChu.setVisible(false);
		phanQuyen.setVisible(false);
		nhapHang.setVisible(true);
	}
	public void showFunction() {
		for(int i=0;i<menu_Label.length;i++) {
			menu_Label[i].setVisible(true);
		}
	}
	public void xuLyPhanQuyen(String quyen) {
		PhanQuyen phanQuyen=new PhanQuyen();
		phanQuyen.setQuyen(quyen);
		phanQuyen=PhanQuyenBUS.getInstance().getByID(phanQuyen);
		int quyenNhapHang=phanQuyen.getNhapHang();
		int quyenQL_SP=phanQuyen.getQlSP();
		int quyenQL_NV=phanQuyen.getQlNV();
		int quyenQL_KH=phanQuyen.getQlKh();
		int quyenQL_NCC=phanQuyen.getQlNCC();
		int quyenThongKe=phanQuyen.getQlThongKe();
		int quyenThem=phanQuyen.getThem();
		int quyenXoa=phanQuyen.getXoa();
		int quyenSua=phanQuyen.getSua();
		int quyenQL_PQ=phanQuyen.getQlPhanQuyen();
//		"Trang chủ", "Bán hàng", "Sản phẩm", "Nhân viên", "Khách hàng", "Nhập & xuất",
//		"Nhà cung cấp", "Phân quyền", "Thống kê"
//		nhập hàng,ql sản phẩm,ql nhân viên,ql khách hàng,ql ncc,thong ke,them,xoa,sua,ql phan quyen
		showFunction();
		if(quyenNhapHang==0) {
			menu_Label[5].setVisible(false);
		}
//		menu_Label[5].setVisible(false);
		if(quyenQL_SP==0) {
			menu_Label[2].setVisible(false);
		}
		if(quyenQL_NV==0) {
			menu_Label[3].setVisible(false);
		}
		if(quyenQL_KH==0) {
			menu_Label[4].setVisible(false);
		}
		if(quyenQL_NCC==0) {
			menu_Label[6].setVisible(false);
		}
		if(quyenThongKe==0) {
			menu_Label[8].setVisible(false);
		}
		if(quyenQL_PQ==0) {
			menu_Label[7].setVisible(false);
		}
		if(quyenThem==0) {
			KhachHangGUI.btnadd.setEnabled(false);
			MatHangGUI.btnadd.setEnabled(false);
			NhaCungCapGUI.btnadd.setEnabled(false);
			NhanVienGUI.btnadd.setEnabled(false);
			
		}
		if(quyenXoa==0) {
			KhachHangGUI.btndelete.setEnabled(false);
			MatHangGUI.btndelete.setEnabled(false);
			NhaCungCapGUI.btndelete.setEnabled(false);
			NhanVienGUI.btndelete.setEnabled(false);
			
		}
		if(quyenSua==0) {
			KhachHangGUI.btnedit.setEnabled(false);
			MatHangGUI.btnedit.setEnabled(false);
			NhaCungCapGUI.btnedit.setEnabled(false);
			NhanVienGUI.btnedit.setEnabled(false);
			
		}
	}
	public void xuLyDangXuat() {
		new ThongBaoDialog("Bạn chọn đăng xuất", ThongBaoDialog.WARNING_DIALOG);
		if(ThongBaoDialog.action==ThongBaoDialog.CANCEL_OPTION) {
			return;
		}
		dispose();
		LoginView login=new LoginView();
	}

	public JPanel getjPanel_north() {
		return jPanel_north;
	}

	public void setjPanel_north(JPanel jPanel_north) {
		this.jPanel_north = jPanel_north;
	}

	public JPanel getjPanel_west() {
		return jPanel_west;
	}

	public void setjPanel_west(JPanel jPanel_west) {
		this.jPanel_west = jPanel_west;
	}

	public JPanel getjPanel_icon_north() {
		return jPanel_icon_north;
	}

	public void setjPanel_icon_north(JPanel jPanel_icon_north) {
		this.jPanel_icon_north = jPanel_icon_north;
	}

	public JLabel getjLabel_north() {
		return jLabel_north;
	}

	public void setjLabel_north(JLabel jLabel_north) {
		this.jLabel_north = jLabel_north;
	}

	public JLabel getjLabel_logo() {
		return jLabel_logo;
	}

	public void setjLabel_logo(JLabel jLabel_logo) {
		this.jLabel_logo = jLabel_logo;
	}

	public JLabel getjLabel_ima_profile() {
		return jLabel_ima_profile;
	}

	public void setjLabel_ima_profile(JLabel jLabel_ima_profile) {
		this.jLabel_ima_profile = jLabel_ima_profile;
	}

	public JLabel getjLabel_user() {
		return jLabel_user;
	}

	public void setjLabel_user(JLabel jLabel_user) {
		this.jLabel_user = jLabel_user;
	}

	public ImageIcon getImage_profile() {
		return image_profile;
	}

	public void setImage_profile(ImageIcon image_profile) {
		this.image_profile = image_profile;
	}

	public ImageIcon getIcon_shop() {
		return icon_shop;
	}

	public void setIcon_shop(ImageIcon icon_shop) {
		this.icon_shop = icon_shop;
	}

	public ImageIcon getIcon_logout() {
		return icon_logout;
	}

	public void setIcon_logout(ImageIcon icon_logout) {
		this.icon_logout = icon_logout;
	}

	public JButton getjButton_hidden() {
		return jButton_hidden;
	}

	public void setjButton_hidden(JButton jButton_hidden) {
		this.jButton_hidden = jButton_hidden;
	}

	public JButton getjButton_close() {
		return jButton_close;
	}

	public void setjButton_close(JButton jButton_close) {
		this.jButton_close = jButton_close;
	}

	public JButton getjButton_logout() {
		return jButton_logout;
	}

	public void setjButton_logout(JButton jButton_logout) {
		this.jButton_logout = jButton_logout;
	}

	public ThongKe getThongKe() {
		return thongKe;
	}

	public void setThongKe(ThongKe thongKe) {
		this.thongKe = thongKe;
	}

	public BanHang getBanHang() {
		return banHang;
	}

	public void setBanHang(BanHang banHang) {
		this.banHang = banHang;
	}

	public NhaCungCapGUI getNcc() {
		return ncc;
	}

	public void setNcc(NhaCungCapGUI ncc) {
		this.ncc = ncc;
	}

	public MatHangGUI getMatHang() {
		return matHang;
	}

	public void setMatHang(MatHangGUI matHang) {
		this.matHang = matHang;
	}

	public String[] getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(String[] menuItem) {
		this.menuItem = menuItem;
	}

	public JLabel[] getMenu_Label() {
		return menu_Label;
	}

	public void setMenu_Label(JLabel[] menu_Label) {
		this.menu_Label = menu_Label;
	}

	public String[] getLink_menuImageIcon() {
		return link_menuImageIcon;
	}

	public void setLink_menuImageIcon(String[] link_menuImageIcon) {
		this.link_menuImageIcon = link_menuImageIcon;
	}

	public ImageIcon getMenuImageIcon() {
		return menuImageIcon;
	}

	public void setMenuImageIcon(ImageIcon menuImageIcon) {
		this.menuImageIcon = menuImageIcon;
	}

	public KhachHangGUI getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHangGUI khachHang) {
		this.khachHang = khachHang;
	}

	public NhanVienGUI getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVienGUI nhanVien) {
		this.nhanVien = nhanVien;
	}

	public TrangChuGUI getTrangChu() {
		return trangChu;
	}

	public void setTrangChu(TrangChuGUI trangChu) {
		this.trangChu = trangChu;
	}

	public PhanQuyenGUI getPhanQuyen() {
		return phanQuyen;
	}

	public void setPhanQuyen(PhanQuyenGUI phanQuyen) {
		this.phanQuyen = phanQuyen;
	}

	public NhapHangGUI getNhapHang() {
		return nhapHang;
	}

	public void setNhapHang(NhapHangGUI nhapHang) {
		this.nhapHang = nhapHang;
	}
	

}
