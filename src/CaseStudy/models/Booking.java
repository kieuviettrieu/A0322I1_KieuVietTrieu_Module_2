package CaseStudy.models;

import CaseStudy.services.BookingService;

import java.util.Date;

public class Booking implements BookingService {
    private int maBooking;
    private Date firstDate;
    private Date lastDate;
    private int maKhachHanh;
    private String tenDichVu;
    private String loaiDichVu;

    public Booking() {
    }

    public Booking(int maBooking, Date firstDate, Date lastDate, int maKhachHanh, String tenDichVu, String loaiDichVu) {
        this.maBooking = maBooking;
        this.firstDate = firstDate;
        this.lastDate = lastDate;
        this.maKhachHanh = maKhachHanh;
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

    public int getMaKhachHanh() {
        return maKhachHanh;
    }

    public void setMaKhachHanh(int maKhachHanh) {
        this.maKhachHanh = maKhachHanh;
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

    @Override
    public String toString() {
        return "Booking{" +
                "maBooking=" + maBooking +
                ", firstDate=" + firstDate +
                ", lastDate=" + lastDate +
                ", maKhachHanh=" + maKhachHanh +
                ", tenDichVu='" + tenDichVu + '\'' +
                ", loaiDichVu='" + loaiDichVu + '\'' +
                '}';
    }

    @Override
    public void createNewConstracts() {

    }

    @Override
    public void disPlayContracts() {

    }

    @Override
    public void editConstract() {

    }

    @Override
    public void addNew() {

    }

    @Override
    public void disPlay() {

    }
}
