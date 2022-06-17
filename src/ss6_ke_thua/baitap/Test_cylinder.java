package ss6_ke_thua.baitap;

public class Test_cylinder {
    public static void main(String[] args) {
        Cylinder cylinder=new Cylinder(3.5,"Black",4);
        System.out.println("Diện tích đáy: "+cylinder.area());
        System.out.println("Thể tích hình trụ: "+cylinder.theTich());
        System.out.println(cylinder.toString());
    }
}
