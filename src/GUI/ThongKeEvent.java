package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ThongKeEvent implements ActionListener,MouseListener,ChangeListener{

	private ThongKe thongKe;
	private Color oldColor=new Color(236, 240, 241);
	private Color hoverColor=new Color(192, 57, 43);
	
	private Color btnoldColor=new Color(52, 152, 219);
	private Color btnhoverColor=new Color(116, 185, 255);
	private Color pressColor=new Color(87, 101, 116);
	private DecimalFormat dcf = new DecimalFormat("###,###");
	public ThongKeEvent(ThongKe thongKe) {
		this.thongKe = thongKe;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==ThongKeTop.lbLapPhieukk) {
			thongKe.getTkt().lapPhieuKiemKe();
		}
		if(e.getSource()==ThongKeTop.lbThongKeTheoKhoangThoiGian) {
			thongKe.getTkd().layDuLieuThongKe();
			thongKe.getTkt().xuLySuKienThongKeTheoKhoangTG();
		}
		if(e.getSource()==ThongKeTop.lbThongKeTheoNV) {
			thongKe.getTkd().layDuLieuThongKe();
			thongKe.getTkt().xuLySuKienThongKeTheoNV();
		}
		if(e.getSource()==ThongKeTop.btnRefresh) {
			thongKe.xuLySuKienRefresh();
		}
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==ThongKeTop.lbLapPhieukk) {
			ThongKeTop.lbLapPhieukk.setBackground(btnhoverColor);
		}
		if(e.getSource()==ThongKeTop.lbThongKeTheoKhoangThoiGian) {
			ThongKeTop.lbThongKeTheoKhoangThoiGian.setBackground(btnhoverColor);
		}
		if(e.getSource()==ThongKeTop.lbThongKeTheoNV) {
			ThongKeTop.lbThongKeTheoNV.setBackground(btnhoverColor);
		}
		if(e.getSource()==ThongKeTop.btnRefresh) {
			ThongKeTop.btnRefresh.setBackground(btnhoverColor);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==ThongKeTop.lbLapPhieukk) {
			ThongKeTop.lbLapPhieukk.setBackground(btnoldColor);
		}
		if(e.getSource()==ThongKeTop.lbThongKeTheoKhoangThoiGian) {
			ThongKeTop.lbThongKeTheoKhoangThoiGian.setBackground(btnoldColor);
		}
		if(e.getSource()==ThongKeTop.lbThongKeTheoNV) {
			ThongKeTop.lbThongKeTheoNV.setBackground(btnoldColor);
		}
		if(e.getSource()==ThongKeTop.btnRefresh) {
			ThongKeTop.btnRefresh.setBackground(Color.white);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==thongKe.getTkt().getBtnView()) {
			thongKe.xuLySuKienBtnView();
		}
		if(e.getSource()==thongKe.getTkct().getBtnBack()) {
			thongKe.xuLySuKienBtnBack();
		}
		if (e.getSource()==ThongKeTop.cblistPKK) {
			thongKe.getTkt().xuLySuKienXuatPhieuKKtheoMa();
		}
		if(e.getSource()==ThongKeDown.cbListNV) {
			thongKe.getTkd().layDuLieuThongKeTheoNV();
		}
		if(e.getSource()==ThongKeChiTiet.cbnam) {
			if(ThongKeChiTiet.cbnam.getSelectedIndex()==0) {
				thongKe.getTkct().veLaiChart();
				thongKe.getTkct().getDSPhieuThang();
			}
			
		}
		if(e.getSource()==ThongKeChiTiet.cbthang) {
			thongKe.getTkct().xuLySuKienBieuDoTheoThoiGian();
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==ThongKeDown.spnTuNgay || e.getSource()==ThongKeDown.spnDenNgay) {
			thongKe.getTkd().layDuLieuThongKeTheoKhoangThoiGian();
		}
	}

}
