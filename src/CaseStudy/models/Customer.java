package CaseStudy.models;

import CaseStudy.services.CustomerService;

import java.util.Date;

public class Customer extends Person implements CustomerService {
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

    public Customer(String hoTen, Date ngaysinh, String gioiTinh, String soDienThoai, String email, String soCCCD, int maKhachHang, String loaiKhach, String diaChi) {
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
        return "Customer{" +
                "maKhachHang=" + maKhachHang +
                ", loaiKhach='" + loaiKhach + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", ngaysinh=" + ngaysinh +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", email='" + email + '\'' +
                ", soCCCD='" + soCCCD + '\'' +
                '}';
    }

    @Override
    public void editCustomer() {

    }

    @Override
    public void addNew() {

    }

    @Override
    public void disPlay() {

    }
}
