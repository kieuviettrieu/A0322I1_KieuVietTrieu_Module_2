package CaseStudy.models.facitily;

public class Room extends Facility {
    private String serviceFree;

    public Room() {
    }

    public Room(String serviceFree) {
        this.serviceFree = serviceFree;
    }

    public Room(String tenDichVu, double dienTich, int chiPhiThue, int soNguoiToiDa, String kieuThue, String serviceFree) {
        super(tenDichVu, dienTich, chiPhiThue, soNguoiToiDa, kieuThue);
        this.serviceFree = serviceFree;
    }

    public Room(String idDichVu, String tenDichVu, double dienTichSuDung, int chiPhiThue, int soNguoiToiDa, String kieuThue, String serviceFree) {
        super(idDichVu, tenDichVu, dienTichSuDung, chiPhiThue, soNguoiToiDa, kieuThue);
        this.serviceFree = serviceFree;
    }

    public String getServiceFree() {
        return serviceFree;
    }

    public void setServiceFree(String serviceFree) {
        this.serviceFree = serviceFree;
    }

    @Override
    public String toString() {
        return  facilityID +
                ";" + facilityName +
                ";" + usableArea +
                ";" + rentalCosts +
                ";" + numberMaxPerson +
                ";" + rentalType +
                ";" + serviceFree;
    }
}
