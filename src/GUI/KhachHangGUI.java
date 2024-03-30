/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.KhachHangBUS;
import DTO.DTO_KhachHang;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Stack;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableCellRenderer;

public class KhachHangGUI extends JPanel {

    private KhachHangEvent khachHangEvent;

    public KhachHangGUI(KhachHangEvent khachHangEvent) {
        this.khachHangEvent = khachHangEvent;
    }

    public KhachHangGUI() {
        init();
        this.setVisible(false);
    }
    private JTable tb1;
    private JScrollPane jScrollPane1;
    public JLabel title, btnchonanh, txtrefresh, txtsearch, img, lbgiato, btnxuatfile, btnnhapfile;
    public static JLabel btnadd, btnedit, btndelete;
    private JLabel buttons[];
    private JTextField textfields[], tftimkiem, tfmasp, tfloaisp, tfgiafrom, tfgiato;
    private ImageIcon icon1;
    private JPanel filter;

    //------------------------------
    private DefaultTableModel tb2;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private DecimalFormat dcf = new DecimalFormat("###,###");
    private KhachHangBUS khachHangBUS;
    private String[] mangKH = new String[0];
    private String[] mean = new String[0];
    private String[] title1 = {"Mã KH", "Tên KH", "Địa chỉ", "Ngày cấp thẻ", "Ngày mua GN", "Điểm thưởng"};
    public static JComboBox<String> cbMaKH;
    public static JComboBox<String> cbDiaChi;
    private String[] listMaKH = {"Chọn mã"};
    private String[] listDiaChi = {"Chọn địa chỉ"};
    public JButton bt_MaKH, bt_DiaChi, bt_NgayMua;
    private JLabel ngayTu, denNgay;
    private SpinnerDateModel dateNgayMuaTu, dateNgayMuaToi;
    public static JSpinner khmTuNgay;
    public static JSpinner khmDenNgay;
    public JLabel btnsearch;
    private int maKHmoiNhat= KhachHangBUS.getIntance().getMaKHmoiNhat();

    public void init() {

        ActionListener ac = new KhachHangEvent(this);
        MouseListener mouse = new KhachHangEvent(this);

        setLayout(null);
        setPreferredSize(new Dimension(1100, 700));
        setBackground(new Color(0xEEEEEE));
        title = new JLabel("QUẢN LÍ KHÁCH HÀNG");
        title.setBounds(350, 10, 300, 40);
        title.setFont(new Font("Serif", Font.BOLD, 25));
        add(title);

        //icon= new ImageIcon("/images/refresh_40px.png");
        txtrefresh = new JLabel();
        txtrefresh.setIcon(new ImageIcon("./src/IMG/Refresh-icon.png"));
        txtrefresh.setBounds(650, 10, 30, 30);
        txtrefresh.setCursor(new Cursor(Cursor.HAND_CURSOR));
        txtrefresh.addMouseListener(mouse);

//        txtrefresh.addMouseListener(new MouseAdapter() { // Nút refresh
//            public void mouseClicked(MouseEvent e) {
//                loadDataLenBangSanPham();
//                cleanView();
////                tftimkiem.setText("");
////                      cmbChoice.setSelectedItem("Tên KH");
//
//            }
//        });
        add(txtrefresh);

        buttons = new JLabel[6];
        textfields = new JTextField[6];
        int toadoyButton = 70;
        String[] arrBtn = {"Mã KH", "Họ Tên", "Địa chỉ", "Ngày cấp thẻ", "Ngày mua gần nhất", "Điểm thưởng"};
        for (int i = 0; i < 6; i++) {
            buttons[i] = new JLabel(arrBtn[i]);
            buttons[i].setBounds(300, toadoyButton, 200, 25);
            buttons[i].setFont(new Font("Serif", Font.BOLD, 20));
            textfields[i] = new JTextField();
            textfields[i].setBounds(500, toadoyButton, 200, 25);
            textfields[i].setFont(new Font("Serif", 0, 20));
            toadoyButton += 30;
            add(buttons[i]);
            add(textfields[i]);
        }
        textfields[0].setEditable(false);
        textfields[3].setEditable(false);
        textfields[4].setEditable(false);
        textfields[5].setEditable(false);

//        tftimkiem = new JTextField();
//        tftimkiem.setBackground(Color.WHITE);
//        //tftimkiem.setOpaque(false);
//        tftimkiem.setBounds(new Rectangle(330, 270, 400, 25));
//        tftimkiem.setFont(new Font("Serif", 0, 20));
//        add(tftimkiem);
//
//        txtsearch = new JLabel();
//        txtsearch.setBounds(new Rectangle(730, 262, 40, 40));
//        txtsearch.setIcon(new ImageIcon("./src/IMG/search_25px.png"));
//        txtsearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        txtsearch.setBackground(Color.red);
//        txtsearch.setOpaque(true);
//
//        add(txtsearch);
        btnadd = new JLabel();
        btnadd.setIcon(new ImageIcon("./src/IMG/btnAdd_150px.png"));
        btnadd.setBounds(800, 65, 200, 50);
        btnadd.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        btnadd.setBackground(Color.GREEN);
        btnadd.setOpaque(true);

        btnadd.addMouseListener(new MouseAdapter() { // add
            public void mouseClicked(MouseEvent e) {
                maKHmoiNhat++;
                String maKH=maKHmoiNhat+"";
                String tenKH = textfields[1].getText();
                String diaChi = textfields[2].getText();
                if(CheckLoi.isEmptyString(tenKH)||CheckLoi.isEmptyString(diaChi)) {
                	new ThongBaoDialog("Thêm lỗi", ThongBaoDialog.ERROR_DIALOG);
                	return;
                }
                Date ngayCapThe = new Date();
                Date ngayMuaGanNhat= new Date();
                DTO_KhachHang kh = new DTO_KhachHang(maKH, tenKH, diaChi, ngayCapThe, ngayMuaGanNhat, 0);
                KhachHangBUS.getIntance().inSert(kh);
                loadDataDSKH();
                cleanView();
            }
        });
        btnedit = new JLabel();
        btnedit.setIcon(new ImageIcon("./src/IMG/btnEdit_150px.png"));
        btnedit.setBounds(800, 115, 200, 50);
        btnedit.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        btnedit.setBackground(Color.YELLOW);////
        btnedit.setOpaque(true);

        btnedit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                String maKH = textfields[0].getText();
                String hoTen = textfields[1].getText();
                String diaChi = textfields[2].getText();

                DTO_KhachHang kh = new DTO_KhachHang();
                kh.setMaKH(maKH);
                kh.setHoTen(hoTen);
                kh.setDiaChi(diaChi);

                int i = JOptionPane.showConfirmDialog(null, "Xác nhận cập nhập", "Thông báo!", JOptionPane.YES_NO_OPTION);
                if (i == 0) {
                    khachHangBUS.capNhat(kh);
                    loadDataDSKH();
                    cleanView();
                }
            }
        });

        btndelete = new JLabel();
        btndelete.setIcon(new ImageIcon("./src/IMG/btnDelete_150px.png"));
        btndelete.setBounds(800, 165, 200, 50);
        btndelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        btndelete.setBackground(Color.red);////
        btndelete.setOpaque(true);

        btndelete.addMouseListener(new MouseAdapter() { // Xóa
            public void mouseClicked(MouseEvent e) {
                String maKH = textfields[0].getText();
                DTO_KhachHang kh = new DTO_KhachHang();
                kh.setMaKH(maKH);
                int i = JOptionPane.showConfirmDialog(null, "Xác nhận xóa", "Thông báo!", JOptionPane.YES_NO_OPTION);
                if (i == 0) {
                    khachHangBUS.delete(kh);
                    loadDataDSKH();
                    cleanView();
                }

            }
        });

        add(btnadd);
        add(btnedit);
        add(btndelete);
        //add(btnchonanh);

        filter = new JPanel();
        filter.setLayout(null);
//        filter.setBackground(Color.red);
        filter.setBounds(0, 260, 1300 - 220, 100);
        add(filter);

        bt_MaKH = new JButton("Mã KH:");
        bt_MaKH.setBounds(280, 10, 90, 30);
        bt_MaKH.setFont(new Font("Serif", 0, 15));
        bt_MaKH.addActionListener(ac);

        cbMaKH = new JComboBox<String>(listMaKH);
        cbMaKH.setBounds(372, 10, 100, 30);
        cbMaKH.addActionListener(ac);
        cbMaKH.setEnabled(false);

        bt_DiaChi = new JButton("Địa chỉ:");
        bt_DiaChi.setBounds(530, 10, 90, 30);
        bt_DiaChi.setFont(new Font("Serif", 0, 15));
        bt_DiaChi.addActionListener(ac);

        cbDiaChi = new JComboBox<String>(listDiaChi);
        cbDiaChi.setBounds(622, 10, 180, 30);
        cbDiaChi.addActionListener(ac);
        cbDiaChi.setEnabled(false);

        //-----------------------------------
        bt_NgayMua = new JButton("Ngày mua");
        bt_NgayMua.setFont(new Font("Serif", 0, 15));
        bt_NgayMua.setBounds(225, 60, 100, 30);
        bt_NgayMua.addActionListener(ac);

        ngayTu = new JLabel("Từ ngày:");
        ngayTu.setBounds(345, 60, 100, 30);

        dateNgayMuaTu = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        khmTuNgay = new JSpinner(dateNgayMuaTu);
        khmTuNgay.setBounds(410, 60, 150, 35);
        JSpinner.DateEditor editor1 = new JSpinner.DateEditor(khmTuNgay, "dd/MM/yyyy");
        khmTuNgay.setEditor(editor1);
        khmTuNgay.setEnabled(false);

        denNgay = new JLabel("đến ngày");
        denNgay.setBounds(585, 60, 100, 30);

        dateNgayMuaToi = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        khmDenNgay = new JSpinner(dateNgayMuaToi);
        khmDenNgay.setBounds(660, 60, 150, 35);
        JSpinner.DateEditor editor2 = new JSpinner.DateEditor(khmDenNgay, "dd/MM/yyyy");
        khmDenNgay.setEditor(editor2);
        khmDenNgay.setEnabled(false);

//        tfgiafrom = new JTextField();
//        tfgiafrom.setBounds(650, 10, 100, 25);
//        lbgiato = new JLabel("-");
//        lbgiato.setBounds(760, 10, 20, 25);
//        lbgiato.setFont(new Font("Serif", 0, 15));
//        tfgiato = new JTextField();
//        tfgiato.setBounds(780, 10, 100, 25);
        filter.add(bt_MaKH);
        filter.add(cbMaKH);
        filter.add(bt_DiaChi);
        filter.add(cbDiaChi);
        filter.add(bt_NgayMua);
        filter.add(ngayTu);
        filter.add(denNgay);
        filter.add(khmTuNgay);
        filter.add(khmDenNgay);

//        filter.add(tfgiafrom);
//        filter.add(lbgiato);
//        filter.add(tfgiato);
        btnsearch = new JLabel();
        btnsearch.setBounds(830, 55, 40, 40);
        btnsearch.setIcon(new ImageIcon("./src/IMG/btnSearch_40px.png"));
        btnsearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        btnsearch.setBackground(Color.blue);
        btnsearch.setOpaque(true);
        btnsearch.addMouseListener(mouse);
        filter.add(btnsearch);

        //-----------------------------
        khachHangBUS = new KhachHangBUS();
        String mean1[][] = null;
        tb2 = new DefaultTableModel(mean1, title1);

        tb1 = new JTable(tb2);
        tb1.getTableHeader().setForeground(Color.BLACK);
        tb1.getTableHeader().setBackground(new Color(0x29B6F6));
        tb1.getTableHeader().setFont(new Font("Serif", Font.BOLD, 18));
        tb1.setFont(new Font("Serif", 0, 16));
        tb1.setRowHeight(25);

        //----"Mã KH","Họ tên KH","Địa chỉ","Ngày cấp thẻ","Ngày mua gần nhất","Điểm thưởng"
        tb1.getColumnModel().getColumn(0).setPreferredWidth(15); //Ma KH
        tb1.getColumnModel().getColumn(1).setPreferredWidth(115); //Ten KH
        tb1.getColumnModel().getColumn(2).setPreferredWidth(155); // Dia chi KH
        tb1.getColumnModel().getColumn(3).setPreferredWidth(70); // Ngay cap the 
        tb1.getColumnModel().getColumn(4).setPreferredWidth(70); // Ngay mua gan nhat
        tb1.getColumnModel().getColumn(5).setPreferredWidth(50); // Diem thuong

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tb1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tb1.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tb1.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tb1.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tb1.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tb1.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);

        tb1.addMouseListener(new MouseAdapter() { // lấy dữ liệu lên textfield
            public void mouseClicked(MouseEvent e) {
                int i = tb1.getSelectedRow(); // lấy vị trí dòng mình click chọn

                textfields[0].setText(tb1.getModel().getValueAt(i, 0).toString());
                textfields[1].setText(tb1.getModel().getValueAt(i, 1).toString());
                textfields[2].setText(tb1.getModel().getValueAt(i, 2).toString());
                textfields[3].setText(tb1.getModel().getValueAt(i, 3).toString());
                textfields[4].setText(tb1.getModel().getValueAt(i, 4).toString());
                textfields[5].setText(tb1.getModel().getValueAt(i, 5).toString());

            }
        });
        //----

        jScrollPane1 = new javax.swing.JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setBounds(80, 380, 900, 250);
        jScrollPane1.setViewportView(tb1);
        getDsKh();
        getDsMaKH();
        getDsDiachi();
        add(jScrollPane1);
    }

    public void getDsKh() {
//		"Mã KH","Họ tên KH","Địa chỉ","Ngày cấp thẻ","Ngày mua gần nhất","Điểm thưởng"
        DefaultTableModel model = (DefaultTableModel) tb1.getModel();
        for (int i = 0; i < khachHangBUS.getList().size(); i++) {
            themPhanTuVaoMangKH(khachHangBUS.getList().get(i).getMaKH());
            themPhanTuVaoMangKH(khachHangBUS.getList().get(i).getHoTen());
            themPhanTuVaoMangKH(khachHangBUS.getList().get(i).getDiaChi());
            themPhanTuVaoMangKH(sdf.format(khachHangBUS.getList().get(i).getNgayCapThe()));
            themPhanTuVaoMangKH(sdf.format(khachHangBUS.getList().get(i).getNgayMuaGanNhat()));
            themPhanTuVaoMangKH(khachHangBUS.getList().get(i).getDiemThuong()+"");

            model.addRow(mangKH);
            mangKH = new String[0];
        }
    }

    public void themPhanTuVaoMangKH(String s) {
        int l = mangKH.length;
        mangKH = Arrays.copyOf(mangKH, l + 1);
        mangKH[l] = s;
    }

    //----------Xóa
    public void cleanView() // Sau khi nhấn nút Refresh sẽ xóa trắng các TextField
    {

        textfields[0].setText("");
        textfields[1].setText("");
        textfields[2].setText("");
        textfields[3].setText("");
        textfields[4].setText("");
        textfields[5].setText(""); // phần quan trọng nhất, nó phải được nhập đầu tiên
        tb1.clearSelection();
    }

    private void loadDataDSKH() {

        tb2.setRowCount(0);

        ArrayList<DTO.DTO_KhachHang> ds = khachHangBUS.getList();
        //		"Mã KH","Họ tên KH","Địa chỉ","Ngày cấp thẻ","Ngày mua gần nhất","Điểm thưởng"
        for (DTO_KhachHang kh : ds) {
            Vector vec = new Vector();
            vec.add(kh.getMaKH());
            vec.add(kh.getHoTen());
            vec.add(kh.getDiaChi());
            vec.add(sdf.format(kh.getNgayCapThe()));
            vec.add(sdf.format(kh.getNgayMuaGanNhat()));
            vec.add(kh.getDiemThuong());

            tb2.addRow(vec);
        }
    }

    public void loadDataLayDoiTuong_maKH(String maKH) { // load data lấy đối tượng đang tìm kiếm bằng mã
        xoaTable();
        DTO_KhachHang kh = KhachHangBUS.getIntance().getMaKH(maKH);
        Vector vec = new Vector();
        vec.add(kh.getMaKH());
        vec.add(kh.getHoTen());
        vec.add(kh.getDiaChi());
        vec.add(sdf.format(kh.getNgayCapThe()));
        vec.add(sdf.format(kh.getNgayMuaGanNhat()));
        vec.add(kh.getDiemThuong());

        tb2.addRow(vec);
    }

    public void loadDataLayDoiTuong_diaChiKH(String diaChi) { // load data lấy đối tượng đang tìm kiếm bằng địa chỉ
        xoaTable();
        for (DTO_KhachHang kh : KhachHangBUS.getIntance().getDiaChiKH(diaChi)) {
            Vector vec = new Vector();
            vec.add(kh.getMaKH());
            vec.add(kh.getHoTen());
            vec.add(kh.getDiaChi());
            vec.add(sdf.format(kh.getNgayMuaGanNhat()));
            vec.add(sdf.format(kh.getNgayMuaGanNhat()));
            vec.add(kh.getDiemThuong());

            tb2.addRow(vec);
        }
    }

    public void xoaTable() { // xóa trống table
        DefaultTableModel model = (DefaultTableModel) tb1.getModel();
        model.setRowCount(0);
    }

    public void xuLySuKien_layDsKH_theoNgayMuaGanNhat() {
        Date date_tuNgay = (Date) khmTuNgay.getValue();
        Date date_denNgay = (Date) khmDenNgay.getValue();
        layDsKH_theoNgayMuaGanNhat(date_tuNgay, date_denNgay);
        System.out.println(date_tuNgay);
        System.out.println(date_denNgay);

    }

    public void layDsKH_theoNgayMuaGanNhat(Date tuNgay, Date denNgay) {
        xoaTable();
        for (DTO_KhachHang kh : khachHangBUS.getDsKH_ngayMuaGanNhat(tuNgay, denNgay)) {
            Vector vec = new Vector();
            vec.add(kh.getMaKH());
            vec.add(kh.getHoTen());
            vec.add(kh.getDiaChi());
            vec.add(sdf.format(kh.getNgayCapThe()));
            vec.add(sdf.format(kh.getNgayMuaGanNhat()));
            vec.add(kh.getDiemThuong());

            tb2.addRow(vec);
        }
    }

//    public int getMaKH() {
//        int maKHmoinhat = 0;
//        for (DTO_KhachHang kh : khachHangBUS.getList()) {
//            String txtmaKH = kh.getMaKH();
//            txtmaKH = txtmaKH.replace("KH", "");
//            int maHD = Integer.parseInt(txtmaKH);
//            if (maHD > maKHmoinhat) {
//                maKHmoinhat = maHD;
//            }
//        }
//        return maKHmoinhat;
//    }
//    public boolean checkTextFields() { // check xem đã điền đầy đủ thông tin chưa??
//        if
//    }
    public void getDsMaKH() { // đưa ds makh vào combobox
        Vector<String> vec = new Vector<>();
        vec.add("Chọn mã");
        for (String maKH : khachHangBUS.getDsMaKh()) {
            vec.add(maKH);
        }
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(vec);
        cbMaKH.setModel(model);
    }

    public void getDsDiachi() { //đưa ds địa chỉ vào combobox
        Vector<String> vec = new Vector<>();
        vec.add("Chọn địa chỉ");
        for (String diaChi : KhachHangBUS.getIntance().getDsDiaChi()) {
            vec.add(diaChi);
        }
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(vec);
        cbDiaChi.setModel(model);
    }

    public void setEnable_lbMaKH() { // button
        cbMaKH.setEnabled(true);
        cbDiaChi.setEnabled(false);
        khmTuNgay.setEnabled(false);
        khmDenNgay.setEnabled(false);
        getDsMaKH();
    }

    public void setEnable_lbDiaChi() {
        cbDiaChi.setEnabled(true);
        cbMaKH.setEnabled(false);
        khmTuNgay.setEnabled(false);
        khmDenNgay.setEnabled(false);
        getDsDiachi();
    }

    public void setEnable_lbNgayMua() {
        khmTuNgay.setEnabled(true);
        khmDenNgay.setEnabled(true);
        cbMaKH.setEnabled(false);
        cbDiaChi.setEnabled(false);
    }
    public void xuLySuKienRefresh() {
    	loadDataDSKH();
    	cleanView();
    	getDsDiachi();
    	getDsMaKH();
    	
    }

}
