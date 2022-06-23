package ss12_collection_framework.baitap;

public class TestLinlListProduct {
    public static void main(String[] args) {
        ProductLinkedList productLinkedList=new ProductLinkedList();
        SanPham sanPham1=new SanPham("1001","Tivi",12000);
        SanPham sanPham2=new SanPham("1002","Tủ lạnh",5000);
        SanPham sanPham3=new SanPham("1003","Máy giặt",4500);
        SanPham sanPham4=new SanPham("1004","Bàn là",1200);
        SanPham sanPham5=new SanPham("1005","Máy lạnh",20000);

        productLinkedList.addProduct(sanPham1);
        productLinkedList.addProduct(sanPham2);
        productLinkedList.addProduct(sanPham3);
        productLinkedList.addProduct(sanPham4);
        productLinkedList.addProduct(sanPham5);
        System.out.println(productLinkedList.toString());
        System.out.println("Sắp xếp theo giá:");
        productLinkedList.sortProduct();
        System.out.println(productLinkedList);
        System.out.println("Xóa theo id:");
        System.out.println("Xóa id: 1003");
        String idRemove="1003";
        if(productLinkedList.removeProduct(idRemove))
        {
            System.out.println("Xóa thành công!");
        }
        else
        {
            System.out.println("Xóa không thành công!");
        }
        System.out.println(productLinkedList);

        String timTheoTen="tivi";
        System.out.println("Tìm kiếm sản phẩm theo tên: "+timTheoTen);
        System.out.println(productLinkedList.searchProduct(timTheoTen));

        SanPham editSanPham=new SanPham("1001","Điện thoại",35000);
        System.out.println("Làm mới id: 1001");
        productLinkedList.setProduct(editSanPham);
        System.out.println(productLinkedList);
    }
}
