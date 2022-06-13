package ss3_mang_phuongthuc.Baitap;

import java.util.Scanner;

public class Sum_cheochinh {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[][] a;
        System.out.print("Nhập ma trận cấp: ");
        int n=sc.nextInt();
        a=new int[n][];
        for (int i=0; i<n; i++)
        {
            a[i]=new int[n];
            for (int j=0; j<n; j++)
            {
                System.out.print("Nhập phần tử a["+i+"]["+j+"]: ");
                a[i][j]=sc.nextInt();
            }
        }
        int Sum=0;
        for (int i=0; i<n; i++) Sum+=a[i][i];
        System.out.println("Tổng đường chéo chính: "+Sum);
    }
}
