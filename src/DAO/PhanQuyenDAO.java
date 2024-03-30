package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.HoaDon;
import DTO.PhanQuyen;

public class PhanQuyenDAO implements DaoInterface<PhanQuyen>{

	public static PhanQuyenDAO getIntance() {
		return new PhanQuyenDAO();
	}
	@Override
	public int them(PhanQuyen t) {
		int check=0;
		try {
			Connection con=new ConnectDatabase().getConnection();
			Statement st= con.createStatement();
			
			String sql="INSERT INTO phan_quyen(QUYEN,NHAPHANG,QL_SANPHAM,QL_NV,QL_KH,QL_NCC,THONGKE,THEM,XOA,SUA,QL_PHAN_QUYEN)\r\n"
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, t.getQuyen());
			prep.setInt(2, t.getNhapHang());
			prep.setInt(3, t.getQlSP());
			prep.setInt(4, t.getQlNV());
			prep.setInt(5, t.getQlKh());
			prep.setInt(6, t.getQlNCC());
			prep.setInt(7, t.getQlThongKe());
			prep.setInt(8, t.getThem());
			prep.setInt(9, t.getXoa());
			prep.setInt(10, t.getSua());
			prep.setInt(11, t.getQlPhanQuyen());
			
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
	public int capNhap(PhanQuyen t) {
		int check=0;
		try {
			Connection con=new ConnectDatabase().getConnection();
			Statement st= con.createStatement();
			
			String sql="UPDATE phan_quyen\r\n"
					+ "SET "
					+ "NHAPHANG= ?, "
					+ "QL_SANPHAM = ?, "
					+"QL_NV= ?, "
					+ "QL_KH = ?, "
					+ "QL_NCC = ?, "
					+ "THONGKE	= ?, "
					+ "THEM =?, "
					+ "XOA= ?, "
					+ "SUA=?, "
					+ "QL_PHAN_QUYEN=? "
					+ "WHERE QUYEN = ?";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setInt(1, t.getNhapHang());
			prep.setInt(2, t.getQlSP());
			prep.setInt(3, t.getQlNV());
			prep.setInt(4, t.getQlKh());
			prep.setInt(5, t.getQlNCC());
			prep.setInt(6, t.getQlThongKe());
			prep.setInt(7, t.getThem());
			prep.setInt(8, t.getXoa());
			prep.setInt(9, t.getSua());
			prep.setInt(10, t.getQlPhanQuyen());
			prep.setString(11, t.getQuyen());
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
	public int xoa(PhanQuyen t) {
		int check=0;
		try {
			Connection con=new ConnectDatabase().getConnection();
			Statement st= con.createStatement();
			String sql="DELETE FROM phan_quyen "
					+ "WHERE QUYEN = '"+t.getQuyen()+"';";
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
	public ArrayList<PhanQuyen> selectAll() {
		ArrayList<PhanQuyen> listPQ = new ArrayList<>();
        try {
        	Connection con=new ConnectDatabase().getConnection();
            String sql = "SELECT * FROM phan_quyen";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	PhanQuyen pq = new PhanQuyen();
            	pq.setQuyen(rs.getString(1));
            	pq.setNhapHang(rs.getInt(2));
            	pq.setQlSP(rs.getInt(3));
            	pq.setQlNV(rs.getInt(4));
            	pq.setQlKh(rs.getInt(5));
            	pq.setQlNCC(rs.getInt(6));
            	pq.setQlThongKe(rs.getInt(7));
            	pq.setThem(rs.getInt(8));
            	pq.setXoa(rs.getInt(9));
            	pq.setSua(rs.getInt(10));
            	pq.setQlPhanQuyen(rs.getInt(11));
                listPQ.add(pq);
            }
            ConnectDatabase.closeConnection(con);
        } catch (SQLException ex) {
        	ex.printStackTrace();
            return null;
            
        }
		return listPQ;
	}

	@Override
	public PhanQuyen selectById(PhanQuyen t) {
		PhanQuyen phanQuyen=null;
        try {
        	Connection con=new ConnectDatabase().getConnection();
            String sql = "SELECT * FROM phan_quyen WHERE QUYEN='"+t.getQuyen()+"'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	PhanQuyen pq = new PhanQuyen();
            	pq.setQuyen(rs.getString(1));
            	pq.setNhapHang(rs.getInt(2));
            	pq.setQlSP(rs.getInt(3));
            	pq.setQlNV(rs.getInt(4));
            	pq.setQlKh(rs.getInt(5));
            	pq.setQlNCC(rs.getInt(6));
            	pq.setQlThongKe(rs.getInt(7));
            	pq.setThem(rs.getInt(8));
            	pq.setXoa(rs.getInt(9));
            	pq.setSua(rs.getInt(10));
            	pq.setQlPhanQuyen(rs.getInt(11));
                phanQuyen=pq;
            }
            ConnectDatabase.closeConnection(con);
        } catch (SQLException ex) {
        	ex.printStackTrace();
            return null;
            
        }
		return phanQuyen;
	}

	@Override
	public ArrayList<PhanQuyen> selectBy(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
