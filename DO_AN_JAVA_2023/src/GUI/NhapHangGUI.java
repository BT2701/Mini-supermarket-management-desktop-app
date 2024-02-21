
package GUI;

import static javax.swing.BorderFactory.createLineBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
//import org.apache.xmlbeans.impl.store.Cursor;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import BUS.LoaiHangBUS;
import BUS.MatHangBUS;
import BUS.NhaCungCapBUS;
import BUS.PhieuNhapBUS;
import BUS.PhieuNhapCTBUS;
import DTO.DonViDTO;
import DTO.MatHangDTO;
import DTO.PhieuNhap;
import DTO.PhieuNhapCT;

public class NhapHangGUI extends JPanel {

    private JPanel jPanel_menu_head, jPanel_nh, jPanel_qlpn, jPanel_table_pn;
    public JLabel jLabel_north, jLabel_logo, jLabel_ima_profile, jLabel_user;
    private ImageIcon icon_refresh, icon_delete;
    public JButton jButton_hidden, jButton_close, jButton_logout;
    public static JTextField jTextField_donGia,jTextField_soLuong,jTextField_tenSP,jTextField_maPN, jTextField_maNCC, jTextField_maNV,jTextField_maSP, jTextField_ngayLap, jTextField_tongTien, jTextField_ctSanPham, jTextField_ctSoLuong, jTextField_ctDonGia, jTextField_ctThanhTien;
    public JLabel jLabel_nh, jLabel_qlpn;
    public JLabel jLabel_Dialog_nh;
    private dialogNhapHangGUI dlnhap;
    private DefaultTableModel model_nhapHang, model_phieuNhap, model_ctPhieuNhap;
    private String[] title_nhapHang = {"Mã sản phẩm", "Tên sản phẩm", "Tồn kho"};
    private String[] title_phieuNhap = {"Mã PN", "Mã NV", "Thời điểm lập"};
    private String[] title_ctPhieuNhap = {"Mã PN", "Mã MH", "Mã NCC", "SL"};
    public static JTable jTable_nhapHang, jTable_phieuNhap, jTable_ctPhieuNhap;
    private JButton bt_NgayNhap;
    private JLabel tuNgay;
    private SpinnerDateModel dateNgayNhapTu;
    private JSpinner nhapTuNgay;
    private JLabel denNgay;
    private SpinnerDateModel dateNgayToi;
    private JSpinner nhapDenNgay;
    private JButton bt_giaTien;
    private JPanel jPanel_timKiemTheoNgay;
    private JButton jButton_refresh;
    private JButton jButton_refresh_pn;
    public static JButton jButton_nhapHang,btnThemMoisp;
    public static JTextField jTextField_nv;
    private Color btnoldColor = new Color(52, 152, 219);
    private Color texfieldColor=new Color(45, 52, 54);
    private Border lineBorder = BorderFactory.createLineBorder(Color.gray, 1);
    private DecimalFormat dcf = new DecimalFormat("###,###");
    private SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    public static JComboBox<String> jTextField_ncc;
    private JButton btnTimKiemNgay,btnTimKiemGia,jButton_timKiem;
    private JTextField jTextField_timKiem;

//Line
    Border lineBorder_exit_hidden = BorderFactory.createLineBorder(new Color(0x29B6F6), 1);
    Border lineBorder_viewMenu = BorderFactory.createLineBorder(Color.WHITE, 2);
    Border lineBorder_viewMenu1 = BorderFactory.createLineBorder(new Color(0xBDBDBD), 1); // line cho viewMenu
    Font font_jLabel_viewMenu_table = new Font("Arials", Font.BOLD, 40); // font cho phần ViewTable sản phẩm
    Font f_jLabel_viewMenu = new Font("Arials", Font.ITALIC, 15); // font trong cho nút "Nhập hàng", "Chi tiết"
    Font font_jLabel_viewMenu_ttsp = new Font("Arials", Font.BOLD, 25);
    Font font_jLabel_viewMenu_ttsp1 = new Font("Arials", Font.PLAIN, 15);
    Font font_menu_item = new Font("Arials", Font.BOLD, 15);

    public NhapHangGUI() {
        initComponents();
        addEvent();
    }

    public void initComponents() {
        this.setPreferredSize(new Dimension(1100, 700));
        this.setLayout(null);

        //------Các thành phần trong viewmenu_center
        //------Các thành phần trong Menu_head
        icon_refresh = new ImageIcon("./src/IMG/Refresh-icon.png");

        jLabel_nh = new JLabel("Nhập hàng", JLabel.CENTER);
        jLabel_nh.setBounds(0, 0, 100, 31);
        jLabel_nh.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabel_nh.setBorder(lineBorder_viewMenu);
        jLabel_nh.setBackground(Color.WHITE);
        jLabel_nh.setOpaque(true);
//        jLabel_nh.; //sự kiện
//        jLabel_nh.addMouseListener(mouse); //sự kiện chuột
//        jLabel_nh.setBorder(lineBorder_viewMenu);
        jLabel_nh.setFont(f_jLabel_viewMenu);

        jLabel_qlpn = new JLabel("Quản lý phiếu nhập", JLabel.CENTER);
        jLabel_qlpn.setBounds(100, 0, 149, 31);
        jLabel_qlpn.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        jLabel_qlpn.addMouseListener(mouse); //sự kiện chuột
        jLabel_qlpn.setBorder(lineBorder_viewMenu);
        jLabel_qlpn.setFont(f_jLabel_viewMenu);

        //------Menu_head
        jPanel_menu_head = new JPanel();
        jPanel_menu_head.setLayout(null);
        jPanel_menu_head.setBackground(new Color(0xE0E0E0));
        jPanel_menu_head.setBounds(0, 0, 1100, 30);
        jPanel_menu_head.setBorder(lineBorder_viewMenu);

        jPanel_menu_head.add(jLabel_nh);
        jPanel_menu_head.add(jLabel_qlpn);

        ///---Các thành phần trong ViewTable
        JLabel jLabel_khoHang = new JLabel("Nhập hàng"); // Kho hàng
        jLabel_khoHang.setBounds(245, 20, 220, 60);
        jLabel_khoHang.setFont(font_jLabel_viewMenu_table);

        jButton_refresh = new JButton(icon_refresh); // nút refresh
        jButton_refresh.setBounds(465, 30, 40, 40);
        jButton_refresh.setBackground(Color.white);
        jButton_refresh.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton_refresh.setOpaque(true);

        JLabel jLabel_timKiem = new JLabel("Tìm kiếm:"); // Tìm kiếm
        jLabel_timKiem.setBounds(125, 105, 90, 30);
        jLabel_timKiem.setFont(f_jLabel_viewMenu);

        jTextField_timKiem = new JTextField(); // nhập
        jTextField_timKiem.setBounds(195, 105, 330, 30);

        jButton_timKiem = new JButton("Tìm kiếm"); // nút tìm kiếm
        jButton_timKiem.setBounds(525, 104, 90, 30);
        jButton_timKiem.setBackground(new Color(0x29B6F6));
        jButton_timKiem.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton_timKiem.setOpaque(true);

        ////---View hiển thị thông tin table/ nằm trong View All Nhập Hàng
        String mean_nhapHang[][] = null;
        model_nhapHang = new DefaultTableModel(mean_nhapHang, title_nhapHang);

        jTable_nhapHang = new JTable(model_nhapHang);
        jTable_nhapHang.getTableHeader().setForeground(Color.BLACK);
        jTable_nhapHang.getTableHeader().setBackground(new Color(0x29B6F6));
        jTable_nhapHang.getTableHeader().setFont(new Font("Serif", Font.BOLD, 18));
        jTable_nhapHang.setFont(new Font("Serif", 0, 16));
        jTable_nhapHang.setRowHeight(30);
        layDuLieuSP();
        jTable_nhapHang.getColumnModel().getColumn(0).setPreferredWidth(120);
        jTable_nhapHang.getColumnModel().getColumn(1).setPreferredWidth(324);
        jTable_nhapHang.getColumnModel().getColumn(2).setPreferredWidth(100);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTable_nhapHang.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        jTable_nhapHang.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        jTable_nhapHang.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

        //Tạo JScrollPane để chứa thằng JTable
        JScrollPane jScrollPane_jTable_nhapHang = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane_jTable_nhapHang.setViewportView(jTable_nhapHang);
        jScrollPane_jTable_nhapHang.setBounds(0, 0, 720, 490);
//---------------------------------------------------------------------------------------------
        JPanel jPanel_scroll_table = new JPanel(); //JPanel này chứa thằng JScrollPane. JScrollPane thì chứa JTable
        jPanel_scroll_table.setLayout(null);
        jPanel_scroll_table.setBounds(10, 170, 720, 460);
        jPanel_scroll_table.setBackground(Color.WHITE);
        jPanel_scroll_table.setBorder(lineBorder_viewMenu1);

        jPanel_scroll_table.add(jScrollPane_jTable_nhapHang); // add thằng JScrollPane 

        ////---ViewTable hiển thị các thông tin/ nằm trong View All Nhập Hàng
        JPanel jPanel_showTable = new JPanel();
        jPanel_showTable.setLayout(null);
        jPanel_showTable.setBounds(0, 0, 740, 700);
        jPanel_showTable.setBackground(Color.WHITE);

        jPanel_showTable.add(jLabel_khoHang);
        jPanel_showTable.add(jButton_refresh);
        jPanel_showTable.add(jLabel_timKiem);
        jPanel_showTable.add(jTextField_timKiem);
        jPanel_showTable.add(jButton_timKiem);
        jPanel_showTable.add(jPanel_scroll_table);

        ///---Các thành phần trong View Thông tin sản phẩm
        JLabel jLabel_ThongTin = new JLabel("Thông tin sản phẩm"); // Thông tin sản phẩm
        jLabel_ThongTin.setBounds(55, 10, 250, 60);
        jLabel_ThongTin.setFont(font_jLabel_viewMenu_ttsp);

        JLabel jLabel_maSP = new JLabel("Mã SP");
        jLabel_maSP.setBounds(25, 90, 50, 30);
        jLabel_maSP.setFont(font_jLabel_viewMenu_ttsp1);

        jTextField_maSP = new JTextField();
        jTextField_maSP.setBounds(85, 90, 230, 30);
        jTextField_maSP.setBorder(lineBorder);
        jTextField_maSP.setHorizontalAlignment(JTextField.CENTER);
        jTextField_maSP.setDisabledTextColor(texfieldColor);
        jTextField_maSP.setEnabled(false);

        JLabel jLabel_tenSP = new JLabel("Tên SP");
        jLabel_tenSP.setBounds(25, 130, 60, 30);
        jLabel_tenSP.setFont(font_jLabel_viewMenu_ttsp1);

        jTextField_tenSP = new JTextField();
        jTextField_tenSP.setBounds(85, 130, 230, 30);
        jTextField_tenSP.setBorder(lineBorder);
        jTextField_tenSP.setHorizontalAlignment(JTextField.CENTER);
        jTextField_tenSP.setDisabledTextColor(texfieldColor);
        jTextField_tenSP.setEnabled(false);
        
        JLabel jLabel_ncc = new JLabel("NCC"); // Nhà cung cấp
        jLabel_ncc.setBounds(25, 170, 60, 30);	
        jLabel_ncc.setFont(font_jLabel_viewMenu_ttsp1);

        jTextField_ncc = new JComboBox<String>();
        jTextField_ncc.setBounds(85, 170, 230, 30);
        jTextField_ncc.setBorder(lineBorder);
//        jTextField_ncc.setHorizontalAlignment(JTextField.CENTER);
//        jTextField_ncc.setDisabledTextColor(texfieldColor);
        layDSNCC();
        jTextField_ncc.setEnabled(true);

        JLabel jLabel_soLuong = new JLabel("Số lượng nhập"); // 
        jLabel_soLuong.setBounds(125, 235, 250, 30);
        jLabel_soLuong.setFont(font_jLabel_viewMenu_ttsp1);

        jTextField_soLuong = new JTextField();
        jTextField_soLuong.setBounds(60, 265, 230, 30);
        jTextField_soLuong.setBorder(lineBorder);
        jTextField_soLuong.setHorizontalAlignment(JTextField.CENTER);
        jTextField_soLuong.setDisabledTextColor(texfieldColor);

        JLabel jLabel_donGia = new JLabel("Thành tiền"); // 
        jLabel_donGia.setBounds(130, 305, 250, 30);
        jLabel_donGia.setFont(font_jLabel_viewMenu_ttsp1);

        jTextField_donGia = new JTextField();
        jTextField_donGia.setBounds(60, 335, 230, 30);
        jTextField_donGia.setBorder(lineBorder);
        jTextField_donGia.setHorizontalAlignment(JTextField.CENTER);
        jTextField_donGia.setDisabledTextColor(texfieldColor);
        jTextField_donGia.setEnabled(false);

        jButton_nhapHang = new JButton("Vào hàng chờ"); // 
        jButton_nhapHang.setBounds(100, 385, 150, 30);
        jButton_nhapHang.setBackground(new Color(0x29B6F6));
        jButton_nhapHang.setCursor(new Cursor(Cursor.HAND_CURSOR));

        ////---View hiển thị thông tin sản phẩm/ nằm trong View All Nhập Hàng
        JPanel jPanel_showThongTinSP = new JPanel();
        jPanel_showThongTinSP.setLayout(null);
        jPanel_showThongTinSP.setBounds(740, 10, 340, 440);
        jPanel_showThongTinSP.setBackground(Color.white);
        jPanel_showThongTinSP.setBorder(lineBorder_viewMenu1);

        jPanel_showThongTinSP.add(jLabel_ThongTin);
        jPanel_showThongTinSP.add(jLabel_maSP);
        jPanel_showThongTinSP.add(jTextField_maSP);
        jPanel_showThongTinSP.add(jLabel_tenSP);
        jPanel_showThongTinSP.add(jTextField_tenSP);
        jPanel_showThongTinSP.add(jLabel_soLuong);
        jPanel_showThongTinSP.add(jTextField_soLuong);
        jPanel_showThongTinSP.add(jLabel_donGia);
        jPanel_showThongTinSP.add(jTextField_donGia);
        jPanel_showThongTinSP.add(jButton_nhapHang);
        jPanel_showThongTinSP.add(jLabel_ncc);
        jPanel_showThongTinSP.add(jTextField_ncc);
        ///---Các thành phần trong View Thêm mới sp
        JLabel jLabel_ThongTinPN = new JLabel("Thêm mới sản phẩm"); // Thông tin phiếu nhập
        jLabel_ThongTinPN.setBounds(45, 20, 260, 60);
        jLabel_ThongTinPN.setFont(font_jLabel_viewMenu_ttsp);

        JLabel jLabel_nv = new JLabel("Người nhập"); // Người đứng ra nhập hàng về cho cửa hàng
        jLabel_nv.setBounds(15, 90, 100, 30);
        jLabel_nv.setFont(font_jLabel_viewMenu_ttsp1);

        jTextField_nv = new JTextField();
        jTextField_nv.setBounds(15, 120, 310, 30);
        jTextField_nv.setBorder(lineBorder);
        jTextField_nv.setHorizontalAlignment(JTextField.CENTER);
        jTextField_nv.setDisabledTextColor(texfieldColor);
        jTextField_nv.setEnabled(false);
        
        btnThemMoisp=new JButton("Tạo mới sản phẩm");
        btnThemMoisp.setBounds(70, 160, 200, 40);
        btnThemMoisp.setBackground(btnoldColor);
        ////---View hiển thị thông tin phiếu nhập/ nằm trong View All Nhập Hàng
        JPanel jPanel_showThongTinPN = new JPanel();
        jPanel_showThongTinPN.setLayout(null);
        jPanel_showThongTinPN.setBounds(740, 450, 340, 250);
        jPanel_showThongTinPN.setBackground(Color.WHITE);
        jPanel_showThongTinPN.setBorder(lineBorder_viewMenu1);

        jPanel_showThongTinPN.add(jLabel_ThongTinPN);
        jPanel_showThongTinPN.add(btnThemMoisp);
//        jPanel_showThongTinPN.add(jTextField_ncc);
        jPanel_showThongTinPN.add(jLabel_nv);
        jPanel_showThongTinPN.add(jTextField_nv);
        

        ////---View hiển thị thông tin table/ nằm trong View All Nhập Hàng
        /////---View All phần Nhập hàng
        jPanel_nh = new JPanel(); //phần view của nút "Nhập hàng"\
        jPanel_nh.setLayout(null);
        jPanel_nh.setBounds(0, 30, 1080, 700);
        jPanel_nh.setBackground(Color.WHITE);

        jPanel_nh.add(jPanel_showTable);
        jPanel_nh.add(jPanel_showThongTinSP);
        jPanel_nh.add(jPanel_showThongTinPN);

        //*********//
        jPanel_nh.setVisible(true);

//----------------------------------------------------------------------------------------------- 
        ///---Các thành phần trong "Quản lý phiếu nhập"
        //--- View Phiếu nhập/ là thành phần của JPanel_pn
        JLabel jLabel_phieuNhap = new JLabel("Phiếu nhập"); // Phiếu nhập
        jLabel_phieuNhap.setBounds(105, 10, 190, 60);
        jLabel_phieuNhap.setFont(font_jLabel_viewMenu_ttsp);

        jButton_refresh_pn = new JButton(icon_refresh); // nút refresh
        jButton_refresh_pn.setBounds(250, 23, 40, 40);
        jButton_refresh_pn.setBackground(Color.white);
        jButton_refresh_pn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton_refresh_pn.setOpaque(true);

        //---Panel_table/ nằm trong Panel_pn
        String mean_phieuNhap[][] = null;
        model_phieuNhap = new DefaultTableModel(mean_phieuNhap, title_phieuNhap);
        jTable_phieuNhap = new JTable(model_phieuNhap);
        jTable_phieuNhap.getTableHeader().setForeground(Color.BLACK);
        jTable_phieuNhap.getTableHeader().setBackground(new Color(0x29B6F6));
        jTable_phieuNhap.getTableHeader().setFont(new Font("Serif", Font.BOLD, 18));
        jTable_phieuNhap.setFont(new Font("Serif", 0, 16));
        jTable_phieuNhap.setRowHeight(30);
        layDSphieuNhap();
        jTable_phieuNhap.getColumnModel().getColumn(0).setPreferredWidth(130);
        jTable_phieuNhap.getColumnModel().getColumn(1).setPreferredWidth(130);
        jTable_phieuNhap.getColumnModel().getColumn(2).setPreferredWidth(300);

//        DefaultTableCellRenderer centerRenderer1 = new DefaultTableCellRenderer();
//        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTable_phieuNhap.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        jTable_phieuNhap.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        jTable_phieuNhap.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

        //Tạo JScrollPane để chứa thằng JTable
        JScrollPane jScrollPane_jTable_phieuNhap = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane_jTable_phieuNhap.setViewportView(jTable_phieuNhap);
        jScrollPane_jTable_phieuNhap.setBounds(0, 0, 390, 390);

        //-------------------------------------
        jPanel_table_pn = new JPanel(); // chứa bảng ScrollPane và chứa bảng table
        jPanel_table_pn.setLayout(null);
        jPanel_table_pn.setBounds(5, 90, 390, 400);
        jPanel_table_pn.setBorder(lineBorder_viewMenu1);
        jPanel_table_pn.setBackground(Color.white);

        jPanel_table_pn.add(jScrollPane_jTable_phieuNhap);


        //----------------Search phiếu nhập
        bt_NgayNhap = new JButton("Tìm kiếm theo ngày");
        bt_NgayNhap.setFont(new Font("Serif", 0, 15));
        bt_NgayNhap.setBounds(110, 500, 180, 35);
        bt_NgayNhap.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bt_NgayNhap.setBackground(btnoldColor);
        bt_NgayNhap.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	btnTimKiemNgay.setVisible(true);
                jPanel_timKiemTheoNgay.setVisible(true);

            }
        });

        

        //---------------Search theo ngày-----------------
        tuNgay = new JLabel("Từ ngày:");
        tuNgay.setBounds(10, 5, 100, 30);

        dateNgayNhapTu = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        nhapTuNgay = new JSpinner(dateNgayNhapTu);
        nhapTuNgay.setBounds(75, 5, 100, 30);
        JSpinner.DateEditor editor1 = new JSpinner.DateEditor(nhapTuNgay, "dd/MM/yyyy");
        nhapTuNgay.setEditor(editor1);

//
        denNgay = new JLabel("đến ngày:");
        denNgay.setBounds(200, 5, 100, 30);
//
        dateNgayToi = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        nhapDenNgay = new JSpinner(dateNgayToi);
        nhapDenNgay.setBounds(275, 5, 100, 30);
        JSpinner.DateEditor editor2 = new JSpinner.DateEditor(nhapDenNgay, "dd/MM/yyyy");
        nhapDenNgay.setEditor(editor2);

        jPanel_timKiemTheoNgay = new JPanel();
        jPanel_timKiemTheoNgay.setLayout(null);
        jPanel_timKiemTheoNgay.setBackground(Color.white);
        jPanel_timKiemTheoNgay.setBounds(0, 560, 390, 45);
        jPanel_timKiemTheoNgay.setVisible(false);

        jPanel_timKiemTheoNgay.add(tuNgay);
        jPanel_timKiemTheoNgay.add(nhapTuNgay);
        jPanel_timKiemTheoNgay.add(denNgay);
        jPanel_timKiemTheoNgay.add(nhapDenNgay);

        



        //------------------Phiếu nhập------Con của View chính---------------
        btnTimKiemNgay=new JButton("Tìm kiếm");
        btnTimKiemNgay.setBounds(140, 615, 120, 30);
        btnTimKiemNgay.setFont(font_jLabel_viewMenu_ttsp1);
        btnTimKiemNgay.setBackground(btnoldColor);
        btnTimKiemNgay.setVisible(false);
        
        
        
        
        JPanel jPanel_pn = new JPanel(); //Phiếu nhập
        jPanel_pn.setLayout(null);
        jPanel_pn.setBounds(5, 5, 400, 700);
        jPanel_pn.setBorder(lineBorder_viewMenu1);
        jPanel_pn.setBackground(Color.white);

        jPanel_pn.add(jLabel_phieuNhap);
        jPanel_pn.add(jButton_refresh_pn);
//        jPanel_pn.add(jPanel_ttpn);
        jPanel_pn.add(jPanel_table_pn);
        jPanel_pn.add(jPanel_timKiemTheoNgay);
        jPanel_pn.add(bt_NgayNhap);
        jPanel_pn.add(btnTimKiemNgay);
        //----------Chi tiết phiếu nhập-----con của View chính
        ///---Các thành phần trong Chi tiết phiếu nhập---
        JLabel jLabel_chiTietPN = new JLabel("Chi tiết phiếu nhập"); // tiêu đề
        jLabel_chiTietPN.setBounds(170, 20, 380, 50);
        jLabel_chiTietPN.setFont(font_jLabel_viewMenu_table);

        JLabel jLabel_ctSanPham = new JLabel("Sản phẩm"); // chi tiết Sản phẩm
        jLabel_ctSanPham.setBounds(110, 95, 90, 30);
        jLabel_ctSanPham.setFont(font_jLabel_viewMenu_ttsp1);
        jTextField_ctSanPham = new JTextField();
        jTextField_ctSanPham.setBounds(110, 125, 200, 30);
//        jTextField_ctSanPham.setBorder(lineBorder_viewMenu1);
        jTextField_ctSanPham.setFont(font_jLabel_viewMenu_ttsp1);
        jTextField_ctSanPham.setBorder(lineBorder);
        jTextField_ctSanPham.setHorizontalAlignment(JTextField.CENTER);
        jTextField_ctSanPham.setDisabledTextColor(texfieldColor);
        jTextField_ctSanPham.setEnabled(false);

        JLabel jLabel_ctSoLuong = new JLabel("Số lượng"); // chi tiết Số lượng
        jLabel_ctSoLuong.setBounds(370, 95, 90, 30);
        jLabel_ctSoLuong.setFont(font_jLabel_viewMenu_ttsp1);
        jTextField_ctSoLuong = new JTextField();
        jTextField_ctSoLuong.setBounds(370, 125, 200, 30);
        jTextField_ctSoLuong.setFont(font_jLabel_viewMenu_ttsp1);
        jTextField_ctSoLuong.setBorder(lineBorder);
        jTextField_ctSoLuong.setHorizontalAlignment(JTextField.CENTER);
        jTextField_ctSoLuong.setDisabledTextColor(texfieldColor);
        jTextField_ctSoLuong.setEnabled(false);

        JLabel jLabel_ctDonGia = new JLabel("Đơn giá"); // chi tiết Đơn giá
        jLabel_ctDonGia.setBounds(110, 175, 90, 30);
        jLabel_ctDonGia.setFont(font_jLabel_viewMenu_ttsp1);
        jTextField_ctDonGia = new JTextField();
        jTextField_ctDonGia.setBounds(110, 205, 200, 30);
        jTextField_ctDonGia.setFont(font_jLabel_viewMenu_ttsp1);
        jTextField_ctDonGia.setBorder(lineBorder);
        jTextField_ctDonGia.setHorizontalAlignment(JTextField.CENTER);
        jTextField_ctDonGia.setDisabledTextColor(texfieldColor);
        jTextField_ctDonGia.setEnabled(false);

        JLabel jLabel_ctThanhTien = new JLabel("Thành tiền"); // chi tiết Thành tiền
        jLabel_ctThanhTien.setBounds(370, 175, 90, 30);
        jLabel_ctThanhTien.setFont(font_jLabel_viewMenu_ttsp1);
        jTextField_ctThanhTien = new JTextField();
        jTextField_ctThanhTien.setBounds(370, 205, 200, 30);
        jTextField_ctThanhTien.setFont(font_jLabel_viewMenu_ttsp1);
        jTextField_ctThanhTien.setBorder(lineBorder);
        jTextField_ctThanhTien.setHorizontalAlignment(JTextField.CENTER);
        jTextField_ctThanhTien.setDisabledTextColor(texfieldColor);
        jTextField_ctThanhTien.setEnabled(false);

        //-----------------------------------------------------------
        JPanel jPanel_chiTietPN = new JPanel(); // chứa thông tin chi tiết phiếu nhập
        jPanel_chiTietPN.setLayout(null);
        jPanel_chiTietPN.setBounds(0, 0, 680, 260);
        jPanel_chiTietPN.setBackground(Color.white);

        jPanel_chiTietPN.add(jLabel_chiTietPN);
        jPanel_chiTietPN.add(jLabel_ctSanPham);
        jPanel_chiTietPN.add(jTextField_ctSanPham);
        jPanel_chiTietPN.add(jLabel_ctSoLuong);
        jPanel_chiTietPN.add(jTextField_ctSoLuong);
        jPanel_chiTietPN.add(jLabel_ctDonGia);
        jPanel_chiTietPN.add(jTextField_ctDonGia);
        jPanel_chiTietPN.add(jLabel_ctThanhTien);
        jPanel_chiTietPN.add(jTextField_ctThanhTien);

        //--------------------------------------------------------------
        //nằm trong jPanel_jTable_chiTietPN
        String mean_ctPhieuNhap[][] = null;
        model_ctPhieuNhap = new DefaultTableModel(mean_ctPhieuNhap, title_ctPhieuNhap);
        jTable_ctPhieuNhap = new JTable(model_ctPhieuNhap);
        jTable_ctPhieuNhap.getTableHeader().setForeground(Color.BLACK);
        jTable_ctPhieuNhap.getTableHeader().setBackground(new Color(0x29B6F6));
        jTable_ctPhieuNhap.getTableHeader().setFont(new Font("Serif", Font.BOLD, 18));
        jTable_ctPhieuNhap.setFont(new Font("Serif", 0, 16));
        jTable_ctPhieuNhap.setRowHeight(30);
        layDSphieuNhapCT();

        jTable_ctPhieuNhap.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTable_ctPhieuNhap.getColumnModel().getColumn(1).setPreferredWidth(104);
        jTable_ctPhieuNhap.getColumnModel().getColumn(2).setPreferredWidth(140);
        jTable_ctPhieuNhap.getColumnModel().getColumn(3).setPreferredWidth(160);

        jTable_ctPhieuNhap.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        jTable_ctPhieuNhap.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        jTable_ctPhieuNhap.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        jTable_ctPhieuNhap.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

        //Tạo JScrollPane để chứa thằng JTable
        JScrollPane jScrollPane_jTable_ctPhieuNhap = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane_jTable_ctPhieuNhap.setViewportView(jTable_ctPhieuNhap);
        jScrollPane_jTable_ctPhieuNhap.setBounds(0, 0, 665, 380);

        JPanel jPanel_jTable_chiTietPN = new JPanel(); // chứa bảng table
        jPanel_jTable_chiTietPN.setLayout(null);
        jPanel_jTable_chiTietPN.setBounds(11, 275, 665, 380);
        jPanel_jTable_chiTietPN.setBorder(lineBorder_viewMenu1);
        jPanel_jTable_chiTietPN.setBackground(Color.white);

        jPanel_jTable_chiTietPN.add(jScrollPane_jTable_ctPhieuNhap);

        JPanel jPanel_ctpn = new JPanel(); //Chi tiết phiếu nhập
        jPanel_ctpn.setLayout(null);
        jPanel_ctpn.setBounds(405, 5, 680, 700);
        jPanel_ctpn.setBorder(lineBorder_viewMenu1);
        jPanel_ctpn.setBackground(Color.white);

        jPanel_ctpn.add(jPanel_chiTietPN);
        jPanel_ctpn.add(jPanel_jTable_chiTietPN);

        /////---View All phần "Quản lý phiếu nhập"--- View chính-------------------------------------
        jPanel_qlpn = new JPanel();
        jPanel_qlpn.setLayout(null);
        jPanel_qlpn.setBounds(0, 30, 1080, 700);
        jPanel_qlpn.setBackground(Color.WHITE);

        jPanel_qlpn.add(jPanel_pn);
        jPanel_qlpn.add(jPanel_ctpn);

        jPanel_qlpn.setVisible(false);

        dlnhap = new dialogNhapHangGUI();

        jLabel_Dialog_nh = new JLabel(new ImageIcon("./src/IMG/nhap.jpg"));
        jLabel_Dialog_nh.setLayout(null);
        jLabel_Dialog_nh.setBounds(655, 10, 75, 75);
        jLabel_Dialog_nh.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabel_Dialog_nh.setBackground(Color.WHITE);
        jPanel_showTable.add(jLabel_Dialog_nh);
        jLabel_Dialog_nh.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
                dlnhap.mouseClicked_jLabel_Dialog_nh();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                mouseExited_dialog_nh();

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                mouseEntered_dialog_nh();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });

//        this.add(jLabel_Dialog_nh);
        this.add(jPanel_menu_head);
        this.add(jPanel_nh);
        this.add(jPanel_qlpn);

        this.setBackground(Color.white);
        this.setVisible(false);
    }
    //-------------------------------------ViewMenu------------------------------------------
    //Nhấp chuột

    public void mouseEntered_dialog_nh() {
        jLabel_Dialog_nh.setBackground(new Color(0xB3E5FC));
        jLabel_Dialog_nh.setOpaque(true);
    }

    public void mouseExited_dialog_nh() {
        jLabel_Dialog_nh.setBackground(Color.WHITE);
        jLabel_Dialog_nh.setOpaque(true);
    }

    public void mousePressed_jLabel_qlpn() { //Sự kiện khi nhấp chuột vào "Quản lý phiếu nhập"
        jPanel_nh.setVisible(false);
        jPanel_qlpn.setVisible(true);
        jLabel_qlpn.setOpaque(true);
        jLabel_qlpn.setBackground(Color.white);
        jLabel_nh.setOpaque(true);
        jLabel_nh.setBackground(new Color(0xE0E0E0));
    }

    public void mousePressed_jLabel_nh() { //Sự kiện khi nhấp chuột vào "Nhập hàng"
        jPanel_nh.setVisible(true);
        jPanel_qlpn.setVisible(false);
        jLabel_qlpn.setOpaque(true);
        jLabel_qlpn.setBackground(new Color(0xE0E0E0));
        jLabel_nh.setOpaque(true);
        jLabel_nh.setBackground(Color.WHITE);

    }
    
    public void layDuLieuSP() {
//		"Mã SP","Tên SP","Đơn giá","Còn lại","Đơn vị tính","Hạn sử dụng"
		DefaultTableModel model = (DefaultTableModel) jTable_nhapHang.getModel();
		for (MatHangDTO mh : MatHangBUS.getInstance().getList()) {
			Vector<String> row=new Vector<>();
			int soluong=mh.getSlNhap()-mh.getSlBan();
			row.add(mh.getMaMh());
			row.add(mh.getTenMh());
			row.add(soluong+"");
			model.addRow(row);
		}
    }
    MatHangDTO matHang=new MatHangDTO();
    public void xuLySuKienTBnhapHang() {
    	int row= jTable_nhapHang.getSelectedRow();
    	String maSP=jTable_nhapHang.getModel().getValueAt(row, 0).toString();
    	String tenSP=jTable_nhapHang.getModel().getValueAt(row, 1).toString();
    	
    	matHang.setMaMh(maSP);
    	matHang=MatHangBUS.getInstance().getById(matHang);
    	
    	
    	
    	jTextField_maSP.setText(maSP);
    	jTextField_tenSP.setText(tenSP);
    	jTextField_soLuong.setText("1");
//    	layDSNCC();
//    	jTextField_ncc.setText(madvt);
    }
    public void xuLyThanhTien() {
    	String sl = jTextField_soLuong.getText();
		if(sl==null) {
			jTextField_donGia.setText("");
			return;
		}
		else {
			int soluong=Integer.parseInt(sl);
			double gianhap=matHang.getGiaMua();
			double thanhTien=soluong*gianhap;
			jTextField_donGia.setText(dcf.format(thanhTien)+" VND");
		}
    }
    public void layDSNCC() {
//		cbloaihang.setEnabled(true);
    	Vector<String> ten=new Vector<>();
    	ten.add("Chọn NCC");
		for (String ncc : NhaCungCapBUS.getInstance().listTenNCC()) {
			ten.add(ncc);
		}
		DefaultComboBoxModel<String>cbmodel=new DefaultComboBoxModel<>(ten);
		jTextField_ncc.setModel(cbmodel);
	}
    public void layDSphieuNhap() {
    	DefaultTableModel model=(DefaultTableModel)jTable_phieuNhap.getModel();
    	for (PhieuNhap phieuNhap : PhieuNhapBUS.getInstance().getList()) {
			Vector<String> vec=new Vector<>();
			vec.add(phieuNhap.getMaPN());
			vec.add(phieuNhap.getMaNV());
			vec.add(sdf.format(phieuNhap.getDate()));
			model.addRow(vec);
		}
    }
    public void layDSphieuNhapCT() {
    	DefaultTableModel model=(DefaultTableModel)jTable_ctPhieuNhap.getModel();
    	for (PhieuNhapCT phieunhapct : PhieuNhapCTBUS.getInstance().getList()) {
			Vector<String> vec=new Vector<>();
			vec.add(phieunhapct.getMaPN());
			vec.add(phieunhapct.getMaMH());
			vec.add(phieunhapct.getMaNCC());
			vec.add(phieunhapct.getSl()+"");
			model.addRow(vec);
		}
    }
    public void delTablePhieuNhap() {
    	DefaultTableModel model=(DefaultTableModel)jTable_phieuNhap.getModel();
    	model.setRowCount(0);
    }
    public void delTablePhieuNhapCT() {
    	DefaultTableModel model=(DefaultTableModel)jTable_ctPhieuNhap.getModel();
    	model.setRowCount(0);
    }
    public void delTableNhapHang() {
    	DefaultTableModel model=(DefaultTableModel)jTable_nhapHang.getModel();
    	model.setRowCount(0);
    }
    public void layDSchiTietPhieuNhapTheoMa(String maPN) {
    	delTablePhieuNhapCT();
    	DefaultTableModel model=(DefaultTableModel)jTable_ctPhieuNhap.getModel();
    	for (PhieuNhapCT phieunhapct : PhieuNhapCTBUS.getInstance().layDStheoMaPN(maPN)) {
			Vector<String> vec=new Vector<>();
			vec.add(phieunhapct.getMaPN());
			vec.add(phieunhapct.getMaMH());
			vec.add(phieunhapct.getMaNCC());
			vec.add(phieunhapct.getSl()+"");
			model.addRow(vec);
		}
    }
    public void clearViewNhapHang() {
    	delTableNhapHang();
    	layDuLieuSP();
    	jTextField_maSP.setText("");
    	jTextField_tenSP.setText("");
    	layDSNCC();
    	jTextField_soLuong.setText("0");
    	
    }
    public void clearViewQLphieu() {
    	delTablePhieuNhap();
    	delTablePhieuNhapCT();
    	layDSphieuNhap();
    	layDSphieuNhapCT();
    	jTextField_ctSanPham.setText("");
		jTextField_ctSoLuong.setText("");
		jTextField_ctDonGia.setText("");
		jTextField_ctThanhTien.setText("");
    	
    }
    public ArrayList<MatHangDTO> dsTimTenSPganDung() {
    	ArrayList<MatHangDTO> list=new ArrayList<>();
    	String tenSP=jTextField_timKiem.getText();
    	for (MatHangDTO matHang : MatHangBUS.getInstance().getList()) {
			if(CheckLoi.similarity(tenSP, matHang.getTenMh())>0.4) {
				list.add(matHang);
			}
		}
    	return list;
    }
    public void XulyTimTenSPganDung() {
    	DefaultTableModel model=(DefaultTableModel) jTable_nhapHang.getModel();
    	model.setRowCount(0);
    	for (MatHangDTO mathang : dsTimTenSPganDung()) {
			Vector<String> vec=new Vector<>();
			vec.add(mathang.getMaMh());
			vec.add(mathang.getTenMh());
			vec.add((mathang.getSlNhap()-mathang.getSlBan())+"");
			model.addRow(vec);
		}
    }
    public void xuLyLayDStheoKhoanTG() {
    	Date tuNgay=(Date) nhapTuNgay.getValue();
    	Date denNgay=(Date)nhapDenNgay.getValue();
    	DefaultTableModel model=(DefaultTableModel)jTable_phieuNhap.getModel();
    	delTablePhieuNhap();
    	for (PhieuNhap pn : PhieuNhapBUS.getInstance().layPhieuNhapTheoKhoangThoiGian(tuNgay, denNgay)) {
			Vector<String> vec=new Vector<>();
			vec.add(pn.getMaPN());
			vec.add(pn.getMaNV());
			vec.add(sdf.format(pn.getDate()));
			model.addRow(vec);
		}
    }
    
    public void addEvent() {
    	jTable_nhapHang.addMouseListener(new MouseAdapter() {
    		public void mousePressed(MouseEvent e) {
    			xuLySuKienTBnhapHang();
    		}
		});
    	jTextField_soLuong.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if(!CheckLoi.isInteger(jTextField_soLuong.getText())) {
					new ThongBaoDialog("Số lượng không khả dụng", ThongBaoDialog.ERROR_DIALOG);
					return;
				}
				xuLyThanhTien();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
//				String inputString = e.getDocument().getText(0, e.getDocument().getLength());
				if(jTextField_soLuong.getText().toString()=="" || jTextField_soLuong.getText().toString().isEmpty()) {
					jTextField_donGia.setText("0 VND");
					return;
				}
				else
					xuLyThanhTien();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				if(!CheckLoi.isInteger(jTextField_soLuong.getText())) {
					new ThongBaoDialog("Số lượng không khả dụng", ThongBaoDialog.ERROR_DIALOG);
					return;
				}
//				throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods,
				xuLySuKienTBnhapHang();													// choose Tools | Templates.
			}

		});
    	jButton_nhapHang.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(jTextField_ncc.getSelectedIndex()==0) {
					new ThongBaoDialog("Chưa chọn nhà cung cấp", ThongBaoDialog.ERROR_DIALOG);
					return;
				}
				dlnhap.xuLyThemVaoHangCho();
			}
		});
    	jTable_phieuNhap.addMouseListener(new MouseAdapter() {
    		public void mousePressed(MouseEvent e) {
    			int row=jTable_phieuNhap.getSelectedRow();
    			String maPN=jTable_phieuNhap.getValueAt(row, 0).toString();
    			layDSchiTietPhieuNhapTheoMa(maPN);
    		}
		});
    	jTable_ctPhieuNhap.addMouseListener(new MouseAdapter() {
    		public void mousePressed(MouseEvent e) {
    			int row=jTable_ctPhieuNhap.getSelectedRow();
    			int soLuong=Integer.parseInt(jTable_ctPhieuNhap.getValueAt(row, 3).toString());
    			String maSP= jTable_ctPhieuNhap.getValueAt(row, 1).toString();
    			MatHangDTO matHang=new MatHangDTO();
    			matHang.setMaMh(maSP);
    			matHang=MatHangBUS.getInstance().getById(matHang);
    			double thanhTien=matHang.getGiaMua()*soLuong;
    			jTextField_ctSanPham.setText(matHang.getTenMh());
    			jTextField_ctSoLuong.setText(soLuong+"");
    			jTextField_ctDonGia.setText(dcf.format(matHang.getGiaMua())+" VND");
    			jTextField_ctThanhTien.setText(dcf.format(thanhTien)+" VND");
    		}
		});
    	jButton_refresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clearViewNhapHang();
			}
		});
    	jButton_refresh_pn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clearViewQLphieu();
			}
		});
    	jButton_timKiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				XulyTimTenSPganDung();
			}
		});
    	btnThemMoisp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int maMHnew =MatHangBUS.getInstance().getMaMHmoiNhat()+1;
				String maSP="00"+maMHnew;
				dladdMatHangGUI dl=new dladdMatHangGUI();
				dl.setVisible(true);
				dl.tfmamh.setText(maSP);
			}
		});
    	btnTimKiemNgay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLyLayDStheoKhoanTG();
			}
		});
    	

    }

}
