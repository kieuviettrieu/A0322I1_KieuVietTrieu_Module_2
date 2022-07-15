package CaseStudy.models;

import CaseStudy.services.exception.DateException;

import java.util.Date;

public class Customer extends Person{
    private int maKhachHang;
    private String loaiKhach;
    private String diaChi;

    public Customer() {
    }

    public Customer(int maKhachHang, String loaiKhach, String diaChi) {
        this.maKhachHang = maKhachHang;
        this.loaiKhach = loaiKhach;
        this.diaChi = diaChi;
    }

    public Customer(int maKhachHang,String hoTen, Date ngaysinh, String gioiTinh, String soDienThoai, String email, String soCCCD, String loaiKhach, String diaChi) {
        super(hoTen, ngaysinh, gioiTinh, soDienThoai, email, soCCCD);
        this.maKhachHang = maKhachHang;
        this.loaiKhach = loaiKhach;
        this.diaChi = diaChi;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getLoaiKhach() {
        return loaiKhach;
    }

    public void setLoaiKhach(String loaiKhach) {
        this.loaiKhach = loaiKhach;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }


    @Override
    public String toString() {
        return maKhachHang +
                ";" + loaiKhach +
                ";" + diaChi +
                ";" + hoTen +
                ";" + DateException.simpleDateFormat.format(ngaysinh) +
                ";" + gioiTinh +
                ";" + soDienThoai +
                ";" + email +
                ";" + soCCCD;
    }

    public String toInfomation()
    {
        return  "maKhachHang:" + maKhachHang +
                ", loaiKhach:" + loaiKhach +
                ", diaChi:" + diaChi  +
                ", hoTen:" + hoTen +
                ", ngaysinh:" + ngaysinh +
                ", gioiTinh:" + gioiTinh +
                ", soDienThoai:" + soDienThoai +
                ", email:" + email +
                ", soCCCD:" + soCCCD ;
    }
}
