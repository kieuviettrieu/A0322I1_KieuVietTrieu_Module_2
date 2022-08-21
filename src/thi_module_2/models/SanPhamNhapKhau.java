package thi_module_2.models;

public class SanPhamNhapKhau extends SanPham{
    public static final String FILE="D:\\Codegym\\module2\\src\\thi_module_2\\data\\sanphamnhapkhau.csv";
    private double giaNhapKhau;
    private String tinhThanhNhap;
    private double thueNhapKhau;

    public SanPhamNhapKhau() {
    }

    public SanPhamNhapKhau(String maSanPham, String tenSanPham, double giaBan, int soLuong, String nhaSanXuat,
                           double giaNhapKhau, String tinhThanhNhap, double thueNhapKhau) {
        super(maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat);
        this.giaNhapKhau = giaNhapKhau;
        this.tinhThanhNhap = tinhThanhNhap;
        this.thueNhapKhau = thueNhapKhau;
    }

    public double getGiaNhapKhau() {
        return giaNhapKhau;
    }

    public void setGiaNhapKhau(double giaNhapKhau) {
        this.giaNhapKhau = giaNhapKhau;
    }

    public String getTinhThanhNhap() {
        return tinhThanhNhap;
    }

    public void setTinhThanhNhap(String tinhThanhNhap) {
        this.tinhThanhNhap = tinhThanhNhap;
    }

    public double getThueNhapKhau() {
        return thueNhapKhau;
    }

    public void setThueNhapKhau(double thueNhapKhau) {
        this.thueNhapKhau = thueNhapKhau;
    }

    @Override
    public String toString() {
        return "SanPhamNhapKhau{" +
                "giaNhapKhau=" + giaNhapKhau +
                ", tinhThanhNhap='" + tinhThanhNhap + '\'' +
                ", thueNhapKhau='" + thueNhapKhau + '\'' +
                ", id=" + id +
                ", maSanPham='" + maSanPham + '\'' +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", giaBan=" + giaBan +
                ", soLuong=" + soLuong +
                ", nhaSanXuat='" + nhaSanXuat + '\'' +
                '}';
    }

    public String toStringWrite()
    {
        return id+","+
                maSanPham+","+
                tenSanPham+","+
                giaBan+","+
                soLuong+","+
                nhaSanXuat+","+
                giaNhapKhau+","+
                tinhThanhNhap+","+
                thueNhapKhau;
    }
}
