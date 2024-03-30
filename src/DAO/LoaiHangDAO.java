//package DAO;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//import DTO.HoaDon;
//import DTO.LoaiHangDTO;
//
//public class LoaiHangDAO implements DaoInterface<LoaiHangDTO>{
//
//	public static LoaiHangDAO getIntance() {
//		return new LoaiHangDAO();
//	}
//	@Override
//	public int them(LoaiHangDTO t) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int capNhap(LoaiHangDTO t) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int xoa(LoaiHangDTO t) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public ArrayList<LoaiHangDTO> selectAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public LoaiHangDTO selectById(LoaiHangDTO t) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ArrayList<LoaiHangDTO> selectBy(String condition) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//	public ArrayList<String> selectByChungLoai(String maChungLoai) {
//		ArrayList<String> listTenLoaiHang = new ArrayList<>();
//        try {
//        	Connection con=new ConnectDatabase().getConnection();
//            String sql = "SELECT MA_LH, TEN FROM loai_hang WHERE MA_CL = '"+maChungLoai+"'";
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//            	String s=rs.getString(1)+" - "+rs.getString(2);
//            	listTenLoaiHang.add(s);
//            }
//            ConnectDatabase.closeConnection(con);
//        } catch (SQLException ex) {
//        	ex.printStackTrace();
//            return null;
//            
//        }
//		return listTenLoaiHang;
//	}
//
//}
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
import DTO.LoaiHangDTO;
import java.sql.Connection;

public class LoaiHangDAO implements DaoInterface<LoaiHangDTO>{

    public static LoaiHangDAO getIntance() {
		return new LoaiHangDAO();
	}
    @Override
    public int them(LoaiHangDTO t) {
        int result=0; 
        try{
            Connection con= (Connection) new ConnectDatabase().getConnection();
            String sql="INSERT INTO loai_hang VALUES (?,?,?)";
            PreparedStatement prep= con.prepareStatement(sql);
            prep.setString(1,t.getMaLH());
            prep.setString(2,t.getTenLH());
            prep.setString(3,t.getMaCL());
            result=prep.executeUpdate();
            if(result>0)
                result=1;
            else
                result=0;
            ConnectDatabase.closeConnection(con);
        }catch(Exception ex)
        {
            return 0;
        }
        return result;
    }

    @Override
    public int capNhap(LoaiHangDTO t) {
        int result=0;
        try {
            Connection con= (Connection) new ConnectDatabase().getConnection();
            String sql= "UPDATE loai_hang SET TEN=?, MA_CL=? WHERE MA_LH=?";
            PreparedStatement prep=con.prepareStatement(sql);
              prep.setString(1,t.getMaLH());
            prep.setString(2,t.getTenLH());
            prep.setString(3,t.getMaCL());
            result=prep.executeUpdate();
            if(result>0)
                result=1;
            else
                result=0;
            ConnectDatabase.closeConnection(con);
        }catch(Exception ex)
        {
            ex.getStackTrace();
            return 0;
        }
        return result;
    }

    @Override
    public int xoa(LoaiHangDTO t) {
        int result=0; 
        try {
            Connection con= (Connection) new ConnectDatabase().getConnection();
            String sql="DELETE FROM loai_hang WHERE MA_LH=?";
            PreparedStatement prep= con.prepareStatement(sql);
              prep.setString(1,t.getMaLH());
            result=prep.executeUpdate();
            if(result>0)
                result=1;
            else
                result=0;
            ConnectDatabase.closeConnection(con);
        }catch(Exception ex)
        {
            return 0;
        }
        return result;
    }

    @Override
    public ArrayList<LoaiHangDTO> selectAll() {
         int result=0;
        try {
            Connection con= (Connection) new ConnectDatabase().getConnection();
            ArrayList<LoaiHangDTO> dslh= new ArrayList<>();
            String sql= "SELECT * from loai_hang";
            Statement stmt=con.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                LoaiHangDTO lh= new LoaiHangDTO();
                lh.setMaLH(rs.getString(1));
                lh.setTenLH(rs.getString(2));
                lh.setMaCL(rs.getString(3));
                dslh.add(lh);
            }
            ConnectDatabase.closeConnection(con);
            return dslh;
        }catch(Exception ex)
        {
            return null;
        }
    }

    @Override
    public LoaiHangDTO selectById(LoaiHangDTO t) {
        LoaiHangDTO lh= null;
        try {
            Connection con = (Connection) new ConnectDatabase().getConnection();
            String sql="SELECT * from loai_hang WHERE MA_LH='"+t.getMaLH()+"'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                lh = new LoaiHangDTO();
                lh.setMaLH(rs.getString(1));
                lh.setTenLH(rs.getString(2));
                lh.setMaCL(rs.getString(3));
            }
            ConnectDatabase.closeConnection(con);
        }catch(Exception ex)
        {
            return null;
        }
        return lh;
    }

    @Override
    public ArrayList<LoaiHangDTO> selectBy(String condition) {
        return null;
    }
    public ArrayList<String> selectByChungLoai(String maChungLoai) {
		ArrayList<String> listTenLoaiHang = new ArrayList<>();
        try {
        	Connection con=new ConnectDatabase().getConnection();
            String sql = "SELECT MA_LH, TEN FROM loai_hang WHERE MA_CL = '"+maChungLoai+"'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	String s=rs.getString(1)+" - "+rs.getString(2);
            	listTenLoaiHang.add(s);
            }
        } catch (SQLException ex) {
        	ex.printStackTrace();
            return null;
            
        }
		return listTenLoaiHang;
	}
    
}

