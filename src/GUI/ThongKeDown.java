package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;

import BUS.CTHoaDonBUS;
import BUS.HoaDonBUS;
import BUS.NhanVienBUS;

public class ThongKeDown extends JPanel{
	public static JLabel tittle;
	private Border lineBorder = BorderFactory.createLineBorder(Color.gray, 1);
	private JLabel soLuongMH,hienSoLuong;
	private JLabel doanhThu,hienDoanhThu;
	private String[] listNV= {"Chọn nhân viên"};
	public static JComboBox<String> cbListNV;
	private SpinnerDateModel dateModel,dateModel1;
	public static JSpinner spnTuNgay;
	public static JSpinner spnDenNgay;
	private Font font = new Font("Tahoma", Font.BOLD, 25);
	private Font fontItems = new Font("Tahoma", Font.BOLD, 15);
	private DecimalFormat dcf = new DecimalFormat("###,###");
	private SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	public ThongKeDown() {
		initComponent();
		this.setVisible(true);
	}
	public void initComponent() {
		this.setLayout(null);
		this.setBounds(0,500,1100,200);
		this.setBackground(Color.white);
		this.setBorder(lineBorder);
		
		soLuongMH=new JLabel("Số lượng bán hàng: ",JLabel.LEFT);
		soLuongMH.setBounds(90, 70, 500, 50);
		soLuongMH.setFont(font);
		
		hienSoLuong=new JLabel("1",JLabel.LEFT);
		hienSoLuong.setBounds(590, 70, 250, 50);
		hienSoLuong.setFont(font);
		
		doanhThu=new JLabel("Doanh thu bán hàng: ",JLabel.LEFT);
		doanhThu.setFont(font);
		doanhThu.setBounds(90,130,500,50);
		
		hienDoanhThu=new JLabel("1",JLabel.LEFT);
		hienDoanhThu.setBounds(590, 130, 250, 50);
		hienDoanhThu.setFont(font);
		
		tittle=new JLabel("Tổng doanh thu",JLabel.CENTER);
		tittle.setBounds(400, 20, 300, 30);
		tittle.setFont(font);
		
		//thống kê theo ngày
		dateModel=new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
		spnTuNgay=new JSpinner(dateModel);
		spnTuNgay.setFont(fontItems);
		spnTuNgay.setBounds(360, 20, 180, 30);
		JSpinner.DateEditor editor1 = new JSpinner.DateEditor(spnTuNgay, "dd/MM/yyyy");
		spnTuNgay.setEditor(editor1);
		spnTuNgay.setVisible(false);
		
		dateModel1=new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
		spnDenNgay=new JSpinner(dateModel1);
		spnDenNgay.setFont(fontItems);
		spnDenNgay.setBounds(560, 20, 180, 30);
		JSpinner.DateEditor editor2 = new JSpinner.DateEditor(spnDenNgay, "dd/MM/yyyy");
		spnDenNgay.setEditor(editor2);
		spnDenNgay.setVisible(false);
		
		//thống kê theo nhân viên
		cbListNV=new JComboBox<String>();
		getDSPhieuNV();
		cbListNV.setBounds(400, 20, 300, 30);
		cbListNV.setFont(fontItems);
		cbListNV.setVisible(false);
		
		layDuLieuThongKe();
		
		this.add(tittle);
		this.add(spnTuNgay);
		this.add(spnDenNgay);
		this.add(cbListNV);
		this.add(doanhThu);
		this.add(soLuongMH);
		this.add(hienDoanhThu);
		this.add(hienSoLuong);
	}
	public void themPhanTuVaoMangNV(String s) {
		int l=listNV.length;
		listNV=Arrays.copyOf(listNV, l+1);
		listNV[l]=s;
	}
	public void getDSPhieuNV() {

		for (String maVaTen : NhanVienBUS.getIntance().getListMaVaTen()) {
			themPhanTuVaoMangNV(maVaTen);
		}
		DefaultComboBoxModel<String> cbmodel = new DefaultComboBoxModel<>(listNV);
		cbListNV.setModel(cbmodel);
		listNV = new String[0];
		themPhanTuVaoMangNV("Chọn nhân viên");
	}
	public void layDuLieuThongKe() {
		int soLuong=CTHoaDonBUS.getIntance().getTongSoLuongBanHang();
		double tongDoanhThu=HoaDonBUS.getIntance().getTongDoanhThu();
		soLuongMH.setText("Số lượng bán hàng: ");
		hienSoLuong.setText(soLuong+" Sản Phẩm");
		hienDoanhThu.setText(dcf.format(tongDoanhThu)+" VND");
	}
	public String layMa(String maVaTen) {
		String []a=maVaTen.split(" - ");
		return a[0];
		
	}
	public String layTen(String maVaTen) {
		String []a=maVaTen.split(" - ");
		return a[1];
	}
	public void layDuLieuThongKeTheoNV() {
		if(cbListNV.getSelectedIndex()==0) {
			layDuLieuThongKe();
			soLuongMH.setText("Số lượng bán hàng: ");
		}
		else {
			String maVaTen=cbListNV.getSelectedItem().toString();
			String maNV=layMa(maVaTen);
			int soLuong=CTHoaDonBUS.getIntance().getTongSoLuongBanHangTheoNV(maNV);
			double tongDoanhThu=HoaDonBUS.getIntance().getTongDoanhThuTheoNV(maNV);
			soLuongMH.setText(layTen(maVaTen)+" đã bán: ");
			hienSoLuong.setText(soLuong+" Sản phẩm");
			hienDoanhThu.setText(dcf.format(tongDoanhThu)+" VND");
		}
		
	}
	public void layDuLieuThongKeTheoKhoangThoiGian() {
		Date fromdate= (Date)spnTuNgay.getValue();
		Date todate= (Date)spnDenNgay.getValue();
		int soLuong=CTHoaDonBUS.getIntance().getTongSoLuongBanHangTheoNgay(fromdate, todate);
		double tongDoanhThu=HoaDonBUS.getIntance().thongKeTheoKhoangThoiGian(fromdate, todate);
		soLuongMH.setText(sdf.format(fromdate)+" - "+sdf.format(todate)+" đã bán:");
		hienSoLuong.setText(soLuong+" Sản phẩm");
		hienDoanhThu.setText(dcf.format(tongDoanhThu)+" VND");
	}
}
