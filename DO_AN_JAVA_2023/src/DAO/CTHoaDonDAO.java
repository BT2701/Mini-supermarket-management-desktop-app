package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.CTHoaDon;
import DTO.HoaDon;

public class CTHoaDonDAO implements DaoInterface<CTHoaDon>{

	public static CTHoaDonDAO getIntance() {
		return new CTHoaDonDAO();
	}
	@Override
	public int them(CTHoaDon t) {
		int check=0;
		try {
			Connection con=new ConnectDatabase().getConnection();
			Statement st= con.createStatement();
			
			String sql="INSERT INTO hoa_don_chi_tiet(MA_HD,MA_MH,SO_LUONG,DON_GIA,THANH_TIEN)\r\n"
					+ "VALUES (?,?,?,?,?);";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, t.getMaHd());
			prep.setString(2, t.getMaMH());
			prep.setInt(3, t.getSlMH());
			prep.setDouble(4, t.getDonGia());
			prep.setDouble(5, t.getThanhTien());
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
	public int capNhap(CTHoaDon t) {
		int check=0;
		try {
			Connection con=new ConnectDatabase().getConnection();
			Statement st= con.createStatement();
			
			String sql="UPDATE hoa_don_chi_tiet\r\n"
					+ "SET "
					+ "SO_LUONG= ? "
					+ "WHERE MA_HD = '"+t.getMaHd()+"' AND MA_MH = '"+t.getMaMH()+"';";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setInt(1, t.getSlMH());
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
	public int xoa(CTHoaDon t) {
		int check=0;
		try {
			Connection con=new ConnectDatabase().getConnection();
			Statement st= con.createStatement();
			String sql="DELETE FROM hoa_don_chi_tiet "
					+ "WHERE MA_HD = '"+t.getMaHd()+"' AND MA_MH = '"+t.getMaMH()+"';";
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
	public ArrayList<CTHoaDon> selectAll() {
		ArrayList<CTHoaDon> listCTHD = new ArrayList<>();
        try {
        	Connection con=new ConnectDatabase().getConnection();
            String sql = "SELECT * FROM hoa_don_chi_tiet";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                CTHoaDon cthd = new CTHoaDon();
                cthd.setMaHd(rs.getString(1));
                cthd.setMaMH(rs.getString(2));
                cthd.setSlMH(rs.getInt(3));
                cthd.setDonGia(rs.getDouble(4));
                cthd.setThanhTien(rs.getDouble(5));
                listCTHD.add(cthd);
            }
            ConnectDatabase.closeConnection(con);
        } catch (SQLException ex) {
        	ex.printStackTrace();
            return null;
            
        }
		return listCTHD;
	}

	@Override
	public CTHoaDon selectById(CTHoaDon t) {
		CTHoaDon hoaDonct=null;
        try {
        	Connection con=new ConnectDatabase().getConnection();
            String sql = "SELECT * FROM hoa_don_chi_tiet "
            		+"WHERE MA_HD = '"+t.getMaHd()+"' AND MA_MH = '"+t.getMaMH()+"';";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	CTHoaDon hdct = new CTHoaDon();
            	hdct.setMaHd(rs.getString(1));
            	hdct.setMaMH(rs.getString(2));
            	hdct.setSlMH(rs.getInt(3));
            	hdct.setDonGia(rs.getDouble(4));
            	hdct.setThanhTien(rs.getDouble(5));
                hoaDonct=hdct;
            }
            ConnectDatabase.closeConnection(con);
        } catch (SQLException ex) {
        	ex.printStackTrace();
            return null;
            
        }
		return hoaDonct;
	}

	@Override
	public ArrayList<CTHoaDon> selectBy(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<String> layDanhSachSanPhamBanChay(){
//		SELECT MA_MH, SUM(SO_LUONG) AS TotalSold
//		FROM hoa_don_chi_tiet
//		GROUP BY MA_MH
//		ORDER BY TotalSold DESC
		ArrayList<String> listSP = new ArrayList<>();
        try {
        	Connection con=new ConnectDatabase().getConnection();
            String sql = "SELECT MA_MH, SUM(SO_LUONG) AS TotalSold "
            		+ "FROM hoa_don_chi_tiet "
            		+ "GROUP BY MA_MH "
            		+ "ORDER BY TotalSold DESC";	
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	String sp = rs.getString(1)+" - "+rs.getInt(2);
                
            	listSP.add(sp);
            }
            ConnectDatabase.closeConnection(con);
        } catch (SQLException ex) {
        	ex.printStackTrace();
            return null;
            
        }
		return listSP;

	}
	public double layTongTienTheoMaHD(String maHD) {
//		SELECT SUM(THANH_TIEN) AS TotalSold
//		FROM hoa_don_chi_tiet
//		WHERE MA_HD = 'HD33'
//		GROUP BY MA_HD
		double tongTien=0;
		try {
			Connection con=new ConnectDatabase().getConnection();
			String sql="SELECT SUM(THANH_TIEN) AS TotalSold "
					+ "FROM hoa_don_chi_tiet "
					+ "WHERE MA_HD = '"+maHD+"' "
							+ "GROUP BY MA_HD";
			Statement stm= con.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next()) {
				tongTien=rs.getDouble(1);
			}
			ConnectDatabase.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return tongTien;
	}
	

}
