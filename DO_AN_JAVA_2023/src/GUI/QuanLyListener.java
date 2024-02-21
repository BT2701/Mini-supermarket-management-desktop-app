/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//import view.QuanLyView;

/**
 *
 * @author phamn
 */
public class QuanLyListener implements ActionListener, MouseListener {
	private QuanLyView quanLyView;

	public QuanLyListener(QuanLyView quanLyView) {
		this.quanLyView = quanLyView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if (button.equals("-")) {
			this.quanLyView.click_hidden();
		} else if (button.equals("X")) {
			this.quanLyView.click_close();
		}
		if(e.getSource()==PhanQuyenGUI.cbLisPQ) {
			quanLyView.getPhanQuyen().xuLySuKienCBlistQuyen();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == quanLyView.getMenu_Label()[1]) {
			quanLyView.mousePress_setVisibleCenter_banHang();
		}
		if (e.getSource() == quanLyView.getMenu_Label()[2]) {
			quanLyView.mousePress_setVisibleCenter_MatHang();
		}
		if (e.getSource() == quanLyView.getMenu_Label()[6]) {
			quanLyView.mousePress_setVisibleCenter_NCC();
		}
		if (e.getSource() == quanLyView.getMenu_Label()[8]) {
			quanLyView.mousePress_setVisibleCenter_thongKe();
		}
		if (e.getSource() == quanLyView.getMenu_Label()[3]) {
			quanLyView.mousePress_setVisibleCenter_NhanVien();
		}
		if (e.getSource() == quanLyView.getMenu_Label()[4]) {
			quanLyView.mousePress_setVisibleCenter_KhachHang();
		}
		if (e.getSource() == quanLyView.getMenu_Label()[0]) {
			quanLyView.mousePress_setVisibleCenter_TrangChu();
		}
		if (e.getSource() == quanLyView.getMenu_Label()[7]) {
			quanLyView.mousePress_setVisibleCenter_PhanQuyen();
		}
		if (e.getSource() == quanLyView.getMenu_Label()[5]) {
			quanLyView.mousePress_setVisibleCenter_NhapHang();
		}
		if(e.getSource()==quanLyView.getNhapHang().jLabel_nh) {
			quanLyView.getNhapHang().mousePressed_jLabel_nh();
		}
		if(e.getSource()==quanLyView.getNhapHang().jLabel_qlpn) {
			quanLyView.getNhapHang().mousePressed_jLabel_qlpn();
		}
		
		//thêm xóa sửa
		if(e.getSource()==KhachHangGUI.btnadd) {
			if(KhachHangGUI.btnadd.isEnabled()==false) {
				new ThongBaoDialog("Không được phép", ThongBaoDialog.ERROR_DIALOG);
			}
		}
		if(e.getSource()==MatHangGUI.btnadd) {
			if(KhachHangGUI.btnadd.isEnabled()==false) {
				new ThongBaoDialog("Không được phép", ThongBaoDialog.ERROR_DIALOG);
			}
		}
		if(e.getSource()==NhanVienGUI.btnadd) {
			if(KhachHangGUI.btnadd.isEnabled()==false) {
				new ThongBaoDialog("Không được phép", ThongBaoDialog.ERROR_DIALOG);
			}
		}
		if(e.getSource()==NhaCungCapGUI.btnadd) {
			if(KhachHangGUI.btnadd.isEnabled()==false) {
				new ThongBaoDialog("Không được phép", ThongBaoDialog.ERROR_DIALOG);
			}
		}
		if(e.getSource()==KhachHangGUI.btnedit) {
			if(KhachHangGUI.btnadd.isEnabled()==false) {
				new ThongBaoDialog("Không được phép", ThongBaoDialog.ERROR_DIALOG);
			}
		}
		if(e.getSource()==MatHangGUI.btnedit) {
			if(KhachHangGUI.btnadd.isEnabled()==false) {
				new ThongBaoDialog("Không được phép", ThongBaoDialog.ERROR_DIALOG);
			}
		}
		if(e.getSource()==NhanVienGUI.btnedit) {
			if(KhachHangGUI.btnadd.isEnabled()==false) {
				new ThongBaoDialog("Không được phép", ThongBaoDialog.ERROR_DIALOG);
			}
		}
		if(e.getSource()==NhaCungCapGUI.btnedit) {
			if(KhachHangGUI.btnadd.isEnabled()==false) {
				new ThongBaoDialog("Không được phép", ThongBaoDialog.ERROR_DIALOG);
			}
		}
		if(e.getSource()==KhachHangGUI.btndelete) {
			if(KhachHangGUI.btnadd.isEnabled()==false) {
				new ThongBaoDialog("Không được phép", ThongBaoDialog.ERROR_DIALOG);
			}
		}
		if(e.getSource()==MatHangGUI.btndelete) {
			if(KhachHangGUI.btnadd.isEnabled()==false) {
				new ThongBaoDialog("Không được phép", ThongBaoDialog.ERROR_DIALOG);
			}
		}
		if(e.getSource()==NhanVienGUI.btndelete) {
			if(KhachHangGUI.btnadd.isEnabled()==false) {
				new ThongBaoDialog("Không được phép", ThongBaoDialog.ERROR_DIALOG);
			}
		}
		if(e.getSource()==NhaCungCapGUI.btndelete) {
			if(KhachHangGUI.btnadd.isEnabled()==false) {
				new ThongBaoDialog("Không được phép", ThongBaoDialog.ERROR_DIALOG);
			}
		}
		if (e.getComponent() == this.quanLyView.jButton_logout) {
			quanLyView.xuLyDangXuat();
		}
		for (int i = 0; i < this.quanLyView.menuItem.length; i++) {
			if (e.getComponent() == this.quanLyView.menu_Label[i]) {
				this.quanLyView.mousePresses_menuItems(i);
			}

		}
		if(e.getSource()==PhanQuyenGUI.btnadd) {
			quanLyView.getPhanQuyen().xuLyThemQuyen();
		}
		if(e.getSource()==PhanQuyenGUI.btndelete) {
			quanLyView.getPhanQuyen().xuLyXoaQuyen();
		}
		if(e.getSource()==PhanQuyenGUI.btnedit) {
			quanLyView.getPhanQuyen().xuLySuaQuyen();
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getComponent() == this.quanLyView.jButton_close) {
			this.quanLyView.mouseEntered_button_close();
		} 
		if (e.getComponent() == this.quanLyView.jButton_hidden) {
			this.quanLyView.mouseEntered_button_hidden();
		}
		if (e.getComponent() == this.quanLyView.jButton_logout) {
			this.quanLyView.mouseEntered_button_logout();
		}
		for (int i = 0; i < this.quanLyView.menuItem.length; i++) {
			if (e.getComponent() == this.quanLyView.menu_Label[i]) {
				this.quanLyView.mouseEntered_button_item(i, new Color(0x29B6F6));
			}

		}
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getComponent() == this.quanLyView.jButton_close) {
			this.quanLyView.mouseExited_button_close();
		} else if (e.getComponent() == this.quanLyView.jButton_hidden) {
			this.quanLyView.mouseExited_button_hidden();
		} else if (e.getComponent() == this.quanLyView.jButton_logout) {
			this.quanLyView.mouseExited_button_logout();
		}
		for (int i = 0; i < this.quanLyView.menuItem.length; i++) {
			if (e.getComponent() == this.quanLyView.menu_Label[i]) {
				this.quanLyView.mouseExited_button_item(i, new Color(0x596275));
			}

		}
	}

}
