package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.event.ChangeListener;

//import QuanLyPizza.GUI.DlgLocThongKe;

public class ThongKe extends JPanel {
	private ThongKeTop tkt;
	private ThongKeDown tkd;
	private ThongKeChiTiet tkct;
	private Color oldColor = new Color(236, 240, 241);
	private Color hoverColor = new Color(192, 57, 43);
	ActionListener ac = new ThongKeEvent(this);
	MouseListener mouse = new ThongKeEvent(this);
	ChangeListener change=new ThongKeEvent(this);

//	private CardLayout cardLayoutThongKe=new CardLayout();
	public ThongKe() {
		initComponent();
		addEvents();
	}

	public void initComponent() {
		this.setPreferredSize(new Dimension(1100, 700));
//		this.setBackground(Color.red);
		this.setLayout(null);

		tkt = new ThongKeTop();
		tkd = new ThongKeDown();
		tkct = new ThongKeChiTiet();
		tkt.getBtnView().setBackground(Color.white);
		tkct.getBtnBack().setBackground(Color.white);
		this.add(tkt);
		this.add(tkd);
		this.add(tkct);
		this.setVisible(false);
	}
	
	private void addEvents() {
		tkt.getBtnView().addActionListener(ac);
		tkct.getBtnBack().addActionListener(ac);
		ThongKeTop.lbLapPhieukk.addMouseListener(mouse);
		ThongKeTop.cblistPKK.addActionListener(ac);
		ThongKeChiTiet.cbnam.addActionListener(ac);
		ThongKeChiTiet.cbthang.addActionListener(ac);
		ThongKeTop.lbThongKeTheoKhoangThoiGian.addMouseListener(mouse);
		ThongKeTop.lbThongKeTheoNV.addMouseListener(mouse);
		ThongKeDown.cbListNV.addActionListener(ac);
		ThongKeDown.spnTuNgay.addChangeListener(change);
		ThongKeDown.spnDenNgay.addChangeListener(change);
		ThongKeTop.btnRefresh.addMouseListener(mouse);
	}

	public void xuLySuKienBtnView() {
		tkct.veLaiChart();
		tkct.setVisible(true);
		tkt.setVisible(false);
		tkd.setVisible(false);
	}

	public void xuLySuKienBtnBack() {
		tkct.setVisible(false);
		tkt.setVisible(true);
		tkd.setVisible(true);
	}
	public void xuLySuKienRefresh() {
		tkt.layDuLieuThongKe();
		tkd.layDuLieuThongKe();
		tkct.veLaiChart();
		tkct.xuLyHienThiSanPhamBanChay();
	}
	
	public ThongKeTop getTkt() {
		return tkt;
	}

	public void setTkt(ThongKeTop tkt) {
		this.tkt = tkt;
	}

	public ThongKeDown getTkd() {
		return tkd;
	}

	public void setTkd(ThongKeDown tkd) {
		this.tkd = tkd;
	}

	public ThongKeChiTiet getTkct() {
		return tkct;
	}

	public void setTkct(ThongKeChiTiet tkct) {
		this.tkct = tkct;
	}
	
}
