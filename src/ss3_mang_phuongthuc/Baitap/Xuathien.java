package ss3_mang_phuongthuc.Baitap;

import java.util.Scanner;

public class Xuathien {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str="acbmskdhduert";
        System.out.print("Nhập một ký tự: ");
        String s=sc.nextLine();
        char c=s.charAt(0);
        int count=0;
        for (int i=0; i<str.length(); i++)
        {
            if(str.charAt(i)==c) count++;
        }
        System.out.println("Số lần xuất hiện của kí tự "+c+" là: "+count);
    }
}
