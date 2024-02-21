
package GUI;

import BUS.DonViBUS;
import BUS.LoaiHangBUS;
import javax.swing.JPanel;
//import BUS.LoaiBUS;
//import BUS.NsxBUS;
import BUS.MatHangBUS;
import DTO.MatHangDTO;
import DAO.MatHangDAO;
import DTO.DonViDTO;
import DTO.LoaiHangDTO;
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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
//import DTO.SanPhamDTO;
//import BUS.SanPhamBUS;
//import DTO.LoaiDTO;
//import DTO.NsxDTO;

import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.util.Arrays;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import static javax.swing.BorderFactory.createLineBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.RowFilter;

import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Admin
 */
public class MatHangGUI extends JPanel implements MouseListener, KeyListener {
	private int DEFALUT_WIDTH;

	public MatHangGUI(int width) {
		DEFALUT_WIDTH = width;
		init();
	}

	private JScrollPane jScrollPane1;
	public String HinhAnh = "hiha";
	private DecimalFormat dcf = new DecimalFormat("###,###");
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	private JLabel title, btnchonanh, txtrefresh, txtsearch, lbmasp, lbloaisp, lbgiafrom, lbgiato, btnsearch,
			btnxuatfile, btnnhapfile;
	public static JLabel btnadd, btnedit, btndelete;
	private JLabel buttons[];
	public JLabel img;
	private JTextField textfields[], tftimkiem, tfmasp, tfloaisp, tfgiafrom, tfgiato;
	private ImageIcon icon1;
	private JPanel filter;
	private dladdMatHangGUI dl;
	private dleditMatHangGUI dl2;
	public JTable ds, dsfull;
	public DefaultTableModel tb1, tbfull;
	private MatHangBUS mathangBUS;
	private String[] title1 = { "Mã SP", "Tên SP", "Loại SP", "Số lượng", "Đơn vị tính", "Đơn giá" };
	private String[] titlefull = { "Mã SP", "Tên SP", "giamua", "giaban", "ngaysx", "hansudung", "slnhap", "slban",
			"ngaynhap", "vat", "malh", "madvt" };
	private String[] TTSP = new String[0];
	private String[] TTSPFull = new String[0];
	private File fileAnhSP;
	private JComboBox cmbloaihang;
	public BufferedImage i = null;
	public int dem;

	public void init() {
		setLayout(null);
		setPreferredSize(new Dimension(1100, 700));
		setBackground(new Color(0xEEEEEE));
		this.setVisible(false);
		title = new JLabel("QUẢN LÍ SẢN PHẨM");
		title.setBounds(400, 10, 250, 40);
		title.setFont(new Font("Serif", Font.BOLD, 25));
		add(title);

		// icon= new ImageIcon("/images/refresh_40px.png");
		txtrefresh = new JLabel();
		txtrefresh.setIcon(new ImageIcon("./src/IMG/Refresh-icon.png"));
		txtrefresh.setBounds(650, 10, 30, 30);
		txtrefresh.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(txtrefresh);
		txtrefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cleanView();
				loadData();
				// saveimg();

			}

		});

		buttons = new JLabel[6];
		textfields = new JTextField[6];
		int toadoyButton = 70;
		String[] arrBtn = { "Mã SP", "Tên SP", "Loại SP", "Số lượng", "Đơn vị tính", "Đơn giá" };
		for (int i = 0; i < 6; i++) {
			buttons[i] = new JLabel(arrBtn[i]);
			buttons[i].setBounds(80, toadoyButton, 100, 25);
			buttons[i].setFont(new Font("Serif", Font.BOLD, 18));
			textfields[i] = new JTextField();
			textfields[i].setBounds(180, toadoyButton, 320, 25);
			textfields[i].setFont(new Font("Serif", 0, 15));
			toadoyButton += 30;
			add(buttons[i]);
			add(textfields[i]);
		}

		tftimkiem = new JTextField();
		tftimkiem.setBackground(Color.WHITE);
		// tftimkiem.setOpaque(false);
		tftimkiem.setBounds(new Rectangle(330, 270, 400, 25));
		tftimkiem.setFont(new Font("Serif", 0, 20));
		add(tftimkiem);

		txtsearch = new JLabel();
		txtsearch.setBounds(new Rectangle(730, 262, 40, 40));
		txtsearch.setIcon(new ImageIcon("./src/IMG/search_25px.png"));
		txtsearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(txtsearch);

		img = new JLabel("Image");
		img.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		img.setFont(new Font("Serif", 0, 20));
		img.setHorizontalAlignment(SwingConstants.CENTER);
		img.setVerticalAlignment(SwingConstants.CENTER);
		img.setBounds(550, 65, 200, 180);
//        img.setIcon(new ImageIcon(MatHangGUI.class.getResource("/images/bau.jpg")));
		add(img);

		btnadd = new JLabel();
		btnadd.setIcon(new ImageIcon("./src/IMG/btnAdd_150px.png"));
		btnadd.setBounds(800, 65, 200, 50);
		btnadd.setCursor(new Cursor(Cursor.HAND_CURSOR));
		dl = new dladdMatHangGUI();
		btnadd.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                dl.setVisible(true);
                int i= getmamathang();
                i++;
                String number=String.valueOf(i);
                String Mamh="00"+number;
                dl.tfmamh.setText(Mamh);
            }
         
        });
		btnedit = new JLabel();
		btnedit.setIcon(new ImageIcon("./src/IMG/btnEdit_150px.png"));
		btnedit.setBounds(800, 115, 200, 50);
		btnedit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		dl2 = new dleditMatHangGUI();
		btnedit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dl2.setVisible(true);
			}

		});
		btndelete = new JLabel();
		btndelete.setIcon(new ImageIcon("./src/IMG/btnDelete_150px.png"));
		btndelete.setBounds(800, 165, 200, 50);
		btndelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btndelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				MatHangDTO mh = new MatHangDTO();
				mh.setMaMh(textfields[0].getText());
				int i = JOptionPane.showConfirmDialog(null, "Xác nhận xóa", "Alert", JOptionPane.YES_NO_OPTION);
				if (i == 0) {
					mathangBUS.delete(mh);
					loadData();
					cleanView();
				}
			}

		});
//        btnchonanh= new JLabel();
//        btnchonanh.setIcon(new ImageIcon(MatHangGUI.class.getResource("/images/btnFile.png")));
//        btnchonanh.setBounds(800,215,200,50);
//        btnchonanh.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        add(btnchonanh);
		add(btnadd);
		add(btnedit);
		add(btndelete);
		// add(btnchonanh);

		filter = new JPanel();
		filter.setLayout(null);
		filter.setBounds(0, 310, 1300 - 220, 50);
		add(filter);

		lbmasp = new JLabel("Mã MH");
		lbmasp.setBounds(150, 15, 60, 25);
		lbmasp.setFont(new Font("Serif", 0, 15));
		tfmasp = new JTextField();
		tfmasp.setBounds(210, 15, 100, 25);
		tfmasp.addKeyListener((KeyListener) this);
		lbloaisp = new JLabel("Mã Loại");
		lbloaisp.setBounds(320, 15, 60, 25);
		lbloaisp.setFont(new Font("Serif", 0, 15));
		cmbloaihang = new JComboBox();
		cmbloaihang.setBounds(380, 15, 100, 25);
		addCombo();
		lbgiafrom = new JLabel("Giá từ");
		lbgiafrom.setFont(new Font("Serif", 0, 15));
		lbgiafrom.setBounds(490, 15, 60, 25);
		tfgiafrom = new JTextField();
		tfgiafrom.setBounds(550, 15, 100, 25);
		lbgiato = new JLabel("-");
		lbgiato.setBounds(660, 15, 20, 25);
		lbgiato.setFont(new Font("Serif", 0, 15));
		tfgiato = new JTextField();
		tfgiato.setBounds(680, 15, 100, 25);

		filter.add(lbmasp);
		filter.add(tfmasp);
		filter.add(lbloaisp);
		filter.add(cmbloaihang);
		filter.add(lbgiafrom);
		filter.add(tfgiafrom);
		filter.add(lbgiato);
		filter.add(tfgiato);

		btnsearch = new JLabel();
		btnsearch.setBounds(790, 0, 40, 40);
		btnsearch.setIcon(new ImageIcon("./src/IMG/btnSearch_40px.png"));
		btnsearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnsearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				search();
			}

		});
		filter.add(btnsearch);

		mathangBUS = new MatHangBUS();
		String mean[][] = null;
		tb1 = new DefaultTableModel(mean, title1);

		String meanfull[][] = null;

		tbfull = new DefaultTableModel(meanfull, titlefull);
		dsfull = new JTable(tbfull);

		ds = new JTable(tb1);
		ds.setFont(new Font("Serif", 0, 15));
		ds.getTableHeader().setForeground(Color.white);
		ds.getTableHeader().setBackground(new Color(52, 152, 219));
		ds.getTableHeader().setFont(new Font("erif", Font.BOLD, 15));
		ds.getTableHeader().setPreferredSize(new Dimension(700, 30));
		ds.setRowHeight(25);
		ds.getColumnModel().getColumn(0).setPreferredWidth(10);
		ds.getColumnModel().getColumn(1).setPreferredWidth(200);
		ds.getColumnModel().getColumn(2).setPreferredWidth(100);
		ds.getColumnModel().getColumn(3).setPreferredWidth(10);
		ds.getColumnModel().getColumn(4).setPreferredWidth(10);
		ds.getColumnModel().getColumn(5).setPreferredWidth(100);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		ds.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		ds.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		ds.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		ds.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		ds.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		ds.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		ds.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int i = ds.getSelectedRow();

				textfields[0].setText(ds.getModel().getValueAt(i, 0).toString());
				textfields[1].setText(ds.getModel().getValueAt(i, 1).toString());
				textfields[2].setText(ds.getModel().getValueAt(i, 2).toString());
				textfields[3].setText(ds.getModel().getValueAt(i, 3).toString());
				textfields[4].setText(ds.getModel().getValueAt(i, 4).toString());
				textfields[5].setText(ds.getModel().getValueAt(i, 5).toString());

				HinhAnh = textfields[0].getText();
				ImageIcon newImage;
				Image image;
				try {
					newImage = new ImageIcon("./src/IMG_SANPHAM/" + mathangBUS.getAnh(HinhAnh));
					image = (newImage).getImage().getScaledInstance(215, 180, Image.SCALE_SMOOTH);

				} catch (NullPointerException E) {
					newImage = new ImageIcon("./src/IMG_SANPHAM/thitboloai1.jpg");
					image = (newImage).getImage().getScaledInstance(215, 180, Image.SCALE_SMOOTH);
				}
				newImage = new ImageIcon(image);
				img.setIcon(newImage);

//				dl2.tfmamh.setText(dsfull.getModel().getValueAt(i, 0).toString());
//				dl2.tften.setText(dsfull.getModel().getValueAt(i, 1).toString());
//				dl2.tfgiamua.setText(dsfull.getModel().getValueAt(i, 2).toString());
//				dl2.tfgiaban.setText(dsfull.getModel().getValueAt(i, 3).toString());
//				String ngaysanxuat = dsfull.getModel().getValueAt(i, 4).toString();
//				String ngayhansudung = dsfull.getModel().getValueAt(i, 5).toString();
//				String ngaynhap = dsfull.getModel().getValueAt(i, 8).toString();
//				java.util.Date ngaySX = new Date();
//				java.util.Date ngayHSD = new Date();
//				java.util.Date ngayNhap = new Date();
//				try {
//					ngaySX = new SimpleDateFormat("dd/MM/yyyy").parse(ngaysanxuat);
//					ngayHSD = new SimpleDateFormat("dd/MM/yyyy").parse(ngayhansudung);
//					ngayNhap = new SimpleDateFormat("dd/MM/yyyy").parse(ngaynhap);
//					// ngayKT = new SimpleDateFormat("dd/MM/yyyy").parse(end);
//				} catch (Exception ex) {
//
//				}
//				dl2.datengaysanxuat.setDate(ngaySX);
//				dl2.datehansudung.setDate(ngayHSD);
//				dl2.tfslnhap.setText(dsfull.getModel().getValueAt(i, 6).toString());
//				dl2.tfslban.setText(dsfull.getModel().getValueAt(i, 7).toString());
//				dl2.datengaynhap.setDate(ngayNhap);
//				dl2.tfvat.setText(dsfull.getModel().getValueAt(i, 9).toString());
//				String temp = dsfull.getModel().getValueAt(i, 10).toString();
//				String tenlh = LoaiHangBUS.getIntance().laytentheomaloaihang(temp);
//				String temp2 = dsfull.getModel().getValueAt(i, 11).toString();
//				String tendv = DonViBUS.getIntance().laytentheomadonvitinh(temp2);
//				dl2.cmbloaihang.setSelectedItem(tenlh);
//				dl2.cmbdvt.setSelectedItem(tendv);
				String mamh = ds.getModel().getValueAt(i, 0).toString();
				MatHangDTO mh = new MatHangDTO();
				mh.setMaMh(mamh);
				mh = mathangBUS.getById(mh);
				dl2.tfmamh.setText(mh.getMaMh());
				dl2.tften.setText(mh.getTenMh());
				dl2.tfgiamua.setText(mh.getGiaMua() + "");
				dl2.tfgiaban.setText(mh.getGiaBan() + "");
				String ngaysanxuat = mh.getNgaySX().toString();
				String ngayhansudung = mh.getHsd().toString();
				java.util.Date ngaySX = new Date();
				java.util.Date ngayHSD = new Date();
				try {
					ngaySX = new SimpleDateFormat("dd/MM/yyyy").parse(ngaysanxuat);
					ngayHSD = new SimpleDateFormat("dd/MM/yyyy").parse(ngayhansudung);
					// ngayKT = new SimpleDateFormat("dd/MM/yyyy").parse(end);
				} catch (Exception ex) {

				}
				dl2.datengaysanxuat.setDate(ngaySX);
				dl2.datehansudung.setDate(ngayHSD);
				dl2.tfslnhap.setText(mh.getSlNhap() + "");
				dl2.tfvat.setText(mh.getVat() + "");
				String temp = mh.getMaLH();
				String tenlh = LoaiHangBUS.getIntance().laytentheomaloaihang(temp);
				String temp2 = mh.getMaDVT();
				String tendv = DonViBUS.getIntance().laytentheomadonvitinh(temp2);
				dl2.cmbloaihang.setSelectedItem(tenlh);
				dl2.cmbdvt.setSelectedItem(tendv);

			}
		});

		jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane1.setBounds(80, 380, 900, 250);
		jScrollPane1.setViewportView(ds);

		add(jScrollPane1);
		getDSsp();
//
//		getDSSPFull();

		btnnhapfile = new JLabel();
		btnnhapfile.setBounds(800, 215, 151, 44);
		btnnhapfile.setIcon(new ImageIcon("./src/IMG/btnNhapExcel.png"));
		btnnhapfile.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnnhapfile);
		btnnhapfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFileChooser fc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel", "xlsx");
				fc.setFileFilter(filter);
				int result = fc.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile(); // Lấy URL
					mathangBUS.nhapExcel(file);
					tb1.setRowCount(0);
					for (int i = 0; i < mathangBUS.getList().size(); i++) {
						Vector vec = new Vector();
						LoaiHangDTO lh = new LoaiHangDTO();
						lh.setMaLH(mathangBUS.getList().get(i).getMaLH());
						DonViDTO dv = new DonViDTO();
						dv.setMaDVT(mathangBUS.getList().get(i).getMaDVT());
						vec.add(mathangBUS.getList().get(i).getMaMh());
						vec.add(mathangBUS.getList().get(i).getTenMh());
						vec.add(LoaiHangBUS.getIntance().getLoaiHangByID(lh).getTenLH());
						vec.add(mathangBUS.getList().get(i).getSlNhap() - mathangBUS.getList().get(i).getSlBan());
						vec.add(DonViBUS.getIntance().getDonViByID(dv).getTenDVT());
						vec.add(mathangBUS.getList().get(i).getGiaBan());
						tb1.addRow(vec);
					}
					JOptionPane.showMessageDialog(null, "Nhap file excel thanh cong");
				}
			}

		});
		btnxuatfile = new JLabel();
		btnxuatfile.setBounds(800, 260, 151, 44);
		btnxuatfile.setIcon(new ImageIcon("./src/IMG/btnXuatExcel.png"));
		btnxuatfile.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnxuatfile);
		btnxuatfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mathangBUS.xuatExcel();
				new ThongBaoDialog("Xuất file thành công", ThongBaoDialog.SUCCESS_DIALOG);
			}

		});

		TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(tb1);
		ds.setRowSorter(rowSorter);

		tftimkiem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtsearch.setIcon(new ImageIcon("./src/IMG/search_25px.png"));
				txtsearch.setBorder(createLineBorder(new Color(52, 152, 219))); // Đổi màu viền
			}

			public void focusLost(FocusEvent e) // Trờ về như cũ
			{
				txtsearch.setIcon(new ImageIcon("./src/IMG/search_25px.png"));
				txtsearch.setBorder(createLineBorder(Color.BLACK)); // Đổi màu viền
			}
		});
		tftimkiem.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = tftimkiem.getText();

				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text + "", 1));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = tftimkiem.getText();

				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text + "", 1));
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods,
																				// choose Tools | Templates.
			}

		});

	}
	public int getmamathang()
	   {
	       int maMatHangmoinhat=0;
	       for(MatHangDTO mh: mathangBUS.getList()) {
				String txtmaMatHang=mh.getMaMh();
				int maHD=Integer.parseInt(txtmaMatHang);
				if(maHD> maMatHangmoinhat) {
					 maMatHangmoinhat=maHD;
				}
			}
	       return  maMatHangmoinhat;
	   }

	public void themphantuvaomang(String s) {
		int l = TTSP.length;
		TTSP = Arrays.copyOf(TTSP, l + 1);
		TTSP[l] = s;
	}

	public void getDSsp() {
//		{"Mã SP","Tên SP","Loại SP","Số lượng","Đơn vị tính","Đơn giá"};
		DefaultTableModel model = (DefaultTableModel) ds.getModel();
		for (int i = 0; i < mathangBUS.getList().size(); i++) {
			themphantuvaomang(mathangBUS.getList().get(i).getMaMh());
			themphantuvaomang(mathangBUS.getList().get(i).getTenMh());
			LoaiHangDTO lh = new LoaiHangDTO();
			lh.setMaLH(mathangBUS.getList().get(i).getMaLH());
			themphantuvaomang(LoaiHangBUS.getIntance().getLoaiHangByID(lh).getTenLH());
			themphantuvaomang((mathangBUS.getList().get(i).getSlNhap() - mathangBUS.getList().get(i).getSlBan()) + "");
			DonViDTO dv = new DonViDTO();
			dv.setMaDVT(mathangBUS.getList().get(i).getMaDVT());
			themphantuvaomang(DonViBUS.getIntance().getDonViByID(dv).getTenDVT());
			themphantuvaomang(dcf.format(mathangBUS.getList().get(i).getGiaBan()));
			model.addRow(TTSP);
			TTSP = new String[0];
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public void mouseExited(MouseEvent e) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	// private LoaiHangBUS loaihangBus= new LoaiHangBUS();
	public void loadData() {
		tb1.setRowCount(0);
		for (int i = 0; i < mathangBUS.getList().size(); i++) {
			Vector vec = new Vector();
			LoaiHangDTO lh = new LoaiHangDTO();
			lh.setMaLH(mathangBUS.getList().get(i).getMaLH());
			DonViDTO dv = new DonViDTO();
			dv.setMaDVT(mathangBUS.getList().get(i).getMaDVT());
			vec.add(mathangBUS.getList().get(i).getMaMh());
			vec.add(mathangBUS.getList().get(i).getTenMh());
			vec.add(LoaiHangBUS.getIntance().getLoaiHangByID(lh).getTenLH());
			vec.add(mathangBUS.getList().get(i).getSlNhap() - mathangBUS.getList().get(i).getSlBan());
			vec.add(DonViBUS.getIntance().getDonViByID(dv).getTenDVT());
			vec.add(mathangBUS.getList().get(i).getGiaBan());
			tb1.addRow(vec);
		}

		// private String[] title1={"Mã SP","Tên SP","Loại SP","Số lượng","Đơn vị
		// tính","Đơn giá"};
	}

	public void cleanView() {
		textfields[0].setText("");
		textfields[1].setText("");
		textfields[2].setText("");
		textfields[3].setText("");
		textfields[4].setText("");
		textfields[5].setText("");
		textfields[0].requestFocusInWindow();
		ds.clearSelection();
	}

	public void addCombo() {
		Vector<String> vec = new Vector();
		vec.add("Chọn loại");
		for (LoaiHangDTO lh : LoaiHangBUS.getIntance().getList()) {
			vec.add(lh.getTenLH());
		}
		DefaultComboBoxModel<String> cbmodel = new DefaultComboBoxModel<>(vec);
		cmbloaihang.setModel(cbmodel);

	}

	public void search() {
		String masp = tfmasp.getText();
		String maloai = "";
		if (cmbloaihang.getSelectedIndex() != 0) {
			String temp = cmbloaihang.getSelectedItem().toString();
			maloai = LoaiHangBUS.getIntance().laymatheotenloaihang(temp);
		}
//        else 
//        {
//           JOptionPane.showMessageDialog(null,"Chưa chọn loại hàng để xóa","ERROR_MESSAGE",1);
//        }
		double max = tfgiato.getText().equals("") ? 9999999 : Double.parseDouble(tfgiato.getText());
		double min = tfgiafrom.getText().equals("") ? 0 : Double.parseDouble(tfgiafrom.getText());

		tb1.setRowCount(0);
		for (MatHangDTO mh : mathangBUS.searchSP(masp, maloai, max, min)) {
			Vector vec = new Vector();
			vec.add(mh.getMaMh());
			vec.add(mh.getTenMh());
			vec.add(mh.getMaLH());
			vec.add(mh.getSlNhap() - mh.getSlBan());
			vec.add(mh.getMaDVT());
			vec.add(mh.getGiaBan());
			tb1.addRow(vec);
		}
	}

	public void themphantuvaomangfull(String s) {
		int l = TTSPFull.length;
		TTSPFull = Arrays.copyOf(TTSPFull, l + 1);
		TTSPFull[l] = s;
	}

//	public void getDSSPFull() {
//		DefaultTableModel model = (DefaultTableModel) dsfull.getModel();
//		dem = mathangBUS.getList().size();
//		for (int i = 0; i < dem; i++) {
//			themphantuvaomangfull(mathangBUS.getList().get(i).getMaMh());
//			themphantuvaomangfull(mathangBUS.getList().get(i).getTenMh());
//			themphantuvaomangfull(dcf.format(mathangBUS.getList().get(i).getGiaMua()));
//			themphantuvaomangfull(dcf.format(mathangBUS.getList().get(i).getGiaBan()));
//			themphantuvaomangfull(formatter.format(mathangBUS.getList().get(i).getDatengsx()));
//			themphantuvaomangfull(formatter.format(mathangBUS.getList().get(i).getDatehsd()));
//			themphantuvaomangfull(dcf.format(mathangBUS.getList().get(i).getSlNhap()));
//			themphantuvaomangfull(dcf.format(mathangBUS.getList().get(i).getSlBan()));
//			themphantuvaomangfull(formatter.format(mathangBUS.getList().get(i).getDatengaynhap()));
//			themphantuvaomangfull(dcf.format(mathangBUS.getList().get(i).getVat()));
//			themphantuvaomangfull(mathangBUS.getList().get(i).getMaLH());
//			themphantuvaomangfull(mathangBUS.getList().get(i).getMaDVT());
//			themphantuvaomangfull(mathangBUS.getList().get(i).getImg());
//			model.addRow(TTSPFull);
//			TTSPFull = new String[0];
//		}
//
//	}

	@Override
	public void keyTyped(KeyEvent e) {
		// To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Object a = e.getSource();
		if (a.equals(tfmasp) || a.equals(tfgiato) || a.equals(tfgiafrom) || a.equals(cmbloaihang)) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				search();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// To change body of generated methods, choose Tools | Templates.
	}

//	public void saveimg() {
//		try {
//
//			if (i != null) {
//				File save = new File("/images/" + dl2.temp1);
//				ImageIO.write(i, "jpg", save);
//				i = null;
//			}
//		} catch (IOException ex) {
//			Logger.getLogger(MatHangGUI.class.getName()).log(Level.SEVERE, null, ex);
//		}
//	}

}
