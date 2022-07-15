package CaseStudy.services.Impl;

import CaseStudy.models.Customer;
import CaseStudy.services.exception.WriteReadFile;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class VoucherServices {
    private static final int AMOUNT_VOUCHER_50=10;
    private static final int AMOUNT_VOUCHER_20=20;
    private static final int VOUCHER_50=50;
    private static final int VOUCHER_20=20;
    private static CustomerServiceImpl customerService=new CustomerServiceImpl();
    private static Map<Integer,Integer> mapVoucher=new LinkedHashMap<>();

    public static int getVoucher(int makhachHang)
    {
        if(mapVoucher.get(makhachHang)==null)
            return 10;
        return mapVoucher.get(makhachHang);
    }

    public static void disPlay()
    {
        System.out.println("List Voucher: ");
        if(mapVoucher.size()!=0)
        {
            for (Map.Entry<Integer,Integer> entry:mapVoucher.entrySet())
            {
                Customer customer=customerService.getCustomer(entry.getKey());
                System.out.println("ID:"+entry.getKey()+", Name:"+customer.getHoTen()+", Voucher: "+entry.getValue()+"%");
            }
        }
        else
        {
            System.out.println("Empty list!");
        }
    }

    public static void addToVoucher(int maKhachHang)
    {
        if(CustomerServiceImpl.getSize()<=AMOUNT_VOUCHER_50)
        {
            mapVoucher.put(maKhachHang,VOUCHER_50);
        }
        else
            if(CustomerServiceImpl.getSize()<=(AMOUNT_VOUCHER_20+AMOUNT_VOUCHER_50))
            {
                mapVoucher.put(maKhachHang,VOUCHER_20);
            }
            else
            {
                mapVoucher.put(maKhachHang,10);
            }
        writeToVoucher("voucher.cvs");
    }

    public static void writeToVoucher(String path)
    {
        WriteReadFile.writeToFile(path,mapVoucher);
    }

    public static void readToVoucher(String path)
    {
        WriteReadFile.readDataFromVoucher(path,mapVoucher);
    }
}
