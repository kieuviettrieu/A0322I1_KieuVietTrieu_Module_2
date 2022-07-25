package CaseStudy.models;

import CaseStudy.utils.DateException;

import java.util.Date;

public class Booking implements Comparable<Booking>{
    private int bookingCode;
    private Date firstDate;
    private Date lastDate;
    private int customerCode;
    private String facilityName;
    private String facilityType;

    public Booking() {
    }

    public Booking(int bookingCode, Date firstDate, Date lastDate, int customerCode, String facilityName, String facilityType) {
        this.bookingCode = bookingCode;
        this.firstDate = firstDate;
        this.lastDate = lastDate;
        this.customerCode = customerCode;
        this.facilityName = facilityName;
        this.facilityType = facilityType;
    }

    public int getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(int bookingCode) {
        this.bookingCode = bookingCode;
    }

    public Date getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public int getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    public String getDay()
    {
        return DateException.simpleDateFormatDay.format(firstDate);
    }

    public String getMonth()
    {
        return DateException.simpleDateFormatMonth.format(firstDate);
    }

    public String getYear()
    {
        return DateException.simpleDateFormatYear.format(firstDate);
    }

    @Override
    public String toString() {
        return  bookingCode +
                "," + DateException.simpleDateFormat.format(firstDate) +
                "," + DateException.simpleDateFormat.format(lastDate) +
                "," + customerCode +
                "," + facilityName +
                "," + facilityType;
    }

    public String toInfomation()
    {
        return   "ID:"+bookingCode+", First day:"+DateException.simpleDateFormat.format(firstDate)
                +", End day:"+DateException.simpleDateFormat.format(lastDate)+", Customer code:"+customerCode
                +", Facility: "+facilityName+"-"+facilityType;
    }

    @Override
    public int compareTo(Booking o) {
        return this.getFirstDate().compareTo(o.getFirstDate());
    }
}
