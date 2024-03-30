package GUI;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.print.PrinterException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import BUS.HoaDonBUS;

import java.util.Vector;

public class DialogHienTrangSP extends JDialog{
	public DialogHienTrangSP() {
		initComponents();
	}
	public void initComponents() {
		this.setSize(500,700);
		this.setLocationRelativeTo(null);
		this.setTitle("Hóa đơn");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setModal(true);
		
		
		
		this.setVisible(true);
	}

}
