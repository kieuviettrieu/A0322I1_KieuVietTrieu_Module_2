package ss13_thuat_toan_timkiem.baitap;

import java.util.LinkedList;
import java.util.Scanner;

public class Chuoitang {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhật chuỗi bất kì: ");
        String string=sc.nextLine();
        System.out.println("Chuỗi tăng dài nhất: "+chuoidai(string));
    }

    public static String chuoidai(String string)
    {
        LinkedList<Character> max = new LinkedList<>();

        for (int i = 0; i < string.length(); i++) { //Vòng lặp bên ngoài
            LinkedList<Character> list = new LinkedList<>();

            list.add(string.charAt(i));
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(j) > list.getLast()) {
                    list.add(string.charAt(j));
                }
            }
            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
            list.clear();
        }

        String str="";
        for (Character ch: max) {
            str+=ch;
        }
        return str;
    }

}
