package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.PhieuKiemKeCT;
import DTO.PhieuNhapCT;

public class PhieuNhapCTDAO implements DaoInterface<PhieuNhapCT>{

	public static PhieuNhapCTDAO getIntance() {
		return new PhieuNhapCTDAO();
	}
	@Override
	public int them(PhieuNhapCT t) {
		int check=0;
		try {
			Connection con=new ConnectDatabase().getConnection();
			Statement st= con.createStatement();
			
			String sql="INSERT INTO phieu_nhap_ct(MA_PN,MA_MH,MA_NCC,SO_LUONG)\r\n"
					+ "VALUES (?,?,?,?);";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, t.getMaPN());
			prep.setString(2, t.getMaMH());
			prep.setString(3, t.getMaNCC());
			prep.setInt(4, t.getSl());
			//thuc thi cau lenh sql va tra ve so dong bi thay doi
//			int check=st.executeUpdate(sql);
			check=prep.executeUpdate();
			if (check>0)
				System.out.println("thêm dữ liệu thành công");
			else
				System.out.println("thất bại 8987");
			System.out.println("ban da thucc thi: "+sql);
			System.out.println("so dong thay doi: "+check);
			
			
			//buoc 5 ngat ket noi
			ConnectDatabase.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("thất bại");
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int capNhap(PhieuNhapCT t) {
		int check=0;
		try {
			Connection con=new ConnectDatabase().getConnection();
			Statement st= con.createStatement();
			
			String sql="UPDATE phieu_nhap_ct\r\n"
					+ "SET "
					+ "MA_NCC	= ? "
					+ "WHERE MA_PN = ? AND MA_MH = ? ";	
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, t.getMaNCC());
			prep.setString(2, t.getMaPN());
			prep.setString(3, t.getMaMH());
			//thuc thi cau lenh sql va tra ve so dong bi thay doi
//			int check=st.executeUpdate(sql);
			check=prep.executeUpdate();
			if (check>0)
				System.out.println("thêm dữ liệu thành công");
			else
				System.out.println("thất bại 8987");
			System.out.println("ban da thucc thi: "+sql);
			System.out.println("so dong thay doi: "+check);
			
			
			//buoc 5 ngat ket noi
			ConnectDatabase.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("thất bại");
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int xoa(PhieuNhapCT t) {
		int check=0;
		try {
			Connection con=new ConnectDatabase().getConnection();
			Statement st= con.createStatement();
			String sql="DELETE FROM phieu_nhap_ct "
					+ "WHERE MA_PN = '"+t.getMaPN()+"' AND MA_MH = '"+t.getMaMH()+"';";
			check=st.executeUpdate(sql);
			if(check>1)
				System.out.println("thành công");
			
			ConnectDatabase.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<PhieuNhapCT> selectAll() {
		ArrayList<PhieuNhapCT> listPNCT = new ArrayList<>();
        try {
        	Connection con=new ConnectDatabase().getConnection();
            String sql = "SELECT * FROM phieu_nhap_ct";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	PhieuNhapCT pnct = new PhieuNhapCT();
            	pnct.setMaPN(rs.getString(1));
            	pnct.setMaMH(rs.getString(2));
            	pnct.setMaNCC(rs.getString(3));
            	pnct.setSl(rs.getInt(4));
            	listPNCT.add(pnct);
            }
            ConnectDatabase.closeConnection(con);
        } catch (SQLException ex) {
        	ex.printStackTrace();
            return null;
            
        }
		return listPNCT;
	}

	@Override
	public PhieuNhapCT selectById(PhieuNhapCT t) {
		PhieuNhapCT phieuNhapCT=null;
        try {
        	Connection con=new ConnectDatabase().getConnection();
            String sql = "SELECT * FROM phieu_nhap_ct "
            		+ "WHERE MA_PN = '"+t.getMaPN()+"' AND MA_MH = '"+t.getMaMH()+"';";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	PhieuNhapCT pnct = new PhieuNhapCT();
            	pnct.setMaPN(rs.getString(1));
            	pnct.setMaMH(rs.getString(2));
            	pnct.setMaNCC(rs.getString(3));
            	pnct.setSl(rs.getInt(4));
            	phieuNhapCT=pnct;
            }
            ConnectDatabase.closeConnection(con);
        } catch (SQLException ex) {
        	ex.printStackTrace();
            return null;
            
        }
		return phieuNhapCT;
	}

	@Override
	public ArrayList<PhieuNhapCT> selectBy(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
