///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package GUI;
//
//import BUS.DonViBUS;
//import BUS.LoaiHangBUS;
//import BUS.MatHangBUS;
//import DTO.DonViDTO;
//import DTO.LoaiHangDTO;
//import DTO.MatHangDTO;
//import com.toedter.calendar.JCalendar;
//import javax.swing.JPanel;
////import BUS.LoaiBUS;
////import BUS.NsxBUS;
//import java.awt.Cursor;
//import java.awt.Dimension;
//import java.awt.Font;
//import java.awt.Image;
//import java.awt.Rectangle;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.util.ArrayList;
//import java.util.Vector;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import static javax.swing.BorderFactory.createLineBorder;
//import javax.swing.ImageIcon;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import javax.swing.table.DefaultTableModel;
//import com.toedter.calendar.JDateChooser;
////import DTO.SanPhamDTO;
////import BUS.SanPhamBUS;
////import DTO.LoaiDTO;
////import DTO.NsxDTO;
//import java.awt.Choice;
//import java.awt.Color;
//import java.awt.event.FocusAdapter;
//import java.awt.event.FocusEvent;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.util.Date;
//import javax.imageio.ImageIO;
//import javax.swing.BorderFactory;
//import javax.swing.DefaultComboBoxModel;
//import javax.swing.JComboBox;
//import javax.swing.JFileChooser;
//import javax.swing.JSeparator;
//import javax.swing.RowFilter;
//import javax.swing.SwingConstants;
//import javax.swing.event.DocumentEvent;
//import javax.swing.event.DocumentListener;
//import javax.swing.filechooser.FileNameExtensionFilter;
//import javax.swing.table.DefaultTableCellRenderer;
//import javax.swing.table.TableModel;
//import javax.swing.table.TableRowSorter;
//import javax.swing.JDialog;
//
//public class dleditMatHangGUI extends JDialog {
//    public dleditMatHangGUI()
//    {
//        init();
//    }
//    private  JLabel title,btnadd,btnimg;
//    private JLabel txtmamh,txtten,txtgiamua,txtgiaban, txtngaysanxuat,txthansudung,txtslnhap,txtslban, txtngaynhap,txtvat,txtmalh,txtmadvt ;
//    public JTextField tfmamh,tften,tfgiamua,tfgiaban,tfslnhap,tfslban,tfvat,tfmalh,tfmadvt;
//    public JDateChooser datengaysanxuat,datehansudung,datengaynhap;
//        private MatHangBUS mathangBUS;
//        public  JComboBox cmbloaihang,cmbdvt;
//        public String temp="",temp1="",temp2="";
//        private MatHangGUI mhGUI;
//  
//    public void init()
//    {
//        setTitle("Sửa chi  tiết sản phẩm");
//        setSize(500, 730);
//        setLayout(null);
//        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//        setVisible(false);
//        setLocationRelativeTo(null);
//        this.setModal(true);
//        title = new JLabel("Thông tin chi tiết sản phẩm");
//        title.setFont(new Font("Serif",1,25));
//        title.setBounds(0, 0, 500, 25);
//        title.setHorizontalAlignment(JLabel.CENTER);
//        add(title);
//        mathangBUS= new MatHangBUS();
//        
//        txtmamh= new JLabel("Mã sản phẩm");
//        txtmamh.setBounds(30,50,150,25);
//        txtmamh.setFont(new Font("Serif",1,18));
//        add(txtmamh);
//        txtten = new JLabel("Tên sản phẩm");
//        txtten.setBounds(30,80,150,25);
//        txtten.setFont(new Font("Serif",1,18));
//        add(txtten);
//        txtgiamua = new JLabel("Giá mua");
//        txtgiamua.setBounds(30,110,150,25);
//        txtgiamua.setFont(new Font("Serif",1,18));
//        add(txtgiamua);
//        txtgiaban= new JLabel("Giá bán");
//        txtgiaban.setBounds(30,140,150,25);
//        txtgiaban.setFont(new Font("Serif",1,18));
//        add(txtgiaban);
//        txtngaysanxuat= new JLabel("Ngày sản xuất");
//        txtngaysanxuat.setBounds(30,170,150,25);
//        txtngaysanxuat.setFont(new Font("Serif",1,18));
//        add(txtngaysanxuat);
//        datengaysanxuat = new JDateChooser();
//        datengaysanxuat.setDateFormatString("dd/MM/yyyy");
//        datengaysanxuat.setBounds(160, 170, 200, 25);
//        add(datengaysanxuat);
//        txthansudung= new JLabel("Hạn sử dụng");
//        txthansudung.setBounds(30,200,150,25);
//        txthansudung.setFont(new Font("Serif",1,18));
//        add(txthansudung);
//        datehansudung = new JDateChooser();
//        datehansudung.setDateFormatString("dd/MM/yyyy");
//        datehansudung.setBounds(160, 200, 200, 25);
//        add(datehansudung);
//        txtslnhap= new JLabel("SL nhập");
//        txtslnhap.setBounds(30,230,150,25);
//        txtslnhap.setFont(new Font("Serif",1,18));
//        add(txtslnhap);
//        txtslban= new JLabel("SL bán");
//        txtslban.setBounds(30,260,150,25);
//        txtslban.setFont(new Font("Serif",1,18));
//        add(txtslban);
//        txtngaynhap= new JLabel("Ngày nhập");
//        txtngaynhap.setBounds(30,290,150,25);
//        txtngaynhap.setFont(new Font("Serif",1,18));
//        add(txtngaynhap);
//        datengaynhap = new JDateChooser();
//        datengaynhap.setDateFormatString("dd/MM/yyyy");
//        datengaynhap.setBounds(160, 290, 200, 25);
//        add(datengaynhap);
//        txtvat= new JLabel("VAT");
//        txtvat.setBounds(30,320,150,25);
//        txtvat.setFont(new Font("Serif",1,18));
//        add(txtvat);
//        txtmalh= new JLabel("Mã LH");
//        txtmalh.setBounds(30,350,150,25);
//        txtmalh.setFont(new Font("Serif",1,18));
//        add(txtmalh);
//        txtmadvt = new JLabel("Mã ĐVT");
//        txtmadvt.setBounds(30,380,150,25);
//        txtmadvt.setFont(new Font("Serif",1,18));
//        add(txtmadvt);
//        
//        
//        tfmamh = new JTextField();
//        tfmamh.setBounds(160,50,200,25);
//        add(tfmamh);
//        tften= new JTextField();
//        tften.setBounds(160, 80, 200, 25);
//        add(tften);
//        tfgiamua= new JTextField();
//        tfgiamua.setBounds(160, 110, 200, 25);
//        add(tfgiamua);
//        tfgiaban= new JTextField();
//        tfgiaban.setBounds(160, 140, 200, 25);
//        add(tfgiaban);
//        tfslnhap= new JTextField();
//        tfslnhap.setBounds(160, 230, 200, 25);
//        add(tfslnhap);
//        tfslban= new JTextField();
//        tfslban.setBounds(160, 260, 200, 25);
//        add(tfslban);
//        tfvat= new JTextField();
//        tfvat.setBounds(160, 320, 200, 25);
//        add(tfvat);
//        cmbloaihang= new JComboBox();
//        cmbloaihang.setBounds(160, 350, 200, 25);
//        add(cmbloaihang);
//        cmbdvt= new JComboBox();
//        cmbdvt.setBounds(160, 380, 200, 25);
//        addDVT();
//        addLoaiHang();
//        add(cmbdvt);
//        btnadd= new JLabel();
//        btnadd.setIcon(new ImageIcon("./src/IMG/btnEdit_150px.png"));
//        btnadd.setBounds(50, 550,200, 50);
//        btnadd.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        add(btnadd);
//        
//        btnadd.addMouseListener(new MouseAdapter(){
//            @Override
//            public void mousePressed(MouseEvent e) {
//                String Mamh = tfmamh.getText();
//                String tenmh = tften.getText();
//                String giamua = tfgiamua.getText();
//                double sogiamua=Double.valueOf(giamua);
//                String giaban = tfgiaban.getText();
//                double sogiaban= Double.valueOf(giaban);
//                Date ngaysx = datengaysanxuat.getDate();
//                Date hansudung = datehansudung.getDate();
//                String slnhap = tfslnhap.getText();
//                int soslnhap= Integer.valueOf(slnhap);
//                String slban = tfslban.getText();
//                int soslban= Integer.valueOf(slban);
//                Date ngaynhap = datengaynhap.getDate();
//                String vat= tfvat.getText();
//                int sovat= Integer.valueOf(vat);
//                String malhtemp=cmbloaihang.getSelectedItem().toString();
//                    String malh = LoaiHangBUS.getIntance().laymatheotenloaihang(malhtemp);
//                    String madvttemp=cmbdvt.getSelectedItem().toString();
//                    String madvt = DonViBUS.getIntance().laymatheotendonvitinh(madvttemp);
//                String img=temp2;
//                MatHangDTO mh= new MatHangDTO(Mamh,tenmh,sogiamua,sogiaban,ngaysx,hansudung,soslnhap,soslban,ngaynhap,sovat,malh,madvt,img);
//                mathangBUS.capnhat(mh);
//                 MatHangGUI mhGUI= new MatHangGUI(1300);
//                    mhGUI.getDSSPFull();
//                cleanView();
//                //setVisible(false);
//            }
//            
//            
//            
//        });
//        
//        btnimg= new JLabel();
//        btnimg.setIcon(new ImageIcon("./src/IMG/btnFile.png"));
//        btnimg.setBounds(250,550,200,50);
//        btnimg.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        add(btnimg);
//        btnimg.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//                mhGUI = new MatHangGUI(1300);
//                JFileChooser fc = new JFileChooser();
//                FileNameExtensionFilter filter = new FileNameExtensionFilter(
//                "JPG & PNG images", "jpg", "png");
//                fc.setFileFilter(filter);
//                int result = fc.showOpenDialog(null);
//                if (result == JFileChooser.APPROVE_OPTION) 
//                {
//                    try {
//                        File file = fc.getSelectedFile(); //Lấy URL hình
//                        mhGUI.i = ImageIO.read(file); // Lấy hình
//                        //C:\Users\Admin\OneDrive\Documents\NetBeansProjects\QLST_MINI\Source Packages\images\bau.jpg
//                        temp=mathangBUS.getAnh(mhGUI.HinhAnh);
//                        
//                        
//                        temp2=file.toString().substring(84, file.toString().length());
//         
//                        // Thay đổi hình hiển thị
//                        ImageIcon icon = new ImageIcon(mhGUI.i.getScaledInstance(215, 180, Image.SCALE_SMOOTH));
//                        mhGUI.img.setIcon(icon);
//                        
//                        revalidate();
//                        repaint();
//                    } catch (IOException ex) {
//                        Logger.getLogger(dladdMatHangGUI.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            }
//        });
//    }
////    public void loadData()
////    {
////        MatHangGUI mhGUI= new  MatHangGUI(1300);
////        mhGUI.tb1.setRowCount(0);
////        ArrayList<MatHangDTO> ds = mathangBUS.getList();
////        for(MatHangDTO mh: ds)
////        {
////            Vector vec = new Vector();  
////            vec.add(mh.getMaMh());
////            vec.add(mh.getTenMh());
////            vec.add(mh.getMaLH());
////            vec.add(mh.getSlNhap()-mh.getSlBan());
////            vec.add(mh.getMaDVT());
////            vec.add(mh.getGiaBan());
////            mhGUI.tb1.addRow(vec);
////        }
////        
////    }
//    public void cleanView()
//    {
//        tfmamh.setText("");
//        tften.setText("");
//        tfgiamua.setText("");
//        tfgiaban.setText("");
//        tfslnhap.setText("");
//        tfslban.setText("");
//        tfvat.setText("");
//        cmbloaihang.setSelectedItem("Chọn loại");
//        cmbdvt.setSelectedItem("Chọn ĐVT");
//    }
//    public void addLoaiHang()
//    {
//        Vector<String> vec= new Vector();
//        vec.add("Chọn loại");
//        for(LoaiHangDTO lh: LoaiHangBUS.getIntance().getList())
//        {
//            vec.add(lh.getTenLH());
//        }
//        DefaultComboBoxModel<String>cbmodel=new DefaultComboBoxModel<>(vec);
//        cmbloaihang.setModel(cbmodel);
//    }
//    public void addDVT()
//    {
//        Vector<String> vec= new Vector();
//        vec.add("Chọn ĐVT");
//        for(DonViDTO lh: DonViBUS.getIntance().getList())
//        {
//            vec.add(lh.getTenDVT());
//        }
//        DefaultComboBoxModel<String>cbmodel=new DefaultComboBoxModel<>(vec);
//        cmbdvt.setModel(cbmodel);
//    }
//   
//}
//
//
// 
//    
//    
//
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.DonViBUS;
import BUS.LoaiHangBUS;
import BUS.MatHangBUS;
import DTO.DonViDTO;
import DTO.LoaiHangDTO;
import DTO.MatHangDTO;
import com.toedter.calendar.JCalendar;
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
import com.toedter.calendar.JDateChooser;
//import DTO.SanPhamDTO;
//import BUS.SanPhamBUS;
//import DTO.LoaiDTO;
//import DTO.NsxDTO;
import java.awt.Choice;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JSeparator;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JDialog;
import javax.swing.border.Border;

public class dleditMatHangGUI extends JDialog {
    public dleditMatHangGUI()
    {
        init();
    }
   private  JLabel title,btnadd,btnimg;
    private JLabel txtmamh,txtten,txtgiamua,txtgiaban, txtngaysanxuat,txthansudung,txtslnhap,txtslban, txtngaynhap,txtvat,txtmalh,txtmadvt ;
    public JTextField tfmamh,tften,tfgiamua,tfgiaban,tfslnhap,tfslban,tfvat,tfmalh,tfmadvt;
    public JDateChooser datengaysanxuat,datehansudung,datengaynhap;
        private MatHangBUS mathangBUS= new MatHangBUS();
        private DecimalFormat dcf = new DecimalFormat("###,###");
        public JComboBox cmbloaihang,cmbdvt;
        public String temp="hi",temp2="";
        private Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        private JLabel tbgiamua,tbgiaban,tbslnhap,tbvat,tblh,tbdvt,tbten;
        
    //private MatHangGUI mhGUI;
    public void init()
    {
        setTitle("Sửa chi tiết sản phẩm");
        setSize(600, 530);
        setLayout(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(false);
        setLocationRelativeTo(null);
        this.setModal(true);
        dispose();
        
        title = new JLabel("Thông tin chi tiết sản phẩm");
        title.setFont(new Font("Serif",1,25));
        title.setBounds(0, 0, 500, 25);
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title);
        
        txtmamh= new JLabel("Mã sản phẩm");
        txtmamh.setBounds(30,50,150,25);
        txtmamh.setFont(new Font("Serif",1,18));
        add(txtmamh);
        txtten = new JLabel("Tên sản phẩm");
        txtten.setBounds(30,80,150,25);
        txtten.setFont(new Font("Serif",1,18));
        add(txtten);
        txtgiamua = new JLabel("Giá mua");
        txtgiamua.setBounds(30,110,150,25);
        txtgiamua.setFont(new Font("Serif",1,18));
        add(txtgiamua);
        txtgiaban= new JLabel("Giá bán");
        txtgiaban.setBounds(30,140,150,25);
        txtgiaban.setFont(new Font("Serif",1,18));
        add(txtgiaban);
        txtngaysanxuat= new JLabel("Ngày sản xuất");
        txtngaysanxuat.setBounds(30,170,150,25);
        txtngaysanxuat.setFont(new Font("Serif",1,18));
        add(txtngaysanxuat);
        datengaysanxuat = new JDateChooser();
        datengaysanxuat.setDateFormatString("dd/MM/yyyy");
        datengaysanxuat.setBounds(160, 170, 200, 25);
        add(datengaysanxuat);
        datengaysanxuat.setDate(new Date());
        datengaysanxuat.getDateEditor().getUiComponent().setEnabled(false);
        datengaysanxuat.getDateEditor().getUiComponent().setFont(new Font("Serif",0,15));
        datengaysanxuat.getDateEditor().getUiComponent().setBorder(lineBorder);
        datengaysanxuat.getDateEditor().getUiComponent().setOpaque(true);
        datengaysanxuat.getDateEditor().getUiComponent().setBackground(Color.white);
        datengaysanxuat.getDateEditor().getUiComponent().setForeground(Color.black);
        
        txthansudung= new JLabel("Hạn sử dụng");
        txthansudung.setBounds(30,200,150,25);
        txthansudung.setFont(new Font("Serif",1,18));
        add(txthansudung);
        datehansudung = new JDateChooser();
        datehansudung.setDateFormatString("dd/MM/yyyy");
        datehansudung.setBounds(160, 200, 200, 25);
        add(datehansudung);
        datehansudung.setDate(new Date());
        datehansudung.getDateEditor().getUiComponent().setEnabled(false);
        datehansudung.getDateEditor().getUiComponent().setFont(new Font("Serif",0,15));
        datehansudung.getDateEditor().getUiComponent().setBorder(lineBorder);
        datehansudung.getDateEditor().getUiComponent().setOpaque(true);
        datehansudung.getDateEditor().getUiComponent().setBackground(Color.white);
        datehansudung.getDateEditor().getUiComponent().setForeground(Color.black);
        txtslnhap= new JLabel("SL nhập");
        txtslnhap.setBounds(30,230,150,25);
        txtslnhap.setFont(new Font("Serif",1,18));
        add(txtslnhap);
        txtvat= new JLabel("VAT");
        txtvat.setBounds(30,260,150,25);
        txtvat.setFont(new Font("Serif",1,18));
        add(txtvat);
        txtmalh= new JLabel("Mã LH");
        txtmalh.setBounds(30,290,150,25);
        txtmalh.setFont(new Font("Serif",1,18));
        add(txtmalh);
        txtmadvt = new JLabel("Mã ĐVT");
        txtmadvt.setBounds(30,320,150,25);
        txtmadvt.setFont(new Font("Serif",1,18));
        add(txtmadvt);
        
        tfmamh = new JTextField();
        tfmamh.setBounds(160,50,200,25);
        add(tfmamh);
        tfmamh.setEditable(false);
        tften= new JTextField();
        tften.setBounds(160, 80, 200, 25);
        add(tften);
        tbten= new JLabel();
        tbten.setBounds(370, 80, 200, 25);
        tbten.setForeground(Color.red);
        add(tbten);
        tften.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e) {
                    tbten.setText(null);
            }
            
        });
        tfgiamua= new JTextField();
        tfgiamua.setBounds(160, 110, 200, 25);
        add(tfgiamua);
        tbgiamua=new JLabel();
        tbgiamua.setBounds(370, 110, 200, 25);
        tbgiamua.setForeground(Color.red);
        tbgiamua.setText(null);
        tfgiamua.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e) {
                String input=tfgiamua.getText();
                    if(!input.matches("\\d+"))   
                        tbgiamua.setText("Sai định dạng giá mua!");
                    
                    else
                        tbgiamua.setText(null);
            }
            
        });
        add(tbgiamua);
        tfgiaban= new JTextField();
        tfgiaban.setBounds(160, 140, 200, 25);
        add(tfgiaban);
        tbgiaban=new JLabel();
        tbgiaban.setBounds(370, 140, 200, 25);
        tbgiaban.setForeground(Color.red);
        tbgiaban.setText(null);
        add(tbgiaban);
        tfgiaban.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e) {
                String input=tfgiaban.getText();
                    if(!input.matches("\\d+"))   
                        tbgiaban.setText("Sai định dạng giá bán!");
                    
                    else
                        tbgiaban.setText(null);
            }
            
        });
        tfslnhap= new JTextField();
        tfslnhap.setBounds(160, 230, 200, 25);
        add(tfslnhap);
        tbslnhap= new JLabel();
        tbslnhap.setBounds(370, 230, 200, 25);
        tbslnhap.setForeground(Color.red);
        tbslnhap.setText(null);
        add(tbslnhap);
        tfslnhap.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e) {
                String input=tfslnhap.getText();
                    if(!input.matches("\\d+"))   
                        tbslnhap.setText("Sai định dạng sl nhập!");
                    
                    else
                        tbslnhap.setText(null);
            }
            
        });
        tfvat= new JTextField();
        tfvat.setBounds(160, 260, 200, 25);
        add(tfvat);
        tbvat=new JLabel();
        tbvat.setBounds(370, 260, 200, 25);
        tbvat.setForeground(Color.red);
        tbvat.setText(null);
        add(tbvat);
        tfvat.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e) {
                String input=tfvat.getText();
                    if(!input.matches("\\d+"))   
                        tbvat.setText("Sai định dạng thuế VAT!");
                    
                    else
                        tbvat.setText(null);
            }
            
        });
        cmbloaihang= new JComboBox();
        cmbloaihang.setBounds(160, 290, 200, 25);
        add(cmbloaihang);
        tblh= new JLabel();
        tblh.setBounds(370, 290, 200, 25);
        tblh.setForeground(Color.red);
        add(tblh);
        cmbdvt= new JComboBox();
        cmbdvt.setBounds(160, 320, 200, 25);
        addDVT();
        addLoaiHang();
        add(cmbdvt);
        tbdvt= new JLabel();
        tbdvt.setBounds(370, 320, 200, 25);
        tbdvt.setForeground(Color.red);
        add(tbdvt);
        btnadd= new JLabel();
        btnadd.setIcon(new ImageIcon("./src/IMG/btnEdit_150px.png"));
        btnadd.setBounds(50, 370,200, 50);
        btnadd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(btnadd);
            btnadd.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                    String Mamh=tfmamh.getText();
                    String tenmh = tften.getText();
                    String giamua = tfgiamua.getText();
                    String giaban = tfgiaban.getText();
                    double sogiamua=0,sogiaban=0;
                    int soslnhap=0,sovat=0;
                    Date ngaysx = datengaysanxuat.getDate();
                    Date hansudung = datehansudung.getDate();
                    String slnhap = tfslnhap.getText();
                    String vat= tfvat.getText();
                    String malh="",madvt="";
                    String malhtemp=cmbloaihang.getSelectedItem().toString();
                    String madvttemp=cmbdvt.getSelectedItem().toString();
                                try {
                       if (tenmh.trim().isEmpty()||giamua.trim().isEmpty()||giaban.trim().isEmpty()||slnhap.trim().isEmpty()||vat.trim().isEmpty()||malhtemp.equalsIgnoreCase("Chọn loại")||madvttemp.equalsIgnoreCase("Chọn ĐVT")) {
                           {
                               throw new Exception("Các TextFiled, ComboBox không được để trống hoặc chưa chọn!");
                           }   
                           }
                       sogiamua=Double.valueOf(giamua);
                       sogiaban= Double.valueOf(giaban);
                       soslnhap= Integer.valueOf(slnhap);
                       sovat= Integer.valueOf(vat);
                       malh = LoaiHangBUS.getIntance().laymatheotenloaihang(malhtemp);
                       madvt = DonViBUS.getIntance().laymatheotendonvitinh(madvttemp);
                       // Tiếp tục xử lý khi giá trị hợp lệ.

                   } catch (Exception ex) {
                       // Xử lý ngoại lệ ở đây, ví dụ như thông báo lỗi cho người dùng.
                       JOptionPane.showMessageDialog(null, ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                       if(madvttemp.equalsIgnoreCase("Chọn ĐVT"))
                           tbdvt.setText("Chưa chọn ĐVT!");
                       if(malhtemp.equalsIgnoreCase("Chọn loại"))
                           tblh.setText("Chưa chọn loại hàng!");
                       if(tenmh.trim().isEmpty())
                           tbten.setText("Chưa nhập tên!");
                       if(giamua.trim().isEmpty())
                           tbgiamua.setText("Chưa nhập giá mua!");
                       if(giaban.trim().isEmpty())
                           tbgiaban.setText("Chưa nhập giá bán!");
                       if(slnhap.trim().isEmpty())
                           tbslnhap.setText("Chưa nhập sl nhập!");
                       if(vat.trim().isEmpty())
                           tbvat.setText("Chưa nhập thuế VAT!");
                   }
                                
                    Date ngaynhap = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String formattedDate = dateFormat.format(ngaynhap);
                    if(!malhtemp.equalsIgnoreCase("Chọn loại"))
                        tblh.setText(null);
                    if(!madvttemp.equalsIgnoreCase("Chọn ĐVT"))
                        tbdvt.setText(null);
                    
                    String img=temp2;
                    MatHangDTO mh= new MatHangDTO(Mamh,tenmh,sogiamua,sogiaban,ngaysx,hansudung,soslnhap,0,ngaynhap,sovat,malh,madvt,img);
                    if(!tenmh.trim().isEmpty()&&tbten.getText()==null&&tblh.getText()==null&&tbdvt.getText()==null&&!tenmh.trim().isEmpty()&&!giaban.trim().isEmpty()&&!giamua.trim().isEmpty()&&!slnhap.trim().isEmpty()&&!vat.trim().isEmpty()&&tbgiaban.getText()==null&&tbgiamua.getText()==null&&tbslnhap.getText()==null&&tbvat.getText()==null&&!madvt.equalsIgnoreCase(null)&&!malh.equalsIgnoreCase(null)){
                    mathangBUS.capnhat(mh);
                    cleanView();
                    JOptionPane.showMessageDialog(null, "Sửa thành công");
                    }
//                    else
//                    JOptionPane.showMessageDialog(null, "Thêm thất bại");
                    
                    
                    
                    
                   

            }
            });
        
        btnimg= new JLabel();
        btnimg.setIcon(new ImageIcon("./src/IMG/btnFile.png"));
        btnimg.setBounds(250,370,200,50);
        btnimg.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(btnimg);
        btnimg.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                MatHangGUI mhGUI = new MatHangGUI(1300);
                JFileChooser fc = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & PNG images", "jpg", "png");
                fc.setFileFilter(filter);
                int result = fc.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) 
                {
                    try {
                        File file = fc.getSelectedFile(); //Lấy URL hình
                        mhGUI.i = ImageIO.read(file); // Lấy hình
                        mhGUI.HinhAnh = tfmamh.getText();
                        temp=mathangBUS.getAnh(mhGUI.HinhAnh);
                        System.out.println(file);
                        
                         temp2=file.toString().substring(84, file.toString().length());
                        
                        // Thay đổi hình hiển thị
                        mhGUI.img.setText("");
                        mhGUI.img.setIcon(new ImageIcon(mhGUI.i.getScaledInstance(200, 230, Image.SCALE_DEFAULT)));
                        
                        revalidate();
                        repaint();
                    } catch (IOException ex) {
                        Logger.getLogger(dladdMatHangGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }
    public void cleanView()
    {
        
        tfmamh.setText("");
        tften.setText("");
        tfgiamua.setText("");
        tfgiaban.setText("");
        tfslnhap.setText("");
        tfvat.setText("");
        cmbloaihang.setSelectedItem("Chọn loại");
        cmbdvt.setSelectedItem("Chọn ĐVT");
    }
    public void addLoaiHang()
    {
        Vector<String> vec= new Vector();
        vec.add("Chọn loại");
        for(LoaiHangDTO lh: LoaiHangBUS.getIntance().getList())
        {
            vec.add(lh.getTenLH());
        }
        DefaultComboBoxModel<String>cbmodel=new DefaultComboBoxModel<>(vec);
        cmbloaihang.setModel(cbmodel);
    }
    public void addDVT()
    {
        Vector<String> vec= new Vector();
        vec.add("Chọn ĐVT");
        for(DonViDTO lh: DonViBUS.getIntance().getList())
        {
            vec.add(lh.getTenDVT());
        }
        DefaultComboBoxModel<String>cbmodel=new DefaultComboBoxModel<>(vec);
        cmbdvt.setModel(cbmodel);
    }
   
}


 
    
    


