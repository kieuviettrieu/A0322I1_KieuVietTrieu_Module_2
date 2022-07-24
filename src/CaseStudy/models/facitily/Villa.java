package CaseStudy.models.facitily;

public class Villa extends Facility {
    private String villaStandard;
    private double swimPoolArea;
    private int numberOfFloors;

    public Villa() {
    }

    public Villa(String villaStandard, double swimPoolArea, int numberOfFloors) {
        this.villaStandard = villaStandard;
        this.swimPoolArea = swimPoolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public Villa(String tenDichVu, double dienTich, int chiPhiThue, int soNguoiToiDa, String kieuThue, String villaStandard, double swimPoolArea, int numberOfFloors) {
        super(tenDichVu, dienTich, chiPhiThue, soNguoiToiDa, kieuThue);
        this.villaStandard = villaStandard;
        this.swimPoolArea = swimPoolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public Villa(String idDichVu, String tenDichVu, double dienTichSuDung, int chiPhiThue, int soNguoiToiDa, String kieuThue, String villaStandard, double swimPoolArea, int numberOfFloors) {
        super(idDichVu, tenDichVu, dienTichSuDung, chiPhiThue, soNguoiToiDa, kieuThue);
        this.villaStandard = villaStandard;
        this.swimPoolArea = swimPoolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public String getVillaStandard() {
        return villaStandard;
    }

    public void setVillaStandard(String villaStandard) {
        this.villaStandard = villaStandard;
    }

    public double getSwimPoolArea() {
        return swimPoolArea;
    }

    public void setSwimPoolArea(double swimPoolArea) {
        this.swimPoolArea = swimPoolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String toInfomation()
    {
        return   "ID:"+facilityID+", Facility:"+facilityName+", Swimming area:"+swimPoolArea
                + ", Number of floors:"+numberOfFloors+", Villa standard:"+villaStandard+", Usable area:"+usableArea
                +", Rentalc costs:"+rentalCosts+", Max person:" +numberMaxPerson
                + ", Rental type:"+rentalType;
    }

    @Override
    public String toString() {
        return  facilityID +
                ";" + facilityName +
                ";" + swimPoolArea +
                ";" + numberOfFloors +
                ";" + villaStandard +
                ";" + usableArea +
                ";" + rentalCosts +
                ";" + numberMaxPerson +
                ";" + rentalType;
    }
}
