package ss5_Acess_method.Baitap;

public class Testcircle {
    public static void main(String[] args) {
        Circle circle=new Circle();
        System.out.println(circle.getRadius()+" "+circle.getArea());
        circle.setRadius(3);
        System.out.println(circle.getRadius()+" "+circle.getArea());
    }
}
