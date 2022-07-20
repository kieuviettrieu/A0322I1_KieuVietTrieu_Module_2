package CaseStudy.models.person;

import CaseStudy.utils.DateException;

import java.util.Date;

public class Customer extends Person {
    private int customerCode;
    private String typeOfGuest;
    private String address;

    public Customer() {
    }

    public Customer(int customerCode, String typeOfGuest, String address) {
        this.customerCode = customerCode;
        this.typeOfGuest = typeOfGuest;
        this.address = address;
    }

    public Customer(int customerCode, String hoTen, Date ngaysinh, String gioiTinh, String soDienThoai, String email, String soCCCD, String typeOfGuest, String address) {
        super(hoTen, ngaysinh, gioiTinh, soDienThoai, email, soCCCD);
        this.customerCode = customerCode;
        this.typeOfGuest = typeOfGuest;
        this.address = address;
    }

    public int getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    public String getTypeOfGuest() {
        return typeOfGuest;
    }

    public void setTypeOfGuest(String typeOfGuest) {
        this.typeOfGuest = typeOfGuest;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return customerCode +
                ";" + typeOfGuest +
                ";" + address +
                ";" + fullName +
                ";" + DateException.simpleDateFormat.format(birthDay) +
                ";" + gender +
                ";" + phoneNumber +
                ";" + email +
                ";" + numberCCCD;
    }

    public String toInfomation()
    {
        return  "maKhachHang:" + customerCode +
                ", loaiKhach:" + typeOfGuest +
                ", diaChi:" + address +
                ", hoTen:" + fullName +
                ", ngaysinh:" + birthDay +
                ", gioiTinh:" + gender +
                ", soDienThoai:" + phoneNumber +
                ", email:" + email +
                ", soCCCD:" + numberCCCD;
    }
}
