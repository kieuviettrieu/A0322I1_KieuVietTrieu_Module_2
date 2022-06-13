package ss1_javaintroduction.Bai_tap;

import java.util.Scanner;

public class Helloname {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello: " + name);
    }
}
