package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.PhieuNhapCT;
import DTO.PhieuXuatChiTiet;

public class PhieuXuatCTDAO implements DaoInterface<PhieuXuatChiTiet>{

	public static PhieuXuatCTDAO getIntance() {
		return new PhieuXuatCTDAO();
	}
	@Override
	public int them(PhieuXuatChiTiet t) {
		int check=0;
		try {
			Connection con=new ConnectDatabase().getConnection();
			Statement st= con.createStatement();
			
			String sql="INSERT INTO phieu_xuat_ct(MA_PX,MA_MH,SO_LUONG)\r\n"
					+ "VALUES (?,?,?);";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, t.getMaPX());
			prep.setString(2, t.getMaMH());
			prep.setInt(3, t.getSoLuong());
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
	public int capNhap(PhieuXuatChiTiet t) {
		int check=0;
		try {
			Connection con=new ConnectDatabase().getConnection();
			Statement st= con.createStatement();
			
			String sql="UPDATE phieu_xuat_ct\r\n"
					+ "SET "
					+ "SO_LUONG	= ? "
					+ "WHERE MA_PX = ? AND MA_MH = ? ";	
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setInt(1, t.getSoLuong());
			prep.setString(2, t.getMaPX());
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
	public int xoa(PhieuXuatChiTiet t) {
		int check=0;
		try {
			Connection con=new ConnectDatabase().getConnection();
			Statement st= con.createStatement();
			String sql="DELETE FROM phieu_xuat_ct "
					+ "WHERE MA_PX = '"+t.getMaPX()+"' AND MA_MH = '"+t.getMaMH()+"';";
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
	public ArrayList<PhieuXuatChiTiet> selectAll() {
		ArrayList<PhieuXuatChiTiet> listPXCT = new ArrayList<>();
        try {
        	Connection con=new ConnectDatabase().getConnection();
            String sql = "SELECT * FROM phieu_xuat_ct";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	PhieuXuatChiTiet pxct = new PhieuXuatChiTiet();
            	pxct.setMaPX(rs.getString(1));
            	pxct.setMaMH(rs.getString(2));
            	pxct.setSoLuong(rs.getInt(3));
            	listPXCT.add(pxct);
            }
            ConnectDatabase.closeConnection(con);
        } catch (SQLException ex) {
        	ex.printStackTrace();
            return null;
            
        }
		return listPXCT;
	}

	@Override
	public PhieuXuatChiTiet selectById(PhieuXuatChiTiet t) {
		PhieuXuatChiTiet phieuXuatCT=null;
        try {
        	Connection con=new ConnectDatabase().getConnection();
            String sql = "SELECT * FROM phieu_xuat_ct "
            		+ "WHERE MA_PX = '"+t.getMaPX()+"' AND MA_MH = '"+t.getMaMH()+"';";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	PhieuXuatChiTiet pxct = new PhieuXuatChiTiet();
            	pxct.setMaPX(rs.getString(1));
            	pxct.setMaMH(rs.getString(2));
            	pxct.setSoLuong(rs.getInt(3));
            	phieuXuatCT=pxct;
            }
            ConnectDatabase.closeConnection(con);
        } catch (SQLException ex) {
        	ex.printStackTrace();
            return null;
            
        }
		return phieuXuatCT;
	}

	@Override
	public ArrayList<PhieuXuatChiTiet> selectBy(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
