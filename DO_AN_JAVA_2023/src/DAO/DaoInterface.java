package DAO;

import java.util.ArrayList;

public interface DaoInterface <T>{
	public int them(T t) ;
	public int capNhap(T t);
	public int xoa(T t);
	public ArrayList<T> selectAll();
	public 	T selectById(T t);
	public ArrayList<T> selectBy(String condition);
	
	
}
