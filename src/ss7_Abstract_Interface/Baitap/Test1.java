package ss7_Abstract_Interface.Baitap;

public class Test1 {
    public static void main(String[] args) {
        Circle circle=new Circle(3,"Red",true);
        Square square=new Square(3,"Red",true);
        Rectangle rectangle=new Rectangle(3,5,"Red",true);
        System.out.println("Circle: "+circle.getArea());
        System.out.println("Square"+square.getArea());
        System.out.println("Rectangle: "+rectangle.getArea());

        System.out.println();
        System.out.println("Sau khi tăng 50%");
        circle.resize(50);
        square.resize(50);
        rectangle.resize(50);
        System.out.println("Circle: "+circle.getArea());
        System.out.println("Square"+square.getArea());
        System.out.println("Rectangle: "+rectangle.getArea());
    }
}
