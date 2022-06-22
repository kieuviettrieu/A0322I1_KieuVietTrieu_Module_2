package ss11_stack_queue.Baitap;

public class NhanSu {
    private String fullName;
    private String set;
    private String birthDay;

    public NhanSu() {
    }

    public NhanSu(String fullName, String set, String birthDay) {
        this.fullName = fullName;
        this.set = set;
        this.birthDay = birthDay;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "Họ tên: "+fullName +
                ", Giới tính:" + set  +
                ", Ngày sinh: " + birthDay;
    }
}
