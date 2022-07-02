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

    @Override
    public String toString() {
        return "Room{" +
                "dichVuFree='" + dichVuFree + '\'' +
                ", tenDichVu='" + tenDichVu + '\'' +
                ", dienTichSuDung=" + dienTichSuDung +
                ", chiPhiThue=" + chiPhiThue +
                ", soNguoiToiDa=" + soNguoiToiDa +
                ", kieuThue='" + kieuThue + '\'' +
                '}';
    }

    @Override
    public void disPlayFMaintenance() {

    }

    @Override
    public void addNew() {

    }

    @Override
    public void disPlay() {

    }
}
