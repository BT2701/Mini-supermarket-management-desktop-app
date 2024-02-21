//package GUI;
//
//import java.awt.Color;
//import java.awt.Dialog;
//import java.awt.Dimension;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JDialog;
//import javax.swing.JLabel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//
//public class dialogNhapHangGUI extends JDialog{
//   
//    private JTextField tfthongtin;
//    private JLabel lbtitle;
//    private JLabel lbthongtin;
//    private JTable tbcart;
//    private JScrollPane scrCart;
//    private String[][] items = {{"", "", "", "", ""}};
//    private String[] header = {"STT", "Tên sản phẩm", "Đơn giá", "Số lượng", "Thành tiền"};
//    private Font font = new Font("Tahoma", Font.BOLD, 30);
//    private Font fontItems = new Font("Tahoma", Font.BOLD, 15);
//    public static JButton btnThanhToan;
//    public static JButton btnDel;
//    private Color btnoldColor = new Color(52, 152, 219);
//
//	public dialogNhapHangGUI () {
//		initComponent();
//	}
//	public void initComponent() {
//		//------Dialog nhập hàng------------------------------------------------------------
//        this.setTitle("Giỏ hàng nhập");
//        this.setLayout(null);
//        this.setSize(800, 600);
////        jLabel_Dialog_nh.setOpaque(true);  
//
//        this.setModal(true);
//        this.setLocationRelativeTo(null);
//        this.setUndecorated(true);  // tắt thanh chức năng mặc định của chương trình
//
//        JButton jButton_dialog_nh = new JButton("x"); //button exits
//        jButton_dialog_nh.setBounds(760, 0, 40, 40);
//        jButton_dialog_nh.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				click_close_dialog();
//			}
//		});
//
//        lbtitle = new JLabel("Giỏ hàng nhập", JLabel.CENTER);
//        lbtitle.setBounds(260, 30, 300, 50);
//        lbtitle.setFont(font);
//
//        lbthongtin = new JLabel("Nhà cung cấp");
//        lbthongtin.setBounds(180, 120, 150, 30);
//        lbthongtin.setFont(fontItems);
//
//        tfthongtin = new JTextField(JTextField.CENTER);
//        tfthongtin.setBounds(310, 120, 300, 30);
//        tfthongtin.setFont(fontItems);
//        tfthongtin.setEnabled(false);
//
//        tbcart = new JTable(items, header);
//        tbcart.setFont(fontItems);
//        tbcart.getTableHeader().setFont(fontItems);
//        tbcart.getTableHeader().setBackground(btnoldColor);
//        tbcart.getTableHeader().setPreferredSize(new Dimension(600, 30));
//        tbcart.setRowHeight(25);
//
//        scrCart = new JScrollPane();
//        scrCart.setViewportView(tbcart);
//        scrCart.setBounds(100, 200, 600, 300);
//
//        btnThanhToan = new JButton("Nhập hàng");
//        btnThanhToan.setBounds(450, 510, 150, 30);
//        btnThanhToan.setFont(fontItems);
//        btnThanhToan.setBackground(btnoldColor);
//
//        btnDel = new JButton("Xóa");
//        btnDel.setBounds(200, 510, 150, 30);
//        btnDel.setFont(fontItems);
//        btnDel.setBackground(btnoldColor);
//
//        add(jButton_dialog_nh);
//        add(lbtitle);
//        add(scrCart);
//        add(btnDel);
//        add(btnThanhToan);
//        add(lbthongtin);
//        add(tfthongtin);
//
////        dialog_nh.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        this.setVisible(false);
//	}
//	public void click_close_dialog() {
//        this.setVisible(false);
//    }
//
//    public void mouseClicked_jLabel_Dialog_nh() {
//        this.setVisible(true);
//    }
//    public void addEvent() {
//    	
//    }
//}
package GUI;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Vector;

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
import BUS.HoaDonBUS;
import BUS.KhachHangBUS;
import BUS.MatHangBUS;
import BUS.NhaCungCapBUS;
import BUS.PhieuNhapBUS;
import BUS.PhieuNhapCTBUS;
import DTO.CTHoaDon;
import DTO.DTO_KhachHang;
import DTO.HoaDon;
import DTO.MatHangDTO;
import DTO.PhieuNhap;
import DTO.PhieuNhapCT;

public class dialogNhapHangGUI extends JDialog {

//    private JTextField tfthongtin;
    private JLabel lbtitle;
//    private JLabel lbthongtin;
    private JTable tbcart;
    private JScrollPane scrCart;
    private String[][] items = null;
    private String[] header = {"Mã SP", "Tên sản phẩm", "Đơn giá", "Số lượng", "Thành tiền"};
    private Font font = new Font("Tahoma", Font.BOLD, 30);
    private Font fontItems = new Font("Tahoma", Font.BOLD, 15);
    public static JButton btnThanhToan;
    public static JButton btnDel;
    private Color btnoldColor = new Color(52, 152, 219);
    private Color btnoldColor1 = Color.white;
    private JButton jButton_dialog_nh;
    private DefaultTableModel model_diaLog;
    private DecimalFormat dcf = new DecimalFormat("###,###");
    private int maPNnew=PhieuNhapBUS.getInstance().getMaPNmoiNhat();

    public dialogNhapHangGUI() {
        initComponent();
        addEvent();
    }

    public void initComponent() {
        //------Dialog nhập hàng------------------------------------------------------------
        this.setTitle("Giỏ hàng nhập");
        this.setLayout(null);
        this.setSize(800, 600);
//        jLabel_Dialog_nh.setOpaque(true);  

        this.setModal(true);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);  // tắt thanh chức năng mặc định của chương trình

        jButton_dialog_nh = new JButton("x"); //button exits

        jButton_dialog_nh.setBounds(760, 0, 40, 40);
        jButton_dialog_nh.setBackground(btnoldColor);
        jButton_dialog_nh.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                click_close_dialog();
            }
        });

        lbtitle = new JLabel("Giỏ hàng nhập", JLabel.CENTER);
        lbtitle.setBounds(260, 30, 300, 50);
        lbtitle.setFont(font);

//        lbthongtin = new JLabel("Nhà cung cấp");
//        lbthongtin.setBounds(180, 120, 150, 30);
//        lbthongtin.setFont(fontItems);
//
//        tfthongtin = new JTextField(JTextField.CENTER);
//        tfthongtin.setBounds(310, 120, 300, 30);
//        tfthongtin.setFont(fontItems);
//        tfthongtin.setEnabled(false);
        
        model_diaLog = new DefaultTableModel(items, header);
        tbcart = new JTable(model_diaLog);
        tbcart.getTableHeader().setForeground(Color.BLACK);
        tbcart.getTableHeader().setBackground(new Color(0x29B6F6));
        tbcart.getTableHeader().setFont(new Font("Serif", Font.BOLD, 18));
        tbcart.setFont(new Font("Serif", 0, 16));
        tbcart.setRowHeight(25);
        
        tbcart.getColumnModel().getColumn(0).setPreferredWidth(40); 
        tbcart.getColumnModel().getColumn(1).setPreferredWidth(160); 
        tbcart.getColumnModel().getColumn(2).setPreferredWidth(115); 
        tbcart.getColumnModel().getColumn(3).setPreferredWidth(70); 
        tbcart.getColumnModel().getColumn(4).setPreferredWidth(140);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tbcart.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
//        tbcart.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tbcart.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tbcart.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tbcart.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        scrCart = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrCart.setViewportView(tbcart);
        scrCart.setBounds(100, 200, 600, 300);

        btnThanhToan = new JButton("Nhập hàng");
        btnThanhToan.setBounds(450, 510, 150, 40);
        btnThanhToan.setFont(fontItems);
        btnThanhToan.setBackground(btnoldColor);

        btnDel = new JButton("Xóa");
        btnDel.setBounds(200, 510, 150, 40);
        btnDel.setFont(fontItems);
        btnDel.setBackground(btnoldColor);

        add(jButton_dialog_nh);
        add(lbtitle);
        add(scrCart);
        add(btnDel);
        add(btnThanhToan);
//        add(lbthongtin);
//        add(tfthongtin);

//        dialog_nh.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(false);
    }

    public void click_close_dialog() {
        this.setVisible(false);
    }

    public void mouseClicked_jLabel_Dialog_nh() {
        this.setVisible(true);
    }
    public void xuLyThemVaoHangCho() {
		if(NhapHangGUI.jTable_nhapHang.getSelectedRow()<0) {
			new ThongBaoDialog("mời chọn sản phẩm",ThongBaoDialog.WARNING_DIALOG);
			return;
		}
        String ma = NhapHangGUI.jTextField_maSP.getText();
        MatHangDTO mh=new MatHangDTO();
        mh.setMaMh(ma);
        mh=MatHangBUS.getInstance().getById(mh);
        String ten = NhapHangGUI.jTextField_tenSP.getText();
        String donGia = dcf.format(mh.getGiaMua())+" VND";
        int soLuong = Integer.parseInt(NhapHangGUI.jTextField_soLuong.getText());
        String thanhTien=NhapHangGUI.jTextField_donGia.getText();


        if (ma.trim().equalsIgnoreCase(""))
            return;
        for (int i = 0; i < tbcart.getRowCount(); i++) {
            String maTbl = tbcart.getValueAt(i, 0) + "";
            if (maTbl.equalsIgnoreCase(ma)) {
                int soLuongCart = Integer.parseInt(tbcart.getValueAt(i, 3) + "");
                soLuongCart += soLuong;
                donGia = donGia.replace(",", "");
                donGia=donGia.replace(" VND", "");
                double donGiaSP = Double.parseDouble(donGia);

                tbcart.setValueAt(soLuongCart+"", i, 3);
                tbcart.setValueAt(dcf.format(soLuongCart * donGiaSP)+" VND", i, 4);
                return;
            }
        }
        getHDALL(ma, ten, soLuong+"", donGia,thanhTien);
        new ThongBaoDialog("Thêm thành công", ThongBaoDialog.SUCCESS_DIALOG);
    }
    public void getHDALL(String masp,String tenSP,String soluong,String donGia,String thanhtien) {
//		"Mã SP","Tên SP",số lượng,"Đơn giá",thành tiền
		DefaultTableModel model = (DefaultTableModel) tbcart.getModel();
		Vector<String> vec=new Vector<>();
		vec.add(masp);
		vec.add(tenSP);
		vec.add(donGia);
		vec.add(soluong);
		vec.add(thanhtien);
		
		model.addRow(vec);
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
	public void xuLyNhapHang() {
		int row =tbcart.getRowCount();
		if(row==0) {
			new ThongBaoDialog("Giỏ hàng rỗng", ThongBaoDialog.ERROR_DIALOG);
			return;
		}
//		String maVaTenKH= cbthongtinkh.getSelectedItem().toString();
//		String maKH=layMa(maVaTenKH);
//		if(maKH.equalsIgnoreCase("Chọn khách hàng")) {
//			new ThongBaoDialog("Mời chọn khách hàng", ThongBaoDialog.WARNING_DIALOG);
//			return;
//		}
		maPNnew++;
		String txtMapn="PN"+maPNnew;
		String maNV=layMa(NhapHangGUI.jTextField_nv.getText());
//		tinhTongTienHD();
//		int diemThuongHD= Integer.parseInt(tfdungdiem.getText()+"");
		
		//truyền dữ liệu xuống database
//		Date thoiDiemLap=new Date();
//		DTO_KhachHang khachHang=new DTO_KhachHang();
//		khachHang.setDateNgayMuaGanNhat(ngayMuaGanNhat);
//		khachHang.setMaKH(maKH);
		PhieuNhap pn=new PhieuNhap(txtMapn, maNV, new Date());
		PhieuNhapBUS.getInstance().inSert(pn);
		
//		KhachHangBUS.getIntance().capNhatDiemThuong(maKH, capNhatDiemThuongKH());
//		KhachHangBUS.getIntance().capNhatNgayMuaGanNhat(khachHang);
		if(row>0) {
			for(int i=0;i<tbcart.getRowCount();i++) {
				
				String maMH= tbcart.getValueAt(i, 0)+"";
//				maMH=maMH.replace("SP", "");
				
				String txtsoLuong=tbcart.getValueAt(i, 3)+"";
				int soLuong= Integer.parseInt(txtsoLuong);
				
//				String txtDonGia= tbcart.getValueAt(i, 2)+"";
//				txtDonGia=txtDonGia.replace(",", "");
//				txtDonGia=txtDonGia.replace("VND", "");
//				double donGia=Double.parseDouble(txtDonGia);
//				
//				String txtThanhTien=tbcart.getValueAt(i, 4)+"";
//				txtThanhTien= txtThanhTien.replace(",", "");
//				txtThanhTien= txtThanhTien.replace("VND", "");
//				double thanhTien=Double.parseDouble(txtThanhTien);
				
				String tenNCC= NhapHangGUI.jTextField_ncc.getSelectedItem().toString();
				String maNCC= NhaCungCapBUS.getInstance().layMaBangTen(tenNCC);
				PhieuNhapCT ctpn=new PhieuNhapCT(txtMapn, maMH, maNCC, soLuong);
				PhieuNhapCTBUS.getInstance().inSert(ctpn);
				
				MatHangBUS.getInstance().capNhatSLNHAP(maMH, soLuong);
			}
		}
		
		new ThongBaoDialog("Đã thanh toán", ThongBaoDialog.SUCCESS_DIALOG);
		
		//cập nhật lại 
		delTableHoaDon();
//		tongTienHoaDon=0;
//		tfdungdiem.setText("0");
	}
	public void delTableHoaDon() {
		DefaultTableModel model=(DefaultTableModel) tbcart.getModel();
		model.setRowCount(0);
	}
	public String layMa(String maVaTen) {
		String []s=maVaTen.split(" - ");
		return s[0];
	}

    public void addEvent() {
    	btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLyXoaSPGioHang();
			}
		});
    	btnThanhToan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLyNhapHang();
			}
		});
    	
    }
}
