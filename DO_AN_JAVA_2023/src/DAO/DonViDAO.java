//package DAO;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//import DTO.DonViDTO;
//import DTO.HoaDon;
//
//public class DonViDAO implements DaoInterface<DonViDTO>{
//
//	public static DonViDAO getIntance() {
//		return new DonViDAO();
//	}
//	@Override
//	public int them(DonViDTO t) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int capNhap(DonViDTO t) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int xoa(DonViDTO t) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public ArrayList<DonViDTO> selectAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public DonViDTO selectById(DonViDTO t) {
//		DonViDTO donvi=null;
//        try {
//        	Connection con=new ConnectDatabase().getConnection();
//            String sql = "SELECT * FROM don_vi WHERE MA_DVT ='"+t.getMaDVT()+"'";
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//            	DonViDTO dv = new DonViDTO();
//            	dv.setMaDVT(rs.getString(1));
//            	dv.setTenDVT(rs.getString(2));
//                donvi=dv;
//            }
//            ConnectDatabase.closeConnection(con);
//        } catch (SQLException ex) {
//        	ex.printStackTrace();
//            return null;
//            
//        }
//		return donvi;
//	}
//
//	@Override
//	public ArrayList<DonViDTO> selectBy(String condition) {
//		// TODO Auto-generated method stub
//		return null;
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
import java.sql.Connection;
import DTO.DonViDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DonViDAO implements DaoInterface<DonViDTO>{
    public static DonViDAO getIntance() {
		return new DonViDAO();
	}
    @Override
    public int them(DonViDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int capNhap(DonViDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int xoa(DonViDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DonViDTO> selectAll() {
         try {
        	Connection con=new ConnectDatabase().getConnection();
                ArrayList<DonViDTO> listdv = new ArrayList<>();
            String sql = "SELECT * FROM don_vi";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	DonViDTO dv = new DonViDTO();
            	dv.setMaDVT(rs.getString(1));
            	dv.setTenDVT(rs.getString(2));
                listdv.add(dv);
            }
            ConnectDatabase.closeConnection(con);
               return listdv;
        } catch (SQLException ex) {
        	ex.printStackTrace();
        	System.out.println("thất bại");
            return null;        
        }
    }

    @Override
    public DonViDTO selectById(DonViDTO v) {
        DonViDTO donvi=null;
        try {
        	Connection con=new ConnectDatabase().getConnection();
            String sql = "SELECT * FROM don_vi WHERE MA_DVT ='"+v.getMaDVT()+"'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	DonViDTO dv = new DonViDTO();
            	dv.setMaDVT(rs.getString(1));
            	dv.setTenDVT(rs.getString(2));
                donvi=dv;
            }
        } catch (SQLException ex) {
        	ex.printStackTrace();
            return null;
            
        }
		return donvi;
    }

    @Override
    public ArrayList<DonViDTO> selectBy(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

