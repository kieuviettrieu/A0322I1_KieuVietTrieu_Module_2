package ss1_javaintroduction.Bai_tap;

import java.util.Scanner;

public class Chuyendoitiente {
    public static void main(String[] args) {
        int rate=23000;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter is money(USD): ");
        long usd=sc.nextLong();
        System.out.println(usd+"USD="+usd*rate+"vnd");
    }
}
