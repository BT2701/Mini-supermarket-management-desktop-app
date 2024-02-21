package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import BUS.NhanVienBUS;
import BUS.PhanQuyenBUS;
import BUS.TaiKhoanBUS;
import DTO.DTO_TaiKhoan;

public class DialogTaoTaiKhoanGUI extends JDialog {
	private JLabel lbtittle, lbthem, lbxoa, lbsua, lbmanv, lbtenDN, lbmatKhau, lbquyen, lbtrangthai;
	private JCheckBox chbtrangThai;
	private JComboBox<String> cbquyen, cbmanv;
	private Font font = new Font("Tahoma", Font.BOLD, 25);
	private Font fontItems = new Font("Tahoma", 0, 15);
	private Color btnoldColor = new Color(52, 152, 219);
	private Color btnhoverColor = new Color(116, 185, 255);
	private JTextField tftenDN, tfMakhau;

	public DialogTaoTaiKhoanGUI() {
		initComponent();
	}

	public void initComponent() {
		this.setSize(600, 370);
		this.setLayout(null);
		this.setModal(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.white);

		lbtittle = new JLabel("Tài khoản", JLabel.CENTER);
		lbtittle.setBounds(0, 10, 600, 50);
		lbtittle.setFont(font);

		lbmanv = new JLabel("Mã nhân viên");
		lbmanv.setBounds(135, 70, 120, 30);
		lbmanv.setFont(fontItems);

		cbmanv = new JComboBox<String>();
		getDsMaNV();
		cbmanv.setBounds(265, 70, 200, 30);
		cbmanv.setFont(fontItems);
		cbmanv.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(cbmanv.getSelectedIndex()==0) {
					clearView();
				}
				else {
					String manv=cbmanv.getSelectedItem().toString();
					DTO_TaiKhoan taiKhoan=new DTO_TaiKhoan();
					taiKhoan.setMaNV(manv);
					taiKhoan=TaiKhoanBUS.getInstance().getByID(taiKhoan);
					tftenDN.setEnabled(true);
					tfMakhau.setEnabled(true);
					cbquyen.setEnabled(true);
					chbtrangThai.setEnabled(true);
					if(taiKhoan==null) {
						new ThongBaoDialog("Nhân viên chưa có tài khoản", ThongBaoDialog.WARNING_DIALOG);
						tftenDN.setText(manv);
						tfMakhau.setText("");
						chbtrangThai.setSelected(false);
						getDSquyen();
					}
					else {
						tftenDN.setText(taiKhoan.getTenDN());
						
						tfMakhau.setText(taiKhoan.getMatKhau());
						if(taiKhoan.getTrangThai()==1)
							chbtrangThai.setSelected(true);
						else
							chbtrangThai.setSelected(false);
					}
				}
				
			}
		});

		lbtenDN = new JLabel("Tên đăng nhập");
		lbtenDN.setBounds(135, 110, 120, 30);
		lbtenDN.setFont(fontItems);

		tftenDN = new JTextField();
		tftenDN.setBounds(265, 110, 200, 30);
		tftenDN.setFont(fontItems);

		lbmatKhau = new JLabel("Mật khẩu");
		lbmatKhau.setBounds(135, 150, 120, 30);
		lbmatKhau.setFont(fontItems);

		tfMakhau = new JTextField();
		tfMakhau.setBounds(265, 150, 200, 30);
		tfMakhau.setFont(fontItems);

		lbquyen = new JLabel("Chọn quyền");
		lbquyen.setBounds(135, 190, 120, 30);
		lbquyen.setFont(fontItems);

		cbquyen = new JComboBox<String>();
		getDSquyen();
		cbquyen.setBounds(265, 190, 200, 30);
		cbquyen.setFont(fontItems);

		lbtrangthai = new JLabel("Trạng thái");
		lbtrangthai.setBounds(135, 230, 120, 30);
		lbtrangthai.setFont(fontItems);

		chbtrangThai = new JCheckBox();
		chbtrangThai.setBounds(265, 230, 30, 30);

		lbthem = new JLabel(new ImageIcon("./src/IMG/btnAdd_150px.png"));
		lbthem.setBounds(55, 270, 150, 50);
		lbthem.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				xuLyThemTaiKhoan();
			}
		});

		lbsua = new JLabel(new ImageIcon("./src/IMG/btnEdit_150px.png"));
		lbsua.setBounds(225, 270, 150, 50);
		lbsua.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				xuLySuaTaiKhoan();
			}
		});

		lbxoa = new JLabel(new ImageIcon("./src/IMG/btnDelete_150px.png"));
		lbxoa.setBounds(395, 270, 150, 50);
		lbxoa.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				xuLyXoaTaiKhoan();
			}
		});
		
		tfMakhau.setEnabled(false);
		tftenDN.setEnabled(false);
		cbquyen.setEnabled(false);
		chbtrangThai.setEnabled(false);

		this.add(lbmanv);
		this.add(lbmatKhau);
		this.add(lbtenDN);
		this.add(lbquyen);
		this.add(lbsua);
		this.add(lbthem);
		this.add(lbtrangthai);
		this.add(lbxoa);
		this.add(tfMakhau);
		this.add(tftenDN);
		this.add(cbmanv);
		this.add(cbquyen);
		this.add(chbtrangThai);
		this.add(lbtittle);
		this.setVisible(true);
	}

	public void getDsMaNV() { // đưa ds manv vào combobox
		Vector<String> vec = new Vector<>();
		vec.add("Chọn mã");
		for (String maNV : NhanVienBUS.getIntance().getDsMaNV()) {
			vec.add(maNV);
		}
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(vec);
		cbmanv.setModel(model);
	}
	public void getDSquyen() {
		Vector<String> vec = new Vector<>();
		vec.add("Chọn quyền");
		for (String quyen : PhanQuyenBUS.getInstance().layDanhSachQuyen()) {
			vec.add(quyen);
		}
		DefaultComboBoxModel<String> cbmodel = new DefaultComboBoxModel<>(vec);
		cbquyen.setModel(cbmodel);
	}
	public void clearView() {
		tfMakhau.setText("");
		tftenDN.setText("");
		getDSquyen();
		chbtrangThai.setSelected(false);
		
		tfMakhau.setEnabled(false);
		tftenDN.setEnabled(false);
		cbquyen.setEnabled(false);
		chbtrangThai.setEnabled(false);
	}
	public void xuLyThemTaiKhoan() {
		String manv=cbmanv.getSelectedItem().toString();
		String tendn=tftenDN.getText().toString();
		if(tendn=="") {
			new ThongBaoDialog("Mời nhập tài khoản mới", ThongBaoDialog.WARNING_DIALOG);
			return;
		}
		for (DTO_TaiKhoan taiKhoan : TaiKhoanBUS.getInstance().getList()) {
			if(taiKhoan.getMaNV().equalsIgnoreCase(manv)) {
				new ThongBaoDialog("Nhân viên này đã có tài khoản", ThongBaoDialog.ERROR_DIALOG);
				return;
			}
			else {
				if(taiKhoan.getTenDN().equalsIgnoreCase(tendn)) {
					new ThongBaoDialog("Tên đăng nhập đã tồn tại", ThongBaoDialog.ERROR_DIALOG);
					tftenDN.setText("");
					return;
				}
			}
		}
		String matkhau=tfMakhau.getText().toString();
		String quyen=cbquyen.getSelectedItem().toString();
		int trangThai=0;
		if(chbtrangThai.isSelected())
			trangThai=1;
		DTO_TaiKhoan taiKhoan=new DTO_TaiKhoan(manv, tendn, matkhau, quyen, trangThai, "./src/IMG/quanLy1.png");
		TaiKhoanBUS.getInstance().inSert(taiKhoan);
		new ThongBaoDialog("Thêm tài khoản thành công", ThongBaoDialog.SUCCESS_DIALOG);
		clearView();
	}
	public void xuLyXoaTaiKhoan() {
		if(tftenDN.getText()=="") {
			new ThongBaoDialog("Không có tài khoản để xóa", ThongBaoDialog.WARNING_DIALOG);
			return;
		}
		String manv=cbmanv.getSelectedItem().toString();
//		DTO_TaiKhoan taikhoan=new DTO_TaiKhoan();
//		taikhoan.setMaNV(manv);
//		TaiKhoanBUS.getInstance().delete(taikhoan);
		TaiKhoanBUS.getInstance().voHieuHoaTaiKhoan(manv);
		
		new ThongBaoDialog("Đã vô hiệu hóa tài khoản", ThongBaoDialog.SUCCESS_DIALOG);
		clearView();
		
	}
	public void xuLySuaTaiKhoan() {
		if(tftenDN.getText()=="") {
			new ThongBaoDialog("Không có tài khoản để sửa", ThongBaoDialog.WARNING_DIALOG);
			return;
		}
		if(cbquyen.getSelectedIndex()==0) {
			new ThongBaoDialog("Chọn quyền", ThongBaoDialog.ERROR_DIALOG);
			return;
		}
		String manv=cbmanv.getSelectedItem().toString(); 
		String tendn=tftenDN.getText();
		String matkhau=tfMakhau.getText().toString();
		String quyen=cbquyen.getSelectedItem().toString();
		int trangThai=0;
		if(chbtrangThai.isSelected())
			trangThai=1;
		DTO_TaiKhoan taiKhoan=new DTO_TaiKhoan(manv, tendn, matkhau, quyen, trangThai, "./src/IMG/quanLy1.png");
		TaiKhoanBUS.getInstance().upDate(taiKhoan);
		new ThongBaoDialog("Sửa tài khoản thành công", ThongBaoDialog.SUCCESS_DIALOG);
		clearView();
		
	}
}
