package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.HoaDon;
import DTO.KhuyenMaiDTO;

public class KhuyenMaiDAO {
	public static KhuyenMaiDAO getIstance() {
		return new KhuyenMaiDAO();
	}
	public int them(KhuyenMaiDTO t) {
		// TODO Auto-generated method stub
		int check=0;
		try {
			Connection con=new ConnectDatabase().getConnection();
			Statement st= con.createStatement();
			
			String sql="INSERT INTO khuyen_mai(TEN,GIA_TRI)\r\n"
					+ "VALUES (?,?);";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, t.getTen());
			prep.setInt(2, t.getGiatri());
			
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

	public int capNhap(KhuyenMaiDTO t) {
		int check=0;
		try {
			Connection con=new ConnectDatabase().getConnection();
			Statement st= con.createStatement();
			
			String sql="UPDATE khuyen_mai\r\n"
					+ "SET "
					+ "GIA_TRI= ? "
					+ "WHERE TEN = ?";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setDouble(1, t.getGiatri());
			prep.setString(2, t.getTen());
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

	public int xoa(KhuyenMaiDTO t) {
		// TODO Auto-generated method stub
		int check=0;
		try {
			Connection con=new ConnectDatabase().getConnection();
			Statement st= con.createStatement();
			String sql="DELETE FROM khuyen_mai "
					+ "WHERE TEN = '"+t.getTen()+"';";
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

	public ArrayList<KhuyenMaiDTO> selectAll() {
		ArrayList<KhuyenMaiDTO> listHD = new ArrayList<>();
        try {
        	Connection con=new ConnectDatabase().getConnection();
            String sql = "SELECT * FROM khuyen_mai";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                KhuyenMaiDTO hd = new KhuyenMaiDTO();
                hd.setTen(rs.getString(1));
                hd.setGiatri(rs.getInt(2));
                listHD.add(hd);
            }
            ConnectDatabase.closeConnection(con);
        } catch (SQLException ex) {
        	ex.printStackTrace();
            return null;
            
        }
		return listHD;
	}

	public KhuyenMaiDTO selectById(KhuyenMaiDTO t) {
		KhuyenMaiDTO hoaDon=null;
        try {
        	Connection con=new ConnectDatabase().getConnection();
            String sql = "SELECT * FROM khuyen_mai WHERE TEN='"+t.getTen()+"'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	KhuyenMaiDTO hd = new KhuyenMaiDTO();
                hd.setTen(rs.getString(1));
                hd.setGiatri(rs.getInt(2));
                hoaDon=hd;
            }
            ConnectDatabase.closeConnection(con);
        } catch (SQLException ex) {
        	ex.printStackTrace();
            return null;
            
        }
		return hoaDon;
	}
}
