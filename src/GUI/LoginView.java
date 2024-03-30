/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

//import controller.LoginListener;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import BUS.NhanVienBUS;
import BUS.TaiKhoanBUS;
import DTO.DTO_TaiKhoan;

/**
 *
 * @author phamn
 */
public class LoginView extends JFrame {

    private JPanel jPanel_icon, jPanel_login;
    private ImageIcon icon_cart, icon_account, icon_lock;
    public JLabel jLabel_icon, jLabel_login, jLabel_account, jLabel_pass, jLabel_forgotPass, jLabel_rememberPass;
    private JPasswordField tfPass;
    private JTextField tfTenDN;
    private JCheckBox jCB_rememberPass;
    private Border lineBorder_login;
    public JButton jButton_close, jButton_hidden;
    public JButton jButton_login;
    //sự kiện
    ActionListener ac = new LoginListener(this);

    //sự kiện chuột
    MouseListener mouse = new LoginListener(this);

    public LoginView() {
        this.init();
        tfTenDN.requestFocus();
    }

    private void init() {
        this.setSize(630, 320);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// chương trình xuất hiện ngay trung tâm màn hình
        Image icon_store = Toolkit.getDefaultToolkit().createImage("./src/IMG/icon_store.png");
		this.setIconImage(icon_store);

        //Line
        lineBorder_login = BorderFactory.createLineBorder(Color.WHITE, 1);

        //Font
        Font font_login = new Font("Times New Roman", Font.BOLD, 30);
        Font font_fP = new Font("Times New Roman", Font.ITALIC, 14);
        Font font_button_login = new Font("Arials", Font.BOLD, 20);

        //Image, icon
        icon_cart = new ImageIcon("./src/IMG/Cart.png");
        icon_account = new ImageIcon("./src/IMG/Account.png");
        icon_lock = new ImageIcon("./src/IMG/Lock.png");

        //--jPanel_icon
        jLabel_icon = new JLabel(icon_cart);
        jLabel_icon.setBounds(127, 127, 50, 50);
        
        jPanel_icon = new JPanel();
        jPanel_icon.setLayout(null);
        jPanel_icon.setBackground(new Color(0x29B6F6));
        jPanel_icon.setBounds(0, 0, 300, 320);

        //jPanel_icon add...
        jPanel_icon.add(jLabel_icon);

        //
        //--jPanel_login
        // tiêu đề
        jLabel_login = new JLabel("Đăng nhập"); // tiêu đề
        jLabel_login.setBounds(90, 15, 160, 50);
        jLabel_login.setFont(font_login);

        //Text + label nhập account
        tfTenDN = new JTextField(JTextField.CENTER);
        tfTenDN.setText("admin");
        tfTenDN.setBounds(80, 80, 180, 35);

        jLabel_account = new JLabel(icon_account);
        jLabel_account.setBounds(40, 80, 35, 35);

        // Text + label nhập pass
        tfPass = new JPasswordField();
        tfPass.setEchoChar('*');
        tfPass.setBounds(80, 140, 180, 35);
        tfPass.setText("123456");

        jLabel_pass = new JLabel(icon_lock);
        jLabel_pass.setBounds(37, 140, 35, 35);

        //Checkbox "Ghi nhớ đăng nhập"
        jCB_rememberPass = new JCheckBox();
        jCB_rememberPass.setBounds(80, 180, 20, 20);
        jLabel_rememberPass = new JLabel("Remember me");
        jLabel_rememberPass.setBounds(102, 180, 120, 18);
        jLabel_rememberPass.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //Nút "Đăng nhập" 
        jButton_login = new JButton("Login");
        jButton_login.setBounds(50, 220, 220, 40);
        jButton_login.setBackground(new Color(0x29B6F6));
        jButton_login.setFont(font_button_login);
        jButton_login.setBorder(lineBorder_login);
        jButton_login.addMouseListener(mouse); //sự kiện chuột
        jButton_login.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //Quên mật khẩu
        jLabel_forgotPass = new JLabel("Quên mật khẩu ?");
        jLabel_forgotPass.setBounds(200, 280, 120, 18);
        jLabel_forgotPass.setFont(font_fP);
        jLabel_forgotPass.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabel_forgotPass.addMouseListener(mouse); //sự kiện chuột

        //Hidden
        jButton_hidden = new JButton("-");
        jButton_hidden.setBounds(262, 0, 35, 35);
        jButton_hidden.setBackground(Color.WHITE);
        jButton_hidden.setBorder(lineBorder_login);
        jButton_hidden.setFont(font_button_login);
        jButton_hidden.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        jButton_hidden.addActionListener(ac); //sự kiện
        jButton_hidden.addMouseListener(mouse); //sự kiện chuột
        
        //Close
        jButton_close = new JButton("X");
        jButton_close.setBounds(295, 0, 35, 35);
        jButton_close.setBackground(Color.WHITE);
        jButton_close.setBorder(lineBorder_login);
        jButton_close.setFont(font_button_login);
        jButton_close.setCursor(new Cursor(Cursor.HAND_CURSOR));
        

        jButton_close.addActionListener(ac); //sự kiện
        jButton_close.addMouseListener(mouse); //sự kiện chuột

        jPanel_login = new JPanel(); //Đăng nhập
        jPanel_login.setLayout(null);
        jPanel_login.setBackground(Color.WHITE);
        jPanel_login.setBounds(300, 0, 330, 320);
        jPanel_login.add(jLabel_login);
        jPanel_login.add(tfPass);
        jPanel_login.add(tfTenDN);
        jPanel_login.add(jLabel_account);
        jPanel_login.add(jLabel_pass);
        jPanel_login.add(jCB_rememberPass);
        jPanel_login.add(jLabel_rememberPass);
        jPanel_login.add(jLabel_forgotPass);
        jPanel_login.add(jButton_login);
        jPanel_login.add(jButton_close);
        jPanel_login.add(jButton_hidden);

        this.setLayout(null);// set Layout cho JF
        this.setUndecorated(true);
        this.setVisible(true);

        //this add...
        this.add(jPanel_icon);
        this.add(jPanel_login);

    }

    //Phương thức
    public void click_close() {
        System.exit(0);
    }
    
    public void click_hidden() {
        this.setState(ICONIFIED);
    }

    //sự kiện di chuột vào nút close
    public void mouseEntered_button_close() {
        jButton_close.setBackground(Color.red);
        jButton_close.setForeground(Color.white);
    }

    public void mouseExited_button_close() {
        jButton_close.setBackground(Color.white);
        jButton_close.setForeground(Color.black);
    }
    
    //sự kiện di chuột vào nút hidden
    public void mouseEntered_button_hidden() {
        jButton_hidden.setBackground(Color.red);
        jButton_hidden.setForeground(Color.white);
    }

    public void mouseExited_button_hidden() {
        jButton_hidden.setBackground(Color.white);
        jButton_hidden.setForeground(Color.black);
    }

    //sự kiện di chuột vào "quên mật khẩu"
    public void mouseEntered_forgotPass() {
        jLabel_forgotPass.setForeground(new Color(0x29B6F6));
    }

    public void mouseExited_forgotPass() {
        jLabel_forgotPass.setForeground(Color.black);
    }

    //sự kiện di chuột vào nút Login
    public void mouseEntered_login() {
        jButton_login.setBackground(new Color(0x74b9ff));
        jButton_login.setForeground(Color.white);

    }

    public void mouseExited_login() {
        jButton_login.setBackground(new Color(0x29B6F6));
        jButton_login.setForeground(Color.black);
    }
    public void xuLySuKienDangNhap() {
    	String tenDN=tfTenDN.getText();
    	String matKhau=new String(tfPass.getPassword());
    	DTO_TaiKhoan taiKhoan=TaiKhoanBUS.getInstance().layTaiKhoan(tenDN, matKhau);
    	if(taiKhoan==null) {
    		new ThongBaoDialog("Tài khoản không tồn tại", ThongBaoDialog.ERROR_DIALOG);
    		return;
    	}
    	else {
    		if(taiKhoan.getTrangThai()==0) {
    			new ThongBaoDialog("Tài khoản đã bị vô hiệu hóa", ThongBaoDialog.ERROR_DIALOG);
    			return;
    		}
    		new ThongBaoDialog("Đăng nhập thành công", ThongBaoDialog.SUCCESS_DIALOG);
    		dispose();
    		String maNV=taiKhoan.getMaNV();
        	String tenNV=NhanVienBUS.getIntance().layTenNVtheoMA(maNV);
        	String quyen=taiKhoan.getQuyen();
        	String urlImage=taiKhoan.getHinhAnh();
    		QuanLyView ql=new QuanLyView();
    		ql.getjLabel_ima_profile().setIcon(new ImageIcon(urlImage));
    		ql.getjLabel_user().setText(tenNV);
    		ChiTietSanPhamGUI.tfNv.setText(maNV+" - "+tenNV);
    		NhapHangGUI.jTextField_nv.setText(maNV+" - "+tenNV);
    		ql.xuLyPhanQuyen(quyen);
    	}
    }
}
