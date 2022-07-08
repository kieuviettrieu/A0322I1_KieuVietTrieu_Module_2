package CaseStudy.models;

import java.util.Date;

public abstract class Person{
    protected String hoTen;
    protected Date ngaysinh;
    protected String gioiTinh;
    protected String soDienThoai;
    protected String email;
    protected String soCCCD;

    public Person() {
    }

    public Person(String hoTen, Date ngaysinh, String gioiTinh, String soDienThoai, String email, String soCCCD) {
        this.hoTen = hoTen;
        this.ngaysinh = ngaysinh;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.soCCCD = soCCCD;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoCCCD() {
        return soCCCD;
    }

    public void setSoCCCD(String soCCCD) {
        this.soCCCD = soCCCD;
    }

    @Override
    public String toString() {
        return "Person{" +
                "hoTen='" + hoTen + '\'' +
                ", ngaysinh=" + ngaysinh +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", email='" + email + '\'' +
                ", soCCCD='" + soCCCD + '\'' +
                '}';
    }
}
