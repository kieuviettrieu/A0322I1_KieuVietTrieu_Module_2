package ss3_mang_phuongthuc.Baitap;

import java.util.Scanner;

public class Remove_array {
    public static void main(String[] args) {
        int[] array={10,4,6,7,8,6};
        int n=6;
        for (int i=0; i<n; i++)
        {
            System.out.print(array[i]+" ");
        }
        System.out.println("");
        System.out.print("Nhập phần tử cần xóa: ");
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int index=viTri(array,x);

        if(index==-1)
        {
            System.out.println(x+" không tồn tại trong mảng!");
        }
        else
        {
            System.out.println(x+" có vị trí cần xóa: "+index);
            for (int i=index; i<array.length-1; i++)
            {
                array[i]=array[i+1];
            }
            n-=1;
            System.out.println("Sau khi xóa: ");
            for (int i=0; i<n; i++)
            {
                System.out.print(array[i]+" ");
            }
        }

    }

    private static int viTri(int[] array,int x)
    {
        int index=-1;
        for(int i=0; i<array.length; i++)
        {
            if(x==array[i])
            {
                index=i;
                break;
            }
        }
        return index;
    }
}
