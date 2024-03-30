
package DAO;

import DTO.DTO_NhanVien;
import DTO.DTO_NhanVien;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

/**
 *
 * @author phamn
 */
public class NhanVienDAO implements DaoInterface<DTO_NhanVien> {
    
        private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    public static NhanVienDAO getIntance() {
        return new NhanVienDAO();
    }

    @Override
    public int them(DTO_NhanVien t) {
        int check = 0;
        try {
            // Tạo kết nối
            Connection con = new ConnectDatabase().getConnection();

            // Tạo Statement
            Statement st = con.createStatement();

            // Thực thi câu lệnh SQL
            String sql = "INSERT INTO nhan_vien (MA_NV, HO_TEN, NGAY_SINH, PHAI, CMND, DIACHI, DIENTHOAI, NGAY_VAO_LAM, MA_CV)"
                    + "VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1, t.getMaNV());
            prep.setString(2, t.getHoTen());
            prep.setDate(3, t.getDateNgaySinh());
            prep.setString(4, t.getGioiTinh());
            prep.setString(5, t.getCmnd());
            prep.setString(6, t.getDiaChi());
            prep.setString(7, t.getSdt());
            prep.setDate(8, t.getDateNgayVL());
            prep.setString(9, t.getMaCV());

            check = prep.executeUpdate();

            //
            if (check > 0) {
                System.out.println("Thêm dữ liệu thành công");
            } else {
                System.out.println("Thất bại");
            }

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
    public int capNhap(DTO_NhanVien t) {
        int check = 0;
        try {
            // Tạo kết nối
            Connection con = new ConnectDatabase().getConnection();

            // Tạo statement
            Statement st = con.createStatement();

            // Thực thi sql
            String sql = "UPDATE nhan_vien SET HO_TEN = ?, DIACHI = ?, DIENTHOAI = ? WHERE MA_NV = ?;";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1, t.getHoTen());
            prep.setString(2, t.getDiaChi());
            prep.setString(3, t.getSdt());
            prep.setString(4, t.getMaNV());

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
    public int xoa(DTO_NhanVien t) {
        int check = 0;
        try {
            // Tạo kết nối
            Connection con = new ConnectDatabase().getConnection();

            // Tạo statement
            Statement st = con.createStatement();

            // Thực thi sql
            String sql = "DELETE FROM nhan_vien WHERE MA_NV = ?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1, t.getMaNV());

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
    public ArrayList<DTO_NhanVien> selectAll() {
        ArrayList<DTO_NhanVien> danhSachNV = new ArrayList<>();
        try {
            //
            Connection con = new ConnectDatabase().getConnection();
            String sql = "SELECT * FROM nhan_vien";
            Statement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                DTO_NhanVien nv = new DTO_NhanVien();
                nv.setMaNV(rs.getString(1));
                nv.setHoTen(rs.getString(2));
                nv.setNgaySinh(rs.getDate(3));
                nv.setGioiTinh(rs.getString(4));
                nv.setCmnd(rs.getString(5));
                nv.setDiaChi(rs.getString(6));
                nv.setSdt(rs.getString(7));
                nv.setNgayVaoLam(rs.getDate(8));
                nv.setMaCV(rs.getString(9));

                danhSachNV.add(nv);
            }
            ConnectDatabase.closeConnection(con);

        } catch (Exception e) {

        }
        return danhSachNV;
    }

    @Override
    public DTO_NhanVien selectById(DTO_NhanVien t) {
        DTO_NhanVien nv = null;
        try {
            //
            Connection con = new ConnectDatabase().getConnection();
            String sql = " SELECT * FROM nhan_vien WHERE MA_NV = '" + t.getMaNV() + "' ";
            Statement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                nv.setMaNV(rs.getString(1));
                nv.setHoTen(rs.getString(2));
                nv.setNgaySinh(rs.getDate(3));
                nv.setGioiTinh(rs.getString(4));
                nv.setCmnd(rs.getString(5));
                nv.setDiaChi(rs.getString(6));
                nv.setSdt(rs.getString(7));
                nv.setNgayVaoLam(rs.getDate(8));
                nv.setMaCV(rs.getString(9));

                nv = new DTO_NhanVien();

            }
            ConnectDatabase.closeConnection(con);

        } catch (Exception e) {
            return null;
        }
        return nv;
    }

    @Override
    public ArrayList<DTO_NhanVien> selectBy(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public ArrayList<DTO_NhanVien> getDsNV_ngayVaoLam(java.util.Date tuNgay, java.util.Date denNgay) {
        ArrayList<DTO_NhanVien> listNV = new ArrayList<>();
        try {
            Connection con = ConnectDatabase.getConnection();
            String sql = "SELECT * FROM nhan_vien "
                    + "WHERE NGAY_VAO_LAM BETWEEN '" + sdf.format(tuNgay) + "' AND '" + sdf.format(denNgay) + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                DTO_NhanVien nv = new DTO_NhanVien();
                nv.setMaNV(rs.getString(1));
                nv.setHoTen(rs.getString(2));
                nv.setNgaySinh(rs.getDate(3));
                nv.setGioiTinh(rs.getString(4));
                nv.setCmnd(rs.getString(5));
                nv.setDiaChi(rs.getString(6));
                nv.setSdt(rs.getString(7));
                nv.setNgayVaoLam(rs.getDate(8));
                nv.setMaCV(rs.getString(9));

                listNV.add(nv);
            }

            ConnectDatabase.closeConnection(con);
        } 
        catch (Exception e) {
            return null;
        }

        return listNV;
    }

}

