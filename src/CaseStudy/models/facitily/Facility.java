package CaseStudy.models.facitily;

public abstract class Facility {
    protected static int id=1000;
    protected String facilityID;
    protected String facilityName;
    protected double usableArea;
    protected int rentalCosts;
    protected int numberMaxPerson;
    protected String rentalType;

    public Facility() {
    }

    public Facility(String facilityName, double dienTich, int rentalCosts, int numberMaxPerson, String rentalType) {
        this.facilityName = facilityName;
        this.usableArea = dienTich;
        this.rentalCosts = rentalCosts;
        this.numberMaxPerson = numberMaxPerson;
        this.rentalType = rentalType;
        String maHoa="SV";
        if(facilityName.equalsIgnoreCase("Villa")) maHoa+="VL";
        else
        if(facilityName.equalsIgnoreCase("Room")) maHoa+="RO";
        else
        if(facilityName.equalsIgnoreCase("House")) maHoa+="HO";
        facilityID =maHoa+"-"+(++id);
    }

    public Facility(String facilityID, String facilityName, double usableArea, int rentalCosts, int numberMaxPerson, String rentalType) {
        this.facilityID = facilityID;
        this.facilityName = facilityName;
        this.usableArea = usableArea;
        this.rentalCosts = rentalCosts;
        this.numberMaxPerson = numberMaxPerson;
        this.rentalType = rentalType;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public int getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(int rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getNumberMaxPerson() {
        return numberMaxPerson;
    }

    public void setNumberMaxPerson(int numberMaxPerson) {
        this.numberMaxPerson = numberMaxPerson;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Facility.id = id;
    }

    public String getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(String facilityID) {
        this.facilityID = facilityID;
    }
}
