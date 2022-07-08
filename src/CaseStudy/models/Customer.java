package CaseStudy.models;

import java.util.Date;

public class Customer extends Person implements Comparable<Customer>{
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
        return "ID:" + maKhachHang +
                ", Type:" + loaiKhach +
                ", Address:" + diaChi +
                ", FullName" + hoTen +
                ", Birthday" + ngaysinh +
                ", Set" + gioiTinh +
                ", PhoneNumber" + soDienThoai +
                ", Email:" + email +
                ", CCCD:" + soCCCD ;
    }


    @Override
    public int compareTo(Customer o) {
        return this.hoTen.compareTo(o.getHoTen());
    }
}
