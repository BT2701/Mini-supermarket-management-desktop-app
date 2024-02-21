package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import BUS.CTHoaDonBUS;
import BUS.HoaDonBUS;
import BUS.KhachHangBUS;
import BUS.MatHangBUS;
import BUS.NhanVienBUS;
import DTO.CTHoaDon;
import DTO.DonViDTO;
import DTO.HoaDon;
import DTO.MatHangDTO;


public class HoaDonGUI extends JPanel{
	private JLabel lbTittle,lbMaHD,lbMaKH,lbNV,lbNgLap,lbTongTien,lbDiemThuong,lbChonNgay,lbChonGia,lbDenNgay,lbDenGia;
	public static JLabel lbTimTheoTime,lbTimTheoPrince;
	private JTextField tfmahd,tfmakh,tfnv,tfnglap,tftongtien,tfDiemThuong,tfGiaTu,tfDenGia;
	private JLabel btnChange;
	private String []tbHeader= {"Mã hóa đơn","Mã nhân viên","Ngày lập","Giảm giá(%)","Mã khách hàng","Tổng tiền"};
	private String [][]tbElements=null;
	private DefaultTableModel modelHD;
	private JTable tbHoaDon;
	private JScrollPane scrHoaDon;
	private String []TTHD=new String[0];
	private Font fontTittle = new Font("Tahoma", Font.BOLD, 25);
	private Font fontItems = new Font("Tahoma", 0, 15);
	private DecimalFormat dcf = new DecimalFormat("###,###");
	private SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
//	private JDateChooser dateChooer;
	private SpinnerDateModel dateModel;
	private SpinnerDateModel dateModel1;
	private JSpinner spnDate;
	private JSpinner spnDate1;
	public static JButton btnTimkiem,btnTimkiem1;
	private Color btnoldColor=new Color(52, 152, 219);
	private Color texfieldColor=new Color(45, 52, 54);
	public static String maHDselected="";
	public static JLabel btndelete,btnInHoaDon;
	private JEditorPane txtHoaDon;
	public HoaDonGUI() {
		initCoponent();
	}
	public void initCoponent() {
		this.setBounds(0, 40, 1100, 660);
		this.setLayout(null);
		
		lbTittle=new JLabel("Thông tin hóa đơn",JLabel.CENTER);
		lbTittle.setBounds(400, 10, 300, 50);
		lbTittle.setFont(fontTittle);
		
		lbMaHD=new JLabel("Mã hóa đơn");
		lbMaHD.setBounds(150, 70, 120, 30);
		lbMaHD.setFont(fontItems);
		
		tfmahd=new JTextField(JTextField.CENTER);
		tfmahd.setBounds(280, 70, 200, 30);
		tfmahd.setFont(fontItems);
		tfmahd.setDisabledTextColor(texfieldColor);
		tfmahd.setEnabled(false);
		
		lbMaKH=new JLabel("Mã khách hàng");
		lbMaKH.setBounds(620, 70, 120, 30);
		lbMaKH.setFont(fontItems);
		
		tfmakh=new JTextField(JTextField.CENTER);
		tfmakh.setBounds(740, 70, 200, 30);
		tfmakh.setFont(fontItems);
		tfmakh.setDisabledTextColor(texfieldColor);
		tfmakh.setEnabled(false);
		
		lbNV=new JLabel("Nhân viên lập");
		lbNV.setBounds(150, 110, 120, 30);
		lbNV.setFont(fontItems);
		
		tfnv=new JTextField(JTextField.CENTER);
		tfnv.setBounds(280, 110, 200, 30);
		tfnv.setFont(fontItems);
		tfnv.setDisabledTextColor(texfieldColor);
		tfnv.setEnabled(false);
		
		lbNgLap=new JLabel("Ngày lập");
		lbNgLap.setBounds(620, 110, 120, 30);
		lbNgLap.setFont(fontItems);
		
		tfnglap=new JTextField(JTextField.CENTER);
		tfnglap.setBounds(740, 110, 200, 30);
		tfnglap.setFont(fontItems);
		tfnglap.setDisabledTextColor(texfieldColor);
		tfnglap.setEnabled(false);
		
		lbTongTien=new JLabel("Tổng tiền");
		lbTongTien.setBounds(150, 150, 120, 30);
		lbTongTien.setFont(fontItems);
		
		tftongtien=new JTextField(JTextField.CENTER);
		tftongtien.setBounds(280, 150, 200, 30);
		tftongtien.setFont(fontItems);
		tftongtien.setDisabledTextColor(texfieldColor);
		tftongtien.setEnabled(false);
		
		lbDiemThuong=new JLabel("Điểm thưởng");
		lbDiemThuong.setBounds(620, 150, 120, 30);
		lbDiemThuong.setFont(fontItems);
		
		tfDiemThuong=new JTextField(JTextField.CENTER);
		tfDiemThuong.setBounds(740, 150, 200, 30);
		tfDiemThuong.setFont(fontItems);
		tfDiemThuong.setDisabledTextColor(texfieldColor);
		tfDiemThuong.setEnabled(false);
		
		btnChange=new JLabel(new ImageIcon("./src/IMG/Refresh-icon.png"));
		btnChange.setBounds(710, 20, 30, 30);
		btnChange.setFont(fontItems);
		btnChange.setOpaque(true);
		
		//lựa chọn tìm kiếm hóa đơn
		lbTimTheoTime=new JLabel("Tìm hóa đơn theo thời gian",JLabel.CENTER);
		lbTimTheoTime.setFont(fontItems);
		lbTimTheoTime.setBounds(340, 200, 200, 30);
		lbTimTheoTime.setOpaque(true);
		lbTimTheoTime.setBackground(btnoldColor);
		
		lbTimTheoPrince=new JLabel("Tìm hóa đơn theo khoảng giá",JLabel.CENTER);
		lbTimTheoPrince.setFont(fontItems);
		lbTimTheoPrince.setBounds(560, 200, 200, 30);
		lbTimTheoPrince.setOpaque(true);
		lbTimTheoPrince.setBackground(btnoldColor);
		
		
		//tìm kiếm hóa đơn theo ngày
		lbChonNgay=new JLabel("Ngày từ: ");
		lbChonNgay.setBounds(160, 240, 120, 30);
		lbChonNgay.setFont(fontItems);
		lbChonNgay.setVisible(false);
		
		lbDenNgay=new JLabel("đến ngày",JLabel.CENTER);
		lbDenNgay.setBounds(500, 240, 100, 30);
		lbDenNgay.setFont(fontItems);
		lbDenNgay.setVisible(false);
		
		dateModel=new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
		spnDate=new JSpinner(dateModel);
		spnDate.setFont(fontItems);
		spnDate.setBounds(290, 240, 200, 30);
		JSpinner.DateEditor editor = new JSpinner.DateEditor(spnDate, "dd/MM/yyyy");
		spnDate.setEditor(editor);
		spnDate.setVisible(false);
		
		dateModel1=new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
		spnDate1=new JSpinner(dateModel1);
		spnDate1.setFont(fontItems);
		spnDate1.setBounds(610, 240, 200, 30);
		JSpinner.DateEditor editor1 = new JSpinner.DateEditor(spnDate1, "dd/MM/yyyy");
		spnDate1.setEditor(editor1);
		spnDate1.setVisible(false);
		
		btnTimkiem=new JButton("Tìm kiếm");
		btnTimkiem.setBounds(820, 240, 120, 30);
		btnTimkiem.setFont(fontItems);
		btnTimkiem.setBackground(btnoldColor);
		btnTimkiem.setVisible(false);
		
		//tìm kiếm hóa đơn theo khoảng giá
		lbChonGia=new JLabel("Giá từ: ");
		lbChonGia.setBounds(160, 240, 120, 30);
		lbChonGia.setFont(fontItems);
		lbChonGia.setVisible(false);
		
		lbDenGia=new JLabel("đến giá",JLabel.CENTER);
		lbDenGia.setBounds(500, 240, 100, 30);
		lbDenGia.setFont(fontItems);
		lbDenGia.setVisible(false);
		
		tfGiaTu=new JTextField();
		tfGiaTu.setFont(fontItems);
		tfGiaTu.setBounds(290, 240, 200, 30);
		tfGiaTu.setVisible(false);
		
		tfDenGia=new JTextField();
		tfDenGia.setFont(fontItems);
		tfDenGia.setBounds(610, 240, 200, 30);
		tfDenGia.setVisible(false);
		
		btnTimkiem1=new JButton("Tìm kiếm");
		btnTimkiem1.setBounds(820, 240, 120, 30);
		btnTimkiem1.setFont(fontItems);
		btnTimkiem1.setBackground(btnoldColor);
		btnTimkiem1.setVisible(false);
		
		
		//table hóa đơn
		modelHD=new DefaultTableModel(tbElements, tbHeader);
		
		tbHoaDon=new JTable(modelHD);
		tbHoaDon.setFont(new Font("Tahoma", Font.BOLD, 15));
		tbHoaDon.getTableHeader().setForeground(Color.white);
		tbHoaDon.getTableHeader().setBackground(new Color(52, 152, 219));
		tbHoaDon.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));
		tbHoaDon.getTableHeader().setPreferredSize(new Dimension(700,30));
		tbHoaDon.setRowHeight(25);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		tbHoaDon.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tbHoaDon.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tbHoaDon.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tbHoaDon.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tbHoaDon.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		
		getDSHDALL();
		
		scrHoaDon=new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrHoaDon.setBounds(100, 280, 900, 330);
		scrHoaDon.setViewportView(tbHoaDon);
		
		btndelete = new JLabel();
		btndelete.setIcon(new ImageIcon("./src/IMG/btnDelete_150px.png"));
		btndelete.setBounds(325, 610, 200, 50);
		btndelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btndelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				xuLyXoaHoaDon();
			}
		});
		txtHoaDon =new JEditorPane();
		btnInHoaDon = new JLabel();
		btnInHoaDon.setIcon(new ImageIcon("./src/IMG/in.jpg"));
		btnInHoaDon.setBounds(575, 610, 200, 50);
		btnInHoaDon.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnInHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row =tbHoaDon.getSelectedRow();
				if(row<0) {
					new ThongBaoDialog("Chọn hóa đơn", ThongBaoDialog.ERROR_DIALOG);
					return;
				}
				String maHd=tbHoaDon.getValueAt(row, 0).toString();
				String manv=tbHoaDon.getValueAt(row, 1).toString();
				String tenNV=NhanVienBUS.getIntance().layTenNVtheoMA(manv);
				String ngayLap=tbHoaDon.getValueAt(row, 2).toString();
				String diemThuong=tbHoaDon.getValueAt(row, 3).toString();
				int diemThuongvalue=Integer.parseInt(diemThuong);
				double tongTienBanDau=CTHoaDonBUS.getIntance().layTongTienTheoMaHD(maHd);
				String tongTienBD=dcf.format(tongTienBanDau)+" VND";
				String soTienGiam= dcf.format((diemThuongvalue*tongTienBanDau)/100)+" VND";
				String maKH=tbHoaDon.getValueAt(row, 4).toString();
				String tenKH=KhachHangBUS.getIntance().layTenBangMa(maKH);
				String tongTien=tbHoaDon.getValueAt(row, 5).toString()+" VND";
				xuLyHienThiHoaDon(maHd, tenNV, ngayLap, tenKH, diemThuong, soTienGiam, tongTien,tongTienBD);
				btnInHoaDonActionPerformed(e);
			}
		});
		
		
		this.add(btnInHoaDon);
		this.add(btnTimkiem1);
		this.add(lbChonGia);
		this.add(lbDenGia);
		this.add(lbDenNgay);
		this.add(lbTimTheoPrince);
		this.add(lbTimTheoTime);
		this.add(spnDate1);
		this.add(tfDenGia);
		this.add(tfGiaTu);
		this.add(lbTittle);
		this.add(lbMaHD);
		this.add(lbMaKH);
		this.add(lbNV);
		this.add(lbNgLap);
		this.add(lbTongTien);
		this.add(lbDiemThuong);
		this.add(tfmahd);
		this.add(tfmakh);
		this.add(tfnv);
		this.add(tfnglap);
		this.add(tftongtien);
		this.add(tfDiemThuong);
		this.add(btnChange);
		this.add(scrHoaDon);
		this.add(lbChonNgay);
		this.add(btndelete);
//		this.add(dateChooer);
		this.add(spnDate);
		this.add(btnTimkiem);
		
		
		this.setVisible(false);
	}
	public void themPhanTuVaoMangTTHD(String s) {
		int l=TTHD.length;
		TTHD=Arrays.copyOf(TTHD, l+1);
		TTHD[l]=s;
	}
	public void getDSHDALL() {
//		"Mã hóa đơn", "Mã nhân viên", "Ngày lập", "Điểm thưởng", "Mã khách hàng"," Tổng tiền "
		DefaultTableModel model = (DefaultTableModel) tbHoaDon.getModel();
		for (HoaDon hoaDon : HoaDonBUS.getIntance().getList()) {
			if(hoaDon.getTrangThai()==1) {
				Vector<String> vec=new Vector<>();
				vec.add(hoaDon.getMaHD());
				vec.add(hoaDon.getMaNV());
				vec.add(sdf.format(hoaDon.getDate()));
				vec.add(hoaDon.getDiemThuong()+"");
				vec.add(hoaDon.getMaKH());
				vec.add(dcf.format(hoaDon.getTongTienPhaiTra()));
				model.addRow(vec);
			}
		}
	}
	public void delTableHoaDon() {
		DefaultTableModel model=(DefaultTableModel) tbHoaDon.getModel();
		model.setRowCount(0);
	}
	public void xuLySuKienTableHoaDon() {
		int row=tbHoaDon.getSelectedRow();
		maHDselected=tbHoaDon.getValueAt(row, 0)+"";
		tfmahd.setText(maHDselected);
		tfnv.setText(tbHoaDon.getValueAt(row, 1)+"");
		tfnglap.setText(tbHoaDon.getValueAt(row, 2)+"");
		tfDiemThuong.setText(tbHoaDon.getValueAt(row, 3)+"");
		tfmakh.setText(tbHoaDon.getValueAt(row, 4)+"");
		tftongtien.setText(tbHoaDon.getValueAt(row, 5)+" VND");
		
	}
//	public void layDanhSachHdTheoNgay(Date date) {
//		DefaultTableModel model = (DefaultTableModel) tbHoaDon.getModel();
//		for(int i=0;i<HoaDonBUS.getIntance().getListByDate(date).size();i++) {
//			themPhanTuVaoMangTTHD(HoaDonBUS.getIntance().getListByDate(date).get(i).getMaHD());
//			themPhanTuVaoMangTTHD(HoaDonBUS.getIntance().getListByDate(date).get(i).getMaNV());
//			themPhanTuVaoMangTTHD(sdf.format(HoaDonBUS.getIntance().getListByDate(date).get(i).getDate()));
//			themPhanTuVaoMangTTHD(HoaDonBUS.getIntance().getListByDate(date).get(i).getDiemThuong()+"");
//			themPhanTuVaoMangTTHD(HoaDonBUS.getIntance().getListByDate(date).get(i).getMaKH());
//			themPhanTuVaoMangTTHD(dcf.format(HoaDonBUS.getIntance().getListByDate(date).get(i).getTongTienPhaiTra()));
//			model.addRow(TTHD);
//			TTHD= new String[0];
//		}
//	}
	public void xuLyXoaHoaDon() {
		int row= tbHoaDon.getSelectedRow();
		if(row<0) {
			new ThongBaoDialog("Chọn hóa đơn", ThongBaoDialog.ERROR_DIALOG);
			return;
		}
		String maHD=tbHoaDon.getValueAt(row, 0).toString();
		HoaDonBUS.getIntance().thayDoiTrangThai(maHD, 0);
		new ThongBaoDialog("Xóa hóa đơn thành công", ThongBaoDialog.SUCCESS_DIALOG);
		delTableHoaDon();
		getDSHDALL();
	}
	public void xuLyBtnSearchPrice() {
		lbChonNgay.setVisible(false);
		spnDate.setVisible(false);
		spnDate1.setVisible(false);
		lbDenNgay.setVisible(false);
		btnTimkiem.setVisible(false);
		
		lbChonGia.setVisible(true);
		tfGiaTu.setVisible(true);
		tfDenGia.setVisible(true);
		lbDenGia.setVisible(true);
		btnTimkiem1.setVisible(true);
	}
	public void xuLyBtnSearchTime() {
		lbChonNgay.setVisible(true);
		spnDate.setVisible(true);
		spnDate1.setVisible(true);
		lbDenNgay.setVisible(true);
		btnTimkiem.setVisible(true);
		
		lbChonGia.setVisible(false);
		tfGiaTu.setVisible(false);
		tfDenGia.setVisible(false);
		lbDenGia.setVisible(false);
		btnTimkiem1.setVisible(false);
	}
	public void layDanhSachHoaDonTheoThoiGian(Date tuNgay,Date denNgay) {
		DefaultTableModel model = (DefaultTableModel) tbHoaDon.getModel();
		for (HoaDon hoaDon : HoaDonBUS.getIntance().layDsHoaDonTheoKhoangThoiGian(tuNgay, denNgay)) {
			themPhanTuVaoMangTTHD(hoaDon.getMaHD());
			themPhanTuVaoMangTTHD(hoaDon.getMaNV());
			themPhanTuVaoMangTTHD(sdf.format(hoaDon.getDate()));
			themPhanTuVaoMangTTHD(hoaDon.getDiemThuong()+"");
			themPhanTuVaoMangTTHD(hoaDon.getMaKH());
			themPhanTuVaoMangTTHD(dcf.format(hoaDon.getTongTienPhaiTra()));
			model.addRow(TTHD);
			TTHD= new String[0];
		}
	}
	public void layDanhSachHoaDonTheoKhoangGia(double giaTu,double denGia) {
		DefaultTableModel model = (DefaultTableModel) tbHoaDon.getModel();
		for (HoaDon hoaDon : HoaDonBUS.getIntance().layDsHoaDonTheoGia(giaTu, denGia)) {
			themPhanTuVaoMangTTHD(hoaDon.getMaHD());
			themPhanTuVaoMangTTHD(hoaDon.getMaNV());
			themPhanTuVaoMangTTHD(sdf.format(hoaDon.getDate()));
			themPhanTuVaoMangTTHD(hoaDon.getDiemThuong()+"");
			themPhanTuVaoMangTTHD(hoaDon.getMaKH());
			themPhanTuVaoMangTTHD(dcf.format(hoaDon.getTongTienPhaiTra()));
			model.addRow(TTHD);
			TTHD= new String[0];
		}
	}
	public void xuLySuKienTimKiemHoaDonTheoNgay() {
		Date tuNgay=(Date)spnDate.getValue();
		Date denNgay=(Date)spnDate1.getValue();
		System.out.println(sdf.format(tuNgay));
		System.out.println(sdf.format(denNgay));
//		System.out.println(sdf.format(date));
		delTableHoaDon();
		layDanhSachHoaDonTheoThoiGian(tuNgay, denNgay);
		tfDiemThuong.setText(null);
		tfmahd.setText(null);
		tfmakh.setText(null);
		tfnglap.setText(null);
		tfnv.setText(null);
		tftongtien.setText(null);
		
	}
	public void xuLySuKienTimKiemHoaDonTheoKhoangGia() {
		if(CheckLoi.isDouble(tfGiaTu.getText().toString())==false || CheckLoi.isDouble(tfDenGia.getText().toString())==false) {
			new ThongBaoDialog("Khoảng giá không khả dụng", ThongBaoDialog.ERROR_DIALOG);
			tfGiaTu.setText("");
			tfDenGia.setText("");
			return;
		}
		double giaTu=Double.parseDouble(tfGiaTu.getText().toString());
		double denGia=Double.parseDouble(tfDenGia.getText().toString());
//		System.out.println(sdf.format(date));
		delTableHoaDon();
		layDanhSachHoaDonTheoKhoangGia(giaTu, denGia);
		tfDiemThuong.setText(null);
		tfmahd.setText(null);
		tfmakh.setText(null);
		tfnglap.setText(null);
		tfnv.setText(null);
		tftongtien.setText(null);
		
	}
	public void xuLySuKienNutRefresh() {
		delTableHoaDon();
		getDSHDALL();
		tfDiemThuong.setText(null);
		tfmahd.setText(null);
		tfmakh.setText(null);
		tfnglap.setText(null);
		tfnv.setText(null);
		tftongtien.setText(null);
		
	}
	
	private void btnInHoaDonActionPerformed(MouseEvent evt) {
        try {
            if (!txtHoaDon.getText().equals("")) {
                txtHoaDon.print();
//                this.dispose();
            }
        } catch (PrinterException ex) {
        }
    }
	private void xuLyHienThiHoaDon(String maHD,String tenNV, String ngayLap,String tenKH,String diemThuong,String giamGia,String tongTien,String tongTienChuaGiam) {
        txtHoaDon.setContentType("text/html");
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//        LocalDateTime now = LocalDateTime.now();
        DecimalFormat dcf = new DecimalFormat("###,### VND");

        String hd = "<style> "
                + "table {"
                + "border: 1px solid;"
                + "border-bottom: none"
                + "}"
                + "tr {"
                + "border-bottom: 1px solid;"
                + "}"
                + "td {"
                + "padding: 8px;"
                + "} "
                + "th {"
                + "font-size:16pt"
                + "}"
                + "</style>";
        hd += "<h1 style='text-align:center;'>HOÁ ĐƠN THANH TOÁN</h1>";
        hd += "Nhân viên: " + tenNV + "<br/>";
        hd += "Ngày lập: " + ngayLap + "<br/>";
        hd += "Khách hàng: " + tenKH + "<br/>";
        hd += "<div style='text-align:center;'>==========================================</div><br/>";
        hd += "<div style='text-align:center'>";
        hd += "<table style='max-width:100%'>";
        hd += "<tr>"
                + "<th>Mã SP</th>"
                + "<th>Tên SP</th>"
                + "<th>Số lượng</th>"
                + "<th>Đơn giá</th>"
                + "<th>Thành tiền</th>"
                + "</tr>";
        for (CTHoaDon cthd : CTHoaDonBUS.getIntance().layDanhSachTheoMaHD(maHD)) {
        	String tenSP=MatHangBUS.getInstance().layTenSanPhamById(cthd.getMaMH());
        	
            hd += "<tr>";
            hd += "<td style='text-align:center;'>" + cthd.getMaMH() + "</td>";
            hd += "<td style='text-align:left;'>" + tenSP + "</td>";
            hd += "<td style='text-align:center;'>" + cthd.getSlMH() + "</td>";
            hd += "<td style='text-align:center;'>" + dcf.format(cthd.getDonGia()) + "</td>";
            hd += "<td style='text-align:center;'>" + dcf.format(cthd.getThanhTien()) + "</td>";
            hd += "</tr>";
        }
        hd += "<tr>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:left;'>" + "</td>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:center;font-weight:bold'>Tổng tiền</td>";
        hd += "<td style='text-align:center;'>" + tongTienChuaGiam  + "</td>";
        hd += "</tr>";
        hd += "<tr>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:left;'>" + "</td>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:center;font-weight:bold'>Khuyến mãi</td>";
        hd += "<td style='text-align:center;'>" + diemThuong + "%"+"</td>";
        hd += "</tr>";
//        if (timMaUI.maGiamTimDuoc != null) {
//            int percent = 0;
//            // lấy phần trăm giảm
//            percent = timMaUI.maGiamTimDuoc.getPhanTramGiam();
//            if (tongTien >= timMaUI.maGiamTimDuoc.getDieuKien()) {
//                tongTien = tongTien - (tongTien * percent / 100);
//            } else {
//                new MyDialog("Không đủ điều kiện nhận ưu đãi!", MyDialog.ERROR_DIALOG);
//                btnTimMaGiam.setEnabled(true);
//                return;
//            }
//        }
        hd += "<tr>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:left;'>" + "</td>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:center;font-weight:bold'>Giảm giá</td>";
        hd += "<td style='text-align:center;'>" + giamGia  + "</td>";
        hd += "</tr>";
        hd += "<tr>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:left;'>" + "</td>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:center;font-weight:bold'>Thành tiền</td>";
        hd += "<td style='text-align:center;'>" + tongTien + "</td>";
        hd += "</tr>";
        hd += "</table>";
        hd += "</div>";
        hd += "<div style='text-align:center;'>==========================================</div><br/>";
        txtHoaDon.setText(hd);
//        txtTongTien.setText(dcf.format(tongTien));
    }
	public JLabel getLbTittle() {
		return lbTittle;
	}
	public void setLbTittle(JLabel lbTittle) {
		this.lbTittle = lbTittle;
	}
	public JLabel getLbMaHD() {
		return lbMaHD;
	}
	public void setLbMaHD(JLabel lbMaHD) {
		this.lbMaHD = lbMaHD;
	}
	public JLabel getLbMaKH() {
		return lbMaKH;
	}
	public void setLbMaKH(JLabel lbMaKH) {
		this.lbMaKH = lbMaKH;
	}
	public JLabel getLbNV() {
		return lbNV;
	}
	public void setLbNV(JLabel lbNV) {
		this.lbNV = lbNV;
	}
	public JLabel getLbNgLap() {
		return lbNgLap;
	}
	public void setLbNgLap(JLabel lbNgLap) {
		this.lbNgLap = lbNgLap;
	}
	public JLabel getLbTongTien() {
		return lbTongTien;
	}
	public void setLbTongTien(JLabel lbTongTien) {
		this.lbTongTien = lbTongTien;
	}
	public JLabel getLbGhiChu() {
		return lbDiemThuong;
	}
	public void setLbGhiChu(JLabel lbGhiChu) {
		this.lbDiemThuong = lbGhiChu;
	}
	public JTextField getTfmahd() {
		return tfmahd;
	}
	public void setTfmahd(JTextField tfmahd) {
		this.tfmahd = tfmahd;
	}
	public JTextField getTfmakh() {
		return tfmakh;
	}
	public void setTfmakh(JTextField tfmakh) {
		this.tfmakh = tfmakh;
	}
	public JTextField getTfnv() {
		return tfnv;
	}
	public void setTfnv(JTextField tfnv) {
		this.tfnv = tfnv;
	}
	public JTextField getTfnglap() {
		return tfnglap;
	}
	public void setTfnglap(JTextField tfnglap) {
		this.tfnglap = tfnglap;
	}
	public JTextField getTftongtien() {
		return tftongtien;
	}
	public void setTftongtien(JTextField tftongtien) {
		this.tftongtien = tftongtien;
	}
	public JTextField getTfDiemThuong() {
		return tfDiemThuong;
	}
	public void setTfDiemThuong(JTextField tfghichu) {
		this.tfDiemThuong = tfghichu;
	}
	public JLabel getBtnChange() {
		return btnChange;
	}
	public void setBtnChange(JLabel btnChange) {
		this.btnChange = btnChange;
	}
	public JScrollPane getScrHoaDon() {
		return scrHoaDon;
	}
	public void setScrHoaDon(JScrollPane scrHoaDon) {
		this.scrHoaDon = scrHoaDon;
	}
	public Font getFontTittle() {
		return fontTittle;
	}
	public void setFontTittle(Font fontTittle) {
		this.fontTittle = fontTittle;
	}
	public Font getFontItems() {
		return fontItems;
	}
	public void setFontItems(Font fontItems) {
		this.fontItems = fontItems;
	}
	public JTable getTbHoaDon() {
		return tbHoaDon;
	}
	public void setTbHoaDon(JTable tbHoaDon) {
		this.tbHoaDon = tbHoaDon;
	}
	
	
	
}
