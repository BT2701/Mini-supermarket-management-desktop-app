package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.HoaDon;
import DTO.PhieuKiemKe;

public class PhieuKiemKeDAO implements DaoInterface<PhieuKiemKe> {

	public static PhieuKiemKeDAO getIntance() {
		return new PhieuKiemKeDAO();
	}

	@Override
	public int them(PhieuKiemKe t) {
		int check = 0;
		try {
			Connection con = new ConnectDatabase().getConnection();
			Statement st = con.createStatement();

			String sql = "INSERT INTO phieu_kiem_ke(MA_PKK,MA_NV,THOI_DIEM_LAP)\r\n"
					+ "VALUES (?,?,?);";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, t.getMaPkk());
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
	public int capNhap(PhieuKiemKe t) {
		int check = 0;
		try {
			Connection con = new ConnectDatabase().getConnection();
			Statement st = con.createStatement();

			String sql = "UPDATE phieu_kiem_ke\r\n" + "SET " + "MA_NV= ?, " + "THOI_DIEM_LAP= ? "
					+ "WHERE MA_PKK = ?";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, t.getMaNV());
			prep.setDate(2, t.getDate());
			prep.setString(3, t.getMaPkk());
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
	public int xoa(PhieuKiemKe t) {
		// TODO Auto-generated method stub
		int check = 0;
		try {
			Connection con = new ConnectDatabase().getConnection();
			Statement st = con.createStatement();
			String sql = "DELETE FROM phieu_kiem_ke " + "WHERE MA_PKK = '" + t.getMaPkk() + "';";
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
	public ArrayList<PhieuKiemKe> selectAll() {
		ArrayList<PhieuKiemKe> listPKK = new ArrayList<>();
		try {
			Connection con = new ConnectDatabase().getConnection();
			String sql = "SELECT * FROM phieu_kiem_ke";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				PhieuKiemKe pkk = new PhieuKiemKe();
				pkk.setMaPkk(rs.getString(1));
				pkk.setMaNV(rs.getString(2));
				pkk.setDate(rs.getDate(3));
				listPKK.add(pkk);
			}
			ConnectDatabase.closeConnection(con);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;

		}
		return listPKK;
	}

	@Override
	public PhieuKiemKe selectById(PhieuKiemKe t) {
		PhieuKiemKe phieukk = null;
		try {
			Connection con = new ConnectDatabase().getConnection();
			String sql = "SELECT * FROM phieu_kiem_ke WHERE MA_PKK='" + t.getMaPkk() + "'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				PhieuKiemKe pkk = new PhieuKiemKe();
				pkk.setMaPkk(rs.getString(1));
				pkk.setMaNV(rs.getString(2));
				pkk.setDate(rs.getDate(3));
				phieukk = pkk;
			}
			ConnectDatabase.closeConnection(con);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;

		}
		return phieukk;
	}

	@Override
	public ArrayList<PhieuKiemKe> selectBy(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
