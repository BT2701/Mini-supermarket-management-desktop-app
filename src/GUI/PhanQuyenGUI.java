/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.JPanel;
//import BUS.LoaiBUS;
//import BUS.NsxBUS;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.BorderFactory.createLineBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
//import DTO.SanPhamDTO;
//import BUS.SanPhamBUS;
//import DTO.LoaiDTO;
//import DTO.NsxDTO;
import java.awt.Choice;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import BUS.NhanVienBUS;
import BUS.PhanQuyenBUS;
import DTO.PhanQuyen;

public class PhanQuyenGUI extends JPanel {
	public PhanQuyenGUI() {
		init();
		this.setVisible(false);
	}

	private JLabel title, lbnhomquyen, lbhanhdong,lbtaiKhoan;
	public static JLabel btnadd, btnedit, btndelete;
	private JCheckBox cbxQuyen[];
	private String[] listPQ= {"Chọn quyền"};
	public static JComboBox<String> cbLisPQ;
	private Font font = new Font("Tahoma", Font.BOLD, 25);
	private Font fontItems = new Font("Tahoma", Font.BOLD, 15);
	private Color btnhoverColor=new Color(116, 185, 255);

//    private JToggleButton test[][];
	public void init() {
		setLayout(null);
		setPreferredSize(new Dimension(1100, 700));
		setBackground(new Color(0xEEEEEE));
		this.setBackground(Color.white);
		title = new JLabel("QUẢN LÍ PHÂN QUYỀN");
		title.setBounds(400, 10, 305, 40);
		title.setFont(font);
		add(title);
		lbnhomquyen = new JLabel("Nhóm quyền: ");
		lbnhomquyen.setBounds(390, 65, 150, 25);
		lbnhomquyen.setFont(fontItems);
		add(lbnhomquyen);
		cbLisPQ = new JComboBox<String>();
		getDSquyen();
		cbLisPQ.setBounds(510, 65, 150, 25);
		cbLisPQ.setFont(fontItems);
		cbLisPQ.setBackground(Color.WHITE);
		add(cbLisPQ);

		lbhanhdong = new JLabel("Các hành động");
		lbhanhdong.setBounds(450, 110, 150, 25);
		lbhanhdong.setFont(fontItems);
		add(lbhanhdong);


		int toadoyButton = 160;
		int toadoyButton1 = 160;
		int toaDoX = 650;
		cbxQuyen = new JCheckBox[10];
		String[] arrBtn = { "Quản lý nhập hàng", "Quản lý sản phẩm", "Quản lý nhân viên", "Quản lý khách hàng",
				"Quản lý nhà cung cấp", "Quản lý thống kê", "Quản lý thêm", "Quản lý xóa", "Quán lý sửa",
				"Quản lý phân quyền" };
		for (int i = 0; i < 10; i++) {
			if(i<5) {
				cbxQuyen[i] = new JCheckBox(arrBtn[i]);
				cbxQuyen[i].setBounds(200, toadoyButton, 220, 25);
				cbxQuyen[i].setFont(fontItems);
				cbxQuyen[i].setBackground(Color.white);
				toadoyButton += 50;
			}
			else {
				cbxQuyen[i] = new JCheckBox(arrBtn[i]);
				cbxQuyen[i].setBounds(toaDoX, toadoyButton1, 220, 25);
				cbxQuyen[i].setFont(fontItems);
				cbxQuyen[i].setBackground(Color.white);
				toadoyButton1+=50;
			}
			add(cbxQuyen[i]);
		}

		btnadd = new JLabel();
		btnadd.setIcon(new ImageIcon("./src/IMG/btnAdd_150px.png"));
		btnadd.setBounds(270, 400, 200, 50);
		btnadd.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnedit = new JLabel();
		btnedit.setIcon(new ImageIcon("./src/IMG/btnEdit_150px.png"));
		btnedit.setBounds(470, 400, 200, 50);
		btnedit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btndelete = new JLabel();
		btndelete.setIcon(new ImageIcon("./src/IMG/btnDelete_150px.png"));
		btndelete.setBounds(670, 400, 200, 50);
		btndelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		lbtaiKhoan=new JLabel(new ImageIcon("./src/IMG/account-icon.png"));
		lbtaiKhoan.setBounds(5, 5, 50, 50);
		lbtaiKhoan.setOpaque(true);
		lbtaiKhoan.setBackground(Color.white);
		lbtaiKhoan.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				new DialogTaoTaiKhoanGUI();
			}
			public void mouseEntered(MouseEvent e) {
				lbtaiKhoan.setBackground(btnhoverColor);
			}
			public void mouseExited(MouseEvent e) {
				lbtaiKhoan.setBackground(Color.white);
			}
		});
		add(btnadd);
		add(btnedit);
		add(btndelete);
		add(lbtaiKhoan);
	}
	public void themPhanTuVaoMangPQ(String s) {
		int l=listPQ.length;
		listPQ=Arrays.copyOf(listPQ, l+1);
		listPQ[l]=s;
	}
	public void getDSquyen() {

		for (String quyen : PhanQuyenBUS.getInstance().layDanhSachQuyen()) {
			themPhanTuVaoMangPQ(quyen);
		}
		DefaultComboBoxModel<String> cbmodel = new DefaultComboBoxModel<>(listPQ);
		cbLisPQ.setModel(cbmodel);
		listPQ = new String[0];
		themPhanTuVaoMangPQ("Chọn quyền");
	}
	public void xuLySuKienCBlistQuyen() {
		if(cbLisPQ.getSelectedIndex()==0) {
			for(int i=0;i<10;i++) {
				cbxQuyen[i].setSelected(false);
			}
		}
		else {
			String quyen=cbLisPQ.getSelectedItem().toString();
			
			PhanQuyen phanQuyen=new PhanQuyen();
			phanQuyen.setQuyen(quyen);
			phanQuyen=PhanQuyenBUS.getInstance().getByID(phanQuyen);
			for(int i=0;i<10;i++) {
				cbxQuyen[i].setSelected(false);
			}
			if(phanQuyen.getNhapHang()==1)
				cbxQuyen[0].setSelected(true);
			if(phanQuyen.getQlSP()==1)
				cbxQuyen[1].setSelected(true);
			if(phanQuyen.getQlNV()==1)
				cbxQuyen[2].setSelected(true);
			if(phanQuyen.getQlKh()==1)
				cbxQuyen[3].setSelected(true);
			if(phanQuyen.getQlNCC()==1)
				cbxQuyen[4].setSelected(true);
			if(phanQuyen.getQlThongKe()==1)
				cbxQuyen[5].setSelected(true);
			if(phanQuyen.getThem()==1)
				cbxQuyen[6].setSelected(true);
			if(phanQuyen.getXoa()==1)
				cbxQuyen[7].setSelected(true);
			if(phanQuyen.getSua()==1)
				cbxQuyen[8].setSelected(true);
			if(phanQuyen.getQlPhanQuyen()==1)
				cbxQuyen[9].setSelected(true);
		}
	}
	public void xuLyThemQuyen() {
		String tenQuyen = JOptionPane.showInputDialog("Nhập tên quyền");
		for (String pq : PhanQuyenBUS.getInstance().layDanhSachQuyen()) {
			if(tenQuyen.equalsIgnoreCase(pq)) {
				new ThongBaoDialog("Quyền đã tồn tại", ThongBaoDialog.ERROR_DIALOG);
				return;
			}
		}
		int qlNhap=0,qlSP=0,qlNV=0,qlKH=0,qlNCC=0,qlThongKe=0,qlThem=0,qlXoa=0,qlSua=0,qlPQ=0;
		if(cbxQuyen[0].isSelected()) {
			qlNhap=1;
		}
		if(cbxQuyen[1].isSelected()) {
			qlSP=1;
		}
		if(cbxQuyen[2].isSelected()) {
			qlNV=1;
		}
		if(cbxQuyen[3].isSelected()) {
			qlKH=1;
		}
		if(cbxQuyen[4].isSelected()) {
			qlNCC=1;
		}
		if(cbxQuyen[5].isSelected()) {
			qlThongKe=1;
		}
		if(cbxQuyen[6].isSelected()) {
			qlThem=1;
		}
		if(cbxQuyen[7].isSelected()) {
			qlXoa=1;
		}
		if(cbxQuyen[8].isSelected()) {
			qlSua=1;
		}
		if(cbxQuyen[9].isSelected()) {
			qlPQ=1;
		}
		PhanQuyen quyen=new PhanQuyen(tenQuyen, qlNhap, qlSP, qlNV, qlKH, qlNCC, qlThongKe, qlThem, qlXoa, qlSua, qlPQ);
		PhanQuyenBUS.getInstance().inSert(quyen);
		new ThongBaoDialog("Thêm quyền thành công", ThongBaoDialog.SUCCESS_DIALOG);
		getDSquyen();
		
	}
	public void xuLyXoaQuyen() {
		if(cbLisPQ.getSelectedIndex()==0) {
			new ThongBaoDialog("Chọn quyền để xóa", ThongBaoDialog.ERROR_DIALOG);
			return;
		}
		else {
			String quyen=cbLisPQ.getSelectedItem().toString();
			PhanQuyen pq=new PhanQuyen();
			pq.setQuyen(quyen);
			pq=PhanQuyenBUS.getInstance().getByID(pq);
			new ThongBaoDialog("Bạn muốn xóa quyền này?", ThongBaoDialog.WARNING_DIALOG);
			if(ThongBaoDialog.action==ThongBaoDialog.CANCEL_OPTION)
				return;
			PhanQuyenBUS.getInstance().delete(pq);
			new ThongBaoDialog("Xóa thành công", ThongBaoDialog.SUCCESS_DIALOG);
		}
		getDSquyen();
	}
	public void xuLySuaQuyen() {
		if(cbLisPQ.getSelectedIndex()==0) {
			new ThongBaoDialog("Chọn quyền để sửa", ThongBaoDialog.ERROR_DIALOG);
			return;
		}
		else {
			String quyen=cbLisPQ.getSelectedItem().toString();
			int qlNhap=0,qlSP=0,qlNV=0,qlKH=0,qlNCC=0,qlThongKe=0,qlThem=0,qlXoa=0,qlSua=0,qlPQ=0;
			if(cbxQuyen[0].isSelected()) {
				qlNhap=1;
			}
			if(cbxQuyen[1].isSelected()) {
				qlSP=1;
			}
			if(cbxQuyen[2].isSelected()) {
				qlNV=1;
			}
			if(cbxQuyen[3].isSelected()) {
				qlKH=1;
			}
			if(cbxQuyen[4].isSelected()) {
				qlNCC=1;
			}
			if(cbxQuyen[5].isSelected()) {
				qlThongKe=1;
			}
			if(cbxQuyen[6].isSelected()) {
				qlThem=1;
			}
			if(cbxQuyen[7].isSelected()) {
				qlXoa=1;
			}
			if(cbxQuyen[8].isSelected()) {
				qlSua=1;
			}
			if(cbxQuyen[9].isSelected()) {
				qlPQ=1;
			}
			new ThongBaoDialog("Bạn muốn sửa quyền này?", ThongBaoDialog.WARNING_DIALOG);
			if(ThongBaoDialog.action==ThongBaoDialog.CANCEL_OPTION)
				return;
			PhanQuyen phanQuyen=new PhanQuyen(quyen, qlNhap, qlSP, qlNV, qlKH, qlNCC, qlThongKe, qlThem, qlXoa, qlSua, qlPQ);
			PhanQuyenBUS.getInstance().upDate(phanQuyen);
			new ThongBaoDialog("Cập nhật thành công", ThongBaoDialog.SUCCESS_DIALOG);
		}
	}
}
