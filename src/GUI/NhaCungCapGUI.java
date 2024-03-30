//
//package GUI;
//
///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//
///**
// *c
// * @author Admin
// */
//import javax.swing.JPanel;
//import BUS.NhaCungCapBUS;
//import DTO.NhaCungCapDTO;
//import DAO.NhaCungCapDAO;
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
////import DTO.SanPhamDTO;
////import BUS.SanPhamBUS;
////import DTO.LoaiDTO;
////import DTO.NsxDTO;
//import java.awt.Choice;
//import java.awt.Color;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.FocusAdapter;
//import java.awt.event.FocusEvent;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.text.DecimalFormat;
//import java.util.Arrays;
//import javax.imageio.ImageIO;
//import javax.swing.BorderFactory;
//import javax.swing.DefaultListModel;
//import javax.swing.JComboBox;
//import javax.swing.JFileChooser;
//import javax.swing.JList;
//import javax.swing.JSeparator;
//import javax.swing.RowFilter;
//import javax.swing.SwingConstants;
//import javax.swing.event.DocumentEvent;
//import javax.swing.event.DocumentListener;
//import javax.swing.filechooser.FileNameExtensionFilter;
//import javax.swing.table.DefaultTableCellRenderer;
//import javax.swing.table.TableModel;
//import javax.swing.table.TableRowSorter;
//
//public class NhaCungCapGUI extends JPanel implements ActionListener {
//	private int DEFALUT_WIDTH;
//
//	public NhaCungCapGUI(int width) {
//		DEFALUT_WIDTH = width;
//		init();
//	}
//
//	private JTable ds, tb2;
//	private String[] mangNcc = new String[0];
//	private JScrollPane jScrollPane1;
//	private JLabel title, btnchonanh, txtrefresh, txtsearch, img, lbmasp, lbloaisp, lbgiafrom, lbgiato, btnsearch,
//			btnxuatfile, btnnhapfile;
//	public static JLabel btnadd, btnedit, btndelete;
//	private JLabel buttons[];
//	private JTextField textfields[], tftimkiem, tfmasp, tfloaisp;
//	private ImageIcon icon1;
//	private JPanel filter;
//	private NhaCungCapBUS nhacungcapBus;
//	private String[] title1 = { "Mã NCC", "Tên NCC", "Địa chỉ", "Điện thoại" };
//	private DefaultTableModel tb1, model1;
//	private JComboBox cmbChoice;
//
//	public void init() {
//		setLayout(null);
//		setPreferredSize(new Dimension(1100, 700));
//		setBackground(new Color(0xEEEEEE));
//		title = new JLabel("QUẢN LÍ NHÀ CUNG CẤP");
//		title.setBounds(345, 10, 305, 40);
//		title.setFont(new Font("Serif", Font.BOLD, 25));
//		add(title);
//
//		// icon= new ImageIcon("/images/refresh_40px.png");
//		txtrefresh = new JLabel();
//		txtrefresh.setIcon(new ImageIcon("./src/IMG/Refresh-icon.png"));
//		txtrefresh.setBounds(650, 10, 30, 30);
//		txtrefresh.setCursor(new Cursor(Cursor.HAND_CURSOR));
//		txtrefresh.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				loadDataLenBangSanPham();
//				cleanView();
//				tftimkiem.setText("");
//				cmbChoice.setSelectedItem("Tên NCC");
//
//			}
//		});
//		add(txtrefresh);
//
//		buttons = new JLabel[6];
//		textfields = new JTextField[6];
//		int toadoyButton = 90;
//		String[] arrBtn = { "Mã NCC", "Tên NCC", "Địa chỉ", "Điện thoại" };
//		for (int i = 0; i < 4; i++) {
//			buttons[i] = new JLabel(arrBtn[i]);
//			buttons[i].setBounds(100, toadoyButton, 100, 25);
//			buttons[i].setFont(new Font("Serif", Font.BOLD, 18));
//			textfields[i] = new JTextField();
//			textfields[i].setBounds(200, toadoyButton, 550, 25);
//			textfields[i].setFont(new Font("Serif", 0, 15));
//			textfields[i].setHorizontalAlignment(JTextField.CENTER);
//			toadoyButton += 30;
//			add(buttons[i]);
//			add(textfields[i]);
//		}
//
//		txtsearch = new JLabel();
//
//		cmbChoice = new JComboBox();
//		cmbChoice.setEditable(true);
//		cmbChoice.setFont(new Font("Serif", Font.PLAIN, 14));
//		cmbChoice.addItem("Mã NCC");
//		cmbChoice.addItem("Tên NCC");
//		cmbChoice.addItem("Địa chỉ");
//		cmbChoice.addItem("SĐT");
//		cmbChoice.setBounds(210, 270, 120, 25);
//		add(cmbChoice);
//
//		tftimkiem = new JTextField();
//		tftimkiem.setBackground(Color.WHITE);
//		// tftimkiem.setOpaque(false);
//		tftimkiem.setBounds(new Rectangle(330, 270, 400, 25));
//		tftimkiem.setFont(new Font("Serif", 0, 15));
//		add(tftimkiem);
//
//		textfields[0].setEditable(false);
//
//		btnadd = new JLabel();
//		btnadd.setIcon(new ImageIcon("./src/IMG/btnAdd_150px.png"));
//		btnadd.setBounds(800, 65, 200, 50);
//		btnadd.setCursor(new Cursor(Cursor.HAND_CURSOR));
//		btnadd.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				int i = getmanhacungcap();
//				i++;
//				String number = String.valueOf(i);
//				String maNCC = "NCC" + number;
//				textfields[0].setText(maNCC);
//				String tenNCC = textfields[1].getText();
//				String diaChi = textfields[2].getText();
//				String dienThoai = textfields[3].getText();
//				NhaCungCapDTO ncc = new NhaCungCapDTO(maNCC, tenNCC, diaChi, dienThoai);
//				nhacungcapBus.add(ncc);
//				loadDataLenBangSanPham();
//				cleanView();
//
//			}
//		});
//		btnedit = new JLabel();
//		btnedit.setIcon(new ImageIcon("./src/IMG/btnEdit_150px.png"));
//		btnedit.setBounds(800, 115, 200, 50);
//		btnedit.setCursor(new Cursor(Cursor.HAND_CURSOR));
//		btnedit.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				String maNCC = textfields[0].getText();
//				String tenNCC = textfields[1].getText();
//				String diaChi = textfields[2].getText();
//				String dienThoai = textfields[3].getText();
//
//				NhaCungCapDTO ncc = new NhaCungCapDTO(maNCC, tenNCC, diaChi, dienThoai);
//				nhacungcapBus.sua(ncc);
//				loadDataLenBangSanPham();
//				cleanView();
//
//			}
//		});
//		btndelete = new JLabel();
//		btndelete.setIcon(new ImageIcon("./src/IMG/btnDelete_150px.png"));
//		btndelete.setBounds(800, 165, 200, 50);
//		btndelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
//		btndelete.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				String maNCC = textfields[0].getText();
//				String tenNCC = textfields[1].getText();
//				String diaChi = textfields[2].getText();
//				String dienThoai = textfields[3].getText();
//				NhaCungCapDTO ncc = new NhaCungCapDTO(maNCC, tenNCC, diaChi, dienThoai);
//				int i = JOptionPane.showConfirmDialog(null, "Xác nhận xóa", "Alert", JOptionPane.YES_NO_OPTION);
//				if (i == 0) {
//					nhacungcapBus.delete(ncc);
//					loadDataLenBangSanPham();
//					cleanView();
//				}
//
//			}
//		});
////        btnchonanh= new JLabel();
////        btnchonanh.setIcon(new ImageIcon(MatHangGUI.class.getResource("/images/btnFile.png")));
////        btnchonanh.setBounds(800,215,200,50);
////        btnchonanh.setCursor(new Cursor(Cursor.HAND_CURSOR));
//		add(btnadd);
//		add(btnedit);
//		add(btndelete);
//		// add(btnchonanh);
//
//		nhacungcapBus = new NhaCungCapBUS();
//		String mean[][] = null;
//		tb1 = new DefaultTableModel(mean, title1);
//
//		ds = new JTable(tb1);
//		ds.setFont(new Font("Serif", 0, 15));
//		ds.getTableHeader().setForeground(Color.white);
//		ds.getTableHeader().setBackground(new Color(52, 152, 219));
//		ds.getTableHeader().setFont(new Font("erif", Font.BOLD, 15));
//		ds.getTableHeader().setPreferredSize(new Dimension(700, 30));
//		ds.setRowHeight(25);
//		ds.getColumnModel().getColumn(0).setPreferredWidth(10);
//		ds.getColumnModel().getColumn(1).setPreferredWidth(200);
//		ds.getColumnModel().getColumn(2).setPreferredWidth(200);
//		ds.getColumnModel().getColumn(3).setPreferredWidth(10);
//		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
//		ds.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
//		ds.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
//		ds.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				int i = ds.getSelectedRow();
//
//				textfields[0].setText(ds.getModel().getValueAt(i, 0).toString());
//				textfields[1].setText(ds.getModel().getValueAt(i, 1).toString());
//				textfields[2].setText(ds.getModel().getValueAt(i, 2).toString());
//				textfields[3].setText(ds.getModel().getValueAt(i, 3).toString());
//			}
//		});
//
//		jScrollPane1 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
//				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//		jScrollPane1.setBounds(80, 330, 920, 300);
//		jScrollPane1.setViewportView(ds);
//		getDsncc();
//		add(jScrollPane1);
//
//		TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(tb1);
//		ds.setRowSorter(rowSorter);
//
//		tftimkiem.addFocusListener(new FocusAdapter() {
//			@Override
//			public void focusGained(FocusEvent e) {
//				txtsearch.setIcon(new ImageIcon("./src/IMG/search_25px.png"));
//				txtsearch.setBorder(createLineBorder(new Color(52, 152, 219))); // Đổi màu viền
//			}
//
//			public void focusLost(FocusEvent e) // Trờ về như cũ
//			{
//				txtsearch.setIcon(new ImageIcon("./src/IMG/search_25px.png"));
//				txtsearch.setBorder(createLineBorder(Color.BLACK)); // Đổi màu viền
//			}
//		});
//		tftimkiem.getDocument().addDocumentListener(new DocumentListener() {
//			@Override
//			public void insertUpdate(DocumentEvent e) {
//				String text = tftimkiem.getText();
//				int choice = cmbChoice.getSelectedIndex();
//
//				if (text.trim().length() == 0) {
//					rowSorter.setRowFilter(null);
//				} else {
//					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text + "", choice));
//				}
//			}
//
//			@Override
//			public void removeUpdate(DocumentEvent e) {
//				String text = tftimkiem.getText();
//				int choice = cmbChoice.getSelectedIndex();
//
//				if (text.trim().length() == 0) {
//					rowSorter.setRowFilter(null);
//				} else {
//					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text + "", choice));
//				}
//			}
//
//			@Override
//			public void changedUpdate(DocumentEvent e) {
////                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//			}
//
//		});
//
//	}
//
//	public void getDsncc() {
////		"Mã SP","Tên SP","Đơn giá","Còn lại","Đơn vị tính","Hạn sử dụng"
//		DefaultTableModel model = (DefaultTableModel) ds.getModel();
//		for (int i = 0; i < nhacungcapBus.getList().size(); i++) {
//			themPhanTuVaoMangNcc(nhacungcapBus.getList().get(i).getMaNcc());
//			themPhanTuVaoMangNcc(nhacungcapBus.getList().get(i).getTenNcc());
//			themPhanTuVaoMangNcc(nhacungcapBus.getList().get(i).getDiachi());
//			themPhanTuVaoMangNcc(nhacungcapBus.getList().get(i).getDienthoai());
//			model.addRow(mangNcc);
//			mangNcc = new String[0];
//		}
//	}
//
//	public void themPhanTuVaoMangNcc(String s) {
//		int l = mangNcc.length;
//		mangNcc = Arrays.copyOf(mangNcc, l + 1);
//		mangNcc[l] = s;
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
//																		// Tools | Templates.
//	}
//
//	public void cleanView() // Xóa trắng các TextField
//	{
//		textfields[0].setEditable(false);
//
//		textfields[0].setText("");
//		textfields[1].setText("");
//		textfields[2].setText("");
//		textfields[3].setText("");
//		textfields[1].requestFocusInWindow();
//		ds.clearSelection();
//	}
//
//	private void loadDataLenBangSanPham() {
//
//		tb1.setRowCount(0);
//
//		ArrayList<NhaCungCapDTO> ds = nhacungcapBus.getList();
//
//		DecimalFormat dcf = new DecimalFormat("###,###");
//
//		for (NhaCungCapDTO ncc : ds) {
//			Vector vec = new Vector();
//			vec.add(ncc.getMaNcc());
//			vec.add(ncc.getTenNcc());
//			vec.add(ncc.getDiachi());
//			vec.add(ncc.getDienthoai());
//
//			tb1.addRow(vec);
//		}
//	}
//
//	public int getmanhacungcap() {
//		int maNCCmoinhat = 0;
//		for (NhaCungCapDTO ncc : nhacungcapBus.getList()) {
//			String txtmaNcc = ncc.getMaNcc();
//			txtmaNcc = txtmaNcc.replace("NCC", "");
//			int maHD = Integer.parseInt(txtmaNcc);
//			if (maHD > maNCCmoinhat) {
//				maNCCmoinhat = maHD;
//			}
//		}
//		return maNCCmoinhat;
//	}
//
//}
package GUI;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *c
 * @author Admin
 */
import javax.swing.JPanel;
import BUS.NhaCungCapBUS;
import DTO.NhaCungCapDTO;
import DAO.NhaCungCapDAO;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class NhaCungCapGUI extends JPanel implements ActionListener{
    private int DEFALUT_WIDTH;
    public NhaCungCapGUI(int width)
    {
        DEFALUT_WIDTH=width;
        init();
        this.setVisible(false);
    }
    private JTable ds,tb2;
    private String []mangNcc= new String[0];
    private JScrollPane jScrollPane1;
    private JLabel title,btnchonanh,txtrefresh,txtsearch,img,lbmasp,lbloaisp,lbgiafrom,lbgiato,btnsearch,btnxuatfile,btnnhapfile;
    private JLabel buttons[];
    private JTextField textfields[],tftimkiem,tfmasp,tfloaisp;
    private NhaCungCapBUS nhacungcapBus;
    private final String []title1= { "Mã NCC", "Tên NCC", "Địa chỉ", "Điện thoại"};
    private DefaultTableModel tb1,model1;
    private JComboBox cmbChoice;
    String maNCC="";
    private  JLabel tbten,tbdiachi,tbdienthoai;
    public static JLabel btnadd,btnedit,btndelete;
    public void init()
    {
        setLayout(null);
        setPreferredSize(new Dimension(1100,700));
        setBackground(new Color(0xEEEEEE));
        title= new JLabel("QUẢN LÍ NHÀ CUNG CẤP"); 
        title.setBounds(345, 10, 305, 40);
        title.setFont(new Font("Serif",Font.BOLD,25));
         add(title);
         

         
         //icon= new ImageIcon("/images/refresh_40px.png");
         txtrefresh = new JLabel();
         txtrefresh.setIcon(new ImageIcon("./src/IMG/Refresh-icon.png"));
         txtrefresh.setBounds(650, 10,30, 30);
        txtrefresh.setCursor(new Cursor(Cursor.HAND_CURSOR));
        txtrefresh.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
             {
                      loadDataLenBangSanPham();
                      cleanView();
                      tftimkiem.setText("");
                      textfields[0].setText(maNCC);
                      cmbChoice.setSelectedItem("Tên NCC");
                        
             }
        });
         add(txtrefresh);
         
        buttons=new JLabel[6];
        textfields= new JTextField[6];
        int toadoyButton=90;
        String[] arrBtn={"Mã NCC","Tên NCC","Địa chỉ","Điện thoại"};
        for(int i=0;i<4;i++)
        {
           buttons[i]=new JLabel(arrBtn[i]);
           buttons[i].setBounds(100, toadoyButton, 100, 25);
           buttons[i].setFont(new Font("Serif",Font.BOLD,18));
           textfields[i]=new JTextField();
           textfields[i].setBounds(200, toadoyButton, 550, 25);
           textfields[i].setFont(new Font("Serif",0,15));
           textfields[i].setHorizontalAlignment(JTextField.CENTER);
           toadoyButton+=30; 
           add(buttons[i]); 
           add(textfields[i]);
        }
        
         txtsearch = new JLabel();
        
        cmbChoice = new JComboBox();
        cmbChoice.setEditable(true);
        cmbChoice.setFont(new Font("Serif",Font.PLAIN,14));
        cmbChoice.addItem("Mã NCC");
        cmbChoice.addItem("Tên NCC");
        cmbChoice.addItem("Địa chỉ");
        cmbChoice.addItem("SĐT");
        cmbChoice.setBounds(210,280,120,25);
        add(cmbChoice);
        
       
        tftimkiem = new JTextField();
        tftimkiem.setBackground(Color.WHITE);
        //tftimkiem.setOpaque(false);
        tftimkiem.setBounds(new Rectangle(330, 280, 400, 25));
        tftimkiem.setFont(new Font("Serif",0,15));
        add(tftimkiem);
        
        tbten=new JLabel();
        tbten.setBounds(800, 100,200, 50);
        tbten.setForeground(Color.red);
        add(tbten);
        
        tbdiachi= new JLabel();
        tbdiachi.setBounds(800, 135,200, 50);
        tbdiachi.setForeground(Color.red);
        add(tbdiachi);
        
        tbdienthoai= new JLabel();
        tbdienthoai.setBounds(800, 170,200, 50);
        tbdienthoai.setForeground(Color.red);
        tbdienthoai.setText(null);
        add(tbdienthoai);
       textfields[3].addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e) {
                String input= textfields[3].getText();
                if(!input.matches("^(\\d{10}|\\d{11})$"))
                    tbdienthoai.setText("Sai định dạng điện thoại!");
                else
                    tbdienthoai.setText(null);
                    
            }
            
        });
        
        
       textfields[0].setEditable(false);
        
        
        btnadd= new JLabel();
        btnadd.setIcon(new ImageIcon("./src/IMG/btnAdd_150px.png"));
        btnadd.setBounds(200, 220,200, 50);
        btnadd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnadd.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
             {
                      int i= getmanhacungcap();
                      i++;
                      String number= String.valueOf(i);
                      maNCC= "NCC"+ number ;
                        String tenNCC = textfields[1].getText();
                        String diaChi = textfields[2].getText();
                        String dienThoai = textfields[3].getText();
                        try{
                            if(tenNCC.trim().isEmpty()||diaChi.trim().isEmpty()||dienThoai.trim().isEmpty())
                                throw new Exception("Các TextFiled không được để trống!");
                        }catch(Exception ex)
                        {
                             JOptionPane.showMessageDialog(null, ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                             if(tenNCC.trim().isEmpty())
                                 tbten.setText("Chưa nhập tên!");
                             if(diaChi.trim().isEmpty())
                                 tbdiachi.setText("Chưa nhập địa chỉ!");
                             if(dienThoai.trim().isEmpty())
                                 tbdienthoai.setText("Chưa nhập số điện thoại");
                        }
                        NhaCungCapDTO ncc= new NhaCungCapDTO(maNCC, tenNCC, diaChi, dienThoai);
                        if(!tenNCC.trim().isEmpty()&&tbten.getText()==null&&!diaChi.trim().isEmpty()&&tbdiachi.getText()==null&&!dienThoai.trim().isEmpty()&&tbdienthoai.getText()==null)
                        {
                        nhacungcapBus.add(ncc);
                        loadDataLenBangSanPham();
                        cleanView();
                        }
                        
             }
        });
        btnedit = new JLabel();
        btnedit.setIcon(new ImageIcon("./src/IMG/btnEdit_150px.png"));
        btnedit.setBounds(400, 220,200, 50);
        btnedit.setCursor(new Cursor(Cursor.HAND_CURSOR));      
        btnedit.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
             {
                      String maNCC = textfields[0].getText();
                        String tenNCC = textfields[1].getText();
                        String diaChi = textfields[2].getText();
                        String dienThoai = textfields[3].getText();
                         try{
                            if(tenNCC.trim().isEmpty()||diaChi.trim().isEmpty()||dienThoai.trim().isEmpty())
                                throw new Exception("Các TextFiled không được để trống!");
                        }catch(Exception ex)
                        {
                             JOptionPane.showMessageDialog(null, ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                             if(tenNCC.trim().isEmpty())
                                 tbten.setText("Chưa nhập tên!");
                             if(diaChi.trim().isEmpty())
                                 tbdiachi.setText("Chưa nhập địa chỉ!");
                             if(dienThoai.trim().isEmpty())
                                 tbdienthoai.setText("Chưa nhập số điện thoại");
                        }
                        NhaCungCapDTO ncc= new NhaCungCapDTO(maNCC, tenNCC, diaChi, dienThoai);
                        if(!tenNCC.trim().isEmpty()&&tbten.getText()==null&&!diaChi.trim().isEmpty()&&tbdiachi.getText()==null&&!dienThoai.trim().isEmpty()&&tbdienthoai.getText()==null)
                        {
                        nhacungcapBus.sua(ncc);
                        loadDataLenBangSanPham();
                        cleanView();
                        }
                        
             }
        });
        btndelete = new JLabel();
        btndelete.setIcon(new ImageIcon("./src/IMG/btnDelete_150px.png"));
        btndelete.setBounds(600, 220,200, 50);
        btndelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btndelete.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
             {
                 String maNCC = textfields[0].getText();
                        String tenNCC = textfields[1].getText();
                        String diaChi = textfields[2].getText();
                        String dienThoai = textfields[3].getText();
                        NhaCungCapDTO ncc= new NhaCungCapDTO(maNCC, tenNCC, diaChi, dienThoai);
                       int i = JOptionPane.showConfirmDialog(null, "Xác nhận xóa","Alert",JOptionPane.YES_NO_OPTION);
                if(i == 0)
                {
                    nhacungcapBus.delete(ncc);
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
        
        nhacungcapBus = new NhaCungCapBUS();
        String mean[][]= null;
        tb1= new DefaultTableModel(mean,title1);
        
        ds = new JTable(tb1);
        ds.setFont(new Font("Serif",0,15));
        ds.getTableHeader().setForeground(Color.white);
	ds.getTableHeader().setBackground(new Color(52, 152, 219));
	ds.getTableHeader().setFont(new Font("erif", Font.BOLD, 15));
	ds.getTableHeader().setPreferredSize(new Dimension(700,30));
	ds.setRowHeight(25);
        ds.getColumnModel().getColumn(0).setPreferredWidth(10);
	ds.getColumnModel().getColumn(1).setPreferredWidth(200);
	ds.getColumnModel().getColumn(2).setPreferredWidth(200);
	ds.getColumnModel().getColumn(3).setPreferredWidth(10);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        ds.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        ds.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        ds.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
             {
                int i = ds.getSelectedRow();
                
                textfields[0].setText(ds.getModel().getValueAt(i, 0).toString());
                textfields[1].setText(ds.getModel().getValueAt(i, 1).toString());
                textfields[2].setText(ds.getModel().getValueAt(i, 2).toString()); 
                textfields[3].setText(ds.getModel().getValueAt(i, 3).toString());        
             }
        });
       
       jScrollPane1 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
       jScrollPane1.setBounds(80, 330,920, 300);
       jScrollPane1.setViewportView(ds);
       getDsncc();
       add(jScrollPane1);
       
      
       TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(tb1);
        ds.setRowSorter(rowSorter);
        
        tftimkiem.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e) 
            {
                txtsearch.setIcon(new ImageIcon("/images/search_25px.png"));
                txtsearch.setBorder(createLineBorder(new Color(52,152,219))); // Đổi màu viền 
            }
            public void focusLost(FocusEvent e) //Trờ về như cũ
            {
                txtsearch.setIcon(new ImageIcon("/images/search_25px.png"));
                txtsearch.setBorder(createLineBorder(Color.BLACK)); // Đổi màu viền 
            }
        });
        tftimkiem.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = tftimkiem.getText();
                int choice = cmbChoice.getSelectedIndex();
                
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+ text +"", choice));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = tftimkiem.getText();
                int choice = cmbChoice.getSelectedIndex();
                
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+ text +"", choice));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
       
       
    }
    
    public void getDsncc() {
//		"Mã SP","Tên SP","Đơn giá","Còn lại","Đơn vị tính","Hạn sử dụng"
		DefaultTableModel model = (DefaultTableModel) ds.getModel();
		for(int i=0;i<nhacungcapBus.getList().size();i++) {
			themPhanTuVaoMangNcc(nhacungcapBus.getList().get(i).getMaNcc());
			themPhanTuVaoMangNcc(nhacungcapBus.getList().get(i).getTenNcc());
			themPhanTuVaoMangNcc(nhacungcapBus.getList().get(i).getDiachi());			
			themPhanTuVaoMangNcc(nhacungcapBus.getList().get(i).getDienthoai());
			model.addRow(mangNcc);
			mangNcc= new String[0];
		}
	} 
        public void themPhanTuVaoMangNcc(String s) {
		int l=mangNcc.length;
		mangNcc=Arrays.copyOf(mangNcc, l+1);
		mangNcc[l]=s;
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void cleanView() //Xóa trắng các TextField
    {
        textfields[0].setText(maNCC);
         textfields[0].setEditable(false);

         textfields[1].setText("");
         textfields[2].setText("");
         textfields[3].setText("");
         textfields[0].requestFocusInWindow();
         ds.clearSelection();
    }
     private void loadDataLenBangSanPham() {

        tb1.setRowCount(0);

        ArrayList<NhaCungCapDTO> ds = nhacungcapBus.getList();

        DecimalFormat dcf = new DecimalFormat("###,###");

        for (NhaCungCapDTO ncc : ds) {
            Vector vec = new Vector();
            vec.add(ncc.getMaNcc());
            vec.add(ncc.getTenNcc());
            vec.add(ncc.getDiachi());
            vec.add(ncc.getDienthoai());

            tb1.addRow(vec);
        }
    }
   public int getmanhacungcap()
   {
       int maNCCmoinhat=0;
       for(NhaCungCapDTO ncc: nhacungcapBus.getList()) {
			String txtmaNcc=ncc.getMaNcc();
			txtmaNcc=txtmaNcc.replace("NCC", "");
			int maHD=Integer.parseInt(txtmaNcc);
			if(maHD>maNCCmoinhat) {
				maNCCmoinhat=maHD;
			}
		}
       return maNCCmoinhat;
   }
   
    
}


