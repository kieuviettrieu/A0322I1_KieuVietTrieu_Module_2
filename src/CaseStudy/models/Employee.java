package CaseStudy.models;

import java.util.Date;

public class Employee extends Person implements Comparable<Employee>{
    private int maNhanVien;
    private String trinhDo;
    private String viTri;
    private double luong;

    public Employee() {
    }

    public Employee(int maNhanVien, String trinhDo, String viTri, double luong) {
        this.maNhanVien = maNhanVien;
        this.trinhDo = trinhDo;
        this.viTri = viTri;
        this.luong = luong;
    }

    public Employee(String hoTen, Date ngaysinh, String gioiTinh, String soDienThoai, String email, String soCCCD, int maNhanVien, String trinhDo, String viTri, double luong) {
        super(hoTen, ngaysinh, gioiTinh, soDienThoai, email, soCCCD);
        this.maNhanVien = maNhanVien;
        this.trinhDo = trinhDo;
        this.viTri = viTri;
        this.luong = luong;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    @Override
    public String toString() {
        return "ID:" + maNhanVien +
                ", Level:" + trinhDo +
                ", Location:" + viTri+
                ", Wage:" + luong +
                ", Fullname:" + hoTen +
                ", Birthday:" + ngaysinh +
                ", Set:" + gioiTinh +
                ", PhoneNumber:" + soDienThoai +
                ", Email" + email +
                ", CCCD:" + soCCCD ;
    }


    @Override
    public int compareTo(Employee o) {
        return this.hoTen.compareTo(o.getHoTen());
    }
}
