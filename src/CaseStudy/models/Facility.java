package CaseStudy.models;

public abstract class Facility {
    protected static int id=1000;
    protected int idDichVu;
    protected String tenDichVu;
    protected double dienTichSuDung;
    protected int chiPhiThue;
    protected int soNguoiToiDa;
    protected String kieuThue;

    public Facility() {
    }

    public Facility(String tenDichVu, double dienTich, int chiPhiThue, int soNguoiToiDa, String kieuThue) {
        this.tenDichVu = tenDichVu;
        this.dienTichSuDung = dienTich;
        this.chiPhiThue = chiPhiThue;
        this.soNguoiToiDa = soNguoiToiDa;
        this.kieuThue = kieuThue;
        idDichVu=++id;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public double getDienTichSuDung() {
        return dienTichSuDung;
    }

    public void setDienTichSuDung(double dienTichSuDung) {
        this.dienTichSuDung = dienTichSuDung;
    }

    public int getChiPhiThue() {
        return chiPhiThue;
    }

    public void setChiPhiThue(int chiPhiThue) {
        this.chiPhiThue = chiPhiThue;
    }

    public int getSoNguoiToiDa() {
        return soNguoiToiDa;
    }

    public void setSoNguoiToiDa(int soNguoiToiDa) {
        this.soNguoiToiDa = soNguoiToiDa;
    }

    public String getKieuThue() {
        return kieuThue;
    }

    public void setKieuThue(String kieuThue) {
        this.kieuThue = kieuThue;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Facility.id = id;
    }
}
