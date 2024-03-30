package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TrangChuGUI extends JPanel {
	private JPanel pnposterHead, pnposterMain;
	private JLabel lbposterMain;
	private JLabel lbposterHeader;
	private String[] hrefPoster = { "./src/IMG_SANPHAM/poster3.png", "./src/IMG_SANPHAM/poster2.png",
			"./src/IMG_SANPHAM/poster1.png", "./src/IMG_SANPHAM/poster4.png" };
	private javax.swing.Timer timer;
	private int index=0;

	public TrangChuGUI() {
		initCompenent();
		this.setVisible(false);
		xuLyChuyenPoster();
	}

	public void initCompenent() {
		this.setPreferredSize(new Dimension(1100, 700));
		this.setLayout(null);
		pnposterHead = new JPanel();
		pnposterMain = new JPanel();

		lbposterHeader=new JLabel(new ImageIcon(hrefPoster[0]));
		lbposterHeader.setBounds(0, 0, 1080, 280);
		
		pnposterHead.setBounds(10, 10, 1080, 280);
//		pnposterHead.setBackground(Color.red);
		pnposterHead.setLayout(null);
		pnposterHead.add(lbposterHeader);
		

		pnposterMain.setBounds(0, 300, 1100, 400);
//		pnposterMain.setBackground(Color.green);
		pnposterMain.setLayout(null);
//		
		lbposterMain = new JLabel(new ImageIcon("./src/IMG_SANPHAM/postermain.png"));
		lbposterMain.setBounds(0, 0, 1100, 400);
		pnposterMain.add(lbposterMain);

		this.add(pnposterHead);
//		this.add(pnposterHead2);
		this.add(pnposterMain);
//		this.setBackground(Color.blue);
	}

	public void xuLyChuyenPoster() {
		timer=new javax.swing.Timer(2000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 if (index == hrefPoster.length) {
			            index = 0;
			        }
			        lbposterHeader.setIcon(new ImageIcon(hrefPoster[index]));
			        index++;
			}
		});
		timer.start();
		
	}

	public JPanel getPnposterHead() {
		return pnposterHead;
	}

	public void setPnposterHead(JPanel pnposterHead) {
		this.pnposterHead = pnposterHead;
	}

	public JPanel getPnposterMain() {
		return pnposterMain;
	}

	public void setPnposterMain(JPanel pnposterMain) {
		this.pnposterMain = pnposterMain;
	}

}
