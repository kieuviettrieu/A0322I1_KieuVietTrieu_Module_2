package ss3_mang_phuongthuc.Baitap;

import java.util.Scanner;

public class Sum_cot {
    public static void main(String[] args) {
        float[][] a;
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập số phần tử mảng a: ");
        int nA=sc.nextInt();
        a=new float[nA][];
        for (int i=0; i<a.length; i++)
        {
            System.out.print("Nhập số phần tử mảng a["+i+"]: ");
            int ni=sc.nextInt();
            a[i]=new float[ni];
            for (int j=0; j<ni; j++)
            {
                System.out.print("Nhập phần tử a["+i+"]["+j+"]: ");
                a[i][j]=sc.nextFloat();
            }
        }
        System.out.print("Nhập cột muốn tính tổng: ");
        int cot=sc.nextInt();
        float sum=0;
        for (int i=0; i<a.length; i++)
        {
            if(a[i].length>=cot)
            {
                sum+=a[i][cot-1];
            }
        }
        System.out.println("Sum cột "+cot+" ="+sum);
    }
}
