package ss12_collection_framework.baitap;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ProductLinkedList extends Product{
    private LinkedList<SanPham> listSanPham;

    public ProductLinkedList() {
        listSanPham=new LinkedList<>();
    }

    @Override
    public void addProduct(SanPham sanPham) {
        listSanPham.add(sanPham);
    }

    @Override
    public boolean setProduct(SanPham sanPham) {
        for (int i=0; i<listSanPham.size(); i++)
        {
            if(listSanPham.get(i).getIdSanPham().equals(sanPham.getIdSanPham()))
            {
                listSanPham.set(i,sanPham);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeProduct(String idSanPham) {
        for (SanPham sanPham:listSanPham)
        {
            if (sanPham.getIdSanPham().equals(idSanPham))
            {
                listSanPham.remove(sanPham);
                return true;
            }
        }
        return false;
    }

    @Override
    public SanPham searchProduct(String tenSanPham) {
        for (SanPham sanPham: listSanPham)
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
        Collections.sort(listSanPham, new Comparator<SanPham>() {
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
        for (SanPham sanPham:listSanPham)
        {
            str+=sanPham.toString()+ '\n';
        }

        return str;
    }
}
