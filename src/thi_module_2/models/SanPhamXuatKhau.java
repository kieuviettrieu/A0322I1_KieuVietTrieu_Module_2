package thi_module_2.models;

public class SanPhamXuatKhau extends SanPham{
    public static final String FILE="D:\\Codegym\\module2\\src\\thi_module_2\\data\\sanphamxuatkhau.csv";
    private double giaXuatKhau;
    private String quocGiaNhap;

    public SanPhamXuatKhau() {
    }

    public SanPhamXuatKhau(String maSanPham, String tenSanPham, double giaBan, int soLuong, String nhaSanXuat,
                           double giaXuatKhau, String quocGiaNhap) {
        super(maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat);
        this.giaXuatKhau = giaXuatKhau;
        this.quocGiaNhap = quocGiaNhap;
    }

    public double getGiaXuatKhau() {
        return giaXuatKhau;
    }

    public void setGiaXuatKhau(double giaXuatKhau) {
        this.giaXuatKhau = giaXuatKhau;
    }

    public String getQuocGiaNhap() {
        return quocGiaNhap;
    }

    public void setQuocGiaNhap(String quocGiaNhap) {
        this.quocGiaNhap = quocGiaNhap;
    }

    @Override
    public String toString() {
        return "SanPhamXuatKhau{" +
                "giaXuatKhau=" + giaXuatKhau +
                ", quocGiaNhap='" + quocGiaNhap + '\'' +
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
                giaXuatKhau+","+
                quocGiaNhap;
    }
}
