package CaseStudy.models.facitily;

public class House extends Facility {
    private String houseStandard;
    private int numberOfFloors;

    public House() {
    }

    public House(String houseStandard, int numberOfFloors) {
        this.houseStandard = houseStandard;
        this.numberOfFloors = numberOfFloors;
    }

    public House(String tenDichVu, double dienTich, int chiPhiThue, int soNguoiToiDa, String kieuThue, String houseStandard, int numberOfFloors) {
        super(tenDichVu, dienTich, chiPhiThue, soNguoiToiDa, kieuThue);
        this.houseStandard = houseStandard;
        this.numberOfFloors = numberOfFloors;
    }

    public House(String idDichVu, String tenDichVu, double dienTichSuDung, int chiPhiThue, int soNguoiToiDa, String kieuThue, String houseStandard, int numberOfFloors) {
        super(idDichVu, tenDichVu, dienTichSuDung, chiPhiThue, soNguoiToiDa, kieuThue);
        this.houseStandard = houseStandard;
        this.numberOfFloors = numberOfFloors;
    }

    public String getHouseStandard() {
        return houseStandard;
    }

    public void setHouseStandard(String houseStandard) {
        this.houseStandard = houseStandard;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return  facilityID +
                ";" + facilityName +
                ";" + numberOfFloors +
                ";" + houseStandard +
                ";" + usableArea +
                ";" + rentalCosts +
                ";" + numberMaxPerson +
                ";" + rentalType;
    }
}
