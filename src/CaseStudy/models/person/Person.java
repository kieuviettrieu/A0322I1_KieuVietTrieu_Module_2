package CaseStudy.models.person;

import java.util.Date;

public abstract class Person{
    protected String fullName;
    protected Date birthDay;
    protected String gender;
    protected String phoneNumber;
    protected String email;
    protected String numberCCCD;

    public Person() {
    }

    public Person(String fullName, Date birthDay, String gender, String phoneNumber, String email, String numberCCCD) {
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.numberCCCD = numberCCCD;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumberCCCD() {
        return numberCCCD;
    }

    public void setNumberCCCD(String numberCCCD) {
        this.numberCCCD = numberCCCD;
    }

    @Override
    public String toString() {
        return "Person{" +
                "hoTen='" + fullName + '\'' +
                ", ngaysinh=" + birthDay +
                ", gioiTinh='" + gender + '\'' +
                ", soDienThoai='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", soCCCD='" + numberCCCD + '\'' +
                '}';
    }
}
