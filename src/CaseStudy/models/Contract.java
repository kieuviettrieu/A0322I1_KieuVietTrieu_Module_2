package CaseStudy.models;

import CaseStudy.services.ContactService;

public class Contract implements ContactService {
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
        return "Contract{" +
                "soHopDong=" + soHopDong +
                ", maBooking=" + maBooking +
                ", tienCoc=" + tienCoc +
                ", tienThanhToan=" + tienThanhToan +
                ", maKhachHang=" + maKhachHang +
                '}';
    }

    @Override
    public void disPlayUseService() {

    }

    @Override
    public void disPlayGetVoucher() {

    }
}
