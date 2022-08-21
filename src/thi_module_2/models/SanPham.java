package thi_module_2.models;

public abstract class SanPham {
    public static int mid=0;
    protected int id;
    protected String maSanPham;
    protected String tenSanPham;
    protected double giaBan;
    protected int soLuong;
    protected String nhaSanXuat;

    public SanPham(String maSanPham, String tenSanPham, double giaBan, int soLuong, String nhaSanXuat) {
        this.id = ++mid;
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.nhaSanXuat = nhaSanXuat;
    }

    public SanPham() {
    }

    public static int getMid() {
        return mid;
    }

    public static void setMid(int mid) {
        SanPham.mid = mid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }
}
