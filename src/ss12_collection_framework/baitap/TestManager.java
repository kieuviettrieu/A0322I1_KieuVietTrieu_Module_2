package ss12_collection_framework.baitap;

public class TestManager {
    public static void main(String[] args) {
        ProductManager productManager=new ProductManager();
        productManager.addProduct(new SanPham("1001","Tivi",12000));
        productManager.addProduct(new SanPham("1002","Tủ lạnh",5000));
        productManager.addProduct(new SanPham("1003","Máy giặt",4500));
        productManager.addProduct(new SanPham("1004","Bàn là",1200));
        productManager.addProduct(new SanPham("1005","Máy lạnh",20000));
        System.out.println(productManager);
        System.out.println("Sắp xếp theo giá:");
        productManager.sortProduct();
        System.out.println(productManager);
        System.out.println("Xóa theo id:");
        System.out.println("Xóa id: 1003");
        String idRemove="1003";
        if(productManager.removeProduct(idRemove))
        {
            System.out.println("Xóa thành công!");
        }
        else
        {
            System.out.println("Xóa không thành công!");
        }
        System.out.println(productManager);

        String timTheoTen="tivi";
        System.out.println("Tìm kiếm sản phẩm theo tên: "+timTheoTen);
        System.out.println(productManager.searchProduct(timTheoTen));

        SanPham editSanPham=new SanPham("1001","Điện thoại",35000);
        System.out.println("Làm mới id: 1001");
        productManager.setProduct(editSanPham);
        System.out.println(productManager);
    }
}
