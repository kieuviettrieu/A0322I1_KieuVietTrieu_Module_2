package CaseStudy.models;

import CaseStudy.utils.DateException;

import java.util.Date;

public class Booking implements Comparable<Booking>{
    private int maBooking;
    private Date firstDate;
    private Date lastDate;
    private int maKhachHang;
    private String tenDichVu;
    private String loaiDichVu;

    public Booking() {
    }

    public Booking(int maBooking, Date firstDate, Date lastDate, int maKhachHang, String tenDichVu, String loaiDichVu) {
        this.maBooking = maBooking;
        this.firstDate = firstDate;
        this.lastDate = lastDate;
        this.maKhachHang = maKhachHang;
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

    public String getLoaiDichVu() {
        return loaiDichVu;
    }

    public void setLoaiDichVu(String loaiDichVu) {
        this.loaiDichVu = loaiDichVu;
    }

    public String getDay()
    {
        return DateException.simpleDateFormatDay.format(firstDate);
    }

    public String getMonth()
    {
        return DateException.simpleDateFormatMonth.format(firstDate);
    }

    public String getYear()
    {
        return DateException.simpleDateFormatYear.format(firstDate);
    }

    @Override
    public String toString() {
        return  maBooking +
                ";" + DateException.simpleDateFormat.format(firstDate) +
                ";" + DateException.simpleDateFormat.format(lastDate) +
                ";" + maKhachHang +
                ";" + tenDichVu +
                ";" + loaiDichVu;
    }

    @Override
    public int compareTo(Booking o) {
        return this.getFirstDate().compareTo(o.getFirstDate());
    }
}
