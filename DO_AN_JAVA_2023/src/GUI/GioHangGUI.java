package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import BUS.CTHoaDonBUS;
import BUS.ChungLoaiBUS;
import BUS.HoaDonBUS;
import BUS.KhachHangBUS;
import BUS.KhuyenMaiBUS;
import BUS.MatHangBUS;
import DAO.KhachHangDAO;
import DTO.CTHoaDon;
import DTO.DTO_KhachHang;
import DTO.DonViDTO;
import DTO.HoaDon;
import DTO.KhuyenMaiDTO;

public class GioHangGUI extends JDialog{
	private JLabel lbtitle;
	private DefaultTableModel modelHD;
	private JTable tbcart;
	private JScrollPane scrCart;
	private String[][] items= null;
	private String []header= {"Mã SP","Tên sản phẩm","Số lượng","Giá bán/SP","Thành tiền"};
	private Font font = new Font("Tahoma", Font.BOLD, 30);
	private Font fontItems = new Font("Tahoma", Font.BOLD, 15);
	public static JButton btnThanhToan;
	public static JButton btnDel;
	private Color btnoldColor=new Color(52, 152, 219);
	private String [] thongTinKH={"Chọn khách hàng"};
	private JLabel lbthongtin,lbKhuyenMai;
	public static JComboBox<String>cbthongtinkh;
	public static JComboBox<String>cbKhuyenMai;
//	private JLabel lbdiemthuong,lbdungdiem;
//	private JTextField tfdiemthuong,tfdungdiem;
//	public static JButton btndungdiem;
	private String[] TTHD=new String[0];
	private DecimalFormat dcf = new DecimalFormat("###,###");
	private double tongTienHoaDon=0;
	private double giamGia=0;
	private int maHD=HoaDonBUS.getIntance().getMaHDmoiNhat();
	public GioHangGUI() {
		initComponent();
		
	}
	public void initComponent() {
		this.setLayout(null);
//		this.setBounds(0, 40, 1100, 660);
		this.setSize(800,600);
		Image icon_cart= Toolkit.getDefaultToolkit().createImage("./src/IMG/cart-icon.png");
		this.setIconImage(icon_cart);
		this.setTitle("Giỏ hàng");
		lbtitle=new JLabel("Giỏ hàng",JLabel.CENTER);
		lbtitle.setBounds(300, 10, 200, 50);
//		lbtitle.setPreferredSize(new Dimension(800,50));
		lbtitle.setFont(font);
		
		modelHD=new DefaultTableModel(items, header);
		
		tbcart=new JTable(modelHD);
		tbcart.setFont(fontItems);
		tbcart.getTableHeader().setFont(fontItems);
		tbcart.getTableHeader().setBackground(btnoldColor);
		tbcart.getTableHeader().setPreferredSize(new Dimension(600,30));
		tbcart.setRowHeight(25);
		
		tbcart.getColumnModel().getColumn(0).setPreferredWidth(20);
		tbcart.getColumnModel().getColumn(1).setPreferredWidth(200);
		tbcart.getColumnModel().getColumn(2).setPreferredWidth(20);
		tbcart.getColumnModel().getColumn(3).setPreferredWidth(30);
		tbcart.getColumnModel().getColumn(4).setPreferredWidth(30);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		tbcart.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tbcart.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		
		scrCart=new JScrollPane();
		scrCart.setViewportView(tbcart);
		scrCart.setBounds(100, 150, 600, 350);
		
		btnThanhToan=new JButton("Thanh toán");
		btnThanhToan.setBounds(450, 510, 150, 30);
		btnThanhToan.setFont(fontItems);
		btnThanhToan.setBackground(btnoldColor);
		
		btnDel=new JButton("Xóa");
		btnDel.setBounds(200, 510, 150, 30);
		btnDel.setFont(fontItems);
		btnDel.setBackground(btnoldColor);
		
		lbthongtin=new JLabel("Chọn khách hàng");
		lbthongtin.setBounds(150, 70, 150, 30);
		lbthongtin.setFont(fontItems);
		
		lbKhuyenMai=new JLabel("Chọn khuyến mãi");
		lbKhuyenMai.setBounds(150, 110, 150, 30);
		lbKhuyenMai.setFont(fontItems);
		
		cbthongtinkh=new JComboBox<String>(thongTinKH);
		getThongTinKhachHang();
		cbthongtinkh.setBounds(310, 70, 300, 30);
		cbthongtinkh.setFont(fontItems);
		
		cbKhuyenMai=new JComboBox<String>();
		layDSKhuyenMai();
		cbKhuyenMai.setBounds(310, 110, 300, 30);
		cbKhuyenMai.setFont(fontItems);
		cbKhuyenMai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dungMaGiamGia();
			}
		});
		
//		lbdiemthuong=new JLabel("Điểm hiện có");
//		lbdiemthuong.setBounds(130, 110, 120, 30);
//		lbdiemthuong.setFont(fontItems);
//		
//		lbdungdiem=new JLabel("Nhập điểm");
//		lbdungdiem.setBounds(490, 110, 120, 30);
//		lbdungdiem.setFont(fontItems);
//		
//		tfdiemthuong=new JTextField(JTextField.CENTER); 
//		tfdiemthuong.setBounds(260, 110, 50, 30);
//		tfdiemthuong.setFont(fontItems);
//		tfdiemthuong.setText("0");
//		tfdiemthuong.setEnabled(false);
//		
//		tfdungdiem=new JTextField(JTextField.CENTER);
//		tfdungdiem.setBounds(620, 110, 50, 30);
//		tfdungdiem.setFont(fontItems);
//		tfdungdiem.setText("0");
//		tfdungdiem.setEnabled(false);
//		
//		btndungdiem=new JButton("Dùng điểm");
//		btndungdiem.setBounds(340, 150, 120, 30);
//		btndungdiem.setFont(fontItems);
//		btndungdiem.setBackground(btnoldColor);
//		
		this.add(lbKhuyenMai);
		this.add(cbKhuyenMai);
		this.add(lbtitle);
		this.add(scrCart);
		this.add(btnDel);
		this.add(btnThanhToan);
		this.add(lbthongtin);
		this.add(cbthongtinkh);
//		this.add(lbdiemthuong);
//		this.add(lbdungdiem);
//		this.add(tfdiemthuong);
//		this.add(tfdungdiem);
//		this.add(btndungdiem);
//		this.getContentPane().add(lbtitle);
//		this.getContentPane().add(scrCart);
		
//		this.pack();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setModal(true);
        this.setVisible(false);
	}
	public void themPhanTuVaoMang(String s) {
		int l=thongTinKH.length;
		thongTinKH=Arrays.copyOf(thongTinKH, l+1);
		thongTinKH[l]=s;
	}
	public void themPhanTuVaoMangTTHD(String s) {
		int l=TTHD.length;
		TTHD=Arrays.copyOf(TTHD, l+1);
		TTHD[l]=s;
	}
	public void getHDALL(String masp,String tenSP,String soluong,String donGia,String thanhtien) {
//		"Mã SP","Tên SP",số lượng,"Đơn giá",thành tiền
		DefaultTableModel model = (DefaultTableModel) tbcart.getModel();
		themPhanTuVaoMangTTHD(masp);
		themPhanTuVaoMangTTHD(tenSP);
		themPhanTuVaoMangTTHD(soluong);
		themPhanTuVaoMangTTHD(donGia);
		themPhanTuVaoMangTTHD(thanhtien);
		model.addRow(TTHD);
		TTHD= new String[0];
	}
	
	public void xuLyThemVaoGioHang() {
		if(DanhSachSPGUI.dsSP.getSelectedRow()<0) {
			new ThongBaoDialog("mời chọn sản phẩm",ThongBaoDialog.WARNING_DIALOG);
			return;
		}
        String ma = ChiTietSanPhamGUI.tfMasp.getText();
        String ten = ChiTietSanPhamGUI.tfTensp.getText();
        String donGia = ChiTietSanPhamGUI.tfDongia.getText();
        String txtSoLuong=ChiTietSanPhamGUI.spnSoluong.getValue() + "";
        if(CheckLoi.isInteger(txtSoLuong)==false) {
        	new ThongBaoDialog("Định dạng sai", ThongBaoDialog.ERROR_DIALOG);
        	return;
        }
        int soLuong = Integer.parseInt(txtSoLuong);
        System.out.println(soLuong);
        int soLuongConLai = Integer.parseInt(DanhSachSPGUI.dsSP.getValueAt(DanhSachSPGUI.dsSP.getSelectedRow(), 3) + "");
        if(soLuong<1) {
        	new ThongBaoDialog("Số lượng không khả dụng", ThongBaoDialog.ERROR_DIALOG);
        	return;
        }
        if (soLuong > soLuongConLai || soLuongConLai <= 0) {
            new ThongBaoDialog("Sản phầm không đủ", ThongBaoDialog.ERROR_DIALOG);
            return;
        }

        ChiTietSanPhamGUI.tfMasp.setText("");
        ChiTietSanPhamGUI.tfTensp.setText("");
        ChiTietSanPhamGUI.tfDongia.setText("");
        ChiTietSanPhamGUI.spnSoluong.setValue(0);

        if (ma.trim().equalsIgnoreCase(""))
            return;
        for (int i = 0; i < tbcart.getRowCount(); i++) {
            String maTbl = tbcart.getValueAt(i, 0) + "";
            if (maTbl.equalsIgnoreCase(ma)) {
                int soLuongCart = Integer.parseInt(tbcart.getValueAt(i, 2) + "");
                soLuongCart += soLuong;
                donGia = donGia.replace(",", "");
                donGia=donGia.replace(" VND", "");
                double donGiaSP = Double.parseDouble(donGia);

                tbcart.setValueAt(soLuongCart+"", i, 2);
                tbcart.setValueAt(dcf.format(soLuongCart * donGiaSP)+"", i, 4);
                return;
            }
        }
        donGia = donGia.replace(",", "");
        donGia=donGia.replace(" VND", "");
        double donGiaSP = Double.parseDouble(donGia);
        getHDALL(ma, ten, soLuong+"", dcf.format(donGiaSP), dcf.format(soLuong * donGiaSP)+"");
        new ThongBaoDialog("Thêm thành công", ThongBaoDialog.SUCCESS_DIALOG);
    }
	public void xuLyXoaSPGioHang() {
		if(tbcart.getSelectedRow()<0) {
			new ThongBaoDialog("Mời chọn sản phẩm", ThongBaoDialog.WARNING_DIALOG);
			return;
		}
		DefaultTableModel model = (DefaultTableModel) tbcart.getModel();
        int row = tbcart.getSelectedRow();
        if (row > -1) {
            model.removeRow(row);
        }
    }
	public void tinhTongTienHD() {
		int row =tbcart.getRowCount();
		if(row>0) {
			for(int i=0;i<tbcart.getRowCount();i++) {
				String txtThanhTien=tbcart.getValueAt(i, 4)+"";
				txtThanhTien= txtThanhTien.replace(",", "");
				double thanhTien=Double.parseDouble(txtThanhTien);
				tongTienHoaDon+=thanhTien;
			}
			if(tongTienHoaDon<0) {
				tongTienHoaDon=0;
			}
		}
	}
//	public int capNhatDiemThuongKH() {
//		//cứ mua được 100k là tích được 1 điểm thưởng
//		double soTienDuocCongDiem=100000;
//		int diemCongThem= (int)Math.floor(tongTienHoaDon/soTienDuocCongDiem);
//		int diemThuongKH= Integer.parseInt(tfdiemthuong.getText()+"");
//		return diemThuongKH+diemCongThem;
//	}
	public void xuLyThanhToan() {
		int row =tbcart.getRowCount();
		if(row==0) {
			new ThongBaoDialog("Giỏ hàng rỗng", ThongBaoDialog.ERROR_DIALOG);
			return;
		}
		String maVaTenKH= cbthongtinkh.getSelectedItem().toString();
		String maKH=layMa(maVaTenKH);
		if(maKH.equalsIgnoreCase("Chọn khách hàng")) {
			new ThongBaoDialog("Mời chọn khách hàng", ThongBaoDialog.ERROR_DIALOG);
			return;
		}
		int indexmaGiam=cbKhuyenMai.getSelectedIndex();
		if(indexmaGiam==0) {
			new ThongBaoDialog("Mời chọn mã giảm", ThongBaoDialog.ERROR_DIALOG);
			return;
		}
		String maGiam=cbKhuyenMai.getSelectedItem().toString();
		KhuyenMaiDTO khuyenMai=new KhuyenMaiDTO();
		khuyenMai.setTen(maGiam);
		khuyenMai=KhuyenMaiBUS.getInstance().getByID(khuyenMai);
		int phanTramGiam=khuyenMai.getGiatri();
		maHD++;
		String txtmaHD="HD"+maHD;
		String maNV=layMa(ChiTietSanPhamGUI.tfNv.getText());
		tinhTongTienHD();
//		int diemThuongHD= Integer.parseInt(tfdungdiem.getText()+"");
		
		//truyền dữ liệu xuống database
		Date ngayMuaGanNhat=new Date();
		DTO_KhachHang khachHang=new DTO_KhachHang();
		khachHang.setDateNgayMuaGanNhat(ngayMuaGanNhat);
		khachHang.setMaKH(maKH);
		HoaDon hd=new HoaDon(txtmaHD, maNV, new Date(), tongTienHoaDon-giamGia, maKH, phanTramGiam,1);
		HoaDonBUS.getIntance().inSert(hd);
		
//		KhachHangBUS.getIntance().capNhatDiemThuong(maKH, capNhatDiemThuongKH());
		KhachHangBUS.getIntance().capNhatNgayMuaGanNhat(khachHang);
		if(row>0) {
			for(int i=0;i<tbcart.getRowCount();i++) {
				
				String maMH= tbcart.getValueAt(i, 0)+"";
				maMH=maMH.replace("SP", "");
				
				String txtsoLuong=tbcart.getValueAt(i, 2)+"";
				int soLuong= Integer.parseInt(txtsoLuong);
				
				String txtDonGia= tbcart.getValueAt(i, 3)+"";
				txtDonGia=txtDonGia.replace(",", "");
				double donGia=Double.parseDouble(txtDonGia);
				
				String txtThanhTien=tbcart.getValueAt(i, 4)+"";
				txtThanhTien= txtThanhTien.replace(",", "");
				double thanhTien=Double.parseDouble(txtThanhTien);
				
				CTHoaDon cthd=new CTHoaDon(txtmaHD, maMH, soLuong, donGia, thanhTien);
				CTHoaDonBUS.getIntance().inSert(cthd);
				
				MatHangBUS.getInstance().capNhatSLban(maMH, soLuong);
			}
		}
		
		new ThongBaoDialog("Đã thanh toán", ThongBaoDialog.SUCCESS_DIALOG);
		
		//cập nhật lại 
		delTableHoaDon();
		tongTienHoaDon=0;
		getThongTinKhachHang();
		layDSKhuyenMai();
//		tfdungdiem.setText("0");
	}
	
	public void delTableHoaDon() {
		DefaultTableModel model=(DefaultTableModel) tbcart.getModel();
		model.setRowCount(0);
	}
	public void dungMaGiamGia() {
		if(cbKhuyenMai.getSelectedIndex()==0) {
			return;
		}
		tinhTongTienHD();
		String maGiam=cbKhuyenMai.getSelectedItem().toString();
		KhuyenMaiDTO khuyenmai=new KhuyenMaiDTO();
		khuyenmai.setTen(maGiam);
		khuyenmai=KhuyenMaiBUS.getInstance().getByID(khuyenmai);
		int phanTramGiam=khuyenmai.getGiatri();
		if(tongTienHoaDon<1000000 && khuyenmai.getGiatri()==10) {
			new ThongBaoDialog("Chưa đủ điều kiện dùng mã", ThongBaoDialog.ERROR_DIALOG);
			tongTienHoaDon=0;
			layDSKhuyenMai();
			return;
		}
		if(tongTienHoaDon<2000000 && khuyenmai.getGiatri()==15) {
			new ThongBaoDialog("Chưa đủ điều kiện dùng mã", ThongBaoDialog.ERROR_DIALOG);
			tongTienHoaDon=0;
			layDSKhuyenMai();
			return;
		}
		if(tongTienHoaDon<1000000 && khuyenmai.getGiatri()==15) {
			new ThongBaoDialog("Chưa đủ điều kiện dùng mã", ThongBaoDialog.ERROR_DIALOG);
			tongTienHoaDon=0;
			layDSKhuyenMai();
			return;
		}
		giamGia=(tongTienHoaDon*phanTramGiam)/100;
		tongTienHoaDon=0;
		
	}
//public void getDSchungLoai() {
//		
//		for (String chungloai : ChungLoaiBUS.getIntance().getListChungloai()) {
//			themPhanTuVaoMangChungLoai(chungloai);
//		}
//		DefaultComboBoxModel<String>cbmodel=new DefaultComboBoxModel<>(listChungLoai);
//		cbchungloai.setModel(cbmodel);
//		listChungLoai=new String[0];
//		themPhanTuVaoMangChungLoai("Chủng loại");
////		listChungLoai=new String[0];
//	}
	public void getThongTinKhachHang() {
		for (String string : KhachHangBUS.getIntance().getListMaHoTenkh()) {
			themPhanTuVaoMang(string);
		}
		themPhanTuVaoMang("Tạo khách hàng mới");
		DefaultComboBoxModel<String>cbmodel=new DefaultComboBoxModel<>(thongTinKH);
		cbthongtinkh.setModel(cbmodel);
		thongTinKH=new String[0];
		themPhanTuVaoMang("Chọn khách hàng");
	}
	public void layDSKhuyenMai() {
		Vector<String> vec=new Vector<>();
		vec.add("Chọn khuyến mãi");
		for (KhuyenMaiDTO khuyenmai : KhuyenMaiBUS.getInstance().getList()) {
			vec.add(khuyenmai.getTen());
		}
		DefaultComboBoxModel<String> model=new DefaultComboBoxModel<>(vec);
		cbKhuyenMai.setModel(model);
		
	}
//	public void setDiemThuongView(String maVaTen) {
//		tfdiemthuong.setText(KhachHangBUS.getIntance().getDiemThuong(layMa(maVaTen))+"");
//	}
	public String layMa(String maVaTen) {
		String []s=maVaTen.split(" - ");
		return s[0];
	}
//	public JTextField getTfdungdiem() {
//		return tfdungdiem;
//	}
//	public void setTfdungdiem(JTextField tfdungdiem) {
//		this.tfdungdiem = tfdungdiem;
//	}
//	public JTextField getTfdiemthuong() {
//		return tfdiemthuong;
//	}
//	public void setTfdiemthuong(JTextField tfdiemthuong) {
//		this.tfdiemthuong = tfdiemthuong;
//	}
	
}
