package ss13_thuat_toan_timkiem.baitap;

import java.util.ArrayList;
import java.util.Scanner;

public class Chuoitanglientiep {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String string=sc.nextLine();
        System.out.println("Chuỗi con tăng dài nhất là: "+chuoiDaiLienTiep(string));
    }

    private static String chuoiDaiLienTiep(String string)
    {
        ArrayList<String> arrayList=new ArrayList<>();
        String chuoiDai=""+string.charAt(0);
        for (int i=1; i<string.length(); i++)
        {
            if(chuoiDai.charAt(chuoiDai.length()-1)<string.charAt(i))
            {
                chuoiDai+=string.charAt(i);
            }
            else
            {
                if(i==string.length()-1)
                {
                    chuoiDai+=string.charAt(i);
                }
                arrayList.add(chuoiDai);
                chuoiDai=""+string.charAt(i);
            }
            if(i==string.length()-1)
            {
                arrayList.add(chuoiDai);
            }
        }
        System.out.println(arrayList);
        chuoiDai=arrayList.get(0);
        for (String str:arrayList)
        {
            if(chuoiDai.length()<str.length())
            {
                chuoiDai=str;
            }
        }
        return chuoiDai;
    }
}
