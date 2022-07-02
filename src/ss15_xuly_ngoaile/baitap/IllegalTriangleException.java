package ss15_xuly_ngoaile.baitap;

public class IllegalTriangleException extends Exception {
    private double side = 1.0;

    public IllegalTriangleException(double side) {
        super(side>0?side+" >= two combined": side+" <= zero");
    }

    public double getSide1() {
        return side;
    }

}
