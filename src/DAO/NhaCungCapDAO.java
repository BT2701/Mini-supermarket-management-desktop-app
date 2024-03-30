/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import DTO.NhaCungCapDTO;
import java.sql.Connection;
/**
 *
 * @author Admin
 */
public class NhaCungCapDAO implements DaoInterface<NhaCungCapDTO> {

    @Override
    public int them(NhaCungCapDTO t) {
       int result=0;
       try {
           Connection con=(Connection) new ConnectDatabase().getConnection();
           String sql="INSERT INTO nha_cc VALUES(?,?,?,?)";
           PreparedStatement prep =con.prepareStatement(sql);
           prep.setString(1, t.getMaNcc());
           prep.setString(2,t.getTenNcc());
           prep.setString(3,t.getDiachi());
           prep.setString(4,t.getDienthoai());
           result= prep.executeUpdate() ;
           if(result >0)
               result=1; 
           else 
               result=0;
           ConnectDatabase.closeConnection(con);
       }catch(SQLException ex){
           return 0;
       }
       return result;
    }

    @Override
    public int capNhap(NhaCungCapDTO t) {
        int result = 0;
        try {
            Connection con=(Connection) new ConnectDatabase().getConnection();
            String sql = "UPDATE nha_cc SET TEN=?, DIACHI=?, DIENTHOAI=? WHERE MA_NCC=?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1, t.getTenNcc());
            prep.setString(2, t.getDiachi());
            prep.setString(3, t.getDienthoai());
            prep.setString(4, t.getMaNcc());
            result = prep.executeUpdate() ;
             if(result >0)
               result=1; 
           else 
               result=0;
             ConnectDatabase.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
        return result;
    }

    @Override
    public int xoa(NhaCungCapDTO t) {
        int result= 0;
        try {
            Connection con=(Connection) new ConnectDatabase().getConnection();
            String sql="DELETE FROM nha_cc WHERE MA_NCC=?";
             PreparedStatement prep = con.prepareStatement(sql);
        prep.setString(1, t.getMaNcc());
        result = prep.executeUpdate();
        if (result > 0) {
            result = 1;
        } else {
            result = 0;
        }
        ConnectDatabase.closeConnection(con);
    } catch (SQLException ex) {
        return 0;
    }
        return result;
    }

    @Override
    public ArrayList<NhaCungCapDTO> selectAll() {
        try{
            Connection con= new ConnectDatabase().getConnection();
            ArrayList<NhaCungCapDTO> dsncc= new ArrayList<>();
            String sql="SELECT * from nha_cc";
            Statement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                NhaCungCapDTO ncc = new NhaCungCapDTO();
                ncc.setMaNcc(rs.getString(1));
                ncc.setTenNcc(rs.getString(2));
                ncc.setDiachi(rs.getString(3));
                ncc.setDienthoai(rs.getString(4));
                dsncc.add(ncc);
            }
            ConnectDatabase.closeConnection(con);
            return dsncc;
        }catch (SQLException ex){
            return null;
        }
    }

    @Override
    public NhaCungCapDTO selectById(NhaCungCapDTO v) {
         NhaCungCapDTO ncc = null;
        try {
            Connection con=(Connection) new ConnectDatabase().getConnection();
            String sql = "SELECT * FROM nha_cc WHERE MaNcc='"+v.getMaNcc()+"'" ;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ncc = new NhaCungCapDTO();
                ncc.setMaNcc(rs.getString(1));
                ncc.setTenNcc(rs.getString(2));
                ncc.setDiachi(rs.getString(3));
                ncc.setDienthoai(rs.getString(4));
            }
            ConnectDatabase.closeConnection(con);
        } catch (SQLException ex) {
            return null;
        }
        return ncc;
    }

    @Override
    public ArrayList<NhaCungCapDTO> selectBy(String condition) {
       return null;
    }
    
}
