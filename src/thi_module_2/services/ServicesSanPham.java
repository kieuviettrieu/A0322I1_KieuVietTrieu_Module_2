package thi_module_2.services;

import thi_module_2.models.SanPham;
import thi_module_2.models.SanPhamNhapKhau;
import thi_module_2.models.SanPhamXuatKhau;
import thi_module_2.utils.WriteReadFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServicesSanPham {
    private Scanner scanner=new Scanner(System.in);
    public ArrayList<SanPhamNhapKhau> arrayNhapKhau=new ArrayList<>();
    public ArrayList<SanPhamXuatKhau> arrayXuatKhau=new ArrayList<>();

    public void addNew()
    {
        System.out.println("1.Thêm sản phẩm nhập khẩu");
        System.out.println("2.Thêm sản phẩm xuất khẩu");
        System.out.println("Thoát");
        String goTo=scanner.nextLine();
        switch (goTo)
        {
            case "1":
                addNewNhapKhau();
                WriteReadFile.writeToFile(SanPhamNhapKhau.FILE,arrayNhapKhau);
                System.out.println("Thêm thành công");
                break;
            case "2":
                addNewXuatKhau();
                WriteReadFile.writeToFiles(SanPhamXuatKhau.FILE,arrayXuatKhau);
                System.out.println("Thêm thành công");
                break;
            default:
                return;
        }
    }

    public void addNewNhapKhau()
    {
        System.out.println("Thêm mới sảm phẩm nhập khẩu");
        System.out.print("Mã sản phẩm: ");
        String maSanPham=scanner.nextLine();
        System.out.print("Tên sản phẩm: ");
        String teSanPham=scanner.nextLine();
        System.out.print("Giá bán: ");
        double giaBan=Double.parseDouble(scanner.nextLine());
        System.out.print("Số lượng: ");
        int soLuong=Integer.parseInt(scanner.nextLine());
        System.out.print("Nhà sản xuất: ");
        String nhaSanXuat=scanner.nextLine();

        System.out.print("Giá nhập khẩu: ");
        double giaNhapKhau=Double.parseDouble(scanner.nextLine());
        System.out.print("Tỉnh thành nhập: ");
        String tinhThanhNhap=scanner.nextLine();
        System.out.print("Thuế nhập khẩu: ");
        double thueNhapKhau=Double.parseDouble(scanner.nextLine());
        SanPhamNhapKhau sanPhamNhapKhau=new SanPhamNhapKhau(maSanPham,teSanPham,giaBan,soLuong,nhaSanXuat,giaNhapKhau,
                tinhThanhNhap,thueNhapKhau);
        arrayNhapKhau.add(sanPhamNhapKhau);

    }

    public void addNewXuatKhau()
    {
        System.out.println("Thêm mới sảm phẩm xuất khẩu");
        System.out.print("Mã sản phẩm: ");
        String maSanPham=scanner.nextLine();
        System.out.print("Tên sản phẩm: ");
        String teSanPham=scanner.nextLine();
        System.out.print("Giá bán: ");
        double giaBan=Double.parseDouble(scanner.nextLine());
        System.out.print("Số lượng: ");
        int soLuong=Integer.parseInt(scanner.nextLine());
        System.out.print("Nhà sản xuất: ");
        String nhaSanXuat=scanner.nextLine();

        System.out.print("Giá xuất khẩu: ");
        double giaXuatKhau=Double.parseDouble(scanner.nextLine());
        System.out.print("Quốc gia nhập sản phẩm: ");
        String quocGiaNhap=scanner.nextLine();

        SanPhamXuatKhau sanPhamXuatKhau=new SanPhamXuatKhau(maSanPham,teSanPham,giaBan,soLuong,nhaSanXuat,giaXuatKhau,quocGiaNhap);

        arrayXuatKhau.add(sanPhamXuatKhau);

    }

    public void disPlay()
    {
        if(arrayNhapKhau.size()==0 && arrayXuatKhau.size()==0)
        {
            System.out.println("Danh sách sản phẩm trống!");
        }
        else
        {
            System.out.println("Danh sách sản phẩm: ");
            for (SanPhamXuatKhau sanPhamXuatKhau:arrayXuatKhau)
            {
                System.out.println(sanPhamXuatKhau.toString());
            }

            for (SanPhamNhapKhau sanPhamNhapKhau:arrayNhapKhau)
            {
                System.out.println(sanPhamNhapKhau.toString());
            }
        }

    }



    public void search()
    {
        System.out.println("1.Tìm kiếm theo mã sản phẩm");
        System.out.println("2.Tìm kiếm theo tên sản phẩm");
        System.out.println("Thoát");
        String goTo=scanner.nextLine();
        switch (goTo)
        {
            case "1":
                System.out.print("Nhập mã sản phẩm: ");
                String maSanPham=scanner.nextLine();
                searchMaSanPham(maSanPham);
                break;
            case "2":
                System.out.print("Nhập tên sản phẩm: ");
                String tenSanPham=scanner.nextLine();
                searchTenSanPham(tenSanPham);
                break;
            default:
                return;
        }
    }

    private void searchMaSanPham(String maSanPham)
    {
        System.out.println("Sản phầm cần tìm: ");
        for (SanPhamXuatKhau sanPhamXuatKhau:arrayXuatKhau)
        {
            if(sanPhamXuatKhau.getMaSanPham().equalsIgnoreCase(maSanPham) || sanPhamXuatKhau.getMaSanPham().indexOf(maSanPham)!=-1)
            {
                System.out.println(sanPhamXuatKhau.toString());
            }
        }

        for (SanPhamNhapKhau sanPhamNhapKhau:arrayNhapKhau)
        {
            if(sanPhamNhapKhau.getMaSanPham().equalsIgnoreCase(maSanPham) || sanPhamNhapKhau.getMaSanPham().indexOf(maSanPham)!=-1) {
                System.out.println(sanPhamNhapKhau.toString());
            }
        }

    }

    private void searchTenSanPham(String tenSanPham)
    {
        int check=0;
        System.out.println("Sản phầm cần tìm: ");
        for (SanPhamXuatKhau sanPhamXuatKhau:arrayXuatKhau)
        {
            if(sanPhamXuatKhau.getTenSanPham().equalsIgnoreCase(tenSanPham) || sanPhamXuatKhau.getMaSanPham().indexOf(tenSanPham)!=-1)
            {
                System.out.println(sanPhamXuatKhau.toString());
                check++;
            }
        }

        for (SanPhamNhapKhau sanPhamNhapKhau:arrayNhapKhau)
        {
            if(sanPhamNhapKhau.getTenSanPham().equalsIgnoreCase(tenSanPham) || sanPhamNhapKhau.getTenSanPham().indexOf(tenSanPham)!=-1) {
                System.out.println(sanPhamNhapKhau.toString());
                check++;
            }
        }
        if(check==0)
        {
            System.out.println("Không tìm thấy! ");
        }

    }

    public void delete()
    {
        System.out.println("Xóa sản phẩm");
        System.out.print("Nhập mã sản phẩm:");
        String maSanPham=scanner.nextLine();
        for (SanPhamXuatKhau sanPhamXuatKhau:arrayXuatKhau)
        {
            if(sanPhamXuatKhau.getMaSanPham().equals(maSanPham))
            {
                while (true)
                {
                    System.out.println("1.Yes  2.No");
                    System.out.print("Chọn: ");
                    String goTo=scanner.nextLine();
                    if(goTo.equals("1"))
                    {
                        arrayXuatKhau.remove(sanPhamXuatKhau);
                        WriteReadFile.writeToFiles(SanPhamXuatKhau.FILE,arrayXuatKhau);
                        System.out.println("Xóa thành công!");
                        return;
                    }
                    if(goTo.equals("2"))
                    {
                        return;
                    }
                }
            }
        }

        for (SanPhamNhapKhau sanPhamNhapKhau:arrayNhapKhau)
        {
            if(sanPhamNhapKhau.getMaSanPham().equals(maSanPham)) {
                while (true)
                {
                    System.out.println("1.Yes  2.No");
                    System.out.print("Chọn: ");
                    String goTo=scanner.nextLine();
                    if(goTo.equals("1"))
                    {
                        arrayNhapKhau.remove(sanPhamNhapKhau);
                        WriteReadFile.writeToFile(SanPhamNhapKhau.FILE,arrayNhapKhau);
                        System.out.println("Xóa thành công!");
                        return;
                    }
                    if(goTo.equals("2"))
                    {
                        return;
                    }
                }
            }
        }
    }
}
