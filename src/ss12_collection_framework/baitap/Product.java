package ss12_collection_framework.baitap;

public abstract class Product {
    public abstract void addProduct(SanPham sanPham);
    public abstract boolean setProduct(SanPham sanPham);
    public abstract boolean removeProduct(String idSanPham);
    public abstract SanPham searchProduct(String tenSanPham);
    public abstract void sortProduct();
}
