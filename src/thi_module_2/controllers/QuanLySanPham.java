package thi_module_2.controllers;

import thi_module_2.models.SanPhamXuatKhau;
import thi_module_2.services.ServicesSanPham;

import java.util.Scanner;

public class QuanLySanPham {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ServicesSanPham servicesSanPham=new ServicesSanPham();
        while (true)
        {
            menu();
            System.out.print("Chọn chức năng: ");
            String goTo=scanner.nextLine();
            switch (goTo)
            {
                case "1":
                    try {
                        servicesSanPham.addNew();
                    }
                    catch (Exception e)
                    {
                        System.out.println("Tạo mới sản phẩm không thành công!");
                    }
                    break;
                case "2":
                    servicesSanPham.delete();
                    break;
                case "3":
                    servicesSanPham.disPlay();
                    break;
                case "4":
                    servicesSanPham.search();
                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng chọn đúng chức năng!");
            }
        }
    }



    private static void menu()
    {
        System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM--");
        System.out.println("Chọn chức năng theo số");
        System.out.println("1.Thêm mới");
        System.out.println("2.Xóa");
        System.out.println("3.Xem danh sách sản phẩm");
        System.out.println("4.Tìm kiếm");
        System.out.println("5.Thoát");
    }
}
