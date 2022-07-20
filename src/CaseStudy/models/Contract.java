package CaseStudy.models;

import CaseStudy.services.Impl.BookingServiceImpl;

import java.util.Date;

public class Contract implements Comparable<Contract>{
    private int contractCode;
    private int bookingCode;
    private double deposit;
    private double payments;
    private int customerCode;

    public Contract() {
    }

    public Contract(int contractCode, int bookingCode, double deposit, double payments, int customerCode) {
        this.contractCode = contractCode;
        this.bookingCode = bookingCode;
        this.deposit = deposit;
        this.payments = payments;
        this.customerCode = customerCode;
    }

    public int getContractCode() {
        return contractCode;
    }

    public void setContractCode(int contractCode) {
        this.contractCode = contractCode;
    }

    public int getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(int bookingCode) {
        this.bookingCode = bookingCode;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getPayments() {
        return payments;
    }

    public void setPayments(double payments) {
        this.payments = payments;
    }

    public int getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    @Override
    public String toString() {
        return  contractCode +
                ";" + bookingCode +
                ";" + deposit +
                ";" + payments +
                ";" + customerCode;
    }

    @Override
    public int compareTo(Contract o) {
        int maBook=o.getBookingCode();
        Date date=BookingServiceImpl.searchBooking(maBook).getFirstDate();
        Date date1=BookingServiceImpl.searchBooking(bookingCode).getFirstDate();
        return date1.compareTo(date);
    }
}
