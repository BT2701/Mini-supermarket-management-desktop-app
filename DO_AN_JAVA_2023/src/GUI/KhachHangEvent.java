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
public class KhachHangEvent implements ActionListener, MouseListener, MouseMotionListener{

    private KhachHangGUI khachHang;

    public KhachHangEvent(KhachHangGUI khachHang) {
        this.khachHang = khachHang;
    }

    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == khachHang.bt_MaKH) {
            this.khachHang.setEnable_lbMaKH();
        }
        else if(e.getSource() == khachHang.bt_DiaChi) {
            this.khachHang.setEnable_lbDiaChi();
        }
        else if(e.getSource() == khachHang.bt_NgayMua) {
            this.khachHang.setEnable_lbNgayMua();
        }
        else if(e.getSource() == khachHang.cbMaKH) {
            String maKh = khachHang.cbMaKH.getSelectedItem().toString();
            khachHang.loadDataLayDoiTuong_maKH(maKh);
        }
        else if(e.getSource() == khachHang.cbDiaChi) {
            String diaChi = khachHang.cbDiaChi.getSelectedItem().toString();
            khachHang.loadDataLayDoiTuong_diaChiKH(diaChi);
        }
        
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == khachHang.btnsearch) {
            khachHang.xuLySuKien_layDsKH_theoNgayMuaGanNhat();
        }
        if(e.getSource()==khachHang.txtrefresh) {
        	khachHang.xuLySuKienRefresh();
        }
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
