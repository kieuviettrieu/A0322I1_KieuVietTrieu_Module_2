package CaseStudy.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking implements Comparable<Booking>{
    private SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
    private int maBooking;
    private Date firstDate;
    private Date lastDate;
    private int maKhachHang;
    private String tenDichVu;
    private int loaiDichVu;

    public Booking() {
    }

    public Booking(int maBooking, Date firstDate, Date lastDate, int maKhachHanh, String tenDichVu, int loaiDichVu) {
        this.maBooking = maBooking;
        this.firstDate = firstDate;
        this.lastDate = lastDate;
        this.maKhachHang = maKhachHanh;
        this.tenDichVu = tenDichVu;
        this.loaiDichVu = loaiDichVu;
    }

    public int getMaBooking() {
        return maBooking;
    }

    public void setMaBooking(int maBooking) {
        this.maBooking = maBooking;
    }

    public Date getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public int getLoaiDichVu() {
        return loaiDichVu;
    }

    public void setLoaiDichVu(int loaiDichVu) {
        this.loaiDichVu = loaiDichVu;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "maBooking=" + maBooking +
                ", firstDate=" + simpleDateFormat.format(firstDate) +
                ", lastDate=" + simpleDateFormat.format(lastDate) +
                ", maKhachHanh=" + maKhachHang +
                ", tenDichVu='" + tenDichVu + '\'' +
                ", loaiDichVu='" + loaiDichVu + '\'' +
                '}';
    }

    @Override
    public int compareTo(Booking o) {
        return this.getFirstDate().compareTo(o.getFirstDate());
    }
}
