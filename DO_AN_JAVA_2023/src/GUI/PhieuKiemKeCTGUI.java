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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import BUS.CTHoaDonBUS;
import BUS.PhieuKiemKeCTBUS;
import BUS.MatHangBUS;

public class PhieuKiemKeCTGUI extends JDialog{
	private JLabel lbTitle,lbMaPKK,lbThoiDiemLap,lbManv,lbTenNV;
	private JTextField tfMaPKK,tfThoiDiemLap,tfmaNV,tfTenNV;
	private String []tbTitle= {"Mã PKK","Mã SP","Tên sản phẩm","Số lượng tồn"};
	private String [][]tbItems= null;
	private DefaultTableModel modelCTHD;
	private JTable tbCTPKK;
	private JScrollPane scrCTHD;
	private String[] TTCTpkk=new String[0];
	private JButton btnchange;
	private Font font = new Font("Tahoma", Font.BOLD, 30);
	private Font fontItems = new Font("Tahoma", Font.BOLD, 15);
	private Color btnoldColor=new Color(52, 152, 219);
	private DecimalFormat dcf = new DecimalFormat("###,###");
	private SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	private Color texfieldColor=new Color(45, 52, 54);
	public PhieuKiemKeCTGUI() {
		initComponents();
	}
	public void initComponents() {
		this.setLayout(null);
		this.setSize(800,600);
		this.setTitle("Chi tiết phiếu kiểm kê");
		Image icon_bill= Toolkit.getDefaultToolkit().createImage("./src/IMG/KiemKe-icon.png");
		this.setIconImage(icon_bill);
		
		lbTitle=new JLabel("Chi tiết phiếu kiểm kê",JLabel.CENTER);
		lbTitle.setBounds(230, 10, 340, 50);
		lbTitle.setFont(font);
		
		lbMaPKK=new JLabel("Mã PKK");
		lbMaPKK.setBounds(30, 80, 120, 30);
		lbMaPKK.setFont(fontItems);
		
		tfMaPKK=new JTextField();
		tfMaPKK.setBounds(160, 80, 200, 30);
		tfMaPKK.setFont(fontItems);
		tfMaPKK.setDisabledTextColor(texfieldColor);
		tfMaPKK.setEnabled(false);
		
		lbThoiDiemLap=new JLabel("Thời điểm lập");
		lbThoiDiemLap.setBounds(420, 80, 120, 30);
		lbThoiDiemLap.setFont(fontItems);
		
		tfThoiDiemLap=new JTextField();
		tfThoiDiemLap.setBounds(550, 80, 200, 30);
		tfThoiDiemLap.setFont(fontItems);
		tfThoiDiemLap.setDisabledTextColor(texfieldColor);
		tfThoiDiemLap.setEnabled(false);
		
		lbManv=new JLabel("Mã nhân viên");
		lbManv.setBounds(30, 120, 120, 30);
		lbManv.setFont(fontItems);
		
		tfmaNV=new JTextField();
		tfmaNV.setBounds(160, 120, 200, 30);
		tfmaNV.setFont(fontItems);
		tfmaNV.setDisabledTextColor(texfieldColor);
		tfmaNV.setEnabled(false);
		
		lbTenNV=new JLabel("Tên nhân viên");
		lbTenNV.setBounds(420, 120, 120, 30);
		lbTenNV.setFont(fontItems);
		
		tfTenNV=new JTextField();
		tfTenNV.setBounds(550, 120, 200, 30);
		tfTenNV.setFont(fontItems);
		tfTenNV.setDisabledTextColor(texfieldColor);
		tfTenNV.setEnabled(false);
		

		modelCTHD=new DefaultTableModel(tbItems, tbTitle);
		tbCTPKK=new JTable(modelCTHD);
		tbCTPKK.setFont(fontItems);
		tbCTPKK.getTableHeader().setFont(fontItems);
		tbCTPKK.getTableHeader().setBackground(btnoldColor);
		tbCTPKK.getTableHeader().setPreferredSize(new Dimension(700,30));
		tbCTPKK.setRowHeight(25);
		tbCTPKK.getColumnModel().getColumn(0).setPreferredWidth(20);
		tbCTPKK.getColumnModel().getColumn(1).setPreferredWidth(20);
		tbCTPKK.getColumnModel().getColumn(2).setPreferredWidth(200);
		tbCTPKK.getColumnModel().getColumn(3).setPreferredWidth(20);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		tbCTPKK.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tbCTPKK.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tbCTPKK.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
//		getCTHDALL();
		scrCTHD=new JScrollPane();
		scrCTHD.setViewportView(tbCTPKK);
		scrCTHD.setBounds(40, 160, 700, 390);
		
		
		this.add(lbTitle);
		this.add(lbMaPKK);
		this.add(lbThoiDiemLap);
		this.add(lbManv);
		this.add(lbTenNV);

		this.add(tfmaNV);
		this.add(tfTenNV);
		this.add(tfMaPKK);
		this.add(tfThoiDiemLap);
		
		this.add(scrCTHD);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setModal(true);
        this.setVisible(false);
	}
	public void delTablePhieukk() {
		DefaultTableModel model=(DefaultTableModel) tbCTPKK.getModel();
		model.setRowCount(0);
	}
	public void themPhanTuVaoMangTTCTpkk(String s) {
		int l=TTCTpkk.length;
		TTCTpkk=Arrays.copyOf(TTCTpkk, l+1);
		TTCTpkk[l]=s;
	}
	public void layDanhSachCTHDtheoMapkk(String mapkk) {
//		"Mã PKK","Mã SP","Tên sản phẩm","Số lượng tồn"
		delTablePhieukk();
		DefaultTableModel model = (DefaultTableModel) tbCTPKK.getModel();
		for(int i=0;i<PhieuKiemKeCTBUS.getInstance().layDanhSachCTPKKtheoMa(mapkk).size();i++) {
			String maMH=PhieuKiemKeCTBUS.getInstance().layDanhSachCTPKKtheoMa(mapkk).get(i).getMaMh();
			themPhanTuVaoMangTTCTpkk(PhieuKiemKeCTBUS.getInstance().layDanhSachCTPKKtheoMa(mapkk).get(i).getMaPkk());
			themPhanTuVaoMangTTCTpkk("SP"+maMH);
			themPhanTuVaoMangTTCTpkk(MatHangBUS.getInstance().layTenSanPhamById(maMH));
			themPhanTuVaoMangTTCTpkk(PhieuKiemKeCTBUS.getInstance().layDanhSachCTPKKtheoMa(mapkk).get(i).getSlTon()+"");
			model.addRow(TTCTpkk);
			TTCTpkk= new String[0];
		}
	}
	public JTextField getTfMaPKK() {
		return tfMaPKK;
	}
	public void setTfMaPKK(JTextField tfMaPKK) {
		this.tfMaPKK = tfMaPKK;
	}
	public JTextField getTfThoiDiemLap() {
		return tfThoiDiemLap;
	}
	public void setTfThoiDiemLap(JTextField tfThoiDiemLap) {
		this.tfThoiDiemLap = tfThoiDiemLap;
	}
	public JTextField getTfmaNV() {
		return tfmaNV;
	}
	public void setTfmaNV(JTextField tfmaNV) {
		this.tfmaNV = tfmaNV;
	}
	public JTextField getTfTenNV() {
		return tfTenNV;
	}
	public void setTfTenNV(JTextField tfTenNV) {
		this.tfTenNV = tfTenNV;
	}
	
}
