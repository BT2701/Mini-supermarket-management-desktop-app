package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.ChungLoai;
import DTO.HoaDon;

public class ChungLoaiDAO implements DaoInterface<ChungLoai>{

	public static ChungLoaiDAO getIntance() {
		return new ChungLoaiDAO();
	}
	@Override
	public int them(ChungLoai t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int capNhap(ChungLoai t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int xoa(ChungLoai t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ChungLoai> selectAll() {
		ArrayList<ChungLoai> listcl = new ArrayList<>();
        try {
        	Connection con=new ConnectDatabase().getConnection();
            String sql = "SELECT * FROM chung_loai";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	ChungLoai cl = new ChungLoai();
            	cl.setMaChungLoai(rs.getString(1));
            	cl.setTen(rs.getString(2));
                listcl.add(cl);
            }
            ConnectDatabase.closeConnection(con);
        } catch (SQLException ex) {
        	ex.printStackTrace();
            return null;
            
        }
		return listcl;
	}

	@Override
	public ChungLoai selectById(ChungLoai t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ChungLoai> selectBy(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
