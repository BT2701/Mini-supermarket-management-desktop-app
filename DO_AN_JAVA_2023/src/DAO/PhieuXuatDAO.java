package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.PhieuNhap;
import DTO.PhieuXuat;

public class PhieuXuatDAO implements DaoInterface<PhieuXuat>{

	public static PhieuXuatDAO getIntance() {
		return new PhieuXuatDAO();
	}
	@Override
	public int them(PhieuXuat t) {
		int check = 0;
		try {
			Connection con = new ConnectDatabase().getConnection();
			Statement st = con.createStatement();	

			String sql = "INSERT INTO phieu_xuat(MA_PX,MA_NV,THOI_DIEM_LAP)\r\n"
					+ "VALUES (?,?,?);";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, t.getMaPX());
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
	public int capNhap(PhieuXuat t) {
		int check = 0;
		try {
			Connection con = new ConnectDatabase().getConnection();
			Statement st = con.createStatement();

			String sql = "UPDATE phieu_xuat\r\n" + "SET " + "MA_NV= ?, " + "THOI_DIEM_LAP= ? "
					+ "WHERE MA_PX = ?";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, t.getMaNV());
			prep.setDate(2, t.getDate());
			prep.setString(3, t.getMaPX());
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
	public int xoa(PhieuXuat t) {
		int check = 0;
		try {
			Connection con = new ConnectDatabase().getConnection();
			Statement st = con.createStatement();
			String sql = "DELETE FROM phieu_xuat " + "WHERE MA_PX = '" + t.getMaPX() + "';";
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
	public ArrayList<PhieuXuat> selectAll() {
		ArrayList<PhieuXuat> listPX = new ArrayList<>();
		try {
			Connection con = new ConnectDatabase().getConnection();
			String sql = "SELECT * FROM phieu_xuat";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				PhieuXuat px = new PhieuXuat();
				px.setMaPX(rs.getString(1));
				px.setMaNV(rs.getString(2));
				px.setDate(rs.getDate(3));
				listPX.add(px);
			}
			ConnectDatabase.closeConnection(con);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;

		}
		return listPX;
	}

	@Override
	public PhieuXuat selectById(PhieuXuat t) {
		PhieuXuat phieuXuat = null;
		try {
			Connection con = new ConnectDatabase().getConnection();
			String sql = "SELECT * FROM phieu_xuat WHERE MA_PX='" + t.getMaPX() + "'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				PhieuXuat px = new PhieuXuat();
				px.setMaPX(rs.getString(1));
				px.setMaNV(rs.getString(2));
				px.setDate(rs.getDate(3));
				phieuXuat = px;
			}
			ConnectDatabase.closeConnection(con);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;

		}
		return phieuXuat;
	}

	@Override
	public ArrayList<PhieuXuat> selectBy(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
