/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
public class NhaCungCapBUS {
    private NhaCungCapDAO nhacungcapDAO= new NhaCungCapDAO();
    private ArrayList<NhaCungCapDTO> listNhaCungCap=nhacungcapDAO.selectAll();
    public static NhaCungCapBUS getInstance() {
    	return new NhaCungCapBUS();
    }
    public ArrayList<NhaCungCapDTO> getList()
    {
        
        return listNhaCungCap;
    }
    public void add(NhaCungCapDTO ncc)
    {
        nhacungcapDAO.them(ncc);
    }
    public void sua(NhaCungCapDTO ncc)
    {
        nhacungcapDAO.capNhap(ncc);
    }
    public NhaCungCapDTO getById(NhaCungCapDTO ncc)
    {
        return nhacungcapDAO.selectById(ncc);
    }
     public boolean delete(NhaCungCapDTO ncc) {
        if (ncc.getMaNcc().trim().equals("")) {
            JOptionPane.showMessageDialog(null,"Chưa chọn nhà cung cấp để xóa","ERROR_MESSAGE",1);
            return false;
        }
        if (nhacungcapDAO.xoa(ncc)==1) {
            JOptionPane.showMessageDialog(null,"Xóa thành công","INFORMATION_MESSAGE",2);
            return true;
        }

         JOptionPane.showMessageDialog(null,"Xóa thất bại","ERROR_MESSAGE",1);
        return false;
    }
    public boolean check(String MaNcc)
    {
        for (NhaCungCapDTO ncc:  listNhaCungCap)
        {
            if(ncc.getMaNcc().equals(MaNcc))
            {
                return true;
            }
        }
        return false;
    }
    public ArrayList<String>listTenNCC(){
    	ArrayList<String> list=new ArrayList<>();
    	for (NhaCungCapDTO ncc : getList()) {
			list.add(ncc.getTenNcc());
		}
    	return list;
    }
    public String layMaBangTen(String tenNCC) {
    	String maNCC=null;
    	for (NhaCungCapDTO nhaCungCapDTO : getList()) {
			if(nhaCungCapDTO.getTenNcc().equalsIgnoreCase(tenNCC)) {
				maNCC=nhaCungCapDTO.getMaNcc();
			}
		}
    	return maNCC;
    }
}
