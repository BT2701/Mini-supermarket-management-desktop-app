package BUS;

import java.util.ArrayList;

public interface BusInterface <T>{
	public ArrayList<T> getList();
	public void saveData(T t);
	public T getByID(T t);
	public void inSert(T t);
	public void upDate(T t);
	public void delete(T t);
	
	
}
