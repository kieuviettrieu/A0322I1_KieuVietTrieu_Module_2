package CaseStudy.models;

public class Room extends Facility{
    private String dichVuFree;

    public Room() {
    }

    public Room(String dichVuFree) {
        this.dichVuFree = dichVuFree;
    }

    public Room(String tenDichVu, double dienTich, int chiPhiThue, int soNguoiToiDa, String kieuThue, String dichVuFree) {
        super(tenDichVu, dienTich, chiPhiThue, soNguoiToiDa, kieuThue);
        this.dichVuFree = dichVuFree;
    }

    public Room(String idDichVu, String tenDichVu, double dienTichSuDung, int chiPhiThue, int soNguoiToiDa, String kieuThue, String dichVuFree) {
        super(idDichVu, tenDichVu, dienTichSuDung, chiPhiThue, soNguoiToiDa, kieuThue);
        this.dichVuFree = dichVuFree;
    }

    public String getDichVuFree() {
        return dichVuFree;
    }

    public void setDichVuFree(String dichVuFree) {
        this.dichVuFree = dichVuFree;
    }

    @Override
    public String toString() {
        return  idDichVu +
                ";" + tenDichVu +
                ";" + dienTichSuDung +
                ";" + chiPhiThue +
                ";" + soNguoiToiDa +
                ";" + kieuThue +
                ";" + dichVuFree ;
    }
}
