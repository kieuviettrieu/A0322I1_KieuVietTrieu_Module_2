package ss3_mang_phuongthuc.Baitap;

import java.util.Scanner;

public class Gop_mang {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] a,b,c;
        System.out.print("Nhập số phần tử mảng a: ");
        int nA=sc.nextInt();
        a=new int[nA];
        for (int i=0; i<nA; i++)
        {
            System.out.print("Nhập element "+(i+1)+": ");
            a[i]=sc.nextInt();
        }
        System.out.print("Nhập số phần tử mảng b: ");
        int nB=sc.nextInt();
        b=new int[nB];
        for (int i=0; i<nB; i++)
        {
            System.out.print("Nhập element "+i+1+": ");
            b[i]=sc.nextInt();
        }

        c=new int[nA+nB];
        for (int i=0; i<nA; i++)
        {
            c[i]=a[i];
        }
        int vitri=nA;
        for (int i=0; i<nB; i++)
        {
            c[vitri]=b[i];
            vitri++;
        }
        System.out.println("Mảng a:");
        for (int i=0; i<nA; i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println("");
        System.out.println("Mảng b:");
        for (int i=0; i<nB; i++)
        {
            System.out.print(b[i]+" ");
        }
        System.out.println("");
        System.out.println("Mảng c:");
        for (int i=0; i<c.length; i++)
        {
            System.out.print(c[i]+" ");
        }
    }
}
