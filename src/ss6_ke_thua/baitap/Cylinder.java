package ss6_ke_thua.baitap;

public class Cylinder extends Circle_{
    private double height=1.0;

    public Cylinder() {
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double theTich()
    {
        return super.area()*this.height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return super.toString()+
                ",height=" + height;
    }
}
