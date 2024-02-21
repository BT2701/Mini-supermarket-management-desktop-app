package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import DTO.PhieuKiemKe;
import DTO.PhieuNhap;

public class PhieuNhapDAO implements DaoInterface<PhieuNhap>{

	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	public static PhieuNhapDAO getIntance() {
		return new PhieuNhapDAO();
	}
	@Override
	public int them(PhieuNhap t) {
		int check = 0;
		try {
			Connection con = new ConnectDatabase().getConnection();
			Statement st = con.createStatement();	

			String sql = "INSERT INTO phieu_nhap(MA_PN,MA_NV,THOI_DIEM_LAP)\r\n"
					+ "VALUES (?,?,?);";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, t.getMaPN());
			prep.setString(2, t.getMaNV());
			prep.setDate(3, t.getDate());
			// thuc thi cau lenh sql va tra ve so dong bi thay doi
//			int check=st.executeUpdate(sql);
			check = prep.executeUpdate();
			if (check > 0)
				System.out.println("thêm dữ liệu thành công");
			else
				System.out.println("thất bại 8987");
			System.out.println("ban da thucc thi: " + sql);
			System.out.println("so dong thay doi: " + check);

			// buoc 5 ngat ket noi
			ConnectDatabase.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("thất bại");
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int capNhap(PhieuNhap t) {
		int check = 0;
		try {
			Connection con = new ConnectDatabase().getConnection();
			Statement st = con.createStatement();

			String sql = "UPDATE phieu_nhap\r\n" + "SET " + "MA_NV= ?, " + "THOI_DIEM_LAP= ? "
					+ "WHERE MA_PN = ?";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, t.getMaNV());
			prep.setDate(2, t.getDate());
			prep.setString(3, t.getMaPN());
			// thuc thi cau lenh sql va tra ve so dong bi thay doi
//			int check=st.executeUpdate(sql);
			check = prep.executeUpdate();
			if (check > 0)
				System.out.println("thêm dữ liệu thành công");
			else
				System.out.println("thất bại 8987");
			System.out.println("ban da thucc thi: " + sql);
			System.out.println("so dong thay doi: " + check);

			// buoc 5 ngat ket noi
			ConnectDatabase.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("thất bại");
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int xoa(PhieuNhap t) {
		int check = 0;
		try {
			Connection con = new ConnectDatabase().getConnection();
			Statement st = con.createStatement();
			String sql = "DELETE FROM phieu_nhap " + "WHERE MA_PN = '" + t.getMaPN() + "';";
			check = st.executeUpdate(sql);
			if (check > 1)
				System.out.println("thành công");

			ConnectDatabase.closeConnection(con);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<PhieuNhap> selectAll() {
		ArrayList<PhieuNhap> listPN = new ArrayList<>();
		try {
			Connection con = new ConnectDatabase().getConnection();
			String sql = "SELECT * FROM phieu_nhap";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				PhieuNhap pn = new PhieuNhap();
				pn.setMaPN(rs.getString(1));
				pn.setMaNV(rs.getString(2));
				pn.setDate(rs.getDate(3));
				listPN.add(pn);
			}
			ConnectDatabase.closeConnection(con);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;

		}
		return listPN;
	}

	@Override
	public PhieuNhap selectById(PhieuNhap t) {
		PhieuNhap phieuNhap = null;
		try {
			Connection con = new ConnectDatabase().getConnection();
			String sql = "SELECT * FROM phieu_nhap WHERE MA_PN='" + t.getMaPN() + "'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				PhieuNhap pn = new PhieuNhap();
				pn.setMaPN(rs.getString(1));
				pn.setMaNV(rs.getString(2));
				pn.setDate(rs.getDate(3));
				phieuNhap = pn;
			}
			ConnectDatabase.closeConnection(con);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;

		}
		return phieuNhap;
	}

	@Override
	public ArrayList<PhieuNhap> selectBy(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<PhieuNhap> layPhieuNhapTheoKhoangThoiGian(Date tuNgay,Date denNgay) {
		ArrayList<PhieuNhap> listPN=new ArrayList<>();
		try {
        	Connection con=new ConnectDatabase().getConnection();
            String sql = "SELECT * "
            		+ "FROM phieu_nhap "
            		+ "WHERE THOI_DIEM_LAP BETWEEN '"+sdf.format(tuNgay)+"' AND '"+sdf.format(denNgay)+"';";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	PhieuNhap pn=new PhieuNhap();
            	pn.setMaPN(rs.getString(1));
            	pn.setMaNV(rs.getString(2));
            	pn.setDate(rs.getDate(3));
                listPN.add(pn);
            }
            ConnectDatabase.closeConnection(con);
        } catch (SQLException ex) {
        	ex.printStackTrace();
            return null;
            
        }
		return listPN;
	}

}
