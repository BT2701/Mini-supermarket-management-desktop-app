package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import BUS.KhachHangBUS;
import DTO.DTO_KhachHang;

public class DiaLogThemKhachHangGUI extends JDialog{
	private JLabel lbNhapTen,lbNhapDiaChi,lbtittle;
	private JLabel lbThemKH;
	private JTextField tfNhapTen,tfNhapDiachi;
	private Font font = new Font("Tahoma", Font.BOLD, 25);
	private Font fontItems = new Font("Tahoma",0, 15);
	private Color btnoldColor=new Color(52, 152, 219);
	private Color btnhoverColor=new Color(116, 185, 255);
	public DiaLogThemKhachHangGUI() {
		initComponent();
	}
	public void initComponent() {
		this.setSize(400, 230);
		this.setLayout(null);
		this.setModal(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		lbtittle=new JLabel("Nhập thông tin khách hàng",JLabel.CENTER);
		lbtittle.setBounds(0, 10, 400, 50);
		lbtittle.setFont(font);
		
		
		lbNhapTen=new JLabel("Nhập tên");
		lbNhapTen.setBounds(20, 70, 120, 30);
		lbNhapTen.setFont(fontItems);
		
		lbNhapDiaChi=new JLabel("Nhập DC");
		lbNhapDiaChi.setBounds(20, 110, 120, 30);
		lbNhapDiaChi.setFont(fontItems);
		
		tfNhapTen=new JTextField();
		tfNhapTen.setBounds(150, 70, 230, 30);
		tfNhapTen.setFont(fontItems);
		
		tfNhapDiachi=new JTextField();
		tfNhapDiachi.setBounds(150, 110, 230, 30);
		tfNhapDiachi.setFont(fontItems);
		
		lbThemKH=new JLabel("Thêm khách hàng");
		lbThemKH.setBounds(100, 150, 150, 30);
		lbThemKH.setFont(fontItems);
		lbThemKH.setOpaque(true);
		lbThemKH.setBackground(btnoldColor);
		lbThemKH.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				xuLyThemKH();
			}
			public void mouseEntered(MouseEvent e) {
				lbThemKH.setBackground(btnhoverColor);
			}
			public void mouseExited(MouseEvent e) {
				lbThemKH.setBackground(btnoldColor);
			}
		});
		
		
		this.add(lbNhapDiaChi);
		this.add(lbNhapTen);
		this.add(lbtittle);
		this.add(tfNhapDiachi);
		this.add(tfNhapTen);
		this.add(lbThemKH);
		
		this.setVisible(true);
	}
	public void xuLyThemKH() {
		String tenKH=tfNhapTen.getText().toString();
		if(tenKH.equalsIgnoreCase("")) {
			new ThongBaoDialog("Mời nhập họ và tên", ThongBaoDialog.ERROR_DIALOG);
			return;
		}
		String diaChi=tfNhapDiachi.getText().toString();
		int maKHnew =KhachHangBUS.getIntance().getMaKHmoiNhat();
		maKHnew++;
		String maKH=maKHnew+"";
		DTO_KhachHang kh=new DTO_KhachHang(maKH, tenKH, diaChi, new Date(), new Date(), 0);
		KhachHangBUS.getIntance().inSert(kh);
		dispose();
//		new ThongBaoDialog("Thêm thành công", ThongBaoDialog.SUCCESS_DIALOG);
	}
}
