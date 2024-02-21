
package GUI;

import BUS.NhanVienBUS;
import DTO.DTO_KhachHang;
import DTO.DTO_NhanVien;
import javax.swing.JPanel;
//import BUS.LoaiBUS;
//import BUS.NsxBUS;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.BorderFactory.createLineBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
//import DTO.SanPhamDTO;
//import BUS.SanPhamBUS;
//import DTO.LoaiDTO;
//import DTO.NsxDTO;
import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.RowFilter;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class NhanVienGUI extends JPanel {

    public NhanVienGUI() {
        init();
        this.setVisible(false);
    }
    private JTable tb1;
    private JScrollPane jScrollPane1;
    public JLabel title, txtrefresh, txtsearch;
    public static JLabel btnadd, btnedit, btndelete;
    private JLabel buttons[];
    private JTextField textfields[], tftimkiem;
    private JPanel filter;

    //------
    private DefaultTableModel tb2;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private DecimalFormat dcf = new DecimalFormat("###,###");
    private NhanVienBUS nhanVienBUS;
    private String[] mangNV = new String[0];
    private String[] mean = new String[0];
    private String[] title1 = {"Mã NV", "Tên NV", "Ngày sinh", "Giới tính", "CMND", "Địa chỉ", "Điện thoại", "Ngày vào làm"};
    public JButton bt_MaNV, bt_gioiTinh, bt_DiaChi, bt_NgayVaoLam;
    public static JComboBox<String> cbMaNV;
    public static JComboBox<String> cbDiaChi;
    public static JComboBox<String> cbPhai;
    private String[] listMaNV = {"Chọn mã"};
    private String[] listDiaChi = {"Chọn địa chỉ"};
    private String[] listPhai = {"Chọn giới tính", "Nam", "Nữ"};
    private JLabel ngayTu, denNgay;
    private SpinnerDateModel dateTuNgay, dateToiNgay;
    public static JSpinner nvvTuNgay;
    public static JSpinner nvvDenNgay;
    public JLabel btnsearch;

    public void init() {

        ActionListener ac = new NhanVienEvent(this);
        MouseListener mouse = new NhanVienEvent(this);

        setLayout(null);
        setPreferredSize(new Dimension(1100, 700));
        setBackground(new Color(0xEEEEEE));
        title = new JLabel("QUẢN LÍ NHÂN VIÊN");
        title.setBounds(390, 10, 305, 40);
        title.setFont(new Font("Serif", Font.BOLD, 25));
        add(title);

        //icon= new ImageIcon("/images/refresh_40px.png");
        txtrefresh = new JLabel();
        txtrefresh.setIcon(new ImageIcon("./src/IMG/Refresh-icon.png"));
        txtrefresh.setBounds(650, 10, 30, 30);
        txtrefresh.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(txtrefresh);

        buttons = new JLabel[8];
        textfields = new JTextField[8];
        int toadoyButton = 70;
        String[] arrBtn = {"Mã NV", "Họ Tên", "Ngày Sinh", "Phái", "CCCD", "Địa Chỉ", "Điện thoại", "Ngày Vào Làm"};
        for (int i = 0; i < 8; i++) {
            buttons[i] = new JLabel(arrBtn[i]);
            buttons[i].setBounds(275, toadoyButton, 135, 25);
            buttons[i].setFont(new Font("Serif", Font.BOLD, 20));
            textfields[i] = new JTextField();
            textfields[i].setBounds(410, toadoyButton, 250, 25);
            textfields[i].setFont(new Font("Serif", 0, 20));
            toadoyButton += 30;
            add(buttons[i]);
            add(textfields[i]);
        }
        textfields[0].setEditable(false);
        textfields[7].setEditable(false);

        tftimkiem = new JTextField();
        tftimkiem.setBackground(Color.WHITE);
        //tftimkiem.setOpaque(false);
        tftimkiem.setBounds(new Rectangle(730, 280, 250, 25));
        tftimkiem.setFont(new Font("Serif", 0, 20));
        add(tftimkiem);

        txtsearch = new JLabel();
        txtsearch.setBounds(new Rectangle(980, 270, 40, 40));
        txtsearch.setIcon(new ImageIcon("./src/IMG/search_25px.png"));
        txtsearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(txtsearch);

        btnadd = new JLabel();
        btnadd.setIcon(new ImageIcon("./src/IMG/btnAdd_150px.png"));
        btnadd.setBounds(800, 65, 200, 50);
        btnadd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnadd.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	int maNVnew= NhanVienBUS.getIntance().getMaNVmoiNhat();
            	maNVnew++;
                String maNV = "NV"+maNVnew;
                String hoTen = textfields[1].getText();
                String ngaySinh = textfields[2].getText();
                String gioiTinh = textfields[3].getText();
                String cmnd = textfields[4].getText();
                String diaChi = textfields[5].getText();
                String sdt = textfields[6].getText();
                if(CheckLoi.isEmptyString(hoTen)||CheckLoi.isValidDate(ngaySinh, "dd/MM/yyyy")==false||CheckLoi.checkGioiTinh(gioiTinh)==false||!CheckLoi.isDouble(cmnd)) {
                	new ThongBaoDialog("Thêm lỗi", ThongBaoDialog.ERROR_DIALOG);
//                	System.out.println(CheckLoi.isEmptyString(hoTen));
//                	System.out.println(CheckLoi.isValidDate(ngaySinh, "dd/MM/yyyy")==false);
//                	System.out.println(CheckLoi.checkGioiTinh(gioiTinh)==false);
//                	System.out.println(!CheckLoi.isDouble(cmnd));
                	if(CheckLoi.isEmptyString(hoTen))
                		textfields[1].setText("");
                	if(CheckLoi.isValidDate(ngaySinh, "dd/MM/yyyy")==false) {
                		textfields[2].setText("");
                	}
                	if(CheckLoi.checkGioiTinh(gioiTinh)==false)
                		textfields[3].setText("");
                	if(!CheckLoi.isDouble(cmnd)) {
                		textfields[4].setText("");
                	}
                	
                	return;
                }
                Date ngayVaoLam=new Date();
                Date date_ngaySinh =null;
                try {
                	date_ngaySinh = sdf.parse(ngaySinh);
				} catch (Exception e2) {
					// TODO: handle exception
				}
                DTO_NhanVien nv=new DTO_NhanVien(maNV, hoTen, date_ngaySinh, gioiTinh, cmnd, diaChi, sdt, ngayVaoLam, null);
               

                int i = JOptionPane.showConfirmDialog(null, "Xác nhận thêm", "Thông báo!", JOptionPane.YES_NO_OPTION);
                if (i == 0) {
                    NhanVienBUS.getIntance().insert(nv);
                    loadDataLenBangSanPham();
                    cleanView();
                }
            }
        });
        btnedit = new JLabel();
        btnedit.setIcon(new ImageIcon("./src/IMG/btnEdit_150px.png"));
        btnedit.setBounds(800, 115, 200, 50);
        btnedit.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnedit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                String maNV = textfields[0].getText();
                String hoTen = textfields[1].getText();
                String ngaySinh = textfields[2].getText();
                String gioiTinh = textfields[3].getText();
                String cmnd = textfields[4].getText();
                String diaChi = textfields[5].getText();
                String sdt = textfields[6].getText();
                if(CheckLoi.isEmptyString(hoTen)||CheckLoi.isValidDate(ngaySinh, "dd/MM/yyyy")==false||CheckLoi.checkGioiTinh(gioiTinh)==false||CheckLoi.isDouble(cmnd)) {
                	new ThongBaoDialog("Sửa lỗi", ThongBaoDialog.ERROR_DIALOG);
                	return;
                }
                Date date_ngaySinh =null;
                try {
                	date_ngaySinh = sdf.parse(ngaySinh);
				} catch (Exception e2) {
					// TODO: handle exception
				}
                

                DTO_NhanVien nv = new DTO_NhanVien();
                nv.setMaNV(maNV);
                nv.setHoTen(hoTen);
                nv.setNgaySinh(date_ngaySinh);
                nv.setGioiTinh(gioiTinh);
                nv.setCmnd(cmnd);
                nv.setDiaChi(diaChi);
                nv.setSdt(sdt);
                

                int i = JOptionPane.showConfirmDialog(null, "Xác nhận cập nhập", "Thông báo!", JOptionPane.YES_NO_OPTION);
                if (i == 0) {
                    NhanVienBUS.getIntance().capNhat(nv);
                    loadDataLenBangSanPham();
                    cleanView();
                }
            }
        });

        btndelete = new JLabel();
        btndelete.setIcon(new ImageIcon("./src/IMG/btnDelete_150px.png"));
        btndelete.setBounds(800, 165, 200, 50);
        btndelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btndelete.addMouseListener(new MouseAdapter() {
        	 public void mouseClicked(MouseEvent e) {
                 String maNV = textfields[0].getText();
                 DTO_NhanVien nv=new DTO_NhanVien();
                 nv.setMaNV(maNV);
                 int i = JOptionPane.showConfirmDialog(null, "Xác nhận xóa", "Thông báo!", JOptionPane.YES_NO_OPTION);
                 if (i == 0) {
                     NhanVienBUS.getIntance().delete(nv);
                     loadDataLenBangSanPham();
                     cleanView();
                 }
        	 }
		});
//        btnchonanh= new JLabel();
//        btnchonanh.setIcon(new ImageIcon(MatHangGUI.class.getResource("/images/btnFile.png")));
//        btnchonanh.setBounds(800,215,200,50);
//        btnchonanh.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(btnadd);
        add(btnedit);
        add(btndelete);
        //add(btnchonanh);

        filter = new JPanel();
        filter.setLayout(null);
//        filter.setBackground(Color.red);
        filter.setBounds(0, 310, 1300 - 220, 100);
        add(filter);

        bt_MaNV = new JButton("Mã NV:");
        bt_MaNV.setBounds(150, 10, 90, 30);
        bt_MaNV.setFont(new Font("Serif", 0, 15));
        bt_MaNV.addActionListener(ac);

        cbMaNV = new JComboBox<String>(listMaNV);
        cbMaNV.setBounds(332 - 90, 10, 100, 30);
        cbMaNV.addActionListener(ac);
        cbMaNV.setEnabled(false);

        bt_gioiTinh = new JButton("Phái:");
        bt_gioiTinh.setBounds(380, 10, 90, 30);
        bt_gioiTinh.setFont(new Font("Serif", 0, 15));
        bt_gioiTinh.addActionListener(ac);

        cbPhai = new JComboBox<String>(listPhai);
        cbPhai.setBounds(472, 10, 130, 30);
        cbPhai.addActionListener(ac);
        cbPhai.setEnabled(false);

        bt_DiaChi = new JButton("Địa chỉ:");
        bt_DiaChi.setBounds(660, 10, 90, 30);
        bt_DiaChi.setFont(new Font("Serif", 0, 15));
        bt_DiaChi.addActionListener(ac);

        cbDiaChi = new JComboBox<String>(listDiaChi);
        cbDiaChi.setBounds(752, 10, 180, 30);
        cbDiaChi.addActionListener(ac);
        cbDiaChi.setEnabled(false);

        //-----------------------------------
        bt_NgayVaoLam = new JButton("Ngày vào làm");
        bt_NgayVaoLam.setFont(new Font("Serif", 0, 15));
        bt_NgayVaoLam.setBounds(225, 60, 100, 30);
        bt_NgayVaoLam.addActionListener(ac);

        ngayTu = new JLabel("Từ ngày:");
        ngayTu.setBounds(345, 60, 100, 30);

        dateTuNgay = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        nvvTuNgay = new JSpinner(dateTuNgay);
        nvvTuNgay.setBounds(410, 60, 150, 35);
        JSpinner.DateEditor editor1 = new JSpinner.DateEditor(nvvTuNgay, "dd/MM/yyyy");
        nvvTuNgay.setEditor(editor1);
        nvvTuNgay.setEnabled(false);

        denNgay = new JLabel("đến ngày");
        denNgay.setBounds(585, 60, 100, 30);

        dateToiNgay = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        nvvDenNgay = new JSpinner(dateToiNgay);
        nvvDenNgay.setBounds(660, 60, 150, 35);
        JSpinner.DateEditor editor2 = new JSpinner.DateEditor(nvvDenNgay, "dd/MM/yyyy");
        nvvDenNgay.setEditor(editor2);
        nvvDenNgay.setEnabled(false);

//        lbmasp = new JLabel("Mã NV");
//        lbmasp.setBounds(110, 15, 60, 25);
//        lbmasp.setFont(new Font("Serif", 0, 15));
//
//        tfmasp = new JTextField();
//        tfmasp.setBounds(170, 15, 100, 25);
//
//        lbdiachi = new JLabel("Địa chỉ");
//        lbdiachi.setBounds(285, 15, 200, 25);
//        lbdiachi.setFont(new Font("Serif", 0, 15));
//
//        tfdiachi = new JTextField();
//        tfdiachi.setBounds(360, 15, 100, 25);
//        String s[] = {"Chọn giới tính", "Nam", "Nữ", "Không rõ"};
//
//        Gender = new JComboBox(s);
//        Gender.setBounds(480, 15, 150, 25);
//        Gender.setBackground(Color.WHITE);
//        Gender.setFont(new Font("Serif", 0, 15));
//
//        Gender.addMouseListener(new MouseAdapter() { // lọc bằng combobox giới tính
//            public void comboBoxOption(MouseEvent e) {
////                String selectedItem = (String )Gender.getSelectedItem(); // lấy xong ép thành kiểu dữ liệu String
////                System.out.println("Lựa chọn lọc của bạn là " + selectedItem);
//
//                //thông qua index
//                int index = Gender.getSelectedIndex();
//                if (index > 0) {
//                    String selectedValue = (String) Gender.getItemAt(index);
////                    System.out.println("Lấy giá trị thông qua stt của ListCombobox: " + selectedValue);
//                }
//            }
//        });
//        lbgiafrom = new JLabel("Ngày Vào Làm");
//        lbgiafrom.setFont(new Font("Serif", 0, 15));
//        lbgiafrom.setBounds(645, 15, 150, 25);
//        tfgiafrom = new JTextField();
//        tfgiafrom.setBounds(750, 15, 100, 25);
//        lbgiato = new JLabel("-");
//        lbgiato.setBounds(860, 15, 20, 25);
//        lbgiato.setFont(new Font("Serif", 0, 15));
//        tfgiato = new JTextField();
//        tfgiato.setBounds(870, 15, 100, 25);
        filter.add(bt_MaNV);
        filter.add(cbMaNV);
        filter.add(bt_DiaChi);
        filter.add(cbDiaChi);
        filter.add(bt_gioiTinh);
        filter.add(cbPhai);
        filter.add(bt_NgayVaoLam);
        filter.add(ngayTu);
        filter.add(nvvTuNgay);
        filter.add(denNgay);
        filter.add(nvvDenNgay);

        btnsearch = new JLabel();
        btnsearch.setBounds(830, 60, 40, 40);
//        btnsearch.setBackground(Color.blue);
        btnsearch.setOpaque(true);
        btnsearch.setIcon(new ImageIcon("./src/IMG/btnSearch_40px.png"));
        btnsearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnsearch.addMouseListener(mouse);
        filter.add(btnsearch);

        //--------------------
        nhanVienBUS = new NhanVienBUS();
        String mean1[][] = null;
        tb2 = new DefaultTableModel(mean1, title1);

        tb1 = new JTable(tb2);
//       tb1.setModel(new javax.swing.table.DefaultTableModel(
//            new Object [][] {             
//            },
//            new String [] {
//                "Mã NV", "Họ Tên","Ngày Sinh","Phái","CCCD","Địa chỉ","Điện thoại","Ngày Làm"
//            }
//        ));
        tb1.getTableHeader().setForeground(Color.BLACK);
        tb1.getTableHeader().setBackground(new Color(0x29B6F6));
        tb1.getTableHeader().setFont(new Font("Serif", Font.BOLD, 18));
        tb1.setFont(new Font("Serif", 0, 16));
        tb1.setRowHeight(25);

//        //---"Mã NV", "Họ Tên", "Ngày Sinh", "Giới tính", "CMND", "Địa Chỉ", "Điện thoại", "Ngày Vào Làm"
        tb1.getColumnModel().getColumn(0).setPreferredWidth(15); //Ma NV
        tb1.getColumnModel().getColumn(1).setPreferredWidth(115); //Ten NV
        tb1.getColumnModel().getColumn(2).setPreferredWidth(70); // Ngay sinh
        tb1.getColumnModel().getColumn(3).setPreferredWidth(20); // Gioi tinh 
        tb1.getColumnModel().getColumn(4).setPreferredWidth(70); // CMND
        tb1.getColumnModel().getColumn(5).setPreferredWidth(120); // Dia chi
        tb1.getColumnModel().getColumn(6).setPreferredWidth(70); // Dien thoai
        tb1.getColumnModel().getColumn(7).setPreferredWidth(70); // Ngay vao lam

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tb1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tb1.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

        tb1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int i = tb1.getSelectedRow();

                textfields[0].setText(tb1.getModel().getValueAt(i, 0).toString());
                textfields[1].setText(tb1.getModel().getValueAt(i, 1).toString());
                textfields[2].setText(tb1.getModel().getValueAt(i, 2).toString());
                textfields[3].setText(tb1.getModel().getValueAt(i, 3).toString());
                textfields[4].setText(tb1.getModel().getValueAt(i, 4).toString());
                textfields[5].setText(tb1.getModel().getValueAt(i, 5).toString());
                textfields[6].setText(tb1.getModel().getValueAt(i, 6).toString());
                textfields[7].setText(tb1.getModel().getValueAt(i, 7).toString());

            }
        });

        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setBounds(80, 410, 900, 250);
        jScrollPane1.setViewportView(tb1);
        getDsNV();
//        getDsGioiTinh();
        add(jScrollPane1);
    }

    public void getDsNV() {
//		"Mã NV", "Họ Tên", "Ngày Sinh", "Giới tính", "CMND", "Địa Chỉ", "Điện thoại", "Ngày Vào Làm"
        DefaultTableModel model = (DefaultTableModel) tb1.getModel();
        for (int i = 0; i < nhanVienBUS.getList().size(); i++) {
            themPhanTuVaoMangNV(nhanVienBUS.getList().get(i).getMaNV());
            themPhanTuVaoMangNV(nhanVienBUS.getList().get(i).getHoTen());
            themPhanTuVaoMangNV(sdf.format(nhanVienBUS.getList().get(i).getNgaySinh()));
            themPhanTuVaoMangNV(nhanVienBUS.getList().get(i).getGioiTinh());
            themPhanTuVaoMangNV(nhanVienBUS.getList().get(i).getCmnd());
            themPhanTuVaoMangNV(nhanVienBUS.getList().get(i).getDiaChi());
            themPhanTuVaoMangNV(nhanVienBUS.getList().get(i).getSdt());
            themPhanTuVaoMangNV(sdf.format(nhanVienBUS.getList().get(i).getNgayVaoLam()));

            model.addRow(mangNV);
            mangNV = new String[0];
        }
    }
    

    private void loadDataLenBangSanPham() {

        tb2.setRowCount(0);

        ArrayList<DTO.DTO_NhanVien> ds = nhanVienBUS.getList();
        //		"Mã KH","Họ tên KH","Địa chỉ","Ngày cấp thẻ","Ngày mua gần nhất","Điểm thưởng"
        for (DTO_NhanVien nv : ds) {
            Vector vec = new Vector();
            vec.add(nv.getMaNV());
            vec.add(nv.getHoTen());
            vec.add(sdf.format(nv.getNgaySinh()));
            vec.add(nv.getGioiTinh());
            vec.add(nv.getCmnd());
            vec.add(nv.getDiaChi());
            vec.add(nv.getSdt());
            vec.add(sdf.format(nv.getNgayVaoLam()));

            tb2.addRow(vec);
        }
    }

    public void cleanView() // Sau khi nhấn nút Refresh sẽ xóa trắng các TextField
    {
       

        textfields[0].setText("");
        textfields[1].setText("");
        textfields[2].setText("");
        textfields[3].setText("");
        textfields[4].setText("");
        textfields[5].setText("");
        textfields[6].setText("");
        textfields[7].setText("");
        

       
        tb1.clearSelection();
    }

    public void themPhanTuVaoMangNV(String s) {
        int l = mangNV.length;
        mangNV = Arrays.copyOf(mangNV, l + 1);
        mangNV[l] = s;
    }

    public void xoaTable() { // xóa trống table
        DefaultTableModel model = (DefaultTableModel) tb1.getModel();
        model.setRowCount(0);
    }

    public void xuLySuKien_layDsNV_theoNgayVaoLam() {
        Date date_tuNgay = (Date) nvvTuNgay.getValue();
        Date date_denNgay = (Date) nvvDenNgay.getValue();
        layDsNV_theoNgayVaoLam(date_tuNgay, date_denNgay);

//        System.out.println(date_tuNgay);
//        System.out.println(date_denNgay);

    }

    public void layDsNV_theoNgayVaoLam(Date tuNgay, Date denNgay) {
        xoaTable();
        for (DTO_NhanVien nv : nhanVienBUS.getDsNV_ngayVaoLam(tuNgay, denNgay)) {
            Vector vec = new Vector();
            vec.add(nv.getMaNV());
            vec.add(nv.getHoTen());
            vec.add(sdf.format(nv.getNgaySinh()));
            vec.add(nv.getGioiTinh());
            vec.add(nv.getCmnd());
            vec.add(nv.getDiaChi());
            vec.add(nv.getSdt());
            vec.add(sdf.format(nv.getNgayVaoLam()));

            tb2.addRow(vec);
        }
    }

    public void loadDataLayDoiTuong_maNV(String maNV) { // load data lấy đối tượng đang tìm kiếm bằng mã
        xoaTable();
        DTO_NhanVien nv = NhanVienBUS.getIntance().getMaNV(maNV);
        Vector vec = new Vector();
        vec.add(nv.getMaNV());
        vec.add(nv.getHoTen());
        vec.add(sdf.format(nv.getNgaySinh()));
        vec.add(nv.getGioiTinh());
        vec.add(nv.getCmnd());
        vec.add(nv.getDiaChi());
        vec.add(nv.getSdt());
        vec.add(sdf.format(nv.getNgayVaoLam()));

        tb2.addRow(vec);
    }

    public void loadDataLayDoiTuong_diaChiNV(String diaChi) { // load data lấy đối tượng đang tìm kiếm bằng địa chỉ
        xoaTable();

        for (DTO_NhanVien nv : NhanVienBUS.getIntance().getDiaChiNV(diaChi)) {
            Vector vec = new Vector();
            vec.add(nv.getMaNV());
            vec.add(nv.getHoTen());
            vec.add(sdf.format(nv.getNgaySinh()));
            vec.add(nv.getGioiTinh());
            vec.add(nv.getCmnd());
            vec.add(nv.getDiaChi());
            vec.add(nv.getSdt());
            vec.add(sdf.format(nv.getNgayVaoLam()));
            

            tb2.addRow(vec);

        }
    }

    public void loadDataLayDoiTuong_gioiTinhNV(String gioiTinh) { // load data lấy đối tượng đang tìm kiếm bằng địa chỉ
        xoaTable();

        for (DTO_NhanVien nv : NhanVienBUS.getIntance().getGioiTinhNV(gioiTinh)) {
            Vector vec = new Vector();
            vec.add(nv.getMaNV());
            vec.add(nv.getHoTen());
            vec.add(sdf.format(nv.getNgaySinh()));
            vec.add(nv.getGioiTinh());
            vec.add(nv.getCmnd());
            vec.add(nv.getDiaChi());
            vec.add(nv.getSdt());
            vec.add(sdf.format(nv.getNgayVaoLam()));
            

            tb2.addRow(vec);

        }
    }

    public void getDsMaNV() { // đưa ds manv vào combobox
        Vector<String> vec = new Vector<>();
        vec.add("Chọn mã");
        for (String maKH : nhanVienBUS.getDsMaNV()) {
            vec.add(maKH);
        }
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(vec);
        cbMaNV.setModel(model);
    }

    public void getDsDiachi() { //đưa ds địa chỉ vào combobox
        Vector<String> vec = new Vector<>();
        vec.add("Chọn địa chỉ");
        for (String diaChi : NhanVienBUS.getIntance().getDsDiaChi()) {
            vec.add(diaChi);
        }
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(vec);
        cbDiaChi.setModel(model);
    }

//    public void getDsGioiTinh() { // đưa ds giới tính vào combobox
//        Vector<String> vec = new Vector<>();
//        vec.add("Chọn giới tính");
//        for (String gioiTinh : nhanVienBUS.getDsGioiTinh()) {
//            vec.add(gioiTinh);
//        }
//        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(vec);
//        cbPhai.setModel(model);
//    }
    public void setEnable_lbMaKH() { // button
        cbMaNV.setEnabled(true);
        cbDiaChi.setEnabled(false);
        nvvTuNgay.setEnabled(false);
        nvvDenNgay.setEnabled(false);
        cbPhai.setEnabled(false);
        getDsMaNV();
    }

    public void setEnable_lbDiaChi() {
        cbDiaChi.setEnabled(true);
        cbMaNV.setEnabled(false);
        nvvTuNgay.setEnabled(false);
        nvvDenNgay.setEnabled(false);
        cbPhai.setEnabled(false);
        getDsDiachi();
    }

    public void setEnable_lbNgayMua() {
        nvvTuNgay.setEnabled(true);
        nvvDenNgay.setEnabled(true);
        cbMaNV.setEnabled(false);
        cbDiaChi.setEnabled(false);
        cbPhai.setEnabled(false);

    }

    public void setEnable_lbGioiTinh() {
        cbPhai.setEnabled(true);
        nvvTuNgay.setEnabled(false);
        nvvDenNgay.setEnabled(false);
        cbMaNV.setEnabled(false);
        cbDiaChi.setEnabled(false);
    }
}

