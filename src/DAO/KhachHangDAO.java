
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.DTO_KhachHang;
import DTO.HoaDon;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class KhachHangDAO implements DaoInterface<DTO_KhachHang> {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static KhachHangDAO getIntance() {
        return new KhachHangDAO();
    }

    @Override
    public int them(DTO_KhachHang t) {
        int check = 0;
        try {
            // Tạo kết nối
            Connection con = new ConnectDatabase().getConnection();

            // Tạo statement
            Statement st = con.createStatement();

            // Thực thi sql
            String sql = "INSERT INTO khach_hang_tt (MA_KH, HO_TEN, DIA_CHI, NGAY_CAP_THE, NGAY_MUA_GAN_NHAT, DIEM_THUONG) "
                    + "VALUES (?,?,?,?,?,?);";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1, t.getMaKH());
            prep.setString(2, t.getHoTen());
            prep.setString(3, t.getDiaChi());
            prep.setDate(4, t.getDateNgayCapThe());
            prep.setDate(5, t.getDateNgayMuaGanNhat());
            prep.setDouble(6, t.getDiemThuong());

            check = prep.executeUpdate();

            if (check > 0) {
                System.out.println("thêm dữ liệu thành công");
                JOptionPane.showMessageDialog(null, "Thêm khách hàng mới thành công", "Thông báo", 1);
            } else {
                System.out.println("thất bại 8987");
                JOptionPane.showMessageDialog(null, "Thêm khách hàng mới thất bại", "Thông báo", 1);

            }

            //
//            System.out.println("ban da thucc thi: " + sql);
//            System.out.println("so dong thay doi: " + check);
            //
            ConnectDatabase.closeConnection(con);

        } catch (Exception e) {
            System.out.println("thất bại");
            JOptionPane.showMessageDialog(null, "Khách hàng đã tồn tại. Không thể thêm mới!", "Thông báo", 1);
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public int capNhap(DTO_KhachHang t) {
        int check = 0;
        try {
            // Tạo kết nối
            Connection con = new ConnectDatabase().getConnection();

            // Tạo statement
            Statement st = con.createStatement();

            // Thực thi sql
            String sql = "UPDATE khach_hang_tt SET HO_TEN = ?, DIA_CHI = ? WHERE MA_KH = ?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1, t.getHoTen());
            prep.setString(2, t.getDiaChi());
            prep.setString(3, t.getMaKH());

            check = prep.executeUpdate();
            if (check > 0) {
                System.out.println("Cập nhật dữ liệu thành công");
            } else {
                System.out.println("thất bại");
            }

            //
//            System.out.println("ban da thucc thi: " + sql);
//            System.out.println("so dong thay doi: " + check);
            //
            ConnectDatabase.closeConnection(con);

        } catch (Exception e) {
            System.out.println("thất bại");
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public int xoa(DTO_KhachHang t) {
        int check = 0;
        try {
            // Tạo kết nối
            Connection con = new ConnectDatabase().getConnection();

            // Tạo statement
            Statement st = con.createStatement();

            // Thực thi sql
            String sql = "DELETE FROM khach_hang_tt WHERE MA_KH = ?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1, t.getMaKH());

            check = prep.executeUpdate();
            if (check > 0) {
                System.out.println("Xóa dữ liệu thành công");
            } else {
                System.out.println("thất bại");
            }

            //
//            System.out.println("ban da thucc thi: " + sql);
//            System.out.println("so dong thay doi: " + check);
            //
            ConnectDatabase.closeConnection(con);

        } catch (Exception e) {
            System.out.println("thất bại");
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public ArrayList<DTO_KhachHang> selectAll() {
        ArrayList<DTO_KhachHang> listKH = new ArrayList<>();
        try {
            //
            Connection con = new ConnectDatabase().getConnection();
            String sql = "SELECT * FROM khach_hang_tt";
            Statement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql); //thực thi truy vấn
            while (rs.next()) { //đọc dữ liệu
                DTO_KhachHang kh = new DTO_KhachHang();
                kh.setMaKH(rs.getString(1));
                kh.setHoTen(rs.getString(2));
                kh.setDiaChi(rs.getString(3));
                kh.setNgayCapThe(rs.getDate(4));
                kh.setNgayMuaGanNhat(rs.getDate(5));
                kh.setDiemThuong(rs.getInt(6));

                listKH.add(kh);
            }
            ConnectDatabase.closeConnection(con);
        } catch (Exception e) {
            return null;
        }
        return listKH;
    }

    @Override
    public DTO_KhachHang selectById(DTO_KhachHang t) {
        DTO_KhachHang kh = null;
        try {
            //
            Connection con = new ConnectDatabase().getConnection();
            String sql = " SELECT * FROM khach_hang_tt WHERE MA_KH = '" + t.getMaKH() + "' ";
            Statement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                kh = new DTO_KhachHang();
                kh.setMaKH(rs.getString(1));
                kh.setHoTen(rs.getString(2));
                kh.setDiaChi(rs.getString(3));
                kh.setNgayCapThe(rs.getDate(4));
                kh.setNgayMuaGanNhat(rs.getDate(5));
                kh.setDiemThuong(rs.getInt(6));
            }
            ConnectDatabase.closeConnection(con);

        } catch (Exception e) {
            return null;
        }
        return kh;
    }

    @Override
    public ArrayList<DTO_KhachHang> selectBy(String condition) {

        return null;
    }

   


    public ArrayList<DTO_KhachHang> getDsKH_ngayMuaGanNhat(java.util.Date tuNgay, java.util.Date denNgay) {
        ArrayList<DTO_KhachHang> listKH = new ArrayList<>();
        try {
            Connection con = ConnectDatabase.getConnection();
            String sql = "SELECT * FROM khach_hang_tt "
                    + "WHERE NGAY_MUA_GAN_NHAT BETWEEN '" + sdf.format(tuNgay) + "' AND '" + sdf.format(denNgay) + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                DTO_KhachHang kh = new DTO_KhachHang();
                kh.setMaKH(rs.getString(1));
                kh.setHoTen(rs.getString(2));
                kh.setDiaChi(rs.getString(3));
                kh.setNgayCapThe(rs.getDate(4));
                kh.setNgayMuaGanNhat(rs.getDate(5));
                kh.setDiemThuong(rs.getInt(6));

                listKH.add(kh);
            }

            ConnectDatabase.closeConnection(con);
        } 
        catch (Exception e) {
            return null;
        }

        return listKH;
    }
    public ArrayList<String>getMaVaTenKH(){
		ArrayList<String> listkh = new ArrayList<>();
        try {
        	Connection con=new ConnectDatabase().getConnection();
            String sql = "SELECT MA_KH,HO_TEN FROM khach_hang_tt";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String tt=rs.getString(1)+" - "+rs.getString(2);
                listkh.add(tt);
            }
            ConnectDatabase.closeConnection(con);
        } catch (SQLException ex) {
        	ex.printStackTrace();
            return null;
            
        }
		return listkh;
	}
	public int getDiemThuong(String maKH) {
		int diemThuong=0;
		try {
        	Connection con=new ConnectDatabase().getConnection();
            String sql = "SELECT DIEM_THUONG FROM khach_hang_tt WHERE MA_KH = '"+maKH+"'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                diemThuong=rs.getInt(1);
            }
            ConnectDatabase.closeConnection(con);
        } catch (SQLException ex) {
        	ex.printStackTrace();
            return 0;
            
        }
		return diemThuong;
	}
	public int capNhatDiemThuong(String maKH,int diemThuong) {
		int check=0;
		try {
			Connection con=new ConnectDatabase().getConnection();
			Statement st= con.createStatement();
			
			String sql="UPDATE khach_hang_tt\r\n"
					+ "SET "
					+ "DIEM_THUONG = ? "
					+ "WHERE MA_KH = '"+maKH+"'";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setInt(1, diemThuong);
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
	public int capNhatNgayMuaGanNhat(DTO_KhachHang t) {
		int check=0;
		try {
			Connection con=new ConnectDatabase().getConnection();
			Statement st= con.createStatement();
			
			String sql="UPDATE khach_hang_tt\r\n"
					+ "SET "
					+ "NGAY_MUA_GAN_NHAT = ? "
					+ "WHERE MA_KH = '"+t.getMaKH()+"'";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setDate(1, t.getDateNgayMuaGanNhat());
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
