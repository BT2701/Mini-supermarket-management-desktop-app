package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import BUS.CTHoaDonBUS;
import BUS.HoaDonBUS;
import BUS.PhieuKiemKeBUS;
import BUS.MatHangBUS;

public class ThongKeChiTiet extends JPanel{
	public static ThongKeChiTiet getInstance() {
		return new ThongKeChiTiet();
	}
	JLabel[]lblMon=new JLabel[5];
	JLabel[]lblSoLuong=new JLabel[5];
	int x,y;
	JPanel pnChart;
	ChartPanel chartPanel;
	
	
	private JButton btnBack;
	public static JComboBox<String> cbnam;
	public static JComboBox<String> cbthang;
	private String[] listNam={"Chọn năm"};
	private String[] listThang= {"Chọn tháng"};
	private Font fontItems = new Font("Tahoma", Font.BOLD, 15);
	public ThongKeChiTiet() {
		initComponent();
		this.setVisible(false);
	}
	public void initComponent() {
		this.setBounds(0,0,1100,700);
		this.setLayout(null);
		this.setBackground(Color.white);
		JLabel lblBackgroundBang = new JLabel(new ImageIcon("./src/IMG/bangChiTiet.png"));
        lblBackgroundBang.setBounds(200, 10, 700, 363);
        this.add(lblBackgroundBang);
        lblMon[0] = new JLabel("0");
        lblMon[1] = new JLabel("0");
        lblMon[2] = new JLabel("0");
        lblMon[3] = new JLabel("0");
        lblMon[4] = new JLabel("0");
        lblSoLuong[0] = new JLabel("0", JLabel.CENTER);
        lblSoLuong[1] = new JLabel("0", JLabel.CENTER);
        lblSoLuong[2] = new JLabel("0", JLabel.CENTER);
        lblSoLuong[3] = new JLabel("0", JLabel.CENTER);
        lblSoLuong[4] = new JLabel("0", JLabel.CENTER);
        
        x = 300;
        y = 120;
        lblMon[0].setBounds(x, y, 493, 50);
        lblMon[1].setBounds(x, y += 50, 493, 50);
        lblMon[2].setBounds(x, y += 50, 493, 50);
        lblMon[3].setBounds(x, y += 50, 493, 50);
        lblMon[4].setBounds(x, y += 50, 493, 50);
        x = 760;
        y = 120;
        lblSoLuong[0].setBounds(x, y, 128, 50);
        lblSoLuong[1].setBounds(x, y += 50, 128, 50);
        lblSoLuong[2].setBounds(x, y += 50, 128, 50);
        lblSoLuong[3].setBounds(x, y += 50, 128, 50);
        lblSoLuong[4].setBounds(x, y += 50, 128, 50);
        
        lblMon[0].setForeground(Color.BLACK);
        lblMon[1].setForeground(Color.BLACK);
        lblMon[2].setForeground(Color.BLACK);
        lblMon[3].setForeground(Color.BLACK);
        lblMon[4].setForeground(Color.BLACK);
        lblSoLuong[0].setForeground(Color.BLACK);
        lblSoLuong[1].setForeground(Color.BLACK);
        lblSoLuong[2].setForeground(Color.BLACK);
        lblSoLuong[3].setForeground(Color.BLACK);
        lblSoLuong[4].setForeground(Color.BLACK);

        Font fontChiTiet = new Font("Tahoma", Font.BOLD, 18);
        lblMon[0].setFont(fontChiTiet);
        lblMon[1].setFont(fontChiTiet);
        lblMon[2].setFont(fontChiTiet);
        lblMon[3].setFont(fontChiTiet);
        lblMon[4].setFont(fontChiTiet);
        lblSoLuong[0].setFont(fontChiTiet);
        lblSoLuong[1].setFont(fontChiTiet);
        lblSoLuong[2].setFont(fontChiTiet);
        lblSoLuong[3].setFont(fontChiTiet);
        lblSoLuong[4].setFont(fontChiTiet);
        
        btnBack = new JButton(new ImageIcon("./src/IMG/icons8_undo_40px.png"));
        btnBack.setToolTipText("Quay lại");
        btnBack.setBounds(10, 10, 45, 45);
        
        cbnam=new JComboBox<String>();
		getDSPhieuNam();
		cbnam.setBounds(350, 390, 180, 30);
		cbnam.setFont(fontItems);
		
		cbthang=new JComboBox<String>();
		getDSPhieuThang();
		cbthang.setBounds(570, 390, 180, 30);
		cbthang.setFont(fontItems);
		xuLyHienThiSanPhamBanChay();

		this.add(cbnam);
		this.add(cbthang);
        for(int i=0;i<5;i++) {
        	this.add(lblMon[i]);
        	this.add(lblSoLuong[i]);
        }
        this.add(btnBack);
        //========BIỂU ĐỒ CỘT=============
        pnChart = new JPanel();
        pnChart.setOpaque(false);
        pnChart.setBounds(0, 430, 1100, 250);

        chartPanel = new ChartPanel(createChart());
        chartPanel.setPreferredSize(new Dimension(1100, 250));

        pnChart.add(chartPanel);
        //================================
        this.add(pnChart);

	}
	public void themPhanTuVaoMangNam(String s) {
		int l=listNam.length;
		listNam=Arrays.copyOf(listNam, l+1);
		listNam[l]=s;
	}
	public void getDSPhieuNam() {

		for (int i=2020;i<=Calendar.getInstance().get(Calendar.YEAR);i++) {
			themPhanTuVaoMangNam("Năm "+i);
		}
		DefaultComboBoxModel<String> cbmodel = new DefaultComboBoxModel<>(listNam);
		cbnam.setModel(cbmodel);
		listNam = new String[0];
		themPhanTuVaoMangNam("Chọn năm");
	}
	
	public void themPhanTuVaoMangThang(String s) {
		int l=listThang.length;
		listThang=Arrays.copyOf(listThang, l+1);
		listThang[l]=s;
	}
	public void getDSPhieuThang() {

		for (int i=1;i<=12;i++) {
			themPhanTuVaoMangThang("Tháng "+i);
		}
		DefaultComboBoxModel<String> cbmodel = new DefaultComboBoxModel<>(listThang);
		cbthang.setModel(cbmodel);
		listThang = new String[0];
		themPhanTuVaoMangThang("Chọn Tháng");
	}
	
	public void veLaiChart() {
		chartPanel.setChart(createChart());

    }
	private JFreeChart createChart() {
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Doanh thu tháng " + (Calendar.getInstance().get(Calendar.MONTH)+1)+" năm "+ Calendar.getInstance().get(Calendar.YEAR),
                "Ngày", "Doanh thu",
                createDataset(), PlotOrientation.VERTICAL, false, false, false);
        return lineChart;
    }
	private CategoryDataset createDataset() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int nam=Calendar.getInstance().get(Calendar.YEAR);
        int thang=Calendar.getInstance().get(Calendar.MONTH)+1;
        // lấy chính xác số ngày trong tháng của 1 năm nào đó
        int soNgay=	LocalDate.of(nam,thang,1).lengthOfMonth()	;
        for (int i = 1; i <= soNgay; i++) {
            double value = HoaDonBUS.getIntance().layDoanhThuTheoNgayChart(nam, thang, i);
//            đặt tạm giá trị
        	dataset.addValue(value, "Doanh thu", i + "");
        }
        return dataset;
    }
	public String getValue(String item) {
		String[]a=item.split(" ");
		return a[1];
	}
	public void xuLySuKienBieuDoTheoThoiGian() {
		if(cbnam.getSelectedIndex()==0) {
			new ThongBaoDialog("Chưa chọn năm", ThongBaoDialog.WARNING_DIALOG);
			return;
		}
		else {
			if(cbthang.getSelectedIndex()==0) {
				veLaiChart();
			}
			else {
				int nam=Integer.parseInt(getValue(cbnam.getSelectedItem().toString()));
				int thang=Integer.parseInt(getValue(cbthang.getSelectedItem().toString()));
				int soNgay= LocalDate.of(nam,thang,1).lengthOfMonth();
				DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
				for (int i = 1; i <= soNgay; i++) {
		            double value = HoaDonBUS.getIntance().layDoanhThuTheoNgayChart(nam, thang, i);
//		            đặt tạm giá trị
		        	dataset1.addValue(value, "Doanh thu", i + "");
		        }
				
				JFreeChart lineChart = ChartFactory.createLineChart(
		                "Doanh thu tháng " + thang+" năm "+ nam,
		                "Ngày", "Doanh thu",
		                dataset1, PlotOrientation.VERTICAL, false, false, false);
				
				chartPanel.setChart(lineChart);
			}	
		}
	}
	public void xuLyHienThiSanPhamBanChay() {
		//lấy 5 sản phẩm bán chạy nhất
		ArrayList<String> listSp=CTHoaDonBUS.getIntance().layDanhSachSanPhamBanChay();
		for (int i=0;i<5;i++) {
			String sanPham=listSp.get(i);
			String maSP=sanPham.split(" - ")[0];
			String txtSoLuong=sanPham.split(" - ")[1];
			String tenSP=MatHangBUS.getInstance().layTenSanPhamById(maSP);
			lblMon[i].setText(tenSP);
			lblSoLuong[i].setText(txtSoLuong);
		}
	}
	public JButton getBtnBack() {
		return btnBack;
	}
	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}
}
