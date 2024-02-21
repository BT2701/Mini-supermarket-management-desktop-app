package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import BUS.CTHoaDonBUS;
import BUS.MatHangBUS;
import DTO.DonViDTO;

public class ChiTietHoaDonGUI extends JDialog{
	private JLabel lbTitle,lbMaHD,lbMasp,lbSL,lbDongia,lbThanhTien,lbTenSp;
	private JTextField tfMahd,tfmasp,tfsl,tfdongia,tfthanhtien,tfTenSP;
	private String []tbTitle= {"Mã HD","Mã SP","SL","Đơn giá","Thành tiền"};
	private String [][]tbItems= null;
	private DefaultTableModel modelCTHD;
	private JTable tbHoaDonCT;
	private JScrollPane scrCTHD;
	private String[] TTCTHD=new String[0];
	private JButton btnchange;
	private Font font = new Font("Tahoma", Font.BOLD, 30);
	private Font fontItems = new Font("Tahoma", Font.BOLD, 15);
	private Color btnoldColor=new Color(52, 152, 219);
	private DecimalFormat dcf = new DecimalFormat("###,###");
	private SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	private Color texfieldColor=new Color(45, 52, 54);
	public ChiTietHoaDonGUI() {
		initComponents();
	}
	public void initComponents() {
		this.setLayout(null);
		this.setSize(800,600);
		this.setTitle("Chi tiết hóa đơn");
		Image icon_bill= Toolkit.getDefaultToolkit().createImage("./src/IMG/Bill-icon.png");
		this.setIconImage(icon_bill);
		
		lbTitle=new JLabel("Chi tiết hóa đơn",JLabel.CENTER);
		lbTitle.setBounds(250, 10, 300, 50);
		lbTitle.setFont(font);
		
		lbMaHD=new JLabel("Mã HD");
		lbMaHD.setBounds(30, 80, 120, 30);
		lbMaHD.setFont(fontItems);
		
		tfMahd=new JTextField();
		tfMahd.setBounds(160, 80, 200, 30);
		tfMahd.setFont(fontItems);
		tfMahd.setDisabledTextColor(texfieldColor);
		tfMahd.setEnabled(false);
		
		lbMasp=new JLabel("Mã sản phẩm");
		lbMasp.setBounds(420, 80, 120, 30);
		lbMasp.setFont(fontItems);
		
		tfmasp=new JTextField();
		tfmasp.setBounds(550, 80, 200, 30);
		tfmasp.setFont(fontItems);
		tfmasp.setDisabledTextColor(texfieldColor);
		tfmasp.setEnabled(false);
		
		lbSL=new JLabel("Số lượng");
		lbSL.setBounds(420, 120, 120, 30);
		lbSL.setFont(fontItems);
		
		tfsl=new JTextField();
		tfsl.setBounds(550, 120, 200, 30);
		tfsl.setFont(fontItems);
		tfsl.setDisabledTextColor(texfieldColor);
		tfsl.setEnabled(false);
		
		lbDongia=new JLabel("Đơn giá");
		lbDongia.setBounds(30, 160, 120, 30);
		lbDongia.setFont(fontItems);
		
		tfdongia=new JTextField();
		tfdongia.setBounds(160, 160, 200, 30);
		tfdongia.setFont(fontItems);
		tfdongia.setDisabledTextColor(texfieldColor);
		tfdongia.setEnabled(false);
		
		lbThanhTien=new JLabel("Thành tiền");
		lbThanhTien.setBounds(420, 160, 120, 30);
		lbThanhTien.setFont(fontItems);
		
		tfthanhtien=new JTextField();
		tfthanhtien.setBounds(550, 160, 200, 30);
		tfthanhtien.setFont(fontItems);
		tfthanhtien.setDisabledTextColor(texfieldColor);
		tfthanhtien.setEnabled(false);
		
		lbTenSp=new JLabel("Tên sản phẩm");
		lbTenSp.setBounds(30, 120, 120, 30);
		lbTenSp.setFont(fontItems);
		
		tfTenSP=new JTextField();
		tfTenSP.setBounds(160, 120, 200, 30);
		tfTenSP.setFont(fontItems);
		tfTenSP.setDisabledTextColor(texfieldColor);
		tfTenSP.setEnabled(false);
		
//		"Mã HD","Mã SP","SL","Đơn giá","Thành tiền"
		modelCTHD=new DefaultTableModel(tbItems, tbTitle);
		tbHoaDonCT=new JTable(modelCTHD);
		tbHoaDonCT.setFont(fontItems);
		tbHoaDonCT.getTableHeader().setFont(fontItems);
		tbHoaDonCT.getTableHeader().setBackground(btnoldColor);
		tbHoaDonCT.getTableHeader().setPreferredSize(new Dimension(700,30));
		tbHoaDonCT.setRowHeight(25);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		tbHoaDonCT.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tbHoaDonCT.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tbHoaDonCT.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		getCTHDALL();
		scrCTHD=new JScrollPane();
		scrCTHD.setViewportView(tbHoaDonCT);
		scrCTHD.setBounds(40, 200, 700, 350);
		
		
		this.add(lbTitle);
		this.add(lbMaHD);
		this.add(lbMasp);
		this.add(lbSL);
		this.add(lbDongia);
		this.add(lbThanhTien);
		this.add(lbTenSp);
		
		this.add(tfsl);
		this.add(tfdongia);
		this.add(tfthanhtien);
		this.add(tfTenSP);
		this.add(tfMahd);
		this.add(tfmasp);
		
		this.add(scrCTHD);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setModal(true);
        this.setVisible(false);
	}
	public void themPhanTuVaoMangTTCTHD(String s) {
		int l=TTCTHD.length;
		TTCTHD=Arrays.copyOf(TTCTHD, l+1);
		TTCTHD[l]=s;
	}
	public void getCTHDALL() {
//		"Mã HD","Mã SP","SL","Đơn giá","Thành tiền"
		DefaultTableModel model = (DefaultTableModel) tbHoaDonCT.getModel();
		for(int i=0;i<CTHoaDonBUS.getIntance().getList().size();i++) {
			themPhanTuVaoMangTTCTHD(CTHoaDonBUS.getIntance().getList().get(i).getMaHd());
			themPhanTuVaoMangTTCTHD("SP"+CTHoaDonBUS.getIntance().getList().get(i).getMaMH());
			themPhanTuVaoMangTTCTHD(CTHoaDonBUS.getIntance().getList().get(i).getSlMH()+"");
			themPhanTuVaoMangTTCTHD(dcf.format( CTHoaDonBUS.getIntance().getList().get(i).getDonGia()));
			themPhanTuVaoMangTTCTHD(dcf.format( CTHoaDonBUS.getIntance().getList().get(i).getThanhTien()));
			model.addRow(TTCTHD);
			TTCTHD= new String[0];
		}
	}
	public void delTableHoaDonCT() {
		DefaultTableModel model=(DefaultTableModel)tbHoaDonCT.getModel();
		model.setRowCount(0);
	}
	public void xuLySuKienTableCTHoaDon() {
		int row=tbHoaDonCT.getSelectedRow();
		String maMH=tbHoaDonCT.getValueAt(row, 1)+"";
		tfMahd.setText(tbHoaDonCT.getValueAt(row, 0)+"");
		tfmasp.setText(maMH);
		tfsl.setText(tbHoaDonCT.getValueAt(row, 2)+"");
		tfdongia.setText(tbHoaDonCT.getValueAt(row, 3)+" VND/SP");
		tfthanhtien.setText(tbHoaDonCT.getValueAt(row, 4)+" VND");
		maMH=maMH.replace("SP", "");
		tfTenSP.setText(MatHangBUS.getInstance().layTenSanPhamById(maMH));
//		tftongtien.setText(tbHoaDonCT.getValueAt(row, 5)+" VND");
	}
	public void xuLySuKienRefresh() {
		delTableHoaDonCT();
		getCTHDALL();
		tfdongia.setText(null);
		tfMahd.setText(null);
		tfmasp.setText(null);
		tfsl.setText(null);
		tfTenSP.setText(null);
		tfthanhtien.setText(null);
		
	}
	public void layDanhSachCTHDtheoMaHD(String maHD) {
		tfdongia.setText(null);
		tfMahd.setText(null);
		tfmasp.setText(null);
		tfsl.setText(null);
		tfTenSP.setText(null);
		tfthanhtien.setText(null);
		delTableHoaDonCT();
		DefaultTableModel model = (DefaultTableModel) tbHoaDonCT.getModel();
		for(int i=0;i<CTHoaDonBUS.getIntance().layDanhSachTheoMaHD(maHD).size();i++) {
			themPhanTuVaoMangTTCTHD(CTHoaDonBUS.getIntance().layDanhSachTheoMaHD(maHD).get(i).getMaHd());
			themPhanTuVaoMangTTCTHD("SP"+CTHoaDonBUS.getIntance().layDanhSachTheoMaHD(maHD).get(i).getMaMH());
			themPhanTuVaoMangTTCTHD(CTHoaDonBUS.getIntance().layDanhSachTheoMaHD(maHD).get(i).getSlMH()+"");
			themPhanTuVaoMangTTCTHD(dcf.format( CTHoaDonBUS.getIntance().layDanhSachTheoMaHD(maHD).get(i).getDonGia()));
			themPhanTuVaoMangTTCTHD(dcf.format( CTHoaDonBUS.getIntance().layDanhSachTheoMaHD(maHD).get(i).getThanhTien()));
			model.addRow(TTCTHD);
			TTCTHD= new String[0];
		}
	}
	public JTable getTbHoaDonCT() {
		return tbHoaDonCT;
	}
	public void setTbHoaDonCT(JTable tbHoaDonCT) {
		this.tbHoaDonCT = tbHoaDonCT;
	}
	
}
