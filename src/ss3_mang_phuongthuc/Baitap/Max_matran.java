package ss3_mang_phuongthuc.Baitap;

import java.util.Scanner;

public class Max_matran {
    public static void main(String[] args) {
        int[][] a;
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập số phần tử mảng a: ");
        int nA=sc.nextInt();
        a=new int[nA][];
        for (int i=0; i<a.length; i++)
        {
            System.out.print("Nhập số phần tử mảng a["+i+"]: ");
            int ni=sc.nextInt();
            a[i]=new int[ni];
            for (int j=0; j<ni; j++)
            {
                System.out.print("Nhập phần tử a["+i+"]["+j+"]: ");
                a[i][j]=sc.nextInt();
            }
        }

        int max=a[0][0];
        for (int i=0; i<a.length; i++)
        {
            for (int j=0; j<a[i].length; j++)
            {
                if(a[i][j]>max) max=a[i][j];
            }
        }
        System.out.println("Max = "+max);
    }
}
