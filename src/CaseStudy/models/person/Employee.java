package CaseStudy.models.person;

import CaseStudy.utils.DateException;

import java.util.Date;

public class Employee extends Person {
    private int employeeCode;
    private String level;
    private String location;
    private double wage;

    public Employee() {
    }

    public Employee(int employeeCode, String level, String location, double wage) {
        this.employeeCode = employeeCode;
        this.level = level;
        this.location = location;
        this.wage = wage;
    }

    public Employee(String hoTen, Date ngaysinh, String gioiTinh, String soDienThoai, String email, String soCCCD, int employeeCode, String level, String location, double wage) {
        super(hoTen, ngaysinh, gioiTinh, soDienThoai, email, soCCCD);
        this.employeeCode = employeeCode;
        this.level = level;
        this.location = location;
        this.wage = wage;
    }

    public int getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(int employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }


    public String toInfomation()
    {
        return   "ID:"+employeeCode+", Level:"+level+", Location:"+location+", Wage:"+wage+", Full name:"+fullName+
                ", Birth day:"+DateException.simpleDateFormat.format(birthDay)+", Gender:"+gender+", Phone number: "+phoneNumber
                +", Email:"+email+", CCCD:"+numberCCCD;
    }

    @Override
    public String toString() {
        return  employeeCode +
                "," + level +
                "," + location +
                "," + wage +
                "," + fullName +
                "," + DateException.simpleDateFormat.format(birthDay) +
                "," + gender +
                "," + phoneNumber +
                "," + email +
                "," + numberCCCD;
    }
}
