package ss17_IO_Binary_File.baitap;

import ss17_IO_Binary_File.thuchanh.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainSanPham {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<SanPham> sanPhams=readDataFromFile("productMain.txt");
        while (true)
        {
            System.out.println("1.Thêm sản phẩm");
            System.out.println("2.Hiển thị danh sách sản phẩm");
            System.out.println("3.Tìm kiếm thông tin sản phẩm");
            System.out.println("0.Exit");
            System.out.print("Chọn chức năng: ");
            int goTo=scanner.nextInt();
            switch (goTo)
            {
                case 1:
                    System.out.println("Nhập thông tin sản phẩm: ");
                    System.out.print("Nhập id: ");
                    int id=scanner.nextInt();
                    System.out.print("Nhập tên sản phẩm: ");
                    String charnext=scanner.nextLine();
                    String name=scanner.nextLine();
                    System.out.print("Nhập hãn sản xuất: ");
                    String product=scanner.nextLine();
                    System.out.print("Nhập giá: ");
                    double price=scanner.nextDouble();
                    System.out.print("Mô tả khác: ");
                    charnext=scanner.nextLine();
                    String otherDescription=scanner.nextLine();
                    SanPham sanPham=new SanPham(id,name,product,price,otherDescription);
                    sanPhams.add(sanPham);
                    addProduct(sanPhams,"productMain.txt");
                    System.out.println();
                    break;
                case 2:
                    disPlay(sanPhams);
                    break;
                case 3:
                    System.out.println("Nhập tên sản phẩm cần tim: ");
                    String charNext=scanner.nextLine();
                    String nameSearch=scanner.nextLine();
                    SanPham sanPham1=search(sanPhams,nameSearch);
                    if(sanPham1==null)
                    {
                        System.out.println("Không tìm thấy sản phẩm!");
                    }
                    else
                    {
                        System.out.println(sanPham1);
                    }
                    System.out.println();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }

    public static void addProduct(List<SanPham> sanPham,String path)
    {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(sanPham);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<SanPham> readDataFromFile(String path){
        List<SanPham> sanPhams = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            sanPhams=(List<SanPham>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return sanPhams;
    }

    public static void disPlay(List<SanPham> sanPhamList)
    {
        System.out.println("Danh sách sản phẩm: ");
        for (SanPham sanPham:sanPhamList)
        {
            System.out.println(sanPham);
        }
        System.out.println();
    }

    public static SanPham search(List<SanPham> sanPhamList,String name)
    {
        for (SanPham sanPham:sanPhamList)
        {
            if(sanPham.getName().equalsIgnoreCase(name))
            {
                return sanPham;
            }
        }
        return null;
    }
}
