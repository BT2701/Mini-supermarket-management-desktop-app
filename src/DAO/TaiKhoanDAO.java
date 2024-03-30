package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.DTO_TaiKhoan;
import DTO.HoaDon;

public class TaiKhoanDAO implements DaoInterface<DTO_TaiKhoan>{
	public static TaiKhoanDAO getInstance() {
		return new TaiKhoanDAO();
	}

	@Override
	public int them(DTO_TaiKhoan t) {
		int check=0;
		try {
			Connection con=new ConnectDatabase().getConnection();
			Statement st= con.createStatement();
			
			String sql="INSERT INTO tai_khoan(MA_NV,TEN_DN,MAT_KHAU,QUYEN,TRANG_THAI,ANH_DAI_DIEN)\r\n"
					+ "VALUES (?,?,?,?,?,?);";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, t.getMaNV());
			prep.setString(2, t.getTenDN());
			prep.setString(3, t.getMatKhau());
			prep.setString(4, t.getQuyen());
			prep.setInt(5, t.getTrangThai());
			prep.setString(6, "./src/IMG/admin.png");
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
	public int capNhap(DTO_TaiKhoan t) {
		int check=0;
		try {
			Connection con=new ConnectDatabase().getConnection();
			Statement st= con.createStatement();
			
			String sql="UPDATE tai_khoan\r\n"
					+ "SET "
					+ "TEN_DN= ?, "
					+ "MAT_KHAU= ?, "
					+ "QUYEN=?, "
					+ "TRANG_THAI=? "
					+ "WHERE MA_NV = ?";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, t.getTenDN());
			prep.setString(2, t.getMatKhau());
			prep.setString(3, t.getQuyen());
			prep.setInt(4, t.getTrangThai());
			prep.setString(5, t.getMaNV());
			
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
	public int xoa(DTO_TaiKhoan t) {
		int check=0;
		try {
			Connection con=new ConnectDatabase().getConnection();
			Statement st= con.createStatement();
			String sql="DELETE FROM tai_khoan "
					+ "WHERE MA_NV = '"+t.getMaNV()+"';";
			check=st.executeUpdate(sql);
			if(check>1)
				System.out.println("thành công");
			
			ConnectDatabase.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public ArrayList<DTO_TaiKhoan> selectAll() {
		ArrayList<DTO_TaiKhoan> listTK = new ArrayList<>();
        try {
        	Connection con=new ConnectDatabase().getConnection();
            String sql = "SELECT * FROM tai_khoan";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	DTO_TaiKhoan TK = new DTO_TaiKhoan();
            	TK.setMaNV(rs.getString(1));
            	TK.setTenDN(rs.getString(2));
            	TK.setMatKhau(rs.getString(3));
            	TK.setQuyen(rs.getString(4));
            	TK.setTrangThai(rs.getInt(5));
            	TK.setHinhAnh(rs.getString(6));
                listTK.add(TK);
            }
            ConnectDatabase.closeConnection(con);
        } catch (SQLException ex) {
        	ex.printStackTrace();
            return null;
            
        }
		return listTK;
	}

	@Override
	public DTO_TaiKhoan selectById(DTO_TaiKhoan t) {
		DTO_TaiKhoan hoaDon=null;
        try {
        	Connection con=new ConnectDatabase().getConnection();
            String sql = "SELECT * FROM tai_khoan WHERE MA_NV='"+t.getMaNV()+"'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                DTO_TaiKhoan hd = new DTO_TaiKhoan();
                hd.setMaNV(rs.getString(1));
                hd.setTenDN(rs.getString(2));
                hd.setMatKhau(rs.getString(3));
                hd.setQuyen(rs.getString(4));
                hd.setTrangThai(rs.getInt(5));
                hd.setHinhAnh(rs.getString(6));
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
	public ArrayList<DTO_TaiKhoan> selectBy(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	public void voHieuHoaTaiKhoan(String maNV) {
		try {
			Connection con=new ConnectDatabase().getConnection();
			Statement st= con.createStatement();
			
			String sql="UPDATE tai_khoan\r\n"
					+ "SET "
					+ "TRANG_THAI=? "
					+ "WHERE MA_NV = ?";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setInt(1, 0);
			prep.setString(2, maNV);
			
			//thuc thi cau lenh sql va tra ve so dong bi thay doi
			int check=prep.executeUpdate();
			//buoc 5 ngat ket noi
			ConnectDatabase.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("thất bại");
			e.printStackTrace();
		}
	}

}
