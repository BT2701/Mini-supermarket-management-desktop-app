package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.text.NumberFormatter;

public class ChiTietSanPhamGUI extends JPanel{
	private JLabel lbTittle,lbMaSp,lbTenSp,lbDonGia,lbSoluong,lbNv;
	public static JLabel lbImage;
//	private JComboBox<String>cbLoaisp;
//	private String []loaiSP;
	public static JTextField tfMasp,tfTensp,tfDongia,tfNv;
	public static JSpinner spnSoluong;
	private JButton btnThemCart;
//	private JFormattedTextField txtSpinner = ((JSpinner.NumberEditor) spnSoluong.getEditor()).getTextField();
	private Font fontTittle = new Font("Tahoma", Font.BOLD, 20);
	private Font fontItems = new Font("Tahoma",0, 15);
	private Border lineBorder = BorderFactory.createLineBorder(Color.gray, 1);
	private Color oldColor=new Color(52, 152, 219);
	private Color hoverColor=new Color(41, 128, 185);
	private Color backgroundcolor=new Color(255, 204, 204);
	private Color texfieldColor=new Color(45, 52, 54);
	private SpinnerNumberModel spnmodel = new SpinnerNumberModel(0, 0, 100, 1);
	public ChiTietSanPhamGUI() {
		initComponent();
	}
	public void initComponent() {
		this.setLayout(null);
		this.setBounds(700, 30, 400, 660);
//		this.setBackground(backgroundcolor);
		lbTittle=new JLabel("Chi tiết sản phẩm",JLabel.CENTER);
		lbTittle.setBounds(0, 70, 400, 50);
		lbTittle.setFont(fontTittle);
		
		lbImage=new JLabel(new ImageIcon("./src/IMG/ami-bung-bu.png"));
		lbImage.setBounds(125, 130, 150, 150);
		lbImage.setBorder(lineBorder);
		
//		lbLoaiSp=new JLabel("Loại SP");
//		lbLoaiSp.setBounds(10, 290, 100, 30);
//		lbLoaiSp.setFont(fontItems);
		
		lbMaSp=new JLabel("Mã SP");
		lbMaSp.setBounds(10, 290, 100, 30);
		lbMaSp.setFont(fontItems);
		
		lbTenSp=new JLabel("Tên SP");
		lbTenSp.setBounds(10, 330, 100, 30);
		lbTenSp.setFont(fontItems);
		
		lbDonGia=new JLabel("Đơn giá");
		lbDonGia.setBounds(10, 370, 100, 30);
		lbDonGia.setFont(fontItems);
		
		lbSoluong=new JLabel("Số lượng");
		lbSoluong.setBounds(10, 410, 100, 30);
		lbSoluong.setFont(fontItems);
		
		lbNv=new JLabel("Nhân viên",JLabel.CENTER);
		lbNv.setBounds(0, 500, 400, 30);
		lbNv.setFont(fontItems);
		
		btnThemCart=new JButton("Thêm vào giỏ");
		btnThemCart.setBounds(120, 570, 160, 30);
		btnThemCart.setFont(fontItems);
		btnThemCart.setBackground(oldColor);
		btnThemCart.setEnabled(false);
		
//		btnDelCart=new JButton("Xóa");
//		btnDelCart.setBounds(120, 560, 160, 30);
//		btnDelCart.setFont(fontItems);
//		btnDelCart.setBackground(oldColor);
//		btnDelCart.setEnabled(false);
//		
//		btnXuatHD=new JButton("Xuất hóa đơn");
//		btnXuatHD.setBounds(120, 600, 160, 30);
//		btnXuatHD.setFont(fontItems);
//		btnXuatHD.setBackground(oldColor);
//		btnXuatHD.setEnabled(false);
		
		//gán tạm giá trị cho jcombobox
//		String []loaiSP= {"Chọn loại","item1","item2","item3"};
//		cbLoaisp=new JComboBox<String>(loaiSP);
//		cbLoaisp.setBounds(120, 290, 250, 30);
//		cbLoaisp.setFont(fontItems);
		
		tfMasp=new JTextField(JTextField.CENTER);
		tfMasp.setBounds(120, 290, 250, 30);
		tfMasp.setFont(fontItems);
		tfMasp.setBorder(lineBorder);
		tfMasp.setHorizontalAlignment(JTextField.CENTER);
		tfMasp.setDisabledTextColor(texfieldColor);
		tfMasp.setEnabled(false);
		
		tfTensp=new JTextField(JTextField.CENTER);
		tfTensp.setBounds(120, 330, 250, 30);
		tfTensp.setFont(fontItems);
		tfTensp.setBorder(lineBorder);
		tfTensp.setHorizontalAlignment(JTextField.CENTER);
		tfTensp.setDisabledTextColor(texfieldColor);
		tfTensp.setEnabled(false);
		
		tfDongia=new JTextField(JTextField.CENTER);
		tfDongia.setBounds(120, 370, 250, 30);
		tfDongia.setFont(fontItems);
		tfDongia.setBorder(lineBorder);
		tfDongia.setHorizontalAlignment(JTextField.CENTER);
//		tfDongia.setBackground(UIManager.getColor("TextField.disabledBackground"));
		tfDongia.setDisabledTextColor(texfieldColor);
		tfDongia.setEnabled(false);
		
		spnSoluong=new JSpinner(spnmodel);
		spnSoluong.setBounds(120, 410, 250, 30);
		spnSoluong.setFont(fontItems);
		spnSoluong.setEnabled(true);
		
		JFormattedTextField txtSpinner = ((JSpinner.NumberEditor) spnSoluong.getEditor()).getTextField();
        ((NumberFormatter) txtSpinner.getFormatter()).setAllowsInvalid(true);
        txtSpinner.setEditable(true);
        txtSpinner.setHorizontalAlignment(JTextField.LEFT);
		
		tfNv=new JTextField();
		tfNv.setBounds(75, 530, 250, 30);
		tfNv.setFont(fontItems);
		tfNv.setBorder(lineBorder);
		tfNv.setHorizontalAlignment(JTextField.CENTER);
		tfNv.setDisabledTextColor(texfieldColor);
		tfNv.setEnabled(false);
		
		this.add(lbTittle);
//		this.add(lbLoaiSp);
		this.add(lbMaSp);
		this.add(lbTenSp);
		this.add(lbDonGia);
		this.add(lbSoluong);
		this.add(lbNv);
		this.add(btnThemCart);
//		this.add(btnDelCart);
//		this.add(btnXuatHD);
//		this.add(cbLoaisp);
		this.add(tfMasp);
		this.add(tfTensp);
		this.add(tfDongia);
		this.add(spnSoluong);
		this.add(tfNv);
		this.add(lbImage);
		
//		this.setBackground(Color.green);
	}
	
	public JButton getBtnThemCart() {
		return btnThemCart;
	}
	public void setBtnThemCart(JButton btnThemCart) {
		this.btnThemCart = btnThemCart;
	}
//	public JButton getBtnXuatHD() {
//		return btnXuatHD;
//	}
//	public void setBtnXuatHD(JButton btnXuatHD) {
//		this.btnXuatHD = btnXuatHD;
//	}
//	public JButton getBtnDelCart() {
//		return btnDelCart;
//	}
//	public void setBtnDelCart(JButton btnDelCart) {
//		this.btnDelCart = btnDelCart;
//	}
	
}
