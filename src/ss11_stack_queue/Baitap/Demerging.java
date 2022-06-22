package ss11_stack_queue.Baitap;

import sun.misc.Queue;

import java.util.*;

public class Demerging {
    public static void main(String[] args) throws InterruptedException {
        Queue<NhanSu> NAM=new Queue<>();
        Queue<NhanSu> NU=new Queue<>();
        Queue<NhanSu> nhanSuQueue=new Queue<>();

        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập số lượng nhân sự: ");
        int n=sc.nextInt();
        String deleteChar=sc.nextLine();
        for (int i=0; i<n; i++)
        {
            System.out.println("Nhập nhân sự thứ "+(i+1));
            System.out.print("Họ tên: ");
            String fullName=sc.nextLine();
            System.out.print("Giới tính: ");
            String set=sc.nextLine();
            System.out.print("Ngày sinh: ");
            String birstDay=sc.nextLine();
            if(set.equalsIgnoreCase("Nam"))
            {
                NAM.enqueue(new NhanSu(fullName,set,birstDay));
            }
            else
            {
                NU.enqueue(new NhanSu(fullName,set,birstDay));
            }
        }

        while (!NU.isEmpty())
        {
            nhanSuQueue.enqueue(NU.dequeue());
        }
        while (!NAM.isEmpty())
        {
            nhanSuQueue.enqueue(NAM.dequeue());
        }

        System.out.println("________________________________________");
        System.out.println("Danh sách nhân viên:");
        while (!nhanSuQueue.isEmpty())
        {
            System.out.println(nhanSuQueue.dequeue().toString());
        }
    }
}
