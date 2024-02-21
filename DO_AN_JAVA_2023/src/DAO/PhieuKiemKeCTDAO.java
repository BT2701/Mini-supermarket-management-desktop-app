package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.PhanQuyen;
import DTO.PhieuKiemKeCT;

public class PhieuKiemKeCTDAO implements DaoInterface<PhieuKiemKeCT>{

	public static PhieuKiemKeCTDAO getIntance() {
		return new PhieuKiemKeCTDAO();
	}
	@Override
	public int them(PhieuKiemKeCT t) {
		int check=0;
		try {
			Connection con=new ConnectDatabase().getConnection();
			Statement st= con.createStatement();
			
			String sql="INSERT INTO phieu_kiem_ke_ct(MA_PKK,MA_MH,SL_TON_QUAY)\r\n"
					+ "VALUES (?,?,?);";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, t.getMaPkk());
			prep.setString(2, t.getMaMh());
			prep.setInt(3, t.getSlTon());
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
	public int capNhap(PhieuKiemKeCT t) {
		int check=0;
		try {
			Connection con=new ConnectDatabase().getConnection();
			Statement st= con.createStatement();
			
			String sql="UPDATE phieu_kiem_ke_ct\r\n"
					+ "SET "
					+ "SL_TON_QUAY	= ? "
					+ "WHERE MA_PKK = ? AND MA_MH = ? ";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setInt(1, t.getSlTon());
			prep.setString(2, t.getMaPkk());
			prep.setString(3, t.getMaMh());
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
	public int xoa(PhieuKiemKeCT t) {
		int check=0;
		try {
			Connection con=new ConnectDatabase().getConnection();
			Statement st= con.createStatement();
			String sql="DELETE FROM phieu_kiem_ke_ct "
					+ "WHERE MA_PKK = '"+t.getMaPkk()+"' AND MA_MH = '"+t.getMaMh()+"';";
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
	public ArrayList<PhieuKiemKeCT> selectAll() {
		ArrayList<PhieuKiemKeCT> listPKKCT = new ArrayList<>();
        try {
        	Connection con=new ConnectDatabase().getConnection();
            String sql = "SELECT * FROM phieu_kiem_ke_ct";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	PhieuKiemKeCT pkkct = new PhieuKiemKeCT();
            	pkkct.setMaPkk(rs.getString(1));
            	pkkct.setMaMh(rs.getString(2));
            	pkkct.setSlTon(rs.getInt(3));
            	listPKKCT.add(pkkct);
            }
            ConnectDatabase.closeConnection(con);
        } catch (SQLException ex) {
        	ex.printStackTrace();
            return null;
            
        }
		return listPKKCT;
	}

	@Override
	public PhieuKiemKeCT selectById(PhieuKiemKeCT t) {
		PhieuKiemKeCT phieuKKCT=null;
        try {
        	Connection con=new ConnectDatabase().getConnection();
            String sql = "SELECT * FROM phieu_kiem_ke_ct "
            		+ "WHERE MA_PKK = '"+t.getMaPkk()+"' AND MA_MH = '"+t.getMaMh()+"';";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	PhieuKiemKeCT pkkct = new PhieuKiemKeCT();
            	pkkct.setMaPkk(rs.getString(1));
            	pkkct.setMaMh(rs.getString(2));
            	pkkct.setSlTon(rs.getInt(3));
            	phieuKKCT=pkkct;
            }
            ConnectDatabase.closeConnection(con);
        } catch (SQLException ex) {
        	ex.printStackTrace();
            return null;
            
        }
		return phieuKKCT;
	}

	@Override
	public ArrayList<PhieuKiemKeCT> selectBy(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
