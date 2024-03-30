/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class NhaCungCapDTO {
    private String MaNcc, TenNcc,Diachi,Dienthoai;
    public NhaCungCapDTO()
    {
        
    }

    public NhaCungCapDTO(String MaNcc, String TenNcc, String Diachi, String Dienthoai) {
        this.MaNcc = MaNcc;
        this.TenNcc = TenNcc;
        this.Diachi = Diachi;
        this.Dienthoai = Dienthoai;
    }

    public String getMaNcc() {
        return MaNcc;
    }

    public void setMaNcc(String MaNcc) {
        this.MaNcc = MaNcc;
    }

    public String getTenNcc() {
        return TenNcc;
    }

    public void setTenNcc(String TenNcc) {
        this.TenNcc = TenNcc;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public String getDienthoai() {
        return Dienthoai;
    }

    public void setDienthoai(String Dienthoai) {
        this.Dienthoai = Dienthoai;
    }
    
}
