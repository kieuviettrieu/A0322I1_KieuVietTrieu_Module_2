package ss12_collection_framework.baitap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProductManager extends Product{
    private ArrayList<SanPham> arrayProduct;

    public ProductManager() {
        arrayProduct=new ArrayList<>();
    }

    @Override
    public void addProduct(SanPham sanPham) {
        arrayProduct.add(sanPham);
    }

    @Override
    public boolean setProduct(SanPham sanPham) {
        for (int i=0; i<arrayProduct.size(); i++)
        {
            if (arrayProduct.get(i).getIdSanPham().equals(sanPham.getIdSanPham()))
            {
                arrayProduct.set(i,sanPham);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeProduct(String idSanPham) {
        for (SanPham sanPham:arrayProduct)
        {
            if (sanPham.getIdSanPham().equals(idSanPham))
            {
                arrayProduct.remove(sanPham);
                return true;
            }
        }
        return false;
    }

    @Override
    public SanPham searchProduct(String tenSanPham) {
        for (SanPham sanPham: arrayProduct)
        {
            if(sanPham.getTenSanPham().equalsIgnoreCase(tenSanPham))
            {
                return sanPham;
            }
        }

        return null;
    }

    @Override
    public void sortProduct() {
        Collections.sort(arrayProduct, new Comparator<SanPham>() {
            @Override
            public int compare(SanPham o1, SanPham o2) {
                if(o1.getGiaSanPham()>o2.getGiaSanPham())
                    return 1;
                if(o1.getGiaSanPham()==o2.getGiaSanPham())
                    return 0;
                return -1;
            }
        });
    }

    @Override
    public String toString() {
        String str="";
        for (SanPham sanPham:arrayProduct)
        {
            str+=sanPham.toString()+ '\n';
        }

        return str;
    }

}
