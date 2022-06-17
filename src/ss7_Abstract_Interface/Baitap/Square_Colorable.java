package ss7_Abstract_Interface.Baitap;

public class Square_Colorable extends Square implements Colorable{
    @Override
    public void howToColor() {
        System.out.println(" Color all four sides...");
    }

    public Square_Colorable() {
    }

    public Square_Colorable(double side) {
        super(side);
    }

    public Square_Colorable(double side, String color, boolean filled) {
        super(side, color, filled);
    }
}
