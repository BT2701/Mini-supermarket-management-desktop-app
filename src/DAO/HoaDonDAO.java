package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import DTO.HoaDon;


public class HoaDonDAO implements DaoInterface<HoaDon>{
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	public static HoaDonDAO getIntance() {
		return new HoaDonDAO();
	}
	
	@Override
	public int them(HoaDon t) {
		// TODO Auto-generated method stub
		int check=0;
		try {
			Connection con=new ConnectDatabase().getConnection();
			Statement st= con.createStatement();
			
			String sql="INSERT INTO hoa_don(MA_HD,MA_NV,THOI_DIEM_LAP,TONG_TIEN_PHAI_TRA,MA_KH,DIEM_THUONG,TRANG_THAI)\r\n"
					+ "VALUES (?,?,?,?,?,?,?);";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, t.getMaHD());
			prep.setString(2, t.getMaNV());
			prep.setDate(3, t.getDate());
			prep.setDouble(4, t.getTongTienPhaiTra());
			prep.setString(5, t.getMaKH());
			prep.setInt(6, t.getDiemThuong());
			prep.setInt(7, 1);
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
	public int capNhap(HoaDon t) {
		int check=0;
		try {
			Connection con=new ConnectDatabase().getConnection();
			Statement st= con.createStatement();
			
			String sql="UPDATE hoa_don\r\n"
					+ "SET "
					+ "TONG_TIEN_PHAI_TRA= ?, "
					+ "DIEM_THUONG= ? "
					+ "WHERE MA_HD = ?";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setDouble(1, t.getTongTienPhaiTra());
			prep.setInt(2, t.getDiemThuong());
			prep.setString(3, t.getMaHD());
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
	public int xoa(HoaDon t) {
		// TODO Auto-generated method stub
		int check=0;
		try {
			Connection con=new ConnectDatabase().getConnection();
			Statement st= con.createStatement();
			String sql="DELETE FROM hoa_don "
					+ "WHERE MA_HD = '"+t.getMaHD()+"';";
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
	public ArrayList<HoaDon> selectAll() {
		ArrayList<HoaDon> listHD = new ArrayList<>();
        try {
        	Connection con=new ConnectDatabase().getConnection();
            String sql = "SELECT * FROM hoa_don";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString(1));
                hd.setMaNV(rs.getString(2));
                hd.setDate(rs.getDate(3));
                hd.setTongTienPhaiTra(rs.getDouble(4));
                hd.setMaKH(rs.getString(5));
                hd.setDiemThuong(rs.getInt(6));
                hd.setTrangThai(rs.getInt(7));
                listHD.add(hd);
            }
            ConnectDatabase.closeConnection(con);
        } catch (SQLException ex) {
        	ex.printStackTrace();
            return null;
            
        }
		return listHD;
	}

	@Override
	public HoaDon selectById(HoaDon t) {
		HoaDon hoaDon=null;
        try {
        	Connection con=new ConnectDatabase().getConnection();
            String sql = "SELECT * FROM hoa_don WHERE MA_HD='"+t.getMaHD()+"'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString(1));
                hd.setMaNV(rs.getString(2));
                hd.setDate(rs.getDate(3));
                hd.setTongTienPhaiTra(rs.getDouble(4));
                hd.setMaKH(rs.getString(5));
                hd.setDiemThuong(rs.getInt(6));
                hd.setTrangThai(rs.getInt(7));
                hoaDon=hd;
            }
            ConnectDatabase.closeConnection(con);
        } catch (SQLException ex) {
        	ex.printStackTrace();
            return null;
            
        }
		return hoaDon;
	}

	@Override
	public ArrayList<HoaDon> selectBy(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public double thongKeTheoKhoangThoiGian(Date tuNgay, Date denNgay) {
		double doanhThu=0;
//		SELECT SUM(TONG_TIEN_PHAI_TRA) AS total_cost
//		FROM hoa_don
//		WHERE THOI_DIEM_LAP BETWEEN '2023-04-19' AND '2023-04-30';
		try {
        	Connection con=new ConnectDatabase().getConnection();
            String sql = "SELECT SUM(TONG_TIEN_PHAI_TRA) AS total_cost "
            		+ "FROM hoa_don "
            		+ "WHERE THOI_DIEM_LAP BETWEEN '"+sdf.format(tuNgay)+"' AND '"+sdf.format(denNgay)+"';";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                doanhThu=rs.getDouble(1);
            }
            ConnectDatabase.closeConnection(con);
        } catch (SQLException ex) {
        	ex.printStackTrace();
            return 0;
            
        }
		
		return doanhThu;

	}
	public ArrayList<String> layMaHoaDonTheoKhoangThoiGian(Date tuNgay,Date denNgay) {
		ArrayList<String> listHD=new ArrayList<>();
		try {
        	Connection con=new ConnectDatabase().getConnection();
            String sql = "SELECT MA_HD "
            		+ "FROM hoa_don "
            		+ "WHERE THOI_DIEM_LAP BETWEEN '"+sdf.format(tuNgay)+"' AND '"+sdf.format(denNgay)+"';";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                listHD.add(rs.getString(1));
            }
            ConnectDatabase.closeConnection(con);
        } catch (SQLException ex) {
        	ex.printStackTrace();
            return null;
            
        }
		return listHD;
	}
	public ArrayList<HoaDon> layDanhSachHoaDonTheoGia(double giaTu, double denGia){
//		SELECT *
//		FROM hoa_don
//		WHERE TONG_TIEN_PHAI_TRA BETWEEN 1000000 AND 3000000;

		ArrayList<HoaDon> listHD=new ArrayList<>();
		try {
        	Connection con=new ConnectDatabase().getConnection();
            String sql = "SELECT * "
            		+ "FROM hoa_don "
            		+ "WHERE TONG_TIEN_PHAI_TRA BETWEEN "+giaTu+" AND "+denGia+";";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString(1));
                hd.setMaNV(rs.getString(2));
                hd.setDate(rs.getDate(3));
                hd.setTongTienPhaiTra(rs.getDouble(4));
                hd.setMaKH(rs.getString(5));
                hd.setDiemThuong(rs.getInt(6));
                hd.setTrangThai(rs.getInt(7));
                listHD.add(hd);
            }
            ConnectDatabase.closeConnection(con);
        } catch (SQLException ex) {
        	ex.printStackTrace();
            return null;
            
        }
		return listHD;
	}
	
	public int thayDoiTrangThai(String maHD,int trangThai) {
		int check=0;
		try {
			Connection con=new ConnectDatabase().getConnection();
			Statement st= con.createStatement();
			
			String sql="UPDATE hoa_don\r\n"
					+ "SET "
					+ "TRANG_THAI= ? "
					+ "WHERE MA_HD = ?";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setInt(1, trangThai);
			prep.setString(2, maHD);
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
	

}
