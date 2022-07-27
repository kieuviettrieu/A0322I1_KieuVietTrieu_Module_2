package CaseStudy.services.Impl;

import CaseStudy.models.person.Customer;
import CaseStudy.utils.WriteReadFile;

import java.util.LinkedHashMap;
import java.util.Map;

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
                System.out.println("ID:"+entry.getKey()+", Name:"+customer.getFullName()+", Voucher: "+entry.getValue()+"%");
            }
        }
        else
        {
            System.out.println("Empty list!");
        }
    }

    public static void addToVoucher(int maKhachHang)
    {
        Integer voucher;
        if(CustomerServiceImpl.getSize()<=AMOUNT_VOUCHER_50)
        {
            mapVoucher.put(maKhachHang,VOUCHER_50);
            voucher=VOUCHER_50;
        }
        else
            if(CustomerServiceImpl.getSize()<=(AMOUNT_VOUCHER_20+AMOUNT_VOUCHER_50))
            {
                mapVoucher.put(maKhachHang,VOUCHER_20);
                voucher=VOUCHER_20;
            }
            else
            {
                voucher=10;
                mapVoucher.put(maKhachHang,10);
            }
        writeToVoucher(WriteReadFile.FILE_VOUCHER,maKhachHang,voucher);
    }

    public static void writeToVoucher(String path,Integer maKhachHang,Integer voucher)
    {
        WriteReadFile.writeToFile(path,maKhachHang,voucher);
    }

    public static void readToVoucher(String path)
    {
        WriteReadFile.readDataFromVoucher(path,mapVoucher);
    }
}
