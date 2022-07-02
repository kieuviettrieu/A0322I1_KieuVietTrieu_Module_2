package ss15_xuly_ngoaile.baitap;

import java.util.Scanner;

public class TriangleTest {

    public static void main(String[] args) throws IllegalTriangleException {

        Scanner input = new Scanner(System.in);

        Triangle triangle = new Triangle();
        double side1 = 1.0;
        double side2 = 1.0;
        double side3 = 1.0;

        System.out.println("Enter three sides: ");

        try {
            side1 = input.nextDouble();
            side2 = input.nextDouble();
            side3 = input.nextDouble();
            triangle = new Triangle(side1, side2, side3);
            System.out.println(side1+" "+side2+" "+side3+" là ba cạnh của một tam giác!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
