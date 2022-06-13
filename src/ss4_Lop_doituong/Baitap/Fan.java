package ss4_Lop_doituong.Baitap;

public class Fan {
    private final int SLOW=1, MEDIUM=2, FAST=3;
    private boolean on;
    private int speed;
    private double radius;
    private String color;

    public Fan() {
        speed=0;
        on=false;
        radius=5;
        color="blue";
    }

    public Fan(boolean on, int speed, double radius, String color) {
        this.on = on;
        this.speed = speed;
        this.radius = radius;
        this.color = color;
        if(on==false) speed=0;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
        if (on==true) this.speed=this.SLOW;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        String str="fan is on";
        if(this.on==false) str="fan is off";
        return "Fan{ on=" + on +
                ", speed=" + speed +
                ", radius=" + radius +
                ", color='" + color + '\'' +
                ", "+str+" "+
                '}';
    }
}
