package CaseStudy.models;

import CaseStudy.services.Impl.BookingServiceImpl;

import java.util.Comparator;
import java.util.Date;

public class Contract implements Comparable<Contract>{
    private int soHopDong;
    private int maBooking;
    private double tienCoc;
    private double tienThanhToan;
    private int maKhachHang;

    public Contract() {
    }

    public Contract(int soHopDong, int maBooking, double tienCoc, double tienThanhToan, int maKhachHang) {
        this.soHopDong = soHopDong;
        this.maBooking = maBooking;
        this.tienCoc = tienCoc;
        this.tienThanhToan = tienThanhToan;
        this.maKhachHang = maKhachHang;
    }

    public int getSoHopDong() {
        return soHopDong;
    }

    public void setSoHopDong(int soHopDong) {
        this.soHopDong = soHopDong;
    }

    public int getMaBooking() {
        return maBooking;
    }

    public void setMaBooking(int maBooking) {
        this.maBooking = maBooking;
    }

    public double getTienCoc() {
        return tienCoc;
    }

    public void setTienCoc(double tienCoc) {
        this.tienCoc = tienCoc;
    }

    public double getTienThanhToan() {
        return tienThanhToan;
    }

    public void setTienThanhToan(double tienThanhToan) {
        this.tienThanhToan = tienThanhToan;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    @Override
    public String toString() {
        return  soHopDong +
                ";" + maBooking +
                ";" + tienCoc +
                ";" + tienThanhToan +
                ";" + maKhachHang;
    }

    @Override
    public int compareTo(Contract o) {
        int maBook=o.getMaBooking();
        Date date=BookingServiceImpl.searchBooking(maBook).getFirstDate();
        Date date1=BookingServiceImpl.searchBooking(maBooking).getFirstDate();
        return date1.compareTo(date);
    }
}
