/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author phamn
 */
public class NhanVienEvent implements ActionListener, MouseListener, MouseMotionListener{

    private NhanVienGUI nhanVien;

    public NhanVienEvent(NhanVienGUI nhanVien) {
        this.nhanVien = nhanVien;
    }

    

    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == nhanVien.bt_MaNV) {
            this.nhanVien.setEnable_lbMaKH();
        }
        else if(e.getSource() == nhanVien.bt_DiaChi) {
            this.nhanVien.setEnable_lbDiaChi();
        }
        else if(e.getSource() == nhanVien.bt_NgayVaoLam) {
            this.nhanVien.setEnable_lbNgayMua();
        }
        else if(e.getSource() == nhanVien.bt_gioiTinh) {
            this.nhanVien.setEnable_lbGioiTinh();
        }
        else if(e.getSource() == nhanVien.cbMaNV) {
            String maKh = nhanVien.cbMaNV.getSelectedItem().toString();
            nhanVien.loadDataLayDoiTuong_maNV(maKh);
        }
        else if(e.getSource() == nhanVien.cbDiaChi) {
            String diaChi = nhanVien.cbDiaChi.getSelectedItem().toString();
            nhanVien.loadDataLayDoiTuong_diaChiNV(diaChi);
        }
        else if(e.getSource() == nhanVien.cbPhai) {
            String gioiTinh = nhanVien.cbPhai.getSelectedItem().toString();
            nhanVien.loadDataLayDoiTuong_gioiTinhNV(gioiTinh);
        }
        
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == nhanVien.btnsearch) {
            nhanVien.xuLySuKien_layDsNV_theoNgayVaoLam();
        }
//        if(e.getSource()==nhanVien.txtrefresh) {
//        	nhanVien.xu
//        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
    
}
